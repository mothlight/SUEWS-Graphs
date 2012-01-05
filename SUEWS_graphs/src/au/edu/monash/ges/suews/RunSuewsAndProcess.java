package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class RunSuewsAndProcess
{
	
	ENVICommon common = new ENVICommon();
	SuewsConfigValues suewsConfigValues;
	boolean justGraphs = false;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{	
		String runPrefix = "Pr0001";
		String justGraphsStr = "";
				
		if (args.length > 0) 
		{
			runPrefix = args[0];		    
		}
		
		RunSuewsAndProcess run = new RunSuewsAndProcess();
		if (args.length > 1) 
		{
			justGraphsStr = args[1];	
			if (justGraphsStr != null && justGraphsStr.equals("graphs"))
			{
				run.justGraphs = true;
			}
		}
		
		run.suewsConfigValues = new SuewsConfigValues(runPrefix);
		
		run.process();

	}
	
	public void process()
	{
		String basePath = common.getHostnameWorkDirPath();
		//System.out.println(basePath);
		
		GenerateSuewsConfig generateConfig = new GenerateSuewsConfig();
		
		int numGridConnections = suewsConfigValues.getNumGridConnections();
		generateConfig.setNumGridConnections(numGridConnections);
		String runPrefix = suewsConfigValues.getRunPrefix();
		generateConfig.setRunPrefix(runPrefix);
		String runDirectory = suewsConfigValues.getRunDirectory();
		common.createDirectory(runDirectory);
		generateConfig.setRunDirectory(runDirectory);
		int numYears = suewsConfigValues.getNumYears();
		generateConfig.setNumYears(numYears);
		int startingYear = suewsConfigValues.getStartingYear();
		generateConfig.setStartingYear(startingYear);	
		
		//String sourceDir = "/home/nice/Climate_Research/SUEWS_V2011b_example/";
		
		String sourceDir = basePath + Messages.getString("SUEWS_EXE_DIR");
		
		// /home/nice/Climate_Research/SUEWS_V2011b_example/SUEWS_V1_1.exe
		// /home/nice/Climate_Research/SUEWS_V2011b_example/salflibc.dll
		String sourceExe = Messages.getString("SUEWS_EXE");
		String sourceDll = Messages.getString("SUEWS_DLL");
		
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
			generateConfig.processConfig(suewsConfigValues);		
			common.runWineExe(runDirectory);
		}
		
		if (suewsConfigValues.getRun().equals(suewsConfigValues.PRESTON_RUN))
		{
			processPrestonRunOutput(runDirectory, startingYear);
		}
		if (suewsConfigValues.getRun().equals(suewsConfigValues.MAWSON_RUN))
		{
			processMawsonRunOutput(runDirectory, startingYear);
		}
				
	}
	
	public void processMawsonRunOutput(String runDirectory, int startingYear)
	{
		String graphDirectory = runDirectory + "graphs/";
		common.createDirectory(graphDirectory);
		
		String path = runDirectory + "Output";		
		String suewsDataFilePrefix = suewsConfigValues.getRunPrefix() + "_" + suewsConfigValues.getStartingYear();
		String filename = suewsDataFilePrefix + Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE2");

		SUEWSDataFile sUEWSDataFile = new SUEWSDataFile(path, filename, true, SUEWSDataFile.LINES_TO_SKIP_60);

		String suewsFilename = suewsDataFilePrefix + Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE2");

		ProcessSUEWSRun processSUEWSRun = new ProcessSUEWSRun();
		SUEWSDataFile suewsDataFile = new SUEWSDataFile(path, suewsFilename, SuewsPrestonComparisonGraphs.SKIP_LINES_TRUE, SUEWSDataFile.LINES_TO_SKIP_60);
		suewsDataFile.setPath(graphDirectory);
		processSUEWSRun.generateReformattedDataFile(suewsDataFile);

		sUEWSDataFile.setPath(graphDirectory);
		processSUEWSRun.generateReformattedDataFile(sUEWSDataFile);
		
		RGraphs rGraphs = new RGraphs();		
//		rGraphs.runPreston1(graphDirectory);
		
		//generate SUEWS monthly average data files
		generateSuewsAverageFiles(graphDirectory, startingYear, sUEWSDataFile);
		
		
		runDirectory = "/tmp/SUEWS_Pr3714/graphs/";
		String datafile = "Ml3714_2011_60.txt.gnuplot.dat";
		String imageFile = "Ml3714_2011_60.png";
		String title = "Plot for fluxes-Monthly Averages-March 2004";
		
		ArrayList<String> plotItems = new ArrayList<String>();
		plotItems.add(PrestonWeatherData.KDOWN);
		plotItems.add(PrestonWeatherData.KUP);
		plotItems.add(PrestonWeatherData.LDOWN);
		plotItems.add(PrestonWeatherData.LUP);
		plotItems.add(PrestonWeatherData.ANTHROP);
		plotItems.add(PrestonWeatherData.QH);
		plotItems.add(PrestonWeatherData.QE);
		plotItems.add(PrestonWeatherData.QG);
		
		rGraphs.runGenericSuewsChart(graphDirectory, datafile, imageFile, plotItems, title, 53);
		
	}	
	
	public void processPrestonRunOutput(String runDirectory, int startingYear)
	{
		String graphDirectory = runDirectory + "graphs/";
		common.createDirectory(graphDirectory);
		
		String path = runDirectory + "Output";		
		String suewsDataFilePrefix = suewsConfigValues.getRunPrefix() + "_" + suewsConfigValues.getStartingYear();
		String filename = suewsDataFilePrefix + Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE2");

		SUEWSDataFile sUEWSDataFile = new SUEWSDataFile(path, filename, true, SUEWSDataFile.LINES_TO_SKIP_60);
		//TreeMap<String, ArrayList<String>> theData = sUEWSDataFile.getData();

//		Set<String> keys = theData.keySet();
//		for (String key : keys)
//		{
//			System.out.println(key);
//		}

		
		//String graphDirectory = Messages.getString("SuewsPrestonComparisonGraphs.graph_dir");

		//String suewsPath = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DATA_PATH");
		
		String suewsFilename = suewsDataFilePrefix + Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE2");

		ProcessSUEWSRun processSUEWSRun = new ProcessSUEWSRun();
		SUEWSDataFile suewsDataFile = new SUEWSDataFile(path, suewsFilename, SuewsPrestonComparisonGraphs.SKIP_LINES_TRUE, SUEWSDataFile.LINES_TO_SKIP_60);
		suewsDataFile.setPath(graphDirectory);
		processSUEWSRun.generateReformattedDataFile(suewsDataFile);
		
				
		//ProcessSUEWSRun processSUEWSRun = new ProcessSUEWSRun();
		//sUEWSDataFile.setPath(Messages.getString("SuewsPrestonComparisonGraphs.graph_dir"));
		sUEWSDataFile.setPath(graphDirectory);
		processSUEWSRun.generateReformattedDataFile(sUEWSDataFile);

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
		generateSuewsAverageFiles(graphDirectory, startingYear, sUEWSDataFile);
		
		rGraphs.runPreston2(graphDirectory);
		
		for (int i=1;i<13;i++)
		{
			rGraphs.runPreston3(graphDirectory, i);
		}
		
		rGraphs.runPrestonSuewsApril2004Compare(graphDirectory, suewsConfigValues.getRunPrefix());
		rGraphs.runPrestonSuewsApril2004CompareDays(graphDirectory, suewsConfigValues.getRunPrefix(), 5);
		rGraphs.runPrestonSuewsApril2004CompareDaysDiff(graphDirectory, suewsConfigValues.getRunPrefix(), 5);
		
	}
	
	public void generateSuewsAverageFiles(String graphDirectory, int startingYear, SUEWSDataFile sUEWSDataFile)
	{
		SUEWSMonthlyAverages sUEWSMonthlyAverages = new SUEWSMonthlyAverages(sUEWSDataFile);
		sUEWSMonthlyAverages.outputDataFile(graphDirectory,
				Messages.getString("SuewsPrestonComparisonGraphs.MONTHLY_AVERAGE_DAT_FILE"));
		
		for (int month =1;month<13;month++)
		{
			//[Ch/i, Ch/i, DR/i, E/i, Fcld, Fw, Ie/i, LAI, L_mod, P/i, QE, QF, QH, RA, RO/i, ROpav, ROpipe, ROsoil/i, ROveg, ROwater, RS, ST/i, 
			// SoilSt_Gr, SoilSt_Irrgr, SoilSt_blg, SoilSt_con, SoilSt_dec, SoilSt_pav, SoilState, St_Gr, St_Irrgr, St_blg, St_con, St_dec, 
			// St_pav, St_water, Tsurf, addWater, dectime, e_mod, h_mod, kdown, kup, ldown, lup, qn, qs, smd, ustar]
			
			StringBuffer st = new StringBuffer();
			
			String item = SUEWSDataFile.SUEWS_kdown;			
			TreeMap<String, Double> kDownAverageData = sUEWSMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);			
			item =  SUEWSDataFile.SUEWS_kup;
			TreeMap<String, Double> kUpAverageData = sUEWSMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);			
			item =  SUEWSDataFile.SUEWS_ldown;
			TreeMap<String, Double> lDownAverageData = sUEWSMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			item =  SUEWSDataFile.SUEWS_lup;
			TreeMap<String, Double> lUpAverageData = sUEWSMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			//item = SUEWSDataFile.SUEWS_QF;
			item = "QF";
			TreeMap<String, Double> qfAverageData = sUEWSMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			item = SUEWSDataFile.SUEWS_QH;
			TreeMap<String, Double> qhAverageData = sUEWSMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			item = SUEWSDataFile.SUEWS_QE;
			TreeMap<String, Double> qeAverageData = sUEWSMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			item = SUEWSDataFile.SUEWS_qs;
			TreeMap<String, Double> qgAverageData = sUEWSMonthlyAverages.getMonthlyAverageForDataItem(month, startingYear, item);
			
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
//			StringBuffer st = new StringBuffer();
//			String item = PrestonWeatherData.KDOWN;
//			TreeMap<String, Double> kDownAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
//			item =  PrestonWeatherData.KUP;
//			TreeMap<String, Double> kUpAverageData = weatherData.getMonthlyAverageForDataItem(month, item);			
//			item =  PrestonWeatherData.LDOWN;
//			TreeMap<String, Double> lDownAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
//			item =  PrestonWeatherData.LUP;
//			TreeMap<String, Double> lUpAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
//			item = PrestonWeatherData.ANTHROP;
//			TreeMap<String, Double> qfAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
//			item = PrestonWeatherData.QH;
//			TreeMap<String, Double> qhAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
//			item = PrestonWeatherData.QE;
//			TreeMap<String, Double> qeAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
//			item = PrestonWeatherData.QG;
//			TreeMap<String, Double> qgAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
//			
//			ArrayList<String> times = weatherData.getDistinctTimesForData();
//			for (String time: times)
//			{
//				st.append(time +" ");
//						
//				Double KDownAveForTime = kDownAverageData.get(time);
//				st.append(KDownAveForTime + " "  );
//				Double KUpAveForTime = kUpAverageData.get(time);
//				st.append(KUpAveForTime + " " );
//				Double lDownAveForTime = lDownAverageData.get(time);
//				st.append(lDownAveForTime + " " );
//				Double lUpAveForTime = lUpAverageData.get(time);
//				st.append(lUpAveForTime + " " );
//				Double qfAveForTime = qfAverageData.get(time);
//				st.append(qfAveForTime + " " );
//				Double qhAveForTime = qhAverageData.get(time);
//				st.append(qhAveForTime + " " );
//				Double qeAveForTime = qeAverageData.get(time);
//				st.append(qeAveForTime + " " );
//				Double qgAveForTime = qgAverageData.get(time);
//				st.append(qgAveForTime + " " );
//				
//				st.append('\n');
//			}
			//common.writeFile(st.toString(), graphDirectory + "PrestonMonthlyAve_" + month + ".dat");
			
			source = prestonDataAveDataDir + "PrestonMonthlyAve_" + month + ".dat";
			target = graphDirectory + "PrestonMonthlyAve_" + month + ".dat";		
			common.createSymlink(source, target);
		}
	}

}
