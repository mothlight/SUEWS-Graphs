package au.edu.monash.ges.suews;

public class SuewsConfigSahp
{
	
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "";
	public final String FILENAME_SUFFUX = ".sahp";
	
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;
	
	private String[] configSahpAHDIUPRF;
	private String[] configSahpAHDIUPRF1;
	private String[] configSahpAHDIUPRF2;
	private String configSahpAH_MIN;
	private String configSahpAH_SLOPE;
	private String configSahpT_CRITIC;
	

	public SuewsConfigSahp(String runDirectory, int year, String runPrefix)
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
		
		String aHDIUPRFEnabled = "#";
		//check  If AnthropHeatChoice = 1, comment AHDIUPRF away
		// if (!AnthropHeatChoice == 1)
		// {
		//	 aHDIUPRFEnabled = "";
		// }
		// 
		
		StringBuffer aHDIUPRFStr = new StringBuffer("");
		for (String aHDIUPRF : configSahpAHDIUPRF)
		{
			aHDIUPRFStr.append(aHDIUPRF + " ");
		}
		
		StringBuffer aHDIUPRF1Str = new StringBuffer("");
		for (String aHDIUPRF1 : configSahpAHDIUPRF1)
		{
			aHDIUPRF1Str.append(aHDIUPRF1 + " ");
		}
		
		StringBuffer aHDIUPRF2Str = new StringBuffer("");
		for (String aHDIUPRF2 : configSahpAHDIUPRF2)
		{
			aHDIUPRF2Str.append(aHDIUPRF2 + " ");
		}		
		
		st.append("#Anthropogenic heat parameters" + '\n');
		st.append("#" + '\n');
		st.append("#Anthropogenic Heating diurnal profile." + '\n');
		st.append("#   Multiplication factor applied to AH (as defined in the table below)" + '\n');
		st.append("#   Hourly values ( 24 of them ), starting at 01 hours Local Time." + '\n');
		st.append("#If AnthropHeatChoice = 1 comment  AHDIUPRF1 and AHDIUPRF2 out. If AnthropHeatChoice = 1, comment AHDIUPRF away" + '\n');
		st.append("		" + '\n');
		//st.append("#AHDIUPRF: 0.30 0.23 0.15 0.13 0.15 0.45 1.2 1.7 1.55 1.4 1.3 1.3  1.35 1.37 1.45 1.6 1.75  1.7  1.2  1.1 0.95  0.65 0.38 0.33" + '\n');
		st.append(aHDIUPRFEnabled +
				"AHDIUPRF: " +
				aHDIUPRFStr + '\n');
		st.append("AHDIUPRF1: " +
				aHDIUPRF1Str + '\n');
		st.append("AHDIUPRF2: " +
				aHDIUPRF2Str + '\n');
		st.append("" + '\n');
		st.append("#" + '\n');
		st.append("AH_MIN: " +
				getConfigSahpAH_MIN() + '\n');
		st.append("" + '\n');
		st.append("#" + '\n');
		st.append("AH_SLOPE: " +
				getConfigSahpAH_SLOPE() + '\n');
		st.append("" + '\n');
		st.append("#" + '\n');
		st.append("T_CRITIC: " +
				getConfigSahpT_CRITIC() + '\n');
			
		return st.toString();
	}		
	
	public void writeConfigFile(String inputDirectory)
	{
		common.createDirectory(runDirectory + inputDirectory);
		common.writeFile(getFileText(), runDirectory + inputDirectory + "/" + this.filename);
	}
	
	private String generateFilename(String runPrefix, int year)
	{
		return FILENAME_PREFIX + runPrefix + "_" + year + FILENAME_SUFFUX;
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

	public String[] getConfigSahpAHDIUPRF()
	{
		return configSahpAHDIUPRF;
	}

	public void setConfigSahpAHDIUPRF(String[] configSahpAHDIUPRF)
	{
		this.configSahpAHDIUPRF = configSahpAHDIUPRF;
	}

	public String[] getConfigSahpAHDIUPRF1()
	{
		return configSahpAHDIUPRF1;
	}

	public void setConfigSahpAHDIUPRF1(String[] configSahpAHDIUPRF1)
	{
		this.configSahpAHDIUPRF1 = configSahpAHDIUPRF1;
	}

	public String[] getConfigSahpAHDIUPRF2()
	{
		return configSahpAHDIUPRF2;
	}

	public void setConfigSahpAHDIUPRF2(String[] configSahpAHDIUPRF2)
	{
		this.configSahpAHDIUPRF2 = configSahpAHDIUPRF2;
	}

	public String getConfigSahpAH_MIN()
	{
		return configSahpAH_MIN;
	}

	public void setConfigSahpAH_MIN(String configSahpAH_MIN)
	{
		this.configSahpAH_MIN = configSahpAH_MIN;
	}

	public String getConfigSahpAH_SLOPE()
	{
		return configSahpAH_SLOPE;
	}

	public void setConfigSahpAH_SLOPE(String configSahpAH_SLOPE)
	{
		this.configSahpAH_SLOPE = configSahpAH_SLOPE;
	}

	public String getConfigSahpT_CRITIC()
	{
		return configSahpT_CRITIC;
	}

	public void setConfigSahpT_CRITIC(String configSahpT_CRITIC)
	{
		this.configSahpT_CRITIC = configSahpT_CRITIC;
	}
	


}
