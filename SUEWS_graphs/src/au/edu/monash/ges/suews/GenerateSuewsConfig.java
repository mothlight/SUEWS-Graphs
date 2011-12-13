package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.print.DocFlavor.INPUT_STREAM;

public class GenerateSuewsConfig
{
	ENVICommon common = new ENVICommon();
	SuewsConfigValues suewsConfigValues = new SuewsConfigValues();
	final String INPUT_DIRECTORY = "Input";
	final String OUTPUT_DIRECTORY = "Output";
	private String outputDirectory;
	private String inputDirectory;
	
	private String runPrefix;
	private String runDirectory;
	private int numYears;
	private int startingYear;
	private int numGridConnections;

	

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		GenerateSuewsConfig generateConfig = new GenerateSuewsConfig();
		
//		int numGridConnections = 1;
//		String runPrefix = "Pr3714";
//		String runDirectory = "/tmp/SUEWS_tmp/";
//		int numYears = 1;
//		int startingYear = 2004;
//		
//		
//		generateConfig.processConfig();
	}
	
	public void processConfig()
	{
		
		
		this.inputDirectory = runDirectory + INPUT_DIRECTORY;
		this.outputDirectory = runDirectory + OUTPUT_DIRECTORY;
		common.createDirectory(this.outputDirectory);
		common.createDirectory(this.inputDirectory);
		

		SuewsConfigModelledYears yearConfig = new SuewsConfigModelledYears(runDirectory, numYears, startingYear);
		//System.out.println (config.getFileText());
		yearConfig.writeConfigFile();
		
		for (int i=0;i<numYears;i++)
		{
			int configYear = startingYear + i;
					
			SuewsConfigGridConnections gridConnections = new SuewsConfigGridConnections(runDirectory, configYear, runPrefix, numGridConnections);
			gridConnections.writeConfigFile();
			
			SuewsConfigHeaderInput headerInputConfig = new SuewsConfigHeaderInput(runDirectory, configYear, runPrefix);
			headerInputConfig.writeConfigFile();
			
			SuewsConfigCanopyMoisture canopyMoistureConfig = new SuewsConfigCanopyMoisture(runDirectory, configYear, runPrefix);
			canopyMoistureConfig.writeConfigFile(INPUT_DIRECTORY);
			
			SuewsConfigGIS gisConfig = new SuewsConfigGIS(runDirectory, configYear, runPrefix);
			
			gisConfig.setBuildingPercentage(suewsConfigValues.getGisConfigBuildingPercentage());
			gisConfig.setPavedPercentage(suewsConfigValues.getGisConfigPavedPercentage());
			gisConfig.setUnmanPercentage(suewsConfigValues.getGisConfigUnmanPercentage());
			gisConfig.setConPercentage(suewsConfigValues.getGisConfigConPercentage());
			gisConfig.setDecPercentage(suewsConfigValues.getGisConfigDecPercentage());
			gisConfig.setGrassPercentage(suewsConfigValues.getGisConfigGrassPercentage());
			gisConfig.setIrrGrassPercentage(suewsConfigValues.getGisConfigIrrGrassPercentage());
			gisConfig.generateFile();
			gisConfig.writeConfigFile(INPUT_DIRECTORY);
			
			SuewsConfigOHM ohmConfig = new SuewsConfigOHM(runDirectory, configYear, runPrefix);
			ohmConfig.generateFile();
			ohmConfig.writeConfigFile(INPUT_DIRECTORY);		
			
			SuewsConfigSahp sahpConfig = new SuewsConfigSahp(runDirectory, configYear, runPrefix);
			sahpConfig.generateFile();
			sahpConfig.writeConfigFile(INPUT_DIRECTORY);	
			
			SuewsConfigSuewsInput suewsInputConfig = new SuewsConfigSuewsInput(runDirectory, configYear, runPrefix);
			suewsInputConfig.generateFile();
			suewsInputConfig.writeConfigFile(INPUT_DIRECTORY);
			
			SuewsConfigWaterUseProfile waterUseProfileConfig = new SuewsConfigWaterUseProfile(runDirectory, configYear, runPrefix);
			waterUseProfileConfig.generateFile();
			waterUseProfileConfig.writeConfigFile(INPUT_DIRECTORY);
			
			
			SuewsConfigWeatherData weatherDataConfig = new SuewsConfigWeatherData(runDirectory, configYear, runPrefix);
			PrestonWeatherData weatherData = new PrestonWeatherData();
			ArrayList<TreeMap<String,String>> dataForYear = weatherData.getPrestonData(configYear);
			weatherDataConfig.setDataForYear(dataForYear);
			weatherDataConfig.generateFile();
			weatherDataConfig.writeConfigFile(INPUT_DIRECTORY);	
			
			
		}
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

	public int getNumGridConnections()
	{
		return numGridConnections;
	}

	public void setNumGridConnections(int numGridConnections)
	{
		this.numGridConnections = numGridConnections;
	}
	
	

}
