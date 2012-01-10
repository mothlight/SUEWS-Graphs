package au.edu.monash.ges.suews;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SUEWSDataFile
{
	ENVICommon common = new ENVICommon();

//	public TUF3DDataFile()
//	{
//		super();
//		// TODO Auto-generated constructor stub
//	}

	//
	public static String SUEWS_FORCING_Day_of_year = "Day of year";
	public static String SUEWS_FORCING_time = "time";
	public static String SUEWS_FORCING_timecode = "timecode";
	public static String SUEWS_FORCING_NET = "NET";
	public static String SUEWS_FORCING_QH = "QH";
	public static String SUEWS_FORCING_QE = "QE";
	public static String SUEWS_FORCING_QG = "QG";
	public static String SUEWS_FORCING_Anthrop = "Anthrop.";
	public static String SUEWS_FORCING_wind_spd = "wind spd";
	public static String SUEWS_FORCING__Hum = "%Hum";
	public static String SUEWS_FORCING_Temp = "Temp";
	public static String SUEWS_FORCING_pressure = "pressure";
	public static String SUEWS_FORCING_Precip = "Precip.";
	public static String SUEWS_FORCING_Kdown = "Kdown";
	public static String SUEWS_FORCING_snowcov = "snowcov";
	public static String SUEWS_FORCING_Ldown = "Ldown";
	public static String SUEWS_FORCING_obscloud = "obscloud";
	public static String SUEWS_FORCING_extwater = "extwater";
	public static String SUEWS_FORCING_soilmodef = "soilmodef";
	public static String SUEWS_FORCING_LAI = "LAI";

	public static String SUEWS_id = "id";
	public static String SUEWS_it = "it";
	public static String SUEWS_kdown = "kdown";
	public static String SUEWS_kup = "kup";
	public static String SUEWS_ldown = "ldown";
	public static String SUEWS_lup = "lup";
	public static String SUEWS_QH = "QH";
	public static String SUEWS_QE = "QE";
	public static String SUEWS_qs = "qs";
	public static String LUMPS_QH = "h_mod";
	public static String LUMPS_QE = "e_mod";

	public static String SUEWS_availableEnergy = "availableEnergy";
	public static String SUEWS_dailyEnergyBalance = "dailyEnergyBalance";
	public static String SUEWS_Rn_G_H_LE = "Rn_G_H_LE";

	public static String SUEWS_NARP_day = "1";
	public static String SUEWS_NARP_dectime = "2";
	public static String SUEWS_NARP_kup_pav = "3";
	public static String SUEWS_NARP_kup_blg = "4";
	public static String SUEWS_NARP_kup_con = "5";
	public static String SUEWS_NARP_kup_dec = "6";
	public static String SUEWS_NARP_kup_Irrgr = "7";
	public static String SUEWS_NARP_kup_Gr = "8";
	public static String SUEWS_NARP_kup_wtr = "9";
	public static String SUEWS_NARP_lup_pav = "10";
	public static String SUEWS_NARP_lup_blg = "11";
	public static String SUEWS_NARP_lup_con = "12";
	public static String SUEWS_NARP_lup_dec = "13";
	public static String SUEWS_NARP_lup_Irrgr = "14";
	public static String SUEWS_NARP_lup_Gr = "15";
	public static String SUEWS_NARP_lup_wtr = "16";
	public static String SUEWS_NARP_Ts_pav = "17";
	public static String SUEWS_NARP_Ts_blg = "18";
	public static String SUEWS_NARP_Ts_con = "19";
	public static String SUEWS_NARP_Ts_dec = "20";
	public static String SUEWS_NARP_Ts_Irrgr = "21";
	public static String SUEWS_NARP_Ts_Gr = "22";
	public static String SUEWS_NARP_Ts_wtr = "23";
	public static String SUEWS_NARP_qn_pav = "24";
	public static String SUEWS_NARP_qn_blg = "25";
	public static String SUEWS_NARP_qn_con = "26";
	public static String SUEWS_NARP_qn_dec = "27";
	public static String SUEWS_NARP_qn_Irrgr = "28";
	public static String SUEWS_NARP_qn_Gr = "29";
	public static String SUEWS_NARP_qn_wtr = "30";
	public static String SUEWS_NARP_REFORMAT_FormattedDate = "30";

	public static String SUEWS_NARP_STR_day = "day";
	public static String SUEWS_NARP_STR_dectime = "dectime";
	public static String SUEWS_NARP_STR_kup_pav = "kup_pav";
	public static String SUEWS_NARP_STR_kup_blg = "kup_blg";
	public static String SUEWS_NARP_STR_kup_con = "kup_con";
	public static String SUEWS_NARP_STR_kup_dec = "kup_dec";
	public static String SUEWS_NARP_STR_kup_Irrgr = "kup_Irrgr";
	public static String SUEWS_NARP_STR_kup_Gr = "kup_Gr";
	public static String SUEWS_NARP_STR_kup_wtr = "kup_wtr";
	public static String SUEWS_NARP_STR_lup_pav = "lup_pav";
	public static String SUEWS_NARP_STR_lup_blg = "lup_blg";
	public static String SUEWS_NARP_STR_lup_con = "lup_con";
	public static String SUEWS_NARP_STR_lup_dec = "lup_dec";
	public static String SUEWS_NARP_STR_lup_Irrgr = "lup_Irrgr";
	public static String SUEWS_NARP_STR_lup_Gr = "lup_Gr";
	public static String SUEWS_NARP_STR_lup_wtr = "lup_wtr";
	public static String SUEWS_NARP_STR_Ts_pav = "Ts_pav";
	public static String SUEWS_NARP_STR_Ts_blg = "Ts_blg";
	public static String SUEWS_NARP_STR_Ts_con = "Ts_con";
	public static String SUEWS_NARP_STR_Ts_dec = "Ts_dec";
	public static String SUEWS_NARP_STR_Ts_Irrgr = "Ts_Irrgr";
	public static String SUEWS_NARP_STR_Ts_Gr = "Ts_Gr";
	public static String SUEWS_NARP_STR_Ts_wtr = "Ts_wtr";
	public static String SUEWS_NARP_STR_qn_pav = "qn_pav";
	public static String SUEWS_NARP_STR_qn_blg = "qn_blg";
	public static String SUEWS_NARP_STR_qn_con = "qn_con";
	public static String SUEWS_NARP_STR_qn_dec = "qn_dec";
	public static String SUEWS_NARP_STR_qn_Irrgr = "qn_Irrgr";
	public static String SUEWS_NARP_STR_qn_Gr = "qn_Gr";
	public static String SUEWS_NARP_STR_qn_wtr = "qn_wtr";
	public static String SUEWS_NARP_STR_FormattedDate = "FormattedDate";

	public static int LINES_TO_SKIP_NARP = 0;
	public static int LINES_TO_SKIP_DAILY_FILE = 1;
	public static int LINES_TO_SKIP_60 = 4;
	//public static int LINES_TO_SKIP_LUMPS_60 = 5;

	public static String SUEWS_DAILY_FILE_day = "1";
	public static String SUEWS_DAILY_FILE_STR_day = "day";

	public static String SUEWS_DAILY_FILE_counter = "1";
	public static String SUEWS_DAILY_FILE_STR_counter = "counter";

	public static String SUEWS_DAILY_FILE_qn = "2";
	public static String SUEWS_DAILY_FILE_STR_qn = "qn";

	public static String SUEWS_DAILY_FILE_qs = "3";
	public static String SUEWS_DAILY_FILE_STR_qs = "qs";

	public static String SUEWS_DAILY_FILE_qf = "4";
	public static String SUEWS_DAILY_FILE_STR_qf = "qf";

	public static String SUEWS_DAILY_FILE_qe_S = "5";
	public static String SUEWS_DAILY_FILE_STR_qe_S = "qe_S";

	public static String SUEWS_DAILY_FILE_pp = "6";
	public static String SUEWS_DAILY_FILE_STR_pp = "pp";

	public static String SUEWS_DAILY_FILE_ext_Ie = "7";
	public static String SUEWS_DAILY_FILE_STR_ext_Ie = "ext_Ie";

	public static String SUEWS_DAILY_FILE_int_Ie = "8";
	public static String SUEWS_DAILY_FILE_STR_int_Ie = "int_Ie";

	public static String SUEWS_DAILY_FILE_tot_ie = "9";
	public static String SUEWS_DAILY_FILE_STR_tot_ie = "tot_ie";

	public static String SUEWS_DAILY_FILE_E_S = "10";
	public static String SUEWS_DAILY_FILE_STR_E_S = "E_S";

	public static String SUEWS_DAILY_FILE_Change = "11";
	public static String SUEWS_DAILY_FILE_STR_Change = "Change";

	public static String SUEWS_DAILY_FILE_R_Soil = "12";
	public static String SUEWS_DAILY_FILE_STR_R_Soil = "R_Soil";

	public static String SUEWS_DAILY_FILE_R = "13";
	public static String SUEWS_DAILY_FILE_STR_R = "R";

	public static String SUEWS_DAILY_FILE_Fw = "14";
	public static String SUEWS_DAILY_FILE_STR_Fw = "Fw";

	public static String SUEWS_DAILY_FILE_addWater = "15";
	public static String SUEWS_DAILY_FILE_STR_addWater = "addWater";

	public static String SUEWS_DAILY_FILE_STR_FormattedDate = "FormattedDate";
	public static String SUEWS_DAILY_FILE_FormattedDate = "16";
	
	//private boolean lumpsRun;

	public SUEWSDataFile(String path, String filename, boolean skipEveryOtherLine, int initialLinesToSkip)
	{
		super();

		this.variables = new ArrayList<String>();
		this.data = new TreeMap<String, ArrayList<String>>();
		//this.lumpsRun = lumpsRun;

		setPath(path);
		setFilename(filename);
		setYear(parseYear(filename));
		readDataFile(path, filename, skipEveryOtherLine, initialLinesToSkip);
	}

//	public SUEWSDataFile(String path, String filename, boolean reformatFullFile)
//	{
//		super();
//
//		this.variables = new ArrayList<String>();
//		this.data = new TreeMap<String, ArrayList<String>>();
//
//		setPath(path);
//		setFilename(filename);
//
//	}


	private String path;
	private String filename;
	private String year;

	private String parseYear(String filename)
	{
		String year;

		String[] filenameSplit = filename.split("_");
		year = filenameSplit[1];

		return year;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	ArrayList<String> variables;
	TreeMap<String, ArrayList<String>> data;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String path = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DATA_PATH");
		String filename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE");

		SUEWSDataFile sUEWSDataFile = new SUEWSDataFile(path, filename, true, LINES_TO_SKIP_60);
		TreeMap<String, ArrayList<String>> theData = sUEWSDataFile.getData();

		Set<String> keys = theData.keySet();
		for (String key : keys)
		{
			System.out.println(key);
		}

		//System.out.println(theData.toString());

		//System.out.println(theData.get(SUEWS_DAILY_FILE_STR_Change).toString());

		SUEWSMonthlyAverages sUEWSMonthlyAverages = new SUEWSMonthlyAverages(sUEWSDataFile);

//		ArrayList<String> keys = sUEWSMonthlyAverages.getKeySetForData();
//		for (String key : keys)
//		{
//			System.out.println(key);
//		}

		//System.out.println(keys.toString());

//		System.out.println(sUEWSMonthlyAverages.getDataForVariableAndTime("kdown_2004_1_1"));
//		System.out.println(sUEWSMonthlyAverages.getAverageForVariableAndTime("kdown_2004_1_1"));
//
//		System.out.println(sUEWSMonthlyAverages.getDataForVariableAndTime("kdown_2004_1_14"));
//		System.out.println(sUEWSMonthlyAverages.getAverageForVariableAndTime("kdown_2004_1_14"));

		sUEWSMonthlyAverages.outputDataFile(Messages.getString("SuewsPrestonComparisonGraphs.graph_dir"),
										Messages.getString("SuewsPrestonComparisonGraphs.MONTHLY_AVERAGE_DAT_FILE"));


		ArrayList<String> plotFields = new ArrayList<String>();
		ArrayList<String> plotFieldLabels = new ArrayList<String>();
		plotFields.add("3");
		plotFieldLabels.add("kdown");
		plotFields.add("4");
		plotFieldLabels.add("kup");
		plotFields.add("5");
		plotFieldLabels.add("ldown");
		plotFields.add("6");
		plotFieldLabels.add("lup");

		for (int i=1;i<9;i++)
		{
			sUEWSMonthlyAverages.setXRANGE_BEG("2004-0" + i + "-15");
			sUEWSMonthlyAverages.setXRANGE_END("2004-0" + i + "-16");

			sUEWSMonthlyAverages.plotData(Messages.getString("SuewsPrestonComparisonGraphs.graph_dir"),
					Messages.getString("SuewsPrestonComparisonGraphs.MONTHLY_AVERAGE_DAT_FILE"),
					"1", "K" + sUEWSMonthlyAverages.getXRANGE_BEG(), plotFields, plotFieldLabels);
		}

		plotFields.clear();
		plotFieldLabels.clear();
		plotFields.add("12");
		plotFieldLabels.add("QF");
		plotFields.add("13");
		plotFieldLabels.add("QH");
		plotFields.add("14");
		plotFieldLabels.add("QE");
		plotFields.add("11");
		plotFieldLabels.add("qs");
		plotFields.add("8");
		plotFieldLabels.add("qn");
		plotFields.add("9");
		plotFieldLabels.add("hMod");
		plotFields.add("10");
		plotFieldLabels.add("eMod");
		for (int i=1;i<9;i++)
		{
			sUEWSMonthlyAverages.setXRANGE_BEG("2004-0" + i + "-15");
			sUEWSMonthlyAverages.setXRANGE_END("2004-0" + i + "-16");

			sUEWSMonthlyAverages.plotData(Messages.getString("SuewsPrestonComparisonGraphs.graph_dir"),
					Messages.getString("SuewsPrestonComparisonGraphs.MONTHLY_AVERAGE_DAT_FILE"),
					"1", "Q" + sUEWSMonthlyAverages.getXRANGE_BEG(), plotFields, plotFieldLabels);
		}

		plotFields.clear();
		plotFields.add("7");
		plotFieldLabels.clear();
		plotFieldLabels.add("Tsurf");

		for (int i=1;i<9;i++)
		{
			sUEWSMonthlyAverages.setXRANGE_BEG("2004-0" + i + "-15");
			sUEWSMonthlyAverages.setXRANGE_END("2004-0" + i + "-16");

			sUEWSMonthlyAverages.plotData(Messages.getString("SuewsPrestonComparisonGraphs.graph_dir"),
					Messages.getString("SuewsPrestonComparisonGraphs.MONTHLY_AVERAGE_DAT_FILE"),
					"1", "T" + sUEWSMonthlyAverages.getXRANGE_BEG(), plotFields, plotFieldLabels);
		}
	}

	public void readDataFile(String path, String filename, boolean skipEveryOtherLine, int initialLinesToSkip)
	{
		String dataFile = path + File.separator + filename;

		File file = new File(dataFile);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try
		{
			fis = new FileInputStream(file);

			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			if (dis.available()>0)
			{
				for (int i=0;i<initialLinesToSkip;i++)
				{
					//use up lines
					dis.readLine();
					//dis.readLine(); dis.readLine(); dis.readLine();

				}
				String variableStr = dis.readLine();
				variableStr = variableStr.replaceFirst("%", "");
				//StringTokenizer st = new StringTokenizer(variableStr);
				String[] splitString = variableStr.split("\\s+");
				//while (st.hasMoreTokens())
				for (String aVariable : splitString)
				{
					//String aVariable = st.nextToken().trim();
					//System.out.println("Variable=" + aVariable);
					this.variables.add(aVariable);
				}
			}

			int readCount = 0;
			while (dis.available()>0)
			{
				int count = 0;
				String dataStr = dis.readLine();

				if (skipEveryOtherLine)
				{
					//if count is even, skip this line
					if (readCount % 2 == 0)
					{}
					else
					{
						readCount ++;
						continue;
					}
				}
				if (dataStr != null)
				{
					//System.out.println(dataStr);
					dataStr = dataStr.trim();
					//System.out.println(dataStr);
					//System.exit(1);
				}

				String[] splitString = dataStr.split("\\s+");

				//System.out.println("splitString.length=" + splitString.length);

				//for (String dataItemFromRow : splitString)
				//try going backwards to get over run together 2nd/3rd row errors

				boolean offsetProblem = false;
//				//special case, seems as first two columns run into 3rd
				if (initialLinesToSkip == LINES_TO_SKIP_60 && splitString.length != 50)
				{
					offsetProblem = true;
				}
//				if (isLumpsRun())
//				{
//					offsetProblem = false;
//				}

				for (int i=splitString.length-1;i>-1;i--)
				{
					String dataItemFromRow = splitString[i];

					int variableNumber = i;

					if (offsetProblem)
					{
						variableNumber = i+1;
						if (i==2)
						{
							String[] parsedStr = getFixedIDIT(dataStr);
							String varName = this.variables.get(0);

							ArrayList<String> storedData = this.data.get(varName);
							if (storedData == null)
							{
								storedData = new ArrayList<String>();
							}
							storedData.add(parsedStr[0].trim());
							this.data.put(varName, storedData);

							varName = this.variables.get(1);

							storedData = this.data.get(varName);
							if (storedData == null)
							{
								storedData = new ArrayList<String>();
							}
							storedData.add(parsedStr[1].trim());
							this.data.put(varName, storedData);

							//finish after processing this item
							i=-1;
						}
					}

					//System.out.println(count);
					String variableName = this.variables.get(variableNumber);
					//System.out.println("variableName=" + variableName);
					ArrayList<String> dataSet = this.data.get(variableName);
					if (dataSet == null)
					{
						dataSet = new ArrayList<String>();
					}

					dataItemFromRow = dataItemFromRow.trim();
					//System.out.println("variableValue=" + variableValue);
					if (variableName.equals(SUEWS_DAILY_FILE_STR_counter))
					{
						dataItemFromRow = "1200";
					}

					dataSet.add(dataItemFromRow);
					this.data.put(variableName, dataSet);

					count ++;
				}
				offsetProblem = false;
				readCount ++;

			}

			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getFixedIDIT(String dataStr)
	{
		String[] returnStr = new String[2];
		String idStr = null,itStr = null;

		String idItStr = dataStr.substring(6, 15).trim();
		System.out.println("|"+idItStr+"|");
		String[] idItStrSplitString = idItStr.split("\\.");

		idStr = dataStr.substring(0, 5).trim();

		itStr = idItStrSplitString[1].trim();
		itStr = common.getHourFromFraction("." + itStr);
		dataStr = dataStr.substring(9, dataStr.length());

		//System.out.println(idStr + "|" + itStr + "|" + dataStr);
		System.out.println(idStr + "|" + itStr );

		returnStr[0]= idStr;
		returnStr[1]= itStr;
		return returnStr;
	}	

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public ArrayList<String> getVariables()
	{
		return variables;
	}

	public void setVariables(ArrayList<String> variables)
	{
		this.variables = variables;
	}

	public TreeMap<String, ArrayList<String>> getData()
	{
		return data;
	}

	public void setData(TreeMap<String, ArrayList<String>> data)
	{
		this.data = data;
	}

//	public boolean isLumpsRun()
//	{
//		return lumpsRun;
//	}
//
//	public void setLumpsRun(boolean lumpsRun)
//	{
//		this.lumpsRun = lumpsRun;
//	}

}
