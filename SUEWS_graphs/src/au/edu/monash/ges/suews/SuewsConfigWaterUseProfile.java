package au.edu.monash.ges.suews;

public class SuewsConfigWaterUseProfile
{
	
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "WaterUseProfile";
	public final String FILENAME_SUFFUX = ".txt";
	
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;

	public SuewsConfigWaterUseProfile(String runDirectory, int year, String runPrefix)
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
		
		
		st.append("&WaterUseProfile" + '\n');
		st.append("Ie_start=0" + '\n');
		st.append("Ie_end=365" + '\n');
		st.append("Faut=0.1" + '\n');
		st.append("Ie_a(1)=-84.535" + '\n');
		st.append("Ie_a(2)=9.959" + '\n');
		st.append("Ie_a(3)=3.674" + '\n');
		st.append("Ie_m(1)=-25.36" + '\n');
		st.append("Ie_m(2)=2.988" + '\n');
		st.append("Ie_m(3)=1.102" + '\n');
		st.append("DayWat(1)=1" + '\n');
		st.append("DayWat(2)=1" + '\n');
		st.append("DayWat(3)=1" + '\n');
		st.append("DayWat(4)=1" + '\n');
		st.append("DayWat(5)=1" + '\n');
		st.append("DayWat(6)=1" + '\n');
		st.append("DayWat(7)=1" + '\n');
		st.append("DayWatPer(1)=0.3" + '\n');
		st.append("DayWatPer(2)=1" + '\n');
		st.append("DayWatPer(3)=1" + '\n');
		st.append("DayWatPer(4)=1" + '\n');
		st.append("DayWatPer(5)=1" + '\n');
		st.append("DayWatPer(6)=1" + '\n');
		st.append("DayWatPer(7)=0.3" + '\n');
		st.append("HourResChoice=0" + '\n');
		st.append("HourWat(5)=0.11" + '\n');
		st.append("HourWat(6)=0.12" + '\n');
		st.append("HourWat(7)=0.11" + '\n');
		st.append("HourWat(17)=0.11" + '\n');
		st.append("HourWat(18)=0.11" + '\n');
		st.append("HourWat(19)=0.11" + '\n');
		st.append("HourWat(20)=0.11" + '\n');
		st.append("HourWat(21)=0.11" + '\n');
		st.append("HourWat(22)=0.11" + '\n');
		st.append("/" + '\n');
			
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
