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
		
		generateConfig.processConfig();		
		common.runWineExe(runDirectory);
		
		
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
		
		//generate Preston monthly average data files
		ArrayList<String> months =weatherData.getMonthAndYearsOfData();
		for (String month:months)
		{
			StringBuffer st = new StringBuffer();
			String item = PrestonWeatherData.KDOWN;
			TreeMap<String, Double> kDownAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
			item =  PrestonWeatherData.KUP;
			TreeMap<String, Double> kUpAverageData = weatherData.getMonthlyAverageForDataItem(month, item);			
			item =  PrestonWeatherData.LDOWN;
			TreeMap<String, Double> lDownAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
			item =  PrestonWeatherData.LUP;
			TreeMap<String, Double> lUpAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
			item = PrestonWeatherData.ANTHROP;
			TreeMap<String, Double> qfAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
			item = PrestonWeatherData.QH;
			TreeMap<String, Double> qhAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
			item = PrestonWeatherData.QE;
			TreeMap<String, Double> qeAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
			item = PrestonWeatherData.QG;
			TreeMap<String, Double> qgAverageData = weatherData.getMonthlyAverageForDataItem(month, item);
			
			ArrayList<String> times = weatherData.getDistinctTimesForData();
			for (String time: times)
			{
				st.append(time +" ");
						
				Double KDownAveForTime = kDownAverageData.get(time);
				st.append(KDownAveForTime + " "  );
				Double KUpAveForTime = kUpAverageData.get(time);
				st.append(KUpAveForTime + " " );
				Double lDownAveForTime = lDownAverageData.get(time);
				st.append(lDownAveForTime + " " );
				Double lUpAveForTime = lUpAverageData.get(time);
				st.append(lUpAveForTime + " " );
				Double qfAveForTime = qfAverageData.get(time);
				st.append(qfAveForTime + " " );
				Double qhAveForTime = qhAverageData.get(time);
				st.append(qhAveForTime + " " );
				Double qeAveForTime = qeAverageData.get(time);
				st.append(qeAveForTime + " " );
				Double qgAveForTime = qgAverageData.get(time);
				st.append(qgAveForTime + " " );
				
				st.append('\n');
			}
			common.writeFile(st.toString(), graphDirectory + "PrestonMonthlyAve_" + month + ".dat");
		}
		
		//generate SUEWS monthly average data files
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
				//st.append(time +" ");
				String timeStr = new Integer(time).toString();
				timeStr = common.padLeft(timeStr, 2, '0');
				
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
			
			common.writeFile(st.toString(), graphDirectory + "SUEWSMonthlyAve_" + month + ".dat");
			
		}	
		
		rGraphs.runPreston2(graphDirectory);
		
		for (int i=1;i<13;i++)
		{
			rGraphs.runPreston3(graphDirectory, i);
		}
				
		
	}

}
