package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class RunSuewsAndProcess
{
	
	ENVICommon common = new ENVICommon();

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		RunSuewsAndProcess run = new RunSuewsAndProcess();
		run.process();

	}
	
	public void process()
	{
		GenerateSuewsConfig generateConfig = new GenerateSuewsConfig();
		
		int numGridConnections = 1;
		generateConfig.setNumGridConnections(numGridConnections);
		String runPrefix = "Pr3714";
		generateConfig.setRunPrefix(runPrefix);
		String runDirectory = "/tmp/SUEWS_" +
				runPrefix +
				"/";
		common.createDirectory(runDirectory);
		generateConfig.setRunDirectory(runDirectory);
		int numYears = 1;
		generateConfig.setNumYears(numYears);
		int startingYear = 2004;
		generateConfig.setStartingYear(startingYear);	
		
		//String sourceDir = "/home/nice/Climate_Research/SUEWS_V2011b_example/";
		
		String sourceDir = Messages.getString("ProcessSUEWSRun.HOME") + Messages.getString("SUEWS_EXE_DIR");
		
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
		
//		generateConfig.processConfig();		
//		common.runWineExe(runDirectory);
		
		
		String path = runDirectory + "Output";		
		String filename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE");

		SUEWSDataFile sUEWSDataFile = new SUEWSDataFile(path, filename, true, SUEWSDataFile.LINES_TO_SKIP_60);
		TreeMap<String, ArrayList<String>> theData = sUEWSDataFile.getData();

		Set<String> keys = theData.keySet();
		for (String key : keys)
		{
			System.out.println(key);
		}

		SUEWSMonthlyAverages sUEWSMonthlyAverages = new SUEWSMonthlyAverages(sUEWSDataFile);
		//String graphDirectory = Messages.getString("SuewsPrestonComparisonGraphs.graph_dir");
		String graphDirectory = runDirectory + "graphs/";
		common.createDirectory(graphDirectory);

		sUEWSMonthlyAverages.outputDataFile(graphDirectory,
				Messages.getString("SuewsPrestonComparisonGraphs.MONTHLY_AVERAGE_DAT_FILE"));

		//String suewsPath = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DATA_PATH");
		String suewsFilename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE");

		ProcessSUEWSRun processSUEWSRun = new ProcessSUEWSRun();
		SUEWSDataFile suewsDataFile = new SUEWSDataFile(path, suewsFilename, SuewsPrestonComparisonGraphs.SKIP_LINES_TRUE, SUEWSDataFile.LINES_TO_SKIP_60);
		suewsDataFile.setPath(graphDirectory);
		processSUEWSRun.generateReformattedDataFile(suewsDataFile);
		
				
		//ProcessSUEWSRun processSUEWSRun = new ProcessSUEWSRun();
		//sUEWSDataFile.setPath(Messages.getString("SuewsPrestonComparisonGraphs.graph_dir"));
		sUEWSDataFile.setPath(graphDirectory);
		processSUEWSRun.generateReformattedDataFile(sUEWSDataFile);

		// get comparison Preston data
		PrestonDataFile prestonDataFile = new PrestonDataFile(Messages.getString("ProcessSUEWSRun.HOME") + Messages.getString("PrestonDataFile.DATA_PATH2"), 
				Messages.getString("PrestonDataFile.2004_DATA_FILE"), false);		

		PrestonMonthlyAverages averages = new PrestonMonthlyAverages(prestonDataFile);
		averages.outputDataFiles(graphDirectory, Messages.getString("SuewsPrestonComparisonGraphs.PrestonMonthlyAve"));
		
		PrestonWeatherData weatherData = new PrestonWeatherData();
		ArrayList<TreeMap<String, String>> variables = weatherData.getPrestonData(-1);
		String prestonPlotDataFilename = "PRESTON CITIES 13092011_2.txt.gnuplot.dat";
		weatherData.outputPlotData(variables, graphDirectory, prestonPlotDataFilename);
		
		RGraphs rGraphs = new RGraphs();		
		rGraphs.runPreston1(graphDirectory);
		
		ArrayList<String> months =weatherData.getMonthAndYearsOfData();
		for (String month:months)
		{
			StringBuffer st = new StringBuffer();
			String item = "Kdown";
			TreeMap<String, Double> averageData = weatherData.getMonthlyAverageForDataItem(month, item);
			ArrayList<String> times = weatherData.getDistinctTimesForData();
			for (String time: times)
			{
				Double aveForTime = averageData.get(time);
				st.append(time + " " + aveForTime + '\n');
			}
			common.writeFile(st.toString(), graphDirectory + "PrestonMonthlyAve_" + month + ".dat");
		}
		
		
	}

}
