package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class RunLumpsAndProcess
{
	
	ENVICommon common = new ENVICommon();
	LumpsConfigValues lumpsConfigValues;
	boolean justGraphs = false;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{	
		String runPrefix = "Pl";
		String justGraphsStr = "";
				
		if (args.length > 0) 
		{
			runPrefix = args[0];		    
		}
		
		RunLumpsAndProcess run = new RunLumpsAndProcess();
		if (args.length > 1) 
		{
			justGraphsStr = args[1];	
			if (justGraphsStr != null && justGraphsStr.equals("graphs"))
			{
				run.justGraphs = true;
			}
		}
		
		run.lumpsConfigValues = new LumpsConfigValues(runPrefix);
		
		run.process();

	}
	
	public void process()
	{
		String basePath = common.getHostnameWorkDirPath();
		//System.out.println(basePath);
		
		GenerateLumpsConfig generateConfig = new GenerateLumpsConfig();
		
		int numGridConnections = lumpsConfigValues.getNumGridNames();
		generateConfig.setNumGridConnections(numGridConnections);
		String runPrefix = lumpsConfigValues.getRunPrefix();
		generateConfig.setRunPrefix(runPrefix);
		String runDirectory = lumpsConfigValues.getRunDirectory();
		common.createDirectory(runDirectory);
		generateConfig.setRunDirectory(runDirectory);
		//int numYears = lumpsConfigValues.getNumYears();
		//generateConfig.setNumYears(numYears);
		int startingYear = lumpsConfigValues.getStartingYear();
		generateConfig.setStartingYear(startingYear);	
		
		//String sourceDir = "/home/nice/Climate_Research/SUEWS_V2011b_example/";
		
		String sourceDir = basePath + Messages.getString("LUMPS_EXE_DIR");
		
		// /home/nice/Climate_Research/SUEWS_V2011b_example/SUEWS_V1_1.exe
		// /home/nice/Climate_Research/SUEWS_V2011b_example/salflibc.dll
		String sourceExe = Messages.getString("LUMPS_EXE");
		String sourceDll = Messages.getString("LUMPS_DLL");
		
		String source = sourceDir + sourceExe;
		String target = runDirectory + sourceExe;		
		common.createSymlink(source, target);
		
		source = sourceDir + sourceDll;
		target = runDirectory + sourceDll;		
		common.createSymlink(source, target);
		
		if (justGraphs)
		{
			
		}
		else
		{
//			generateConfig.processConfig(lumpsConfigValues);		
//			common.runWineExe(runDirectory, sourceExe);
		}
		
		if (lumpsConfigValues.getRun().equals(lumpsConfigValues.PRESTON_RUN))
		{
			processPrestonRunOutput(runDirectory, startingYear);
		}
//		if (lumpsConfigValues.getRun().equals(lumpsConfigValues.MAWSON_RUN))
//		{
//			processMawsonRunOutput(runDirectory, startingYear);
//		}
				
	}
	
//	public void processMawsonRunOutput(String runDirectory, int startingYear)
//	{
//		String graphDirectory = runDirectory + "graphs/";
//		common.createDirectory(graphDirectory);
//		
//		String path = runDirectory + "Output";		
//		String suewsDataFilePrefix = suewsConfigValues.getRunPrefix() + "_" + suewsConfigValues.getStartingYear();
//		String filename = suewsDataFilePrefix + Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE2");
//
//		SUEWSDataFile sUEWSDataFile = new SUEWSDataFile(path, filename, true, SUEWSDataFile.LINES_TO_SKIP_60);
//
//		String suewsFilename = suewsDataFilePrefix + Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE2");
//
//		ProcessSUEWSRun processSUEWSRun = new ProcessSUEWSRun();
//		SUEWSDataFile suewsDataFile = new SUEWSDataFile(path, suewsFilename, SuewsPrestonComparisonGraphs.SKIP_LINES_TRUE, SUEWSDataFile.LINES_TO_SKIP_60);
//		suewsDataFile.setPath(graphDirectory);
//		processSUEWSRun.generateReformattedDataFile(suewsDataFile);
//
//		sUEWSDataFile.setPath(graphDirectory);
//		processSUEWSRun.generateReformattedDataFile(sUEWSDataFile);
//		
//		RGraphs rGraphs = new RGraphs();		
//		
//		//generate SUEWS monthly average data files
//		generateSuewsAverageFiles(graphDirectory, startingYear, sUEWSDataFile);
//		
//		
//		runDirectory = "/tmp/SUEWS_Pr3714/graphs/";
//		String datafile = "Ml3714_2011_60.txt.gnuplot.dat";
//		String imageFile = "Ml3714_2011_60.png";
//		String title = "Plot for fluxes-Monthly Averages-March 2004";
//		
//		ArrayList<String> plotItems = new ArrayList<String>();
//		plotItems.add(PrestonWeatherData.KDOWN);
//		plotItems.add(PrestonWeatherData.KUP);
//		plotItems.add(PrestonWeatherData.LDOWN);
//		plotItems.add(PrestonWeatherData.LUP);
//		plotItems.add(PrestonWeatherData.ANTHROP);
//		plotItems.add(PrestonWeatherData.QH);
//		plotItems.add(PrestonWeatherData.QE);
//		plotItems.add(PrestonWeatherData.QG);
//		
//		rGraphs.runGenericSuewsChart(graphDirectory, datafile, imageFile, plotItems, title, 53);
//		
//	}	
//	
	public void processPrestonRunOutput(String runDirectory, int startingYear)
	{
		//boolean lumpsRun = true;
		String graphDirectory = runDirectory + "graphs/";
		common.createDirectory(graphDirectory);
		
		String path = runDirectory + "Output/";		
		String lumpsDataFilePrefix = lumpsConfigValues.getRunPrefix()  
				+ common.shortenYearTo2Digits(lumpsConfigValues.getStartingYear())
				+ "_X0001Y0001";
		String filename = lumpsDataFilePrefix + Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE2");

		LumpsDataFile lumpsDataFile = new LumpsDataFile(path, filename, true, SUEWSDataFile.LINES_TO_SKIP_60);
		//lumpsDataFile.setLumpsRun(true);
		
		String suewsFilename = lumpsDataFilePrefix + Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE2");
		ProcessLumpsRun processSUEWSRun = new ProcessLumpsRun();
		
		//String inputPath, String Inputfile, int headerLinesToTrim, String outputPath, String outputfile
				
		processSUEWSRun.generateReformattedDataFile(path, suewsFilename, 5, graphDirectory, suewsFilename + ".gnuplot.dat" ); 
		
		
		
//		ProcessLumpsRun processSUEWSRun = new ProcessLumpsRun();
//		LumpsDataFile suewsDataFile = new LumpsDataFile(path, suewsFilename, 
//				SuewsPrestonComparisonGraphs.SKIP_LINES_FALSE, SUEWSDataFile.LINES_TO_SKIP_60);
//		//suewsDataFile.setLumpsRun(true);
//		suewsDataFile.setPath(graphDirectory);
//		processSUEWSRun.setLumpsRun(true);
//		processSUEWSRun.generateReformattedDataFile(suewsDataFile);
//		
//		lumpsDataFile.setPath(graphDirectory);
//		processSUEWSRun.generateReformattedDataFile(lumpsDataFile);

		// get comparison Preston data
		PrestonDataFile prestonDataFile = new PrestonDataFile(
				common.getHostnameWorkDirPath()
				+ Messages.getString("PrestonDataFile.DATA_PATH2"), 
				Messages.getString("PrestonDataFile.2004_DATA_FILE"), false);		

		PrestonMonthlyAverages averages = new PrestonMonthlyAverages(prestonDataFile);
		averages.outputDataFiles(graphDirectory, Messages.getString("SuewsPrestonComparisonGraphs.PrestonMonthlyAve"));
				
		RGraphs rGraphs = new RGraphs();		
		rGraphs.runPreston1(graphDirectory);
		
		//generate Preston monthly average data files
		generatePrestonAverageFiles(graphDirectory);
				
		//generate SUEWS monthly average data files
		generateLumpsAverageFiles(graphDirectory, startingYear, lumpsDataFile);
		
		rGraphs.runPreston2(graphDirectory);
		
		for (int i=1;i<13;i++)
		{
			rGraphs.runLumpsPreston3(graphDirectory, i);
		}
		
		rGraphs.runPrestonLumpsApril2004Compare(graphDirectory, lumpsConfigValues.getRunPrefix());
		rGraphs.runPrestonLumpsApril2004CompareDays(graphDirectory, lumpsConfigValues.getRunPrefix(), 5);
		rGraphs.runPrestonLumpsApril2004CompareDaysDiff(graphDirectory, lumpsConfigValues.getRunPrefix(), 5);
		
	}
	
	public void generateLumpsAverageFiles(String graphDirectory, int startingYear, LumpsDataFile lumpsDataFile)
	{
		LumpsMonthlyAverages lumpsMonthlyAverages = new LumpsMonthlyAverages(lumpsDataFile);
		lumpsMonthlyAverages.outputDataFile(graphDirectory,
				Messages.getString("LumpsPrestonComparisonGraphs.MONTHLY_AVERAGE_DAT_FILE"));
		
		for (int month =1;month<13;month++)
		{
			//[Ch/i, Ch/i, DR/i, E/i, Fcld, Fw, Ie/i, LAI, L_mod, P/i, QE, QF, QH, RA, RO/i, ROpav, ROpipe, ROsoil/i, ROveg, ROwater, RS, ST/i, 
			// SoilSt_Gr, SoilSt_Irrgr, SoilSt_blg, SoilSt_con, SoilSt_dec, SoilSt_pav, SoilState, St_Gr, St_Irrgr, St_blg, St_con, St_dec, 
			// St_pav, St_water, Tsurf, addWater, dectime, e_mod, h_mod, kdown, kup, ldown, lup, qn, qs, smd, ustar]
			
			// %id   it    dectime   kdown  kup    ldown   lup     Ts    qn    h_mod   e_mod   qs      FCLD   V
			
			StringBuffer st = new StringBuffer();
			
			String item = SUEWSDataFile.SUEWS_kdown;			
			TreeMap<String, Double> kDownAverageData = lumpsMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);			
			item =  SUEWSDataFile.SUEWS_kup;
			TreeMap<String, Double> kUpAverageData = lumpsMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);			
			item =  SUEWSDataFile.SUEWS_ldown;
			TreeMap<String, Double> lDownAverageData = lumpsMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			item =  SUEWSDataFile.SUEWS_lup;
			TreeMap<String, Double> lUpAverageData = lumpsMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			//item = SUEWSDataFile.SUEWS_QF;
			item = "QF";  //well, there is no QF in LUMPS, this will be null
			TreeMap<String, Double> qfAverageData = lumpsMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			item = SUEWSDataFile.LUMPS_QH;
			TreeMap<String, Double> qhAverageData = lumpsMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			item = SUEWSDataFile.LUMPS_QE;
			TreeMap<String, Double> qeAverageData = lumpsMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			item = SUEWSDataFile.SUEWS_qs;
			TreeMap<String, Double> qgAverageData = lumpsMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			
			for (int time = 0;time<24;time++)
			{
				
				String timeStr = new Integer(time).toString();
				timeStr = common.padLeft(timeStr, 2, '0');
				
				if (kUpAverageData.get(timeStr) == null)
				{
					continue;
				}
				
				st.append(common.padRight(timeStr, 4, '0') +" ");
						
				Double KDownAveForTime = kDownAverageData.get(timeStr);
				st.append(KDownAveForTime + " "  );
				Double KUpAveForTime = kUpAverageData.get(timeStr);
				st.append(KUpAveForTime + " " );
				Double lDownAveForTime = lDownAverageData.get(timeStr);
				st.append(lDownAveForTime + " " );
				Double lUpAveForTime = lUpAverageData.get(timeStr);
				st.append(lUpAveForTime + " " );
				Double qfAveForTime = qfAverageData.get(timeStr);
				st.append(qfAveForTime + " " );
				Double qhAveForTime = qhAverageData.get(timeStr);
				st.append(qhAveForTime + " " );
				Double qeAveForTime = qeAverageData.get(timeStr);
				st.append(qeAveForTime + " " );
				Double qgAveForTime = qgAverageData.get(timeStr);
				st.append(qgAveForTime + " " );
				
				st.append('\n');
			}
			if (st.length() > 2)
			{
				common.writeFile(st.toString(), graphDirectory + "SUEWSMonthlyAve_" + month + ".dat");
			}
			
		}
	
	}
	
	public void generatePrestonAverageFiles(String graphDirectory)
	{
		String prestonDataAveDataDir = common.getHostnameWorkDirPath()
				+ Messages.getString("PrestonDataFile.AVE_DATA_PATH2");
		
		PrestonWeatherData weatherData = new PrestonWeatherData();
		//ArrayList<TreeMap<String, String>> variables = weatherData.getPrestonData(-1);
		
		String prestonPlotDataFilename = Messages.getString("ProcessSUEWSRun.prestonPlotDataFilename");
		//weatherData.outputPlotData(variables, graphDirectory, prestonPlotDataFilename);	
		String source = prestonDataAveDataDir + prestonPlotDataFilename;
		String target = graphDirectory + prestonPlotDataFilename;		
		common.createSymlink(source, target);
				
		ArrayList<String> months =weatherData.getMonthAndYearsOfData();
		for (String month:months)
		{
			source = prestonDataAveDataDir + "PrestonMonthlyAve_" + month + ".dat";
			target = graphDirectory + "PrestonMonthlyAve_" + month + ".dat";		
			common.createSymlink(source, target);
		}
	}

}
