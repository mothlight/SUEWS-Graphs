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
		
		st.append("#Anthropogenic heat parameters" + '\n');
		st.append("#" + '\n');
		st.append("#Anthropogenic Heating diurnal profile." + '\n');
		st.append("#   Multiplication factor applied to AH (as defined in the table below)" + '\n');
		st.append("#   Hourly values ( 24 of them ), starting at 01 hours Local Time." + '\n');
		st.append("#If AnthropHeatChoice = 1 comment  AHDIUPRF1 and AHDIUPRF2 out. If AnthropHeatChoice = 1, comment AHDIUPRF away" + '\n');
		st.append("		" + '\n');
		st.append("#AHDIUPRF: 0.30 0.23 0.15 0.13 0.15 0.45 1.2 1.7 1.55 1.4 1.3 1.3  1.35 1.37 1.45 1.6 1.75  1.7  1.2  1.1 0.95  0.65 0.38 0.33" + '\n');
		st.append("#AHDIUPRF: 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " + '\n');
		st.append("AHDIUPRF1: 0.57 0.45 0.43 0.4 0.4 0.45 0.71 1.2 1.44 1.29 1.28 1.31 1.3 1.32 1.35 1.44 1.51 1.41 1.14 0.99 0.86 0.85 0.8 0.7" + '\n');
		st.append("AHDIUPRF2: 0.65 0.49 0.46 0.47 0.47 0.53 0.7 1.13 1.37 1.37 1.3 1.37 1.33 1.3 1.27 1.36 1.44 1.3 1.1 0.98 0.84 0.9 0.87 0.74" + '\n');
		st.append("" + '\n');
		st.append("#" + '\n');
		st.append("AH_MIN: 15" + '\n');
		st.append("" + '\n');
		st.append("#" + '\n');
		st.append("AH_SLOPE: 2.7" + '\n');
		st.append("" + '\n');
		st.append("#" + '\n');
		st.append("T_CRITIC: 7.0" + '\n');
			
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
	


}
