package au.edu.monash.ges.suews;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.im4java.core.CompositeCmd;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.jgnuplot.Splot;

public class ENVICommon
{

	String ediFileType = ".EDI";
	String edtFileType = ".EDT";
	String cfFileType = ".cf";
	String inFileType = ".in";

	public static final int z_Topo = 1;
	public static final int T_Surface_K = 2;
	public static final int T_Surface_Diff = 3;
	public static final int T_Surface_Change = 4;
	public static final int Q_Surface = 5;
	public static final int uv_above_Surface = 6;
	public static final int Sensible_heat_flux = 7;
	public static final int Exchange_Coeff_Heat = 8;
	public static final int Latent_heat_flux = 9;
	public static final int Soil_heat_Flux = 10;
	public static final int Sw_Direct_Radiation = 11;
	public static final int Sw_Diffuse_Radiation = 12;
	public static final int Lambert_Factor = 13;
	public static final int Longwave_Radiation_Budget = 14;
	public static final int Longwave_Rad_from_vegetation = 15;
	public static final int Longwave_Rad_from_environment = 16;
	public static final int Water_Flux = 17;
	public static final int Sky_View_Faktor = 18;
	public static final int Building_Height = 19;
	public static final int Surface_Albedo = 20;
	public static final int Deposition_Speed = 21;
	public static final int Mass_Deposed = 22;

	public static final String RUN_DATE = "run_date";
	public static final String RUN_DESC = "run_desc";
	public static final String RUN_NAME = "run_name";
	public static final String ENVI_VERSION = "envi_version";
	public static final String ENVI_VERSION3 = "3";
	public static final String ENVI_VERSION4 = "4";
	public static final String DATA_DIR = "data_dir";

	public static final String RECEPTOR_ID = "receptor_id";
	public static final String RECEPTOR_X = "x";
	public static final String RECEPTOR_Y = "y";
	public static final String RECEPTOR_FILENAME = "filename";
	public static final String RECEPTOR_PATH = "path";
	
	public static int DEFAULT_ROUNDING_PRECISION = 2;

	/*
	 *
	 * <td>1</td><td>z Topo (m)</td></tr> <td>2</td><td>T Surface (K)</td></tr>
	 * <td>3</td><td>T Surface Diff. (K)</td></tr> <td>4</td><td>T Surface
	 * Change (K/h)</td></tr> <td>5</td><td>q Surface (g/kg)</td></tr>
	 * <td>6</td><td>uv above Surface (m/s)</td></tr> <td>7</td><td>Sensible
	 * heat flux (W/m&sup2;)</td></tr> <td>8</td><td>Exchange Coeff. Heat
	 * (m&sup2;/s)</td></tr> <td>9</td><td>Latent heat flux
	 * (W/m&sup2;)</td></tr> <td>10</td><td>Soil heat Flux (W/m&sup2;)</td></tr>
	 * <td>11</td><td>Sw Direct Radiation (W/m&sup2;)</td></tr>
	 * <td>12</td><td>Sw Diffuse Radiation (W/m&sup2;)</td></tr>
	 * <td>13</td><td>Lambert Factor</td></tr> <td>14</td><td>Longwave Radiation
	 * Budget (W/m&sup2;)</td></tr> <td>15</td><td>Longwave Rad. from vegetation
	 * (W/m&sup2;)</td></tr> <td>16</td><td>Longwave Rad. from environment
	 * (W/m&sup2;)</td></tr> <td>17</td><td>Water Flux (g/(m&sup2;s))</td></tr>
	 * <td>18</td><td>Sky-View-Faktor</td></tr> <td>19</td><td>Building Height
	 * (m)</td></tr> <td>20</td><td>Surface Albedo</td></tr>
	 * <td>21</td><td>Deposition Speed (mm/s)</td></tr> <td>22</td><td>Mass
	 * Deposed (&micro;g/m&sup2;)</td></tr>
	 */

	public void writeFile(String text, String filename)
	{
		FileOutputStream out; // declare a file output object
		PrintStream p; // declare a print stream object

		try
		{
			out = new FileOutputStream(filename);
			p = new PrintStream(out);
			p.println(text);
			p.close();
		} catch (Exception e)
		{
			System.err.println("Error writing to file");
		}

	}
	
	public int getYVWQuarterForMonth(int month)
	{
		int quarter = 0;
		
		switch (month) {
		  case 1:
			  quarter = 0;
		    break;
		  case 2:	
			 quarter = 0;
		    break;
		  case 3:		   
			  quarter = 0;
		    break;
		  case 4:		   
			  quarter = 1;
		    break;
		  case 5:		   
			  quarter = 1;
		    break;
		  case 6:		   
			  quarter = 1;
		    break;
		  case 7:		   
			  quarter = 2;
		    break;
		  case 8:		   
			  quarter = 2;
		    break;
		  case 9:		   
			  quarter = 2;
		    break;
		  case 10:		   
			  quarter = 3;
		    break;
		  case 11:		   
			  quarter = 3;
		    break;
		  case 12:		   
			  quarter = 3;
		    break;		    
		  
		  default: 
		  
		}
		
		return quarter;
	}
	
	public String getYVWKeyForDate(String year, String month, int day)
	{
		String key = day + "-" + month + "-" + year;
		return key;
	}
	
	public String getMonthForMonthInt(int month)
	{
		String monthStr = "";
		switch (month) {
		  case 1:
			  monthStr = "Jan";
		    break;
		  case 2:	
			  monthStr = "Feb";
		    break;
		  case 3:		   
			  monthStr = "Mar";
		    break;
		  case 4:		   
			  monthStr = "Apr";
		    break;
		  case 5:		   
			  monthStr = "May";
		    break;
		  case 6:		   
			  monthStr = "Jun";
		    break;
		  case 7:		   
			  monthStr = "Jul";
		    break;
		  case 8:		   
			  monthStr = "Aug";
		    break;		    
		  case 9:		   
			  monthStr = "Sep";
		    break;
		  case 10:		   
			  monthStr = "Oct";
		    break;
		  case 11:		   
			  monthStr = "Nov";
		    break;
		  case 12:		   
			  monthStr = "Dec";
		    break;		    
		    
		  default: 
		  
		}
		
		return monthStr;
	}
	
	public String getYVWKeyForDate(int year, int month, int day)
	{
		
		String monthStr = getMonthForMonthInt(month);
		String yearStr = new Integer(year).toString();
		if (yearStr.length() == 4)
		{
			yearStr = yearStr.substring(2);
		}
		
		String key = day + "-" + monthStr + "-" + yearStr;
		return key;
	}	
	
	public String getHourFromFraction(String fraction)
	{
		double fractionDouble = new Double(fraction).doubleValue();
		double hour = fractionDouble * 24;
		long roundHour = Math.round(hour);

//		long hourLong = (long) (hour % 1);
		
		return new Long(roundHour).toString();
		

	}
	
	public int getWeekOfYearFromDayAndMonth(String yearStr, String dayStr, String monthStr)
	{
		int month = new Integer(monthStr).intValue() - 1;
		int day = new Integer(dayStr).intValue();
		int year = new Integer(yearStr).intValue();	

	    return getWeekOfYearFromDayAndMonth(year, day, month);
	}	
	
	public int getWeekOfYearFromDayAndMonth(int year, int day, int month)
	{

	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.MONTH, month);
	    calendar.set(Calendar.DAY_OF_MONTH, day);	    
	    //calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
	    calendar.set(Calendar.YEAR, year);	    
	    
	    int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

	    //System.out.println("Day of year " + dayOfYear + " = " + calendar.getTime());
	    return weekOfYear;
	}		
	
	public int getDayOfYearFromDayAndMonth(String yearStr, String dayStr, String monthStr)
	{
		int month = new Integer(monthStr).intValue() - 1;
		int day = new Integer(dayStr).intValue();
		int year = new Integer(yearStr).intValue();	

	    return getDayOfYearFromDayAndMonth(year, day, month);
	}		
	
	public int getDayOfYearFromDayAndMonth(int year, int day, int month)
	{

	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.MONTH, month);
	    calendar.set(Calendar.DAY_OF_MONTH, day);	    
	    //calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
	    calendar.set(Calendar.YEAR, year);	    
	    
	    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

	    //System.out.println("Day of year " + dayOfYear + " = " + calendar.getTime());
	    return dayOfYear;
	}	

	public int getDayOfMonthFromDayOfYear(int year, int dayOfYear)
	{

	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
	    calendar.set(Calendar.YEAR, year);
	    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

	    //System.out.println("Day of year " + dayOfYear + " = " + calendar.getTime());
	    return dayOfMonth;
	}

	public int getMonthFromDayOfYear(int year, int dayOfYear)
	{

	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
	    calendar.set(Calendar.YEAR, year);
	    int month = calendar.get(Calendar.MONTH) + 1;

	    //System.out.println("dayOfYear=" + dayOfYear + " month=" + month);
	    
	    //System.out.println("Day of year " + dayOfYear + " = " + calendar.getTime());
	    return month;
	}
	
	//20040011500 to 2004
	public int getYearFromTimecode(String timecode)
	{
		int year = 0;
		
		String yearStr = timecode.substring(0, 4);
		try
		{
			year = new Integer(yearStr).intValue();	
		}
		catch (NumberFormatException e)
		{
			year = 0;
		}		
		
		return year;
	}
	
	//20040011500 to month
	public int getMonthFromTimecode(String timecode)
	{
		int year = getYearFromTimecode(timecode);
		int month = 0;
		int dayOfYear = 0;
		
		String dayOfYearStr = timecode.substring(4, 7);
		try
		{
			dayOfYear = new Integer(dayOfYearStr).intValue();	
		}
		catch (NumberFormatException e)
		{
			month = 0;
		}	
		month = getMonthFromDayOfYear(year, dayOfYear);
		
		return month;
	}	
	
	//20040011500 to day
	public int getDayOfMonthFromTimecode(String timecode)
	{
		int year = getYearFromTimecode(timecode);
		int dayOfMonth = 0;
		int dayOfYear = 0;
		
		String dayOfYearStr = timecode.substring(4, 7);
		try
		{
			dayOfYear = new Integer(dayOfYearStr).intValue();	
		}
		catch (NumberFormatException e)
		{
			dayOfMonth = 0;
		}	
		dayOfMonth = getDayOfMonthFromDayOfYear(year, dayOfYear);
		
		return dayOfMonth;
	}	
	
	//20040011500 to 15
	public int getHourFromTimecode(String timecode)
	{		
		int time;		
		String timeStr = timecode.substring(7, 9);
		try
		{
			time = new Integer(timeStr).intValue();	
		}
		catch (NumberFormatException e)
		{
			time = 0;
		}			
		return time;
	}
	
	double roundTwoDecimals(double d) 
	{
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
	}
	
	double roundToDecimals(double d, int c) 
	{
		int temp=(int)((d*Math.pow(10,c)));
		return (((double)temp)/Math.pow(10,c));
	}

	public ArrayList<Double> energyBalance(String net, String QG, String QH, String QE, boolean fake)
	{
		ArrayList<Double> returnValues = new ArrayList<Double>();

		if (net == null || QG== null || QH== null || QE== null)
		{
			returnValues.add(0.0);
			returnValues.add(0.0);
			returnValues.add(0.0);
			return returnValues;
		}
		try
		{
			double netRadiation = new Double(net).doubleValue();
			double soilHeatFlux = new Double(QG).doubleValue();
			double sensibleHeatFlux = new Double(QH).doubleValue();
			double latentHeatFlux = new Double(QE).doubleValue();
		}
		catch(NumberFormatException e)
		{
			//e.printStackTrace();
			returnValues.add(0.0);
			returnValues.add(0.0);
			returnValues.add(0.0);
			return returnValues;

		}

		double netRadiation = new Double(net).doubleValue();
		double soilHeatFlux = new Double(QG).doubleValue();
		double availableEnergy = netRadiation - soilHeatFlux;
		double sensibleHeatFlux = new Double(QH).doubleValue();
		double latentHeatFlux = new Double(QE).doubleValue();
		double dailyEnergyBalance = netRadiation - soilHeatFlux - sensibleHeatFlux - latentHeatFlux;
		double Rn_G_H_LE = netRadiation - soilHeatFlux - sensibleHeatFlux - latentHeatFlux;

		returnValues.add(availableEnergy);
		returnValues.add(dailyEnergyBalance);
		returnValues.add(Rn_G_H_LE);

		return returnValues;

	}

	public ArrayList<Double> energyBalance(String kdown, String kup, String ldown, String lup, String QG, String QH, String QE, String temp)
	{
		ArrayList<Double> returnValues = new ArrayList<Double>();
		double surfaceAlbedo = 0.15;

		//first try and see if you have to calculate kup and lup
		if (kup != null && lup != null && kup.equals("?") && lup.equals("?") && temp != null)
		{
			try
			{
				double swIn = new Double(kdown).doubleValue();
				double tSurfaceK = new Double(temp).doubleValue() + 273;
				double lwIn = new Double(ldown).doubleValue();
			}
			catch(NumberFormatException e)
			{
				//e.printStackTrace();
				returnValues.add(0.0);
				returnValues.add(0.0);
				returnValues.add(0.0);
				return returnValues;

			}

			double lwIn = new Double(ldown).doubleValue();
			double swIn = new Double(kdown).doubleValue();
			double tSurfaceK = new Double(temp).doubleValue() + 273;

			double swOut = (surfaceAlbedo) * (swIn);
			double lwOut = 0.0000000567 * Math.pow(tSurfaceK, 4);


			double netRadiation = (swIn - swOut) + (lwIn - lwOut);
			double soilHeatFlux = new Double(QG).doubleValue();
			double availableEnergy = netRadiation - soilHeatFlux;
			double sensibleHeatFlux = new Double(QH).doubleValue();
			double latentHeatFlux = new Double(QE).doubleValue();
			double dailyEnergyBalance = netRadiation - soilHeatFlux - sensibleHeatFlux - latentHeatFlux;
			double Rn_G_H_LE = netRadiation - soilHeatFlux - sensibleHeatFlux - latentHeatFlux;

			returnValues.add(availableEnergy);
			returnValues.add(dailyEnergyBalance);
			returnValues.add(Rn_G_H_LE);

			return returnValues;
		}

		//ok, then calculate using kup,down and lup,down
		if (kdown == null || kup == null || ldown== null || lup== null || QG== null || QH== null || QE== null)
		{
			returnValues.add(0.0);
			returnValues.add(0.0);
			returnValues.add(0.0);
			return returnValues;
		}

		try
		{
			double swIn = new Double(kdown).doubleValue();
			double swOut = new Double(kup).doubleValue();
			double lwIn = new Double(ldown).doubleValue();
			double lwOut = new Double(lup).doubleValue();
			double soilHeatFlux = new Double(QG).doubleValue();
			double sensibleHeatFlux = new Double(QH).doubleValue();
			double latentHeatFlux = new Double(QE).doubleValue();
		}
		catch(NumberFormatException e)
		{
			//e.printStackTrace();
			returnValues.add(0.0);
			returnValues.add(0.0);
			returnValues.add(0.0);
			return returnValues;

		}
		double swIn = new Double(kdown).doubleValue();
		double swOut = new Double(kup).doubleValue();
		double lwIn = new Double(ldown).doubleValue();
		double lwOut = new Double(lup).doubleValue();
		double netRadiation = (swIn - swOut) + (lwIn - lwOut);
		double soilHeatFlux = new Double(QG).doubleValue();
		double availableEnergy = netRadiation - soilHeatFlux;
		double sensibleHeatFlux = new Double(QH).doubleValue();
		double latentHeatFlux = new Double(QE).doubleValue();
		double dailyEnergyBalance = netRadiation - soilHeatFlux - sensibleHeatFlux - latentHeatFlux;
		double Rn_G_H_LE = netRadiation - soilHeatFlux - sensibleHeatFlux - latentHeatFlux;

		returnValues.add(availableEnergy);
		returnValues.add(dailyEnergyBalance);
		returnValues.add(Rn_G_H_LE);

		return returnValues;


//		double swIn = swDirectRadiation + swDiffuseRadiation;
//		double swOut = (surfaceAlbedo) * (swIn);
//		//double lwIn = longwaveRadFromEnvironment;
//		double lwIn = rs.getDouble(REC_QLW_SKY);

//		double lwOut = 0.0000000567 * Math.pow(tSurfaceK, 4);
//		double netRadiation = (swIn - swOut) + (lwIn - lwOut);
//		double availableEnergy = netRadiation - soilHeatFlux;

//		double dailyEnergyBalance = netRadiation - soilHeatFlux - sensibleHeatFlux - latentHeatFlux;

		// Rn-G-H-LE

	}
	
	public String convertTimesToTimeDecimal(String time)
	{	
		//1330 to 13.5
		String hour = time.substring(0, 2);
		String minute = time.substring(2, 4);
		if (minute.equals("00"))
		{
			minute = "";
		}
		else
		{
			minute = ".5";
		}
		
		return hour + minute;
	}
	
	public String convertTimeToTimecode(String timecode)
	{
		// 20040011230 to 1.5416666667
		//String year = timecode.substring(0, 4);
		String day = timecode.substring(4, 7);
		String time = timecode.substring(7, 11);
		
		String convertTime = convertTimesToTimeDecimal(time);
		double convertTimeDouble = new Double(convertTime).doubleValue();
		double timecodeFraction = convertTimeDouble / 24;
		return day + timecodeFraction;
	}

	public String padLeft(String str, int size, char padChar)
	{
		//StringBuffer padded = new StringBuffer(str);
		String padded = str;
		while (padded.length() < size)
		{
			padded = padChar + padded;
			//padded.append(padChar);
		}
		//return padded.toString();
		return padded;
	}

	public String padRight(String str, int size, char padChar)
	{
		StringBuffer padded = new StringBuffer(str);
		//String padded = str;
		while (padded.length() < size)
		{
			//padded = padChar + padded;
			padded.append(padChar);
		}
		return padded.toString();
		//return padded;
	}


//	public static String padLeft(String s, int n)
//	{
//		return String.format("%0" + n,s);
//	    //return String.format("%1$#" + n + "s", s);
//	}

//	public static String padRight(String s, int n)
//	{
//	     return String.format("%1$-" + n + "s", s);
//	}
	
	public void copyFileOnFilesystem(String sourceStr, String destinationStr)
	{
		// The source file name to be copied.
        File source = new File("january.doc");
        
        // The target file name to which the source file will be copied.
        File target = new File("january-backup.doc");
        
        // A temporary folder where we are gonna copy the source file to.
        // Here we use the temporary folder of the OS, which can be obtained
        // using java.io.tmpdir property.
        File targetDir = new File(System.getProperty("java.io.tmpdir"));
        
        try
        {
            // Using FileUtils.copyFile() method to copy a file.
            System.out.println("Copying " + source + " file to " + target);
            FileUtils.copyFile(source, target);
            
            // To copy a file to a specified folder we can use the
            // FileUtils.copyFileToDirectory() method.
            System.out.println("Copying " + source + " file to " + targetDir);
            FileUtils.copyFileToDirectory(source, targetDir);
        } catch (IOException e)
        {
            // Errors will be reported here if any error occures during copying
            // the file
            e.printStackTrace();
        }
	}
	
	public void createSymlink(String source, String target)
	{
		Runtime rt=Runtime.getRuntime();
		Process result=null;
		String exe=new String("ln"+" -s "+source+" "+target);
		try
		{
			result=rt.exec(exe);
		} catch (IOException e)
		{			
			e.printStackTrace();
		}
	}
	
	public void runR(String runDirectory, String rScript)
	{
		String rFilename = "run.r";
		String scriptFilename = "run.sh";
		String scriptStr = "cd " + runDirectory + '\n' + "/usr/bin/R CMD BATCH " + rFilename + "\n";
		writeFile(scriptStr, runDirectory + scriptFilename);
		writeFile(rScript, runDirectory + rFilename);
		
		
		Runtime rt=Runtime.getRuntime();		
		Process result=null;
		//String exe=new String("wine " + exeStr);
		//String[] exe={new String("/bin/sh " + exeStr + "exe.sh"),exeStr};
		String exe=new String("/bin/sh " + runDirectory + scriptFilename);
		try
		{
			
			result=rt.exec(exe);
			result.waitFor();
			
			String s;
			BufferedReader stdInput = new BufferedReader(new 
		             InputStreamReader(result.getInputStream()));

		    BufferedReader stdError = new BufferedReader(new 
		             InputStreamReader(result.getErrorStream()));

		        // read the output from the command
		    System.out.println("Here is the standard output of the command:\n");
		    while ((s = stdInput.readLine()) != null) 
		    {
		            System.out.println(s);
		    }

		    // read any errors from the attempted command
		    System.out.println("Here is the standard error of the command (if any):\n");
		    while ((s = stdError.readLine()) != null) 
		    {
		            System.out.println(s);
		    }
			
			
			
			
			//System.out.println(result.getOutputStream());
		} catch (Exception e)
		{			
			e.printStackTrace();
		}
	}	
	
	public void runWineExe(String runDirectory)
	{
		String filename = "run.sh";
		String scriptStr = "cd " + runDirectory + '\n' + "wine " + "SUEWS_V1_1.exe" + "\n";
		writeFile(scriptStr, runDirectory + filename);
		
		
		Runtime rt=Runtime.getRuntime();		
		Process result=null;
		//String exe=new String("wine " + exeStr);
		//String[] exe={new String("/bin/sh " + exeStr + "exe.sh"),exeStr};
		String exe=new String("/bin/sh " + runDirectory + "run.sh");
		try
		{
			
			result=rt.exec(exe);
			result.waitFor();
			
			String s;
			BufferedReader stdInput = new BufferedReader(new 
		             InputStreamReader(result.getInputStream()));

		    BufferedReader stdError = new BufferedReader(new 
		             InputStreamReader(result.getErrorStream()));

		        // read the output from the command
		    System.out.println("Here is the standard output of the command:\n");
		    while ((s = stdInput.readLine()) != null) 
		    {
		            System.out.println(s);
		    }

		    // read any errors from the attempted command
		    System.out.println("Here is the standard error of the command (if any):\n");
		    while ((s = stdError.readLine()) != null) 
		    {
		            System.out.println(s);
		    }
			
			
			
			
			//System.out.println(result.getOutputStream());
		} catch (Exception e)
		{			
			e.printStackTrace();
		}
	}	



	public boolean createDirectory(String directory)
	{
//	    // Create one directory
//	    boolean success = (new File(directory)).mkdir();
//	    if (success) {
//	      System.out.println("Directory: " + directory + " created");
//	    }


	    // Create multiple directories
	    boolean success = (new File(directory)).mkdirs();
	    if (success) {
	      System.out.println("Directories: " + directory + " created");
	    }

	    return success;


	}

	@SuppressWarnings("unchecked")
	public String[] getDirectoryList(String directory)
	{
		FilenameFilter filter = new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				boolean accept = true;
				if (name.contains("##check"))
				{
					accept = false;
				} else if (name.startsWith("."))
				{
					accept = false;
				}
				else if (name.contains("##Check"))
				{
					accept = false;
				}
				return accept;
			}
		};


		File dir = new File(directory);

		File files[] = dir.listFiles(filter);
		Arrays.sort( files, new Comparator<File>()
		{
//		     public int compare(final Object o1, final Object o2) {
//		       return new Long(((File)o1).lastModified()).compareTo
//		             (new Long(((File) o2).lastModified()));
//		      }

			@Override
			public int compare(File o1, File o2)
			{
				return new Long((o1).lastModified()).compareTo
	             (new Long(( o2).lastModified()));
			}
		});

		String[] fileNames = new String[files.length];
		int count = 0;
		for (File file : files)
		{
			fileNames[count] = file.getName();
			//System.out.println(fileNames[count]);
			count ++;
		}


//		//String[] children = dir.list();
//		if (files == null)
//		{
//			// Either dir does not exist or is not a directory
//		} else
//		{
//			for (int i = 0; i < children.length; i++)
//			{
//				// Get filename of file or directory
//				String filename = children[i];
//			}
//		}
//
//		children = dir.list(filter);
//		return children;
		return fileNames;

	}

	public ENVICommon()
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public void CalculateH(double t1, double rh1, double t2)
	{

			t1 = t1 + 273.0;
			t2 = t2 + 273.0;

			double	p0, deltaH, R;
			p0 = 7.5152E8;
			deltaH = 42809;
			R = 8.314;

			double sat_p1, sat_p2, vapor, rh2, dew;
			sat_p1 = p0 * Math.exp(-deltaH/(R*t1));
			sat_p2 = p0 * Math.exp(-deltaH/(R*t2));
			vapor = sat_p1 * rh1/100;
			rh2 = (vapor/sat_p2)*100;
			dew = -deltaH/(R*Math.log(vapor/p0)) - 273;

			//vapor = Math.round(vapor*10)/10;
			//rh2   = Math.round(rh2*10)/10;
			//dew   = Math.round(dew*10)/10;

			System.out.println("rh2=" + rh2);
			System.out.println("dew=" + dew);
			System.out.println("vapor=" + vapor);




//			rh2text   = rh2.toString();
//			dewtext   = dew.toString();
//			vaportext = vapor.toString();

	}

	public void CalculateH(double t1, double rh1)
	{

			t1 = t1 + 273.0;
			//t2 = t2 + 273.0;

			double	p0, deltaH, R;
			p0 = 7.5152E8;
			deltaH = 42809;
			R = 8.314;

			double sat_p1, sat_p2, vapor, rh2, dew;
			sat_p1 = p0 * Math.exp(-deltaH/(R*t1));
			//sat_p2 = p0 * Math.exp(-deltaH/(R*t2));
			vapor = sat_p1 * rh1/100;
			//rh2 = (vapor/sat_p2)*100;
			dew = -deltaH/(R*Math.log(vapor/p0)) - 273;

			//vapor = Math.round(vapor*10)/10;
			//rh2   = Math.round(rh2*10)/10;
			//dew   = Math.round(dew*10)/10;

			//System.out.println("rh2=" + rh2);
			System.out.println("dew=" + dew);
			System.out.println("vapor=" + vapor);




//			rh2text   = rh2.toString();
//			dewtext   = dew.toString();
//			vaportext = vapor.toString();

	}

	public double CalculateRH(double tempC, double vapor)
	{
		double rh1=0;
		double tempK = tempC + 273.0;

		double p0 = 7.5152E8;
		double deltaH = 42809;
		double R = 8.314;

		double sat_p1 = 7.5152E8 * Math.exp(-42809/(8.314*tempK));

		rh1 = 100 * vapor / sat_p1;

		//vapor = sat_p1 * rh1/100;

//		double sat_p1 = p0 * Math.exp(-deltaH/(R*tempK));
//		vapor = sat_p1 * rh1/100;

		//double dew = -deltaH/(R*Math.log(vapor/p0)) - 273;

		//System.out.println("dew=" + dew);
		System.out.println("vapor=" + vapor);
		System.out.println("rh1=" + rh1);

		return rh1;

	}

	public double CalculateRH2(double tempC, double vapor)
	{

//		double tempK = tempC + 273.0;

//		double p0 = 7.5152E8;
//		double deltaH = 42809;
//		double R = 8.314;

//		double sat_p1 = 7.5152E8 * Math.exp(-42809/(8.314*(tempC + 273.0)));

		double rh = 100 * vapor / (7.5152E8 * Math.exp(-42809/(8.314*(tempC + 273.0))));

		//vapor = sat_p1 * rh1/100;

//		double sat_p1 = p0 * Math.exp(-deltaH/(R*tempK));
//		vapor = sat_p1 * rh1/100;

		//double dew = -deltaH/(R*Math.log(vapor/p0)) - 273;

		//System.out.println("dew=" + dew);
		//System.out.println("vapor=" + vapor);
		//System.out.println("rh1=" + rh);

		return rh;

	}

	public double CalculateVaporPressure(double t_hmp, double rh_hmp)
	{

		double A_0 = 6.107800;
		double A_1 = 4.436519e-1;
		double A_2 = 1.428946e-2;
		double A_3 = 2.650648e-4;
		double A_4 = 3.031240e-6;
		double A_5 = 2.034081e-8;
		double A_6 = 6.136821e-11;

		rh_hmp = rh_hmp*0.01;

//		// 'Find the HMP45C vapor pressure, in kPa, using a sixth order polynomial (Lowe, 1976).
//		double e_sat = 0.1*(A_0+t_hmp*(A_1+t_hmp*(A_2+t_hmp*(A_3+t_hmp*(A_4+t_hmp*(A_5+t_hmp*A_6))))));

		double e_sat = CalculateVaporPressurekPa(t_hmp);

		double e = e_sat*rh_hmp;

		//hmp in this case just refers to the instrument taking the temperature (t_hmp) and humidity (rh_hmp) measurements

		return e;
	}

	public double CalculateRHFromVapor(double t_hmp, double e)
	{
		double e_sat = CalculateVaporPressurekPa(t_hmp);

		double rh_hmp = e/e_sat ;

		//double e = e_sat*rh_hmp;

		return rh_hmp * 100;
	}

	public double CalculateRHFromVapor2(double t_hmp, double e)
	{
		return e/(0.1*(6.107800+t_hmp*(4.436519e-1+t_hmp*(1.428946e-2+t_hmp*(2.650648e-4+t_hmp*(3.031240e-6+t_hmp*(2.034081e-8+t_hmp*6.136821e-11)))))))*100;
	}


	public double CalculateVaporPressurekPa(double t_hmp)
	{
		double A_0 = 6.107800;
		double A_1 = 4.436519e-1;
		double A_2 = 1.428946e-2;
		double A_3 = 2.650648e-4;
		double A_4 = 3.031240e-6;
		double A_5 = 2.034081e-8;
		double A_6 = 6.136821e-11;

		// 'Find the HMP45C vapor pressure, in kPa, using a sixth order polynomial (Lowe, 1976).
		double e_sat = 0.1*(A_0+t_hmp*(A_1+t_hmp*(A_2+t_hmp*(A_3+t_hmp*(A_4+t_hmp*(A_5+t_hmp*A_6))))));

		return e_sat;
	}


	public Connection getMySqlConnection()
	{

		String USERNAME = "envimet";
		String PASSWORD = "envimet";
		String URL = "jdbc:mysql://localhost/envimet";

		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return conn;
	}
	
	public Connection getSuewsMySqlConnection()
	{

		String USERNAME = "suews";
		String PASSWORD = "suews";
		String URL = "jdbc:mysql://localhost/suews";

		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return conn;
	}
	
	public Connection getPrestonSqlite3Connection()
	{
		Connection conn = null;
		// SQLite.Database db = null;
		try
		{			
			Class.forName("org.sqlite.JDBC").newInstance();
			conn = DriverManager
					.getConnection("jdbc:sqlite:/" +
							Messages.getString("ProcessSUEWSRun.HOME") +
							Messages.getString("PrestonWeatherData.PRESTON_SQLITE") );
			// java.lang.reflect.Method m = conn.getClass().getMethod(
			// "getSQLiteDatabase", null);
			// db = (SQLite.Database) m.invoke(conn, null);
		} catch (Exception e)
		{
			e.printStackTrace();			
		}

		return conn;
	}		
	
	public Connection getPrestonSqliteConnection()
	{
		Connection conn = null;
		// SQLite.Database db = null;
		try
		{			
			Class.forName("SQLite.JDBCDriver").newInstance();
			conn = DriverManager
					.getConnection("jdbc:sqlite:/" +
							Messages.getString("ProcessSUEWSRun.HOME") +
							Messages.getString("PrestonWeatherData.PRESTON_SQLITE") );
			// java.lang.reflect.Method m = conn.getClass().getMethod(
			// "getSQLiteDatabase", null);
			// db = (SQLite.Database) m.invoke(conn, null);
		} catch (Exception e)
		{
			//e.printStackTrace();
			System.out.println("Falling back to other sqlite driver");
			conn = getPrestonSqlite3Connection();
		}

		return conn;
	}	

	public Connection getSqliteConnection()
	{
		Connection conn = null;
		// SQLite.Database db = null;
		try
		{
			Class.forName("SQLite.JDBCDriver").newInstance();
			conn = DriverManager
					.getConnection("jdbc:sqlite://home/nice/Documents/MonashMasters/Research Dissertation/Envimet-data.sqlite3");
			// java.lang.reflect.Method m = conn.getClass().getMethod(
			// "getSQLiteDatabase", null);
			// db = (SQLite.Database) m.invoke(conn, null);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return conn;
	}

	public ArrayList<String> getOutputFiles(int runID, int variable)
	{
		ArrayList<String> list = new ArrayList<String>();
		String query = "select distinct output_file from run_data where run_id = "
				+ "?" +
				// + runID +
				" and variable_type = " + "?"
		// + variable
		;
		System.out.println(query);

		Connection conn = getMySqlConnection();
		try
		{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, runID);
			ps.setInt(2, variable);
			// Statement stat = conn.createStatement();

			// ResultSet rs = stat.executeQuery(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				String outputFile = rs.getString("output_file");
				list.add(outputFile);
				 System.out.println("add output_file " + outputFile);
				 System.out.println("list=" + list.toString());

			}
			rs.close();
			conn.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<Integer> getDistinctVariableTypesForRun(int runID)
	{
		ArrayList<Integer> runVariableTypes = new ArrayList<Integer>();
		Connection conn = getMySqlConnection();
		String query = "select distinct variable_type from run_data where run_id = "
				+ runID;

		try
		{

			Statement stat = conn.createStatement();

			ResultSet rs = stat.executeQuery(query);

			while (rs.next())
			{
				Integer variableType = rs.getInt("variable_type");
				runVariableTypes.add(variableType);
			}
			rs.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		try
		{
			conn.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return runVariableTypes;
	}

	public TreeMap<String, ArrayList<DataPoint>> getVariableDataFromDB(
			int runID, int variable)
	{

		ArrayList<String> listOfOutputFiles = getOutputFiles(runID, variable);

		Connection conn = getMySqlConnection();

		TreeMap<String, ArrayList<DataPoint>> allData = new TreeMap<String, ArrayList<DataPoint>>();

		for (String outputFileName : listOfOutputFiles)
		{
			String query = "select x,y,z,value,output_file from run_data where run_id = "
					+ runID
					+ " and variable_type = "
					+ variable
					+ " and output_file ='" + outputFileName + "' ";

			System.out.println(query);
			// System.exit(1);

			try
			{
				ArrayList<DataPoint> variables = new ArrayList<DataPoint>();
				;
				Statement stat = conn.createStatement();

				ResultSet rs = stat.executeQuery(query);

				while (rs.next())
				{
					double x = rs.getDouble("x");
					double y = rs.getDouble("y");
					double z = rs.getDouble("z");
					double value = rs.getDouble("value");
					String outputFile = rs.getString("output_file");
					// System.out.println("outputFile="+ outputFile);

					DataPoint dataPoint = new DataPoint(x, y, z, value,
							outputFile);
					variables.add(dataPoint);
					//
					// System.out.println(dataPoint.toString());
					// System.out.println("variables.size()="+
					// variables.size());
					// System.out.println("allData.size()="+ allData.size());
				}
				rs.close();
				allData.put(outputFileName, variables);

			} catch (Exception e)
			{
				e.printStackTrace();
			}

		}
		try
		{
			conn.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(variables.toString());
		// System.out.println("allData.size()="+ allData.size());
		return allData;
	}
	public TreeMap<String, Integer> getDataVariableTypes()
	{
		TreeMap<String, Integer> variables = new TreeMap<String, Integer>();
		String query = "select variable_id, variable_name from run_variables ";

		Connection conn = getMySqlConnection();
		try
		{
			Statement stat = conn.createStatement();

			ResultSet rs = stat.executeQuery(query);
			while (rs.next())
			{
				Integer variableID = rs.getInt("variable_id");
				String variableName = rs.getString("variable_name");

				variables.put(variableName, variableID);
			}
			rs.close();
			conn.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println(variables.toString());
		return variables;
	}

	public TreeMap<String, String> getMetaDataForRun(int runID)
	{
		TreeMap<String, String> metaData = new TreeMap<String, String>();
		String query = "select run_date,run_desc,run_name,envi_version,data_dir from runs where run_id = " +runID;

		Connection conn = getMySqlConnection();
		try
		{
			Statement stat = conn.createStatement();

			ResultSet rs = stat.executeQuery(query);
			while (rs.next())
			{
				metaData.put(RUN_DESC, rs.getString(RUN_DESC));
				metaData.put(RUN_NAME, rs.getString(RUN_NAME));
				metaData.put(ENVI_VERSION, rs.getString(ENVI_VERSION));
				metaData.put(DATA_DIR, rs.getString(DATA_DIR));
			}
			rs.close();
			conn.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return metaData;
	}

	public TreeMap<String, String> getReceptorMetaDataFromDB(int runID)
	{
		TreeMap<String, String> metaData = new TreeMap<String, String>();
		String query = "select receptor_id,x,y,filename,path from receptor_files where run_id = " +runID;

		Connection conn = getMySqlConnection();
		try
		{
			Statement stat = conn.createStatement();

			ResultSet rs = stat.executeQuery(query);
			while (rs.next())
			{
				metaData.put(RECEPTOR_ID, rs.getString(RECEPTOR_ID));
				metaData.put(RECEPTOR_X, ""+rs.getInt(RECEPTOR_X));
				metaData.put(RECEPTOR_Y, ""+rs.getInt(RECEPTOR_Y));
				metaData.put(RECEPTOR_FILENAME, rs.getString(RECEPTOR_FILENAME));
				metaData.put(RECEPTOR_PATH, rs.getString(RECEPTOR_PATH));

			}
			rs.close();
			conn.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return metaData;
	}

	public String removeIllegalCharacters(String str)
	{
		return str.replaceAll("/", "_");
	}

    public void actualPlotCmd(String plotname, String outputDirectory)
    {
    	try
		{
			String[] commands = new String[]{"/home/kerryn/bin/gnuplot_bin_indiv.sh", plotname, outputDirectory};
			Process aProcess = Runtime.getRuntime().exec(commands);
			aProcess.waitFor();

		} catch (Exception e)
		{
			System.err.println(e);
			System.exit(1);
		}
    }
	public void runPlotCmd(String outputDirectory, Splot aPlot)
	{
		try
		{
			String plotName = aPlot.plot();
			//System.out.println("Plotting cmd=" + plotName);
			actualPlotCmd(plotName, outputDirectory);

		} catch (Exception e)
		{
			System.err.println(e);
			System.exit(1);
		}
	}

	public void imageMakeTransparent(String inImage, String outImage)
	{
		// convert startImage.png -transparent white EndImageT.png

		IMOperation op = new IMOperation();
		op.transparent("white");
		ConvertCmd convert = new ConvertCmd();
	    op.addImage();  // read and crop first image
	    op.addImage();  // read and crop second image

		try
		{
			convert.run(op, inImage, outImage);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IM4JavaException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void imageCompositeBlendCmd(String baseImage, String overlayImage, String outputImage, Integer blend)
	{
		IMOperation op = new IMOperation();
		op.blend(blend);
		op.gravity("center");
		CompositeCmd composite = new CompositeCmd();
	    op.addImage();  // read and crop first image
	    op.addImage();  // read and crop second image
	    op.addImage();
		try
		{
			composite.run(op,baseImage,overlayImage,outputImage);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IM4JavaException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void imageCompositeDifferenceCmd(String baseImage, String overlayImage, String outputImage)
	{
		IMOperation op = new IMOperation();
		op.compose("difference");
//		op.dissolve(percent);

//		op.blend(blend);
		op.gravity("center");
		CompositeCmd composite = new CompositeCmd();
	    op.addImage();  // read and crop first image
	    op.addImage();  // read and crop second image
	    op.addImage();
		try
		{
			composite.run(op,baseImage,overlayImage,outputImage);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IM4JavaException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void imageCompositeDissolveCmd(String baseImage, String overlayImage, String outputImage, Integer percent)
	{
		IMOperation op = new IMOperation();
		op.dissolve(percent);

//		op.blend(blend);
		op.gravity("center");
		CompositeCmd composite = new CompositeCmd();
	    op.addImage();  // read and crop first image
	    op.addImage();  // read and crop second image
	    op.addImage();
		try
		{
			composite.run(op,baseImage,overlayImage,outputImage);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IM4JavaException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

//	ReadEDTFile trimEDTOfIgnored(ReadEDTFile readEDTFile, String[] ignoredFields)
//	{
//		TreeMap<String, ArrayList> edtData = readEDTFile.getData();
//		for (int i = 0; i < ignoredFields.length; i++)
//		{
//			edtData.remove(ignoredFields[i]);
//		}
//		readEDTFile.setData(edtData);
//
//		return readEDTFile;
//	}

//	ArrayList<String> trimVariablesOfIgnored(ArrayList<String> fileVariables,
//			String[] ignoredFields)
//	{
//
//		ArrayList<String> returnVariables = new ArrayList<String>();
//
//		for (int j = 0; j < fileVariables.size(); j++)
//		{
//			boolean dropVariable = false;
//			String variable = fileVariables.get(j);
//			for (int i = 0; i < ignoredFields.length; i++)
//			{
//				// System.out.println("variable=|" + variable +
//				// "| ignoredFields[i]=|" + ignoredFields[i] + "|");
//
//				if (variable.equals(ignoredFields[i]))
//				{
//					// don't keep it
//					dropVariable = true;
//					break;
//				}
//
//			}
//			if (dropVariable)
//			{
//
//			} else
//			{
//				returnVariables.add(variable);
//			}
//			dropVariable = false;
//		}
//		return returnVariables;
//	}


}
