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
		st.append("ALB(1)=0.12" + '\n');
		st.append("ALB(2)=0.15" + '\n');
		st.append("ALB(3)=0.10" + '\n');
		st.append("ALB(4)=0.18" + '\n');
		st.append("ALB(5)=0.21" + '\n');
		st.append("ALB(6)=0.21" + '\n');
		st.append("ALB(7)=0.10" + '\n');
		st.append("ALB_SNOW=0.35" + '\n');
		st.append("AnthropHeatChoice=2" + '\n');
		st.append("BaseT(1)=5" + '\n');
		st.append("BaseT(2)=5" + '\n');
		st.append("BaseT(3)=5" + '\n');
		st.append("BaseT(4)=5" + '\n');
		st.append("BaseTe(1)=13" + '\n');
		st.append("BaseTe(2)=13" + '\n');
		st.append("BaseTe(3)=13" + '\n');
		st.append("BaseTe(4)=13" + '\n');
		st.append("BaseTHDD=18.2" + '\n');
		st.append("blgH=6.4" + '\n');
		st.append("DayLightSavingDay(1)=275" + '\n');
		st.append("DayLightSavingDay(2)=93" + '\n');
		st.append("defaultFcld=0.1" + '\n');
		st.append("defaultPres=1013" + '\n');
		st.append("defaultRH=50" + '\n');
		st.append("defaultT=10" + '\n');
		st.append("defaultU=3" + '\n');
		st.append("defaultQf=10" + '\n');  
		st.append("defaultQs=10" + '\n');
		st.append("DRAINRT=0.25" + '\n');
		st.append("EMIS(1)=0.95" + '\n');
		st.append("EMIS(2)=0.91" + '\n');
		st.append("EMIS(3)=0.98" + '\n');
		st.append("EMIS(4)=0.98" + '\n');
		st.append("EMIS(5)=0.93" + '\n');
		st.append("EMIS(6)=0.93" + '\n');
		st.append("EMIS(7)=0.95" + '\n');
		st.append("EMIS_SNOW=0.99" + '\n');
		st.append("FileInputPath=" + inputPath + '\n');
		st.append("FileOutputPath=" + outputPath + '\n');
		st.append("FileCode='" +
				runPrefix +
				"_" +
				year +
				"'" + '\n');
		st.append("GDDFull(1)=300" + '\n');
		st.append("GDDFull(2)=300" + '\n');
		st.append("GDDFull(3)=300" + '\n');
		st.append("GDDFull(4)=300" + '\n');
		st.append("GISInputType=3" + '\n');
		st.append("INTERVAL=60" + '\n');
		st.append("LAImax(1)=5.1" + '\n');
		st.append("LAImax(2)=5.5" + '\n');
		st.append("LAImax(3)=5.9" + '\n');
		st.append("LAImax(4)=5.9" + '\n');
		st.append("LAImin(1)=4.0" + '\n');
		st.append("LAImin(2)=1.0" + '\n');
		st.append("LAImin(3)=1.6" + '\n');
		st.append("LAImin(4)=1.6" + '\n');
		st.append("lat=-37.49" + '\n');
		st.append("lng=144.53" + '\n');
		st.append("NARPOutput=1" + '\n');
		st.append("NetRadiationChoice=2" + '\n');
		st.append("numCapita=2939" + '\n');
		st.append("ldown_option=1" + '\n');
		st.append("Qf_A(1)=0.014711" + '\n');
		st.append("Qf_A(2)=0.014711" + '\n');
		st.append("Qf_B(1)=0.000444" + '\n');
		st.append("Qf_B(2)=0.000444" + '\n');
		st.append("Qf_C(1)=0.000489" + '\n');
		st.append("Qf_C(2)=0.000489" + '\n');
		st.append("QSChoice=1" + '\n');
		st.append("RAINCOVER=1" + '\n');
		st.append("RAINMAXRES=10" + '\n');
		st.append("SDDFull(1)=-450" + '\n');
		st.append("SDDFull(2)=-450" + '\n');
		st.append("SDDFull(3)=-450" + '\n');
		st.append("SDDFull(4)=-450" + '\n');
		st.append("SkipHeaderGIS=1" + '\n');
		st.append("SkipHeaderMet=1" + '\n');
		st.append("SuewsStatus=1" + '\n');
		st.append("TIMEZONE=10" + '\n');
		st.append("TRANS_SITE=1" + '\n');
		st.append("TreeH=14" + '\n');
		st.append("Veg_type=1" + '\n');
		st.append("year=" +
				year + '\n');
		st.append("z=40" + '\n');
		st.append("z0_method=2" + '\n');
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

	
	
}
