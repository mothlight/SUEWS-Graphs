package au.edu.monash.ges.suews;

public class SuewsConfigOHM
{
	
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "";
	public final String FILENAME_SUFFUX = ".OHM";
	
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;
	


	public SuewsConfigOHM(String runDirectory, int year, String runPrefix)
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
		st.append("#" +
				runPrefix +
				".ohm" + '\n');
		st.append("   2	   Canyons included: [1] Y [2] N " + '\n');
		st.append("   2     Vegetation as one [1] Y [2] Separate grass/trees&shrubs/water  " + '\n');                          
		st.append("   3     Vegetation: [3] Short Grass" + '\n');
		st.append("   4                 [4] Bare soil" + '\n');
		st.append("   0                                             " + '\n');               
		st.append("   1     Roof [1] Mean of all " + '\n');                                                                        
		st.append("   2     Impervious as one [1] Y [2] Concrete & asphalt separate    " + '\n');                              
		st.append("   2                       " + '\n');                                           
		st.append("   4" + '\n');
		st.append("   0 " + '\n');
			
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
