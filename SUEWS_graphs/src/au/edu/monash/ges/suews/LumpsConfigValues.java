package au.edu.monash.ges.suews;

import java.util.TreeMap;

public class LumpsConfigValues
{
	
	public LumpsConfigValues()
	{
		super();
		setConfigValues("");
	}
	
	public LumpsConfigValues(String runPrefix)
	{
		super();
		setConfigValues(runPrefix);
	}	

	public void setConfigValues(String runPrefix)	
	{
		setDefaultValues();
		
		setNumGridNames(1);
		//setRunPrefix("Pr3714");
		setRunPrefix(runPrefix);
		setRunDirectory("/tmp/SUEWS_" + runPrefix + "/");
		setNumYears(1);
		setStartingYear(2004);
		
		
		setRun(PRESTON_RUN);
		//setRunPrefix("Pr0003");	

				
//		if (run.equals(PRESTON_RUN))
//		{
//			setBlgH(6.4);
//			setDayLightSavingDay1(275);
//			setDayLightSavingDay2(93);
//			setLat(-37.49);
//			setLng(144.53);
//			setNumCapita(2939);
//			setLdown_option(1);
//			setTIMEZONE(10);
//			setZ(40);
//				
//			setSuewsConfigSuewsInputWUChoice("1");
			setPrestonWeatherDataDataTable("Preston_data");
			prestonExternalWaterHourlyWeighings = new TreeMap<String, Double>();
////			prestonExternalWaterHourlyWeighings.put("01", .25);
////			prestonExternalWaterHourlyWeighings.put("02", .25);
////			prestonExternalWaterHourlyWeighings.put("03", .25);
////			prestonExternalWaterHourlyWeighings.put("22", .25);
//			
//			prestonExternalWaterHourlyWeighings.put("06", .125);
//			prestonExternalWaterHourlyWeighings.put("07", .125);
//			prestonExternalWaterHourlyWeighings.put("08", .125);
//			prestonExternalWaterHourlyWeighings.put("09", .125);			
//			prestonExternalWaterHourlyWeighings.put("16", .125);
//			prestonExternalWaterHourlyWeighings.put("17", .125);
//			prestonExternalWaterHourlyWeighings.put("18", .125);
//			prestonExternalWaterHourlyWeighings.put("19", .125);
//			
//			setPrestonExternalWaterMultiplier(1.0);
//			
//			setGisConfigBuildingPercentage(0.4500);
//			setGisConfigPavedPercentage(0.1800);
//			setGisConfigUnmanPercentage(0.0100);
//			setGisConfigConPercentage(0.115);
//			setGisConfigDecPercentage(0.115);
//			setGisConfigGrassPercentage(0.075);
//			setGisConfigIrrGrassPercentage(0.075);
//			
//			setPrestonExternalWaterHourlyWeighings(prestonExternalWaterHourlyWeighings);
//
//			
//			Ie_start=0;
//			Ie_end=365;
//			
//			if (getRunPrefix().equals("Pr0000")	)
//			{
//				setPrestonExternalWaterMultiplier(100.0);
//			}			
//			if (runPrefix.equals("Pr0001")	)
//			{
//				setLdown_option(3);				
//			}
//			if (getRunPrefix().equals("Pr0002")	)
//			{
//				setLdown_option(1);				
//			}	
//			if (runPrefix.equals("Pr0003")	)
//			{
//				setLdown_option(1);
//				setSuewsStatus(0);
//			}	
//			if (getRunPrefix().equals("Pr0004")	)
//			{
//				setAnthropHeatChoice(2);
//			}	
//			if (getRunPrefix().equals("Pr0005")	)
//			{
//				setAnthropHeatChoice(1);
//			}
//			if (getRunPrefix().equals("Pr0006")	)
//			{
//				setAnthropHeatChoice(0);
//			}		
//			if (getRunPrefix().equals("Pr0007")	)
//			{
//				setNetRadiationChoice(1);
//			}	
//			if (getRunPrefix().equals("Pr0008")	)
//			{
//				setNetRadiationChoice(2);
//			}	
//			if (getRunPrefix().equals("Pr0009")	)
//			{
//				setQSChoice(1);
//			}
//			if (getRunPrefix().equals("Pr0010")	)
//			{
//				setQSChoice(2);
//			}		
//			if (getRunPrefix().equals("Pr0011")	)
//			{
//				setVeg_type(1);
//			}	
//			if (getRunPrefix().equals("Pr0012")	)
//			{
//				setVeg_type(2);
//			}	
//			if (getRunPrefix().equals("Pr3714")	)
//			{
//				setSuewsConfigSuewsInputWUChoice("0");
//				setPrestonExternalWaterHourlyWeighings(new TreeMap<String, Double>());
//			}
//		}
		
//		if (run.equals(MAWSON_RUN))
//		{
//			setBlgH(6.4);
//			setDayLightSavingDay1(275);
//			setDayLightSavingDay2(93);
//			setLat(-37.49);
//			setLng(144.53);
//			setNumCapita(2939);
//			setLdown_option(1);
//			setTIMEZONE(10);
//			setZ(40);
//			
//			setSuewsConfigSuewsInputWUChoice("0");
//			
//			setPrestonWeatherDataDataTable("Mawson_Lakes_data");
//			//setPrestonWeatherDataDataTable("Preston_data");
//			prestonExternalWaterHourlyWeighings = new TreeMap<String, Double>();
//			prestonExternalWaterHourlyWeighings.put("01", .25);
//			prestonExternalWaterHourlyWeighings.put("02", .25);
//			prestonExternalWaterHourlyWeighings.put("03", .25);
//			prestonExternalWaterHourlyWeighings.put("22", .25);
//			setPrestonExternalWaterHourlyWeighings(prestonExternalWaterHourlyWeighings);
//			setPrestonExternalWaterMultiplier(1.0);
//			
//			setGisConfigBuildingPercentage(0.4500);
//			setGisConfigPavedPercentage(0.1800);
//			setGisConfigUnmanPercentage(0.0100);
//			setGisConfigConPercentage(0.115);
//			setGisConfigDecPercentage(0.115);
//			setGisConfigGrassPercentage(0.075);
//			setGisConfigIrrGrassPercentage(0.075);
//						
//			setNumGridNames(1);
//			setRunPrefix("Ml3714");
//			setRunDirectory("/tmp/SUEWS_" + runPrefix + "/");
//			setNumYears(1);
//			setStartingYear(2011);
//			//setStartingYear(2004);
//			
//			Ie_start=0;
//			Ie_end=365;
//		}
//		
//		
//		
//
//		
	}
	
	private TreeMap <String, Double> prestonExternalWaterHourlyWeighings;
	private double prestonExternalWaterMultiplier;
	private int numGridNames ;
	private int numDifferentOhm ;
	private int numDifferentMet ;
	private String runPrefix ;
	private String runDirectory;
	private int numYears ;
	private int startingYear ;
	
	
	private double ALB1;
	private double ALB2;
	private double ALB3;
	private double ALB4;
	private double ALB5;
	private double ALB6;
	//private double ALB7;
	private double ALB_SNOW;
	private int CommonChoiceAllSites;
	//private int AnthropHeatChoice;
	private int D3_CalcYes;
	private int DifferentOutPuts;
//	private double BaseT1;
//	private double BaseT2;
//	private double BaseT3;
//	private double BaseT4;
//	private double BaseTe1;
//	private double BaseTe2;
//	private double BaseTe3;
//	private double BaseTe4;
//	private double BaseTHDD;
//	private double blgH;
//	private int DayLightSavingDay1;
//	private int DayLightSavingDay2;
	private double defaultFcld;
	private double defaultPres;
	private double defaultRH;
	private double defaultT;
//	private double defaultU;
//	private double defaultQf;  
//	private double defaultQs;
	private double DRAINRT;
	private double EMIS1;
	private double EMIS2;
	private double EMIS3;
	private double EMIS4;
	private double EMIS5;
	private double EMIS6;
	//private double EMIS7;
	private double EMIS_SNOW;
	private String FileChoices; 
	private String FileGIS;
	private String FileMet;
	private String FileOHM;
	private String FileOut15;
	private String FileOut30;
	private String FileOut60;
	private String FileErrorInf;
	private String NARPOut;	
//	private double GDDFull1;
//	private double GDDFull2;
//	private double GDDFull3;
//	private double GDDFull4;
	private int GISInputType;
	private int GrassFractionIrrigated;
	private int INTERVAL;
//	private double LAImax1;
//	private double LAImax2;
//	private double LAImax3;
//	private double LAImax4;
//	private double LAImin1;
//	private double LAImin2;
//	private double LAImin3;
//	private double LAImin4;
	private double lat;
	private double lng;
	private int NARPOutput;
	private int NetRadiationChoice;
	//private int numCapita;
	private int ldown_option;
	private int OhmFileType;
//	private double Qf_A1;
//	private double Qf_A2;
//	private double Qf_B1;
//	private double Qf_B2;
//	private double Qf_C1;
//	private double Qf_C2;
	private double PavedFractionIrrigated;
	private int QSChoice;
	private double RAINCOVER;
	private double RAINMAXRES;
//	private double SDDFull1;
//	private double SDDFull2;
//	private double SDDFull3;
//	private double SDDFull4;
	private int SDEC1;
	private int SDEC2;
	private int SDEC3;
	private int SDEC4;		
	private int SkipHeaderGIS;
	private int SkipHeaderMet;
	//private int SuewsStatus;
	private int TIMEZONE;
	private int TRANS_SITE;
	private double TreeFractionIrrigated;
	//private double TreeH;
	private int Veg_type;
	//private double z;
	//private int z0_method;
	
	
//	private double BldgStorCap;
//	private double BldgDrainCoef1;
//	private double BldgDrainCoef2;
//	private double BldgState;
//	private double ConifStorCap;
//	private double ConifDrainCoef1;
//	private double ConifDrainCoef2;
//	private double ConifState;
//	private double DecidStorCap;
//	private double DecidDrainCoef1;
//	private double DecidDrainCoef2;
//	private double DecidState;
//	private double FlowChange;
//	private double G1;
//	private double G2;
//	private double G3;
//	private double G4;
//	private double G5;
//	private double G6;
//	private double GrassUStorCap;
//	private double GrassUDrainCoef1;
//	private double GrassUDrainCoef2;
//	private double GrassUState;
//	private double GrassIStorCap;
//	private double GrassIDrainCoef1;
//	private double GrassIDrainCoef2;
//	private double GrassIState;
//	private double SatHydraulicConduct;
//	private double InternalWaterUse;
//	private double Kmax;
//	private double PavStorCap;
//	private double PavDrainCoef1;
//	private double PavDrainCoef2;
//	private double PavState;
//	private String PipeCapacity;
//	private double RunoffToWater;
//	private int RoughLen_heat;
//	private double S1;
//	private double S2;
//	private double SDECStor;
//	private double SmCap;
//	private int smd_choice;
//	private int sm_input;
//	private double SoilDensity;
//	private double SoilDepth;
//	private double SoilDepthMeas;
//	private double SoilRocks;
//	private double soilstorePav;
//	private double soilstoreBldg;
//	private double soilstorePavstate;
//	private double soilstoreBldgstate;
//	private double soilstoreConif;
//	private double soilstoreDec;
//	private double soilstoreGrass;
//	private double soilstoreConifstate;
//	private double soilstoreDecstate;
//	private double soilstoreGrassUnirstate;
//	private double soilstoreGrassirrstate;
//	private int StabilityMethod;
//	private int SurfaceArea;
//	private double TH;
//	private double TL;
//	private int Tstep;
//	private int WaterUseArea;
//	private double WaterState;
//	private String WaterStorCap;
//	private int write5min;	
	
	private Double gisConfigBuildingPercentage;
	private Double gisConfigPavedPercentage;
	private Double gisConfigUnmanPercentage;
	private Double gisConfigConPercentage;
	private Double gisConfigDecPercentage;
	private Double gisConfigGrassPercentage;
	//private Double gisConfigIrrGrassPercentage;
	
	
	private int gisConfigId;
	private int gisConfigIt;
	private int gisConfigQual;
	private double gisConfigWater;
	private double gisConfigCany3d;
	private double gisConfigROOF3D;
	//private double gisConfigz0m;
	//private double gisConfigzd;
	private double gisConfigPlanF;
	//private double gisConfigPlanTr;
	private Double gisConfigAngle;
	
//	private double canopyConfigPavedtoRunOff;
//	private double canopyConfigPavedtoConif;
//	private double canopyConfigPavedtoDecid;
//	private double canopyConfigPavedtoIrrGrass;
//	private double canopyConfigPavedtoUnirrGrass;
//	private double canopyConfigPavedtoWater;
//	private double canopyConfigBuildtoRunOff;
//	private double canopyConfigBuildtoPaved;
//	private double canopyConfigBuildtoConif;
//	private double canopyConfigBuildtoDecid;
//	private double canopyConfigBuildtoIrrGrass;
//	private double canopyConfigBuildtoUnIrrGrass;
//	private double canopyConfigBuildtoWater;
//	private double canopyConfigConiftoSoil;
//	private double canopyConfigConiftoPaved;
//	private double canopyConfigConiftoDecid;
//	private double canopyConfigConiftoIrrGrass;
//	private double canopyConfigConiftoUnirrGrass;
//	private double canopyConfigConiftoWater;
//	private double canopyConfigDecidtoSoil;
//	private double canopyConfigDecidtoPaved;
//	private double canopyConfigDecidtoConif;
//	private double canopyConfigDecidtoIrrGrass;
//	private double canopyConfigDecidtoUnirrGrass;
//	private double canopyConfigDecidtoWater;
//	private double canopyConfigIrrGrasstoSoil;
//	private double canopyConfigIrrGrasstoPaved;
//	private double canopyConfigIrrGrasstoConif;
//	private double canopyConfigIrrGrasstoDecid;
//	private double canopyConfigIrrGrasstoUnirrGrass;
//	private double canopyConfigIrrGrasstoWater;
//	private double canopyConfigUnirrGrasstoSoil;
//	private double canopyConfigUnirrGrasstoPaved;
//	private double canopyConfigUnirrGrasstoConif;
//	private double canopyConfigUnirrGrasstoDecid;
//	private double canopyConfigUnirrGrasstoIrrGrass;
//	private double canopyConfigUnirrGrasstoWater;
	
	private boolean ohmConfigCanyonsIncluded;
	private int ohmConfigCalcuationsCoefficientsCanyons;
	private int ohmConfigVegetationCalculated;
	private String[] ohmConfigCalcuationsCoefficientsVegetation;
	private String[] ohmConfigCalcuationsCoefficientsRoof;
	private int ohmConfigImperviousAreasCalculated;
	private String[] ohmConfigCalcuationsCoefficientsImperviousAreas;
	
//	private String[] configSahpAHDIUPRF;
//	private String[] configSahpAHDIUPRF1;
//	private String[] configSahpAHDIUPRF2;
//	private String configSahpAH_MIN;
//	private String configSahpAH_SLOPE;
//	private String configSahpT_CRITIC;
		
	private String prestonWeatherDataDataTable;
	private String suewsConfigSuewsInputWUChoice;
	public final String PRESTON_RUN="Preston";
	public final String MAWSON_RUN="Mawson";
	private String run;	
	
	private int Ie_start;
	private int Ie_end;
	private double Faut;
	private double Ie_a1;
	private double Ie_a2;
	private double Ie_a3;
	private double Ie_m1;
	private double Ie_m2;
	private double Ie_m3;
	private int DayWat1;
	private int DayWat2;
	private int DayWat3;
	private int DayWat4;
	private int DayWat5;
	private int DayWat6;
	private int DayWat7;
	private double DayWatPer1;
	private double DayWatPer2;
	private double DayWatPer3;
	private double DayWatPer4;
	private double DayWatPer5;
	private double DayWatPer6;
	private double DayWatPer7;
	private int HourResChoice;
	private String[] HourWat;	
	
	public void setDefaultValues()
	{
		setNumGridNames(1);
		setNumDifferentOhm(0);
		setNumDifferentMet(0);
		
		//Header input (root dir)
		ALB1=0.125;
		ALB2=0.224;
		ALB3=0.10;
		ALB4=0.18;
		ALB5=0.25;
		ALB6=0.25;
		//ALB7=0.10;
		ALB_SNOW=0.35;
//		AnthropHeatChoice=2;
//		BaseT1=5;
//		BaseT2=5;
//		BaseT3=5;
//		BaseT4=5;
//		BaseTe1=13;
//		BaseTe2=13;
//		BaseTe3=13;
//		BaseTe4=13;
//		BaseTHDD=18.2;
//		blgH=19.5559;
		CommonChoiceAllSites=1;
		D3_CalcYes=0;
//		DayLightSavingDay1=87;
//		DayLightSavingDay2=304;
		defaultFcld=0.1;
		defaultPres=1013;
		defaultRH=50;
		defaultT=10;
//		defaultU=3;
//		defaultQf=10;  
//		defaultQs=10;		
		DifferentOutPuts=0;
		DRAINRT=0.25;
		EMIS1=0.95;
		EMIS2=0.91;
		EMIS3=0.98;
		EMIS4=0.975;
		EMIS5=0.93;
		EMIS6=0.93;
//		EMIS7=0.95;
		EMIS_SNOW=0.99;
		FileChoices="\".\\Output\\\"" ;
		FileGIS ="\".\\Input\\\""; 
		FileMet="\".\\Input\\\"" ;
		FileOHM ="\".\\Input\\\"";
		FileOut15="\".\\Output\\\"";
		FileOut30="\".\\Output\\\"";
		FileOut60="\".\\Output\\\"";
		FileErrorInf="\".\\Output\\\""; 
		NARPOut="\".\\Output\\\"";
//		GDDFull1=300;
//		GDDFull2=300;
//		GDDFull3=300;
//		GDDFull4=300;
		GISInputType=3;
		GrassFractionIrrigated=1;
		INTERVAL=60;
//		LAImax1=5.1;
//		LAImax2=5.5;
//		LAImax3=5.9;
//		LAImax4=5.9;
//		LAImin1=4.0;
//		LAImin2=1.0;
//		LAImin3=1.6;
//		LAImin4=1.6;
		lat=51.5153;
		lng=-0.116;
		NARPOutput=1;
		NetRadiationChoice=2;		
//		numCapita=3000;
		ldown_option=1;
		OhmFileType=2;
		PavedFractionIrrigated=0.0;
//		Qf_A1=0.014711;
//		Qf_A2=0.014711;
//		Qf_B1=0.000444;
//		Qf_B2=0.000444;
//		Qf_C1=0.000489;
//		Qf_C2=0.000489;
		QSChoice=1;
		RAINCOVER=1;
		RAINMAXRES=10;
//		SDDFull1=-450;
//		SDDFull2=-450;
//		SDDFull3=-450;
//		SDDFull4=-450;
		SDEC1=65;
		SDEC2=115;
		SDEC3=240;
		SDEC4=270;
		SkipHeaderGIS=1;
		SkipHeaderMet=1;
//		SuewsStatus=1;
		TIMEZONE=0;
		TRANS_SITE=1;
		TreeFractionIrrigated=0.0;
//		TreeH=14;
		Veg_type=1;
//		z=31;
//		z0_method=2;	
		//year=2004;
		
		//SUEWSInputSSNN_YYYY.nml
//		BldgStorCap=0.25;
//		BldgDrainCoef1=10;
//		BldgDrainCoef2=3;
//		BldgState=0;
//		ConifStorCap=1.3;
//		ConifDrainCoef1=0.013;
//		ConifDrainCoef2=1.71;
//		ConifState=0;
//		DecidStorCap=0.3;
//		DecidDrainCoef1=0.013;
//		DecidDrainCoef2=1.71;
//		DecidState=0;
//		FlowChange=0;
//		G1=16.4764;
//		G2=566.0923;
//		G3=0.2163;
//		G4=3.3649;
//		G5=11.0764;
//		G6=0.0176;
//		GrassUStorCap=1.9;
//		GrassUDrainCoef1=0.013;
//		GrassUDrainCoef2=1.71;
//		GrassUState=0;
//		GrassIStorCap=1.9;
//		GrassIDrainCoef1=10;
//		GrassIDrainCoef2=3;
//		GrassIState=0;
//		SatHydraulicConduct=0.0005;
//		InternalWaterUse=0;
//		Kmax=1200;
//		PavStorCap=0.48;
//		PavDrainCoef1=10;
//		PavDrainCoef2=3;
//		PavState=0;
//		PipeCapacity="700 !in mm";
//		RunoffToWater=0.1;
//		RoughLen_heat=2;
//		S1=0.45;
//		S2=15;
//		SDECStor=0.8;
//		SmCap=0.6;
//		smd_choice=0;
//		sm_input=1;
//		SoilDensity=0.94;
//		SoilDepth=250;
//		SoilDepthMeas=50;
//		SoilRocks=1;
//		soilstorePav=100;
//		soilstoreBldg=70;
//		soilstorePavstate=95;
//		soilstoreBldgstate=65;
//		soilstoreConif=150;
//		soilstoreDec=150;
//		soilstoreGrass=150;
//		soilstoreConifstate=140;
//		soilstoreDecstate=140;
//		soilstoreGrassUnirstate=140;
//		soilstoreGrassirrstate=140;
//		StabilityMethod=2;
//		SurfaceArea=100;
//		TH=40;
//		TL=0.0;
//		Tstep=300;
//		WaterUseArea=100;
//		WaterState=20000;
//		WaterStorCap="30000 !max storage cap.";
//		write5min=1;
//		setSuewsConfigSuewsInputWUChoice("0");
		
		//gis file
		setGisConfigId(3);
		setGisConfigIt(3);
		setGisConfigQual(1);
		
		setGisConfigBuildingPercentage(0.4863);
		setGisConfigPavedPercentage(0.4150);
		setGisConfigUnmanPercentage(0.0);
		setGisConfigConPercentage(0.0);
		setGisConfigDecPercentage(0.0123);
		setGisConfigGrassPercentage(0.0864);
		//setGisConfigIrrGrassPercentage(0.0687);
		
		setGisConfigWater(0.0000);
		setGisConfigCany3d(0.9119);
		setGisConfigROOF3D(0.5836);
		//setGisConfigz0m(-999);
		//setGisConfigzd(-999);
		setGisConfigPlanF(0);
		//setGisConfigPlanTr(-999);		
		setGisConfigAngle(0.0);
		
		//canopy moisture
//		canopyConfigPavedtoRunOff=1;
//		canopyConfigPavedtoConif=0;
//		canopyConfigPavedtoDecid=0;
//		canopyConfigPavedtoIrrGrass=0;
//		canopyConfigPavedtoUnirrGrass=0;
//		canopyConfigPavedtoWater=0;
//		canopyConfigBuildtoRunOff=0.8;
//		canopyConfigBuildtoPaved=0.15;
//		canopyConfigBuildtoConif=0.01;
//		canopyConfigBuildtoDecid=0;
//		canopyConfigBuildtoIrrGrass=0.02;
//		canopyConfigBuildtoUnIrrGrass=0.02;
//		canopyConfigBuildtoWater=0;
//		canopyConfigConiftoSoil=1;
//		canopyConfigConiftoPaved=0;
//		canopyConfigConiftoDecid=0;
//		canopyConfigConiftoIrrGrass=0;
//		canopyConfigConiftoUnirrGrass=0;
//		canopyConfigConiftoWater=0;
//		canopyConfigDecidtoSoil=1;
//		canopyConfigDecidtoPaved=0;
//		canopyConfigDecidtoConif=0;
//		canopyConfigDecidtoIrrGrass=0;
//		canopyConfigDecidtoUnirrGrass=0;
//		canopyConfigDecidtoWater=0;
//		canopyConfigIrrGrasstoSoil=1;
//		canopyConfigIrrGrasstoPaved=0;
//		canopyConfigIrrGrasstoConif=0;
//		canopyConfigIrrGrasstoDecid=0;
//		canopyConfigIrrGrasstoUnirrGrass=0;
//		canopyConfigIrrGrasstoWater=0;
//		canopyConfigUnirrGrasstoSoil=1;
//		canopyConfigUnirrGrasstoPaved=0;
//		canopyConfigUnirrGrasstoConif=0;
//		canopyConfigUnirrGrasstoDecid=0;
//		canopyConfigUnirrGrasstoIrrGrass=0;
//		canopyConfigUnirrGrasstoWater=0;
				
		//ohm
		ohmConfigCanyonsIncluded = true;
		ohmConfigCalcuationsCoefficientsCanyons = 2;
		ohmConfigVegetationCalculated = 2;
		ohmConfigCalcuationsCoefficientsVegetation = new String[]{"2", "3", "8", "0"};
		ohmConfigCalcuationsCoefficientsRoof= new String[]{"1"};
		ohmConfigImperviousAreasCalculated = 1;
		ohmConfigCalcuationsCoefficientsImperviousAreas= new String[]{"1"};
		
		//sahp
//		configSahpAHDIUPRF = new String[]{"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1" };
//		configSahpAHDIUPRF1 = new String[]{"0.57", "0.45", "0.43", "0.4", "0.4", "0.45", "0.71", "1.2", "1.44", "1.29", "1.28", "1.31", "1.3", "1.32", "1.35", "1.44", "1.51", "1.41", "1.14", "0.99", "0.86", "0.85", "0.8", "0.7"};
//		configSahpAHDIUPRF2 = new String[]{"0.65", "0.49", "0.46", "0.47", "0.47", "0.53", "0.7", "1.13", "1.37", "1.37", "1.3", "1.37", "1.33", "1.3", "1.27", "1.36", "1.44", "1.3", "1.1", "0.98", "0.84", "0.9", "0.87", "0.74"};
//		configSahpAH_MIN = "15";
//		configSahpAH_SLOPE = "2.7";
//		configSahpT_CRITIC = "7.0";
		
		//WaterUseProfileSSNN_YYYY.txt
//		Ie_start=100;
//		Ie_end=270;
//		Faut=0.1;
//		Ie_a1=-84.535;
//		Ie_a2=9.959;
//		Ie_a3=3.674;
//		Ie_m1=-25.36;
//		Ie_m2=2.988;
//		Ie_m3=1.102;
//		DayWat1=1;
//		DayWat2=1;
//		DayWat3=1;
//		DayWat4=1;
//		DayWat5=1;
//		DayWat6=1;
//		DayWat7=1;
//		DayWatPer1=0.3;
//		DayWatPer2=1;
//		DayWatPer3=1;
//		DayWatPer4=1;
//		DayWatPer5=1;
//		DayWatPer6=1;
//		DayWatPer7=0.3;
//		HourResChoice=0;
//		HourWat = new String[]{"","","","","","0.11","0.12","0.11","","","","","","","","","","0.11","0.11","0.11","0.11","0.11","0.11",""};			
				
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

	public int getNumGridNames()
	{
		return numGridNames;
	}

	public void setNumGridNames(int numGridNames)
	{
		this.numGridNames = numGridNames;
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

//	public Double getGisConfigIrrGrassPercentage()
//	{
//		return gisConfigIrrGrassPercentage;
//	}

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

//	public void setGisConfigIrrGrassPercentage(Double gisConfigIrrGrassPercentage)
//	{
//		this.gisConfigIrrGrassPercentage = gisConfigIrrGrassPercentage;
//	}

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

//	public double getGisConfigz0m() {
//		return gisConfigz0m;
//	}

//	public void setGisConfigz0m(double gisConfigz0m) {
//		this.gisConfigz0m = gisConfigz0m;
//	}

//	public double getGisConfigzd() {
//		return gisConfigzd;
//	}

//	public void setGisConfigzd(double gisConfigzd) {
//		this.gisConfigzd = gisConfigzd;
//	}

	public double getGisConfigPlanF() {
		return gisConfigPlanF;
	}

	public void setGisConfigPlanF(double gisConfigPlanF) {
		this.gisConfigPlanF = gisConfigPlanF;
	}

//	public double getGisConfigPlanTr() {
//		return gisConfigPlanTr;
//	}

//	public void setGisConfigPlanTr(double gisConfigPlanTr) {
//		this.gisConfigPlanTr = gisConfigPlanTr;
//	}

//	public double getCanopyConfigPavedtoRunOff() {
//		return canopyConfigPavedtoRunOff;
//	}
//
//	public void setCanopyConfigPavedtoRunOff(double canopyConfigPavedtoRunOff) {
//		this.canopyConfigPavedtoRunOff = canopyConfigPavedtoRunOff;
//	}
//
//	public double getCanopyConfigPavedtoConif() {
//		return canopyConfigPavedtoConif;
//	}
//
//	public void setCanopyConfigPavedtoConif(double canopyConfigPavedtoConif) {
//		this.canopyConfigPavedtoConif = canopyConfigPavedtoConif;
//	}
//
//	public double getCanopyConfigPavedtoDecid() {
//		return canopyConfigPavedtoDecid;
//	}
//
//	public void setCanopyConfigPavedtoDecid(double canopyConfigPavedtoDecid) {
//		this.canopyConfigPavedtoDecid = canopyConfigPavedtoDecid;
//	}
//
//	public double getCanopyConfigPavedtoIrrGrass() {
//		return canopyConfigPavedtoIrrGrass;
//	}
//
//	public void setCanopyConfigPavedtoIrrGrass(double canopyConfigPavedtoIrrGrass) {
//		this.canopyConfigPavedtoIrrGrass = canopyConfigPavedtoIrrGrass;
//	}
//
//	public double getCanopyConfigPavedtoUnirrGrass() {
//		return canopyConfigPavedtoUnirrGrass;
//	}
//
//	public void setCanopyConfigPavedtoUnirrGrass(
//			double canopyConfigPavedtoUnirrGrass) {
//		this.canopyConfigPavedtoUnirrGrass = canopyConfigPavedtoUnirrGrass;
//	}
//
//	public double getCanopyConfigPavedtoWater() {
//		return canopyConfigPavedtoWater;
//	}
//
//	public void setCanopyConfigPavedtoWater(double canopyConfigPavedtoWater) {
//		this.canopyConfigPavedtoWater = canopyConfigPavedtoWater;
//	}
//
//	public double getCanopyConfigBuildtoRunOff() {
//		return canopyConfigBuildtoRunOff;
//	}
//
//	public void setCanopyConfigBuildtoRunOff(double canopyConfigBuildtoRunOff) {
//		this.canopyConfigBuildtoRunOff = canopyConfigBuildtoRunOff;
//	}
//
//	public double getCanopyConfigBuildtoPaved() {
//		return canopyConfigBuildtoPaved;
//	}
//
//	public void setCanopyConfigBuildtoPaved(double canopyConfigBuildtoPaved) {
//		this.canopyConfigBuildtoPaved = canopyConfigBuildtoPaved;
//	}
//
//	public double getCanopyConfigBuildtoConif() {
//		return canopyConfigBuildtoConif;
//	}
//
//	public void setCanopyConfigBuildtoConif(double canopyConfigBuildtoConif) {
//		this.canopyConfigBuildtoConif = canopyConfigBuildtoConif;
//	}
//
//	public double getCanopyConfigBuildtoDecid() {
//		return canopyConfigBuildtoDecid;
//	}
//
//	public void setCanopyConfigBuildtoDecid(double canopyConfigBuildtoDecid) {
//		this.canopyConfigBuildtoDecid = canopyConfigBuildtoDecid;
//	}
//
//	public double getCanopyConfigBuildtoIrrGrass() {
//		return canopyConfigBuildtoIrrGrass;
//	}
//
//	public void setCanopyConfigBuildtoIrrGrass(double canopyConfigBuildtoIrrGrass) {
//		this.canopyConfigBuildtoIrrGrass = canopyConfigBuildtoIrrGrass;
//	}
//
//	public double getCanopyConfigBuildtoUnIrrGrass() {
//		return canopyConfigBuildtoUnIrrGrass;
//	}
//
//	public void setCanopyConfigBuildtoUnIrrGrass(
//			double canopyConfigBuildtoUnIrrGrass) {
//		this.canopyConfigBuildtoUnIrrGrass = canopyConfigBuildtoUnIrrGrass;
//	}
//
//	public double getCanopyConfigBuildtoWater() {
//		return canopyConfigBuildtoWater;
//	}
//
//	public void setCanopyConfigBuildtoWater(double canopyConfigBuildtoWater) {
//		this.canopyConfigBuildtoWater = canopyConfigBuildtoWater;
//	}
//
//	public double getCanopyConfigConiftoSoil() {
//		return canopyConfigConiftoSoil;
//	}
//
//	public void setCanopyConfigConiftoSoil(double canopyConfigConiftoSoil) {
//		this.canopyConfigConiftoSoil = canopyConfigConiftoSoil;
//	}
//
//	public double getCanopyConfigConiftoPaved() {
//		return canopyConfigConiftoPaved;
//	}
//
//	public void setCanopyConfigConiftoPaved(double canopyConfigConiftoPaved) {
//		this.canopyConfigConiftoPaved = canopyConfigConiftoPaved;
//	}
//
//	public double getCanopyConfigConiftoDecid() {
//		return canopyConfigConiftoDecid;
//	}
//
//	public void setCanopyConfigConiftoDecid(double canopyConfigConiftoDecid) {
//		this.canopyConfigConiftoDecid = canopyConfigConiftoDecid;
//	}
//
//	public double getCanopyConfigConiftoIrrGrass() {
//		return canopyConfigConiftoIrrGrass;
//	}
//
//	public void setCanopyConfigConiftoIrrGrass(double canopyConfigConiftoIrrGrass) {
//		this.canopyConfigConiftoIrrGrass = canopyConfigConiftoIrrGrass;
//	}
//
//	public double getCanopyConfigConiftoUnirrGrass() {
//		return canopyConfigConiftoUnirrGrass;
//	}
//
//	public void setCanopyConfigConiftoUnirrGrass(
//			double canopyConfigConiftoUnirrGrass) {
//		this.canopyConfigConiftoUnirrGrass = canopyConfigConiftoUnirrGrass;
//	}
//
//	public double getCanopyConfigConiftoWater() {
//		return canopyConfigConiftoWater;
//	}
//
//	public void setCanopyConfigConiftoWater(double canopyConfigConiftoWater) {
//		this.canopyConfigConiftoWater = canopyConfigConiftoWater;
//	}
//
//	public double getCanopyConfigDecidtoSoil() {
//		return canopyConfigDecidtoSoil;
//	}
//
//	public void setCanopyConfigDecidtoSoil(double canopyConfigDecidtoSoil) {
//		this.canopyConfigDecidtoSoil = canopyConfigDecidtoSoil;
//	}
//
//	public double getCanopyConfigDecidtoPaved() {
//		return canopyConfigDecidtoPaved;
//	}
//
//	public void setCanopyConfigDecidtoPaved(double canopyConfigDecidtoPaved) {
//		this.canopyConfigDecidtoPaved = canopyConfigDecidtoPaved;
//	}
//
//	public double getCanopyConfigDecidtoConif() {
//		return canopyConfigDecidtoConif;
//	}
//
//	public void setCanopyConfigDecidtoConif(double canopyConfigDecidtoConif) {
//		this.canopyConfigDecidtoConif = canopyConfigDecidtoConif;
//	}
//
//	public double getCanopyConfigDecidtoIrrGrass() {
//		return canopyConfigDecidtoIrrGrass;
//	}
//
//	public void setCanopyConfigDecidtoIrrGrass(double canopyConfigDecidtoIrrGrass) {
//		this.canopyConfigDecidtoIrrGrass = canopyConfigDecidtoIrrGrass;
//	}
//
//	public double getCanopyConfigDecidtoUnirrGrass() {
//		return canopyConfigDecidtoUnirrGrass;
//	}
//
//	public void setCanopyConfigDecidtoUnirrGrass(
//			double canopyConfigDecidtoUnirrGrass) {
//		this.canopyConfigDecidtoUnirrGrass = canopyConfigDecidtoUnirrGrass;
//	}
//
//	public double getCanopyConfigDecidtoWater() {
//		return canopyConfigDecidtoWater;
//	}
//
//	public void setCanopyConfigDecidtoWater(double canopyConfigDecidtoWater) {
//		this.canopyConfigDecidtoWater = canopyConfigDecidtoWater;
//	}
//
//	public double getCanopyConfigIrrGrasstoSoil() {
//		return canopyConfigIrrGrasstoSoil;
//	}
//
//	public void setCanopyConfigIrrGrasstoSoil(double canopyConfigIrrGrasstoSoil) {
//		this.canopyConfigIrrGrasstoSoil = canopyConfigIrrGrasstoSoil;
//	}
//
//	public double getCanopyConfigIrrGrasstoPaved() {
//		return canopyConfigIrrGrasstoPaved;
//	}
//
//	public void setCanopyConfigIrrGrasstoPaved(double canopyConfigIrrGrasstoPaved) {
//		this.canopyConfigIrrGrasstoPaved = canopyConfigIrrGrasstoPaved;
//	}
//
//	public double getCanopyConfigIrrGrasstoConif() {
//		return canopyConfigIrrGrasstoConif;
//	}
//
//	public void setCanopyConfigIrrGrasstoConif(double canopyConfigIrrGrasstoConif) {
//		this.canopyConfigIrrGrasstoConif = canopyConfigIrrGrasstoConif;
//	}
//
//	public double getCanopyConfigIrrGrasstoDecid() {
//		return canopyConfigIrrGrasstoDecid;
//	}
//
//	public void setCanopyConfigIrrGrasstoDecid(double canopyConfigIrrGrasstoDecid) {
//		this.canopyConfigIrrGrasstoDecid = canopyConfigIrrGrasstoDecid;
//	}
//
//	public double getCanopyConfigIrrGrasstoUnirrGrass() {
//		return canopyConfigIrrGrasstoUnirrGrass;
//	}
//
//	public void setCanopyConfigIrrGrasstoUnirrGrass(
//			double canopyConfigIrrGrasstoUnirrGrass) {
//		this.canopyConfigIrrGrasstoUnirrGrass = canopyConfigIrrGrasstoUnirrGrass;
//	}
//
//	public double getCanopyConfigIrrGrasstoWater() {
//		return canopyConfigIrrGrasstoWater;
//	}
//
//	public void setCanopyConfigIrrGrasstoWater(double canopyConfigIrrGrasstoWater) {
//		this.canopyConfigIrrGrasstoWater = canopyConfigIrrGrasstoWater;
//	}
//
//	public double getCanopyConfigUnirrGrasstoSoil() {
//		return canopyConfigUnirrGrasstoSoil;
//	}
//
//	public void setCanopyConfigUnirrGrasstoSoil(double canopyConfigUnirrGrasstoSoil) {
//		this.canopyConfigUnirrGrasstoSoil = canopyConfigUnirrGrasstoSoil;
//	}
//
//	public double getCanopyConfigUnirrGrasstoPaved() {
//		return canopyConfigUnirrGrasstoPaved;
//	}
//
//	public void setCanopyConfigUnirrGrasstoPaved(
//			double canopyConfigUnirrGrasstoPaved) {
//		this.canopyConfigUnirrGrasstoPaved = canopyConfigUnirrGrasstoPaved;
//	}
//
//	public double getCanopyConfigUnirrGrasstoConif() {
//		return canopyConfigUnirrGrasstoConif;
//	}
//
//	public void setCanopyConfigUnirrGrasstoConif(
//			double canopyConfigUnirrGrasstoConif) {
//		this.canopyConfigUnirrGrasstoConif = canopyConfigUnirrGrasstoConif;
//	}
//
//	public double getCanopyConfigUnirrGrasstoDecid() {
//		return canopyConfigUnirrGrasstoDecid;
//	}
//
//	public void setCanopyConfigUnirrGrasstoDecid(
//			double canopyConfigUnirrGrasstoDecid) {
//		this.canopyConfigUnirrGrasstoDecid = canopyConfigUnirrGrasstoDecid;
//	}
//
//	public double getCanopyConfigUnirrGrasstoIrrGrass() {
//		return canopyConfigUnirrGrasstoIrrGrass;
//	}
//
//	public void setCanopyConfigUnirrGrasstoIrrGrass(
//			double canopyConfigUnirrGrasstoIrrGrass) {
//		this.canopyConfigUnirrGrasstoIrrGrass = canopyConfigUnirrGrasstoIrrGrass;
//	}
//
//	public double getCanopyConfigUnirrGrasstoWater() {
//		return canopyConfigUnirrGrasstoWater;
//	}
//
//	public void setCanopyConfigUnirrGrasstoWater(
//			double canopyConfigUnirrGrasstoWater) {
//		this.canopyConfigUnirrGrasstoWater = canopyConfigUnirrGrasstoWater;
//	}

	public boolean getOhmConfigCanyonsIncluded()
	{
		return ohmConfigCanyonsIncluded;
	}

	public void setOhmConfigCanyonsIncluded(boolean ohmConfigCanyonsIncluded)
	{
		this.ohmConfigCanyonsIncluded = ohmConfigCanyonsIncluded;
	}

	public int getOhmConfigCalcuationsCoefficientsCanyons()
	{
		return ohmConfigCalcuationsCoefficientsCanyons;
	}

	public void setOhmConfigCalcuationsCoefficientsCanyons(
			int ohmConfigCalcuationsCoefficientsCanyons)
	{
		this.ohmConfigCalcuationsCoefficientsCanyons = ohmConfigCalcuationsCoefficientsCanyons;
	}

	public int getOhmConfigVegetationCalculated()
	{
		return ohmConfigVegetationCalculated;
	}

	public void setOhmConfigVegetationCalculated(
			int ohmConfigVegetationCalculated)
	{
		this.ohmConfigVegetationCalculated = ohmConfigVegetationCalculated;
	}

	public String[] getOhmConfigCalcuationsCoefficientsVegetation()
	{
		return ohmConfigCalcuationsCoefficientsVegetation;
	}

	public void setOhmConfigCalcuationsCoefficientsVegetation(
			String[] ohmConfigCalcuationsCoefficientsVegetation)
	{
		this.ohmConfigCalcuationsCoefficientsVegetation = ohmConfigCalcuationsCoefficientsVegetation;
	}

	public String[] getOhmConfigCalcuationsCoefficientsRoof()
	{
		return ohmConfigCalcuationsCoefficientsRoof;
	}

	public void setOhmConfigCalcuationsCoefficientsRoof(
			String[] ohmConfigCalcuationsCoefficientsRoof)
	{
		this.ohmConfigCalcuationsCoefficientsRoof = ohmConfigCalcuationsCoefficientsRoof;
	}

	public int getOhmConfigImperviousAreasCalculated()
	{
		return ohmConfigImperviousAreasCalculated;
	}

	public void setOhmConfigImperviousAreasCalculated(
			int ohmConfigImperviousAreasCalculated)
	{
		this.ohmConfigImperviousAreasCalculated = ohmConfigImperviousAreasCalculated;
	}

	public String[] getOhmConfigCalcuationsCoefficientsImperviousAreas()
	{
		return ohmConfigCalcuationsCoefficientsImperviousAreas;
	}

	public void setOhmConfigCalcuationsCoefficientsImperviousAreas(
			String[] ohmConfigCalcuationsCoefficientsImperviousAreas)
	{
		this.ohmConfigCalcuationsCoefficientsImperviousAreas = ohmConfigCalcuationsCoefficientsImperviousAreas;
	}

//	public String[] getConfigSahpAHDIUPRF()
//	{
//		return configSahpAHDIUPRF;
//	}
//
//	public void setConfigSahpAHDIUPRF(String[] configSahpAHDIUPRF)
//	{
//		this.configSahpAHDIUPRF = configSahpAHDIUPRF;
//	}
//
//	public String[] getConfigSahpAHDIUPRF1()
//	{
//		return configSahpAHDIUPRF1;
//	}
//
//	public void setConfigSahpAHDIUPRF1(String[] configSahpAHDIUPRF1)
//	{
//		this.configSahpAHDIUPRF1 = configSahpAHDIUPRF1;
//	}
//
//	public String[] getConfigSahpAHDIUPRF2()
//	{
//		return configSahpAHDIUPRF2;
//	}
//
//	public void setConfigSahpAHDIUPRF2(String[] configSahpAHDIUPRF2)
//	{
//		this.configSahpAHDIUPRF2 = configSahpAHDIUPRF2;
//	}
//
//	public String getConfigSahpAH_MIN()
//	{
//		return configSahpAH_MIN;
//	}
//
//	public void setConfigSahpAH_MIN(String configSahpAH_MIN)
//	{
//		this.configSahpAH_MIN = configSahpAH_MIN;
//	}
//
//	public String getConfigSahpAH_SLOPE()
//	{
//		return configSahpAH_SLOPE;
//	}
//
//	public void setConfigSahpAH_SLOPE(String configSahpAH_SLOPE)
//	{
//		this.configSahpAH_SLOPE = configSahpAH_SLOPE;
//	}
//
//	public String getConfigSahpT_CRITIC()
//	{
//		return configSahpT_CRITIC;
//	}
//
//	public void setConfigSahpT_CRITIC(String configSahpT_CRITIC)
//	{
//		this.configSahpT_CRITIC = configSahpT_CRITIC;
//	}

	public double getALB1()
	{
		return ALB1;
	}

	public void setALB1(double aLB1)
	{
		ALB1 = aLB1;
	}

	public double getALB2()
	{
		return ALB2;
	}

	public void setALB2(double aLB2)
	{
		ALB2 = aLB2;
	}

	public double getALB3()
	{
		return ALB3;
	}

	public void setALB3(double aLB3)
	{
		ALB3 = aLB3;
	}

	public double getALB4()
	{
		return ALB4;
	}

	public void setALB4(double aLB4)
	{
		ALB4 = aLB4;
	}

	public double getALB5()
	{
		return ALB5;
	}

	public void setALB5(double aLB5)
	{
		ALB5 = aLB5;
	}

	public double getALB6()
	{
		return ALB6;
	}

	public void setALB6(double aLB6)
	{
		ALB6 = aLB6;
	}

//	public double getALB7()
//	{
//		return ALB7;
//	}
//
//	public void setALB7(double aLB7)
//	{
//		ALB7 = aLB7;
//	}

	public double getALB_SNOW()
	{
		return ALB_SNOW;
	}

	public void setALB_SNOW(double aLB_SNOW)
	{
		ALB_SNOW = aLB_SNOW;
	}

//	public int getAnthropHeatChoice()
//	{
//		return AnthropHeatChoice;
//	}
//
//	public void setAnthropHeatChoice(int anthropHeatChoice)
//	{
//		AnthropHeatChoice = anthropHeatChoice;
//	}
//
//	public double getBaseT1()
//	{
//		return BaseT1;
//	}
//
//	public void setBaseT1(double baseT1)
//	{
//		BaseT1 = baseT1;
//	}
//
//	public double getBaseT2()
//	{
//		return BaseT2;
//	}
//
//	public void setBaseT2(double baseT2)
//	{
//		BaseT2 = baseT2;
//	}
//
//	public double getBaseT3()
//	{
//		return BaseT3;
//	}
//
//	public void setBaseT3(double baseT3)
//	{
//		BaseT3 = baseT3;
//	}
//
//	public double getBaseT4()
//	{
//		return BaseT4;
//	}
//
//	public void setBaseT4(double baseT4)
//	{
//		BaseT4 = baseT4;
//	}
//
//	public double getBaseTe1()
//	{
//		return BaseTe1;
//	}
//
//	public void setBaseTe1(double baseTe1)
//	{
//		BaseTe1 = baseTe1;
//	}
//
//	public double getBaseTe2()
//	{
//		return BaseTe2;
//	}
//
//	public void setBaseTe2(double baseTe2)
//	{
//		BaseTe2 = baseTe2;
//	}
//
//	public double getBaseTe3()
//	{
//		return BaseTe3;
//	}
//
//	public void setBaseTe3(double baseTe3)
//	{
//		BaseTe3 = baseTe3;
//	}
//
//	public double getBaseTe4()
//	{
//		return BaseTe4;
//	}
//
//	public void setBaseTe4(double baseTe4)
//	{
//		BaseTe4 = baseTe4;
//	}
//
//	public double getBaseTHDD()
//	{
//		return BaseTHDD;
//	}
//
//	public void setBaseTHDD(double baseTHDD)
//	{
//		BaseTHDD = baseTHDD;
//	}
//
//	public double getBlgH()
//	{
//		return blgH;
//	}
//
//	public void setBlgH(double blgH)
//	{
//		this.blgH = blgH;
//	}
//
//	public int getDayLightSavingDay1()
//	{
//		return DayLightSavingDay1;
//	}
//
//	public void setDayLightSavingDay1(int dayLightSavingDay1)
//	{
//		DayLightSavingDay1 = dayLightSavingDay1;
//	}
//
//	public int getDayLightSavingDay2()
//	{
//		return DayLightSavingDay2;
//	}
//
//	public void setDayLightSavingDay2(int dayLightSavingDay2)
//	{
//		DayLightSavingDay2 = dayLightSavingDay2;
//	}

	public double getDefaultFcld()
	{
		return defaultFcld;
	}

	public void setDefaultFcld(double defaultFcld)
	{
		this.defaultFcld = defaultFcld;
	}

	public double getDefaultPres()
	{
		return defaultPres;
	}

	public void setDefaultPres(double defaultPres)
	{
		this.defaultPres = defaultPres;
	}

	public double getDefaultRH()
	{
		return defaultRH;
	}

	public void setDefaultRH(double defaultRH)
	{
		this.defaultRH = defaultRH;
	}

	public double getDefaultT()
	{
		return defaultT;
	}

	public void setDefaultT(double defaultT)
	{
		this.defaultT = defaultT;
	}

//	public double getDefaultU()
//	{
//		return defaultU;
//	}
//
//	public void setDefaultU(double defaultU)
//	{
//		this.defaultU = defaultU;
//	}
//
//	public double getDefaultQf()
//	{
//		return defaultQf;
//	}
//
//	public void setDefaultQf(double defaultQf)
//	{
//		this.defaultQf = defaultQf;
//	}
//
//	public double getDefaultQs()
//	{
//		return defaultQs;
//	}
//
//	public void setDefaultQs(double defaultQs)
//	{
//		this.defaultQs = defaultQs;
//	}

	public double getDRAINRT()
	{
		return DRAINRT;
	}

	public void setDRAINRT(double dRAINRT)
	{
		DRAINRT = dRAINRT;
	}

	public double getEMIS1()
	{
		return EMIS1;
	}

	public void setEMIS1(double eMIS1)
	{
		EMIS1 = eMIS1;
	}

	public double getEMIS2()
	{
		return EMIS2;
	}

	public void setEMIS2(double eMIS2)
	{
		EMIS2 = eMIS2;
	}

	public double getEMIS3()
	{
		return EMIS3;
	}

	public void setEMIS3(double eMIS3)
	{
		EMIS3 = eMIS3;
	}

	public double getEMIS4()
	{
		return EMIS4;
	}

	public void setEMIS4(double eMIS4)
	{
		EMIS4 = eMIS4;
	}

	public double getEMIS5()
	{
		return EMIS5;
	}

	public void setEMIS5(double eMIS5)
	{
		EMIS5 = eMIS5;
	}

	public double getEMIS6()
	{
		return EMIS6;
	}

	public void setEMIS6(double eMIS6)
	{
		EMIS6 = eMIS6;
	}

//	public double getEMIS7()
//	{
//		return EMIS7;
//	}
//
//	public void setEMIS7(double eMIS7)
//	{
//		EMIS7 = eMIS7;
//	}

	public double getEMIS_SNOW()
	{
		return EMIS_SNOW;
	}

	public void setEMIS_SNOW(double eMIS_SNOW)
	{
		EMIS_SNOW = eMIS_SNOW;
	}

//	public double getGDDFull1()
//	{
//		return GDDFull1;
//	}
//
//	public void setGDDFull1(double gDDFull1)
//	{
//		GDDFull1 = gDDFull1;
//	}
//
//	public double getGDDFull2()
//	{
//		return GDDFull2;
//	}
//
//	public void setGDDFull2(double gDDFull2)
//	{
//		GDDFull2 = gDDFull2;
//	}
//
//	public double getGDDFull3()
//	{
//		return GDDFull3;
//	}
//
//	public void setGDDFull3(double gDDFull3)
//	{
//		GDDFull3 = gDDFull3;
//	}
//
//	public double getGDDFull4()
//	{
//		return GDDFull4;
//	}
//
//	public void setGDDFull4(double gDDFull4)
//	{
//		GDDFull4 = gDDFull4;
//	}

	public int getGISInputType()
	{
		return GISInputType;
	}

	public void setGISInputType(int gISInputType)
	{
		GISInputType = gISInputType;
	}

	public int getINTERVAL()
	{
		return INTERVAL;
	}

	public void setINTERVAL(int iNTERVAL)
	{
		INTERVAL = iNTERVAL;
	}

//	public double getLAImax1()
//	{
//		return LAImax1;
//	}
//
//	public void setLAImax1(double lAImax1)
//	{
//		LAImax1 = lAImax1;
//	}
//
//	public double getLAImax2()
//	{
//		return LAImax2;
//	}
//
//	public void setLAImax2(double lAImax2)
//	{
//		LAImax2 = lAImax2;
//	}
//
//	public double getLAImax3()
//	{
//		return LAImax3;
//	}
//
//	public void setLAImax3(double lAImax3)
//	{
//		LAImax3 = lAImax3;
//	}
//
//	public double getLAImax4()
//	{
//		return LAImax4;
//	}
//
//	public void setLAImax4(double lAImax4)
//	{
//		LAImax4 = lAImax4;
//	}
//
//	public double getLAImin1()
//	{
//		return LAImin1;
//	}
//
//	public void setLAImin1(double lAImin1)
//	{
//		LAImin1 = lAImin1;
//	}
//
//	public double getLAImin2()
//	{
//		return LAImin2;
//	}
//
//	public void setLAImin2(double lAImin2)
//	{
//		LAImin2 = lAImin2;
//	}
//
//	public double getLAImin3()
//	{
//		return LAImin3;
//	}
//
//	public void setLAImin3(double lAImin3)
//	{
//		LAImin3 = lAImin3;
//	}
//
//	public double getLAImin4()
//	{
//		return LAImin4;
//	}
//
//	public void setLAImin4(double lAImin4)
//	{
//		LAImin4 = lAImin4;
//	}

	public double getLat()
	{
		return lat;
	}

	public void setLat(double lat)
	{
		this.lat = lat;
	}

	public double getLng()
	{
		return lng;
	}

	public void setLng(double lng)
	{
		this.lng = lng;
	}

	public int getNARPOutput()
	{
		return NARPOutput;
	}

	public void setNARPOutput(int nARPOutput)
	{
		NARPOutput = nARPOutput;
	}

	public int getNetRadiationChoice()
	{
		return NetRadiationChoice;
	}

	public void setNetRadiationChoice(int netRadiationChoice)
	{
		NetRadiationChoice = netRadiationChoice;
	}

//	public int getNumCapita()
//	{
//		return numCapita;
//	}
//
//	public void setNumCapita(int numCapita)
//	{
//		this.numCapita = numCapita;
//	}

	public int getLdown_option()
	{
		return ldown_option;
	}

	public void setLdown_option(int ldown_option)
	{
		this.ldown_option = ldown_option;
	}

//	public double getQf_A1()
//	{
//		return Qf_A1;
//	}
//
//	public void setQf_A1(double qf_A1)
//	{
//		Qf_A1 = qf_A1;
//	}
//
//	public double getQf_A2()
//	{
//		return Qf_A2;
//	}
//
//	public void setQf_A2(double qf_A2)
//	{
//		Qf_A2 = qf_A2;
//	}
//
//	public double getQf_B1()
//	{
//		return Qf_B1;
//	}
//
//	public void setQf_B1(double qf_B1)
//	{
//		Qf_B1 = qf_B1;
//	}
//
//	public double getQf_B2()
//	{
//		return Qf_B2;
//	}
//
//	public void setQf_B2(double qf_B2)
//	{
//		Qf_B2 = qf_B2;
//	}
//
//	public double getQf_C1()
//	{
//		return Qf_C1;
//	}
//
//	public void setQf_C1(double qf_C1)
//	{
//		Qf_C1 = qf_C1;
//	}
//
//	public double getQf_C2()
//	{
//		return Qf_C2;
//	}
//
//	public void setQf_C2(double qf_C2)
//	{
//		Qf_C2 = qf_C2;
//	}

	public int getQSChoice()
	{
		return QSChoice;
	}

	public void setQSChoice(int qSChoice)
	{
		QSChoice = qSChoice;
	}

	public double getRAINCOVER()
	{
		return RAINCOVER;
	}

	public void setRAINCOVER(double rAINCOVER)
	{
		RAINCOVER = rAINCOVER;
	}

	public double getRAINMAXRES()
	{
		return RAINMAXRES;
	}

	public void setRAINMAXRES(double rAINMAXRES)
	{
		RAINMAXRES = rAINMAXRES;
	}

//	public double getSDDFull1()
//	{
//		return SDDFull1;
//	}
//
//	public void setSDDFull1(double sDDFull1)
//	{
//		SDDFull1 = sDDFull1;
//	}
//
//	public double getSDDFull2()
//	{
//		return SDDFull2;
//	}
//
//	public void setSDDFull2(double sDDFull2)
//	{
//		SDDFull2 = sDDFull2;
//	}
//
//	public double getSDDFull3()
//	{
//		return SDDFull3;
//	}
//
//	public void setSDDFull3(double sDDFull3)
//	{
//		SDDFull3 = sDDFull3;
//	}
//
//	public double getSDDFull4()
//	{
//		return SDDFull4;
//	}
//
//	public void setSDDFull4(double sDDFull4)
//	{
//		SDDFull4 = sDDFull4;
//	}

	public int getSkipHeaderGIS()
	{
		return SkipHeaderGIS;
	}

	public void setSkipHeaderGIS(int skipHeaderGIS)
	{
		SkipHeaderGIS = skipHeaderGIS;
	}

	public int getSkipHeaderMet()
	{
		return SkipHeaderMet;
	}

	public void setSkipHeaderMet(int skipHeaderMet)
	{
		SkipHeaderMet = skipHeaderMet;
	}

//	public int getSuewsStatus()
//	{
//		return SuewsStatus;
//	}
//
//	public void setSuewsStatus(int suewsStatus)
//	{
//		SuewsStatus = suewsStatus;
//	}

	public int getTIMEZONE()
	{
		return TIMEZONE;
	}

	public void setTIMEZONE(int tIMEZONE)
	{
		TIMEZONE = tIMEZONE;
	}

	public int getTRANS_SITE()
	{
		return TRANS_SITE;
	}

	public void setTRANS_SITE(int tRANS_SITE)
	{
		TRANS_SITE = tRANS_SITE;
	}

//	public double getTreeH()
//	{
//		return TreeH;
//	}
//
//	public void setTreeH(double treeH)
//	{
//		TreeH = treeH;
//	}

	public int getVeg_type()
	{
		return Veg_type;
	}

	public void setVeg_type(int veg_type)
	{
		Veg_type = veg_type;
	}

//	public double getZ()
//	{
//		return z;
//	}
//
//	public void setZ(double z)
//	{
//		this.z = z;
//	}
//
//	public int getZ0_method()
//	{
//		return z0_method;
//	}
//
//	public void setZ0_method(int z0_method)
//	{
//		this.z0_method = z0_method;
//	}

//	public double getBldgStorCap()
//	{
//		return BldgStorCap;
//	}
//
//	public void setBldgStorCap(double bldgStorCap)
//	{
//		BldgStorCap = bldgStorCap;
//	}
//
//	public double getBldgDrainCoef1()
//	{
//		return BldgDrainCoef1;
//	}
//
//	public void setBldgDrainCoef1(double bldgDrainCoef1)
//	{
//		BldgDrainCoef1 = bldgDrainCoef1;
//	}
//
//	public double getBldgDrainCoef2()
//	{
//		return BldgDrainCoef2;
//	}
//
//	public void setBldgDrainCoef2(double bldgDrainCoef2)
//	{
//		BldgDrainCoef2 = bldgDrainCoef2;
//	}
//
//	public double getBldgState()
//	{
//		return BldgState;
//	}
//
//	public void setBldgState(double bldgState)
//	{
//		BldgState = bldgState;
//	}
//
//	public double getConifStorCap()
//	{
//		return ConifStorCap;
//	}
//
//	public void setConifStorCap(double conifStorCap)
//	{
//		ConifStorCap = conifStorCap;
//	}
//
//	public double getConifDrainCoef1()
//	{
//		return ConifDrainCoef1;
//	}
//
//	public void setConifDrainCoef1(double conifDrainCoef1)
//	{
//		ConifDrainCoef1 = conifDrainCoef1;
//	}
//
//	public double getConifDrainCoef2()
//	{
//		return ConifDrainCoef2;
//	}
//
//	public void setConifDrainCoef2(double conifDrainCoef2)
//	{
//		ConifDrainCoef2 = conifDrainCoef2;
//	}
//
//	public double getConifState()
//	{
//		return ConifState;
//	}
//
//	public void setConifState(double conifState)
//	{
//		ConifState = conifState;
//	}
//
//	public double getDecidStorCap()
//	{
//		return DecidStorCap;
//	}
//
//	public void setDecidStorCap(double decidStorCap)
//	{
//		DecidStorCap = decidStorCap;
//	}
//
//	public double getDecidDrainCoef1()
//	{
//		return DecidDrainCoef1;
//	}
//
//	public void setDecidDrainCoef1(double decidDrainCoef1)
//	{
//		DecidDrainCoef1 = decidDrainCoef1;
//	}
//
//	public double getDecidDrainCoef2()
//	{
//		return DecidDrainCoef2;
//	}
//
//	public void setDecidDrainCoef2(double decidDrainCoef2)
//	{
//		DecidDrainCoef2 = decidDrainCoef2;
//	}
//
//	public double getDecidState()
//	{
//		return DecidState;
//	}
//
//	public void setDecidState(double decidState)
//	{
//		DecidState = decidState;
//	}
//
//	public double getFlowChange()
//	{
//		return FlowChange;
//	}
//
//	public void setFlowChange(double flowChange)
//	{
//		FlowChange = flowChange;
//	}
//
//	public double getG1()
//	{
//		return G1;
//	}
//
//	public void setG1(double g1)
//	{
//		G1 = g1;
//	}
//
//	public double getG2()
//	{
//		return G2;
//	}
//
//	public void setG2(double g2)
//	{
//		G2 = g2;
//	}
//
//	public double getG3()
//	{
//		return G3;
//	}
//
//	public void setG3(double g3)
//	{
//		G3 = g3;
//	}
//
//	public double getG4()
//	{
//		return G4;
//	}
//
//	public void setG4(double g4)
//	{
//		G4 = g4;
//	}
//
//	public double getG5()
//	{
//		return G5;
//	}
//
//	public void setG5(double g5)
//	{
//		G5 = g5;
//	}
//
//	public double getG6()
//	{
//		return G6;
//	}
//
//	public void setG6(double g6)
//	{
//		G6 = g6;
//	}
//
//	public double getGrassUStorCap()
//	{
//		return GrassUStorCap;
//	}
//
//	public void setGrassUStorCap(double grassUStorCap)
//	{
//		GrassUStorCap = grassUStorCap;
//	}
//
//	public double getGrassUDrainCoef1()
//	{
//		return GrassUDrainCoef1;
//	}
//
//	public void setGrassUDrainCoef1(double grassUDrainCoef1)
//	{
//		GrassUDrainCoef1 = grassUDrainCoef1;
//	}
//
//	public double getGrassUDrainCoef2()
//	{
//		return GrassUDrainCoef2;
//	}
//
//	public void setGrassUDrainCoef2(double grassUDrainCoef2)
//	{
//		GrassUDrainCoef2 = grassUDrainCoef2;
//	}
//
//	public double getGrassUState()
//	{
//		return GrassUState;
//	}
//
//	public void setGrassUState(double grassUState)
//	{
//		GrassUState = grassUState;
//	}
//
//	public double getGrassIStorCap()
//	{
//		return GrassIStorCap;
//	}
//
//	public void setGrassIStorCap(double grassIStorCap)
//	{
//		GrassIStorCap = grassIStorCap;
//	}
//
//	public double getGrassIDrainCoef1()
//	{
//		return GrassIDrainCoef1;
//	}
//
//	public void setGrassIDrainCoef1(double grassIDrainCoef1)
//	{
//		GrassIDrainCoef1 = grassIDrainCoef1;
//	}
//
//	public double getGrassIDrainCoef2()
//	{
//		return GrassIDrainCoef2;
//	}
//
//	public void setGrassIDrainCoef2(double grassIDrainCoef2)
//	{
//		GrassIDrainCoef2 = grassIDrainCoef2;
//	}
//
//	public double getGrassIState()
//	{
//		return GrassIState;
//	}
//
//	public void setGrassIState(double grassIState)
//	{
//		GrassIState = grassIState;
//	}
//
//	public double getSatHydraulicConduct()
//	{
//		return SatHydraulicConduct;
//	}
//
//	public void setSatHydraulicConduct(double satHydraulicConduct)
//	{
//		SatHydraulicConduct = satHydraulicConduct;
//	}
//
//	public double getInternalWaterUse()
//	{
//		return InternalWaterUse;
//	}
//
//	public void setInternalWaterUse(double internalWaterUse)
//	{
//		InternalWaterUse = internalWaterUse;
//	}
//
//	public double getKmax()
//	{
//		return Kmax;
//	}
//
//	public void setKmax(double kmax)
//	{
//		Kmax = kmax;
//	}
//
//	public double getPavStorCap()
//	{
//		return PavStorCap;
//	}
//
//	public void setPavStorCap(double pavStorCap)
//	{
//		PavStorCap = pavStorCap;
//	}
//
//	public double getPavDrainCoef1()
//	{
//		return PavDrainCoef1;
//	}
//
//	public void setPavDrainCoef1(double pavDrainCoef1)
//	{
//		PavDrainCoef1 = pavDrainCoef1;
//	}
//
//	public double getPavDrainCoef2()
//	{
//		return PavDrainCoef2;
//	}
//
//	public void setPavDrainCoef2(double pavDrainCoef2)
//	{
//		PavDrainCoef2 = pavDrainCoef2;
//	}
//
//	public double getPavState()
//	{
//		return PavState;
//	}
//
//	public void setPavState(double pavState)
//	{
//		PavState = pavState;
//	}
//
//	public String getPipeCapacity()
//	{
//		return PipeCapacity;
//	}
//
//	public void setPipeCapacity(String pipeCapacity)
//	{
//		PipeCapacity = pipeCapacity;
//	}
//
//	public double getRunoffToWater()
//	{
//		return RunoffToWater;
//	}
//
//	public void setRunoffToWater(double runoffToWater)
//	{
//		RunoffToWater = runoffToWater;
//	}
//
//	public int getRoughLen_heat()
//	{
//		return RoughLen_heat;
//	}
//
//	public void setRoughLen_heat(int roughLen_heat)
//	{
//		RoughLen_heat = roughLen_heat;
//	}
//
//	public double getS1()
//	{
//		return S1;
//	}
//
//	public void setS1(double s1)
//	{
//		S1 = s1;
//	}
//
//	public double getS2()
//	{
//		return S2;
//	}
//
//	public void setS2(double s2)
//	{
//		S2 = s2;
//	}
//
//	public double getSDECStor()
//	{
//		return SDECStor;
//	}
//
//	public void setSDECStor(double sDECStor)
//	{
//		SDECStor = sDECStor;
//	}
//
//	public double getSmCap()
//	{
//		return SmCap;
//	}
//
//	public void setSmCap(double smCap)
//	{
//		SmCap = smCap;
//	}
//
//	public int getSmd_choice()
//	{
//		return smd_choice;
//	}
//
//	public void setSmd_choice(int smd_choice)
//	{
//		this.smd_choice = smd_choice;
//	}
//
//	public int getSm_input()
//	{
//		return sm_input;
//	}
//
//	public void setSm_input(int sm_input)
//	{
//		this.sm_input = sm_input;
//	}
//
//	public double getSoilDensity()
//	{
//		return SoilDensity;
//	}
//
//	public void setSoilDensity(double soilDensity)
//	{
//		SoilDensity = soilDensity;
//	}
//
//	public double getSoilDepth()
//	{
//		return SoilDepth;
//	}
//
//	public void setSoilDepth(double soilDepth)
//	{
//		SoilDepth = soilDepth;
//	}
//
//	public double getSoilDepthMeas()
//	{
//		return SoilDepthMeas;
//	}
//
//	public void setSoilDepthMeas(double soilDepthMeas)
//	{
//		SoilDepthMeas = soilDepthMeas;
//	}
//
//	public double getSoilRocks()
//	{
//		return SoilRocks;
//	}
//
//	public void setSoilRocks(double soilRocks)
//	{
//		SoilRocks = soilRocks;
//	}
//
//	public double getSoilstorePav()
//	{
//		return soilstorePav;
//	}
//
//	public void setSoilstorePav(double soilstorePav)
//	{
//		this.soilstorePav = soilstorePav;
//	}
//
//	public double getSoilstoreBldg()
//	{
//		return soilstoreBldg;
//	}
//
//	public void setSoilstoreBldg(double soilstoreBldg)
//	{
//		this.soilstoreBldg = soilstoreBldg;
//	}
//
//	public double getSoilstorePavstate()
//	{
//		return soilstorePavstate;
//	}
//
//	public void setSoilstorePavstate(double soilstorePavstate)
//	{
//		this.soilstorePavstate = soilstorePavstate;
//	}
//
//	public double getSoilstoreBldgstate()
//	{
//		return soilstoreBldgstate;
//	}
//
//	public void setSoilstoreBldgstate(double soilstoreBldgstate)
//	{
//		this.soilstoreBldgstate = soilstoreBldgstate;
//	}
//
//	public double getSoilstoreConif()
//	{
//		return soilstoreConif;
//	}
//
//	public void setSoilstoreConif(double soilstoreConif)
//	{
//		this.soilstoreConif = soilstoreConif;
//	}
//
//	public double getSoilstoreDec()
//	{
//		return soilstoreDec;
//	}
//
//	public void setSoilstoreDec(double soilstoreDec)
//	{
//		this.soilstoreDec = soilstoreDec;
//	}
//
//	public double getSoilstoreGrass()
//	{
//		return soilstoreGrass;
//	}
//
//	public void setSoilstoreGrass(double soilstoreGrass)
//	{
//		this.soilstoreGrass = soilstoreGrass;
//	}
//
//	public double getSoilstoreConifstate()
//	{
//		return soilstoreConifstate;
//	}
//
//	public void setSoilstoreConifstate(double soilstoreConifstate)
//	{
//		this.soilstoreConifstate = soilstoreConifstate;
//	}
//
//	public double getSoilstoreDecstate()
//	{
//		return soilstoreDecstate;
//	}
//
//	public void setSoilstoreDecstate(double soilstoreDecstate)
//	{
//		this.soilstoreDecstate = soilstoreDecstate;
//	}
//
//	public double getSoilstoreGrassUnirstate()
//	{
//		return soilstoreGrassUnirstate;
//	}
//
//	public void setSoilstoreGrassUnirstate(double soilstoreGrassUnirstate)
//	{
//		this.soilstoreGrassUnirstate = soilstoreGrassUnirstate;
//	}
//
//	public double getSoilstoreGrassirrstate()
//	{
//		return soilstoreGrassirrstate;
//	}
//
//	public void setSoilstoreGrassirrstate(double soilstoreGrassirrstate)
//	{
//		this.soilstoreGrassirrstate = soilstoreGrassirrstate;
//	}
//
//	public int getStabilityMethod()
//	{
//		return StabilityMethod;
//	}
//
//	public void setStabilityMethod(int stabilityMethod)
//	{
//		StabilityMethod = stabilityMethod;
//	}
//
//	public int getSurfaceArea()
//	{
//		return SurfaceArea;
//	}
//
//	public void setSurfaceArea(int surfaceArea)
//	{
//		SurfaceArea = surfaceArea;
//	}
//
//	public double getTH()
//	{
//		return TH;
//	}
//
//	public void setTH(double tH)
//	{
//		TH = tH;
//	}
//
//	public double getTL()
//	{
//		return TL;
//	}
//
//	public void setTL(double tL)
//	{
//		TL = tL;
//	}
//
//	public int getTstep()
//	{
//		return Tstep;
//	}
//
//	public void setTstep(int tstep)
//	{
//		Tstep = tstep;
//	}
//
//	public int getWaterUseArea()
//	{
//		return WaterUseArea;
//	}
//
//	public void setWaterUseArea(int waterUseArea)
//	{
//		WaterUseArea = waterUseArea;
//	}
//
//	public double getWaterState()
//	{
//		return WaterState;
//	}
//
//	public void setWaterState(double waterState)
//	{
//		WaterState = waterState;
//	}
//
//	public String getWaterStorCap()
//	{
//		return WaterStorCap;
//	}
//
//	public void setWaterStorCap(String waterStorCap)
//	{
//		WaterStorCap = waterStorCap;
//	}
//
//	public int getWrite5min()
//	{
//		return write5min;
//	}
//
//	public void setWrite5min(int write5min)
//	{
//		this.write5min = write5min;
//	}

	public int getIe_start()
	{
		return Ie_start;
	}

	public void setIe_start(int ie_start)
	{
		Ie_start = ie_start;
	}

	public int getIe_end()
	{
		return Ie_end;
	}

	public void setIe_end(int ie_end)
	{
		Ie_end = ie_end;
	}

	public double getFaut()
	{
		return Faut;
	}

	public void setFaut(double faut)
	{
		Faut = faut;
	}

	public double getIe_a1()
	{
		return Ie_a1;
	}

	public void setIe_a1(double ie_a1)
	{
		Ie_a1 = ie_a1;
	}

	public double getIe_a2()
	{
		return Ie_a2;
	}

	public void setIe_a2(double ie_a2)
	{
		Ie_a2 = ie_a2;
	}

	public double getIe_a3()
	{
		return Ie_a3;
	}

	public void setIe_a3(double ie_a3)
	{
		Ie_a3 = ie_a3;
	}

	public double getIe_m1()
	{
		return Ie_m1;
	}

	public void setIe_m1(double ie_m1)
	{
		Ie_m1 = ie_m1;
	}

	public double getIe_m2()
	{
		return Ie_m2;
	}

	public void setIe_m2(double ie_m2)
	{
		Ie_m2 = ie_m2;
	}

	public double getIe_m3()
	{
		return Ie_m3;
	}

	public void setIe_m3(double ie_m3)
	{
		Ie_m3 = ie_m3;
	}

	public int getDayWat1()
	{
		return DayWat1;
	}

	public void setDayWat1(int dayWat1)
	{
		DayWat1 = dayWat1;
	}

	public int getDayWat2()
	{
		return DayWat2;
	}

	public void setDayWat2(int dayWat2)
	{
		DayWat2 = dayWat2;
	}

	public int getDayWat3()
	{
		return DayWat3;
	}

	public void setDayWat3(int dayWat3)
	{
		DayWat3 = dayWat3;
	}

	public int getDayWat4()
	{
		return DayWat4;
	}

	public void setDayWat4(int dayWat4)
	{
		DayWat4 = dayWat4;
	}

	public int getDayWat5()
	{
		return DayWat5;
	}

	public void setDayWat5(int dayWat5)
	{
		DayWat5 = dayWat5;
	}

	public int getDayWat6()
	{
		return DayWat6;
	}

	public void setDayWat6(int dayWat6)
	{
		DayWat6 = dayWat6;
	}

	public int getDayWat7()
	{
		return DayWat7;
	}

	public void setDayWat7(int dayWat7)
	{
		DayWat7 = dayWat7;
	}

	public double getDayWatPer1()
	{
		return DayWatPer1;
	}

	public void setDayWatPer1(double dayWatPer1)
	{
		DayWatPer1 = dayWatPer1;
	}

	public double getDayWatPer2()
	{
		return DayWatPer2;
	}

	public void setDayWatPer2(double dayWatPer2)
	{
		DayWatPer2 = dayWatPer2;
	}

	public double getDayWatPer3()
	{
		return DayWatPer3;
	}

	public void setDayWatPer3(double dayWatPer3)
	{
		DayWatPer3 = dayWatPer3;
	}

	public double getDayWatPer4()
	{
		return DayWatPer4;
	}

	public void setDayWatPer4(double dayWatPer4)
	{
		DayWatPer4 = dayWatPer4;
	}

	public double getDayWatPer5()
	{
		return DayWatPer5;
	}

	public void setDayWatPer5(double dayWatPer5)
	{
		DayWatPer5 = dayWatPer5;
	}

	public double getDayWatPer6()
	{
		return DayWatPer6;
	}

	public void setDayWatPer6(double dayWatPer6)
	{
		DayWatPer6 = dayWatPer6;
	}

	public double getDayWatPer7()
	{
		return DayWatPer7;
	}

	public void setDayWatPer7(double dayWatPer7)
	{
		DayWatPer7 = dayWatPer7;
	}

	public int getHourResChoice()
	{
		return HourResChoice;
	}

	public void setHourResChoice(int hourResChoice)
	{
		HourResChoice = hourResChoice;
	}

	public String[] getHourWat()
	{
		return HourWat;
	}

	public void setHourWat(String[] hourWat)
	{
		HourWat = hourWat;
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

	public int getCommonChoiceAllSites()
	{
		return CommonChoiceAllSites;
	}

	public void setCommonChoiceAllSites(int commonChoiceAllSites)
	{
		CommonChoiceAllSites = commonChoiceAllSites;
	}

	public int getD3_CalcYes()
	{
		return D3_CalcYes;
	}

	public void setD3_CalcYes(int d3_CalcYes)
	{
		D3_CalcYes = d3_CalcYes;
	}

	public String getFileChoices()
	{
		return FileChoices;
	}

	public void setFileChoices(String fileChoices)
	{
		FileChoices = fileChoices;
	}

	public String getFileGIS()
	{
		return FileGIS;
	}

	public void setFileGIS(String fileGIS)
	{
		FileGIS = fileGIS;
	}

	public String getFileMet()
	{
		return FileMet;
	}

	public void setFileMet(String fileMet)
	{
		FileMet = fileMet;
	}

	public String getFileOHM()
	{
		return FileOHM;
	}

	public void setFileOHM(String fileOHM)
	{
		FileOHM = fileOHM;
	}

	public String getFileOut15()
	{
		return FileOut15;
	}

	public void setFileOut15(String fileOut15)
	{
		FileOut15 = fileOut15;
	}

	public String getFileOut30()
	{
		return FileOut30;
	}

	public void setFileOut30(String fileOut30)
	{
		FileOut30 = fileOut30;
	}

	public String getFileOut60()
	{
		return FileOut60;
	}

	public void setFileOut60(String fileOut60)
	{
		FileOut60 = fileOut60;
	}

	public String getFileErrorInf()
	{
		return FileErrorInf;
	}

	public void setFileErrorInf(String fileErrorInf)
	{
		FileErrorInf = fileErrorInf;
	}

	public String getNARPOut()
	{
		return NARPOut;
	}

	public void setNARPOut(String nARPOut)
	{
		NARPOut = nARPOut;
	}

	public int getGrassFractionIrrigated()
	{
		return GrassFractionIrrigated;
	}

	public void setGrassFractionIrrigated(int grassFractionIrrigated)
	{
		GrassFractionIrrigated = grassFractionIrrigated;
	}

	public int getOhmFileType()
	{
		return OhmFileType;
	}

	public void setOhmFileType(int ohmFileType)
	{
		OhmFileType = ohmFileType;
	}

	public double getPavedFractionIrrigated()
	{
		return PavedFractionIrrigated;
	}

	public void setPavedFractionIrrigated(double pavedFractionIrrigated)
	{
		PavedFractionIrrigated = pavedFractionIrrigated;
	}

	public int getSDEC1()
	{
		return SDEC1;
	}

	public void setSDEC1(int sDEC1)
	{
		SDEC1 = sDEC1;
	}

	public int getSDEC2()
	{
		return SDEC2;
	}

	public void setSDEC2(int sDEC2)
	{
		SDEC2 = sDEC2;
	}

	public int getSDEC3()
	{
		return SDEC3;
	}

	public void setSDEC3(int sDEC3)
	{
		SDEC3 = sDEC3;
	}

	public int getSDEC4()
	{
		return SDEC4;
	}

	public void setSDEC4(int sDEC4)
	{
		SDEC4 = sDEC4;
	}

	public double getTreeFractionIrrigated()
	{
		return TreeFractionIrrigated;
	}

	public void setTreeFractionIrrigated(double treeFractionIrrigated)
	{
		TreeFractionIrrigated = treeFractionIrrigated;
	}

	public int getDifferentOutPuts()
	{
		return DifferentOutPuts;
	}

	public void setDifferentOutPuts(int differentOutPuts)
	{
		DifferentOutPuts = differentOutPuts;
	}

	public Double getGisConfigAngle()
	{
		return gisConfigAngle;
	}

	public void setGisConfigAngle(Double gisConfigAngle)
	{
		this.gisConfigAngle = gisConfigAngle;
	}

}
