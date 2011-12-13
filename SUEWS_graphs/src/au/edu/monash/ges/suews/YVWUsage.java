package au.edu.monash.ges.suews;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class YVWUsage
{
	ENVICommon common = new ENVICommon();
	private TreeMap<String, Integer> waterData;
	ArrayList<String> quarter1Months; 
	ArrayList<String> quarter2Months;
	ArrayList<String> quarter3Months;
	ArrayList<String> quarter4Months;


	public YVWUsage()
	{
		super();
		populateWaterUsage();
		
		quarter1Months = new ArrayList<String>();
		quarter1Months.add("Jan");
		quarter1Months.add("Feb");
		quarter1Months.add("Mar");
		
		quarter2Months = new ArrayList<String>();
		quarter2Months.add("Apr");
		quarter2Months.add("May");
		quarter2Months.add("Jun");
		
		quarter3Months = new ArrayList<String>();
		quarter3Months.add("Jul");
		quarter3Months.add("Aug");
		quarter3Months.add("Sep");
		  
		quarter4Months = new ArrayList<String>();		   
		quarter4Months.add("Oct");
		quarter4Months.add("Nov");
		quarter4Months.add("Dec");
		
	}
	
	public static void main(String[] args)
	{
		String year = "04";
		int quarter = 1;
		
		YVWUsage yVWUsage = new YVWUsage();
		//TreeMap<String, Integer> data = yVWUsage.extractQuarter(year, quarter);
		//System.out.println(data.toString());
//		Double average = yVWUsage.getMLAverageForQuarter(year, quarter);
//		System.out.println(average + " for " + year + " " + quarter);
//		
//		quarter = 2;
//		System.out.println(yVWUsage.getMLAverageForQuarter(year, quarter) + " for " + year + " " + quarter);
//		quarter = 3;		
//		System.out.println(yVWUsage.getMLAverageForQuarter(year, quarter) + " for " + year + " " + quarter);
//		quarter = 4;
//		System.out.println(yVWUsage.getMLAverageForQuarter(year, quarter) + " for " + year + " " + quarter);
		
		yVWUsage.calculateYearWaterExternal(year);
	}
	
	public TreeMap <String, Double> weightDailyUsageByHour(TreeMap <String, Double> hourlyWeighings, double dailyWaterAmount)
	{
		TreeMap <String, Double> returnValues = new TreeMap <String, Double>();
		
		Set<String> keys = hourlyWeighings.keySet();
		for(String key : keys)
		{
			// hourlyWeighings.put("1", .25);
			Double hourlyPercentage = hourlyWeighings.get(key);
			Double water = common.roundToDecimals( (dailyWaterAmount * hourlyPercentage) , common.DEFAULT_ROUNDING_PRECISION);
			returnValues.put(key, water);
		}
		
		return returnValues;		
	}

	
	public ArrayList<TreeMap<String, Double>> calculateYearWaterExternal(String year)
	{
		ArrayList<TreeMap<String, Double>> data = new ArrayList<TreeMap<String, Double>>();
		int winterQuarter = 3;
		double winterUsage = getMLAverageForQuarter(year, winterQuarter);
		
		double quarter1TotalUsage = getMLTotalForQuarter(year, 1);
		TreeMap<String, Integer> quarter1Data = extractQuarter(year, 1);
		TreeMap<String, Double> quarter1WeightedData = weightWaterUsage(year, 1, quarter1TotalUsage, winterUsage, quarter1Data);
		System.out.println (quarter1WeightedData.toString());
		
		double quarter2TotalUsage = getMLTotalForQuarter(year, 2);
		TreeMap<String, Integer> quarter2Data = extractQuarter(year, 2);
		TreeMap<String, Double> quarter2WeightedData = weightWaterUsage(year, 2, quarter2TotalUsage, winterUsage, quarter2Data);
		System.out.println (quarter2WeightedData.toString());
		
		TreeMap<String, Double> quarter3WeightedData = getZeroWaterUsageQuarter(year, 3);
		System.out.println (quarter3WeightedData.toString());
		
		double quarter4TotalUsage = getMLTotalForQuarter(year, 4);
		TreeMap<String, Integer> quarter4Data = extractQuarter(year, 4);
		TreeMap<String, Double> quarter4WeightedData = weightWaterUsage(year, 4, quarter4TotalUsage, winterUsage, quarter4Data);
		System.out.println (quarter4WeightedData.toString());
		
		data.add(quarter1WeightedData);
		data.add(quarter2WeightedData);
		data.add(quarter3WeightedData);
		data.add(quarter4WeightedData);
		
		return data;
		
	}
	
	public TreeMap<String, Double> weightWaterUsage(String year, int quarter, double quarterTotalUsage, double winterAverage, TreeMap<String, Integer> quarterData)
	{
		TreeMap<String, Double> weightedWaterUsage = new TreeMap<String, Double>();
		ArrayList<String> months = getMonthsForQuarter(quarter);
		
		for (String month : months)
		{			
		  for (int day=1;day<=31;day++)
		  {
			  //String key = day + "-" + month + "-" + year;
			  String key = getKeyForDate(year, month, day);
			  Integer ml = quarterData.get(key);
			  if (ml != null)
			  {
				  double difference = ml - winterAverage;
				  if (difference < 0)
				  {
					  difference = 0;
				  }
				  double quarterlyPercentage = quarterTotalUsage / ml / 100;
				  double dailyWeighted = common.roundToDecimals( (quarterlyPercentage * difference), common.DEFAULT_ROUNDING_PRECISION);
				  
				  weightedWaterUsage.put(key, dailyWeighted);
			  }			   
		  }
		}			
		return weightedWaterUsage;
	}
	
	public String getKeyForDate(String year, String month, int day)
	{
		String key = day + "-" + month + "-" + year;
		return key;
	}
	
	public TreeMap<String, Double> getZeroWaterUsageQuarter(String year, int quarter)
	{
		TreeMap<String, Double> weightedWaterUsage = new TreeMap<String, Double>();
		ArrayList<String> months = getMonthsForQuarter(quarter);
		
		for (String month : months)
		{			
		  for (int day=1;day<=31;day++)
		  {
			  String key = getKeyForDate(year, month, day);			  
			  weightedWaterUsage.put(key, 0.0);
		  }
		}			
		return weightedWaterUsage;
	}
	
	public Double getMLAverageForQuarter(String year, int quarter)
	{
		double total = 0;
		
		TreeMap<String, Integer> data = extractQuarter(year, quarter);
		Set<String> keys = data.keySet();
		int items = data.size();
		for (String key : keys)
		{
			Integer ml = data.get(key);
			total += ml; 			
		}
		return common.roundToDecimals((total/items), common.DEFAULT_ROUNDING_PRECISION);
	}
	
	public Double getMLTotalForQuarter(String year, int quarter)
	{
		double total = 0;
		
		TreeMap<String, Integer> data = extractQuarter(year, quarter);
		Set<String> keys = data.keySet();
		
		for (String key : keys)
		{
			Integer ml = data.get(key);
			total += ml; 			
		}
		return total;
	}	
	
	public TreeMap<String, Integer> extractQuarter(String year, int quarter)
	{
		TreeMap<String, Integer> quarterData = new TreeMap<String, Integer>();
		
		TreeMap<String, Integer> data = getWaterData();
		
		//{1-Apr-01=587, 1-Apr-02=460, 1-Apr-03=547,
		ArrayList<String> months = getMonthsForQuarter(quarter);
		
		for (String month : months)
		{			
		  for (int day=1;day<=31;day++)
		  {
			  //String key = day + "-" + month + "-" + year;
			  String key = getKeyForDate(year, month, day);
			  Integer ml = data.get(key);
			  if (ml != null)
			  {
				  quarterData.put(key, ml);
			  }
			   
		  }
		}		
		return quarterData;		
	}
	
	public ArrayList<String> getMonthsForQuarter(int quarter)
	{
		ArrayList<String> months = new ArrayList();
		switch (quarter) {
		  case 1:	
//			  months.add("Jan");
//			  months.add("Feb");
//			  months.add("Mar");
			  months = quarter1Months;
		    break;
		  case 2:	
//			  months.add("Apr");
//			  months.add("May");
//			  months.add("Jun");
			  months = quarter2Months;
		    break;
		  case 3:		   
//			  months.add("Jul");
//			  months.add("Aug");
//			  months.add("Sep");
			  months = quarter3Months;
		    break;
		  case 4:		   
//			  months.add("Oct");
//			  months.add("Nov");
//			  months.add("Dec");
			  months = quarter4Months;
		    break;
		  
		  default: 
		  
		}
		return months;
	}
	
	private void populateWaterUsage()
	{
		setWaterData(fetchWaterUsage());
	}

	public TreeMap<String, Integer> fetchWaterUsage()
	{
		TreeMap<String, Integer> data = new TreeMap<String, Integer>();
		
		Connection conn = common.getPrestonSqliteConnection();
		String query = "select Date,ML from Water_usage";
		
		try
		{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			while (rs.next())
			{
				String date = rs.getString(1);
				Integer ml = rs.getInt(2);
				//System.out.println(date + " " + ml);
				data.put(date, ml);
				
			}
			rs.close();
			conn.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return data;
	}
	
	public TreeMap<String, Integer> getWaterData()
	{
		return waterData;
	}

	public void setWaterData(TreeMap<String, Integer> waterData)
	{
		this.waterData = waterData;
	}

}
