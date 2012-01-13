package au.edu.monash.ges.suews;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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

public class PrestonDailyAverages
{	
	public static int ROUND_DIGITS = 2;
	ENVICommon common = new ENVICommon();
	private int year;
	private ArrayList<String> variables = new ArrayList<String>();
	private TreeMap<String, TreeMap<String, ArrayList<String>>> dataFromFile = new TreeMap<String, TreeMap<String, ArrayList<String>>>(); 
	private TreeMap<String, TreeMap<String, String>> calculatedAverages = new TreeMap<String, TreeMap<String, String>>();
	private TreeMap<String, TreeMap<String, String>> calculatedMonthlyAverages = new TreeMap<String, TreeMap<String, String>>();

	//key of variable_2008_12_1400 year_month_hour, contains ArrayList of data for that hour for the month
	private TreeMap<String, ArrayList<String>> dailyAverageData = new TreeMap<String, ArrayList<String>>();
	
	private PrestonDailyAverages(String path, String filename)
	{
		try
		{
			FileInputStream fstream = new FileInputStream(path + filename);			
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			String variableStr = br.readLine();
			String[] variableStrSplit = variableStr.split(" ");
			for (String aVariable : variableStrSplit)
			{
				//this.variables.add(aVariable.trim().replaceAll(" ", "_").replaceAll("\"", ""));
				
				if (aVariable.trim().equals("#"))
				{
					continue;
				}
				this.variables.add(aVariable.trim());
			}
						
			
			
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   
			{				
				String[] dataStrSplit = strLine.split(" ");
				
				if (dataStrSplit[0].equals("2003"))
				{
					continue;
				}
				String day = dataStrSplit[1];
				TreeMap<String, ArrayList<String>> dayData = dataFromFile.get(day);
				if (dayData == null)
				{
					dayData = new TreeMap<String, ArrayList<String>>();
				}
				int count = 0;
				for (String variable : this.variables)
				{
					ArrayList<String> item = dayData.get(variable);
					if (item == null)
					{
						item = new ArrayList<String>();
					}
					item.add(dataStrSplit[count]);
					dayData.put(variable, item);
					count ++;
				}
				dataFromFile.put(day, dayData);
				// Print the content on the console
			    //System.out.println (strLine);
			}
			//Close the input stream
			in.close();
		}
		catch (Exception e)
		{//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		calculateDailyAverages();
		calculateMonthlyAverages();

	}
	
//	private PrestonMonthlyAverages(String path, String filename)
//	{
//		try
//		{
//			FileInputStream fstream = new FileInputStream(path + filename);			
//			DataInputStream in = new DataInputStream(fstream);
//			BufferedReader br = new BufferedReader(new InputStreamReader(in));
//			String strLine;
//			
//			String variableStr = br.readLine();
//			String[] variableStrSplit = variableStr.split(" ");
//			for (String aVariable : variableStrSplit)
//			{
//				//this.variables.add(aVariable.trim().replaceAll(" ", "_").replaceAll("\"", ""));
//				
//				if (aVariable.trim().equals("#"))
//				{
//					continue;
//				}
//				this.variables.add(aVariable.trim());
//			}
//						
//			
//			
//			//Read File Line By Line
//			while ((strLine = br.readLine()) != null)   
//			{				
//				String[] dataStrSplit = strLine.split(" ");
//				
//				if (dataStrSplit[0].equals("2003"))
//				{
//					continue;
//				}
//				String day = dataStrSplit[1];
//				String month = common.getMonthStrFromDayOfYear(year, day);
//				TreeMap<String, ArrayList<String>> dayData = dataFromFile.get(day);
//				if (dayData == null)
//				{
//					dayData = new TreeMap<String, ArrayList<String>>();
//				}
//				int count = 0;
//				for (String variable : this.variables)
//				{
//					ArrayList<String> item = dayData.get(variable);
//					if (item == null)
//					{
//						item = new ArrayList<String>();
//					}
//					item.add(dataStrSplit[count]);
//					dayData.put(variable, item);
//					count ++;
//				}
//				dataFromFile.put(day, dayData);
//				// Print the content on the console
//			    //System.out.println (strLine);
//			}
//			//Close the input stream
//			in.close();
//		}
//		catch (Exception e)
//		{//Catch exception if any
//			System.err.println("Error: " + e.getMessage());
//		}
//		
//		calculateDailyAverages();
//
//	}	
	
	private void calculateDailyAverages()
	{	
		for (int i=1;i<366;i++)
		{
			String day = new Integer(i).toString();
			TreeMap<String, ArrayList<String>> dayData = dataFromFile.get(day);
			if (dayData == null)
			{
				dayData = new TreeMap<String, ArrayList<String>>();
			}
			
			//get data for each day
			for (String variable : this.variables)
			{
				ArrayList<String> item = dayData.get(variable);
				if (item == null)
				{
					item = new ArrayList<String>();
				}
			
				String average = common.averageListOfStrings(item);
				
				TreeMap<String, String> calculatedDayData =calculatedAverages.get(day);
				if (calculatedDayData == null)
				{
					calculatedDayData = new TreeMap<String, String>();
				}
				calculatedDayData.put(variable, average);
				calculatedAverages.put(day, calculatedDayData);
			}
			
		}
	}
	
	private void calculateMonthlyAverages()
	{
		TreeMap<String, TreeMap<String, ArrayList<String>>> tempDataFromDailys = new TreeMap<String, TreeMap<String, ArrayList<String>>>();
		
		for (int i=1;i<366;i++)
		{
			String day = new Integer(i).toString();
			TreeMap<String, ArrayList<String>> dayData = dataFromFile.get(day);
			if (dayData == null)
			{
				dayData = new TreeMap<String, ArrayList<String>>();
			}
			
			String month = common.getMonthStrFromDayOfYear(year, day);
			//get data for each day
			for (String variable : this.variables)
			{
				ArrayList<String> item = dayData.get(variable);
				if (item == null)
				{
					item = new ArrayList<String>();
				}
				
				//append them to the data for the rest of the month and store them again
				TreeMap<String, ArrayList<String>> monthData = tempDataFromDailys.get(month);
				if (monthData == null)
				{
					monthData = new TreeMap<String, ArrayList<String>>();
				}
				
				ArrayList<String> monthItem = monthData.get(variable);
				if (monthItem == null)
				{
					monthItem = new ArrayList<String>();
				}
				monthItem.addAll(item);
				monthData.put(variable, monthItem);
				tempDataFromDailys.put(month, monthData);
				
//				
//				String average = common.averageListOfStrings(item);				
//				TreeMap<String, String> calculatedMonthData =calculatedMonthlyAverages.get(day);
//				if (calculatedMonthData == null)
//				{
//					calculatedMonthData = new TreeMap<String, String>();
//				}
//				calculatedMonthData.put(variable, average);
//				calculatedMonthlyAverages.put(day, calculatedMonthData);
			}			
		}
		
		for (int i=1;i<13;i++)
		{
			String month = new Integer(i).toString();
			TreeMap<String, ArrayList<String>> monthData = dataFromFile.get(month);
			if (monthData == null)
			{
				monthData = new TreeMap<String, ArrayList<String>>();
			}
			
			//get data for each month
			for (String variable : this.variables)
			{
				ArrayList<String> item = monthData.get(variable);
				if (item == null)
				{
					item = new ArrayList<String>();
				}
				
				String average = common.averageListOfStrings(item);				
				TreeMap<String, String> calculatedMonthData =calculatedMonthlyAverages.get(month);
				if (calculatedMonthData == null)
				{
					calculatedMonthData = new TreeMap<String, String>();
				}
				calculatedMonthData.put(variable, average);
				calculatedMonthlyAverages.put(month, calculatedMonthData);
			}			
		}		
				
	}	

//	public PrestonDailyAverages(PrestonDataFile prestonDataFile)
//	{
//
//		setVariables(prestonDataFile.getVariables());
//		TreeMap<String, ArrayList<String>> prestonData = prestonDataFile.getData();
//		year = 2004;
//
//		String key="";
//
//		String keyTimecode = "";
//		boolean foundTimecode = false;
//
//		int numberOfData = 0;
//
//		for (String variable : variables)
//		{
//			System.out.println(variable);
//			ArrayList<String> variableData = prestonData.get(variable);
//			numberOfData = variableData.size();
//
//			break;
//		}
//		
//		for (int i=0;i<numberOfData;i++)
//		{
//			for (String variable : variables)
//			{
//				ArrayList<String> variableData = prestonData.get(variable);
//				System.out.println("variableData=" + variableData.size() + " for variable " + variable);
//				
//				if (variable.equals(PrestonDataFile.PRESTON_STR_timecode))
//				{
//					keyTimecode = variableData.get(i);
//					foundTimecode = true;
//				}
//		
//				else
//				{
//					if (foundTimecode)
//					{							
//						key =  variable + "_" 
//							+ common.getYearFromTimecode(keyTimecode) + "_" 
//							+ common.getMonthFromTimecode(keyTimecode) + "_" 
//							+ common.getHourFromTimecode(keyTimecode);
//						String variableItem = "?";
//						try
//						{
//							variableItem = variableData.get(i);
//						}
//						catch (IndexOutOfBoundsException e)
//						{
//						}
//						ArrayList<String> tempDataItem = getDataForVariableAndTime(key);
//						if (tempDataItem == null)
//						{
//							tempDataItem = new ArrayList<String>();
//							System.out.println("Create new item for " + key);
//						}
//						tempDataItem.add(variableItem);
//						setDataForVariableAndTime(key, tempDataItem);
//						System.out.println("Adding item for " + key + " value=" + tempDataItem);
//					}
//				}
//			}
//			foundTimecode = false;
//		}
//	}

//	public void outputDataFile(String path, String filename)
//	{
//		StringBuffer outputStr = new StringBuffer("# ");
//
//		ArrayList<String> theVariables = getVariables();
//		int count = 0;
//		for (String variable : theVariables)
//		{
//			if (count == 0)
//			{
//				outputStr.append("Time" + " ");
//			}
//			if (count == 0 || count == 1)
//			{
//				count++;
//				continue;
//			}
//			outputStr.append(variable + " ");
//			count++;
//		}
//		outputStr.append('\n');
//
//		//year will be year
//		//iterate through 0-23 hours and 1-12 months and pull out each data file
//
//		for (int month=1;month<13;month++)
//		{
//			for (int hour=0;hour<24;hour++)
//			{
//				// 2004/1/1 or /year/month/hour
//				String date = year + "/" + month + "/" + month;
//				String testKey = variables.get(4) + "_" + year + "_" + month + "_" + hour;
//				//System.out.println("Look for " + testKey);
//
//				if (!getKeySetForData().contains(testKey))
//				{
//					//System.out.println("Didn't find " + testKey);
//					continue;
//				}
//				//System.out.println("Found " + testKey);
//
//				//outputStr.append(date + " ");
//				int counter = 0;
//				for (String variable : theVariables)
//				{				
//					if (counter == 0)
//					{
//						String monthStr = common.padLeft(new Integer(month).toString(), 2, '0');
//						String hourStr = common.padLeft(new Integer(hour).toString(), 2, '0');
//						//String dateStr = year + "-" + monthStr + "-15" + "-" + hourStr ;
//						String dateStr = year + "-" + monthStr + "-" + hourStr ;
//						outputStr.append(dateStr + " ");
//					}
//					if (counter == 0 || counter == 1)
//					{
//						counter++;
//						continue;
//					}
//
//					String key = variable + "_" + year + "_" + month + "_" + hour;
//					double average = getAverageForVariableAndTime(key);					
//					outputStr.append(common.roundToDecimals(average, ROUND_DIGITS) + " ");
//
//					counter++;
//				}
//				outputStr.append('\n');
//			}
//		}
//		String dataFileName = path + filename;
//		common.writeFile(outputStr.toString(), dataFileName);
//	}
	
//	public void outputDataFiles(String path, String filename)
//	{
//		StringBuffer outputStr = new StringBuffer("# ");
//
//		ArrayList<String> theVariables = getVariables();
//		//System.out.println (variables.toString());
//		int count = 0;
//		for (String variable : theVariables)
//		{
//			if (count == 0)
//			{
//				outputStr.append("Time" + " ");
//			}
//			if (count == 0 || count == 1)
//			{
//				count++;
//				continue;
//			}
//			outputStr.append(variable + " ");
//			count++;
//		}
//		outputStr.append('\n');
//
//		//year will be year
//		//iterate through 0-23 hours and 1-12 months and pull out each data file
//
//		for (int month=1;month<13;month++)
//		{
//			for (int hour=0;hour<24;hour++)
//			{
//				// 2004/1/1 or /year/month/hour
//				//String date = year + "/" + month + "/" + month;
//				String testKey = variables.get(4) + "_" + year + "_" + month + "_" + hour;
//				//System.out.println("Look for " + testKey);
//
//				if (!getKeySetForData().contains(testKey))
//				{
//					//System.out.println("Didn't find " + testKey);
//					continue;
//				}
//				//System.out.println("Found " + testKey);
//
//				//outputStr.append(date + " ");
//				int counter = 0;
//				for (String variable : theVariables)
//				{				
//					if (counter == 0)
//					{
//						String monthStr = common.padLeft(new Integer(month).toString(), 2, '0');
//						String hourStr = common.padLeft(new Integer(hour).toString(), 2, '0');
//						//String dateStr = year + "-" + monthStr + "-15" + "-" + hourStr ;
//						String dateStr = year + "-" + monthStr + "-" + hourStr ;
//						outputStr.append(dateStr + " ");
//					}
//					if (counter == 0 || counter == 1)
//					{
//						counter++;
//						continue;
//					}
//
//					String key = variable + "_" + year + "_" + month + "_" + hour;
//					double average = getAverageForVariableAndTime(key);					
//					outputStr.append(common.roundToDecimals(average, ROUND_DIGITS) + " ");
//
//					counter++;
//				}
//				outputStr.append('\n');
//			}
//		}
//
//		String dataFileName = path + filename;
//		common.writeFile(outputStr.toString(), dataFileName);
//	}	

//	public ArrayList<String> getKeySetForData()
//	{
//		ArrayList<String> keysInDataSet = new ArrayList<String>();
//		Set<String> keys = dailyAverageData.keySet();
//		for (String key : keys)
//		{
//			keysInDataSet.add(key);
//		}
//		return keysInDataSet;
//	}

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
		dailyAverageData.put(key, arrayData);
	}

	public ArrayList<String> getDataForVariableAndTime(String key)
	{
		return dailyAverageData.get(key);
	}

	public double getAverageForVariableAndTime(String key)
	{
		double total = 0;
		double average = 0;

		ArrayList<String> averageData = dailyAverageData.get(key);
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
		return dailyAverageData;
	}

	private void setData(TreeMap<String, ArrayList<String>> data)
	{
		this.dailyAverageData = data;
	}
	
	public void outputDailyFile(String path, String file)
	{
		StringBuffer st = new StringBuffer();
		
		for (String variable : variables)
		{
			if (variable.equals("Year"))
			{
				continue;
			}
			st.append(variable + " ");
		}
		st.append('\n');
		
		for (int i=1;i<366;i++)
		{
			String day = new Integer(i).toString();
			TreeMap<String, String> dayValues = calculatedAverages.get(day);
			if (dayValues == null)
			{ 
				continue;
			}
			for (String variable : variables)
			{
				if (variable.equals("Year"))
				{
					continue;
				}
				
				String averageValue = dayValues.get(variable);
				if (variable.equals("Day_of_year"))
				{
					averageValue = day;
				}
				
				st.append(averageValue + " ");
			}
			st.append('\n');
		}
		
		
		common.writeFile(st.toString(), path + file);
	}
	
	public void outputMonthlyFile(String path, String file)
	{
		StringBuffer st = new StringBuffer();
		
		for (String variable : variables)
		{
			if (variable.equals("Year"))
			{
				continue;
			}
			st.append(variable + " ");
		}
		st.append('\n');
		
		for (int i=1;i<13;i++)
		{
			String month = new Integer(i).toString();
			TreeMap<String, String> dayValues = calculatedMonthlyAverages.get(month);
			if (dayValues == null)
			{ 
				continue;
			}
			for (String variable : variables)
			{
				if (variable.equals("Year"))
				{
					continue;
				}
				
				String averageValue = dayValues.get(variable);
				if (variable.equals("Day_of_year"))
				{
					averageValue = month;
				}
				
				st.append(averageValue + " ");
			}
			st.append('\n');
		}
		
		
		common.writeFile(st.toString(), path + file);
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ENVICommon common = new ENVICommon();		
		String basePath = common.getHostnameWorkDirPath();	
		String path = basePath + Messages.getString("ProcessLumps.PrestonCalculatedPath");		
		String filename = Messages.getString("ProcessLumps.PrestonCalculated");
		String outputFile = "Preston2004DailyAverages.dat";
		String outputMonthlyFile = "Preston2004MonthlyAverages.dat";
//		PrestonDataFile prestonDataFile = new PrestonDataFile(path, filename, false);
		
		PrestonDailyAverages averages = new PrestonDailyAverages(path, filename);
		//averages.calculateDailyAverages();
		//System.out.println(averages.calculatedAverages.toString());
		
		//averages.outputDailyFile(path, outputFile);
		averages.outputMonthlyFile(path, outputMonthlyFile);

		
		
		
//		ArrayList<String> keysForAverages = averages.getKeySetForData();
//		for (String key : keysForAverages)
//		{
//			System.out.println(key);
//		}
		
		//TreeMap<String, ArrayList<String>> data = averages.getData();
		//Set<String> dataKeySet = data.keySet();
//		Set<String> dataKeySet = averages.dailyAverageData.keySet();
//		for (String key : dataKeySet)
//		{
//			System.out.println(key + " ");
//		}
				
//		TreeMap<String, ArrayList<String>> theData = prestonDataFile.getData();
//
//		Set<String> keys = theData.keySet();
//		for (String key : keys)
//		{
//			System.out.println(key);
//		}
		
//		averages.outputDataFile(Messages.getString("SuewsPrestonComparisonGraphs.graph_dir"),
//										Messages.getString("SuewsPrestonComparisonGraphs.PrestonMonthlyAve"));
		
		

	}

}
