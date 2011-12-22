package au.edu.monash.ges.suews;

public class SuewsConfigHeaderInput
{
	
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "HeaderInput";
	public final String FILENAME_SUFFUX = ".nml";
	
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;
		
	private double ALB1=0.12;
	private double ALB2=0.15;
	private double ALB3=0.10;
	private double ALB4=0.18;
	private double ALB5=0.21;
	private double ALB6=0.21;
	private double ALB7=0.10;
	private double ALB_SNOW=0.35;
	private int AnthropHeatChoice=2;
	private double BaseT1=5;
	private double BaseT2=5;
	private double BaseT3=5;
	private double BaseT4=5;
	private double BaseTe1=13;
	private double BaseTe2=13;
	private double BaseTe3=13;
	private double BaseTe4=13;
	private double BaseTHDD=18.2;
	private double blgH=6.4;
	private int DayLightSavingDay1=275;
	private int DayLightSavingDay2=93;
	private double defaultFcld=0.1;
	private double defaultPres=1013;
	private double defaultRH=50;
	private double defaultT=10;
	private double defaultU=3;
	private double defaultQf=10;  
	private double defaultQs=10;
	private double DRAINRT=0.25;
	private double EMIS1=0.95;
	private double EMIS2=0.91;
	private double EMIS3=0.98;
	private double EMIS4=0.98;
	private double EMIS5=0.93;
	private double EMIS6=0.93;
	private double EMIS7=0.95;
	private double EMIS_SNOW=0.99;
	private double GDDFull1=300;
	private double GDDFull2=300;
	private double GDDFull3=300;
	private double GDDFull4=300;
	private int GISInputType=3;
	private int INTERVAL=60;
	private double LAImax1=5.1;
	private double LAImax2=5.5;
	private double LAImax3=5.9;
	private double LAImax4=5.9;
	private double LAImin1=4.0;
	private double LAImin2=1.0;
	private double LAImin3=1.6;
	private double LAImin4=1.6;
	private double lat=-37.49;
	private double lng=144.53;
	private int NARPOutput=1;
	private int NetRadiationChoice=2;
	private int numCapita=2939;
	private int ldown_option=1;
	private double Qf_A1=0.014711;
	private double Qf_A2=0.014711;
	private double Qf_B1=0.000444;
	private double Qf_B2=0.000444;
	private double Qf_C1=0.000489;
	private double Qf_C2=0.000489;
	private int QSChoice=1;
	private double RAINCOVER=1;
	private double RAINMAXRES=10;
	private double SDDFull1=-450;
	private double SDDFull2=-450;
	private double SDDFull3=-450;
	private double SDDFull4=-450;
	private int SkipHeaderGIS=1;
	private int SkipHeaderMet=1;
	private int SuewsStatus=1;
	private double TIMEZONE=10;
	private double TRANS_SITE=1;
	private double TreeH=14;
	private int Veg_type=1;
	private double z=40;
	private int z0_method=2;

	
	
	public SuewsConfigHeaderInput(String runDirectory, int year, String runPrefix)
	{
		super();
		this.runDirectory = runDirectory;		
		this.year = year;
		this.runPrefix = runPrefix;		
		
		this.filename = generateFilename(runPrefix, year);		
		setFileText(generateConfigFileText(runPrefix, year));
		
	}

	public static void main(String[] args)
	{
		
		

	}
	
	private String generateConfigFileText(String runPrefix, int year)
	{
		StringBuffer st = new StringBuffer();
		
		String inputPath = "\".\\Input\\\"";
		String outputPath = "\".\\Output\\\"";
						
		st.append("&HeaderInput" + '\n');
		st.append("ALB(1)=" +
				getALB1() + '\n');
		st.append("ALB(2)=" +
				getALB2() + '\n');
		st.append("ALB(3)=" +
				getALB3() + '\n');
		st.append("ALB(4)=" +
				getALB4() + '\n');
		st.append("ALB(5)=" +
				getALB5() + '\n');
		st.append("ALB(6)=" +
				getALB6() + '\n');
		st.append("ALB(7)=" +
				getALB7() + '\n');
		st.append("ALB_SNOW=" +
				getALB_SNOW() + '\n');
		st.append("AnthropHeatChoice=" +
				getAnthropHeatChoice() + '\n');
		st.append("BaseT(1)=" +
				getBaseT1() + '\n');
		st.append("BaseT(2)=" +
				getBaseT2() + '\n');
		st.append("BaseT(3)=" +
				getBaseT3() + '\n');
		st.append("BaseT(4)=" +
				getBaseT4() + '\n');
		st.append("BaseTe(1)=" +
				getBaseTe1() + '\n');
		st.append("BaseTe(2)=" +
				getBaseTe2() + '\n');
		st.append("BaseTe(3)=" +
				getBaseTe3() + '\n');
		st.append("BaseTe(4)=" +
				getBaseTe4() + '\n');
		st.append("BaseTHDD=" +
				getBaseTHDD() + '\n');
		st.append("blgH=" +
				getBlgH() + '\n');
		st.append("DayLightSavingDay(1)=" +
				getDayLightSavingDay1() + '\n');
		st.append("DayLightSavingDay(2)=" +
				getDayLightSavingDay2() + '\n');
		st.append("defaultFcld=" +
				getDefaultFcld() + '\n');
		st.append("defaultPres=" +
				getDefaultPres() + '\n');
		st.append("defaultRH=" +
				getDefaultRH() + '\n');
		st.append("defaultT=" +
				getDefaultT() + '\n');
		st.append("defaultU=" +
				getDefaultU() + '\n');
		st.append("defaultQf=" +
				getDefaultQf() + '\n');  
		st.append("defaultQs=" +
				getDefaultQs() + '\n');
		st.append("DRAINRT=" +
				getDRAINRT() + '\n');
		st.append("EMIS(1)=" +
				getEMIS1() + '\n');
		st.append("EMIS(2)=" +
				getEMIS2() + '\n');
		st.append("EMIS(3)=" +
				getEMIS3() + '\n');
		st.append("EMIS(4)=" +
				getEMIS4() + '\n');
		st.append("EMIS(5)=" +
				getEMIS5() + '\n');
		st.append("EMIS(6)=" +
				getEMIS6() + '\n');
		st.append("EMIS(7)=" +
				getEMIS7() + '\n');
		st.append("EMIS_SNOW=" +
				getEMIS_SNOW() + '\n');
		st.append("FileInputPath=" + inputPath + '\n');
		st.append("FileOutputPath=" + outputPath + '\n');
		st.append("FileCode='" +
				runPrefix +
				"_" +
				year +
				"'" + '\n');
		st.append("GDDFull(1)=" +
				"300" + '\n');
		st.append("GDDFull(2)=" +
				"300" + '\n');
		st.append("GDDFull(3)=" +
				"300" + '\n');
		st.append("GDDFull(4)=" +
				"300" + '\n');
		st.append("GISInputType=" +
				"3" + '\n');
		st.append("INTERVAL=" +
				"60" + '\n');
		st.append("LAImax(1)=" +
				"5.1" + '\n');
		st.append("LAImax(2)=" +
				"5.5" + '\n');
		st.append("LAImax(3)=" +
				"5.9" + '\n');
		st.append("LAImax(4)=" +
				"5.9" + '\n');
		st.append("LAImin(1)=" +
				"4.0" + '\n');
		st.append("LAImin(2)=" +
				"1.0" + '\n');
		st.append("LAImin(3)=" +
				"1.6" + '\n');
		st.append("LAImin(4)=" +
				"1.6" + '\n');
		st.append("lat=" +
				"-37.49" + '\n');
		st.append("lng=" +
				"144.53" + '\n');
		st.append("NARPOutput=" +
				"1" + '\n');
		st.append("NetRadiationChoice=" +
				"2" + '\n');
		st.append("numCapita=" +
				"2939" + '\n');
		st.append("ldown_option=" +
				"1" + '\n');
		st.append("Qf_A(1)=" +
				"0.014711" + '\n');
		st.append("Qf_A(2)=" +
				"0.014711" + '\n');
		st.append("Qf_B(1)=" +
				"0.000444" + '\n');
		st.append("Qf_B(2)=" +
				"0.000444" + '\n');
		st.append("Qf_C(1)=" +
				"0.000489" + '\n');
		st.append("Qf_C(2)=" +
				"0.000489" + '\n');
		st.append("QSChoice=" +
				"1" + '\n');
		st.append("RAINCOVER=" +
				"1" + '\n');
		st.append("RAINMAXRES=" +
				"10" + '\n');
		st.append("SDDFull(1)=" +
				"-450" + '\n');
		st.append("SDDFull(2)=" +
				"-450" + '\n');
		st.append("SDDFull(3)=" +
				"-450" + '\n');
		st.append("SDDFull(4)=" +
				"-450" + '\n');
		st.append("SkipHeaderGIS=" +
				"1" + '\n');
		st.append("SkipHeaderMet=" +
				"1" + '\n');
		st.append("SuewsStatus=" +
				"1" + '\n');
		st.append("TIMEZONE=" +
				"10" + '\n');
		st.append("TRANS_SITE=" +
				"1" + '\n');
		st.append("TreeH=" +
				"14" + '\n');
		st.append("Veg_type=" +
				"1" + '\n');
		st.append("year=" +
				year + '\n');
		st.append("z=" +
				"40" + '\n');
		st.append("z0_method=" +
				"2" + '\n');
		st.append("/" + '\n');

		st.append('\n');
		
		return st.toString();
	}	
	
	public void writeConfigFile()
	{
		common.createDirectory(runDirectory);
		common.writeFile(getFileText(), runDirectory + this.filename);
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

	public double getALB7()
	{
		return ALB7;
	}

	public void setALB7(double aLB7)
	{
		ALB7 = aLB7;
	}

	public double getALB_SNOW()
	{
		return ALB_SNOW;
	}

	public void setALB_SNOW(double aLB_SNOW)
	{
		ALB_SNOW = aLB_SNOW;
	}

	public int getAnthropHeatChoice()
	{
		return AnthropHeatChoice;
	}

	public void setAnthropHeatChoice(int anthropHeatChoice)
	{
		AnthropHeatChoice = anthropHeatChoice;
	}

	public double getBaseT1()
	{
		return BaseT1;
	}

	public void setBaseT1(double baseT1)
	{
		BaseT1 = baseT1;
	}

	public double getBaseT2()
	{
		return BaseT2;
	}

	public void setBaseT2(double baseT2)
	{
		BaseT2 = baseT2;
	}

	public double getBaseT3()
	{
		return BaseT3;
	}

	public void setBaseT3(double baseT3)
	{
		BaseT3 = baseT3;
	}

	public double getBaseT4()
	{
		return BaseT4;
	}

	public void setBaseT4(double baseT4)
	{
		BaseT4 = baseT4;
	}

	public double getBaseTe1()
	{
		return BaseTe1;
	}

	public void setBaseTe1(double baseTe1)
	{
		BaseTe1 = baseTe1;
	}

	public double getBaseTe2()
	{
		return BaseTe2;
	}

	public void setBaseTe2(double baseTe2)
	{
		BaseTe2 = baseTe2;
	}

	public double getBaseTe3()
	{
		return BaseTe3;
	}

	public void setBaseTe3(double baseTe3)
	{
		BaseTe3 = baseTe3;
	}

	public double getBaseTe4()
	{
		return BaseTe4;
	}

	public void setBaseTe4(double baseTe4)
	{
		BaseTe4 = baseTe4;
	}

	public double getBaseTHDD()
	{
		return BaseTHDD;
	}

	public void setBaseTHDD(double baseTHDD)
	{
		BaseTHDD = baseTHDD;
	}

	public double getBlgH()
	{
		return blgH;
	}

	public void setBlgH(double blgH)
	{
		this.blgH = blgH;
	}

	public int getDayLightSavingDay1()
	{
		return DayLightSavingDay1;
	}

	public void setDayLightSavingDay1(int dayLightSavingDay1)
	{
		DayLightSavingDay1 = dayLightSavingDay1;
	}

	public int getDayLightSavingDay2()
	{
		return DayLightSavingDay2;
	}

	public void setDayLightSavingDay2(int dayLightSavingDay2)
	{
		DayLightSavingDay2 = dayLightSavingDay2;
	}

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

	public double getDefaultU()
	{
		return defaultU;
	}

	public void setDefaultU(double defaultU)
	{
		this.defaultU = defaultU;
	}

	public double getDefaultQf()
	{
		return defaultQf;
	}

	public void setDefaultQf(double defaultQf)
	{
		this.defaultQf = defaultQf;
	}

	public double getDefaultQs()
	{
		return defaultQs;
	}

	public void setDefaultQs(double defaultQs)
	{
		this.defaultQs = defaultQs;
	}

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

	public double getEMIS7()
	{
		return EMIS7;
	}

	public void setEMIS7(double eMIS7)
	{
		EMIS7 = eMIS7;
	}

	public double getEMIS_SNOW()
	{
		return EMIS_SNOW;
	}

	public void setEMIS_SNOW(double eMIS_SNOW)
	{
		EMIS_SNOW = eMIS_SNOW;
	}

	public double getGDDFull1()
	{
		return GDDFull1;
	}

	public void setGDDFull1(double gDDFull1)
	{
		GDDFull1 = gDDFull1;
	}

	public double getGDDFull2()
	{
		return GDDFull2;
	}

	public void setGDDFull2(double gDDFull2)
	{
		GDDFull2 = gDDFull2;
	}

	public double getGDDFull3()
	{
		return GDDFull3;
	}

	public void setGDDFull3(double gDDFull3)
	{
		GDDFull3 = gDDFull3;
	}

	public double getGDDFull4()
	{
		return GDDFull4;
	}

	public void setGDDFull4(double gDDFull4)
	{
		GDDFull4 = gDDFull4;
	}

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

	public double getLAImax1()
	{
		return LAImax1;
	}

	public void setLAImax1(double lAImax1)
	{
		LAImax1 = lAImax1;
	}

	public double getLAImax2()
	{
		return LAImax2;
	}

	public void setLAImax2(double lAImax2)
	{
		LAImax2 = lAImax2;
	}

	public double getLAImax3()
	{
		return LAImax3;
	}

	public void setLAImax3(double lAImax3)
	{
		LAImax3 = lAImax3;
	}

	public double getLAImax4()
	{
		return LAImax4;
	}

	public void setLAImax4(double lAImax4)
	{
		LAImax4 = lAImax4;
	}

	public double getLAImin1()
	{
		return LAImin1;
	}

	public void setLAImin1(double lAImin1)
	{
		LAImin1 = lAImin1;
	}

	public double getLAImin2()
	{
		return LAImin2;
	}

	public void setLAImin2(double lAImin2)
	{
		LAImin2 = lAImin2;
	}

	public double getLAImin3()
	{
		return LAImin3;
	}

	public void setLAImin3(double lAImin3)
	{
		LAImin3 = lAImin3;
	}

	public double getLAImin4()
	{
		return LAImin4;
	}

	public void setLAImin4(double lAImin4)
	{
		LAImin4 = lAImin4;
	}

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

	public int getNumCapita()
	{
		return numCapita;
	}

	public void setNumCapita(int numCapita)
	{
		this.numCapita = numCapita;
	}

	public int getLdown_option()
	{
		return ldown_option;
	}

	public void setLdown_option(int ldown_option)
	{
		this.ldown_option = ldown_option;
	}

	public double getQf_A1()
	{
		return Qf_A1;
	}

	public void setQf_A1(double qf_A1)
	{
		Qf_A1 = qf_A1;
	}

	public double getQf_A2()
	{
		return Qf_A2;
	}

	public void setQf_A2(double qf_A2)
	{
		Qf_A2 = qf_A2;
	}

	public double getQf_B1()
	{
		return Qf_B1;
	}

	public void setQf_B1(double qf_B1)
	{
		Qf_B1 = qf_B1;
	}

	public double getQf_B2()
	{
		return Qf_B2;
	}

	public void setQf_B2(double qf_B2)
	{
		Qf_B2 = qf_B2;
	}

	public double getQf_C1()
	{
		return Qf_C1;
	}

	public void setQf_C1(double qf_C1)
	{
		Qf_C1 = qf_C1;
	}

	public double getQf_C2()
	{
		return Qf_C2;
	}

	public void setQf_C2(double qf_C2)
	{
		Qf_C2 = qf_C2;
	}

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

	public double getSDDFull1()
	{
		return SDDFull1;
	}

	public void setSDDFull1(double sDDFull1)
	{
		SDDFull1 = sDDFull1;
	}

	public double getSDDFull2()
	{
		return SDDFull2;
	}

	public void setSDDFull2(double sDDFull2)
	{
		SDDFull2 = sDDFull2;
	}

	public double getSDDFull3()
	{
		return SDDFull3;
	}

	public void setSDDFull3(double sDDFull3)
	{
		SDDFull3 = sDDFull3;
	}

	public double getSDDFull4()
	{
		return SDDFull4;
	}

	public void setSDDFull4(double sDDFull4)
	{
		SDDFull4 = sDDFull4;
	}

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

	public int getSuewsStatus()
	{
		return SuewsStatus;
	}

	public void setSuewsStatus(int suewsStatus)
	{
		SuewsStatus = suewsStatus;
	}

	public double getTIMEZONE()
	{
		return TIMEZONE;
	}

	public void setTIMEZONE(double tIMEZONE)
	{
		TIMEZONE = tIMEZONE;
	}

	public double getTRANS_SITE()
	{
		return TRANS_SITE;
	}

	public void setTRANS_SITE(double tRANS_SITE)
	{
		TRANS_SITE = tRANS_SITE;
	}

	public double getTreeH()
	{
		return TreeH;
	}

	public void setTreeH(double treeH)
	{
		TreeH = treeH;
	}

	public int getVeg_type()
	{
		return Veg_type;
	}

	public void setVeg_type(int veg_type)
	{
		Veg_type = veg_type;
	}

	public double getZ()
	{
		return z;
	}

	public void setZ(double z)
	{
		this.z = z;
	}

	public int getZ0_method()
	{
		return z0_method;
	}

	public void setZ0_method(int z0_method)
	{
		this.z0_method = z0_method;
	}	

	
	
}
