package au.edu.monash.ges.suews;

import java.util.ArrayList;
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
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
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
		String suewsTimeField = "50";
		String prestonTimeField = "26";
		String suewsVariableNumber = "3";
		String prestonVariableNumber = "7";
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);

		variable = "Tsurf";
		suewsVariableNumber = "7";
		prestonVariableNumber = "18";
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);

		variable = "QH";
		suewsVariableNumber = "7";
		prestonVariableNumber = "9";
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);

		variable = "QE";
		suewsVariableNumber = "8";
		prestonVariableNumber = "10";
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);

		variable = "QG";
		suewsVariableNumber = "9";
		prestonVariableNumber = "11";
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
//
//		variable = "QG";
//		suewsVariableNumber = "9";
//		prestonVariableNumber = "11";
//		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);


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
		aPlot.setOutput(Terminal.PNG, outputFile, " 1024,600  enhanced font Vera 14 ");
		aPlot.unsetLogscale();
		aPlot.setYTics("nomirror");
//		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 pi 20");
//		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 pi 20");
//		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 pi 20");
//		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 pi 20");
//		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 pi 20");
//		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 pi 20");
//		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 pi 20");
//		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 pi 20");
//		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 pi 20");
//		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 pi 20");
//		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 pi 20");

		aPlot.addExtra("set tmargin 1");
		aPlot.addExtra("set bmargin 2");
		aPlot.addExtra("set lmargin 6");
		aPlot.addExtra("set rmargin 1");

		aPlot.addExtra("set xdata time");
		aPlot.addExtra("set timefmt '%Y-%j-%H%M'");
		aPlot.addExtra("set xrange [\"2004-001-0000\":\"2004-045-0000\"]");

		aPlot.addExtra("set dgrid3d 10,10,1");
		aPlot.addExtra("set ylabel \" " + variable + "\"");
		String xLabel = "Time";
		aPlot.addExtra("set xlabel \" " + xLabel + "\"");

		aPlot.setDataFileName(suewsDataFileName);
		aPlot.pushGraph(new Graph(suewsDataFileName, suewsTimeField + ":" + suewsVariableNumber, Axes.X1Y1, variable + "-SUEWS", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));
		aPlot.pushGraph(new Graph(prestonDataFileName, prestonTimeField + ":" + prestonVariableNumber, Axes.X1Y1, variable + "-Preston", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));


		try
		{
			String plotCommand = aPlot.plot();
			//System.out.println("command=" + command);
			String gnuplotScriptFile = plotCommand.replaceFirst("gnuplot", "");
			String[] commands = new String[]{Messages.getString("ProcessSUEWSRun.GNUPLOT_SH"), " " + plotDirectory, " " + gnuplotScriptFile};
			Process aProcess = Runtime.getRuntime().exec(commands);
			System.out.println("commands="+ commands[0] + commands[1] + commands[2] );
			//System.out.println("aProcess.exitValue()="+ aProcess.exitValue());

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
			//System.exit(1);
//			if (count ==0)
//			{
//				//skip this one
//				count++;
//				continue;
//			}
//			else if (count == 1)
//			{
//				outputStr.append(variables.get(0) + "-" + variable + " ");
//				count++;
//			}
//			else
//			{
				outputStr.append(variable + " ");
				count++;
//			}


		}
		outputStr.append('\n');


		TreeMap<String, ArrayList<String>> theData = prestonDataFile.getData();
		ArrayList<String> timeArray = theData.get("tau");
		//ArrayList<String> varibleArray = theData.get(variable);

		for (int i = 0;i<timeArray.size()-1;i++)
		{
			count = 0;
			for (String variable : variables)
			{
//				if (count == 0)
//				{
//					count++;
//					//skip this one
//					continue;
//				}
//				else if (count == 1)
//				{
//					outputStr.append(theData.get("id").get(i) + "-" + theData.get("it").get(i) + " ");
//					count++;
//				}
//				else
//				{
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
