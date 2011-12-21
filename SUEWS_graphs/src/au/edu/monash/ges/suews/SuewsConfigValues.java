package au.edu.monash.ges.suews;

import java.util.TreeMap;

public class SuewsConfigValues
{
	
	public SuewsConfigValues()
	{
		super();
		setConfigValues();
	}

	public void setConfigValues()	
	{
		setDefaultValues();
		
		setRun(PRESTON_RUN);
				
		if (run.equals(PRESTON_RUN))
		{
			setSuewsConfigSuewsInputWUChoice("1");
			setPrestonWeatherDataDataTable("Preston_data");
			prestonExternalWaterHourlyWeighings = new TreeMap<String, Double>();
			prestonExternalWaterHourlyWeighings.put("01", .25);
			prestonExternalWaterHourlyWeighings.put("02", .25);
			prestonExternalWaterHourlyWeighings.put("03", .25);
			prestonExternalWaterHourlyWeighings.put("22", .25);
			setPrestonExternalWaterMultiplier(1.0);
			
			setGisConfigBuildingPercentage(0.4500);
			setGisConfigPavedPercentage(0.1800);
			setGisConfigUnmanPercentage(0.0100);
			setGisConfigConPercentage(0.115);
			setGisConfigDecPercentage(0.115);
			setGisConfigGrassPercentage(0.075);
			setGisConfigIrrGrassPercentage(0.075);
			
			setPrestonExternalWaterHourlyWeighings(prestonExternalWaterHourlyWeighings);
			setNumGridConnections(1);
			setRunPrefix("Pr3714");			
			setRunDirectory("/tmp/SUEWS_" + runPrefix + "/");
			setNumYears(1);
			setStartingYear(2004);
		}
		
		if (run.equals(MAWSON_RUN))
		{			
			setSuewsConfigSuewsInputWUChoice("0");
			
			setPrestonWeatherDataDataTable("Mawson_Lakes_data");
			//setPrestonWeatherDataDataTable("Preston_data");
			prestonExternalWaterHourlyWeighings = new TreeMap<String, Double>();
			prestonExternalWaterHourlyWeighings.put("01", .25);
			prestonExternalWaterHourlyWeighings.put("02", .25);
			prestonExternalWaterHourlyWeighings.put("03", .25);
			prestonExternalWaterHourlyWeighings.put("22", .25);
			setPrestonExternalWaterHourlyWeighings(prestonExternalWaterHourlyWeighings);
			setPrestonExternalWaterMultiplier(1.0);
			
			setGisConfigBuildingPercentage(0.4500);
			setGisConfigPavedPercentage(0.1800);
			setGisConfigUnmanPercentage(0.0100);
			setGisConfigConPercentage(0.115);
			setGisConfigDecPercentage(0.115);
			setGisConfigGrassPercentage(0.075);
			setGisConfigIrrGrassPercentage(0.075);
						
			setNumGridConnections(1);
			setRunPrefix("Ml3714");
			setRunDirectory("/tmp/SUEWS_" + runPrefix + "/");
			setNumYears(1);
			setStartingYear(2011);
			//setStartingYear(2004);
		}
		
		
		

		
	}
	
	private TreeMap <String, Double> prestonExternalWaterHourlyWeighings;
	private double prestonExternalWaterMultiplier;
	private int numGridConnections ;
	private String runPrefix ;
	private String runDirectory;
	private int numYears ;
	private int startingYear ;
	
	private Double gisConfigBuildingPercentage;
	private Double gisConfigPavedPercentage;
	private Double gisConfigUnmanPercentage;
	private Double gisConfigConPercentage;
	private Double gisConfigDecPercentage;
	private Double gisConfigGrassPercentage;
	private Double gisConfigIrrGrassPercentage;
	
	private int gisConfigId;
	private int gisConfigIt;
	private int gisConfigQual;
	private double gisConfigWater;
	private double gisConfigCany3d;
	private double gisConfigROOF3D;
	private double gisConfigz0m;
	private double gisConfigzd;
	private double gisConfigPlanF;
	private double gisConfigPlanTr;
	
	private double canopyConfigPavedtoRunOff=1;
	private double canopyConfigPavedtoConif=0;
	private double canopyConfigPavedtoDecid=0;
	private double canopyConfigPavedtoIrrGrass=0;
	private double canopyConfigPavedtoUnirrGrass=0;
	private double canopyConfigPavedtoWater=0;
	private double canopyConfigBuildtoRunOff=0.8;
	private double canopyConfigBuildtoPaved=0.15;
	private double canopyConfigBuildtoConif=0.01;
	private double canopyConfigBuildtoDecid=0;
	private double canopyConfigBuildtoIrrGrass=0.02;
	private double canopyConfigBuildtoUnIrrGrass=0.02;
	private double canopyConfigBuildtoWater=0;
	private double canopyConfigConiftoSoil=1;
	private double canopyConfigConiftoPaved=0;
	private double canopyConfigConiftoDecid=0;
	private double canopyConfigConiftoIrrGrass=0;
	private double canopyConfigConiftoUnirrGrass=0;
	private double canopyConfigConiftoWater=0;
	private double canopyConfigDecidtoSoil=1;
	private double canopyConfigDecidtoPaved=0;
	private double canopyConfigDecidtoConif=0;
	private double canopyConfigDecidtoIrrGrass=0;
	private double canopyConfigDecidtoUnirrGrass=0;
	private double canopyConfigDecidtoWater=0;
	private double canopyConfigIrrGrasstoSoil=1;
	private double canopyConfigIrrGrasstoPaved=0;
	private double canopyConfigIrrGrasstoConif=0;
	private double canopyConfigIrrGrasstoDecid=0;
	private double canopyConfigIrrGrasstoUnirrGrass=0;
	private double canopyConfigIrrGrasstoWater=0;
	private double canopyConfigUnirrGrasstoSoil=1;
	private double canopyConfigUnirrGrasstoPaved=0;
	private double canopyConfigUnirrGrasstoConif=0;
	private double canopyConfigUnirrGrasstoDecid=0;
	private double canopyConfigUnirrGrasstoIrrGrass=0;
	private double canopyConfigUnirrGrasstoWater=0;
	
	
	private String prestonWeatherDataDataTable;
	private String suewsConfigSuewsInputWUChoice;
	public final String PRESTON_RUN="Preston";
	public final String MAWSON_RUN="Mawson";
	private String run;	
	
	public void setDefaultValues()
	{
		setGisConfigId(3);
		setGisConfigIt(3);
		setGisConfigQual(1);
		
		setGisConfigBuildingPercentage(0.4864);
		setGisConfigPavedPercentage(0.4154);
		setGisConfigUnmanPercentage(0.0);
		setGisConfigConPercentage(0.0);
		setGisConfigDecPercentage(0.0123);
		setGisConfigGrassPercentage(0.0172);
		setGisConfigIrrGrassPercentage(0.0687);
		
		setGisConfigWater(0.0);
		setGisConfigCany3d(-999);
		setGisConfigROOF3D(-999);
		setGisConfigz0m(-999);
		setGisConfigzd(-999);
		setGisConfigPlanF(-999);
		setGisConfigPlanTr(-999);
		
		
		canopyConfigPavedtoRunOff=1;
		canopyConfigPavedtoConif=0;
		canopyConfigPavedtoDecid=0;
		canopyConfigPavedtoIrrGrass=0;
		canopyConfigPavedtoUnirrGrass=0;
		canopyConfigPavedtoWater=0;
		canopyConfigBuildtoRunOff=0.8;
		canopyConfigBuildtoPaved=0.15;
		canopyConfigBuildtoConif=0.01;
		canopyConfigBuildtoDecid=0;
		canopyConfigBuildtoIrrGrass=0.02;
		canopyConfigBuildtoUnIrrGrass=0.02;
		canopyConfigBuildtoWater=0;
		canopyConfigConiftoSoil=1;
		canopyConfigConiftoPaved=0;
		canopyConfigConiftoDecid=0;
		canopyConfigConiftoIrrGrass=0;
		canopyConfigConiftoUnirrGrass=0;
		canopyConfigConiftoWater=0;
		canopyConfigDecidtoSoil=1;
		canopyConfigDecidtoPaved=0;
		canopyConfigDecidtoConif=0;
		canopyConfigDecidtoIrrGrass=0;
		canopyConfigDecidtoUnirrGrass=0;
		canopyConfigDecidtoWater=0;
		canopyConfigIrrGrasstoSoil=1;
		canopyConfigIrrGrasstoPaved=0;
		canopyConfigIrrGrasstoConif=0;
		canopyConfigIrrGrasstoDecid=0;
		canopyConfigIrrGrasstoUnirrGrass=0;
		canopyConfigIrrGrasstoWater=0;
		canopyConfigUnirrGrasstoSoil=1;
		canopyConfigUnirrGrasstoPaved=0;
		canopyConfigUnirrGrasstoConif=0;
		canopyConfigUnirrGrasstoDecid=0;
		canopyConfigUnirrGrasstoIrrGrass=0;
		canopyConfigUnirrGrasstoWater=0;
		
		
	}
	

	public TreeMap<String, Double> getPrestonExternalWaterHourlyWeighings()
	{
		return prestonExternalWaterHourlyWeighings;
	}

	public void setPrestonExternalWaterHourlyWeighings(
			TreeMap<String, Double> prestonExternalWaterHourlyWeighings)
	{
		this.prestonExternalWaterHourlyWeighings = prestonExternalWaterHourlyWeighings;
	}

	public int getNumGridConnections()
	{
		return numGridConnections;
	}

	public void setNumGridConnections(int numGridConnections)
	{
		this.numGridConnections = numGridConnections;
	}

	public String getRunPrefix()
	{
		return runPrefix;
	}

	public void setRunPrefix(String runPrefix)
	{
		this.runPrefix = runPrefix;
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
		return numYears;
	}

	public void setNumYears(int numYears)
	{
		this.numYears = numYears;
	}

	public int getStartingYear()
	{
		return startingYear;
	}

	public void setStartingYear(int startingYear)
	{
		this.startingYear = startingYear;
	}

	public Double getGisConfigBuildingPercentage()
	{
		return gisConfigBuildingPercentage;
	}

	public Double getGisConfigPavedPercentage()
	{
		return gisConfigPavedPercentage;
	}

	public Double getGisConfigUnmanPercentage()
	{
		return gisConfigUnmanPercentage;
	}

	public Double getGisConfigConPercentage()
	{
		return gisConfigConPercentage;
	}

	public Double getGisConfigDecPercentage()
	{
		return gisConfigDecPercentage;
	}

	public Double getGisConfigGrassPercentage()
	{
		return gisConfigGrassPercentage;
	}

	public Double getGisConfigIrrGrassPercentage()
	{
		return gisConfigIrrGrassPercentage;
	}

	public void setGisConfigBuildingPercentage(Double gisConfigBuildingPercentage)
	{
		this.gisConfigBuildingPercentage = gisConfigBuildingPercentage;
	}

	public void setGisConfigPavedPercentage(Double gisConfigPavedPercentage)
	{
		this.gisConfigPavedPercentage = gisConfigPavedPercentage;
	}

	public void setGisConfigUnmanPercentage(Double gisConfigUnmanPercentage)
	{
		this.gisConfigUnmanPercentage = gisConfigUnmanPercentage;
	}

	public void setGisConfigConPercentage(Double gisConfigConPercentage)
	{
		this.gisConfigConPercentage = gisConfigConPercentage;
	}

	public void setGisConfigDecPercentage(Double gisConfigDecPercentage)
	{
		this.gisConfigDecPercentage = gisConfigDecPercentage;
	}

	public void setGisConfigGrassPercentage(Double gisConfigGrassPercentage)
	{
		this.gisConfigGrassPercentage = gisConfigGrassPercentage;
	}

	public void setGisConfigIrrGrassPercentage(Double gisConfigIrrGrassPercentage)
	{
		this.gisConfigIrrGrassPercentage = gisConfigIrrGrassPercentage;
	}

	public double getPrestonExternalWaterMultiplier()
	{
		return prestonExternalWaterMultiplier;
	}

	public void setPrestonExternalWaterMultiplier(
			double prestonExternalWaterMultiplier)
	{
		this.prestonExternalWaterMultiplier = prestonExternalWaterMultiplier;
	}

	public String getPrestonWeatherDataDataTable()
	{
		return prestonWeatherDataDataTable;
	}

	public void setPrestonWeatherDataDataTable(String prestonWeatherDataDataTable)
	{
		this.prestonWeatherDataDataTable = prestonWeatherDataDataTable;
	}

	public String getSuewsConfigSuewsInputWUChoice()
	{
		return suewsConfigSuewsInputWUChoice;
	}

	public void setSuewsConfigSuewsInputWUChoice(
			String suewsConfigSuewsInputWUChoice)
	{
		this.suewsConfigSuewsInputWUChoice = suewsConfigSuewsInputWUChoice;
	}

	public String getRun()
	{
		return run;
	}

	public void setRun(String run)
	{
		this.run = run;
	}

	public int getGisConfigId() {
		return gisConfigId;
	}

	public void setGisConfigId(int gisConfigId) {
		this.gisConfigId = gisConfigId;
	}

	public int getGisConfigIt() {
		return gisConfigIt;
	}

	public void setGisConfigIt(int gisConfigIt) {
		this.gisConfigIt = gisConfigIt;
	}

	public int getGisConfigQual() {
		return gisConfigQual;
	}

	public void setGisConfigQual(int gisConfigQual) {
		this.gisConfigQual = gisConfigQual;
	}

	public double getGisConfigWater() {
		return gisConfigWater;
	}

	public void setGisConfigWater(double gisConfigWater) {
		this.gisConfigWater = gisConfigWater;
	}

	public double getGisConfigCany3d() {
		return gisConfigCany3d;
	}

	public void setGisConfigCany3d(double gisConfigCany3d) {
		this.gisConfigCany3d = gisConfigCany3d;
	}

	public double getGisConfigROOF3D() {
		return gisConfigROOF3D;
	}

	public void setGisConfigROOF3D(double gisConfigROOF3D) {
		this.gisConfigROOF3D = gisConfigROOF3D;
	}

	public double getGisConfigz0m() {
		return gisConfigz0m;
	}

	public void setGisConfigz0m(double gisConfigz0m) {
		this.gisConfigz0m = gisConfigz0m;
	}

	public double getGisConfigzd() {
		return gisConfigzd;
	}

	public void setGisConfigzd(double gisConfigzd) {
		this.gisConfigzd = gisConfigzd;
	}

	public double getGisConfigPlanF() {
		return gisConfigPlanF;
	}

	public void setGisConfigPlanF(double gisConfigPlanF) {
		this.gisConfigPlanF = gisConfigPlanF;
	}

	public double getGisConfigPlanTr() {
		return gisConfigPlanTr;
	}

	public void setGisConfigPlanTr(double gisConfigPlanTr) {
		this.gisConfigPlanTr = gisConfigPlanTr;
	}

	public double getCanopyConfigPavedtoRunOff() {
		return canopyConfigPavedtoRunOff;
	}

	public void setCanopyConfigPavedtoRunOff(double canopyConfigPavedtoRunOff) {
		this.canopyConfigPavedtoRunOff = canopyConfigPavedtoRunOff;
	}

	public double getCanopyConfigPavedtoConif() {
		return canopyConfigPavedtoConif;
	}

	public void setCanopyConfigPavedtoConif(double canopyConfigPavedtoConif) {
		this.canopyConfigPavedtoConif = canopyConfigPavedtoConif;
	}

	public double getCanopyConfigPavedtoDecid() {
		return canopyConfigPavedtoDecid;
	}

	public void setCanopyConfigPavedtoDecid(double canopyConfigPavedtoDecid) {
		this.canopyConfigPavedtoDecid = canopyConfigPavedtoDecid;
	}

	public double getCanopyConfigPavedtoIrrGrass() {
		return canopyConfigPavedtoIrrGrass;
	}

	public void setCanopyConfigPavedtoIrrGrass(double canopyConfigPavedtoIrrGrass) {
		this.canopyConfigPavedtoIrrGrass = canopyConfigPavedtoIrrGrass;
	}

	public double getCanopyConfigPavedtoUnirrGrass() {
		return canopyConfigPavedtoUnirrGrass;
	}

	public void setCanopyConfigPavedtoUnirrGrass(
			double canopyConfigPavedtoUnirrGrass) {
		this.canopyConfigPavedtoUnirrGrass = canopyConfigPavedtoUnirrGrass;
	}

	public double getCanopyConfigPavedtoWater() {
		return canopyConfigPavedtoWater;
	}

	public void setCanopyConfigPavedtoWater(double canopyConfigPavedtoWater) {
		this.canopyConfigPavedtoWater = canopyConfigPavedtoWater;
	}

	public double getCanopyConfigBuildtoRunOff() {
		return canopyConfigBuildtoRunOff;
	}

	public void setCanopyConfigBuildtoRunOff(double canopyConfigBuildtoRunOff) {
		this.canopyConfigBuildtoRunOff = canopyConfigBuildtoRunOff;
	}

	public double getCanopyConfigBuildtoPaved() {
		return canopyConfigBuildtoPaved;
	}

	public void setCanopyConfigBuildtoPaved(double canopyConfigBuildtoPaved) {
		this.canopyConfigBuildtoPaved = canopyConfigBuildtoPaved;
	}

	public double getCanopyConfigBuildtoConif() {
		return canopyConfigBuildtoConif;
	}

	public void setCanopyConfigBuildtoConif(double canopyConfigBuildtoConif) {
		this.canopyConfigBuildtoConif = canopyConfigBuildtoConif;
	}

	public double getCanopyConfigBuildtoDecid() {
		return canopyConfigBuildtoDecid;
	}

	public void setCanopyConfigBuildtoDecid(double canopyConfigBuildtoDecid) {
		this.canopyConfigBuildtoDecid = canopyConfigBuildtoDecid;
	}

	public double getCanopyConfigBuildtoIrrGrass() {
		return canopyConfigBuildtoIrrGrass;
	}

	public void setCanopyConfigBuildtoIrrGrass(double canopyConfigBuildtoIrrGrass) {
		this.canopyConfigBuildtoIrrGrass = canopyConfigBuildtoIrrGrass;
	}

	public double getCanopyConfigBuildtoUnIrrGrass() {
		return canopyConfigBuildtoUnIrrGrass;
	}

	public void setCanopyConfigBuildtoUnIrrGrass(
			double canopyConfigBuildtoUnIrrGrass) {
		this.canopyConfigBuildtoUnIrrGrass = canopyConfigBuildtoUnIrrGrass;
	}

	public double getCanopyConfigBuildtoWater() {
		return canopyConfigBuildtoWater;
	}

	public void setCanopyConfigBuildtoWater(double canopyConfigBuildtoWater) {
		this.canopyConfigBuildtoWater = canopyConfigBuildtoWater;
	}

	public double getCanopyConfigConiftoSoil() {
		return canopyConfigConiftoSoil;
	}

	public void setCanopyConfigConiftoSoil(double canopyConfigConiftoSoil) {
		this.canopyConfigConiftoSoil = canopyConfigConiftoSoil;
	}

	public double getCanopyConfigConiftoPaved() {
		return canopyConfigConiftoPaved;
	}

	public void setCanopyConfigConiftoPaved(double canopyConfigConiftoPaved) {
		this.canopyConfigConiftoPaved = canopyConfigConiftoPaved;
	}

	public double getCanopyConfigConiftoDecid() {
		return canopyConfigConiftoDecid;
	}

	public void setCanopyConfigConiftoDecid(double canopyConfigConiftoDecid) {
		this.canopyConfigConiftoDecid = canopyConfigConiftoDecid;
	}

	public double getCanopyConfigConiftoIrrGrass() {
		return canopyConfigConiftoIrrGrass;
	}

	public void setCanopyConfigConiftoIrrGrass(double canopyConfigConiftoIrrGrass) {
		this.canopyConfigConiftoIrrGrass = canopyConfigConiftoIrrGrass;
	}

	public double getCanopyConfigConiftoUnirrGrass() {
		return canopyConfigConiftoUnirrGrass;
	}

	public void setCanopyConfigConiftoUnirrGrass(
			double canopyConfigConiftoUnirrGrass) {
		this.canopyConfigConiftoUnirrGrass = canopyConfigConiftoUnirrGrass;
	}

	public double getCanopyConfigConiftoWater() {
		return canopyConfigConiftoWater;
	}

	public void setCanopyConfigConiftoWater(double canopyConfigConiftoWater) {
		this.canopyConfigConiftoWater = canopyConfigConiftoWater;
	}

	public double getCanopyConfigDecidtoSoil() {
		return canopyConfigDecidtoSoil;
	}

	public void setCanopyConfigDecidtoSoil(double canopyConfigDecidtoSoil) {
		this.canopyConfigDecidtoSoil = canopyConfigDecidtoSoil;
	}

	public double getCanopyConfigDecidtoPaved() {
		return canopyConfigDecidtoPaved;
	}

	public void setCanopyConfigDecidtoPaved(double canopyConfigDecidtoPaved) {
		this.canopyConfigDecidtoPaved = canopyConfigDecidtoPaved;
	}

	public double getCanopyConfigDecidtoConif() {
		return canopyConfigDecidtoConif;
	}

	public void setCanopyConfigDecidtoConif(double canopyConfigDecidtoConif) {
		this.canopyConfigDecidtoConif = canopyConfigDecidtoConif;
	}

	public double getCanopyConfigDecidtoIrrGrass() {
		return canopyConfigDecidtoIrrGrass;
	}

	public void setCanopyConfigDecidtoIrrGrass(double canopyConfigDecidtoIrrGrass) {
		this.canopyConfigDecidtoIrrGrass = canopyConfigDecidtoIrrGrass;
	}

	public double getCanopyConfigDecidtoUnirrGrass() {
		return canopyConfigDecidtoUnirrGrass;
	}

	public void setCanopyConfigDecidtoUnirrGrass(
			double canopyConfigDecidtoUnirrGrass) {
		this.canopyConfigDecidtoUnirrGrass = canopyConfigDecidtoUnirrGrass;
	}

	public double getCanopyConfigDecidtoWater() {
		return canopyConfigDecidtoWater;
	}

	public void setCanopyConfigDecidtoWater(double canopyConfigDecidtoWater) {
		this.canopyConfigDecidtoWater = canopyConfigDecidtoWater;
	}

	public double getCanopyConfigIrrGrasstoSoil() {
		return canopyConfigIrrGrasstoSoil;
	}

	public void setCanopyConfigIrrGrasstoSoil(double canopyConfigIrrGrasstoSoil) {
		this.canopyConfigIrrGrasstoSoil = canopyConfigIrrGrasstoSoil;
	}

	public double getCanopyConfigIrrGrasstoPaved() {
		return canopyConfigIrrGrasstoPaved;
	}

	public void setCanopyConfigIrrGrasstoPaved(double canopyConfigIrrGrasstoPaved) {
		this.canopyConfigIrrGrasstoPaved = canopyConfigIrrGrasstoPaved;
	}

	public double getCanopyConfigIrrGrasstoConif() {
		return canopyConfigIrrGrasstoConif;
	}

	public void setCanopyConfigIrrGrasstoConif(double canopyConfigIrrGrasstoConif) {
		this.canopyConfigIrrGrasstoConif = canopyConfigIrrGrasstoConif;
	}

	public double getCanopyConfigIrrGrasstoDecid() {
		return canopyConfigIrrGrasstoDecid;
	}

	public void setCanopyConfigIrrGrasstoDecid(double canopyConfigIrrGrasstoDecid) {
		this.canopyConfigIrrGrasstoDecid = canopyConfigIrrGrasstoDecid;
	}

	public double getCanopyConfigIrrGrasstoUnirrGrass() {
		return canopyConfigIrrGrasstoUnirrGrass;
	}

	public void setCanopyConfigIrrGrasstoUnirrGrass(
			double canopyConfigIrrGrasstoUnirrGrass) {
		this.canopyConfigIrrGrasstoUnirrGrass = canopyConfigIrrGrasstoUnirrGrass;
	}

	public double getCanopyConfigIrrGrasstoWater() {
		return canopyConfigIrrGrasstoWater;
	}

	public void setCanopyConfigIrrGrasstoWater(double canopyConfigIrrGrasstoWater) {
		this.canopyConfigIrrGrasstoWater = canopyConfigIrrGrasstoWater;
	}

	public double getCanopyConfigUnirrGrasstoSoil() {
		return canopyConfigUnirrGrasstoSoil;
	}

	public void setCanopyConfigUnirrGrasstoSoil(double canopyConfigUnirrGrasstoSoil) {
		this.canopyConfigUnirrGrasstoSoil = canopyConfigUnirrGrasstoSoil;
	}

	public double getCanopyConfigUnirrGrasstoPaved() {
		return canopyConfigUnirrGrasstoPaved;
	}

	public void setCanopyConfigUnirrGrasstoPaved(
			double canopyConfigUnirrGrasstoPaved) {
		this.canopyConfigUnirrGrasstoPaved = canopyConfigUnirrGrasstoPaved;
	}

	public double getCanopyConfigUnirrGrasstoConif() {
		return canopyConfigUnirrGrasstoConif;
	}

	public void setCanopyConfigUnirrGrasstoConif(
			double canopyConfigUnirrGrasstoConif) {
		this.canopyConfigUnirrGrasstoConif = canopyConfigUnirrGrasstoConif;
	}

	public double getCanopyConfigUnirrGrasstoDecid() {
		return canopyConfigUnirrGrasstoDecid;
	}

	public void setCanopyConfigUnirrGrasstoDecid(
			double canopyConfigUnirrGrasstoDecid) {
		this.canopyConfigUnirrGrasstoDecid = canopyConfigUnirrGrasstoDecid;
	}

	public double getCanopyConfigUnirrGrasstoIrrGrass() {
		return canopyConfigUnirrGrasstoIrrGrass;
	}

	public void setCanopyConfigUnirrGrasstoIrrGrass(
			double canopyConfigUnirrGrasstoIrrGrass) {
		this.canopyConfigUnirrGrasstoIrrGrass = canopyConfigUnirrGrasstoIrrGrass;
	}

	public double getCanopyConfigUnirrGrasstoWater() {
		return canopyConfigUnirrGrasstoWater;
	}

	public void setCanopyConfigUnirrGrasstoWater(
			double canopyConfigUnirrGrasstoWater) {
		this.canopyConfigUnirrGrasstoWater = canopyConfigUnirrGrasstoWater;
	}

}
