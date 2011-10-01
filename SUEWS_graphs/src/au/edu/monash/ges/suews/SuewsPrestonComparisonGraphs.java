package au.edu.monash.ges.suews;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jgnuplot.Axes;
import org.jgnuplot.Graph;
import org.jgnuplot.LineType;
import org.jgnuplot.Plot;
import org.jgnuplot.PointType;
import org.jgnuplot.Style;
import org.jgnuplot.Terminal;

public class SuewsPrestonComparisonGraphs
{

	ENVICommon common = new ENVICommon();

	public static String XRANGE_BEG = "2004-001-0000";
	public static String XRANGE_END = "2004-005-0000";
	//public static String GRAPH_SIZE = "1024,600";
	public static String GRAPH_SIZE = "1536,900";

	public static String PRESTON_Year = "1";
	public static String PRESTON_Day_of_year = "2";
	public static String PRESTON_time = "3";
	public static String PRESTON_timecode = "4";
	public static String PRESTON_month = "5";
	public static String PRESTON_week = "6";
	public static String PRESTON_Kdown = "7";
	public static String PRESTON_Kup = "8";
	public static String PRESTON_Ldown = "9";
	public static String PRESTON_Lup = "10";
	public static String PRESTON_NET = "11";
	public static String PRESTON_QH = "12";
	public static String PRESTON_QE = "13";
	public static String PRESTON_QG = "14";
	public static String PRESTON_Flux_validity = "15";
	public static String PRESTON_CO2flux_final = "16";
	public static String PRESTON_CO2_flux_validity = "17";
	public static String PRESTON_Temp = "18";
	public static String PRESTON_e_a = "19";
	public static String PRESTON_wind_spd = "20";
	public static String PRESTON_wind_dir = "21";
	public static String PRESTON_pressure = "22";
	public static String PRESTON_Precip = "23";
	public static String PRESTON_Anthrop = "24";
	public static String PRESTON_tau = "25";
	public static String PRESTON_soil_moisture = "26";
	public static String PRESTON_deep_soil_temp = "27";
	public static String PRESTON_FormattedDate = "28";

	public static String SUEWS_id_it = "1";
	//public static String SUEWS_it = "2";
	public static String SUEWS_dectime = "2";
	public static String SUEWS_kdown = "3";
	public static String SUEWS_kup = "4";
	public static String SUEWS_ldown = "5";
	public static String SUEWS_lup = "6";
	public static String SUEWS_Tsurf = "7";
	public static String SUEWS_qn = "8";
	public static String SUEWS_h_mod = "9";
	public static String SUEWS_e_mod = "10";
	public static String SUEWS_qs = "11";
	public static String SUEWS_QF = "12";
	public static String SUEWS_QH = "13";
	public static String SUEWS_QE = "14";
	public static String SUEWS_P_i = "15";
	public static String SUEWS_Ie_i = "16";
	public static String SUEWS_E_i = "17";
	public static String SUEWS_DR_i = "18";
	public static String SUEWS_Ch_i = "19";
	public static String SUEWS_ST_i = "20";
	public static String SUEWS_ROsoil_i = "21";
	public static String SUEWS_RO_i = "22";
	public static String SUEWS_ROpipe = "23";
	public static String SUEWS_ROpav = "24";
	public static String SUEWS_ROveg = "25";
	public static String SUEWS_ROwater = "26";
	public static String SUEWS_RA = "27";
	public static String SUEWS_RS = "28";
	public static String SUEWS_ustar = "29";
	public static String SUEWS_L_mod = "30";
	public static String SUEWS_SoilSt_pav = "31";
	public static String SUEWS_SoilSt_blg = "32";
	public static String SUEWS_SoilSt_con = "33";
	public static String SUEWS_SoilSt_dec = "34";
	public static String SUEWS_SoilSt_Irrgr = "35";
	public static String SUEWS_SoilSt_Gr = "36";
	public static String SUEWS_St_pav = "37";
	public static String SUEWS_St_blg = "38";
	public static String SUEWS_St_con = "39";
	public static String SUEWS_St_dec = "40";
	public static String SUEWS_St_Irrgr = "41";
	public static String SUEWS_St_Gr = "42";
	public static String SUEWS_St_water = "43";
	public static String SUEWS_Fcld = "44";
	public static String SUEWS_SoilState = "45";
	public static String SUEWS_smd = "46";
	public static String SUEWS_LAI = "47";
	public static String SUEWS_Fw = "48";
	public static String SUEWS_addWater = "49";
	public static String SUEWS_FormattedDate = "50";


	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		ArrayList<String> variableArray = new ArrayList<String>();
		ArrayList<String> suewsVariableNumberArray = new ArrayList<String>();
		ArrayList<String> prestonVariableNumberArray = new ArrayList<String>();

		SuewsPrestonComparisonGraphs suewsPrestonComparisonGraphs = new SuewsPrestonComparisonGraphs();

		String graphDir = Messages.getString("SuewsPrestonComparisonGraphs.graph_dir");

		String prestonPath = Messages.getString("PrestonDataFile.DATA_PATH");
		String prestonFilename = Messages.getString("PrestonDataFile.DATA_FILE");

		PrestonDataFile prestonDataFile = new PrestonDataFile(prestonPath, prestonFilename, true);
		prestonDataFile.setPath(graphDir);
		suewsPrestonComparisonGraphs.generateReformattedPrestonDataFile(prestonDataFile);
		//TreeMap<String, ArrayList<String>> theData = prestonDataFile.getData();
		//System.out.println(theData.get(prestonDataFile.FORMATTED_DATE).toString());


		String suewsPath = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DATA_PATH");
		String suewsFilename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE");

		ProcessSUEWSRun processSUEWSRun = new ProcessSUEWSRun();
		SUEWSDataFile suewsDataFile = new SUEWSDataFile(suewsPath, suewsFilename, true);
		suewsDataFile.setPath(graphDir);
		processSUEWSRun.generateReformattedDataFile(suewsDataFile);
		//String timeField = "dectime";
		String variable = "kdown";
		String suewsTimeField = SUEWS_FormattedDate;
		String prestonTimeField = PRESTON_FormattedDate;
		String suewsVariableNumber = "3";
		String prestonVariableNumber = "7";
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "Tsurf";
		suewsVariableNumber = SUEWS_Tsurf;
		prestonVariableNumber =  PRESTON_Temp ;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);

		variable = "QH";
		suewsVariableNumber =  SUEWS_QH;
		//suewsVariableNumber =  SUEWS_h_mod;
		prestonVariableNumber = PRESTON_QH;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "QE";
		suewsVariableNumber = SUEWS_QE;
		//suewsVariableNumber = SUEWS_e_mod;
		prestonVariableNumber = PRESTON_QE;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "QG";
		suewsVariableNumber = SUEWS_qs;
		prestonVariableNumber = PRESTON_QG;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "kup";
		suewsVariableNumber = SUEWS_kup;
		prestonVariableNumber = PRESTON_Kup;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "lup";
		suewsVariableNumber = SUEWS_lup;
		prestonVariableNumber = PRESTON_Lup;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "ldown";
		suewsVariableNumber = SUEWS_ldown;
		prestonVariableNumber = PRESTON_Ldown;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "net";
		suewsVariableNumber = SUEWS_qn;
		prestonVariableNumber = PRESTON_NET;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "Anthrop";
		suewsVariableNumber = SUEWS_QF;
		prestonVariableNumber = PRESTON_Anthrop;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);



		suewsPrestonComparisonGraphs.plotDataMultiples(suewsDataFile, variableArray, prestonDataFile, suewsVariableNumberArray, prestonVariableNumberArray, suewsTimeField, prestonTimeField, "EnergyBalance");

	}

	public void plotDataMultiples(SUEWSDataFile sUEWSDataFile, ArrayList<String> variableArray, PrestonDataFile prestonDataFile,
			ArrayList<String> suewsVariableNumberArray, ArrayList<String> prestonVariableNumberArray, String suewsTimeField, String prestonTimeField, String graphPrefix)
	{
		String suewsDataFileName = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + ".gnuplot.dat";
		String prestonDataFileName = prestonDataFile.getPath() + prestonDataFile.getFilename() + ".gnuplot.dat";
		String outputFile = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + "_" + graphPrefix + ".png";

		Plot.setGnuplotExecutable("gnuplot");
		String plotDirectory = sUEWSDataFile.getPath().substring(0, sUEWSDataFile.getPath().length()-1);
		Plot.setPlotDirectory(plotDirectory);
		Plot aPlot = new Plot();

		aPlot.setTitle("Plot for " + graphPrefix);
		aPlot.setGrid();
		aPlot.setKey("right box");
		aPlot.unsetParametric();
		aPlot.unsetPolar();
		aPlot.setOutput(Terminal.PNG, outputFile, " " + GRAPH_SIZE + "  enhanced font Vera 14 ");
		aPlot.unsetLogscale();
		aPlot.setYTics("nomirror");
		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 pi 20");
		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 pi 20");
		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 pi 20");
		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 pi 20");
		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 pi 20");
		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 pi 20");
		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 pi 20");
		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 pi 20");
		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 pi 20");
		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 pi 20");
		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 pi 20");

		aPlot.addExtra("set tmargin 1");
		aPlot.addExtra("set bmargin 2");
		aPlot.addExtra("set lmargin 6");
		aPlot.addExtra("set rmargin 1");

		aPlot.addExtra("set xdata time");
		aPlot.addExtra("set timefmt '%Y-%j-%H%M'");
		aPlot.addExtra("set xrange [\"" + XRANGE_BEG + "\":\"" + XRANGE_END + "\"]");

		aPlot.addExtra("set dgrid3d 10,10,1");
		aPlot.addExtra("set ylabel \" " + graphPrefix + "\"");
		String xLabel = "Time";
		aPlot.addExtra("set xlabel \" " + xLabel + "\"");

		aPlot.setDataFileName(suewsDataFileName);

		for (int i=0;i<variableArray.size();i++)
		{
			String variable = variableArray.get(i);
			String suewsVariableNumber = suewsVariableNumberArray.get(i);
			String prestonVariableNumber = prestonVariableNumberArray.get(i);

			aPlot.pushGraph(new Graph(suewsDataFileName, suewsTimeField + ":" + suewsVariableNumber, Axes.X1Y1, variable + "-SUEWS", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));
			aPlot.pushGraph(new Graph(prestonDataFileName, prestonTimeField + ":" + prestonVariableNumber, Axes.X1Y1, variable + "-Preston", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));
		}

		try
		{
//			OutputStream stdin = null;
//		    InputStream stderr = null;
//		    InputStream stdout = null;
//		    String line;
			String plotCommand = aPlot.plot();
			plotCmd(plotCommand, plotDirectory);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public void plotData(SUEWSDataFile sUEWSDataFile, String variable, PrestonDataFile prestonDataFile,
			String suewsVariableNumber, String prestonVariableNumber, String suewsTimeField, String prestonTimeField)
	{
		String suewsDataFileName = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + ".gnuplot.dat";
		String prestonDataFileName = prestonDataFile.getPath() + prestonDataFile.getFilename() + ".gnuplot.dat";
		String outputFile = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + "_" + variable + ".png";

		Plot.setGnuplotExecutable("gnuplot");
		String plotDirectory = sUEWSDataFile.getPath().substring(0, sUEWSDataFile.getPath().length()-1);
		Plot.setPlotDirectory(plotDirectory);
		Plot aPlot = new Plot();

		aPlot.setTitle("Plot for " + variable);
		aPlot.setGrid();
		aPlot.setKey("right box");
		aPlot.unsetParametric();
		aPlot.unsetPolar();
		aPlot.setOutput(Terminal.PNG, outputFile, " " + GRAPH_SIZE + "  enhanced font Vera 14 ");
		aPlot.unsetLogscale();
		aPlot.setYTics("nomirror");
		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 pi 20");
		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 pi 20");
		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 pi 20");
		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 pi 20");
		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 pi 20");
		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 pi 20");
		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 pi 20");
		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 pi 20");
		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 pi 20");
		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 pi 20");
		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 pi 20");

		aPlot.addExtra("set tmargin 1");
		aPlot.addExtra("set bmargin 2");
		aPlot.addExtra("set lmargin 6");
		aPlot.addExtra("set rmargin 1");

		aPlot.addExtra("set xdata time");
		aPlot.addExtra("set timefmt '%Y-%j-%H%M'");
		aPlot.addExtra("set xrange [\"" + XRANGE_BEG + "\":\"" + XRANGE_END + "\"]");

		aPlot.addExtra("set dgrid3d 10,10,1");
		aPlot.addExtra("set ylabel \" " + variable + "\"");
		String xLabel = "Time";
		aPlot.addExtra("set xlabel \" " + xLabel + "\"");

		aPlot.setDataFileName(suewsDataFileName);
		aPlot.pushGraph(new Graph(suewsDataFileName, suewsTimeField + ":" + suewsVariableNumber, Axes.X1Y1, variable + "-SUEWS", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));
		aPlot.pushGraph(new Graph(prestonDataFileName, prestonTimeField + ":" + prestonVariableNumber, Axes.X1Y1, variable + "-Preston", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));


		try
		{
//			OutputStream stdin = null;
//		    InputStream stderr = null;
//		    InputStream stdout = null;
//		    String line;
			String plotCommand = aPlot.plot();
			plotCmd(plotCommand, plotDirectory);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void plotCmd(String plotCommand, String plotDirectory)
	{
		try
		{
			OutputStream stdin = null;
		    InputStream stderr = null;
		    InputStream stdout = null;
		    String line;

			String gnuplotScriptFile = plotCommand.replaceFirst("gnuplot", "");
			ProcessBuilder pb= new ProcessBuilder("/usr/bin/gnuplot", gnuplotScriptFile);
			pb.directory(new File(plotDirectory));
			Process p = pb.start();
			p.waitFor();

			stdin = p.getOutputStream ();
		    stderr = p.getErrorStream ();
		    stdout = p.getInputStream ();
		    BufferedReader brCleanUp = new BufferedReader (new InputStreamReader (stdout));
		    while ((line = brCleanUp.readLine ()) != null)
		    {
		        System.out.println ("[Stdout] " + line);
		    }
		    brCleanUp.close();
		    brCleanUp = new BufferedReader (new InputStreamReader (stderr));
		    while ((line = brCleanUp.readLine ()) != null)
		    {
		    	System.out.println ("[Stderr] " + line);
		    }
		    brCleanUp.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void generateReformattedPrestonDataFile(PrestonDataFile prestonDataFile)
	{
		StringBuffer outputStr = new StringBuffer("# ");

		ArrayList<String> variables = prestonDataFile.getVariables();
		//System.out.println (variables.toString());
		int count = 0;
		for (String variable : variables)
		{
			outputStr.append(variable + " ");
			count++;
		}
		outputStr.append('\n');


		TreeMap<String, ArrayList<String>> theData = prestonDataFile.getData();
		ArrayList<String> timeArray = theData.get("tau");

		for (int i = 0;i<timeArray.size()-1;i++)
		{
			count = 0;
			for (String variable : variables)
			{
				ArrayList<String> dataArray = theData.get(variable);
				if (dataArray == null)
				{
					//System.out.println("theData.get(variable)="+ variable);
					String variableValue = "?";
					outputStr.append(variableValue + " ");

				}
				else
				{
					//System.out.println(dataArray.toString());
					//System.out.println(variable + "=" + variable);
					String variableValue = dataArray.get(i);
					//System.out.println(variable + "=" + variableValue);
					outputStr.append(variableValue + " ");
				}
					count++;
//				}

			}
			outputStr.append('\n');
		}

		String dataFileName = prestonDataFile.getPath() + prestonDataFile.getFilename() + ".gnuplot.dat";
		common.writeFile(outputStr.toString(), dataFileName);
	}


}
