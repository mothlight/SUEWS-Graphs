package au.edu.monash.ges.suews;

public class SuewsConfigSuewsInput
{
	
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "SUEWSInput";
	public final String FILENAME_SUFFUX = ".nml";
	
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;

	public SuewsConfigSuewsInput(String runDirectory, int year, String runPrefix)
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
		
		
		st.append("&SUEWSInput" + '\n');
		st.append("BldgStorCap=0.25" + '\n');
		st.append("BldgDrainCoef1=10" + '\n');
		st.append("BldgDrainCoef2=3" + '\n');
		st.append("BldgState=0" + '\n');
		st.append("ConifStorCap=1.3" + '\n');
		st.append("ConifDrainCoef1=0.013" + '\n');
		st.append("ConifDrainCoef2=1.71" + '\n');
		st.append("ConifState=0" + '\n');
		st.append("DecidStorCap=0.3" + '\n');
		st.append("DecidDrainCoef1=0.013" + '\n');
		st.append("DecidDrainCoef2=1.71" + '\n');
		st.append("DecidState=0" + '\n');
		st.append("FlowChange=0" + '\n');
		st.append("G1=16.4764" + '\n');
		st.append("G2=566.0923" + '\n');
		st.append("G3=0.2163" + '\n');
		st.append("G4=3.3649" + '\n');
		st.append("G5=11.0764" + '\n');
		st.append("G6=0.0176" + '\n');
		st.append("GrassUStorCap=1.9" + '\n');
		st.append("GrassUDrainCoef1=0.013" + '\n');
		st.append("GrassUDrainCoef2=1.71" + '\n');
		st.append("GrassUState=0" + '\n');
		st.append("GrassIStorCap=1.9" + '\n');
		st.append("GrassIDrainCoef1=10" + '\n');
		st.append("GrassIDrainCoef2=3" + '\n');
		st.append("GrassIState=0" + '\n');
		st.append("SatHydraulicConduct=0.0005" + '\n');
		st.append("InternalWaterUse=0" + '\n');
		st.append("Kmax=1200" + '\n');
		st.append("PavStorCap=0.48" + '\n');
		st.append("PavDrainCoef1=10" + '\n');
		st.append("PavDrainCoef2=3" + '\n');
		st.append("PavState=0" + '\n');
		st.append("PipeCapacity=700 !in mm" + '\n');
		st.append("RunoffToWater=0.1" + '\n');
		st.append("RoughLen_heat=2" + '\n');
		st.append("S1=0.45" + '\n');
		st.append("S2=15" + '\n');
		st.append("SDECStor=0.8" + '\n');
		st.append("SmCap=0.6" + '\n');
		st.append("smd_choice=0" + '\n');
		st.append("sm_input=1" + '\n');
		st.append("SoilDensity=0.94" + '\n');
		st.append("SoilDepth=250" + '\n');
		st.append("SoilDepthMeas=50" + '\n');
		st.append("SoilRocks=1" + '\n');
		st.append("soilstorePav=100" + '\n');
		st.append("soilstoreBldg=70" + '\n');
		st.append("soilstorePavstate=95" + '\n');
		st.append("soilstoreBldgstate=65" + '\n');
		st.append("soilstoreConif=150" + '\n');
		st.append("soilstoreDec=150" + '\n');
		st.append("soilstoreGrass=150" + '\n');
		st.append("soilstoreConifstate=140" + '\n');
		st.append("soilstoreDecstate=140" + '\n');
		st.append("soilstoreGrassUnirstate=140" + '\n');
		st.append("soilstoreGrassirrstate=140" + '\n');
		st.append("StabilityMethod=2" + '\n');
		st.append("SurfaceArea=100" + '\n');
		st.append("TH=40" + '\n');
		st.append("TL=0.0" + '\n');
		st.append("Tstep=300" + '\n');
		st.append("WaterUseArea=100" + '\n');
		st.append("WaterState=20000" + '\n');
		st.append("WaterStorCap=30000 !max storage cap." + '\n');
		st.append("write5min=1" + '\n');
		st.append("WU_choice=1" + '\n');
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
