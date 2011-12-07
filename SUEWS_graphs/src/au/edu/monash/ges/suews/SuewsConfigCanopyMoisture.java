package au.edu.monash.ges.suews;

public class SuewsConfigCanopyMoisture
{
	
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "CanopyMoistureInput";
	public final String FILENAME_SUFFUX = ".nml";
	
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;
	
	
	public SuewsConfigCanopyMoisture(String runDirectory, int year, String runPrefix)
	{
		super();
		this.runDirectory = runDirectory;		
		this.year = year;
		this.runPrefix = runPrefix;		
		
		this.filename = generateFilename(runPrefix, year);		
		setFileText(generateConfigFileText(runPrefix, year));
		
	}
	
	private String generateConfigFileText(String runPrefix, int year)
	{
		StringBuffer st = new StringBuffer();

		st.append("&CanopyMoistureInput" + '\n');
		st.append("PavedtoRunOff=1" + '\n');
		st.append("PavedtoConif=0" + '\n');
		st.append("PavedtoDecid=0" + '\n');
		st.append("PavedtoIrrGrass=0" + '\n');
		st.append("PavedtoUnirrGrass=0" + '\n');
		st.append("PavedtoWater=0" + '\n');
		st.append("BuildtoRunOff=0.8" + '\n');
		st.append("BuildtoPaved=0.15" + '\n');
		st.append("BuildtoConif=0.01" + '\n');
		st.append("BuildtoDecid=0" + '\n');
		st.append("BuildtoIrrGrass=0.02" + '\n');
		st.append("BuildtoUnIrrGrass=0.02" + '\n');
		st.append("BuildtoWater=0" + '\n');
		st.append("ConiftoSoil=1" + '\n');
		st.append("ConiftoPaved=0" + '\n');
		st.append("ConiftoDecid=0" + '\n');
		st.append("ConiftoIrrGrass=0" + '\n');
		st.append("ConiftoUnirrGrass=0" + '\n');
		st.append("ConiftoWater=0" + '\n');
		st.append("DecidtoSoil=1" + '\n');
		st.append("DecidtoPaved=0" + '\n');
		st.append("DecidtoConif=0" + '\n');
		st.append("DecidtoIrrGrass=0" + '\n');
		st.append("DecidtoUnirrGrass=0" + '\n');
		st.append("DecidtoWater=0" + '\n');
		st.append("IrrGrasstoSoil=1" + '\n');
		st.append("IrrGrasstoPaved=0" + '\n');
		st.append("IrrGrasstoConif=0" + '\n');
		st.append("IrrGrasstoDecid=0" + '\n');
		st.append("IrrGrasstoUnirrGrass=0" + '\n');
		st.append("IrrGrasstoWater=0" + '\n');
		st.append("UnirrGrasstoSoil=1" + '\n');
		st.append("UnirrGrasstoPaved=0" + '\n');
		st.append("UnirrGrasstoConif=0" + '\n');
		st.append("UnirrGrasstoDecid=0" + '\n');
		st.append("UnirrGrasstoIrrGrass=0" + '\n');
		st.append("UnirrGrasstoWater=0" + '\n');
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
