package au.edu.monash.ges.suews;

public class LumpsConfigGridnames
{
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "LUMPS_GridNames";
	public final String FILENAME_SUFFUX = ".TXT";
	private int nroGrids;
	private int numDifferentOhm;
	private int numDifferentMet;
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;
	
	public static void main(String[] args)
	{
		int numGridConnections = 1;
		int numDifferentOhm = 0;
		int numDifferentMet = 0;
		String runPrefix = "Pl";
		int year = 04;
		String runDirectory = "/tmp/SUEWS_tmp/";
		LumpsConfigGridnames gridConnections = new LumpsConfigGridnames(runDirectory, year, runPrefix, numGridConnections, numDifferentOhm, numDifferentMet);
		gridConnections.generateFile();
		gridConnections.writeConfigFile();

	}
	
	
//	 1      !Number of grid connections listed below
//	 'Pr3714_2004'     0         'none'
//	 !From   fraction     To 

	
	
//	 3      !NroGrids: Number of modelled grids      
//	 0      !DifferentOhm: Different OHM file used for for the different runs ([0] no, [1] yes)
//	 0      !DifferentMet: Different meteorological input file used for for the different runs ([0] no, [1] yes)               
//	Ln09_X0001Y0021   
//	Ln09_X0001Y0027
//	Ln09_X0001Y0029   
	
	//but only supporting 1 grid
//	 1      !NroGrids: Number of modelled grids      
//	 0      !DifferentOhm: Different OHM file used for for the different runs ([0] no, [1] yes)
//	 0      !DifferentMet: Different meteorological input file used for for the different runs ([0] no, [1] yes)               
//	Ln09_X0001Y0001   
	
	
	public LumpsConfigGridnames(String runDirectory, int year, String runPrefix, int numGrids, int numDifferentOhm, int numDifferentMet)
	{
		super();
		this.runDirectory = runDirectory;
		this.year = year;
		this.nroGrids = numGrids;
		this.numDifferentOhm = numDifferentOhm;
		this.numDifferentMet = numDifferentMet;
		this.filename = generateFilename(year);		
		setRunPrefix(runPrefix);
		//setFileText(generateConfigFileText(year, runPrefix, numGridConnections));
	}
	
	private String generateFilename(int year)
	{
		return FILENAME_PREFIX + FILENAME_SUFFUX;
	}

	//only going to support one grid
	private String generateConfigFileText(int year, String runPrefix, int numGridConnections, int numDifferentOhm, int numDifferentMet)
	{
		StringBuffer st = new StringBuffer();
		
		//doesn't handle more grid connections yet
		st.append(" " +
				numGridConnections +
				"      !NroGrids: Number of modelled grids      " + '\n');
		
		st.append(" " +
				numDifferentOhm +
				"      !DifferentOhm: Different OHM file used for for the different runs ([0] no, [1] yes)" + '\n');		
		st.append(" " +
				numDifferentMet +
				"      !DifferentMet: Different meteorological input file used for for the different runs ([0] no, [1] yes)               " + '\n');			
		
		//String yearStr = common.padLeft(year, 2, '0'); 
		st.append(runPrefix + common.shortenYearTo2Digits(year) + "_X0001Y0001");
		st.append('\n');
		
		return st.toString();
	}
	
	public void generateFile()
	{
		setFileText(generateConfigFileText(year, runPrefix, nroGrids, numDifferentOhm, numDifferentMet));
	}
	
	public void writeConfigFile()
	{		
		common.createDirectory(runDirectory);
		common.writeFile(getFileText(), runDirectory + this.filename);
	}	
	

	public int getNumGrids()
	{
		return nroGrids;
	}


	public void setNumGrids(int numGridConnections)
	{
		this.nroGrids = numGridConnections;
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


	public int getNumDifferentOhm()
	{
		return numDifferentOhm;
	}


	public void setNumDifferentOhm(int numDifferentOhm)
	{
		this.numDifferentOhm = numDifferentOhm;
	}


	public int getNumDifferentMet()
	{
		return numDifferentMet;
	}


	public void setNumDifferentMet(int numDifferentMet)
	{
		this.numDifferentMet = numDifferentMet;
	}

}
