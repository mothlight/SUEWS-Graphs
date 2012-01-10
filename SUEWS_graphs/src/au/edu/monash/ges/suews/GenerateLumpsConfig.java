package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.print.DocFlavor.INPUT_STREAM;

public class GenerateLumpsConfig
{
	ENVICommon common = new ENVICommon();
	//LumpsConfigValues suewsConfigValues = new LumpsConfigValues();
	final String INPUT_DIRECTORY = "Input";
	final String OUTPUT_DIRECTORY = "Output";
	private String outputDirectory;
	private String inputDirectory;
	
	private String runPrefix;
	private String runDirectory;
	private int numYears;
	private int startingYear;
	private int numGrids;
	private int numDifferentOhm;
	private int numDifferentMet;

	

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
	
	public void processConfig(LumpsConfigValues lumpsConfigValues)
	{
		
		
		this.inputDirectory = runDirectory + INPUT_DIRECTORY;
		this.outputDirectory = runDirectory + OUTPUT_DIRECTORY;
		common.createDirectory(this.outputDirectory);
		common.createDirectory(this.inputDirectory);
		

//		SuewsConfigModelledYears yearConfig = new SuewsConfigModelledYears(runDirectory, numYears, startingYear);
//		//System.out.println (config.getFileText());
//		yearConfig.writeConfigFile();
		
//		for (int i=0;i<numYears;i++)
//		{
			//int configYear = startingYear + i;
		int configYear = startingYear ;
					
		LumpsConfigGridnames gridnames = new LumpsConfigGridnames(runDirectory, configYear, runPrefix, numGrids, numDifferentOhm, numDifferentMet);
		gridnames.generateFile();
		gridnames.writeConfigFile();	
			
		//  headerInputConfig.set(lumpsConfigValues.get);
		
			LumpsConfigHeaderInput headerInputConfig = new LumpsConfigHeaderInput(runDirectory, configYear, runPrefix);
			headerInputConfig.setALB1(lumpsConfigValues.getALB1());
			headerInputConfig.setALB2(lumpsConfigValues.getALB2());
			headerInputConfig.setALB3(lumpsConfigValues.getALB3());
			headerInputConfig.setALB4(lumpsConfigValues.getALB4());
			headerInputConfig.setALB5(lumpsConfigValues.getALB5());
			headerInputConfig.setALB6(lumpsConfigValues.getALB6());
			//headerInputConfig.setALB7(lumpsConfigValues.getALB7());
			headerInputConfig.setALB_SNOW(lumpsConfigValues.getALB_SNOW());
			headerInputConfig.setCommonChoiceAllSites(lumpsConfigValues.getCommonChoiceAllSites());
			headerInputConfig.setD3_CalcYes(lumpsConfigValues.getD3_CalcYes());
//			headerInputConfig.setAnthropHeatChoice(lumpsConfigValues.getAnthropHeatChoice());
//			headerInputConfig.setBaseT1(lumpsConfigValues.getBaseT1());
//			headerInputConfig.setBaseT2(lumpsConfigValues.getBaseT2());
//			headerInputConfig.setBaseT3(lumpsConfigValues.getBaseT3());
//			headerInputConfig.setBaseT4(lumpsConfigValues.getBaseT4());
//			headerInputConfig.setBaseTe1(lumpsConfigValues.getBaseTe1());
//			headerInputConfig.setBaseTe2(lumpsConfigValues.getBaseTe2());
//			headerInputConfig.setBaseTe3(lumpsConfigValues.getBaseTe3());
//			headerInputConfig.setBaseTe4(lumpsConfigValues.getBaseTe4());
//			headerInputConfig.setBaseTHDD(lumpsConfigValues.getBaseTHDD());
//			headerInputConfig.setBlgH(lumpsConfigValues.getBlgH());
//			headerInputConfig.setDayLightSavingDay1(lumpsConfigValues.getDayLightSavingDay1());
//			headerInputConfig.setDayLightSavingDay2(lumpsConfigValues.getDayLightSavingDay2());
			headerInputConfig.setDefaultFcld(lumpsConfigValues.getDefaultFcld());
			headerInputConfig.setDefaultPres(lumpsConfigValues.getDefaultPres());
			headerInputConfig.setDefaultRH(lumpsConfigValues.getDefaultRH());
			headerInputConfig.setDefaultT(lumpsConfigValues.getDefaultT());
			headerInputConfig.setDifferentOutPuts(lumpsConfigValues.getDifferentOutPuts());
//			headerInputConfig.setDefaultU(lumpsConfigValues.getDefaultU());
//			headerInputConfig.setDefaultQf(lumpsConfigValues.getDefaultQf());
//			headerInputConfig.setDefaultQs(lumpsConfigValues.getDefaultQs());
			headerInputConfig.setDRAINRT(lumpsConfigValues.getDRAINRT());
			headerInputConfig.setEMIS1(lumpsConfigValues.getEMIS1());
			headerInputConfig.setEMIS2(lumpsConfigValues.getEMIS2());
			headerInputConfig.setEMIS3(lumpsConfigValues.getEMIS3());
			headerInputConfig.setEMIS4(lumpsConfigValues.getEMIS4());
			headerInputConfig.setEMIS5(lumpsConfigValues.getEMIS5());
			headerInputConfig.setEMIS6(lumpsConfigValues.getEMIS6());
//			headerInputConfig.setEMIS7(lumpsConfigValues.getEMIS7());
			headerInputConfig.setEMIS_SNOW(lumpsConfigValues.getEMIS_SNOW());
			
			headerInputConfig.setFileChoices(lumpsConfigValues.getFileChoices());
			headerInputConfig.setFileGIS(lumpsConfigValues.getFileGIS());
			headerInputConfig.setFileMet(lumpsConfigValues.getFileMet());
			headerInputConfig.setFileOHM(lumpsConfigValues.getFileOHM());
			headerInputConfig.setFileOut15(lumpsConfigValues.getFileOut15());
			headerInputConfig.setFileOut30(lumpsConfigValues.getFileOut30());
			headerInputConfig.setFileOut60(lumpsConfigValues.getFileOut60());
			headerInputConfig.setFileErrorInf(lumpsConfigValues.getFileErrorInf());
			headerInputConfig.setNARPOut(lumpsConfigValues.getNARPOut());
			
//			headerInputConfig.setGDDFull1(lumpsConfigValues.getGDDFull1());
//			headerInputConfig.setGDDFull2(lumpsConfigValues.getGDDFull2());
//			headerInputConfig.setGDDFull3(lumpsConfigValues.getGDDFull3());
//			headerInputConfig.setGDDFull4(lumpsConfigValues.getGDDFull4());
			headerInputConfig.setGISInputType(lumpsConfigValues.getGISInputType());
			headerInputConfig.setGrassFractionIrrigated(lumpsConfigValues.getGrassFractionIrrigated());
			headerInputConfig.setINTERVAL(lumpsConfigValues.getINTERVAL());
//			headerInputConfig.setLAImax1(lumpsConfigValues.getLAImax1());
//			headerInputConfig.setLAImax2(lumpsConfigValues.getLAImax2());
//			headerInputConfig.setLAImax3(lumpsConfigValues.getLAImax3());
//			headerInputConfig.setLAImax4(lumpsConfigValues.getLAImax4());
//			headerInputConfig.setLAImin1(lumpsConfigValues.getLAImin1());
//			headerInputConfig.setLAImin2(lumpsConfigValues.getLAImin2());
//			headerInputConfig.setLAImin3(lumpsConfigValues.getLAImin3());
//			headerInputConfig.setLAImin4(lumpsConfigValues.getLAImin4());
			headerInputConfig.setLat(lumpsConfigValues.getLat());
			headerInputConfig.setLng(lumpsConfigValues.getLng());
			headerInputConfig.setNARPOutput(lumpsConfigValues.getNARPOutput());
			headerInputConfig.setNetRadiationChoice(lumpsConfigValues.getNetRadiationChoice());
//			headerInputConfig.setNumCapita(lumpsConfigValues.getNumCapita());
			headerInputConfig.setLdown_option(lumpsConfigValues.getLdown_option());
			headerInputConfig.setOhmFileType(lumpsConfigValues.getOhmFileType());
			headerInputConfig.setPavedFractionIrrigated(lumpsConfigValues.getPavedFractionIrrigated());
//			headerInputConfig.setQf_A1(lumpsConfigValues.getQf_A1());
//			headerInputConfig.setQf_A2(lumpsConfigValues.getQf_A2());
//			headerInputConfig.setQf_B1(lumpsConfigValues.getQf_B1());
//			headerInputConfig.setQf_B2(lumpsConfigValues.getQf_B2());
//			headerInputConfig.setQf_C1(lumpsConfigValues.getQf_C1());
//			headerInputConfig.setQf_C2(lumpsConfigValues.getQf_C2());
			headerInputConfig.setQSChoice(lumpsConfigValues.getQSChoice());
			headerInputConfig.setRAINCOVER(lumpsConfigValues.getRAINCOVER());
			headerInputConfig.setRAINMAXRES(lumpsConfigValues.getRAINMAXRES());
//			headerInputConfig.setSDDFull1(lumpsConfigValues.getSDDFull1());
//			headerInputConfig.setSDDFull2(lumpsConfigValues.getSDDFull2());
//			headerInputConfig.setSDDFull3(lumpsConfigValues.getSDDFull3());
//			headerInputConfig.setSDDFull4(lumpsConfigValues.getSDDFull4());
			
			headerInputConfig.setSDEC1(lumpsConfigValues.getSDEC1());
			headerInputConfig.setSDEC2(lumpsConfigValues.getSDEC2());
			headerInputConfig.setSDEC3(lumpsConfigValues.getSDEC3());
			headerInputConfig.setSDEC4(lumpsConfigValues.getSDEC4());
			
			headerInputConfig.setSkipHeaderGIS(lumpsConfigValues.getSkipHeaderGIS());
			headerInputConfig.setSkipHeaderMet(lumpsConfigValues.getSkipHeaderMet());
//			headerInputConfig.setSuewsStatus(lumpsConfigValues.getSuewsStatus());
			headerInputConfig.setTIMEZONE(lumpsConfigValues.getTIMEZONE());
			headerInputConfig.setTRANS_SITE(lumpsConfigValues.getTRANS_SITE());
			headerInputConfig.setTreeFractionIrrigated(lumpsConfigValues.getTreeFractionIrrigated());
//			headerInputConfig.setTreeH(lumpsConfigValues.getTreeH());
			headerInputConfig.setVeg_type(lumpsConfigValues.getVeg_type());
//			headerInputConfig.setZ(lumpsConfigValues.getZ());
//			headerInputConfig.setZ0_method(lumpsConfigValues.getZ0_method());	
			headerInputConfig.setYear(configYear);
			headerInputConfig.generateFile();
			headerInputConfig.writeConfigFile();
//			
//			SuewsConfigCanopyMoisture canopyMoistureConfig = new SuewsConfigCanopyMoisture(runDirectory, configYear, runPrefix);
//			canopyMoistureConfig.setPavedtoRunOff(lumpsConfigValues.getCanopyConfigPavedtoRunOff());
//			canopyMoistureConfig.setPavedtoConif(lumpsConfigValues.getCanopyConfigPavedtoConif());
//			canopyMoistureConfig.setPavedtoDecid(lumpsConfigValues.getCanopyConfigPavedtoDecid());
//			canopyMoistureConfig.setPavedtoIrrGrass(lumpsConfigValues.getCanopyConfigPavedtoIrrGrass());
//			canopyMoistureConfig.setPavedtoUnirrGrass(lumpsConfigValues.getCanopyConfigPavedtoUnirrGrass());
//			canopyMoistureConfig.setPavedtoWater(lumpsConfigValues.getCanopyConfigPavedtoWater());
//			canopyMoistureConfig.setBuildtoRunOff(lumpsConfigValues.getCanopyConfigBuildtoRunOff());
//			canopyMoistureConfig.setBuildtoPaved(lumpsConfigValues.getCanopyConfigBuildtoPaved());
//			canopyMoistureConfig.setBuildtoConif(lumpsConfigValues.getCanopyConfigBuildtoConif());
//			canopyMoistureConfig.setBuildtoDecid(lumpsConfigValues.getCanopyConfigBuildtoDecid());
//			canopyMoistureConfig.setBuildtoIrrGrass(lumpsConfigValues.getCanopyConfigBuildtoIrrGrass());
//			canopyMoistureConfig.setBuildtoUnIrrGrass(lumpsConfigValues.getCanopyConfigBuildtoUnIrrGrass());
//			canopyMoistureConfig.setBuildtoWater(lumpsConfigValues.getCanopyConfigBuildtoWater());
//			canopyMoistureConfig.setConiftoSoil(lumpsConfigValues.getCanopyConfigConiftoSoil());
//			canopyMoistureConfig.setConiftoPaved(lumpsConfigValues.getCanopyConfigConiftoPaved());
//			canopyMoistureConfig.setConiftoDecid(lumpsConfigValues.getCanopyConfigConiftoDecid());
//			canopyMoistureConfig.setConiftoIrrGrass(lumpsConfigValues.getCanopyConfigConiftoIrrGrass());
//			canopyMoistureConfig.setConiftoUnirrGrass(lumpsConfigValues.getCanopyConfigConiftoUnirrGrass());
//			canopyMoistureConfig.setConiftoWater(lumpsConfigValues.getCanopyConfigConiftoWater());
//			canopyMoistureConfig.setDecidtoSoil(lumpsConfigValues.getCanopyConfigDecidtoSoil());
//			canopyMoistureConfig.setDecidtoPaved(lumpsConfigValues.getCanopyConfigDecidtoPaved());
//			canopyMoistureConfig.setDecidtoConif(lumpsConfigValues.getCanopyConfigDecidtoConif());
//			canopyMoistureConfig.setDecidtoIrrGrass(lumpsConfigValues.getCanopyConfigDecidtoIrrGrass());
//			canopyMoistureConfig.setDecidtoUnirrGrass(lumpsConfigValues.getCanopyConfigDecidtoUnirrGrass());
//			canopyMoistureConfig.setDecidtoWater(lumpsConfigValues.getCanopyConfigDecidtoWater());
//			canopyMoistureConfig.setIrrGrasstoSoil(lumpsConfigValues.getCanopyConfigIrrGrasstoSoil());
//			canopyMoistureConfig.setIrrGrasstoPaved(lumpsConfigValues.getCanopyConfigIrrGrasstoPaved());
//			canopyMoistureConfig.setIrrGrasstoConif(lumpsConfigValues.getCanopyConfigIrrGrasstoConif());
//			canopyMoistureConfig.setIrrGrasstoDecid(lumpsConfigValues.getCanopyConfigIrrGrasstoDecid());
//			canopyMoistureConfig.setIrrGrasstoUnirrGrass(lumpsConfigValues.getCanopyConfigIrrGrasstoUnirrGrass());
//			canopyMoistureConfig.setIrrGrasstoWater(lumpsConfigValues.getCanopyConfigIrrGrasstoWater());
//			canopyMoistureConfig.setUnirrGrasstoSoil(lumpsConfigValues.getCanopyConfigUnirrGrasstoSoil());
//			canopyMoistureConfig.setUnirrGrasstoPaved(lumpsConfigValues.getCanopyConfigUnirrGrasstoPaved());
//			canopyMoistureConfig.setUnirrGrasstoConif(lumpsConfigValues.getCanopyConfigUnirrGrasstoConif());
//			canopyMoistureConfig.setUnirrGrasstoDecid(lumpsConfigValues.getCanopyConfigUnirrGrasstoDecid());
//			canopyMoistureConfig.setUnirrGrasstoIrrGrass(lumpsConfigValues.getCanopyConfigUnirrGrasstoIrrGrass());
//			canopyMoistureConfig.setUnirrGrasstoWater(lumpsConfigValues.getCanopyConfigUnirrGrasstoWater());	
//			canopyMoistureConfig.generateFile();
//			canopyMoistureConfig.writeConfigFile(INPUT_DIRECTORY);
//			
			LumpsConfigGIS gisConfig = new LumpsConfigGIS(runDirectory, configYear, runPrefix);
			gisConfig.setId(lumpsConfigValues.getGisConfigId());
			gisConfig.setIt(lumpsConfigValues.getGisConfigIt());
			gisConfig.setQual(lumpsConfigValues.getGisConfigQual());			
			gisConfig.setWater(lumpsConfigValues.getGisConfigWater());
			gisConfig.setCany3d(lumpsConfigValues.getGisConfigCany3d());
			gisConfig.setROOF3D(lumpsConfigValues.getGisConfigROOF3D());
			//gisConfig.setZ0m(lumpsConfigValues.getGisConfigz0m());
			//gisConfig.setZd(lumpsConfigValues.getGisConfigzd());
			gisConfig.setPlanF(lumpsConfigValues.getGisConfigPlanF());
			//gisConfig.setPlanTr(lumpsConfigValues.getGisConfigPlanTr());			
			gisConfig.setBuildingPercentage(lumpsConfigValues.getGisConfigBuildingPercentage());
			gisConfig.setPavedPercentage(lumpsConfigValues.getGisConfigPavedPercentage());
			gisConfig.setUnmanPercentage(lumpsConfigValues.getGisConfigUnmanPercentage());
			gisConfig.setConPercentage(lumpsConfigValues.getGisConfigConPercentage());
			gisConfig.setDecPercentage(lumpsConfigValues.getGisConfigDecPercentage());
			gisConfig.setGrassPercentage(lumpsConfigValues.getGisConfigGrassPercentage());
			//gisConfig.setIrrGrassPercentage(lumpsConfigValues.getGisConfigIrrGrassPercentage());
			gisConfig.setAngle(lumpsConfigValues.getGisConfigAngle());
			gisConfig.generateFile();
			gisConfig.writeConfigFile(INPUT_DIRECTORY);
			
			LumpsConfigOHM ohmConfig = new LumpsConfigOHM(runDirectory, configYear, runPrefix);
			
			ohmConfig.setOhmConfigCanyonsIncluded(lumpsConfigValues.getOhmConfigCanyonsIncluded());			
			ohmConfig.setOhmConfigCalcuationsCoefficientsCanyons(lumpsConfigValues.getOhmConfigCalcuationsCoefficientsCanyons());
			ohmConfig.setOhmConfigVegetationCalculated(lumpsConfigValues.getOhmConfigVegetationCalculated());
			ohmConfig.setOhmConfigCalcuationsCoefficientsVegetation(lumpsConfigValues.getOhmConfigCalcuationsCoefficientsVegetation());
			ohmConfig.setOhmConfigCalcuationsCoefficientsRoof(lumpsConfigValues.getOhmConfigCalcuationsCoefficientsRoof());
			ohmConfig.setOhmConfigImperviousAreasCalculated(lumpsConfigValues.getOhmConfigImperviousAreasCalculated());
			ohmConfig.setOhmConfigCalcuationsCoefficientsImperviousAreas(lumpsConfigValues.getOhmConfigCalcuationsCoefficientsImperviousAreas());			
			ohmConfig.generateFile();
			ohmConfig.writeConfigFile(INPUT_DIRECTORY);		
//			
//			SuewsConfigSahp sahpConfig = new SuewsConfigSahp(runDirectory, configYear, runPrefix);
//			sahpConfig.setConfigSahpAHDIUPRF(lumpsConfigValues.getConfigSahpAHDIUPRF());
//			sahpConfig.setConfigSahpAHDIUPRF1(lumpsConfigValues.getConfigSahpAHDIUPRF1());
//			sahpConfig.setConfigSahpAHDIUPRF2(lumpsConfigValues.getConfigSahpAHDIUPRF2());
//			sahpConfig.setConfigSahpAH_MIN(lumpsConfigValues.getConfigSahpAH_MIN());
//			sahpConfig.setConfigSahpAH_SLOPE(lumpsConfigValues.getConfigSahpAH_SLOPE());
//			sahpConfig.setConfigSahpT_CRITIC(lumpsConfigValues.getConfigSahpT_CRITIC());
//			sahpConfig.generateFile();
//			sahpConfig.writeConfigFile(INPUT_DIRECTORY);	
//			
//			SuewsConfigSuewsInput suewsInputConfig = new SuewsConfigSuewsInput(runDirectory, configYear, runPrefix);
//			suewsInputConfig.setBldgStorCap(lumpsConfigValues.getBldgStorCap());
//			suewsInputConfig.setBldgDrainCoef1(lumpsConfigValues.getBldgDrainCoef1());
//			suewsInputConfig.setBldgDrainCoef2(lumpsConfigValues.getBldgDrainCoef2());
//			suewsInputConfig.setBldgState(lumpsConfigValues.getBldgState());
//			suewsInputConfig.setConifStorCap(lumpsConfigValues.getConifStorCap());
//			suewsInputConfig.setConifDrainCoef1(lumpsConfigValues.getConifDrainCoef1());
//			suewsInputConfig.setConifDrainCoef2(lumpsConfigValues.getConifDrainCoef2());
//			suewsInputConfig.setConifState(lumpsConfigValues.getConifState());
//			suewsInputConfig.setDecidStorCap(lumpsConfigValues.getDecidStorCap());
//			suewsInputConfig.setDecidDrainCoef1(lumpsConfigValues.getDecidDrainCoef1());
//			suewsInputConfig.setDecidDrainCoef2(lumpsConfigValues.getDecidDrainCoef2());
//			suewsInputConfig.setDecidState(lumpsConfigValues.getDecidState());
//			suewsInputConfig.setFlowChange(lumpsConfigValues.getFlowChange());
//			suewsInputConfig.setG1(lumpsConfigValues.getG1());
//			suewsInputConfig.setG2(lumpsConfigValues.getG2());
//			suewsInputConfig.setG3(lumpsConfigValues.getG3());
//			suewsInputConfig.setG4(lumpsConfigValues.getG4());
//			suewsInputConfig.setG5(lumpsConfigValues.getG5());
//			suewsInputConfig.setG6(lumpsConfigValues.getG6());
//			suewsInputConfig.setGrassUStorCap(lumpsConfigValues.getGrassUStorCap());
//			suewsInputConfig.setGrassUDrainCoef1(lumpsConfigValues.getGrassUDrainCoef1());
//			suewsInputConfig.setGrassUDrainCoef2(lumpsConfigValues.getGrassUDrainCoef2());
//			suewsInputConfig.setGrassUState(lumpsConfigValues.getGrassUState());
//			suewsInputConfig.setGrassIStorCap(lumpsConfigValues.getGrassIStorCap());
//			suewsInputConfig.setGrassIDrainCoef1(lumpsConfigValues.getGrassIDrainCoef1());
//			suewsInputConfig.setGrassIDrainCoef2(lumpsConfigValues.getGrassIDrainCoef2());
//			suewsInputConfig.setGrassIState(lumpsConfigValues.getGrassIState());
//			suewsInputConfig.setSatHydraulicConduct(lumpsConfigValues.getSatHydraulicConduct());
//			suewsInputConfig.setInternalWaterUse(lumpsConfigValues.getInternalWaterUse());
//			suewsInputConfig.setKmax(lumpsConfigValues.getKmax());
//			suewsInputConfig.setPavStorCap(lumpsConfigValues.getPavStorCap());
//			suewsInputConfig.setPavDrainCoef1(lumpsConfigValues.getPavDrainCoef1());
//			suewsInputConfig.setPavDrainCoef2(lumpsConfigValues.getPavDrainCoef2());
//			suewsInputConfig.setPavState(lumpsConfigValues.getPavState());
//			suewsInputConfig.setPipeCapacity(lumpsConfigValues.getPipeCapacity());
//			suewsInputConfig.setRunoffToWater(lumpsConfigValues.getRunoffToWater());
//			suewsInputConfig.setRoughLen_heat(lumpsConfigValues.getRoughLen_heat());
//			suewsInputConfig.setS1(lumpsConfigValues.getS1());
//			suewsInputConfig.setS2(lumpsConfigValues.getS2());
//			suewsInputConfig.setSDECStor(lumpsConfigValues.getSDECStor());
//			suewsInputConfig.setSmCap(lumpsConfigValues.getSmCap());
//			suewsInputConfig.setSmd_choice(lumpsConfigValues.getSmd_choice());
//			suewsInputConfig.setSm_input(lumpsConfigValues.getSm_input());
//			suewsInputConfig.setSoilDensity(lumpsConfigValues.getSoilDensity());
//			suewsInputConfig.setSoilDepth(lumpsConfigValues.getSoilDepth());
//			suewsInputConfig.setSoilDepthMeas(lumpsConfigValues.getSoilDepthMeas());
//			suewsInputConfig.setSoilRocks(lumpsConfigValues.getSoilRocks());
//			suewsInputConfig.setSoilstorePav(lumpsConfigValues.getSoilstorePav());
//			suewsInputConfig.setSoilstoreBldg(lumpsConfigValues.getSoilstoreBldg());
//			suewsInputConfig.setSoilstorePavstate(lumpsConfigValues.getSoilstorePavstate());
//			suewsInputConfig.setSoilstoreBldgstate(lumpsConfigValues.getSoilstoreBldgstate());
//			suewsInputConfig.setSoilstoreConif(lumpsConfigValues.getSoilstoreConif());
//			suewsInputConfig.setSoilstoreDec(lumpsConfigValues.getSoilstoreDec());
//			suewsInputConfig.setSoilstoreGrass(lumpsConfigValues.getSoilstoreGrass());
//			suewsInputConfig.setSoilstoreConifstate(lumpsConfigValues.getSoilstoreConifstate());
//			suewsInputConfig.setSoilstoreDecstate(lumpsConfigValues.getSoilstoreDecstate());
//			suewsInputConfig.setSoilstoreGrassUnirstate(lumpsConfigValues.getSoilstoreGrassUnirstate());
//			suewsInputConfig.setSoilstoreGrassirrstate(lumpsConfigValues.getSoilstoreGrassirrstate());
//			suewsInputConfig.setStabilityMethod(lumpsConfigValues.getStabilityMethod());
//			suewsInputConfig.setSurfaceArea(lumpsConfigValues.getSurfaceArea());
//			suewsInputConfig.setTH(lumpsConfigValues.getTH());
//			suewsInputConfig.setTL(lumpsConfigValues.getTL());
//			suewsInputConfig.setTstep(lumpsConfigValues.getTstep());
//			suewsInputConfig.setWaterUseArea(lumpsConfigValues.getWaterUseArea());
//			suewsInputConfig.setWaterState(lumpsConfigValues.getWaterState());
//			suewsInputConfig.setWaterStorCap(lumpsConfigValues.getWaterStorCap());
//			suewsInputConfig.setWrite5min(lumpsConfigValues.getWrite5min());			
//			suewsInputConfig.generateFile();
//			suewsInputConfig.writeConfigFile(INPUT_DIRECTORY);
//			
//			SuewsConfigWaterUseProfile waterUseProfileConfig = new SuewsConfigWaterUseProfile(runDirectory, configYear, runPrefix);			
//			waterUseProfileConfig.setIe_start(lumpsConfigValues.getIe_start());			
//			waterUseProfileConfig.setIe_end(lumpsConfigValues.getIe_end());
//			waterUseProfileConfig.setFaut(lumpsConfigValues.getFaut());
//			waterUseProfileConfig.setIe_a1(lumpsConfigValues.getIe_a1());
//			waterUseProfileConfig.setIe_a2(lumpsConfigValues.getIe_a2());
//			waterUseProfileConfig.setIe_a3(lumpsConfigValues.getIe_a3());
//			waterUseProfileConfig.setIe_m1(lumpsConfigValues.getIe_m1());
//			waterUseProfileConfig.setIe_m2(lumpsConfigValues.getIe_m2());
//			waterUseProfileConfig.setIe_m3(lumpsConfigValues.getIe_m3());
//			waterUseProfileConfig.setDayWat1(lumpsConfigValues.getDayWat1());
//			waterUseProfileConfig.setDayWat2(lumpsConfigValues.getDayWat2());
//			waterUseProfileConfig.setDayWat3(lumpsConfigValues.getDayWat3());
//			waterUseProfileConfig.setDayWat4(lumpsConfigValues.getDayWat4());
//			waterUseProfileConfig.setDayWat5(lumpsConfigValues.getDayWat5());
//			waterUseProfileConfig.setDayWat6(lumpsConfigValues.getDayWat6());
//			waterUseProfileConfig.setDayWat7(lumpsConfigValues.getDayWat7());
//			waterUseProfileConfig.setDayWatPer1(lumpsConfigValues.getDayWatPer1());
//			waterUseProfileConfig.setDayWatPer2(lumpsConfigValues.getDayWatPer2());
//			waterUseProfileConfig.setDayWatPer3(lumpsConfigValues.getDayWatPer3());
//			waterUseProfileConfig.setDayWatPer4(lumpsConfigValues.getDayWatPer4());
//			waterUseProfileConfig.setDayWatPer5(lumpsConfigValues.getDayWatPer5());
//			waterUseProfileConfig.setDayWatPer6(lumpsConfigValues.getDayWatPer6());
//			waterUseProfileConfig.setDayWatPer7(lumpsConfigValues.getDayWatPer7());
//			waterUseProfileConfig.setHourResChoice(lumpsConfigValues.getHourResChoice());
//			waterUseProfileConfig.setHourWat(lumpsConfigValues.getHourWat());
//			waterUseProfileConfig.generateFile();
//			waterUseProfileConfig.writeConfigFile(INPUT_DIRECTORY);
//			
//			
			LumpsConfigWeatherData weatherDataConfig = new LumpsConfigWeatherData(runDirectory, configYear, runPrefix);
			PrestonWeatherData weatherData = new PrestonWeatherData();
			ArrayList<TreeMap<String,String>> dataForYear = weatherData.getPrestonData(configYear);
			weatherDataConfig.setDataForYear(dataForYear);
			weatherDataConfig.generateFile();
			weatherDataConfig.writeConfigFile(INPUT_DIRECTORY);	
			
//			
//		}
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
		return numGrids;
	}

	public void setNumGridConnections(int numGridConnections)
	{
		this.numGrids = numGridConnections;
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
