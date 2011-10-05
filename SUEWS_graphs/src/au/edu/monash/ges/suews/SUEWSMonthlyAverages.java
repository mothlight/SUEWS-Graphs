package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import org.jgnuplot.Axes;
import org.jgnuplot.Graph;
import org.jgnuplot.LineType;
import org.jgnuplot.Plot;
import org.jgnuplot.PointType;
import org.jgnuplot.Style;
import org.jgnuplot.Terminal;

public class SUEWSMonthlyAverages
{

	public String XRANGE_BEG = "2004-01-15";
	public String XRANGE_END = "2004-01-16";
	//public static String GRAPH_SIZE = "1024,600";
	public static String GRAPH_SIZE = "1536,900";

	ENVICommon common = new ENVICommon();
	private int year;
	private ArrayList<String> variables = new ArrayList<String>();

	//key of variable_2008_12_1400 year_month_hour, contains ArrayList of data for that hour for the month
	private TreeMap<String, ArrayList<String>> monthlyAverageData = new TreeMap<String, ArrayList<String>>();

	public SUEWSMonthlyAverages(SUEWSDataFile suewsDataFile)
	{

		setVariables(suewsDataFile.getVariables());
		TreeMap<String, ArrayList<String>> suewsData = suewsDataFile.getData();
		year = new Integer(common.padLeft(suewsDataFile.getYear(), 3, '0')).intValue();

		String key="";
		String keyTime="";
		String keyMonth="";
		String keyDay="";
		String keyYear="";
		String keyVariable="";
		boolean foundDay = false;
		boolean foundTime = false;

		int numberOfData = 0;

		for (String variable : variables)
		{
			ArrayList<String> variableData = suewsData.get(variable);
			numberOfData = variableData.size();
			break;
//			if (variable.equals(SUEWSDataFile.SUEWS_id))
//			{
//				keyDay = variable;
//				foundDay = true;
//			}
//			else if (variable.equals(SUEWSDataFile.SUEWS_it))
//			{
//				keyTime = variable;
//			}

		}


		for (int i=0;i<numberOfData;i++)
		{

			for (String variable : variables)
			{
				ArrayList<String> variableData = suewsData.get(variable);
				if (variable.equals(SUEWSDataFile.SUEWS_id))
				{
					keyDay = variableData.get(i);
					foundDay = true;
				}
				else if (variable.equals(SUEWSDataFile.SUEWS_it))
				{
					keyTime = variableData.get(i);

//					// if 1, needs to be 0100, if 10, needs to be 1000
//					keyTime = common.padLeft(keyTime, 2, '0');
//					keyTime = common.padRight(keyTime, 4, '0');

					foundTime = true;
					// variable_2008_12_1400 year_month_hour
					int dayOfYear = new Integer(keyDay).intValue();
					int dayOfMonth = common.getDayOfMonthFromDayOfYear(year, dayOfYear);
					int month = common.getMonthFromDayOfYear(year, dayOfYear);
					keyMonth = new Integer(month).toString();
					//key = variable + year + month + keyTime;
				}
				else
				{
					key = variable + "_" + year + "_" + keyMonth + "_" + keyTime;
					String variableItem = variableData.get(i);
					ArrayList<String> tempDataItem = getDataForVariableAndTime(key);
					if (tempDataItem == null)
					{
						tempDataItem = new ArrayList<String>();
					}
					tempDataItem.add(variableItem);
					setDataForVariableAndTime(key, tempDataItem);
				}

			}
			foundDay = false;
			foundTime = false;

		}

	}

	public void outputDataFile(String path, String filename)
	{
		StringBuffer outputStr = new StringBuffer("# ");

		ArrayList<String> theVariables = getVariables();
		//System.out.println (variables.toString());
		int count = 0;
		for (String variable : theVariables)
		{
			if (count == 0)
			{
				outputStr.append("Time" + " ");
			}
			if (count == 0 || count == 1)
			{
				count++;
				continue;
			}
			outputStr.append(variable + " ");
			count++;
		}
		outputStr.append('\n');

		//year will be year
		//iterate through 0-23 hours and 1-12 months and pull out each data file

		for (int month=1;month<13;month++)
		{
			for (int hour=0;hour<24;hour++)
			{
				// 2004/1/1 or /year/month/hour
				String date = year + "/" + month + "/" + month;
				String testKey = variables.get(4) + "_" + year + "_" + month + "_" + hour;
				//System.out.println("Look for " + testKey);

				if (!getKeySetForData().contains(testKey))
				{
					//System.out.println("Didn't find " + testKey);
					continue;
				}
				//System.out.println("Found " + testKey);

				//outputStr.append(date + " ");
				int counter = 0;
				for (String variable : theVariables)
				{
					if (counter == 0)
					{
						String monthStr = common.padLeft(new Integer(month).toString(), 2, '0');
						String hourStr = common.padLeft(new Integer(hour).toString(), 2, '0');
						String dateStr = year + "-" + monthStr + "-15" + "-" + hourStr ;
						outputStr.append(dateStr + " ");
					}
					if (counter == 0 || counter == 1)
					{
						counter++;
						continue;
					}

					String key = variable + "_" + year + "_" + month + "_" + hour;
					double average = getAverageForVariableAndTime(key);
					outputStr.append(average + " ");

					counter++;
				}
				outputStr.append('\n');
			}
		}

//		TreeMap<String, ArrayList<String>> theData = prestonDataFile.getData();
//		ArrayList<String> timeArray = theData.get("tau");
//		for (int i = 0;i<timeArray.size()-1;i++)
//		{
//			count = 0;
//			for (String variable : variables)
//			{
//				ArrayList<String> dataArray = theData.get(variable);
//				if (dataArray == null)
//				{
//					//System.out.println("theData.get(variable)="+ variable);
//					String variableValue = "?";
//					outputStr.append(variableValue + " ");
//				}
//				else
//				{
//					//System.out.println(dataArray.toString());
//					//System.out.println(variable + "=" + variable);
//					String variableValue = dataArray.get(i);
//					//System.out.println(variable + "=" + variableValue);
//					outputStr.append(variableValue + " ");
//				}
//					count++;
//			}
//			outputStr.append('\n');
//		}

		String dataFileName = path + filename;
		common.writeFile(outputStr.toString(), dataFileName);
//		System.out.println(outputStr.toString());

	}

	public void plotData(String dataFilePath, String dataFileName, String timeField, String variable,
			ArrayList<String> plotFields, ArrayList<String> plotFieldLabel)
		{
			String dataFile = dataFilePath + dataFileName;
			String outputFile = dataFilePath + dataFileName + "_" + variable + ".png";

			Plot.setGnuplotExecutable("gnuplot");
			String plotDirectory = dataFilePath;
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

			aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 ");
			aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 ");
			aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 ");
			aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 ");
			aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 ");
			aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 ");
			aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 ");
			aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 ");
			aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 ");
			aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 ");
			aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 ");

			aPlot.addExtra("set tmargin 1");
			aPlot.addExtra("set bmargin 2");
			aPlot.addExtra("set lmargin 6");
			aPlot.addExtra("set rmargin 1");

			aPlot.addExtra("set xdata time");
			aPlot.addExtra("set timefmt '%Y-%m-%d-%H:%M'");
			aPlot.addExtra("set xrange [\"" + XRANGE_BEG + "\":\"" + XRANGE_END + "\"]");

			aPlot.addExtra("set dgrid3d 10,10,1");
			aPlot.addExtra("set ylabel \" fluxes\"");
			String xLabel = "Time";
			aPlot.addExtra("set xlabel \" Time\"");

			aPlot.setDataFileName(dataFile);
			for (int i=0;i<plotFields.size();i++)
			{
				aPlot.pushGraph(new Graph(dataFile, timeField + ":" + plotFields.get(i), Axes.X1Y1, plotFieldLabel.get(i) + "-SUEWS", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));
			}

			try
			{
//				OutputStream stdin = null;
//			    InputStream stderr = null;
//			    InputStream stdout = null;
//			    String line;
				String plotCommand = aPlot.plot();
				//plotCmd(plotCommand, plotDirectory);

			} catch (Exception e)
			{
				e.printStackTrace();
			}

	}


	public ArrayList<String> getKeySetForData()
	{
		ArrayList<String> keysInDataSet = new ArrayList<String>();
		Set<String> keys = monthlyAverageData.keySet();
		for (String key : keys)
		{
			keysInDataSet.add(key);
		}
		return keysInDataSet;


	}


	public ArrayList<String> getVariables()
	{
		return variables;
	}

	private void setVariables(ArrayList<String> variables)
	{
		this.variables = variables;
	}

	private void setDataForVariableAndTime(String key, ArrayList<String> arrayData)
	{
		monthlyAverageData.put(key, arrayData);
	}

	public ArrayList<String> getDataForVariableAndTime(String key)
	{
		return monthlyAverageData.get(key);
	}

	public double getAverageForVariableAndTime(String key)
	{
		double total = 0;
		double average = 0;

		ArrayList<String> averageData = monthlyAverageData.get(key);
		if (averageData == null)
		{
			return 0;
		}
		for (String data : averageData)
		{
			try
			{
				total = total + new Double(data).doubleValue();
			}
			catch (NumberFormatException e)
			{
				return 0;
			}
		}
		average = total / averageData.size();

		return average;
	}

	private TreeMap<String, ArrayList<String>> getData()
	{
		return monthlyAverageData;
	}

	private void setData(TreeMap<String, ArrayList<String>> data)
	{
		this.monthlyAverageData = data;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
