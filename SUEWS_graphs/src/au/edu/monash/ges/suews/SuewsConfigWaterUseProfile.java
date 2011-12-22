package au.edu.monash.ges.suews;

public class SuewsConfigWaterUseProfile
{
	
	ENVICommon common = new ENVICommon();
	public final String FILENAME_PREFIX = "WaterUseProfile";
	public final String FILENAME_SUFFUX = ".txt";
	
	private String runDirectory;
	private String filename ;
	private String fileText;
	private int year;
	private String runPrefix;
	
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
//	private double HourWat5=0.11;
//	private double HourWat6=0.12;
//	private double HourWat7=0.11;
//	private double HourWat17=0.11;
//	private double HourWat18=0.11;
//	private double HourWat19=0.11;
//	private double HourWat20=0.11;
//	private double HourWat21=0.11;
//	private double HourWat22=0.11;			

	public SuewsConfigWaterUseProfile(String runDirectory, int year, String runPrefix)
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
		
		
		st.append("&WaterUseProfile" + '\n');
		st.append("Ie_start=" +
				getIe_start() + '\n');
		st.append("Ie_end=" +
				getIe_end() + '\n');
		st.append("Faut=" +
				getFaut() + '\n');
		st.append("Ie_a(1)=" +
				getIe_a1() + '\n');
		st.append("Ie_a(2)=" +
				getIe_a2() + '\n');
		st.append("Ie_a(3)=" +
				getIe_a3() + '\n');
		st.append("Ie_m(1)=" +
				getIe_m1() + '\n');
		st.append("Ie_m(2)=" +
				getIe_m2() + '\n');
		st.append("Ie_m(3)=" +
				getIe_m3() + '\n');
		st.append("DayWat(1)=" +
				getDayWat1() + '\n');
		st.append("DayWat(2)=" +
				getDayWat2() + '\n');
		st.append("DayWat(3)=" +
				getDayWat3() + '\n');
		st.append("DayWat(4)=" +
				getDayWat4() + '\n');
		st.append("DayWat(5)=" +
				getDayWat5() + '\n');
		st.append("DayWat(6)=" +
				getDayWat6() + '\n');
		st.append("DayWat(7)=" +
				getDayWat7() + '\n');
		st.append("DayWatPer(1)=" +
				getDayWatPer1() + '\n');
		st.append("DayWatPer(2)=" +
				getDayWatPer2() + '\n');
		st.append("DayWatPer(3)=" +
				getDayWatPer3() + '\n');
		st.append("DayWatPer(4)=" +
				getDayWatPer4() + '\n');
		st.append("DayWatPer(5)=" +
				getDayWatPer5() + '\n');
		st.append("DayWatPer(6)=" +
				getDayWatPer6() + '\n');
		st.append("DayWatPer(7)=" +
				getDayWatPer7() + '\n');
		st.append("HourResChoice=" +
				getHourResChoice() + '\n');
		
		if (getHourResChoice() == 0)
		{
			int count = 0;
			for (String hourVal
					: getHourWat() )
			{
				if (hourVal == null || hourVal.equals(""))
				{
					count ++;
					continue;
				}
				st.append("HourWat(" +
						count +
						")=" + hourVal + '\n');
				count ++;
			}

		}
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
	


}
