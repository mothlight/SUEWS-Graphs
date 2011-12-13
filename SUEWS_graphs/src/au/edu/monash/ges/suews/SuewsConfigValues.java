package au.edu.monash.ges.suews;

import java.util.TreeMap;

public class SuewsConfigValues
{
	
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
	private String prestonWeatherDataDataTable;
	private String suewsConfigSuewsInputWUChoice;

	public SuewsConfigValues()
	{
		super();
		setConfigValues();
	}

	public void setConfigValues()
	{
		//setSuewsConfigSuewsInputWUChoice("1");
		setSuewsConfigSuewsInputWUChoice("0");
		
		
		prestonExternalWaterHourlyWeighings = new TreeMap<String, Double>();
		prestonExternalWaterHourlyWeighings.put("01", .25);
		prestonExternalWaterHourlyWeighings.put("02", .25);
		prestonExternalWaterHourlyWeighings.put("03", .25);
		prestonExternalWaterHourlyWeighings.put("22", .25);
		setPrestonExternalWaterMultiplier(1.0);
		//setPrestonWeatherDataDataTable("Preston_data");
		setPrestonWeatherDataDataTable("Mawson_Lakes_data");
		
		setGisConfigBuildingPercentage(0.4500);
		setGisConfigPavedPercentage(0.1800);
		setGisConfigUnmanPercentage(0.0100);
		setGisConfigConPercentage(0.115);
		setGisConfigDecPercentage(0.115);
		setGisConfigGrassPercentage(0.075);
		setGisConfigIrrGrassPercentage(0.075);
		
		setPrestonExternalWaterHourlyWeighings(prestonExternalWaterHourlyWeighings);
		setNumGridConnections(1);
		//setRunPrefix("Pr3714");
		setRunPrefix("Ml3714");
		setRunDirectory("/tmp/SUEWS_" + runPrefix + "/");
		setNumYears(1);
		//setStartingYear(2004);
		setStartingYear(2011);
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

}
