package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.TreeMap;

public class SuewsConfigWeatherData
{
	
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "";
	public final String FILENAME_SUFFUX = ".txt";
	
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;
	ArrayList<TreeMap<String,String>> dataForYear;


	public SuewsConfigWeatherData(String runDirectory, int year, String runPrefix)
	{
		super();
		this.runDirectory = runDirectory;		
		this.year = year;
		this.runPrefix = runPrefix;				
		this.filename = generateFilename(runPrefix, year);		
		
	}
	
	public void generateFile()
	{
		setFileText(generateConfigFileText(runPrefix, year));
	}
	
	private String generateConfigFileText(String runPrefix, int year)
	{		
		StringBuffer st = new StringBuffer();
		
		
		st.append("\"%\" \"Day of year\" \"time\" \"timecode\" \"NET\" \"QH\" \"QE\" \"QG\" \"Anthrop.\" \"wind spd\" \"%Hum\" \"Temp\" \"pressure\" \"Precip.\" \"Kdown\" \"snowcov\" \"Ldown\" \"obscloud\" \"extwater\" \"soilmodef\" \"LAI\"" + '\n');
		
		for (TreeMap<String,String> oneItem : dataForYear)
		{
			String dayOfYear = oneItem.get(PrestonWeatherData.DAY_OF_YEAR);
			String time = oneItem.get(PrestonWeatherData.TIME);	
			String timeHours = "";
			String timeMinutes = "";
			if (time.length() == 4)
			{
				timeHours = time.substring(0, 2);
				//1330
				timeMinutes = time.substring(2, 4);
				if (timeMinutes.equals("30"))
				{
					timeMinutes = ".5";						
				}
				else
				{
					timeMinutes = "";
				}				
			}
			else if (time.length() == 3)
			{
				timeHours = time.substring(0, 1);
				timeHours = "0" + timeHours;
				timeMinutes = time.substring(1, 3);
				if (timeMinutes.equals("30"))
				{
					timeMinutes = ".5";						
				}
				else
				{
					timeMinutes = "";
				}
				
			} else if (time.length() == 2)
			{
				//timeHours = time.substring(0, 1);
				timeHours = "0" + "0";
				//timeMinutes = time.substring(1, 3);
				if (time.equals("30"))
				{
					timeMinutes = ".5";						
				}
				else
				{
					timeMinutes = "";
				}
				
			}
			else if (time.length() == 1)
			{
				timeHours = time.substring(0, 1);
				timeHours = "0" + timeHours;
				//timeMinutes = time.substring(1, 3);
				//if (timeMinutes.equals("30"))
				//{
				//	timeMinutes = ".5";						
				//}
				//else
				//{
					timeMinutes = "";
				//}
				
			}
			//String timeMinutes = time.substring(time.length()-1,time.length());
			
			String timeCombined = timeHours + timeMinutes;
			String timecode = oneItem.get(PrestonWeatherData.TIMECODE);
			double timeFraction = new Double(timeCombined).doubleValue() /24;
			double dectimeDouble = new Double(dayOfYear) + timeFraction;
					
			//String dectime = dayOfYear + "." + time.replace(".", "");
			String net = oneItem.get(PrestonWeatherData.NET);
			String qh = oneItem.get(PrestonWeatherData.QH);
			String qe = oneItem.get(PrestonWeatherData.QE);
			String qg = oneItem.get(PrestonWeatherData.QG);
			String anthrop = oneItem.get(PrestonWeatherData.ANTHROP);
			String windSpd = oneItem.get(PrestonWeatherData.WIND_SPD);
			String rh = oneItem.get(PrestonWeatherData.RH);
			String temp = oneItem.get(PrestonWeatherData.TEMP);
			String pressure = oneItem.get(PrestonWeatherData.PRESSURE);
			String precip = oneItem.get(PrestonWeatherData.PRECIP);
			String kdown = oneItem.get(PrestonWeatherData.KDOWN);
			String ldown = oneItem.get(PrestonWeatherData.LDOWN);
			
			st.append("" +
					dayOfYear +
					" " +
					timeCombined +
					" " +
					dectimeDouble +
					" " +
					net +
					" " +
					qh +
					" " +
					qe +
					" " +
					qg +
					" " +
					anthrop +
					" " +
					windSpd +
					" " +
					rh +
					" " +
					temp +
					" " +
					pressure +
					" " +
					precip +
					" " +
					kdown +
					" " +
					"-999" + //snowcov
					" " +
					ldown +
					" " +
					"-999" + //obscloud
					" " +
					"258.18" + //extwater
					" " +
					"-999" + //soilmodef
					" " +
					"-999" + //LAI
					"" + '\n');
			
			//st.append("1 0 10 -99.826 5.638 2.721 -90.472 6.497 2.081 67.77 16.422 1002 0 -2.846 -999 299.64 -999 258.18 -999 -999" + '\n');	
			
		}
		
					
		return st.toString();
	}		
	
	public void writeConfigFile(String inputDirectory)
	{
		common.createDirectory(runDirectory + inputDirectory);
		common.writeFile(getFileText(), runDirectory + inputDirectory + "/" + this.filename);
	}
	
	private String generateFilename(String runPrefix, int year)
	{
		return FILENAME_PREFIX + runPrefix + "_" + year + "_data" + FILENAME_SUFFUX;
	}


	public String getRunDirectory()
	{
		return runDirectory;
	}

	public void setRunDirectory(String runDirectory)
	{
		this.runDirectory = runDirectory;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getFileText()
	{
		return fileText;
	}

	public void setFileText(String fileText)
	{
		this.fileText = fileText;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public String getRunPrefix()
	{
		return runPrefix;
	}

	public void setRunPrefix(String runPrefix)
	{
		this.runPrefix = runPrefix;
	}
	

	public ArrayList<TreeMap<String, String>> getDataForYear()
	{
		return dataForYear;
	}

	public void setDataForYear(ArrayList<TreeMap<String, String>> dataForYear)
	{
		this.dataForYear = dataForYear;
	}


}