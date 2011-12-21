package au.edu.monash.ges.suews;

public class SuewsConfigGIS
{
	
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "";
	public final String FILENAME_SUFFUX = ".gis";
	
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;
	
	private double buildingPercentage;
	private double pavedPercentage;
	private double unmanPercentage;
	private double conPercentage;
	private double decPercentage;
	private double grassPercentage;
	private double irrGrassPercentage;
	
	private int id;
	private int it;
	private int qual;
	private double water;
	private double cany3d;
	private double ROOF3D;
	private double z0m;
	private double zd;
	private double planF;
	private double planTr;
	

	public SuewsConfigGIS(String runDirectory, int year, String runPrefix)
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

		st.append("id  it  qual   build     Paved   unman  con   dec     grass    IrrGrass  water  cany3d  ROOF3D  z0m      zd     planF   planTr  " + '\n');
		st.append("" +
				getId() +
				"    " +
				getIt() +
				"    " +
				getQual() +
				"    " +
				getBuildingPercentage() +
				"    " +
				getPavedPercentage() +
				"    " +
				getUnmanPercentage() +
				"    " +
				getConPercentage() +
				"    " +
				getDecPercentage() +
				"    " +
				getGrassPercentage() +
				"    " +
				getIrrGrassPercentage() +
				"    " +
				getWater() +
				"    " +
				getCany3d() +
				"    " +
				getROOF3D() +
				"    " +
				getZ0m() +
				"    " +
				getZd() +
				"    " +
				getPlanF() +
				"    " +
				getPlanTr() +
				"" + '\n');

	
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
	
	public double getBuildingPercentage()
	{
		return buildingPercentage;
	}

	public void setBuildingPercentage(double buildingPercentage)
	{
		this.buildingPercentage = buildingPercentage;
	}
	
	public double getPavedPercentage()
	{
		return pavedPercentage;
	}

	public void setPavedPercentage(double pavedPercentage)
	{
		this.pavedPercentage = pavedPercentage;
	}

	public double getUnmanPercentage()
	{
		return unmanPercentage;
	}

	public void setUnmanPercentage(double unmanPercentage)
	{
		this.unmanPercentage = unmanPercentage;
	}

	public double getConPercentage()
	{
		return conPercentage;
	}

	public void setConPercentage(double conPercentage)
	{
		this.conPercentage = conPercentage;
	}

	public double getDecPercentage()
	{
		return decPercentage;
	}

	public void setDecPercentage(double decPercentage)
	{
		this.decPercentage = decPercentage;
	}

	public double getGrassPercentage()
	{
		return grassPercentage;
	}

	public void setGrassPercentage(double grassPercentage)
	{
		this.grassPercentage = grassPercentage;
	}
	
	public double getIrrGrassPercentage()
	{
		return irrGrassPercentage;
	}

	public void setIrrGrassPercentage(double irrGrassPercentage)
	{
		this.irrGrassPercentage = irrGrassPercentage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}

	public int getQual() {
		return qual;
	}

	public void setQual(int qual) {
		this.qual = qual;
	}

	public double getWater() {
		return water;
	}

	public void setWater(double water) {
		this.water = water;
	}

	public double getCany3d() {
		return cany3d;
	}

	public void setCany3d(double cany3d) {
		this.cany3d = cany3d;
	}

	public double getROOF3D() {
		return ROOF3D;
	}

	public void setROOF3D(double rOOF3D) {
		ROOF3D = rOOF3D;
	}

	public double getZ0m() {
		return z0m;
	}

	public void setZ0m(double z0m) {
		this.z0m = z0m;
	}

	public double getZd() {
		return zd;
	}

	public void setZd(double zd) {
		this.zd = zd;
	}

	public double getPlanF() {
		return planF;
	}

	public void setPlanF(double planF) {
		this.planF = planF;
	}

	public double getPlanTr() {
		return planTr;
	}

	public void setPlanTr(double planTr) {
		this.planTr = planTr;
	}	

}
