package au.edu.monash.ges.suews;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;

public class RGraphs {

	ENVICommon common = new ENVICommon();
	
	public static void main(String[] args) {
		RGraphs rGraphs = new RGraphs();
		//rGraphs.process();
		//rGraphs.runGenericChart(null, null, null, null, null);
		//rGraphs.process2();
		
//		
//		String graphDirectory = "/tmp/SUEWS_Pr3714/graphs/";
//		rGraphs.runPreston2(graphDirectory);
//		
//		for (int i=1;i<13;i++)
//		{
//			rGraphs.runPreston3(graphDirectory, i);
//		}
			
		rGraphs.runGenericSuewsChart(null, null, null, null, null, 53);
		
		
		

	}
	
	public void process2()
	{
		int startingYear = 2004;
		String runPrefix = "Pr3714";
		String runDirectory = "/tmp/SUEWS_" +
				runPrefix +
				"/";
		String graphDirectory = "/tmp/SUEWS_Pr3714/graphs/";
		
		String path = runDirectory + "Output";		
		String filename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE");

		SUEWSDataFile sUEWSDataFile = new SUEWSDataFile(path, filename, true, SUEWSDataFile.LINES_TO_SKIP_60);
		SUEWSMonthlyAverages sUEWSMonthlyAverages = new SUEWSMonthlyAverages(sUEWSDataFile);
		//ArrayList<String> monthlyKeys = sUEWSMonthlyAverages.getKeysForMonthlyData();
		//System.out.println(monthlyKeys.toString());
		
		// kdown_2004_10_0
		// kdown_2004_10_23
		//ArrayList<String> monthlyHourlyData = sUEWSMonthlyAverages.getDataForVariableAndTime("kdown_2004_4_14");
		//System.out.println(monthlyHourlyData.toString());
		
//		int month = 4;
//		String item = "kdown";
//		TreeMap<String, Double> hourlyData = sUEWSMonthlyAverages.getMonthlyAverageForDataItem(month, year, item);
//		System.out.println(hourlyData.toString());
		
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
				
			//runPreston3(graphDirectory);
	}
	
	public void process()
	{
		
		String runDirectory = "/tmp/SUEWS_Pr3714/graphs/";
		
		PrestonWeatherData weatherData = new PrestonWeatherData();
		//ArrayList<TreeMap<String, String>> variables = weatherData.getPrestonData(-1);
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
			common.writeFile(st.toString(), runDirectory + "PrestonMonthlyAve_" + month + ".dat");
		}
		
		runPreston2(runDirectory);
	}

	public void runPreston1(String runDirectory)
	{
		String basePath = common.getHostnameWorkDirPath();
		
		String prestonCalculated = Messages.getString("ProcessLumps.PrestonCalculated");
		String prestonCalculatedPath = Messages.getString("ProcessLumps.PrestonCalculatedPath");
		
		String source = basePath + prestonCalculatedPath + prestonCalculated;
		String imageName = "r_plot.png";

		String target = runDirectory + prestonCalculated;		
		common.createSymlink(source, target);	
		
		StringBuffer st = new StringBuffer();
		
		st.append("filename <-\"" +
				prestonCalculated +
				"\""+ '\n');
		st.append("data_table <- read.table(filename,col.names=c(\"Year\",\"Day_of_year\",\"time\",\"timecode\",\"month\",\"week\",\"Kdown\",\"Kup\",\"Ldown\",\"Lup\",\"NET\",\"QH\",\"QE\",\"QG\"," +'\n');
		st.append("		\"Flux_validity\",\"CO2flux_final\",\"CO2_flux_validity\",\"Temp\",\"e_a\",\"wind_spd\",\"wind_dir.\",\"pressure\",\"Precip.\"," +'\n');
		st.append("		\"Anthrop.\",\"tau\",\"soil_moisture\",\"deep_soil_temp\",\"FormattedDate\",\"RH\"))" +'\n');
		st.append("dates <- strptime(as.character(data_table$timecode), format(\"%Y%j%H%M\"))" +'\n');
		st.append("beg <- as.Date(\"2004-11-26\", \"%Y-%m-%d\") " +'\n');
		st.append("end <- as.Date(\"2004-11-28\", \"%Y-%m-%d\") " +'\n');
		st.append("firstdate = ISOdate(2004,3,1)" +'\n');
		st.append("lastdate = ISOdate(2004,3,20)" +'\n');
		st.append("png(\"" +
				imageName +
				"\", width = 1536, height = 900)" +'\n');
		st.append("plot(dates, data_table$Kdown, type=\"l\", xlab=\"Date\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, xlim=c(firstdate, lastdate), axes=FALSE)" +'\n');
		st.append("lines(dates, data_table$Kdown, type=\"l\", lwd=1.5, pch=21, lty=1, col=1)" +'\n');
		st.append("lines(dates, data_table$Ldown, type=\"l\", lwd=1.5, pch=19, lty=1, col=2)" +'\n');
		st.append("lines(dates, data_table$Kup, type=\"l\", lwd=1.5, pch=19, lty=1, col=3)" +'\n');
		st.append("lines(dates, data_table$Lup, type=\"l\", lwd=1.5, pch=19, lty=1, col=4)" +'\n');
		st.append("lines(dates, data_table$QE, type=\"l\", lwd=1.5, pch=19, lty=1, col=5)" +'\n');
		st.append("lines(dates, data_table$QH, type=\"l\", lwd=1.5, pch=19, lty=1, col=6)" +'\n');
		st.append("lines(dates, data_table$QG, type=\"l\", lwd=1.5, pch=19, lty=1, col=7)" +'\n');
		st.append("lines(dates, data_table$NET, type=\"l\", lwd=1.5, pch=19, lty=1, col=8)" +'\n');
		st.append("atx <- seq(firstdate, lastdate, by=24*60*60)" +'\n');
		st.append("axis(1, at=atx, labels=format(atx, \"%b\n%d\"), padj=0.5)" +'\n');
		st.append("axis(side = 2)" +'\n');
		st.append("box()" +'\n');
		st.append("title(\"Preston fluxes, March 2004\", \"\")" +'\n');
		st.append("legend(\"topright\", legend = c(\"Kdown\",\"Ldown\",\"Kup\",\"Lup\",\"QE\",\"QH\",\"QG\",\"NET\"), col = 1:8, lty = 1:1)" +'\n');
		st.append("grid()" +'\n');
		st.append("dev.off()" +'\n');

		common.runR(runDirectory, st.toString(), imageName);		
	}
	
	public void runPreston2(String runDirectory)
	{
		String title = "Plot for fluxes-Monthly Averages-March 2004";
		String plotImage = "r_plot_2.png";
		
		StringBuffer st = new StringBuffer();
		

		st.append("preston_file <-\"PrestonMonthlyAve_200403.dat\"" +'\n');
	
		st.append("preston_table <- read.table(preston_file,header = FALSE,col.names=c(\"Time\",\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +
				PrestonWeatherData.QG +
				"\"))" +'\n');


		st.append("png(\"" +
				plotImage +
				"\", width = 1536, height = 900)" +'\n');

		st.append("plot(preston_table$Time, preston_table$Kdown, type=\"l\", xlab=\"Date\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, , axes=TRUE)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.KDOWN +
				", type=\"l\", lwd=1.5, pch=21, lty=1, col=1)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.KUP +
				", type=\"l\", lwd=1.5, pch=21, lty=1, col=2)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.LDOWN +
				", type=\"l\", lwd=1.5, pch=21, lty=1, col=3)" +'\n');		
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.LUP +
				", type=\"l\", lwd=1.5, pch=21, lty=1, col=4)" +'\n');	
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.ANTHROP +
				", type=\"l\", lwd=1.5, pch=21, lty=1, col=5)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QH +
				", type=\"l\", lwd=1.5, pch=21, lty=1, col=6)" +'\n');	
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QE +
				", type=\"l\", lwd=1.5, pch=21, lty=1, col=7)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QG +
				", type=\"l\", lwd=1.5, pch=21, lty=1, col=8)" +'\n');		

		st.append("atx <- seq(firstdate, lastdate, by=24*60*60)" +'\n');
		st.append("axis(1, at=atx, labels=format(atx, \"%b\n%d\"), padj=0.5)" +'\n');
		st.append("axis(side = 2)" +'\n');
		st.append("box()" +'\n');

		st.append("title(\"" +
				title +
				"\", \"\")" +'\n');
		st.append("legend(\"topright\", legend = c(\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +				
				PrestonWeatherData.QG +
				"\"), col = 1:8, lty = 1:1)" +'\n');
		st.append("grid()" +'\n');
		st.append("dev.off()" +'\n');
		
		common.runR(runDirectory, st.toString(), plotImage);
	}
	
	public void runPreston3(String runDirectory, int month)
	{
		String monthName = common.getMonthForMonthInt(month);
		String title = "Monthly averages comparisons, Preston vs. SUEWS - " +
				monthName +
				" 2004";
		String plotImage = "monthlyAve_" +
				month +
				".png";
		
		String monthStr = new Integer(month).toString();
		String monthPadded = common.padLeft(monthStr, 2, '0');
		
		StringBuffer st = new StringBuffer();
		
		String prestonDataFile = "PrestonMonthlyAve_2004" + monthPadded + ".dat";
		File prestonDataFileFile = new File(runDirectory + prestonDataFile);
		if (!prestonDataFileFile.exists())
		{
			return;
		}
		st.append("preston_file <-\"" +
				prestonDataFile +
				"\"" +'\n');
		String suewsDataFile = "SUEWSMonthlyAve_" + month + ".dat";
		File suewsDataFileFile = new File(runDirectory + suewsDataFile);
		if (!suewsDataFileFile.exists())
		{
			return;
		}		
		st.append("suews_file <-\"" +
				suewsDataFile +
				"\"" +'\n');
	
		st.append("preston_table <- read.table(preston_file,header = FALSE,col.names=c(\"Time\",\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +
				PrestonWeatherData.QG +
				"\"))" +'\n');
		
		st.append("suews_table <- read.table(suews_file,header = FALSE,col.names=c(\"Time\",\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +
				PrestonWeatherData.QG +
				"\"))" +'\n');		

		st.append("plot_colors <- rainbow(10)" + '\n');
		st.append("png(\"" +
				plotImage +
				"\", width = 1536, height = 900)" +'\n');
		
		st.append("y_range <-range(preston_table$Kdown,preston_table$Lup,preston_table$QG, suews_table$Kdown,suews_table$Lup,suews_table$QG)" + '\n');

		st.append("plot(preston_table$Time, preston_table$Kdown, type=\"l\", xlab=\"Time of day\", ylab=\"w/m2\", lwd=1, pch=1,col=plot_colors[1], lty=1, ylim=y_range, axes=TRUE)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.KDOWN +
				", type=\"b\", lwd=1, pch=1, lty=1, col=plot_colors[1])" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.KUP +
				", type=\"b\", lwd=1, pch=2, lty=1, col=plot_colors[2])" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.LDOWN +
				", type=\"b\", lwd=1, pch=3, lty=1, col=plot_colors[3])" +'\n');		
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.LUP +
				", type=\"b\", lwd=1, pch=4, lty=1, col=plot_colors[4])" +'\n');	
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.ANTHROP +
				", type=\"b\", lwd=1, pch=5, lty=1, col=plot_colors[5])" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QH +
				", type=\"b\", lwd=1, pch=6, lty=1, col=plot_colors[6])" +'\n');	
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QE +
				", type=\"b\", lwd=1, pch=7, lty=1, col=plot_colors[7])" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QG +
				", type=\"b\", lwd=1, pch=8, lty=1, col=plot_colors[8])" +'\n');		
		
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.KDOWN +
				", type=\"b\", lwd=1, pch=1, lty=3, col=plot_colors[1])" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.KUP +
				", type=\"b\", lwd=1, pch=2, lty=3, col=plot_colors[2])" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.LDOWN +
				", type=\"b\", lwd=1, pch=3, lty=3, col=plot_colors[3])" +'\n');		
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.LUP +
				", type=\"b\", lwd=1, pch=4, lty=3, col=plot_colors[4])" +'\n');	
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.ANTHROP +
				", type=\"b\", lwd=1, pch=5, lty=3, col=plot_colors[5])" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QH +
				", type=\"b\", lwd=1, pch=6, lty=3, col=plot_colors[6])" +'\n');	
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QE +
				", type=\"b\", lwd=1, pch=7, lty=3, col=plot_colors[7])" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QG +
				", type=\"b\", lwd=1, pch=8, lty=3, col=plot_colors[8])" +'\n');			

//		st.append("atx <- seq(firstdate, lastdate, by=24*60*60)" +'\n');
//		st.append("axis(1, at=atx, labels=format(atx, \"%b\n%d\"), padj=0.5)" +'\n');
		//st.append("atx <- seq(0,24,6)" + '\n');
		//st.append("axis(1, at=atx, labels=atx, padj=0.5)" + '\n');
		//st.append("axis(side = 2)" +'\n');
		st.append("box()" +'\n');

		st.append("title(\"" +
				title +
				"\", \"\")" +'\n');
		st.append("legend(\"topright\", legend = c(\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +				
				PrestonWeatherData.QG +
				"\"), col = plot_colors[1:8], lty = 1:1, pch=c(1,2,3,4,5,6,7,8))" +'\n');
		st.append("legend(\"topleft\", legend = c(\"Preston\",\"SUEWS\"), col = plot_colors[1:1], lty = 1:2)" +'\n');
		st.append("grid()" +'\n');
		st.append("dev.off()" +'\n');
		
		common.runR(runDirectory, st.toString(), plotImage);
	}	
	
	public void runLumpsPreston3(String runDirectory, int month)
	{
		String monthName = common.getMonthForMonthInt(month);
		String title = "Monthly averages comparisons, Preston vs. LUMPS - " +
				monthName +
				" 2004";
		String plotImage = "monthlyAve_" +
				month +
				".png";
		
		String monthStr = new Integer(month).toString();
		String monthPadded = common.padLeft(monthStr, 2, '0');
		
		StringBuffer st = new StringBuffer();
		
		String prestonDataFile = "PrestonMonthlyAve_2004" + monthPadded + ".dat";
		File prestonDataFileFile = new File(runDirectory + prestonDataFile);
		if (!prestonDataFileFile.exists())
		{
			return;
		}
		st.append("preston_file <-\"" +
				prestonDataFile +
				"\"" +'\n');
		String suewsDataFile = "SUEWSMonthlyAve_" + month + ".dat";
		File suewsDataFileFile = new File(runDirectory + suewsDataFile);
		if (!suewsDataFileFile.exists())
		{
			return;
		}		
		st.append("suews_file <-\"" +
				suewsDataFile +
				"\"" +'\n');
	
		st.append("preston_table <- read.table(preston_file,header = FALSE,col.names=c(\"Time\",\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +
				PrestonWeatherData.QG +
				"\"))" +'\n');
		
		st.append("suews_table <- read.table(suews_file,header = FALSE,col.names=c(\"Time\",\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +
				PrestonWeatherData.QG +
				"\"))" +'\n');		

		st.append("plot_colors <- rainbow(10)" + '\n');
		st.append("png(\"" +
				plotImage +
				"\", width = 1536, height = 900)" +'\n');
		
		st.append("y_range <-range(preston_table$Kdown,preston_table$Lup,preston_table$QG, suews_table$Kdown,suews_table$Lup,suews_table$QG)" + '\n');

		st.append("plot(preston_table$Time, preston_table$Kdown, type=\"b\", xlab=\"Time of day\", ylab=\"w/m2\", lwd=1, col=plot_colors[1], pch=1, lty=1, ylim=y_range, axes=TRUE)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.KDOWN +
				", type=\"b\", lwd=1, pch=1, lty=1, col=plot_colors[1])" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.KUP +
				", type=\"b\", lwd=1, pch=2, lty=1, col=plot_colors[2])" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.LDOWN +
				", type=\"b\", lwd=1, pch=3, lty=1, col=plot_colors[3])" +'\n');		
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.LUP +
				", type=\"b\", lwd=1, pch=4, lty=1, col=plot_colors[4])" +'\n');	
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.ANTHROP +
				", type=\"b\", lwd=1, pch=5, lty=1, col=plot_colors[5])" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QH +
				", type=\"b\", lwd=1, pch=6, lty=1, col=plot_colors[6])" +'\n');	
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QE +
				", type=\"b\", lwd=1, pch=7, lty=1, col=plot_colors[7])" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QG +
				", type=\"b\", lwd=1, pch=8, lty=1, col=plot_colors[8])" +'\n');		
		
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.KDOWN +
				", type=\"b\", lwd=1, pch=1, lty=3, col=plot_colors[1])" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.KUP +
				", type=\"b\", lwd=1, pch=2, lty=3, col=plot_colors[2])" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.LDOWN +
				", type=\"b\", lwd=1, pch=3, lty=3, col=plot_colors[3])" +'\n');		
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.LUP +
				", type=\"b\", lwd=1, pch=4, lty=3, col=plot_colors[4])" +'\n');	
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.ANTHROP +
				", type=\"b\", lwd=1, pch=5, lty=3, col=plot_colors[5])" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QH +
				", type=\"b\", lwd=1, pch=6, lty=3, col=plot_colors[6])" +'\n');	
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QE +
				", type=\"b\", lwd=1, pch=7, lty=3, col=plot_colors[7])" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QG +
				", type=\"b\", lwd=1, pch=8, lty=3, col=plot_colors[8])" +'\n');			

//		st.append("atx <- seq(firstdate, lastdate, by=24*60*60)" +'\n');
//		st.append("axis(1, at=atx, labels=format(atx, \"%b\n%d\"), padj=0.5)" +'\n');
		//st.append("atx <- seq(0,24,6)" + '\n');
		//st.append("axis(1, at=atx, labels=atx, padj=0.5)" + '\n');
		//st.append("axis(side = 2)" +'\n');
		st.append("box()" +'\n');

		st.append("title(\"" +
				title +
				"\", \"\")" +'\n');
		st.append("legend(\"topright\", legend = c(\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +				
				PrestonWeatherData.QG +
				"\"), col = plot_colors[1:8], lty = 1:1, pch=c(1,2,3,4,5,6,7,8))" +'\n');
		st.append("legend(\"topleft\", legend = c(\"Preston\",\"SUEWS\"), col = plot_colors[1:1], lty = 1:2)" +'\n');
		st.append("grid()" +'\n');
		st.append("dev.off()" +'\n');
		
		common.runR(runDirectory, st.toString(), plotImage);
	}		
	
	public void runGenericChart(String runDirectory, String datafile, String imageFile, ArrayList<String> plotItems, String title)
	{
		runDirectory = "/tmp/SUEWS_Pr3714/graphs/";
		datafile = "PrestonMonthlyAve_200403.dat";
		imageFile = "r_plot_3.png";
		title = "Plot for fluxes-Monthly Averages-March 2004";
		
		plotItems = new ArrayList<String>();
		plotItems.add(PrestonWeatherData.KDOWN);
		plotItems.add(PrestonWeatherData.KUP);
		plotItems.add(PrestonWeatherData.LDOWN);
		plotItems.add(PrestonWeatherData.LUP);
		plotItems.add(PrestonWeatherData.ANTHROP);
		plotItems.add(PrestonWeatherData.QH);
		plotItems.add(PrestonWeatherData.QE);
		plotItems.add(PrestonWeatherData.QG);
		
		int count = 0;
		StringBuffer readTableStr = new StringBuffer("preston_table <- read.table(preston_file,header = FALSE,col.names=c(\"Time\"," );
		StringBuffer plotLinesStr = new StringBuffer("plot(preston_table$Time, preston_table$" +
				plotItems.get(0) +
				", type=\"l\", xlab=\"Date\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, , axes=TRUE)" +'\n');
		StringBuffer legendStr = new StringBuffer("legend(\"topright\", legend = c(");
				
		for (String item : plotItems)
		{
			legendStr.append("\"" + item + "\"");
			readTableStr.append("\"" + item +"\"" );
			count ++;
			if (count == plotItems.size())
			{
				
			}
			else
			{
				readTableStr.append("," );
				legendStr.append(",");
			}			
			
			
			plotLinesStr.append(" lines(preston_table$Time, preston_table$" +
					item +
					", type=\"l\", lwd=1.5, pch=21, lty=1, col=" +
					count +
					")" +'\n');				
			
		}
		readTableStr.append("))" +'\n');
		legendStr.append("), col = 1:" +
				count +
				", lty = 1:1)" +'\n');		
		
		StringBuffer st = new StringBuffer();
		st.append("preston_file <-\"" + datafile + "\"" +'\n');
		
		st.append("png(\"" + imageFile + "\", width = 1536, height = 900)" +'\n');		
	
		st.append(readTableStr);
		st.append(plotLinesStr);			

		st.append("atx <- seq(firstdate, lastdate, by=24*60*60)" +'\n');
		st.append("axis(1, at=atx, labels=format(atx, \"%b\\n%d\"), padj=0.5)" +'\n');
		st.append("axis(side = 2)" +'\n');
		st.append("box()" +'\n');

		st.append("title(\"" +
				title +
				"\", \"\")" +'\n');
		
		st.append(legendStr);		
		
		st.append("grid()" +'\n');
		st.append("dev.off()" +'\n');
		
		common.runR(runDirectory, st.toString(), imageFile);
	}	
	
	public void runGenericSuewsChart(String runDirectory, String datafile, String imageFile, ArrayList<String> plotItems, String title, int numberInHeader)
	{
		numberInHeader = 52;
		runDirectory = "/tmp/SUEWS_Ml3714/graphs/";
		datafile = "Ml3714_2011_60.txt.gnuplot.dat";
		imageFile = "r_plot_4.png";
		title = "Plot for fluxes-Monthly Averages-March 2004";
		
		plotItems = new ArrayList<String>();
		plotItems.add(PrestonWeatherData.KDOWN);
		plotItems.add(PrestonWeatherData.KUP);
		plotItems.add(PrestonWeatherData.LDOWN);
		plotItems.add(PrestonWeatherData.LUP);
		plotItems.add(PrestonWeatherData.ANTHROP);
		plotItems.add(PrestonWeatherData.QH);
		plotItems.add(PrestonWeatherData.QE);
		plotItems.add(PrestonWeatherData.QG);
		
		int count = 0;
		StringBuffer readTableStr = new StringBuffer("preston_table <- read.table(preston_file,header = TRUE,col.names=c(\"Time\"," );
		StringBuffer plotLinesStr = new StringBuffer("plot(dates, preston_table$" +
				plotItems.get(0) +
				", type=\"l\", xlab=\"Date\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, , axes=TRUE)" +'\n');
		StringBuffer legendStr = new StringBuffer("legend(\"topright\", legend = c(");
				
//		for (String item : plotItems)
//		{
//			legendStr.append("\"" + item + "\"");
//			readTableStr.append("\"" + item +"\"" );
//			count ++;
//			if (count == plotItems.size())
//			{
//				
//			}
//			else
//			{
//				readTableStr.append("," );
//				legendStr.append(",");
//			}			
//			
//			
//			plotLinesStr.append(" lines(preston_table$Time, preston_table$" +
//					item +
//					", type=\"l\", lwd=1.5, pch=21, lty=1, col=" +
//					count +
//					")" +'\n');				
//			
//		}
		
		
		for (int i =0;i<numberInHeader;i++)
		{
			String item = "a" + i;
			legendStr.append("\"" + item + "\"");
			readTableStr.append("\"" + item +"\"" );
			count ++;
			if (count == numberInHeader)
			{
				
			}
			else
			{
				readTableStr.append("," );
				legendStr.append(",");
			}			
			
			
			plotLinesStr.append(" lines(dates, preston_table$" +
					item +
					", type=\"l\", lwd=1.5, pch=21, lty=1, col=" +
					count +
					")" +'\n');				
			
		}
		
		readTableStr.append("))" +'\n');
		legendStr.append("), col = 1:" +
				count +
				", lty = 1:1)" +'\n');		
		
		StringBuffer st = new StringBuffer();
		st.append("preston_file <-\"" + datafile + "\"" +'\n');
		
		st.append("png(\"" + imageFile + "\", width = 1536, height = 900)" +'\n');		
		st.append("dates <- strptime(as.character(preston_table$Time), format(\"%j-%H\"))" + '\n');
	
		st.append(readTableStr);
		st.append(plotLinesStr);			

		st.append("atx <- seq(firstdate, lastdate, by=24*60*60)" +'\n');
		st.append("axis(1, at=atx, labels=format(atx, \"%b\\n%d\"), padj=0.5)" +'\n');
		st.append("axis(side = 2)" +'\n');
		st.append("box()" +'\n');

		st.append("title(\"" +
				title +
				"\", \"\")" +'\n');
		
		st.append(legendStr);		
		
		st.append("grid()" +'\n');
		st.append("dev.off()" +'\n');
		
		common.runR(runDirectory, st.toString(), imageFile);
	}	
	
	public void runPrestonSuewsApril2004Compare(String runDirectory, String runPrefix)
	{
		int month = 4;
		String monthName = common.getMonthForMonthInt(month);
		String title = "Monthly averages comparisons, Preston vs. SUEWS - " +
				monthName +
				" 2004";
		String plotImage = "monthlyAve_" +
				month +
				"_" + runPrefix + 
				".png";
		
		String monthStr = new Integer(month).toString();
		String monthPadded = common.padLeft(monthStr, 2, '0');
		
		StringBuffer st = new StringBuffer();
		
		String prestonDataFile = "PrestonMonthlyAve_2004" + monthPadded + ".dat";
		File prestonDataFileFile = new File(runDirectory + prestonDataFile);
		if (!prestonDataFileFile.exists())
		{
			return;
		}
		st.append("preston_file <-\"" +
				prestonDataFile +
				"\"" +'\n');
		String suewsDataFile = "SUEWSMonthlyAve_" + month + ".dat";
		File suewsDataFileFile = new File(runDirectory + suewsDataFile);
		if (!suewsDataFileFile.exists())
		{
			return;
		}		
		st.append("suews_file <-\"" +
				suewsDataFile +
				"\"" +'\n');
	
		st.append("preston_table <- read.table(preston_file,header = FALSE,col.names=c(\"Time\",\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +
				PrestonWeatherData.QG +
				"\"))" +'\n');
		
		st.append("suews_table <- read.table(suews_file,header = FALSE,col.names=c(\"Time\",\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +
				PrestonWeatherData.QG +
				"\"))" +'\n');		

		//st.append("plot_colors <- rainbow(10)" + '\n');
		st.append("plot_colors <- c( \"#D92121\",\"#2121D9\", \"#21D921\", \"#FFFF4D\", \"#FF9326\", \"#9999FF\")" + '\n');		
		
		st.append("png(\"" +
				plotImage +
				"\", width = 1536, height = 900)" +'\n');
		
		st.append("y_range <-range(preston_table$QH,preston_table$QE,suews_table$QH,suews_table$QE)" + '\n');

		st.append("plot(preston_table$Time, preston_table$QH, type=\"l\", xlab=\"Time of day\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, ylim=y_range, axes=TRUE)" +'\n');
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.KDOWN +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[1])" +'\n');
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.KUP +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])" +'\n');
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.LDOWN +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[3])" +'\n');		
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.LUP +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[4])" +'\n');	
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.ANTHROP +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[5])" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QH +
				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[1])" +'\n');	
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QE +
				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])" +'\n');
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.QG +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[8])" +'\n');		
		
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.KDOWN +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[1])" +'\n');
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.KUP +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[2])" +'\n');
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.LDOWN +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[3])" +'\n');		
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.LUP +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[4])" +'\n');	
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.ANTHROP +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[5])" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QH +
				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[1])" +'\n');	
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QE +
				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[2])" +'\n');
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.QG +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[8])" +'\n');			

//		st.append("atx <- seq(firstdate, lastdate, by=24*60*60)" +'\n');
//		st.append("axis(1, at=atx, labels=format(atx, \"%b\n%d\"), padj=0.5)" +'\n');
		st.append("atx <- seq(0,24,6)" + '\n');
		st.append("axis(1, at=atx, labels=atx, padj=0.5)" + '\n');
		st.append("axis(side = 2)" +'\n');
		st.append("box()" +'\n');

		st.append("title(\"" +
				title +
				"\", \"\")" +'\n');
		st.append("legend(\"topright\", legend = c(\"" +
//				PrestonWeatherData.KDOWN +
//				"\",\"" +
//				PrestonWeatherData.KUP +
//				"\",\"" +	
//				PrestonWeatherData.LDOWN +
//				"\",\"" +	
//				PrestonWeatherData.LUP +
//				"\",\"" +	
//				PrestonWeatherData.ANTHROP +
//				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\"" +
//				",\"" +				
//				PrestonWeatherData.QG +
//				"\"" +
				"), col = plot_colors[1:2], lty = 1:1)" +'\n');
		st.append("legend(\"topleft\", legend = c(\"Preston\",\"SUEWS\"), col = plot_colors[1:1], lty = 1:2)" +'\n');
		st.append("grid()" +'\n');
		st.append("dev.off()" +'\n');
		
		common.runR(runDirectory, st.toString(), plotImage);
	}	
	
	public void runPrestonSuewsApril2004CompareDays(String runDirectory, String runPrefix, int numDays)
	{
		int startDay = 92;
		int endDay = startDay + numDays;
		int month = 4;
		String monthName = common.getMonthForMonthInt(month);
		String title = "Comparisons, Preston vs. SUEWS - " +
				monthName +
				" 2004";
		String plotImage = "Data_" +
				month +
				"_" + runPrefix + 
				".png";
		
		String monthStr = new Integer(month).toString();
		String monthPadded = common.padLeft(monthStr, 2, '0');
		
		StringBuffer st = new StringBuffer();
		

		st.append("Dataset <- read.table(\"" +
				runDirectory +
				runPrefix +
				"_2004_60.txt.gnuplot.dat" +
				"\", header=FALSE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE)" +'\n');
		st.append("PrDataset <- read.table(\"" +
				runDirectory + "../Input/" +
				runPrefix +
				"_2004_data.txt" +
				"\", header=FALSE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE, skip=1)" +'\n');
		st.append("plot_colors <- c( \"#D92121\",\"#2121D9\", \"#21D921\", \"#FFFF4D\", \"#FF9326\", \"#9999FF\")" +'\n');
		st.append("png(\"" +
				plotImage +
				"\", width = 1536, height = 900)" + '\n');
		st.append("y_range <-range(Dataset$V13, Dataset$V14, PrDataset$V5, PrDataset$V6)" + '\n');
		
		st.append("plot(PrDataset$V3, PrDataset$V5, type=\"l\", xlab=\"Day of year\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, ylim=y_range, axes=TRUE , xlim=c(" +
				startDay +
				"," +
				endDay +
				"))" + '\n');
		st.append("lines(PrDataset$V3, PrDataset$V5, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[1])" + '\n');
		st.append("lines(PrDataset$V3, PrDataset$V6, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])" + '\n');
		st.append("lines(Dataset$V2, Dataset$V13, type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[1])" + '\n');
		st.append("lines(Dataset$V2, Dataset$V14, type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[2])" + '\n');
		st.append("atx <- seq(" +
				startDay +
				"," +
				endDay +
				",1)" + '\n');
		st.append("axis(1, at=atx, labels=atx, padj=0.5)" + '\n');
		st.append("axis(side = 2)" + '\n');
		st.append("box()" + '\n');
		st.append("title(\"" +
				title +
				"\", \"\")" + '\n');
		st.append("legend(\"topright\", legend = c(\"QH\",\"QE\"), col = plot_colors[1:2], lty = 1:1)" + '\n');
		st.append("legend(\"topleft\", legend = c(\"Preston\",\"SUEWS\"), col = plot_colors[1:1], lty = 1:2)" + '\n');
		st.append("grid()" + '\n');
		st.append("dev.off()" + '\n');
		st.append("" + '\n');
		st.append("" + '\n');
				
		common.runR(runDirectory, st.toString(), plotImage);
	}	
	
	public void runSUEWSDailyAverageGraphs(String runDirectory, String runPrefix)
	{
		//# X.day counter  qn  qs  qf qe_S  pp  ext_Ie  int_Ie tot_ie  E_S  Change  R_Soil   R   Fw    addWater
		
		
		// plot_colors <- c( "#D92121","#2121D9", "#21D921", "#FFFF4D", "#FF9326", "#9999FF")
		// PrDataset <- read.table("/home/kerryn/Documents/Work/PrestonData/CalculatedAverages/Preston2004DailyAverages.dat", header=TRUE, sep="", na.strings="NA", dec=".", strip.white=TRUE)
		// lines(PrDataset$Day_of_year, PrDataset$QE, type="l", lwd=2, pch=21, lty=1, col=plot_colors[2])
		// lines(PrDataset$Day_of_year, PrDataset$NET, type="l", lwd=2, pch=21, lty=1, col=plot_colors[2])
		

		
		
		String[] variables = {"qn","qs","qf","qe_S","pp","ext_Ie","int_Ie","tot_ie","E_S","Change","R_Soil","R","Fw","addWater"};
		String[] variablesDescript = {"(net all wave radiation)","(storage heat flux)","(anthropogenic heat flux)",
				"(latent heat flux-SUEWS)","(precipitation)","(external water use on grass)","(internal water)",
				"(total, ext+int, water use)","(evaportation per day/month)","(storage change)","(soil runoff)",
				"(surface runoff)","(additional water flow to water body)","(water input from other grids)"};
		
		StringBuffer st = new StringBuffer();
		st.append("plot_colors <- c( \"#D92121\",\"#2121D9\", \"#21D921\", \"#FFFF4D\", \"#FF9326\", \"#9999FF\")" + '\n');
		st.append("PrDataset <- read.table(\"" +
				common.getHostnameWorkDirPath() +
				Messages.getString("ProcessLumps.PrestonCalculatedPath") +				
				Messages.getString("ProcessLumps.PrestonCalculuated2004DailyAverages") +				
				"\", header=TRUE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE)" + '\n');
		st.append("Dataset <- read.table(\"/tmp/SUEWS_" +
				runPrefix +
				"/graphs/../Output/" +
				runPrefix +
				"_2004_DailyFile.txt\", header=TRUE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE, skip=1)" + '\n');
		int count = 0;
		for (String variable : variables)
		{
			String lineStr = "";
			String legendStr = "legend(\"topright\", legend = c(\"SUEWS\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
			String rangeStr = "";
			
			if (variable.equals("qn"))
			{
				lineStr = "lines(PrDataset$Day_of_year, PrDataset$NET, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])" + '\n';
				legendStr = "legend(\"topright\", legend = c(\"SUEWS\",\"Preston\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
				rangeStr = ",PrDataset$NET";
			}
			if (variable.equals("qs"))
			{
				lineStr = "lines(PrDataset$Day_of_year, PrDataset$QG, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])"+ '\n';
				legendStr = "legend(\"topright\", legend = c(\"SUEWS\",\"Preston\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
				rangeStr = ",PrDataset$QG";
			}	
			if (variable.equals("qf"))
			{
				lineStr = "lines(PrDataset$Day_of_year, PrDataset$Anthrop, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])"+ '\n';
				legendStr = "legend(\"topright\", legend = c(\"SUEWS\",\"Preston\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
				rangeStr = ",PrDataset$Anthrop";
			}
			if (variable.equals("qe_S"))
			{
				lineStr = "lines(PrDataset$Day_of_year, PrDataset$QE, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])"+ '\n';
				legendStr = "legend(\"topright\", legend = c(\"SUEWS\",\"Preston\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
				rangeStr = ",PrDataset$QE";
			}	
			if (variable.equals("pp"))
			{
				lineStr = "lines(PrDataset$Day_of_year, PrDataset$Precip, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])"+ '\n';
				legendStr = "legend(\"topright\", legend = c(\"SUEWS\",\"Preston\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
				rangeStr = ",PrDataset$Precip";
			}				
			
			st.append("png(\"" +
					runPrefix +
					"_Daily_" +
					variable +
					".png\", width = 1536, height = 900)" + '\n');
			st.append("y_range <-range(Dataset$" + variable + rangeStr +")" + '\n');
			st.append("plot(Dataset$X.day, Dataset$" +
					variable +
					", type=\"l\", xlab=\"Day of year\", ylab=\" \", lwd=1.5, pch=21, lty=1, ylim=y_range, axes=TRUE, col=plot_colors[1] )" + '\n');
			st.append(lineStr + '\n');
			
			st.append(legendStr);
			st.append("box()" + '\n');
			st.append("title(\"SUEWS " +
					runPrefix +
					" run 2004, " +
					variable + variablesDescript[count] + " from daily average file (DailyFile) " +
					"\", \"\")" + '\n');
			st.append("grid()" + '\n');
			st.append("dev.off()" + '\n');
			count ++;
		}	
		String imageFile = runPrefix + "_Daily_" + ".png";
		common.runR(runDirectory, st.toString(), imageFile);
		
//		String dirPlot = runDirectory + plotImage;
//		File diffPlotImage = new File(dirPlot);
//		if (!diffPlotImage.exists())
//		{
//			return;
//		}		
//		String source = dirPlot;
//		String tempDirectory = "/tmp/SUEWS_Graphs/";
//		String target = tempDirectory + plotImage;		
//		common.createSymlink(source, target);
		
		
	}	
	
	public void runSUEWSCalculatedDailyAverageGraphs(String runDirectory, String runPrefix)
	{
		//dectime kdown kup ldown lup Tsurf qn h_mod e_mod qs QF QH QE P/i Ie/i E/i DR/i Ch/i ST/i ROsoil/i RO/i ROpipe ROpav ROveg ROwater RA RS ustar L_mod SoilSt_pav SoilSt_blg SoilSt_con SoilSt_dec SoilSt_Irrgr SoilSt_Gr St_pav St_blg St_con St_dec St_Irrgr St_Gr St_water Fcld SoilState smd LAI Fw addWater 

		//Day_of_year time timecode month week Kdown Kup Ldown Lup NET QH QE QG Flux_validity CO2flux_final CO2_flux_validity Temp e_a wind_spd wind_dir. pressure Precip. Anthrop. tau soil_moisture deep_soil_temp FormattedDate RH  
		
		//String[] variables = {"qn","qs","qf","qe_S","pp","ext_Ie","int_Ie","tot_ie","E_S","Change","R_Soil","R","Fw","addWater"};
		String[] variables = {"kdown"};
		String[] variablesDescript = {"(incoming shortwave)"};
//		String[] variablesDescript = {"(net all wave radiation)","(storage heat flux)","(anthropogenic heat flux)",
//				"(latent heat flux-SUEWS)","(precipitation)","(external water use on grass)","(internal water)",
//				"(total, ext+int, water use)","(evaportation per day/month)","(storage change)","(soil runoff)",
//				"(surface runoff)","(additional water flow to water body)","(water input from other grids)"};
		
		StringBuffer st = new StringBuffer();
		st.append("plot_colors <- c( \"#D92121\",\"#2121D9\", \"#21D921\", \"#FFFF4D\", \"#FF9326\", \"#9999FF\")" + '\n');
		st.append("PrDataset <- read.table(\"" +
				common.getHostnameWorkDirPath() +
				Messages.getString("ProcessLumps.PrestonCalculatedPath") +				
				Messages.getString("ProcessLumps.PrestonCalculuated2004DailyAverages") +				
				"\", header=TRUE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE)" + '\n');
		st.append("Dataset <- read.table(\"/tmp/SUEWS_" +
				runPrefix +
				"/graphs/" +
				Messages.getString("SuewsPrestonComparisonGraphs.DAILY_AVERAGE_DAT_FILE") +
				"\", header=TRUE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE)" + '\n');
		int count = 0;
		for (String variable : variables)
		{
			String lineStr = "";
			String legendStr = "legend(\"topright\", legend = c(\"SUEWS\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
			String rangeStr = "";
			
			if (variable.equals("kdown"))
			{
				lineStr = "lines(PrDataset$Day_of_year, PrDataset$Kdown, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])" + '\n';
				legendStr = "legend(\"topright\", legend = c(\"SUEWS\",\"Preston\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
				rangeStr = ",PrDataset$Kdown";
			}
			if (variable.equals("qs"))
			{
				lineStr = "lines(PrDataset$Day_of_year, PrDataset$QG, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])"+ '\n';
				legendStr = "legend(\"topright\", legend = c(\"SUEWS\",\"Preston\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
				rangeStr = ",PrDataset$QG";
			}	
			if (variable.equals("qf"))
			{
				lineStr = "lines(PrDataset$Day_of_year, PrDataset$Anthrop, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])"+ '\n';
				legendStr = "legend(\"topright\", legend = c(\"SUEWS\",\"Preston\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
				rangeStr = ",PrDataset$Anthrop";
			}
			if (variable.equals("qe_S"))
			{
				lineStr = "lines(PrDataset$Day_of_year, PrDataset$QE, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])"+ '\n';
				legendStr = "legend(\"topright\", legend = c(\"SUEWS\",\"Preston\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
				rangeStr = ",PrDataset$QE";
			}	
			if (variable.equals("pp"))
			{
				lineStr = "lines(PrDataset$Day_of_year, PrDataset$Precip, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])"+ '\n';
				legendStr = "legend(\"topright\", legend = c(\"SUEWS\",\"Preston\"), col = plot_colors[1:2], lty = 1:1)" + '\n';
				rangeStr = ",PrDataset$Precip";
			}				
			
			st.append("png(\"" +
					runPrefix +
					"_CALC_Daily_" +
					variable +
					".png\", width = 1536, height = 900)" + '\n');
			st.append("y_range <-range(Dataset$" + variable + rangeStr +")" + '\n');
			st.append("plot(Dataset$dectime, Dataset$" +
					variable +
					", type=\"l\", xlab=\"Day of year\", ylab=\" \", lwd=1.5, pch=21, lty=1, ylim=y_range, axes=TRUE, col=plot_colors[1] )" + '\n');
			st.append(lineStr + '\n');
			
			st.append(legendStr);
			st.append("box()" + '\n');
			st.append("title(\"SUEWS " +
					runPrefix +
					" run 2004, " +
					variable + variablesDescript[count] + " from daily average file (calclated from 60 min file) " +
					"\", \"\")" + '\n');
			st.append("grid()" + '\n');
			st.append("dev.off()" + '\n');
			count ++;
		}	
		String imageFile = runPrefix + "_CALC_Daily_" + ".png";
		common.runR(runDirectory, st.toString(), imageFile);
		
//		String dirPlot = runDirectory + plotImage;
//		File diffPlotImage = new File(dirPlot);
//		if (!diffPlotImage.exists())
//		{
//			return;
//		}		
//		String source = dirPlot;
//		String tempDirectory = "/tmp/SUEWS_Graphs/";
//		String target = tempDirectory + plotImage;		
//		common.createSymlink(source, target);
		
		
	}			

	public void runPrestonSuewsApril2004CompareDaysDiff(String runDirectory, String runPrefix, int numDays)
	{
		int startDay = 92;
		int endDay = startDay + numDays;
		int month = 4;
		String monthName = common.getMonthForMonthInt(month);
		String title = "Comparisons, Preston vs. SUEWS, Difference (SUEWS - Preston) - " +
				monthName +
				" 2004";
		String plotImage = "Data_Diff_" +
				month +
				"_" + runPrefix + 
				".png";
		
		String monthStr = new Integer(month).toString();
		String monthPadded = common.padLeft(monthStr, 2, '0');
		
		StringBuffer st = new StringBuffer();
		

		st.append("Dataset <- read.table(\"" +
				runDirectory +
				runPrefix +
				"_2004_60.txt.gnuplot.dat" +
				"\", header=FALSE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE)" +'\n');
		st.append("PrDataset <- read.table(\"" +
				runDirectory + "../Input/" +
				runPrefix +
				"_2004_data.txt" +
				"\", header=FALSE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE, skip=1)" +'\n');
		st.append("plot_colors <- c( \"#D92121\",\"#2121D9\", \"#21D921\", \"#FFFF4D\", \"#FF9326\", \"#9999FF\")" +'\n');
		st.append("png(\"" +
				plotImage +
				"\", width = 1536, height = 900)" + '\n');
		st.append("y_range <-range(-300,300)" + '\n');
		
		st.append("plot(PrDataset$V3, (Dataset$V13-PrDataset$V5), type=\"l\", xlab=\"Day of year\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, ylim=y_range, axes=TRUE , xlim=c(" +
				startDay +
				"," +
				endDay +
				"))" + '\n');
		st.append("lines(PrDataset$V3, (Dataset$V13-PrDataset$V5), type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[1])" + '\n');
		st.append("lines(PrDataset$V3, (Dataset$V14-PrDataset$V6), type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])" + '\n');
				
		st.append("lines(PrDataset$V3, (Dataset$V9-PrDataset$V5), type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[1])" + '\n');
		st.append("lines(PrDataset$V3, (Dataset$V10-PrDataset$V6), type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[2])" + '\n');
		
		st.append("atx <- seq(" +
				startDay +
				"," +
				endDay +
				",1)" + '\n');
		st.append("axis(1, at=atx, labels=atx, padj=0.5)" + '\n');
		st.append("axis(side = 2)" + '\n');
		st.append("box()" + '\n');
		st.append("title(\"" +
				title +
				"\", \"\")" + '\n');
		st.append("legend(\"topright\", legend = c(\"QH\",\"QE\"), col = plot_colors[1:2], lty = 1:1)" + '\n');
		st.append("legend(\"topleft\", legend = c(\"LUMPS\",\"SUEWS\"), col = plot_colors[1:1], lty = 1:2)" + '\n');
		st.append("grid()" + '\n');
		st.append("dev.off()" + '\n');
		st.append("" + '\n');
		st.append("" + '\n');
				
		common.runR(runDirectory, st.toString(), plotImage);
		
		String dirPlot = runDirectory + plotImage;
		File diffPlotImage = new File(dirPlot);
		if (!diffPlotImage.exists())
		{
			return;
		}
		
		String source = dirPlot;
		String tempDirectory = "/tmp/SUEWS_Graphs/";
		String target = tempDirectory + plotImage;		
		common.createSymlink(source, target);
		
		
	}	
	

	
	
	public void runPrestonLumpsApril2004Compare(String runDirectory, String runPrefix)
	{
		//String lumpsDataFile = runDirectory + runPrefix + "04_X0001Y0001_60.txt.gnuplot.dat";
		
		int month = 4;
		String monthName = common.getMonthForMonthInt(month);
		String title = "Monthly averages comparisons, Preston vs. SUEWS - " +
				monthName +
				" 2004";
		String plotImage = "monthlyAve_" +
				month +
				"_" + runPrefix + 
				".png";
		
		String monthStr = new Integer(month).toString();
		String monthPadded = common.padLeft(monthStr, 2, '0');
		
		StringBuffer st = new StringBuffer();
		
		String prestonDataFile = "PrestonMonthlyAve_2004" + monthPadded + ".dat";
		File prestonDataFileFile = new File(runDirectory + prestonDataFile);
		if (!prestonDataFileFile.exists())
		{
			return;
		}
		st.append("preston_file <-\"" +
				prestonDataFile +
				"\"" +'\n');
		String suewsDataFile = "SUEWSMonthlyAve_" + month + ".dat";
		File suewsDataFileFile = new File(runDirectory + suewsDataFile);
		if (!suewsDataFileFile.exists())
		{
			return;
		}		
		st.append("suews_file <-\"" +
				suewsDataFile +
				"\"" +'\n');
	
		st.append("preston_table <- read.table(preston_file,header = FALSE,col.names=c(\"Time\",\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +
				PrestonWeatherData.QG +
				"\"))" +'\n');
		
		st.append("suews_table <- read.table(suews_file,header = FALSE,col.names=c(\"Time\",\"" +
				PrestonWeatherData.KDOWN +
				"\",\"" +
				PrestonWeatherData.KUP +
				"\",\"" +	
				PrestonWeatherData.LDOWN +
				"\",\"" +	
				PrestonWeatherData.LUP +
				"\",\"" +	
				PrestonWeatherData.ANTHROP +
				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\",\"" +
				PrestonWeatherData.QG +
				"\"))" +'\n');		

		//st.append("plot_colors <- rainbow(10)" + '\n');
		st.append("plot_colors <- c( \"#D92121\",\"#2121D9\", \"#21D921\", \"#FFFF4D\", \"#FF9326\", \"#9999FF\")" + '\n');		
		
		st.append("png(\"" +
				plotImage +
				"\", width = 1536, height = 900)" +'\n');
		
		st.append("y_range <-range(preston_table$QH,preston_table$QE,suews_table$QH,suews_table$QE)" + '\n');

		st.append("plot(preston_table$Time, preston_table$QH, type=\"l\", xlab=\"Time of day\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, ylim=y_range, axes=TRUE)" +'\n');
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.KDOWN +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[1])" +'\n');
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.KUP +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])" +'\n');
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.LDOWN +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[3])" +'\n');		
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.LUP +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[4])" +'\n');	
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.ANTHROP +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[5])" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QH +
				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[1])" +'\n');	
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QE +
				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])" +'\n');
//		st.append(" lines(preston_table$Time, preston_table$" +
//				PrestonWeatherData.QG +
//				", type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[8])" +'\n');		
		
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.KDOWN +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[1])" +'\n');
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.KUP +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[2])" +'\n');
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.LDOWN +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[3])" +'\n');		
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.LUP +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[4])" +'\n');	
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.ANTHROP +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[5])" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QH +
				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[1])" +'\n');	
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QE +
				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[2])" +'\n');
//		st.append(" lines(suews_table$Time, suews_table$" +
//				PrestonWeatherData.QG +
//				", type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[8])" +'\n');			

//		st.append("atx <- seq(firstdate, lastdate, by=24*60*60)" +'\n');
//		st.append("axis(1, at=atx, labels=format(atx, \"%b\n%d\"), padj=0.5)" +'\n');
		st.append("atx <- seq(0,24,6)" + '\n');
		st.append("axis(1, at=atx, labels=atx, padj=0.5)" + '\n');
		st.append("axis(side = 2)" +'\n');
		st.append("box()" +'\n');

		st.append("title(\"" +
				title +
				"\", \"\")" +'\n');
		st.append("legend(\"topright\", legend = c(\"" +
//				PrestonWeatherData.KDOWN +
//				"\",\"" +
//				PrestonWeatherData.KUP +
//				"\",\"" +	
//				PrestonWeatherData.LDOWN +
//				"\",\"" +	
//				PrestonWeatherData.LUP +
//				"\",\"" +	
//				PrestonWeatherData.ANTHROP +
//				"\",\"" +	
				PrestonWeatherData.QH +
				"\",\"" +	
				PrestonWeatherData.QE +
				"\"" +
//				",\"" +				
//				PrestonWeatherData.QG +
//				"\"" +
				"), col = plot_colors[1:2], lty = 1:1)" +'\n');
		st.append("legend(\"topleft\", legend = c(\"Preston\",\"SUEWS\"), col = plot_colors[1:1], lty = 1:2)" +'\n');
		st.append("grid()" +'\n');
		st.append("dev.off()" +'\n');
		
		common.runR(runDirectory, st.toString(), plotImage);
	}	
	
	public void runPrestonLumpsApril2004CompareDays(String runDirectory, String runPrefix, int numDays)
	{
		
		String lumpsDataFile = runDirectory + runPrefix + "04_X0001Y0001_60.txt.gnuplot.dat";
				
		String basePath = common.getHostnameWorkDirPath();
		
		String baseWeatherFile = Messages.getString("ProcessLumps.BaseWeatherData");
		String prestonCalculatedPath = Messages.getString("ProcessLumps.PrestonCalculatedPath");
		
		String source = basePath + prestonCalculatedPath + baseWeatherFile;

		String target = runDirectory + baseWeatherFile;		
		common.createSymlink(source, target);	

		String prestonDataFile = runDirectory + baseWeatherFile;
		
		int startDay = 92;
		int endDay = startDay + numDays;
		int month = 4;
		String monthName = common.getMonthForMonthInt(month);
		String title = "Comparisons, Preston vs. LUMPS - " +
				monthName +
				" 2004";
		String plotImage = "Data_" +
				month +
				"_" + runPrefix + 
				".png";
		
		String monthStr = new Integer(month).toString();
		String monthPadded = common.padLeft(monthStr, 2, '0');
		
		StringBuffer st = new StringBuffer();
				
		st.append("Dataset <- read.table(\"" +
				lumpsDataFile +
				"\", header=FALSE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE)" +'\n');
		st.append("PrDataset <- read.table(\"" +
				prestonDataFile +
				"\", header=FALSE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE, skip=1)" +'\n');
		st.append("plot_colors <- c( \"#D92121\",\"#2121D9\", \"#21D921\", \"#FFFF4D\", \"#FF9326\", \"#9999FF\")" +'\n');
		st.append("png(\"" +
				plotImage +
				"\", width = 1536, height = 900)" + '\n');
		st.append("y_range <-range(Dataset$V9, Dataset$V10, PrDataset$V5, PrDataset$V6)" + '\n');
		
		st.append("plot(PrDataset$V3, PrDataset$V5, type=\"l\", xlab=\"Day of year\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, ylim=y_range, axes=TRUE , xlim=c(" +
				startDay +
				"," +
				endDay +
				"))" + '\n');
		st.append("lines(PrDataset$V3, PrDataset$V5, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[1])" + '\n');
		st.append("lines(PrDataset$V3, PrDataset$V6, type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])" + '\n');
		st.append("lines(Dataset$V2, Dataset$V9, type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[1])" + '\n');
		st.append("lines(Dataset$V2, Dataset$V10, type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[2])" + '\n');
		st.append("atx <- seq(" +
				startDay +
				"," +
				endDay +
				",1)" + '\n');
		st.append("axis(1, at=atx, labels=atx, padj=0.5)" + '\n');
		st.append("axis(side = 2)" + '\n');
		st.append("box()" + '\n');
		st.append("title(\"" +
				title +
				"\", \"\")" + '\n');
		st.append("legend(\"topright\", legend = c(\"QH\",\"QE\"), col = plot_colors[1:2], lty = 1:1)" + '\n');
		st.append("legend(\"topleft\", legend = c(\"Preston\",\"LUMPS\"), col = plot_colors[1:1], lty = 1:2)" + '\n');
		st.append("grid()" + '\n');
		st.append("dev.off()" + '\n');
		st.append("" + '\n');
		st.append("" + '\n');
				
		common.runR(runDirectory, st.toString(), plotImage);
	}	

	public void runPrestonLumpsApril2004CompareDaysDiff(String runDirectory, String runPrefix, int numDays)
	{
		int startDay = 92;
		int endDay = startDay + numDays;
		int month = 4;
		String monthName = common.getMonthForMonthInt(month);
		String title = "Comparisons, Preston vs. LUMPS, Difference (LUMPS - Preston) - " +
				monthName +
				" 2004";
		String plotImage = "Data_Diff_" +
				month +
				"_" + runPrefix + 
				".png";
		
		String monthStr = new Integer(month).toString();
		String monthPadded = common.padLeft(monthStr, 2, '0');
		
		StringBuffer st = new StringBuffer();
		String lumpsDataFile = runDirectory + runPrefix + "04_X0001Y0001_60.txt.gnuplot.dat";
		String prestonDataFile = runDirectory + "../Input/" + runPrefix +
				"04_X0001Y0001_data.TXT";

		st.append("Dataset <- read.table(\"" +
				lumpsDataFile +
				"\", header=FALSE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE)" +'\n');
		st.append("PrDataset <- read.table(\"" +
				prestonDataFile +
				"\", header=FALSE, sep=\"\", na.strings=\"NA\", dec=\".\", strip.white=TRUE, skip=1)" +'\n');
		st.append("plot_colors <- c( \"#D92121\",\"#2121D9\", \"#21D921\", \"#FFFF4D\", \"#FF9326\", \"#9999FF\")" +'\n');
		st.append("png(\"" +
				plotImage +
				"\", width = 1536, height = 900)" + '\n');
		st.append("y_range <-range(-300,300)" + '\n');
		
		st.append("plot(PrDataset$V3, (Dataset$V9-PrDataset$V5), type=\"l\", xlab=\"Day of year\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, ylim=y_range, axes=TRUE , xlim=c(" +
				startDay +
				"," +
				endDay +
				"))" + '\n');
		st.append("lines(PrDataset$V3, (Dataset$V9-PrDataset$V5), type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[1])" + '\n');
		st.append("lines(PrDataset$V3, (Dataset$V10-PrDataset$V6), type=\"l\", lwd=2, pch=21, lty=1, col=plot_colors[2])" + '\n');
				
//		st.append("lines(PrDataset$V3, (Dataset$V9-PrDataset$V5), type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[1])" + '\n');
//		st.append("lines(PrDataset$V3, (Dataset$V10-PrDataset$V6), type=\"l\", lwd=2, pch=21, lty=3, col=plot_colors[2])" + '\n');
		
		st.append("atx <- seq(" +
				startDay +
				"," +
				endDay +
				",1)" + '\n');
		st.append("axis(1, at=atx, labels=atx, padj=0.5)" + '\n');
		st.append("axis(side = 2)" + '\n');
		st.append("box()" + '\n');
		st.append("title(\"" +
				title +
				"\", \"\")" + '\n');
		st.append("legend(\"topright\", legend = c(\"QH\",\"QE\"), col = plot_colors[1:2], lty = 1:1)" + '\n');
//		st.append("legend(\"topleft\", legend = c(\"LUMPS\",\"SUEWS\"), col = plot_colors[1:1], lty = 1:2)" + '\n');
		st.append("grid()" + '\n');
		st.append("dev.off()" + '\n');
		st.append("" + '\n');
		st.append("" + '\n');
				
		common.runR(runDirectory, st.toString(), plotImage);
		
		String dirPlot = runDirectory + plotImage;
		File diffPlotImage = new File(dirPlot);
		if (!diffPlotImage.exists())
		{
			return;
		}
		
		String source = dirPlot;
		String tempDirectory = "/tmp/SUEWS_Graphs/";
		String target = tempDirectory + plotImage;		
		common.createSymlink(source, target);
		
		
	}	
	
	
	
	
	
	
	
	
	
}
