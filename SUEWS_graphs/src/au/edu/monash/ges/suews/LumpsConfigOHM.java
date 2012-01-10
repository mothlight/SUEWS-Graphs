package au.edu.monash.ges.suews;

public class LumpsConfigOHM
{
	
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "";
	public final String FILENAME_SUFFUX = ".ohm";
	
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;
	
	private boolean ohmConfigCanyonsIncluded;
	private int ohmConfigCalcuationsCoefficientsCanyons;
	private int ohmConfigVegetationCalculated;
	private String[] ohmConfigCalcuationsCoefficientsVegetation;
	private String[] ohmConfigCalcuationsCoefficientsRoof;
	private int ohmConfigImperviousAreasCalculated;
	private String[] ohmConfigCalcuationsCoefficientsImperviousAreas;

	public LumpsConfigOHM(String runDirectory, int year, String runPrefix)
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
		String canyonIncludedStr = "";
		String vegetationCalculatedStr = "";
		String roofCalculatedStr = "";
		String imperviousCalculatedStr = "";
		if (ohmConfigCanyonsIncluded == true)
		{
			canyonIncludedStr = "   " +
					"1" +
					"	   Canyons included: [1] Y [2] N " + '\n' +
					"   " + ohmConfigCalcuationsCoefficientsCanyons 
					+ "	   [2] Mean [3] Yoshida et al (1990, 1991) E-W canyon [3] Nunez (1974) N-S canyon " + '\n'
					;
		}
		else
		{
			canyonIncludedStr = 
			"   " +
					"2" +
					"	   Canyons included: [1] Y [2] N " + '\n';
		}
		
		if (ohmConfigVegetationCalculated == 2)
		{
			vegetationCalculatedStr = "   " +
					"2" +
					"	   Vegetation as one [1] Y [2] Seperate grass/trees&shrubs/water" + '\n';
					
					for (String vegetation : ohmConfigCalcuationsCoefficientsVegetation)
					{
						vegetationCalculatedStr += "   " + vegetation+ "	   " + getVegetationQuote(vegetation) + '\n';
					}
					
	
		}
		else
		{
			vegetationCalculatedStr = 
			"   " +
					"1" +
					"	   Vegetation as one [1] Y [2] Seperate grass/trees&shrubs/water" + '\n';
		}
		
		
		if (ohmConfigCalcuationsCoefficientsRoof[0].equals("1"))
		{
			roofCalculatedStr = "   " +
					"1" +
					"	   Roof [1] Mean of all" + '\n';						
	
		}
		else
		{			
			for (String roof : ohmConfigCalcuationsCoefficientsRoof)
			{
				roofCalculatedStr += "   " + roof + "	   " + getRoofQuote(roof) + '\n';
			}
			
		}
		
		if (ohmConfigImperviousAreasCalculated == 1)
		{
			imperviousCalculatedStr = "   " +
					"1" +
					"	   impervious as one [1] one [2] seperated to concrete & asphalt" + '\n';	
			for (String impervious : ohmConfigCalcuationsCoefficientsImperviousAreas)
			{
				imperviousCalculatedStr += "   " + impervious + "	   " + getImperviousQuote(impervious) + '\n';
			}
	
		}
		else
		{
			imperviousCalculatedStr = "   " +
					"2" +
					"	   impervious as one [1] one [2] seperated to concrete & asphalt" + '\n';		
			
			for (String impervious : ohmConfigCalcuationsCoefficientsImperviousAreas)
			{
				imperviousCalculatedStr += "   " + impervious + "	   " + getImperviousQuote(impervious) + '\n';
			}
			
		}		
		
		
		StringBuffer st = new StringBuffer();
		st.append("#" +
				runPrefix + 
				common.shortenYearTo2Digits(year) +
				".ohm" + '\n');
		st.append(canyonIncludedStr);
		st.append(vegetationCalculatedStr);               
		st.append(roofCalculatedStr);                                                                        
		st.append(imperviousCalculatedStr);
			
		return st.toString();
	}	
	
	public String getVegetationQuote(String vegetation)
	{
		String returnVal = "";
		
		if (vegetation.equals("1"))
		{
			return "[1] Mean";
		}
		if (vegetation.equals("2"))
		{
			return "[2] Mixed Forest - McCaughy (1985)";
		}
		if (vegetation.equals("3"))
		{
			return "[3] Short grass -- Doll et al. (1985)";
		}
		if (vegetation.equals("4"))
		{
			return "[4] Bare Soil -- Novak (1982)";
		}
		if (vegetation.equals("5"))
		{
			return "[5] Bare soil (wet) -- Fuchs & Hadas (1972)";
		}
		if (vegetation.equals("6"))
		{
			return "[6] Bare Soil (dry) -- Fuchs & Hadas (1972)";
		}
		if (vegetation.equals("7"))
		{
			return "[7] Bare soil -- Asaeda & Ca (1993)";
		}
		if (vegetation.equals("8"))
		{
			return "[8] Water Shallow - Turbid -- Souch et al (1998)";
		}
		
		
		return returnVal;
	}
	
	public String getRoofQuote(String roof)
	{
		String returnVal = "";
		
		if (roof.equals("1"))
		{
			return "[1] Mean of all";
		}
		if (roof.equals("2"))
		{
			return "[2] Tar and gravel -- Yap (1973)";
		}
		if (roof.equals("3"))
		{
			return "[3] Taseler (1980)";
		}
		if (roof.equals("4"))
		{
			return "[4] Yoshida et al (1990, 1991)";
		}
		if (roof.equals("5"))
		{
			return "[5] Average grave/tar/conc. flat industrial -- Mern (2000)";
		}
		if (roof.equals("6"))
		{
			return "[6] Dry -- grave/tar/conc. flat industrial -- Mern (2000)";
		}
		if (roof.equals("7"))
		{
			return "[7] Wet -- grave/tar/conc. flat industrial -- Mern (2000)";
		}
		if (roof.equals("8"))
		{
			return "[8] Bitumen spread over flat industrial membrane -- Mern (2000)";
		}
		if (roof.equals("9"))
		{
			return "[9] Asphalt shingle on plywood residental roof -- Mern (2000)";
		}
		if (roof.equals("10"))
		{
			return "[10] Star - high albedo asphalt shingle residental roof -- Mern (2000)";
		}	
		if (roof.equals("11"))
		{
			return "[11] Star - Ceramic Tile -- Mern (2000)";
		}
		if (roof.equals("12"))
		{
			return "[12] Star - Slate Tile -- Mern (2000)";
		}		
		
		
		return returnVal;
	}	
	
	public String getImperviousQuote(String impervious)
	{
		String returnVal = "";
		
		if (impervious.equals("1"))
		{
			return "[1] Mean";
		}
		if (impervious.equals("2"))
		{
			return "[2] Concrete - Doll et al (1985)";
		}
		if (impervious.equals("3"))
		{
			return "[3] Concrete - Asaeda & Ca (1993)";
		}
		if (impervious.equals("4"))
		{
			return "[4] Asphalt - Narita el al (1984)";
		}
		if (impervious.equals("5"))
		{
			return "[5] Asphalt -- Asaeda & Ca (1993)";
		}
		if (impervious.equals("6"))
		{
			return "[6] Asphalt - Anandakumar (1999)";
		}
		if (impervious.equals("7"))
		{
			return "[7] Asphalt (winter) - Anandakumar (1999)";
		}
		if (impervious.equals("8"))
		{
			return "[8] Asphalt (summer) - Anandakumar (1999)";
		}
		
		
		return returnVal;
	}	
	
	public void writeConfigFile(String inputDirectory)
	{
		common.createDirectory(runDirectory + inputDirectory);
		common.writeFile(getFileText(), runDirectory + inputDirectory + "/" + this.filename);
	}
	
	private String generateFilename(String runPrefix, int year)
	{
		return FILENAME_PREFIX + runPrefix  + common.shortenYearTo2Digits(year) + "_X0001Y0001" + FILENAME_SUFFUX;
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

	public boolean isOhmConfigCanyonsIncluded()
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

	public void setOhmConfigVegetationCalculated(int ohmConfigVegetationCalculated)
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
	


}
