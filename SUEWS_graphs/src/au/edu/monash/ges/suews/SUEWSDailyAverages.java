package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class SUEWSDailyAverages
{
	ENVICommon common = new ENVICommon();
	private int year;
	private ArrayList<String> variables = new ArrayList<String>();

	//key of variable_2008_12_1400 year_month_hour, contains ArrayList of data for that hour for the month
	private TreeMap<String, ArrayList<String>> dailyAverageData = new TreeMap<String, ArrayList<String>>();
	private TreeMap<String, TreeMap<String, ArrayList<String>>> dataStoredByDay = new TreeMap<String, TreeMap<String, ArrayList<String>>>();
	private TreeMap<String, TreeMap<String, String>> calculatedAverages = new TreeMap<String, TreeMap<String, String>>();
	private TreeMap<String, TreeMap<String, String>> calculatedMonthlyAverages = new TreeMap<String, TreeMap<String, String>>();

	public SUEWSDailyAverages(SUEWSDataFile suewsDataFile)
	{		
		setVariables(suewsDataFile.getVariables());
		TreeMap<String, ArrayList<String>> suewsData = suewsDataFile.getData();
		year = new Integer(common.padLeft(suewsDataFile.getYear(), 3, '0')).intValue();

		String key="";
		String keyTime="";
		String keyMonth="";
		String keyDay="";
		Integer dayOfYear=0;
		boolean foundDay = false;
		boolean foundTime = false;

		int numberOfData = 0;

		for (String variable : variables)
		{
			System.out.println(variable);
			ArrayList<String> variableData = suewsData.get(variable);
			numberOfData = variableData.size();

			break;
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
					foundTime = true;
					dayOfYear = new Integer(keyDay).intValue();
					int month = common.getMonthFromDayOfYear(year, dayOfYear);
					keyMonth = new Integer(month).toString();
				}
				else
				{
//					key = variable + "_" + year + "_" + keyMonth + "_" + keyTime;
//					String variableItem = "?";
//					try
//					{
//						variableItem = variableData.get(i);
//					}
//					catch (IndexOutOfBoundsException e)
//					{
//						//System.out.println("Exception with " + i + " " + variable);
//					}
//					ArrayList<String> tempDataItem = getDataForVariableAndTime(key);
//					if (tempDataItem == null)
//					{
//						tempDataItem = new ArrayList<String>();
//					}
//					tempDataItem.add(variableItem);
//					//System.out.println("Setting key=" + key);
//					setDataForVariableAndTime(key, tempDataItem);
					
					
					String day = dayOfYear.toString();
					String variableItem = variableData.get(i);
					TreeMap<String, ArrayList<String>> dailyData = dataStoredByDay.get(day);
					if (dailyData == null)
					{
						dailyData = new TreeMap<String, ArrayList<String>>();
					}
					ArrayList<String> item = dailyData.get(variable);
					if (item == null)
					{
						item = new ArrayList<String>();
					}
					item.add(variableItem);
					dailyData.put(variable, item);
					dataStoredByDay.put(day, dailyData);
					
				}
			}
			foundDay = false;
			foundTime = false;
		}
		calculateDailyAverages();
		calculateMonthlyAverages();
	}
	
	private void calculateDailyAverages()
	{	
		for (int i=1;i<366;i++)
		{
			String day = new Integer(i).toString();
			TreeMap<String, ArrayList<String>> dayData = dataStoredByDay.get(day);
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
			TreeMap<String, ArrayList<String>> dayData = dataStoredByDay.get(day);
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
			TreeMap<String, ArrayList<String>> monthData = dataStoredByDay.get(month);
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
	
	public TreeMap<String, Double> getMonthlyAverageForDataItem(int month, int yearStr, String item)
	{
		TreeMap<String, Double> data = new TreeMap<String, Double>();
		for (int time=0;time<24;time++)
		{
			String key = item + "_" + yearStr + "_" + month + "_" + time;
			ArrayList<String> tempDataItem = getDataForVariableAndTime(key);
			if (tempDataItem == null)
			{
				return data;
			}
			
			int count = 0;
			double runningTotal = 0;
			for (String value : tempDataItem)
			{				
				count ++;
				Double valueDouble = new Double(value).doubleValue();
				runningTotal += valueDouble;					
			}
			double average = runningTotal / count;
			String timeStr = new Integer(time).toString();			
			data.put(common.padLeft(timeStr, 2, '0'), common.roundTwoDecimals(average));				
		}		
		return data;
	}

	public void outputDataFile(String path, String filename)
	{
		StringBuffer outputStr = new StringBuffer("");

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
				//String date = year + "/" + month + "/" + month;
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
		String dataFileName = path + filename;
		common.writeFile(outputStr.toString(), dataFileName);

	}

	public ArrayList<String> getKeySetForData()
	{
		ArrayList<String> keysInDataSet = new ArrayList<String>();
		Set<String> keys = dailyAverageData.keySet();
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
		dailyAverageData.put(key, arrayData);
	}

	public ArrayList<String> getDataForVariableAndTime(String key)
	{
		return dailyAverageData.get(key);
	}
	
//	public ArrayList<String> getKeysForMonthlyData()
//	{
//		ArrayList<String> keys = new ArrayList<String>();
//		
//		Set keySet = monthlyAverageData.keySet();
//		
//		Iterator keySetItr = keySet.iterator();
//		while (keySetItr.hasNext())
//		//for (String key : keySet)
//		{
//			String key = (String)keySetItr.next();
//			keys.add(key);
//		}
//		
//		return keys;
//	}

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

//	private TreeMap<String, ArrayList<String>> getData()
//	{
//		return monthlyAverageData;
//	}
//
//	private void setData(TreeMap<String, ArrayList<String>> data)
//	{
//		this.monthlyAverageData = data;
//	}
	
	public void outputDailyFile(String path, String file)
	{
		StringBuffer st = new StringBuffer();
		
		for (String variable : variables)
		{
			if (variable.equals("id"))
			{
				continue;
			}
			if (variable.equals("it"))
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
				if (variable.equals("id"))
				{
					continue;
				}
				if (variable.equals("it"))
				{
					continue;
				}
				
				String averageValue = dayValues.get(variable);
				if (variable.equals("dectime"))
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
			if (variable.equals("id"))
			{
				continue;
			}
			if (variable.equals("it"))
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
				if (variable.equals("id"))
				{
					continue;
				}
				if (variable.equals("it"))
				{
					continue;
				}
				
				String averageValue = dayValues.get(variable);
				if (variable.equals("dectime"))
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
		String runDirectory = "/tmp/SUEWS_Pr0001/";
		String year = "2004";
		String runPrefix = "Pr0001";
		String graphDirectory = runDirectory + "graphs/";
		
		String path = runDirectory + "Output";		
		String suewsDataFilePrefix = runPrefix + "_" + year;
		String filename = suewsDataFilePrefix + Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE2");
		
		SUEWSDataFile sUEWSDataFile = new SUEWSDataFile(path, filename, SuewsPrestonComparisonGraphs.SKIP_LINES_FALSE
				, SUEWSDataFile.LINES_TO_SKIP_60);
		
		SUEWSDailyAverages sUEWSDailyAverages = new SUEWSDailyAverages(sUEWSDataFile);
		sUEWSDailyAverages.outputDailyFile(graphDirectory,
				Messages.getString("SuewsPrestonComparisonGraphs.DAILY_AVERAGE_DAT_FILE"));
		sUEWSDailyAverages.outputMonthlyFile(graphDirectory,
				Messages.getString("SuewsPrestonComparisonGraphs.MONTHLY_CALCD_AVERAGE_DAT_FILE"));		

	}
	


}
