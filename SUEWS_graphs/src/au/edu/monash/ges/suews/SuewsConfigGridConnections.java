package au.edu.monash.ges.suews;

public class SuewsConfigGridConnections
{
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "GridConnections";
	public final String FILENAME_SUFFUX = ".TXT";
	private int numGridConnections;
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;
	
	public static void main(String[] args)
	{
		int numGridConnections = 1;
		String runPrefix = "Pr3714";
		int year = 2004;
		String runDirectory = "/tmp/SUEWS_tmp/";
		SuewsConfigGridConnections gridConnections = new SuewsConfigGridConnections(runDirectory, year, runPrefix, numGridConnections);
		gridConnections.writeConfigFile();

	}
	
	
//	 1      !Number of grid connections listed below
//	 'Pr3714_2004'     0         'none'
//	 !From   fraction     To 

	
	public SuewsConfigGridConnections(String runDirectory, int year, String runPrefix, int numGridConnections)
	{
		super();
		this.runDirectory = runDirectory;
		this.year = year;
		this.numGridConnections = numGridConnections;
		this.filename = generateFilename(year);		
		setRunPrefix(runPrefix);
		//setFileText(generateConfigFileText(year, runPrefix, numGridConnections));
	}
	
	private String generateFilename(int year)
	{
		return FILENAME_PREFIX + year + FILENAME_SUFFUX;
	}

	private String generateConfigFileText(int year, String runPrefix, int numGridConnections)
	{
		StringBuffer st = new StringBuffer();
		
		//doesn't handle more grid connections yet
		st.append(" " +
				numGridConnections +
				"      !Number of grid connections listed below");
		st.append('\n');
		st.append("'" +
				runPrefix +
				"_" +
				year +
				"'     0         'none'");
		st.append('\n');
		st.append("!From   fraction     To ");
		st.append('\n');
		
		return st.toString();
	}
	
	public void generateFile()
	{
		setFileText(generateConfigFileText(year, runPrefix, numGridConnections));
	}
	
	public void writeConfigFile()
	{		
		common.createDirectory(runDirectory);
		common.writeFile(getFileText(), runDirectory + this.filename);
	}	
	

	public int getNumGridConnections()
	{
		return numGridConnections;
	}


	public void setNumGridConnections(int numGridConnections)
	{
		this.numGridConnections = numGridConnections;
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
	
	public String getRunDirectory()
	{
		return runDirectory;
	}

	public void setRunDirectory(String runDirectory)
	{
		this.runDirectory = runDirectory;
	}

	public String getRunPrefix() {
		return runPrefix;
	}


	public void setRunPrefix(String runPrefix) {
		this.runPrefix = runPrefix;
	}

}
