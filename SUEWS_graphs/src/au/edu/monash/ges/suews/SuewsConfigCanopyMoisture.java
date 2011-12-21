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
	
	
	private double PavedtoRunOff;
	private double PavedtoConif;
	private double PavedtoDecid;
	private double PavedtoIrrGrass;
	private double PavedtoUnirrGrass;
	private double PavedtoWater;
	private double BuildtoRunOff;
	private double BuildtoPaved;
	private double BuildtoConif;
	private double BuildtoDecid;
	private double BuildtoIrrGrass;
	private double BuildtoUnIrrGrass;
	private double BuildtoWater;
	private double ConiftoSoil;
	private double ConiftoPaved;
	private double ConiftoDecid;
	private double ConiftoIrrGrass;
	private double ConiftoUnirrGrass;
	private double ConiftoWater;
	private double DecidtoSoil;
	private double DecidtoPaved;
	private double DecidtoConif;
	private double DecidtoIrrGrass;
	private double DecidtoUnirrGrass;
	private double DecidtoWater;
	private double IrrGrasstoSoil;
	private double IrrGrasstoPaved;
	private double IrrGrasstoConif;
	private double IrrGrasstoDecid;
	private double IrrGrasstoUnirrGrass;
	private double IrrGrasstoWater;
	private double UnirrGrasstoSoil;
	private double UnirrGrasstoPaved;
	private double UnirrGrasstoConif;
	private double UnirrGrasstoDecid;
	private double UnirrGrasstoIrrGrass;
	private double UnirrGrasstoWater;
	
	
	
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
		st.append("PavedtoRunOff=" +
				getPavedtoRunOff() + '\n');
		st.append("PavedtoConif=" +
				getPavedtoConif() + '\n');
		st.append("PavedtoDecid=" +
				getPavedtoDecid() + '\n');
		st.append("PavedtoIrrGrass=" +
				getPavedtoIrrGrass()
				+ '\n');
		st.append("PavedtoUnirrGrass=" +
				getPavedtoUnirrGrass() + '\n');
		st.append("PavedtoWater=" +
				getPavedtoWater() + '\n');
		st.append("BuildtoRunOff=" +
				getBuildtoRunOff() + '\n');
		st.append("BuildtoPaved=" +
				getBuildtoPaved() + '\n');
		st.append("BuildtoConif=" +
				getBuildtoConif() + '\n');
		st.append("BuildtoDecid=" +
				getBuildtoDecid() + '\n');
		st.append("BuildtoIrrGrass=" +
				getBuildtoIrrGrass() + '\n');
		st.append("BuildtoUnIrrGrass=" +
				getBuildtoUnIrrGrass() + '\n');
		st.append("BuildtoWater=" +
				getBuildtoWater() + '\n');
		st.append("ConiftoSoil=" +
				getConiftoSoil() + '\n');
		st.append("ConiftoPaved=" +
				getConiftoPaved() + '\n');
		st.append("ConiftoDecid=" +
				getConiftoDecid() + '\n');
		st.append("ConiftoIrrGrass=" +
				getConiftoIrrGrass() + '\n');
		st.append("ConiftoUnirrGrass=" +
				getConiftoUnirrGrass() + '\n');
		st.append("ConiftoWater=" +
				getConiftoWater() + '\n');
		st.append("DecidtoSoil=" +
				getDecidtoSoil() + '\n');
		st.append("DecidtoPaved=" +
				getDecidtoPaved() + '\n');
		st.append("DecidtoConif=" +
				getDecidtoConif() + '\n');
		st.append("DecidtoIrrGrass=" +
				getDecidtoIrrGrass() + '\n');
		st.append("DecidtoUnirrGrass=" +
				getDecidtoUnirrGrass() + '\n');
		st.append("DecidtoWater=" +
				getDecidtoWater() + '\n');
		st.append("IrrGrasstoSoil=" +
				getIrrGrasstoSoil() + '\n');
		st.append("IrrGrasstoPaved=" +
				getIrrGrasstoPaved() + '\n');
		st.append("IrrGrasstoConif=" +
				getIrrGrasstoConif() + '\n');
		st.append("IrrGrasstoDecid=" +
				getIrrGrasstoDecid() + '\n');
		st.append("IrrGrasstoUnirrGrass=" +
				getIrrGrasstoUnirrGrass() + '\n');
		st.append("IrrGrasstoWater=" +
				getIrrGrasstoWater() + '\n');
		st.append("UnirrGrasstoSoil=" +
				getUnirrGrasstoSoil() + '\n');
		st.append("UnirrGrasstoPaved=" +
				getUnirrGrasstoPaved() + '\n');
		st.append("UnirrGrasstoConif=" +
				getUnirrGrasstoConif() + '\n');
		st.append("UnirrGrasstoDecid=" +
				getUnirrGrasstoDecid() + '\n');
		st.append("UnirrGrasstoIrrGrass=" +
				getUnirrGrasstoIrrGrass() + '\n');
		st.append("UnirrGrasstoWater=" +
				getUnirrGrasstoWater() + '\n');
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

	public double getPavedtoRunOff() {
		return PavedtoRunOff;
	}

	public void setPavedtoRunOff(double pavedtoRunOff) {
		PavedtoRunOff = pavedtoRunOff;
	}

	public double getPavedtoConif() {
		return PavedtoConif;
	}

	public void setPavedtoConif(double pavedtoConif) {
		PavedtoConif = pavedtoConif;
	}

	public double getPavedtoDecid() {
		return PavedtoDecid;
	}

	public void setPavedtoDecid(double pavedtoDecid) {
		PavedtoDecid = pavedtoDecid;
	}

	public double getPavedtoIrrGrass() {
		return PavedtoIrrGrass;
	}

	public void setPavedtoIrrGrass(double pavedtoIrrGrass) {
		PavedtoIrrGrass = pavedtoIrrGrass;
	}

	public double getPavedtoUnirrGrass() {
		return PavedtoUnirrGrass;
	}

	public void setPavedtoUnirrGrass(double pavedtoUnirrGrass) {
		PavedtoUnirrGrass = pavedtoUnirrGrass;
	}

	public double getPavedtoWater() {
		return PavedtoWater;
	}

	public void setPavedtoWater(double pavedtoWater) {
		PavedtoWater = pavedtoWater;
	}

	public double getBuildtoRunOff() {
		return BuildtoRunOff;
	}

	public void setBuildtoRunOff(double buildtoRunOff) {
		BuildtoRunOff = buildtoRunOff;
	}

	public double getBuildtoPaved() {
		return BuildtoPaved;
	}

	public void setBuildtoPaved(double buildtoPaved) {
		BuildtoPaved = buildtoPaved;
	}

	public double getBuildtoConif() {
		return BuildtoConif;
	}

	public void setBuildtoConif(double buildtoConif) {
		BuildtoConif = buildtoConif;
	}

	public double getBuildtoDecid() {
		return BuildtoDecid;
	}

	public void setBuildtoDecid(double buildtoDecid) {
		BuildtoDecid = buildtoDecid;
	}

	public double getBuildtoIrrGrass() {
		return BuildtoIrrGrass;
	}

	public void setBuildtoIrrGrass(double buildtoIrrGrass) {
		BuildtoIrrGrass = buildtoIrrGrass;
	}

	public double getBuildtoUnIrrGrass() {
		return BuildtoUnIrrGrass;
	}

	public void setBuildtoUnIrrGrass(double buildtoUnIrrGrass) {
		BuildtoUnIrrGrass = buildtoUnIrrGrass;
	}

	public double getBuildtoWater() {
		return BuildtoWater;
	}

	public void setBuildtoWater(double buildtoWater) {
		BuildtoWater = buildtoWater;
	}

	public double getConiftoSoil() {
		return ConiftoSoil;
	}

	public void setConiftoSoil(double coniftoSoil) {
		ConiftoSoil = coniftoSoil;
	}

	public double getConiftoPaved() {
		return ConiftoPaved;
	}

	public void setConiftoPaved(double coniftoPaved) {
		ConiftoPaved = coniftoPaved;
	}

	public double getConiftoDecid() {
		return ConiftoDecid;
	}

	public void setConiftoDecid(double coniftoDecid) {
		ConiftoDecid = coniftoDecid;
	}

	public double getConiftoIrrGrass() {
		return ConiftoIrrGrass;
	}

	public void setConiftoIrrGrass(double coniftoIrrGrass) {
		ConiftoIrrGrass = coniftoIrrGrass;
	}

	public double getConiftoUnirrGrass() {
		return ConiftoUnirrGrass;
	}

	public void setConiftoUnirrGrass(double coniftoUnirrGrass) {
		ConiftoUnirrGrass = coniftoUnirrGrass;
	}

	public double getConiftoWater() {
		return ConiftoWater;
	}

	public void setConiftoWater(double coniftoWater) {
		ConiftoWater = coniftoWater;
	}

	public double getDecidtoSoil() {
		return DecidtoSoil;
	}

	public void setDecidtoSoil(double decidtoSoil) {
		DecidtoSoil = decidtoSoil;
	}

	public double getDecidtoPaved() {
		return DecidtoPaved;
	}

	public void setDecidtoPaved(double decidtoPaved) {
		DecidtoPaved = decidtoPaved;
	}

	public double getDecidtoConif() {
		return DecidtoConif;
	}

	public void setDecidtoConif(double decidtoConif) {
		DecidtoConif = decidtoConif;
	}

	public double getDecidtoIrrGrass() {
		return DecidtoIrrGrass;
	}

	public void setDecidtoIrrGrass(double decidtoIrrGrass) {
		DecidtoIrrGrass = decidtoIrrGrass;
	}

	public double getDecidtoUnirrGrass() {
		return DecidtoUnirrGrass;
	}

	public void setDecidtoUnirrGrass(double decidtoUnirrGrass) {
		DecidtoUnirrGrass = decidtoUnirrGrass;
	}

	public double getDecidtoWater() {
		return DecidtoWater;
	}

	public void setDecidtoWater(double decidtoWater) {
		DecidtoWater = decidtoWater;
	}

	public double getIrrGrasstoSoil() {
		return IrrGrasstoSoil;
	}

	public void setIrrGrasstoSoil(double irrGrasstoSoil) {
		IrrGrasstoSoil = irrGrasstoSoil;
	}

	public double getIrrGrasstoPaved() {
		return IrrGrasstoPaved;
	}

	public void setIrrGrasstoPaved(double irrGrasstoPaved) {
		IrrGrasstoPaved = irrGrasstoPaved;
	}

	public double getIrrGrasstoConif() {
		return IrrGrasstoConif;
	}

	public void setIrrGrasstoConif(double irrGrasstoConif) {
		IrrGrasstoConif = irrGrasstoConif;
	}

	public double getIrrGrasstoDecid() {
		return IrrGrasstoDecid;
	}

	public void setIrrGrasstoDecid(double irrGrasstoDecid) {
		IrrGrasstoDecid = irrGrasstoDecid;
	}

	public double getIrrGrasstoUnirrGrass() {
		return IrrGrasstoUnirrGrass;
	}

	public void setIrrGrasstoUnirrGrass(double irrGrasstoUnirrGrass) {
		IrrGrasstoUnirrGrass = irrGrasstoUnirrGrass;
	}

	public double getIrrGrasstoWater() {
		return IrrGrasstoWater;
	}

	public void setIrrGrasstoWater(double irrGrasstoWater) {
		IrrGrasstoWater = irrGrasstoWater;
	}

	public double getUnirrGrasstoSoil() {
		return UnirrGrasstoSoil;
	}

	public void setUnirrGrasstoSoil(double unirrGrasstoSoil) {
		UnirrGrasstoSoil = unirrGrasstoSoil;
	}

	public double getUnirrGrasstoPaved() {
		return UnirrGrasstoPaved;
	}

	public void setUnirrGrasstoPaved(double unirrGrasstoPaved) {
		UnirrGrasstoPaved = unirrGrasstoPaved;
	}

	public double getUnirrGrasstoConif() {
		return UnirrGrasstoConif;
	}

	public void setUnirrGrasstoConif(double unirrGrasstoConif) {
		UnirrGrasstoConif = unirrGrasstoConif;
	}

	public double getUnirrGrasstoDecid() {
		return UnirrGrasstoDecid;
	}

	public void setUnirrGrasstoDecid(double unirrGrasstoDecid) {
		UnirrGrasstoDecid = unirrGrasstoDecid;
	}

	public double getUnirrGrasstoIrrGrass() {
		return UnirrGrasstoIrrGrass;
	}

	public void setUnirrGrasstoIrrGrass(double unirrGrasstoIrrGrass) {
		UnirrGrasstoIrrGrass = unirrGrasstoIrrGrass;
	}

	public double getUnirrGrasstoWater() {
		return UnirrGrasstoWater;
	}

	public void setUnirrGrasstoWater(double unirrGrasstoWater) {
		UnirrGrasstoWater = unirrGrasstoWater;
	}	

}
