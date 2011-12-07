package au.edu.monash.ges.suews;

public class SuewsConfigModelledYears
{	
	ENVICommon common = new ENVICommon();
	public final String FILENAME = "ModelledYears.TXT";
	private String runDirectory;
	private int NumYears;
	private int startingYear;
	private String fileText;
	
	public SuewsConfigModelledYears(String runDirectory, int numYears,
			int startingYear)
	{
		super();
		this.runDirectory = runDirectory;
		NumYears = numYears;
		this.startingYear = startingYear;
		setFileText(generateConfigFileText(numYears, startingYear));
	}
	

	private String generateConfigFileText(int numYears,  int startingYear)
	{
		StringBuffer st = new StringBuffer();
		
		st.append(numYears +
				"      !How many years will be run" + '\n');
		st.append(startingYear +
				"   !List these below" + '\n');
		for (int i=1;i<numYears;i++)
		{
			int nextYear = startingYear + i;			
			st.append(nextYear);
			st.append('\n');
		}		
		
		return st.toString();
	}
	
	public void writeConfigFile()
	{
		common.createDirectory(runDirectory);
		common.writeFile(getFileText(), runDirectory + FILENAME);
	}
	
	public static void main(String[] args)
	{
		String runDirectory = "/tmp/SUEWS_tmp/";
		int numYears = 3;
		int startingYear = 2004;
		SuewsConfigModelledYears config = new SuewsConfigModelledYears(runDirectory, numYears, startingYear);
		//System.out.println (config.getFileText());
		config.writeConfigFile();

	}

	public String getRunDirectory()
	{
		return runDirectory;
	}

	public void setRunDirectory(String runDirectory)
	{
		this.runDirectory = runDirectory;
	}


	public int getNumYears()
	{
		return NumYears;
	}

	public void setNumYears(int numYears)
	{
		NumYears = numYears;
	}

	public int getStartingYear()
	{
		return startingYear;
	}

	public void setStartingYear(int startingYear)
	{
		this.startingYear = startingYear;
	}

	public String getFileText()
	{
		return fileText;
	}


	public void setFileText(String fileText)
	{
		this.fileText = fileText;
	}


	
	

}
