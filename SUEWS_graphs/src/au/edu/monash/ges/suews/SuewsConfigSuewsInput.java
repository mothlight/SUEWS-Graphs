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
	SuewsConfigValues suewsConfigValues = new SuewsConfigValues();
			
	private double BldgStorCap;
	private double BldgDrainCoef1;
	private double BldgDrainCoef2;
	private double BldgState;
	private double ConifStorCap;
	private double ConifDrainCoef1;
	private double ConifDrainCoef2;
	private double ConifState;
	private double DecidStorCap;
	private double DecidDrainCoef1;
	private double DecidDrainCoef2;
	private double DecidState;
	private double FlowChange;
	private double G1;
	private double G2;
	private double G3;
	private double G4;
	private double G5;
	private double G6;
	private double GrassUStorCap;
	private double GrassUDrainCoef1;
	private double GrassUDrainCoef2;
	private double GrassUState;
	private double GrassIStorCap;
	private double GrassIDrainCoef1;
	private double GrassIDrainCoef2;
	private double GrassIState;
	private double SatHydraulicConduct;
	private double InternalWaterUse;
	private double Kmax;
	private double PavStorCap;
	private double PavDrainCoef1;
	private double PavDrainCoef2;
	private double PavState;
	private String PipeCapacity;
	private double RunoffToWater;
	private int RoughLen_heat;
	private double S1;
	private double S2;
	private double SDECStor;
	private double SmCap;
	private int smd_choice;
	private int sm_input;
	private double SoilDensity;
	private double SoilDepth;
	private double SoilDepthMeas;
	private double SoilRocks;
	private double soilstorePav;
	private double soilstoreBldg;
	private double soilstorePavstate;
	private double soilstoreBldgstate;
	private double soilstoreConif;
	private double soilstoreDec;
	private double soilstoreGrass;
	private double soilstoreConifstate;
	private double soilstoreDecstate;
	private double soilstoreGrassUnirstate;
	private double soilstoreGrassirrstate;
	private int StabilityMethod;
	private int SurfaceArea;
	private double TH;
	private double TL;
	private int Tstep;
	private int WaterUseArea;
	private double WaterState;
	private String WaterStorCap;
	private int write5min;
	
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
		st.append("BldgStorCap=" +
				getBldgStorCap() + '\n');
		st.append("BldgDrainCoef1=" +
				getBldgDrainCoef1() + '\n');
		st.append("BldgDrainCoef2=" +
				getBldgDrainCoef2() + '\n');
		st.append("BldgState=" +
				getBldgState() + '\n');
		st.append("ConifStorCap=" +
				getConifStorCap() + '\n');
		st.append("ConifDrainCoef1=" +
				getConifDrainCoef1() + '\n');
		st.append("ConifDrainCoef2=" +
				getConifDrainCoef2() + '\n');
		st.append("ConifState=" +
				getConifState() + '\n');
		st.append("DecidStorCap=" +
				getDecidStorCap() + '\n');
		st.append("DecidDrainCoef1=" +
				getDecidDrainCoef1() + '\n');
		st.append("DecidDrainCoef2=" +
				getDecidDrainCoef2() + '\n');
		st.append("DecidState=" +
				getDecidState() + '\n');
		st.append("FlowChange=" +
				getFlowChange() + '\n');
		st.append("G1=" +
				getG1() + '\n');
		st.append("G2=" +
				getG2() + '\n');
		st.append("G3=" +
				getG3() + '\n');
		st.append("G4=" +
				getG4() + '\n');
		st.append("G5=" +
				getG5() + '\n');
		st.append("G6=" +
				getG6() + '\n');
		st.append("GrassUStorCap=" +
				"1.9" + '\n');
		st.append("GrassUDrainCoef1=" +
				getGrassUDrainCoef1() + '\n');
		st.append("GrassUDrainCoef2=" +
				getGrassUDrainCoef2() + '\n');
		st.append("GrassUState=" +
				getGrassUState() + '\n');
		st.append("GrassIStorCap=" +
				getGrassIStorCap() + '\n');
		st.append("GrassIDrainCoef1=" +
				getGrassIDrainCoef1() + '\n');
		st.append("GrassIDrainCoef2=" +
				getGrassIDrainCoef2() + '\n');
		st.append("GrassIState=" +
				getGrassIState() + '\n');
		st.append("SatHydraulicConduct=" +
				getSatHydraulicConduct() + '\n');
		st.append("InternalWaterUse=" +
				getInternalWaterUse() + '\n');
		st.append("Kmax=" +
				getKmax() + '\n');
		st.append("PavStorCap=" +
				getPavStorCap() + '\n');
		st.append("PavDrainCoef1=" +
				getPavDrainCoef1() + '\n');
		st.append("PavDrainCoef2=" +
				getPavDrainCoef2() + '\n');
		st.append("PavState=" +
				getPavState() + '\n');
		st.append("PipeCapacity=" +
				getPipeCapacity() + '\n');
		st.append("RunoffToWater=" +
				getRunoffToWater() + '\n');
		st.append("RoughLen_heat=" +
				getRoughLen_heat() + '\n');
		st.append("S1=" +
				getS1() + '\n');
		st.append("S2=" +
				getS2() + '\n');
		st.append("SDECStor=" +
				getSDECStor() + '\n');
		st.append("SmCap=" +
				getSmCap() + '\n');
		st.append("smd_choice=" +
				getSmd_choice() + '\n');
		st.append("sm_input=" +
				getSm_input() + '\n');
		st.append("SoilDensity=" +
				getSoilDensity() + '\n');
		st.append("SoilDepth=" +
				getSoilDepth() + '\n');
		st.append("SoilDepthMeas=" +
				getSoilDepthMeas() + '\n');
		st.append("SoilRocks=" +
				getSoilRocks() + '\n');
		st.append("soilstorePav=" +
				getSoilstorePav() + '\n');
		st.append("soilstoreBldg=" +
				getSoilstoreBldg() + '\n');
		st.append("soilstorePavstate=" +
				getSoilstorePavstate() + '\n');
		st.append("soilstoreBldgstate=" +
				getSoilstoreBldgstate() + '\n');
		st.append("soilstoreConif=" +
				getSoilstoreConif() + '\n');
		st.append("soilstoreDec=" +
				getSoilstoreDec() + '\n');
		st.append("soilstoreGrass=" +
				getSoilstoreGrass() + '\n');
		st.append("soilstoreConifstate=" +
				getSoilstoreConifstate() + '\n');
		st.append("soilstoreDecstate=" +
				getSoilstoreDecstate() + '\n');
		st.append("soilstoreGrassUnirstate=" +
				getSoilstoreGrassUnirstate() + '\n');
		st.append("soilstoreGrassirrstate=" +
				getSoilstoreGrassirrstate() + '\n');
		st.append("StabilityMethod=" +
				getStabilityMethod() + '\n');
		st.append("SurfaceArea=" +
				getSurfaceArea() + '\n');
		st.append("TH=" +
				getTH() + '\n');
		st.append("TL=" +
				getTL() + '\n');
		st.append("Tstep=" +
				getTstep() + '\n');
		st.append("WaterUseArea=" +
				getWaterUseArea() + '\n');
		st.append("WaterState=" +
				getWaterState() + '\n');
		st.append("WaterStorCap=" +
				getWaterStorCap() + '\n');
		st.append("write5min=" +
				getWrite5min() + '\n');
		st.append("WU_choice=" +
				suewsConfigValues.getSuewsConfigSuewsInputWUChoice()
				+ '\n');
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

	public ENVICommon getCommon()
	{
		return common;
	}

	public void setCommon(ENVICommon common)
	{
		this.common = common;
	}

	public SuewsConfigValues getSuewsConfigValues()
	{
		return suewsConfigValues;
	}

	public void setSuewsConfigValues(SuewsConfigValues suewsConfigValues)
	{
		this.suewsConfigValues = suewsConfigValues;
	}

	public double getBldgStorCap()
	{
		return BldgStorCap;
	}

	public void setBldgStorCap(double bldgStorCap)
	{
		BldgStorCap = bldgStorCap;
	}

	public double getBldgDrainCoef1()
	{
		return BldgDrainCoef1;
	}

	public void setBldgDrainCoef1(double bldgDrainCoef1)
	{
		BldgDrainCoef1 = bldgDrainCoef1;
	}

	public double getBldgDrainCoef2()
	{
		return BldgDrainCoef2;
	}

	public void setBldgDrainCoef2(double bldgDrainCoef2)
	{
		BldgDrainCoef2 = bldgDrainCoef2;
	}

	public double getBldgState()
	{
		return BldgState;
	}

	public void setBldgState(double bldgState)
	{
		BldgState = bldgState;
	}

	public double getConifStorCap()
	{
		return ConifStorCap;
	}

	public void setConifStorCap(double conifStorCap)
	{
		ConifStorCap = conifStorCap;
	}

	public double getConifDrainCoef1()
	{
		return ConifDrainCoef1;
	}

	public void setConifDrainCoef1(double conifDrainCoef1)
	{
		ConifDrainCoef1 = conifDrainCoef1;
	}

	public double getConifDrainCoef2()
	{
		return ConifDrainCoef2;
	}

	public void setConifDrainCoef2(double conifDrainCoef2)
	{
		ConifDrainCoef2 = conifDrainCoef2;
	}

	public double getConifState()
	{
		return ConifState;
	}

	public void setConifState(double conifState)
	{
		ConifState = conifState;
	}

	public double getDecidStorCap()
	{
		return DecidStorCap;
	}

	public void setDecidStorCap(double decidStorCap)
	{
		DecidStorCap = decidStorCap;
	}

	public double getDecidDrainCoef1()
	{
		return DecidDrainCoef1;
	}

	public void setDecidDrainCoef1(double decidDrainCoef1)
	{
		DecidDrainCoef1 = decidDrainCoef1;
	}

	public double getDecidDrainCoef2()
	{
		return DecidDrainCoef2;
	}

	public void setDecidDrainCoef2(double decidDrainCoef2)
	{
		DecidDrainCoef2 = decidDrainCoef2;
	}

	public double getDecidState()
	{
		return DecidState;
	}

	public void setDecidState(double decidState)
	{
		DecidState = decidState;
	}

	public double getFlowChange()
	{
		return FlowChange;
	}

	public void setFlowChange(double flowChange)
	{
		FlowChange = flowChange;
	}

	public double getG1()
	{
		return G1;
	}

	public void setG1(double g1)
	{
		G1 = g1;
	}

	public double getG2()
	{
		return G2;
	}

	public void setG2(double g2)
	{
		G2 = g2;
	}

	public double getG3()
	{
		return G3;
	}

	public void setG3(double g3)
	{
		G3 = g3;
	}

	public double getG4()
	{
		return G4;
	}

	public void setG4(double g4)
	{
		G4 = g4;
	}

	public double getG5()
	{
		return G5;
	}

	public void setG5(double g5)
	{
		G5 = g5;
	}

	public double getG6()
	{
		return G6;
	}

	public void setG6(double g6)
	{
		G6 = g6;
	}

	public double getGrassUStorCap()
	{
		return GrassUStorCap;
	}

	public void setGrassUStorCap(double grassUStorCap)
	{
		GrassUStorCap = grassUStorCap;
	}

	public double getGrassUDrainCoef1()
	{
		return GrassUDrainCoef1;
	}

	public void setGrassUDrainCoef1(double grassUDrainCoef1)
	{
		GrassUDrainCoef1 = grassUDrainCoef1;
	}

	public double getGrassUDrainCoef2()
	{
		return GrassUDrainCoef2;
	}

	public void setGrassUDrainCoef2(double grassUDrainCoef2)
	{
		GrassUDrainCoef2 = grassUDrainCoef2;
	}

	public double getGrassUState()
	{
		return GrassUState;
	}

	public void setGrassUState(double grassUState)
	{
		GrassUState = grassUState;
	}

	public double getGrassIStorCap()
	{
		return GrassIStorCap;
	}

	public void setGrassIStorCap(double grassIStorCap)
	{
		GrassIStorCap = grassIStorCap;
	}

	public double getGrassIDrainCoef1()
	{
		return GrassIDrainCoef1;
	}

	public void setGrassIDrainCoef1(double grassIDrainCoef1)
	{
		GrassIDrainCoef1 = grassIDrainCoef1;
	}

	public double getGrassIDrainCoef2()
	{
		return GrassIDrainCoef2;
	}

	public void setGrassIDrainCoef2(double grassIDrainCoef2)
	{
		GrassIDrainCoef2 = grassIDrainCoef2;
	}

	public double getGrassIState()
	{
		return GrassIState;
	}

	public void setGrassIState(double grassIState)
	{
		GrassIState = grassIState;
	}

	public double getSatHydraulicConduct()
	{
		return SatHydraulicConduct;
	}

	public void setSatHydraulicConduct(double satHydraulicConduct)
	{
		SatHydraulicConduct = satHydraulicConduct;
	}

	public double getInternalWaterUse()
	{
		return InternalWaterUse;
	}

	public void setInternalWaterUse(double internalWaterUse)
	{
		InternalWaterUse = internalWaterUse;
	}

	public double getKmax()
	{
		return Kmax;
	}

	public void setKmax(double kmax)
	{
		Kmax = kmax;
	}

	public double getPavStorCap()
	{
		return PavStorCap;
	}

	public void setPavStorCap(double pavStorCap)
	{
		PavStorCap = pavStorCap;
	}

	public double getPavDrainCoef1()
	{
		return PavDrainCoef1;
	}

	public void setPavDrainCoef1(double pavDrainCoef1)
	{
		PavDrainCoef1 = pavDrainCoef1;
	}

	public double getPavDrainCoef2()
	{
		return PavDrainCoef2;
	}

	public void setPavDrainCoef2(double pavDrainCoef2)
	{
		PavDrainCoef2 = pavDrainCoef2;
	}

	public double getPavState()
	{
		return PavState;
	}

	public void setPavState(double pavState)
	{
		PavState = pavState;
	}

	public String getPipeCapacity()
	{
		return PipeCapacity;
	}

	public void setPipeCapacity(String pipeCapacity)
	{
		PipeCapacity = pipeCapacity;
	}

	public double getRunoffToWater()
	{
		return RunoffToWater;
	}

	public void setRunoffToWater(double runoffToWater)
	{
		RunoffToWater = runoffToWater;
	}

	public int getRoughLen_heat()
	{
		return RoughLen_heat;
	}

	public void setRoughLen_heat(int roughLen_heat)
	{
		RoughLen_heat = roughLen_heat;
	}

	public double getS1()
	{
		return S1;
	}

	public void setS1(double s1)
	{
		S1 = s1;
	}

	public double getS2()
	{
		return S2;
	}

	public void setS2(double s2)
	{
		S2 = s2;
	}

	public double getSDECStor()
	{
		return SDECStor;
	}

	public void setSDECStor(double sDECStor)
	{
		SDECStor = sDECStor;
	}

	public double getSmCap()
	{
		return SmCap;
	}

	public void setSmCap(double smCap)
	{
		SmCap = smCap;
	}

	public int getSmd_choice()
	{
		return smd_choice;
	}

	public void setSmd_choice(int smd_choice)
	{
		this.smd_choice = smd_choice;
	}

	public int getSm_input()
	{
		return sm_input;
	}

	public void setSm_input(int sm_input)
	{
		this.sm_input = sm_input;
	}

	public double getSoilDensity()
	{
		return SoilDensity;
	}

	public void setSoilDensity(double soilDensity)
	{
		SoilDensity = soilDensity;
	}

	public double getSoilDepth()
	{
		return SoilDepth;
	}

	public void setSoilDepth(double soilDepth)
	{
		SoilDepth = soilDepth;
	}

	public double getSoilDepthMeas()
	{
		return SoilDepthMeas;
	}

	public void setSoilDepthMeas(double soilDepthMeas)
	{
		SoilDepthMeas = soilDepthMeas;
	}

	public double getSoilRocks()
	{
		return SoilRocks;
	}

	public void setSoilRocks(double soilRocks)
	{
		SoilRocks = soilRocks;
	}

	public double getSoilstorePav()
	{
		return soilstorePav;
	}

	public void setSoilstorePav(double soilstorePav)
	{
		this.soilstorePav = soilstorePav;
	}

	public double getSoilstoreBldg()
	{
		return soilstoreBldg;
	}

	public void setSoilstoreBldg(double soilstoreBldg)
	{
		this.soilstoreBldg = soilstoreBldg;
	}

	public double getSoilstorePavstate()
	{
		return soilstorePavstate;
	}

	public void setSoilstorePavstate(double soilstorePavstate)
	{
		this.soilstorePavstate = soilstorePavstate;
	}

	public double getSoilstoreBldgstate()
	{
		return soilstoreBldgstate;
	}

	public void setSoilstoreBldgstate(double soilstoreBldgstate)
	{
		this.soilstoreBldgstate = soilstoreBldgstate;
	}

	public double getSoilstoreConif()
	{
		return soilstoreConif;
	}

	public void setSoilstoreConif(double soilstoreConif)
	{
		this.soilstoreConif = soilstoreConif;
	}

	public double getSoilstoreDec()
	{
		return soilstoreDec;
	}

	public void setSoilstoreDec(double soilstoreDec)
	{
		this.soilstoreDec = soilstoreDec;
	}

	public double getSoilstoreGrass()
	{
		return soilstoreGrass;
	}

	public void setSoilstoreGrass(double soilstoreGrass)
	{
		this.soilstoreGrass = soilstoreGrass;
	}

	public double getSoilstoreConifstate()
	{
		return soilstoreConifstate;
	}

	public void setSoilstoreConifstate(double soilstoreConifstate)
	{
		this.soilstoreConifstate = soilstoreConifstate;
	}

	public double getSoilstoreDecstate()
	{
		return soilstoreDecstate;
	}

	public void setSoilstoreDecstate(double soilstoreDecstate)
	{
		this.soilstoreDecstate = soilstoreDecstate;
	}

	public double getSoilstoreGrassUnirstate()
	{
		return soilstoreGrassUnirstate;
	}

	public void setSoilstoreGrassUnirstate(double soilstoreGrassUnirstate)
	{
		this.soilstoreGrassUnirstate = soilstoreGrassUnirstate;
	}

	public double getSoilstoreGrassirrstate()
	{
		return soilstoreGrassirrstate;
	}

	public void setSoilstoreGrassirrstate(double soilstoreGrassirrstate)
	{
		this.soilstoreGrassirrstate = soilstoreGrassirrstate;
	}

	public int getStabilityMethod()
	{
		return StabilityMethod;
	}

	public void setStabilityMethod(int stabilityMethod)
	{
		StabilityMethod = stabilityMethod;
	}

	public int getSurfaceArea()
	{
		return SurfaceArea;
	}

	public void setSurfaceArea(int surfaceArea)
	{
		SurfaceArea = surfaceArea;
	}

	public double getTH()
	{
		return TH;
	}

	public void setTH(double tH)
	{
		TH = tH;
	}

	public double getTL()
	{
		return TL;
	}

	public void setTL(double tL)
	{
		TL = tL;
	}

	public int getTstep()
	{
		return Tstep;
	}

	public void setTstep(int tstep)
	{
		Tstep = tstep;
	}

	public int getWaterUseArea()
	{
		return WaterUseArea;
	}

	public void setWaterUseArea(int waterUseArea)
	{
		WaterUseArea = waterUseArea;
	}

	public double getWaterState()
	{
		return WaterState;
	}

	public void setWaterState(double waterState)
	{
		WaterState = waterState;
	}

	public String getWaterStorCap()
	{
		return WaterStorCap;
	}

	public void setWaterStorCap(String waterStorCap)
	{
		WaterStorCap = waterStorCap;
	}

	public int getWrite5min()
	{
		return write5min;
	}

	public void setWrite5min(int write5min)
	{
		this.write5min = write5min;
	}
	


}
