package au.edu.monash.ges.suews;

public class RGraphs {

	ENVICommon common = new ENVICommon();
	
	public static void main(String[] args) {
		
		RGraphs rGraphs = new RGraphs();
		String runDirectory = "/tmp/SUEWS_Pr3714/graphs/";
		rGraphs.runPreston2(runDirectory);

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
		StringBuffer st = new StringBuffer();
		

		st.append("preston_file <-\"PrestonMonthlyAve_200403.dat\"" +'\n');
	
		st.append("preston_table <- read.table(preston_file,header = FALSE,col.names=c(\"Time\",\"Kdown\"))" +'\n');


		st.append("png(\"r_plot_2.png\", width = 1536, height = 900)" +'\n');

		st.append("plot(preston_table$Time, preston_table$Kdown, type=\"l\", xlab=\"Date\", ylab=\"w/m2\", lwd=1.5, pch=21, lty=1, , axes=TRUE)" +'\n');
		st.append(" lines(preston_table$Time, preston_table$Kdown, type=\"l\", lwd=1.5, pch=21, lty=1, col=1)" +'\n');

		st.append("atx <- seq(firstdate, lastdate, by=24*60*60)" +'\n');
		st.append("axis(1, at=atx, labels=format(atx, \"%b\n%d\"), padj=0.5)" +'\n');
		st.append("axis(side = 2)" +'\n');
		st.append("box()" +'\n');

		st.append("title(\"Plot for fluxes-Monthly Averages-March 2004\", \"\")" +'\n');
		st.append("legend(\"topright\", legend = c(\"kdown\"), col = 1:8, lty = 1:1)" +'\n');
		st.append("grid()" +'\n');
		st.append("dev.off()" +'\n');






		
		common.runR(runDirectory, st.toString());
	}

}
