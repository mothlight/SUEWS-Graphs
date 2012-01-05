package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.print.DocFlavor.INPUT_STREAM;

public class GenerateSuewsConfig
{
	ENVICommon common = new ENVICommon();
	//SuewsConfigValues suewsConfigValues = new SuewsConfigValues();
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
	
	public void processConfig(SuewsConfigValues suewsConfigValues)
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
			gridConnections.generateFile();
			gridConnections.writeConfigFile();	
			
			SuewsConfigHeaderInput headerInputConfig = new SuewsConfigHeaderInput(runDirectory, configYear, runPrefix);
			headerInputConfig.setALB1(suewsConfigValues.getALB1());
			headerInputConfig.setALB2(suewsConfigValues.getALB2());
			headerInputConfig.setALB3(suewsConfigValues.getALB3());
			headerInputConfig.setALB4(suewsConfigValues.getALB4());
			headerInputConfig.setALB5(suewsConfigValues.getALB5());
			headerInputConfig.setALB6(suewsConfigValues.getALB6());
			headerInputConfig.setALB7(suewsConfigValues.getALB7());
			headerInputConfig.setALB_SNOW(suewsConfigValues.getALB_SNOW());
			headerInputConfig.setAnthropHeatChoice(suewsConfigValues.getAnthropHeatChoice());
			headerInputConfig.setBaseT1(suewsConfigValues.getBaseT1());
			headerInputConfig.setBaseT2(suewsConfigValues.getBaseT2());
			headerInputConfig.setBaseT3(suewsConfigValues.getBaseT3());
			headerInputConfig.setBaseT4(suewsConfigValues.getBaseT4());
			headerInputConfig.setBaseTe1(suewsConfigValues.getBaseTe1());
			headerInputConfig.setBaseTe2(suewsConfigValues.getBaseTe2());
			headerInputConfig.setBaseTe3(suewsConfigValues.getBaseTe3());
			headerInputConfig.setBaseTe4(suewsConfigValues.getBaseTe4());
			headerInputConfig.setBaseTHDD(suewsConfigValues.getBaseTHDD());
			headerInputConfig.setBlgH(suewsConfigValues.getBlgH());
			headerInputConfig.setDayLightSavingDay1(suewsConfigValues.getDayLightSavingDay1());
			headerInputConfig.setDayLightSavingDay2(suewsConfigValues.getDayLightSavingDay2());
			headerInputConfig.setDefaultFcld(suewsConfigValues.getDefaultFcld());
			headerInputConfig.setDefaultPres(suewsConfigValues.getDefaultPres());
			headerInputConfig.setDefaultRH(suewsConfigValues.getDefaultRH());
			headerInputConfig.setDefaultT(suewsConfigValues.getDefaultT());
			headerInputConfig.setDefaultU(suewsConfigValues.getDefaultU());
			headerInputConfig.setDefaultQf(suewsConfigValues.getDefaultQf());
			headerInputConfig.setDefaultQs(suewsConfigValues.getDefaultQs());
			headerInputConfig.setDRAINRT(suewsConfigValues.getDRAINRT());
			headerInputConfig.setEMIS1(suewsConfigValues.getEMIS1());
			headerInputConfig.setEMIS2(suewsConfigValues.getEMIS2());
			headerInputConfig.setEMIS3(suewsConfigValues.getEMIS3());
			headerInputConfig.setEMIS4(suewsConfigValues.getEMIS4());
			headerInputConfig.setEMIS5(suewsConfigValues.getEMIS5());
			headerInputConfig.setEMIS6(suewsConfigValues.getEMIS6());
			headerInputConfig.setEMIS7(suewsConfigValues.getEMIS7());
			headerInputConfig.setEMIS_SNOW(suewsConfigValues.getEMIS_SNOW());
			headerInputConfig.setGDDFull1(suewsConfigValues.getGDDFull1());
			headerInputConfig.setGDDFull2(suewsConfigValues.getGDDFull2());
			headerInputConfig.setGDDFull3(suewsConfigValues.getGDDFull3());
			headerInputConfig.setGDDFull4(suewsConfigValues.getGDDFull4());
			headerInputConfig.setGISInputType(suewsConfigValues.getGISInputType());
			headerInputConfig.setINTERVAL(suewsConfigValues.getINTERVAL());
			headerInputConfig.setLAImax1(suewsConfigValues.getLAImax1());
			headerInputConfig.setLAImax2(suewsConfigValues.getLAImax2());
			headerInputConfig.setLAImax3(suewsConfigValues.getLAImax3());
			headerInputConfig.setLAImax4(suewsConfigValues.getLAImax4());
			headerInputConfig.setLAImin1(suewsConfigValues.getLAImin1());
			headerInputConfig.setLAImin2(suewsConfigValues.getLAImin2());
			headerInputConfig.setLAImin3(suewsConfigValues.getLAImin3());
			headerInputConfig.setLAImin4(suewsConfigValues.getLAImin4());
			headerInputConfig.setLat(suewsConfigValues.getLat());
			headerInputConfig.setLng(suewsConfigValues.getLng());
			headerInputConfig.setNARPOutput(suewsConfigValues.getNARPOutput());
			headerInputConfig.setNetRadiationChoice(suewsConfigValues.getNetRadiationChoice());
			headerInputConfig.setNumCapita(suewsConfigValues.getNumCapita());
			headerInputConfig.setLdown_option(suewsConfigValues.getLdown_option());		
			headerInputConfig.setQf_A1(suewsConfigValues.getQf_A1());
			headerInputConfig.setQf_A2(suewsConfigValues.getQf_A2());
			headerInputConfig.setQf_B1(suewsConfigValues.getQf_B1());
			headerInputConfig.setQf_B2(suewsConfigValues.getQf_B2());
			headerInputConfig.setQf_C1(suewsConfigValues.getQf_C1());
			headerInputConfig.setQf_C2(suewsConfigValues.getQf_C2());
			headerInputConfig.setQSChoice(suewsConfigValues.getQSChoice());
			headerInputConfig.setRAINCOVER(suewsConfigValues.getRAINCOVER());
			headerInputConfig.setRAINMAXRES(suewsConfigValues.getRAINMAXRES());
			headerInputConfig.setSDDFull1(suewsConfigValues.getSDDFull1());
			headerInputConfig.setSDDFull2(suewsConfigValues.getSDDFull2());
			headerInputConfig.setSDDFull3(suewsConfigValues.getSDDFull3());
			headerInputConfig.setSDDFull4(suewsConfigValues.getSDDFull4());
			headerInputConfig.setSkipHeaderGIS(suewsConfigValues.getSkipHeaderGIS());
			headerInputConfig.setSkipHeaderMet(suewsConfigValues.getSkipHeaderMet());
			headerInputConfig.setSuewsStatus(suewsConfigValues.getSuewsStatus());
			headerInputConfig.setTIMEZONE(suewsConfigValues.getTIMEZONE());
			headerInputConfig.setTRANS_SITE(suewsConfigValues.getTRANS_SITE());
			headerInputConfig.setTreeH(suewsConfigValues.getTreeH());
			headerInputConfig.setVeg_type(suewsConfigValues.getVeg_type());
			headerInputConfig.setZ(suewsConfigValues.getZ());
			headerInputConfig.setZ0_method(suewsConfigValues.getZ0_method());	
			headerInputConfig.generateFile();
			headerInputConfig.writeConfigFile();
			
			SuewsConfigCanopyMoisture canopyMoistureConfig = new SuewsConfigCanopyMoisture(runDirectory, configYear, runPrefix);
			canopyMoistureConfig.setPavedtoRunOff(suewsConfigValues.getCanopyConfigPavedtoRunOff());
			canopyMoistureConfig.setPavedtoConif(suewsConfigValues.getCanopyConfigPavedtoConif());
			canopyMoistureConfig.setPavedtoDecid(suewsConfigValues.getCanopyConfigPavedtoDecid());
			canopyMoistureConfig.setPavedtoIrrGrass(suewsConfigValues.getCanopyConfigPavedtoIrrGrass());
			canopyMoistureConfig.setPavedtoUnirrGrass(suewsConfigValues.getCanopyConfigPavedtoUnirrGrass());
			canopyMoistureConfig.setPavedtoWater(suewsConfigValues.getCanopyConfigPavedtoWater());
			canopyMoistureConfig.setBuildtoRunOff(suewsConfigValues.getCanopyConfigBuildtoRunOff());
			canopyMoistureConfig.setBuildtoPaved(suewsConfigValues.getCanopyConfigBuildtoPaved());
			canopyMoistureConfig.setBuildtoConif(suewsConfigValues.getCanopyConfigBuildtoConif());
			canopyMoistureConfig.setBuildtoDecid(suewsConfigValues.getCanopyConfigBuildtoDecid());
			canopyMoistureConfig.setBuildtoIrrGrass(suewsConfigValues.getCanopyConfigBuildtoIrrGrass());
			canopyMoistureConfig.setBuildtoUnIrrGrass(suewsConfigValues.getCanopyConfigBuildtoUnIrrGrass());
			canopyMoistureConfig.setBuildtoWater(suewsConfigValues.getCanopyConfigBuildtoWater());
			canopyMoistureConfig.setConiftoSoil(suewsConfigValues.getCanopyConfigConiftoSoil());
			canopyMoistureConfig.setConiftoPaved(suewsConfigValues.getCanopyConfigConiftoPaved());
			canopyMoistureConfig.setConiftoDecid(suewsConfigValues.getCanopyConfigConiftoDecid());
			canopyMoistureConfig.setConiftoIrrGrass(suewsConfigValues.getCanopyConfigConiftoIrrGrass());
			canopyMoistureConfig.setConiftoUnirrGrass(suewsConfigValues.getCanopyConfigConiftoUnirrGrass());
			canopyMoistureConfig.setConiftoWater(suewsConfigValues.getCanopyConfigConiftoWater());
			canopyMoistureConfig.setDecidtoSoil(suewsConfigValues.getCanopyConfigDecidtoSoil());
			canopyMoistureConfig.setDecidtoPaved(suewsConfigValues.getCanopyConfigDecidtoPaved());
			canopyMoistureConfig.setDecidtoConif(suewsConfigValues.getCanopyConfigDecidtoConif());
			canopyMoistureConfig.setDecidtoIrrGrass(suewsConfigValues.getCanopyConfigDecidtoIrrGrass());
			canopyMoistureConfig.setDecidtoUnirrGrass(suewsConfigValues.getCanopyConfigDecidtoUnirrGrass());
			canopyMoistureConfig.setDecidtoWater(suewsConfigValues.getCanopyConfigDecidtoWater());
			canopyMoistureConfig.setIrrGrasstoSoil(suewsConfigValues.getCanopyConfigIrrGrasstoSoil());
			canopyMoistureConfig.setIrrGrasstoPaved(suewsConfigValues.getCanopyConfigIrrGrasstoPaved());
			canopyMoistureConfig.setIrrGrasstoConif(suewsConfigValues.getCanopyConfigIrrGrasstoConif());
			canopyMoistureConfig.setIrrGrasstoDecid(suewsConfigValues.getCanopyConfigIrrGrasstoDecid());
			canopyMoistureConfig.setIrrGrasstoUnirrGrass(suewsConfigValues.getCanopyConfigIrrGrasstoUnirrGrass());
			canopyMoistureConfig.setIrrGrasstoWater(suewsConfigValues.getCanopyConfigIrrGrasstoWater());
			canopyMoistureConfig.setUnirrGrasstoSoil(suewsConfigValues.getCanopyConfigUnirrGrasstoSoil());
			canopyMoistureConfig.setUnirrGrasstoPaved(suewsConfigValues.getCanopyConfigUnirrGrasstoPaved());
			canopyMoistureConfig.setUnirrGrasstoConif(suewsConfigValues.getCanopyConfigUnirrGrasstoConif());
			canopyMoistureConfig.setUnirrGrasstoDecid(suewsConfigValues.getCanopyConfigUnirrGrasstoDecid());
			canopyMoistureConfig.setUnirrGrasstoIrrGrass(suewsConfigValues.getCanopyConfigUnirrGrasstoIrrGrass());
			canopyMoistureConfig.setUnirrGrasstoWater(suewsConfigValues.getCanopyConfigUnirrGrasstoWater());	
			canopyMoistureConfig.generateFile();
			canopyMoistureConfig.writeConfigFile(INPUT_DIRECTORY);
			
			SuewsConfigGIS gisConfig = new SuewsConfigGIS(runDirectory, configYear, runPrefix);
			gisConfig.setId(suewsConfigValues.getGisConfigId());
			gisConfig.setIt(suewsConfigValues.getGisConfigIt());
			gisConfig.setQual(suewsConfigValues.getGisConfigQual());			
			gisConfig.setWater(suewsConfigValues.getGisConfigWater());
			gisConfig.setCany3d(suewsConfigValues.getGisConfigCany3d());
			gisConfig.setROOF3D(suewsConfigValues.getGisConfigROOF3D());
			gisConfig.setZ0m(suewsConfigValues.getGisConfigz0m());
			gisConfig.setZd(suewsConfigValues.getGisConfigzd());
			gisConfig.setPlanF(suewsConfigValues.getGisConfigPlanF());
			gisConfig.setPlanTr(suewsConfigValues.getGisConfigPlanTr());			
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
			
			ohmConfig.setOhmConfigCanyonsIncluded(suewsConfigValues.getOhmConfigCanyonsIncluded());			
			ohmConfig.setOhmConfigCalcuationsCoefficientsCanyons(suewsConfigValues.getOhmConfigCalcuationsCoefficientsCanyons());
			ohmConfig.setOhmConfigVegetationCalculated(suewsConfigValues.getOhmConfigVegetationCalculated());
			ohmConfig.setOhmConfigCalcuationsCoefficientsVegetation(suewsConfigValues.getOhmConfigCalcuationsCoefficientsVegetation());
			ohmConfig.setOhmConfigCalcuationsCoefficientsRoof(suewsConfigValues.getOhmConfigCalcuationsCoefficientsRoof());
			ohmConfig.setOhmConfigImperviousAreasCalculated(suewsConfigValues.getOhmConfigImperviousAreasCalculated());
			ohmConfig.setOhmConfigCalcuationsCoefficientsImperviousAreas(suewsConfigValues.getOhmConfigCalcuationsCoefficientsImperviousAreas());			
			ohmConfig.generateFile();
			ohmConfig.writeConfigFile(INPUT_DIRECTORY);		
			
			SuewsConfigSahp sahpConfig = new SuewsConfigSahp(runDirectory, configYear, runPrefix);
			sahpConfig.setConfigSahpAHDIUPRF(suewsConfigValues.getConfigSahpAHDIUPRF());
			sahpConfig.setConfigSahpAHDIUPRF1(suewsConfigValues.getConfigSahpAHDIUPRF1());
			sahpConfig.setConfigSahpAHDIUPRF2(suewsConfigValues.getConfigSahpAHDIUPRF2());
			sahpConfig.setConfigSahpAH_MIN(suewsConfigValues.getConfigSahpAH_MIN());
			sahpConfig.setConfigSahpAH_SLOPE(suewsConfigValues.getConfigSahpAH_SLOPE());
			sahpConfig.setConfigSahpT_CRITIC(suewsConfigValues.getConfigSahpT_CRITIC());
			sahpConfig.generateFile();
			sahpConfig.writeConfigFile(INPUT_DIRECTORY);	
			
			SuewsConfigSuewsInput suewsInputConfig = new SuewsConfigSuewsInput(runDirectory, configYear, runPrefix);
			suewsInputConfig.setBldgStorCap(suewsConfigValues.getBldgStorCap());
			suewsInputConfig.setBldgDrainCoef1(suewsConfigValues.getBldgDrainCoef1());
			suewsInputConfig.setBldgDrainCoef2(suewsConfigValues.getBldgDrainCoef2());
			suewsInputConfig.setBldgState(suewsConfigValues.getBldgState());
			suewsInputConfig.setConifStorCap(suewsConfigValues.getConifStorCap());
			suewsInputConfig.setConifDrainCoef1(suewsConfigValues.getConifDrainCoef1());
			suewsInputConfig.setConifDrainCoef2(suewsConfigValues.getConifDrainCoef2());
			suewsInputConfig.setConifState(suewsConfigValues.getConifState());
			suewsInputConfig.setDecidStorCap(suewsConfigValues.getDecidStorCap());
			suewsInputConfig.setDecidDrainCoef1(suewsConfigValues.getDecidDrainCoef1());
			suewsInputConfig.setDecidDrainCoef2(suewsConfigValues.getDecidDrainCoef2());
			suewsInputConfig.setDecidState(suewsConfigValues.getDecidState());
			suewsInputConfig.setFlowChange(suewsConfigValues.getFlowChange());
			suewsInputConfig.setG1(suewsConfigValues.getG1());
			suewsInputConfig.setG2(suewsConfigValues.getG2());
			suewsInputConfig.setG3(suewsConfigValues.getG3());
			suewsInputConfig.setG4(suewsConfigValues.getG4());
			suewsInputConfig.setG5(suewsConfigValues.getG5());
			suewsInputConfig.setG6(suewsConfigValues.getG6());
			suewsInputConfig.setGrassUStorCap(suewsConfigValues.getGrassUStorCap());
			suewsInputConfig.setGrassUDrainCoef1(suewsConfigValues.getGrassUDrainCoef1());
			suewsInputConfig.setGrassUDrainCoef2(suewsConfigValues.getGrassUDrainCoef2());
			suewsInputConfig.setGrassUState(suewsConfigValues.getGrassUState());
			suewsInputConfig.setGrassIStorCap(suewsConfigValues.getGrassIStorCap());
			suewsInputConfig.setGrassIDrainCoef1(suewsConfigValues.getGrassIDrainCoef1());
			suewsInputConfig.setGrassIDrainCoef2(suewsConfigValues.getGrassIDrainCoef2());
			suewsInputConfig.setGrassIState(suewsConfigValues.getGrassIState());
			suewsInputConfig.setSatHydraulicConduct(suewsConfigValues.getSatHydraulicConduct());
			suewsInputConfig.setInternalWaterUse(suewsConfigValues.getInternalWaterUse());
			suewsInputConfig.setKmax(suewsConfigValues.getKmax());
			suewsInputConfig.setPavStorCap(suewsConfigValues.getPavStorCap());
			suewsInputConfig.setPavDrainCoef1(suewsConfigValues.getPavDrainCoef1());
			suewsInputConfig.setPavDrainCoef2(suewsConfigValues.getPavDrainCoef2());
			suewsInputConfig.setPavState(suewsConfigValues.getPavState());
			suewsInputConfig.setPipeCapacity(suewsConfigValues.getPipeCapacity());
			suewsInputConfig.setRunoffToWater(suewsConfigValues.getRunoffToWater());
			suewsInputConfig.setRoughLen_heat(suewsConfigValues.getRoughLen_heat());
			suewsInputConfig.setS1(suewsConfigValues.getS1());
			suewsInputConfig.setS2(suewsConfigValues.getS2());
			suewsInputConfig.setSDECStor(suewsConfigValues.getSDECStor());
			suewsInputConfig.setSmCap(suewsConfigValues.getSmCap());
			suewsInputConfig.setSmd_choice(suewsConfigValues.getSmd_choice());
			suewsInputConfig.setSm_input(suewsConfigValues.getSm_input());
			suewsInputConfig.setSoilDensity(suewsConfigValues.getSoilDensity());
			suewsInputConfig.setSoilDepth(suewsConfigValues.getSoilDepth());
			suewsInputConfig.setSoilDepthMeas(suewsConfigValues.getSoilDepthMeas());
			suewsInputConfig.setSoilRocks(suewsConfigValues.getSoilRocks());
			suewsInputConfig.setSoilstorePav(suewsConfigValues.getSoilstorePav());
			suewsInputConfig.setSoilstoreBldg(suewsConfigValues.getSoilstoreBldg());
			suewsInputConfig.setSoilstorePavstate(suewsConfigValues.getSoilstorePavstate());
			suewsInputConfig.setSoilstoreBldgstate(suewsConfigValues.getSoilstoreBldgstate());
			suewsInputConfig.setSoilstoreConif(suewsConfigValues.getSoilstoreConif());
			suewsInputConfig.setSoilstoreDec(suewsConfigValues.getSoilstoreDec());
			suewsInputConfig.setSoilstoreGrass(suewsConfigValues.getSoilstoreGrass());
			suewsInputConfig.setSoilstoreConifstate(suewsConfigValues.getSoilstoreConifstate());
			suewsInputConfig.setSoilstoreDecstate(suewsConfigValues.getSoilstoreDecstate());
			suewsInputConfig.setSoilstoreGrassUnirstate(suewsConfigValues.getSoilstoreGrassUnirstate());
			suewsInputConfig.setSoilstoreGrassirrstate(suewsConfigValues.getSoilstoreGrassirrstate());
			suewsInputConfig.setStabilityMethod(suewsConfigValues.getStabilityMethod());
			suewsInputConfig.setSurfaceArea(suewsConfigValues.getSurfaceArea());
			suewsInputConfig.setTH(suewsConfigValues.getTH());
			suewsInputConfig.setTL(suewsConfigValues.getTL());
			suewsInputConfig.setTstep(suewsConfigValues.getTstep());
			suewsInputConfig.setWaterUseArea(suewsConfigValues.getWaterUseArea());
			suewsInputConfig.setWaterState(suewsConfigValues.getWaterState());
			suewsInputConfig.setWaterStorCap(suewsConfigValues.getWaterStorCap());
			suewsInputConfig.setWrite5min(suewsConfigValues.getWrite5min());			
			suewsInputConfig.generateFile();
			suewsInputConfig.writeConfigFile(INPUT_DIRECTORY);
			
			SuewsConfigWaterUseProfile waterUseProfileConfig = new SuewsConfigWaterUseProfile(runDirectory, configYear, runPrefix);			
			waterUseProfileConfig.setIe_start(suewsConfigValues.getIe_start());			
			waterUseProfileConfig.setIe_end(suewsConfigValues.getIe_end());
			waterUseProfileConfig.setFaut(suewsConfigValues.getFaut());
			waterUseProfileConfig.setIe_a1(suewsConfigValues.getIe_a1());
			waterUseProfileConfig.setIe_a2(suewsConfigValues.getIe_a2());
			waterUseProfileConfig.setIe_a3(suewsConfigValues.getIe_a3());
			waterUseProfileConfig.setIe_m1(suewsConfigValues.getIe_m1());
			waterUseProfileConfig.setIe_m2(suewsConfigValues.getIe_m2());
			waterUseProfileConfig.setIe_m3(suewsConfigValues.getIe_m3());
			waterUseProfileConfig.setDayWat1(suewsConfigValues.getDayWat1());
			waterUseProfileConfig.setDayWat2(suewsConfigValues.getDayWat2());
			waterUseProfileConfig.setDayWat3(suewsConfigValues.getDayWat3());
			waterUseProfileConfig.setDayWat4(suewsConfigValues.getDayWat4());
			waterUseProfileConfig.setDayWat5(suewsConfigValues.getDayWat5());
			waterUseProfileConfig.setDayWat6(suewsConfigValues.getDayWat6());
			waterUseProfileConfig.setDayWat7(suewsConfigValues.getDayWat7());
			waterUseProfileConfig.setDayWatPer1(suewsConfigValues.getDayWatPer1());
			waterUseProfileConfig.setDayWatPer2(suewsConfigValues.getDayWatPer2());
			waterUseProfileConfig.setDayWatPer3(suewsConfigValues.getDayWatPer3());
			waterUseProfileConfig.setDayWatPer4(suewsConfigValues.getDayWatPer4());
			waterUseProfileConfig.setDayWatPer5(suewsConfigValues.getDayWatPer5());
			waterUseProfileConfig.setDayWatPer6(suewsConfigValues.getDayWatPer6());
			waterUseProfileConfig.setDayWatPer7(suewsConfigValues.getDayWatPer7());
			waterUseProfileConfig.setHourResChoice(suewsConfigValues.getHourResChoice());
			waterUseProfileConfig.setHourWat(suewsConfigValues.getHourWat());
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
