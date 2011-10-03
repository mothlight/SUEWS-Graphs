package au.edu.monash.ges.suews;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.jgnuplot.Axes;
import org.jgnuplot.Graph;
import org.jgnuplot.LineType;
import org.jgnuplot.Plot;
import org.jgnuplot.PointType;
import org.jgnuplot.Splot;
import org.jgnuplot.Style;
import org.jgnuplot.Terminal;

public class ProcessSUEWSRun {

	ENVICommon common = new ENVICommon();
	final public String VARIABLE_SEPARATOR = Messages.getString("ProcessSUEWSRun.VARIABLE_SEPARATOR");
	final public int NUMBER_OF_HOURS = 24;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DATA_PATH");
		String filename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE");


//		String fileVariables = Messages.getString("ProcessSUEWSRun.TUF3D_Tsfc_Facets_VARIABLES");
//		String timeOfDayVariable = Messages.getString("ProcessSUEWSRun.TUF3D_EnergyBalance_Facets_TIME_OF_DAY_VARIABLE");
//		String variablePrefix = "T";

		ProcessSUEWSRun processSUEWSRun = new ProcessSUEWSRun();
		processSUEWSRun.process(path, filename);




	}

	public void process(String path, String filename)
	{

		SUEWSDataFile suewsDataFile = new SUEWSDataFile(path, filename, false, SUEWSDataFile.LINES_TO_SKIP_60);
		//System.out.println(suewsDataFile.getVariables().toString());
		//TreeMap<String, ArrayList<String>> theData = suewsDataFile.getData();

		plotVariables(suewsDataFile);


		//plotVariable(suewsDataFile);



		//String toFind = Messages.getString("ProcessSUEWSRun.2");
		//ArrayList<String> dataItem = theData.get(toFind);
		//System.out.println(dataItem.toString());

		//toFind = "time_of_day";
		//dataItem = theData.get(toFind);
		//System.out.println(dataItem.toString());

		//plot24HoursOfVariable(tUF3DDataFile, toFind, path, filename);



		//plot24HoursOfTempVariable(suewsDataFile, path, filename);
	}

	public void plotVariables(SUEWSDataFile sUEWSDataFile)
	{
//		String timeField = "dectime";
//		String variable = "kdown";
		generateReformattedDataFile(sUEWSDataFile);
		//plotData(sUEWSDataFile);

	}

	public void plotVariable(SUEWSDataFile sUEWSDataFile)
	{
		String timeField = "dectime";
		String variable = "kdown";
		generateDataFile(sUEWSDataFile, timeField, variable);
		plotData(sUEWSDataFile, timeField, variable);

	}


	public void generateReformattedDataFile(SUEWSDataFile sUEWSDataFile)
	{
		StringBuffer outputStr = new StringBuffer("# ");

		ArrayList<String> variables = sUEWSDataFile.getVariables();
		int count = 0;

		for (String variable : variables)
		{
			if (count ==0)
			{
				//skip this one
				count++;
				continue;
			}
			else if (count == 1)
			{
				outputStr.append(variables.get(0) + "-" + variable + " ");
				count++;
			}
			else
			{
				outputStr.append(variable + " ");
				count++;
			}

			if (count == variables.size())
			{
				String formattedDate = PrestonDataFile.FORMATTED_DATE;
				outputStr.append(formattedDate + " ");
			}



		}
		outputStr.append('\n');


		TreeMap<String, ArrayList<String>> theData = sUEWSDataFile.getData();
		ArrayList<String> timeArray = theData.get("id");
		//ArrayList<String> varibleArray = theData.get(variable);

		String dayOfYear = "";
		String time = "";
		for (int i = 0;i<timeArray.size();i++)
		{
			count = 0;
			for (String variable : variables)
			{
				if (count == 0)
				{
					String dayOfYearStr = theData.get(variable).get(i);
					dayOfYear = common.padLeft(dayOfYearStr, 3, '0');

					count++;
					//skip this one
					continue;
				}
				else if (count == 1)
				{
					outputStr.append(theData.get("id").get(i) + "-" + theData.get("it").get(i) + " ");
					count++;
				}
				else
				{
					outputStr.append(theData.get(variable).get(i) + " ");
					count++;
				}

//				if (variable.equals("id"))
//				{
//					String dayOfYearStr = theData.get(variable).get(i);
//					dayOfYear = common.padLeft(dayOfYearStr, 3, '0');
//				}
				if (variable.equals("it"))
				{
					// if 1, needs to be 0100, if 10, needs to be 1000
					String timeStr = theData.get(variable).get(i);
					time = common.padLeft(timeStr, 2, '0');
					time = common.padRight(time, 4, '0');
				}

				if (count == variables.size())
				{
					String formattedDate = sUEWSDataFile.getYear() + "-" + dayOfYear + "-" + time;
					outputStr.append(formattedDate + " ");
				}

			}
			outputStr.append('\n');
		}

		String dataFileName = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + ".gnuplot.dat";
		common.writeFile(outputStr.toString(), dataFileName);
	}

	public void generateReformattedGenericDataFile(SUEWSDataFile sUEWSDataFile, String dayField, String timeField)
	{


		StringBuffer outputStr = new StringBuffer("# ");

		ArrayList<String> variables = sUEWSDataFile.getVariables();
		int count = 0;

		for (String variable : variables)
		{
			if (count ==0)
			{
				//skip this one
				count++;
				continue;
			}
			else if (count == 1)
			{
				outputStr.append(variables.get(0) + "-" + variable + " ");
				count++;
			}
			else
			{
				outputStr.append(variable + " ");
				count++;
			}

			if (count == variables.size())
			{
				String formattedDate = PrestonDataFile.FORMATTED_DATE;
				outputStr.append(formattedDate + " ");
			}



		}
		outputStr.append('\n');


		TreeMap<String, ArrayList<String>> theData = sUEWSDataFile.getData();
		ArrayList<String> timeArray = theData.get(dayField);
		//ArrayList<String> varibleArray = theData.get(variable);

		String dayOfYear = "";
		String time = "";
		for (int i = 0;i<timeArray.size();i++)
		{
			count = 0;
			for (String variable : variables)
			{
				if (count == 0)
				{
					String dayOfYearStr = theData.get(variable).get(i);
					dayOfYear = common.padLeft(dayOfYearStr, 3, '0');

					count++;
					//skip this one
					continue;
				}
				else if (count == 1)
				{
					outputStr.append(theData.get(dayField).get(i) + "-" + theData.get(timeField).get(i) + " ");
					count++;
				}
				else
				{
					outputStr.append(theData.get(variable).get(i) + " ");
					count++;
				}

//				if (variable.equals("id"))
//				{
//					String dayOfYearStr = theData.get(variable).get(i);
//					dayOfYear = common.padLeft(dayOfYearStr, 3, '0');
//				}
				if (variable.equals(timeField))
				{
					// if 1, needs to be 0100, if 10, needs to be 1000
					String timeStr = theData.get(variable).get(i);
					time = common.padLeft(timeStr, 2, '0');
					time = common.padRight(time, 4, '0');
				}

				if (count == variables.size())
				{
					String formattedDate = sUEWSDataFile.getYear() + "-" + dayOfYear + "-" + time;
					outputStr.append(formattedDate + " ");
				}

			}
			outputStr.append('\n');
		}

		String dataFileName = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + ".gnuplot.dat";
		common.writeFile(outputStr.toString(), dataFileName);
	}

	public void generateDataFile(SUEWSDataFile sUEWSDataFile, String timeField, String variable)
	{
		StringBuffer outputStr = new StringBuffer();
		outputStr.append(timeField + " " + variable + '\n');

		TreeMap<String, ArrayList<String>> theData = sUEWSDataFile.getData();
		ArrayList<String> timeArray = theData.get(timeField);
		ArrayList<String> varibleArray = theData.get(variable);

		for (int i = 0;i<timeArray.size();i++)
		{
			outputStr.append(timeArray.get(i) + " " + varibleArray.get(i) + '\n');
		}


		String dataFileName = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + ".gnuplot.dat";
		common.writeFile(outputStr.toString(), dataFileName);

		//String outputFile = outputDirectory + File.separator + filename;


	}

	public void plotData(SUEWSDataFile sUEWSDataFile, String timeField, String variable)
	{
		String dataFileName = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + ".gnuplot.dat";
		String outputFile = sUEWSDataFile.getPath() + "_" + sUEWSDataFile.getFilename() + "_" + variable + ".png";

		Plot.setGnuplotExecutable("gnuplot");
		Plot.setPlotDirectory(sUEWSDataFile.getPath());
		Plot aPlot = new Plot();

		aPlot.setTitle("Plot for " + variable);
		aPlot.setGrid();
		aPlot.setKey("right box");
		aPlot.unsetParametric();
		aPlot.unsetPolar();
		aPlot.setOutput(Terminal.PNG, outputFile, " 1024,600  enhanced font Vera 14 ");
		aPlot.unsetLogscale();
		aPlot.setYTics("nomirror");
//		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 pi 20"); //$NON-NLS-1$

		aPlot.addExtra("set tmargin 1");
		aPlot.addExtra("set bmargin 2");
		aPlot.addExtra("set lmargin 6");
		aPlot.addExtra("set rmargin 1");

		aPlot.addExtra("set dgrid3d 10,10,1");
		aPlot.addExtra("set ylabel \" " + variable + "\"");
		String xLabel = "Time";
		aPlot.addExtra("set xlabel \" " + xLabel + "\"");

		aPlot.setDataFileName(dataFileName);
		aPlot.pushGraph(new Graph(dataFileName, "1:2", Axes.X1Y1, variable, Style.LINES, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));


		try
		{
			aPlot.plot();
			String[] commands = new String[]{Messages.getString("ProcessSUEWSRun.GNUPLOT_SH"),  sUEWSDataFile.getPath() };
			Process aProcess = Runtime.getRuntime().exec(commands);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

//	public void plot24HoursOfVariable(SUEWSDataFile tUF3DDataFile, String toFind, String path, String filename, String fileVariables
//			, String variablePrefix, String timeOfDayVariable)
//	{
//		TreeMap<String, ArrayList<String>> theData = tUF3DDataFile.getData();
//
//		//String timeOfDayVariable = "time_of_day";
//		ArrayList<String> dataItem = theData.get(toFind);
//		ArrayList<String> dataForTime = theData.get(timeOfDayVariable);
//
//		String dataFileName = path + File.separator + filename + ".gnuplotdat";
//
//		generateDataFileFromPoints(dataForTime, dataItem, path, filename, 24, "Time", toFind, dataFileName);
//		String outputFile = dataFileName + ".png";
//		plotData(dataFileName, outputFile, toFind, path);
//
//	}

//	ArrayList<String> getVariablesToPlot(String fileVariables)
//	{
//		ArrayList<String> variablesToPlot = new ArrayList<String>();
//		StringTokenizer st = new StringTokenizer(fileVariables, VARIABLE_SEPARATOR);
//		while (st.hasMoreTokens())
//		{
//			variablesToPlot.add(st.nextToken());
//		}
//		return variablesToPlot;
//	}

//	public void plot24HoursOfTempVariable(SUEWSDataFile tUF3DDataFile, String path, String filename, String fileVariables
//			, String variablePrefix, String timeOfDayVariable)
//	{
//		TreeMap<String, ArrayList<String>> theData = tUF3DDataFile.getData();
//
//		//String timeOfDayVariable = "time_of_day";
//		//ArrayList<String> dataItem = theData.get(toFind);
//		ArrayList<String> dataForTime = theData.get(timeOfDayVariable);
//
//		String dataFileName = path + File.separator + filename + "_" + variablePrefix + ".gnuplotdat";
//
//		ArrayList<String> variablesToPlot = getVariablesToPlot(fileVariables);
//
//		generateDataFileFromManyPoints(dataForTime, theData, variablesToPlot, path, filename, NUMBER_OF_HOURS, Messages.getString("ProcessSUEWSRun.TIME"),
//				dataFileName);
//
//		String outputFile = dataFileName + ".png";
//		plotDatas(dataFileName, outputFile, "Temp", path, theData, variablesToPlot);
//
//	}

	public void plotDatas(String dataFileName, String outputFile, String yLabel, String outputDirectory,
						TreeMap<String, ArrayList<String>> theData, ArrayList<String> variablesToPlot)
	{
		Plot.setGnuplotExecutable("gnuplot");
		Plot.setPlotDirectory(outputDirectory);
		Plot aPlot = new Plot();

		aPlot.setTitle("Plot for " + yLabel);
		aPlot.setGrid();
		aPlot.setKey("right box");
		aPlot.unsetParametric();
		aPlot.unsetPolar();
		aPlot.setOutput(Terminal.PNG, outputFile, " 1024,600  enhanced font Vera 14 ");
		aPlot.unsetLogscale();
		aPlot.setYTics("nomirror");
//		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 pi 20"); //$NON-NLS-1$

		aPlot.addExtra("set tmargin 1");
		aPlot.addExtra("set bmargin 2");
		aPlot.addExtra("set lmargin 6");
		aPlot.addExtra("set rmargin 1");

		aPlot.addExtra("set dgrid3d 10,10,1");
		aPlot.addExtra("set ylabel \" " + yLabel + "\"");
		String xLabel = "Time";
		aPlot.addExtra("set xlabel \" " + xLabel + "\"");

		aPlot.setDataFileName(dataFileName);

		int count = 2;
		for (String variable : variablesToPlot)
		{
			aPlot.pushGraph(new Graph(dataFileName, "1:" + count, Axes.X1Y1, variable, Style.LINES, LineType.NOT_SPECIFIED,
							PointType.NOT_SPECIFIED));
			count ++;
		}





		try
		{
			aPlot.plot();
			String[] commands = new String[]{Messages.getString("ProcessSUEWSRun.GNUPLOT_SH"),  outputDirectory };
			Process aProcess = Runtime.getRuntime().exec(commands);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void plotData(String dataFileName, String outputFile, String yLabel, String outputDirectory)
	{
		Plot.setGnuplotExecutable("gnuplot");
		Plot.setPlotDirectory(outputDirectory);
		Plot aPlot = new Plot();

		aPlot.setTitle("Plot for " + yLabel);
		aPlot.setGrid();
		aPlot.setKey("right box");
		aPlot.unsetParametric();
		aPlot.unsetPolar();
		aPlot.setOutput(Terminal.PNG, outputFile, " 1024,600  enhanced font Vera 14 ");
		aPlot.unsetLogscale();
		aPlot.setYTics("nomirror");
//		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 pi 20"); //$NON-NLS-1$
//		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 pi 20"); //$NON-NLS-1$

		aPlot.addExtra("set tmargin 1");
		aPlot.addExtra("set bmargin 2");
		aPlot.addExtra("set lmargin 6");
		aPlot.addExtra("set rmargin 1");

		aPlot.addExtra("set dgrid3d 10,10,1");
		aPlot.addExtra("set ylabel \" " + yLabel + "\"");
		String xLabel = "Time";
		aPlot.addExtra("set xlabel \" " + xLabel + "\"");

		aPlot.setDataFileName(dataFileName);
		aPlot.pushGraph(new Graph(dataFileName, "1:2", Axes.X1Y1, yLabel, Style.LINES, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));


		try
		{
			aPlot.plot();
			String[] commands = new String[]{Messages.getString("ProcessSUEWSRun.GNUPLOT_SH"),  outputDirectory };
			Process aProcess = Runtime.getRuntime().exec(commands);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public void plotAllAspects(SUEWSDataFile tUF3DDataFile)
	{

	}

	public void generateDataFileFromManyPoints(
			ArrayList<String> x, TreeMap<String, ArrayList<String>> theData, ArrayList<String> variablesToPlot,
			String outputDirectory, String filename, int numberOfHours, String xLabel, String dataFileName)
	{
		StringBuffer outputStr = new StringBuffer();
		outputStr.append(xLabel + " " );

		for (String variable : variablesToPlot)
		{
			outputStr.append(variable+ " ");
		}
		outputStr.append('\n');

		for (int i = 0;i<numberOfHours;i++)
		{
			String dataValue = x.get(i);
			outputStr.append(dataValue + " ");
			for (String variable : variablesToPlot)
			{
				ArrayList<String> oneData = theData.get(variable);
				outputStr.append(oneData.get(i)+ " ");
			}
			outputStr.append('\n');
		}
		common.writeFile(outputStr.toString(), dataFileName);

		//String outputFile = outputDirectory + File.separator + filename;


	}

	public void generateDataFileFromPoints(
			ArrayList<String> x, ArrayList<String> y, String outputDirectory, String filename, int numberOfHours,
			String xLabel, String yLabel, String dataFileName)
	{
		StringBuffer outputStr = new StringBuffer();

		outputStr.append(xLabel + " " + yLabel + '\n');

		for (int i = 0;i<numberOfHours;i++)
		{
			outputStr.append(x.get(i) + " " + y.get(i) + '\n');
		}


		common.writeFile(outputStr.toString(), dataFileName);

		//String outputFile = outputDirectory + File.separator + filename;


	}

}
