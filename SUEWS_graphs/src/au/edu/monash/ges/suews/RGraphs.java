package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.TreeMap;

public class RGraphs {

	ENVICommon common = new ENVICommon();
	
	public static void main(String[] args) {
		RGraphs rGraphs = new RGraphs();
		//rGraphs.process();
		//rGraphs.runGenericChart(null, null, null, null, null);
		//rGraphs.process2();
		
		
		String graphDirectory = "/tmp/SUEWS_Pr3714/graphs/";
		rGraphs.runPreston2(graphDirectory);
		
		for (int i=1;i<13;i++)
		{
			rGraphs.runPreston3(graphDirectory, i);
		}
			
		
		
		

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
		ArrayList<TreeMap<String, String>> variables = weatherData.getPrestonData(-1);
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
		StringBuffer st = new StringBuffer();
		
		st.append("filename <-\"PRESTON CITIES 13092011_2.txt.gnuplot.dat\""+ '\n');
		st.append("data_table <- read.table(filename,col.names=c(\"Year\",\"Day_of_year\",\"time\",\"timecode\",\"month\",\"week\",\"Kdown\",\"Kup\",\"Ldown\",\"Lup\",\"NET\",\"QH\",\"QE\",\"QG\"," +'\n');
		st.append("		\"Flux_validity\",\"CO2flux_final\",\"CO2_flux_validity\",\"Temp\",\"e_a\",\"wind_spd\",\"wind_dir.\",\"pressure\",\"Precip.\"," +'\n');
		st.append("		\"Anthrop.\",\"tau\",\"soil_moisture\",\"deep_soil_temp\",\"FormattedDate\",\"RH\"))" +'\n');
		st.append("dates <- strptime(as.character(data_table$timecode), format(\"%Y%j%H%M\"))" +'\n');
		st.append("beg <- as.Date(\"2004-11-26\", \"%Y-%m-%d\") " +'\n');
		st.append("end <- as.Date(\"2004-11-28\", \"%Y-%m-%d\") " +'\n');
		st.append("firstdate = ISOdate(2004,3,1)" +'\n');
		st.append("lastdate = ISOdate(2004,3,20)" +'\n');
		st.append("png(\"r_plot.png\", width = 1536, height = 900)" +'\n');
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

		common.runR(runDirectory, st.toString());		
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
		
		common.runR(runDirectory, st.toString());
	}
	
	public void runPreston3(String runDirectory, int month)
	{
		String title = "Monthly averages comparisons, Preston vs. SUEWS -" +
				//"March" +
				month +
				" 2004";
		String plotImage = "monthlyAve_" +
				month +
				".png";
		
		String monthStr = new Integer(month).toString();
		String monthPadded = common.padLeft(monthStr, 2, '0');
		
		StringBuffer st = new StringBuffer();
		

		st.append("preston_file <-\"PrestonMonthlyAve_2004" +
				monthPadded +
				".dat\"" +'\n');
		st.append("suews_file <-\"SUEWSMonthlyAve_" +
				month +
				".dat\"" +'\n');
	
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


		st.append("png(\"" +
				plotImage +
				"\", width = 1536, height = 900)" +'\n');

		st.append("plot(preston_table$Time, preston_table$Kdown, type=\"l\", xlab=\"Time of day\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, , axes=TRUE)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.KDOWN +
				", type=\"l\", lwd=2, pch=21, lty=1, col=1)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.KUP +
				", type=\"l\", lwd=2, pch=21, lty=1, col=2)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.LDOWN +
				", type=\"l\", lwd=2, pch=21, lty=1, col=3)" +'\n');		
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.LUP +
				", type=\"l\", lwd=2, pch=21, lty=1, col=4)" +'\n');	
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.ANTHROP +
				", type=\"l\", lwd=2, pch=21, lty=1, col=5)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QH +
				", type=\"l\", lwd=2, pch=21, lty=1, col=6)" +'\n');	
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QE +
				", type=\"l\", lwd=2, pch=21, lty=1, col=7)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$" +
				PrestonWeatherData.QG +
				", type=\"l\", lwd=2, pch=21, lty=1, col=8)" +'\n');		
		
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.KDOWN +
				", type=\"l\", lwd=2, pch=21, lty=3, col=1)" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.KUP +
				", type=\"l\", lwd=2, pch=21, lty=3, col=2)" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.LDOWN +
				", type=\"l\", lwd=2, pch=21, lty=3, col=3)" +'\n');		
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.LUP +
				", type=\"l\", lwd=2, pch=21, lty=3, col=4)" +'\n');	
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.ANTHROP +
				", type=\"l\", lwd=2, pch=21, lty=3, col=5)" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QH +
				", type=\"l\", lwd=2, pch=21, lty=3, col=6)" +'\n');	
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QE +
				", type=\"l\", lwd=2, pch=21, lty=3, col=7)" +'\n');
		st.append(" lines(suews_table$Time, suews_table$" +
				PrestonWeatherData.QG +
				", type=\"l\", lwd=2, pch=21, lty=1, col=8)" +'\n');			

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
		st.append("legend(\"topleft\", legend = c(\"Preston\",\"SUEWS\"), col = 1:1, lty = 1:2)" +'\n');
		st.append("grid()" +'\n');
		st.append("dev.off()" +'\n');
		
		common.runR(runDirectory, st.toString());
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
		
		common.runR(runDirectory, st.toString());
	}	

}
