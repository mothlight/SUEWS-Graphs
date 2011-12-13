package au.edu.monash.ges.suews;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class PrestonWeatherData {
	
	public static String YEAR = "Year";
	public static String DAY_OF_YEAR = "Day_of_year";
	public static String TIME = "Time";
	public static String TIMECODE = "Timecode";
	public static String MONTH = "Month";
	public static String WEEK = "Week";
	public static String KDOWN = "Kdown";
	public static String KUP = "Kup";
	public static String LDOWN = "Ldown";
	public static String LUP = "Lup";
	public static String NET = "NET";
	public static String QH = "QH";
	public static String QE = "QE";
	public static String QG = "QG";
	public static String FLUX_VALIDITY = "Flux_validity";
	public static String CO2_FLUX_FINAL = "CO2_flux_final";
	public static String CO2_FLUX_VALIDITY = "CO2_flux_validity";
	public static String TEMP = "Temp";
	public static String E_A = "e_a";
	public static String WIND_SPD = "Wind_spd";
	public static String WIND_DIR = "Wind_dir";
	public static String PRESSURE = "Pressure";
	public static String PRECIP = "Precip";
	public static String ANTHROP = "Anthrop";
	public static String TAU = "tau";
	public static String SOIL_MOISTURE = "Soil_moisture";
	public static String DEEP_SOIL_TEMP = "Deep_soil_temp";
	public static String RH = "RH";
	public static String EXT_WATER = "extwater";
	
	ENVICommon common = new ENVICommon();
	SuewsConfigValues suewsConfigValues = new SuewsConfigValues();
	
	private String dataTable = "Preston_data";
	
	
	

	/*
	  load data local infile '/home/kerryn/Documents/Work/PrestonData/PrestonMysqlImport.csv' 
into table suews.Preston_data fields terminated by ',' lines terminated by '\n'; 
	 * 
	 */
	
	public PrestonWeatherData()
	{
		super();
		setDataTable(suewsConfigValues.getPrestonWeatherDataDataTable());
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrestonWeatherData prestonWeatherData = new PrestonWeatherData();
		int searchYear = 2004;
		prestonWeatherData.getPrestonData(searchYear);

	}
	
	public ArrayList<String> getMonthAndYearsOfData()
	{
		ArrayList<String> months = new ArrayList<String>();
		String query = "select distinct month from " +
				getDataTable() +
				" ";
		Connection conn = common.getPrestonSqliteConnection();
		try
		{
			Statement stat = conn.createStatement();

			ResultSet rs = stat.executeQuery(query);
			while (rs.next())
			{
				String month = rs.getString(1);
				months.add(month);
			}
		
		rs.close();
		conn.close();

		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return months;
	}
	
	public ArrayList<String> getDistinctTimesForData()
	{
		Connection conn = common.getPrestonSqliteConnection();
		ArrayList<String> times = new ArrayList<String>();
		String timeQuery = "select distinct time from " +
				getDataTable() +
				" ";	
		try
		{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(timeQuery);
			while (rs.next())
			{
				String timeStr = rs.getString(1);
				times.add(timeStr);
			}
			rs.close();
			conn.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return times;
	}
	
	public TreeMap<String, Double> getMonthlyAverageForDataItem(String month, String item)
	{
		Connection conn = common.getPrestonSqliteConnection();
		TreeMap<String,Double> data = new TreeMap<String, Double>();
		// select Kdown from Preston_data where month='200401' and time = '130'
					
		try
		{
			Statement stat = conn.createStatement();
			ResultSet rs = null;
			ArrayList<String> times = getDistinctTimesForData();
			
			for (String time : times)
			{
				String query = "select " + item + " from " +
						getDataTable() +
						" where month='" + month + "' and time = '" + time + "'";
				rs = stat.executeQuery(query);
				int count = 0;
				double runningTotal = 0;
				while(rs.next())
				{
					String value = rs.getString(1);
					count ++;
					Double valueDouble = new Double(value).doubleValue();
					runningTotal += valueDouble;					
				}
				double average = runningTotal / count;
				data.put(time, common.roundTwoDecimals(average));				
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
	
	public String getWaterUsageForHour(String timecode, ArrayList<TreeMap<String, Double>> yVWData, TreeMap<String, Double> hourlyWeighings)
	{
		String waterUsage = "0.0";
		
		//20042241330
		String year = timecode.substring(0, 4);
		int yearInt = new Integer(year).intValue();
		String day = timecode.substring(4, 7);
		int dayOfYearInt = new Integer(day).intValue();
		String hourMinute = timecode.substring(7, 11);
		if (hourMinute .endsWith("30"))
		{
			return waterUsage;
		}
		String hour = hourMinute.substring(0,2);
		
		int dayOfMonth = common.getDayOfMonthFromDayOfYear(yearInt, dayOfYearInt);	
		int month = common.getMonthFromDayOfYear(yearInt, dayOfYearInt);
		String key = common.getYVWKeyForDate(yearInt, month, dayOfMonth);
		int quarter = common.getYVWQuarterForMonth(month);
		
		TreeMap<String, Double> quarterlyData = yVWData.get(quarter);
		Double dailyWater = quarterlyData.get(key);
		
		if (dailyWater == null)
		{
			return "0.0";
		}
		Double hourWaterAmount = YVWUsage.weightDailyUsageBySingleHour(hourlyWeighings, dailyWater, hour);
		hourWaterAmount = hourWaterAmount * suewsConfigValues.getPrestonExternalWaterMultiplier();
		
		Double roundedHourWaterAmount = common.roundToDecimals(hourWaterAmount, ENVICommon.DEFAULT_ROUNDING_PRECISION);
		waterUsage = roundedHourWaterAmount.toString();		
				
		return waterUsage;				
	}
	
	
	public ArrayList<TreeMap<String,String>> getPrestonData(int searchYear)
	{
//		TreeMap <String, Double> hourlyWeighings = new TreeMap<String, Double>();
//		hourlyWeighings.put("01", .25);
//		hourlyWeighings.put("02", .25);
//		hourlyWeighings.put("03", .25);
//		hourlyWeighings.put("22", .25);
		
		SuewsConfigValues suewsConfigValues = new SuewsConfigValues();
		TreeMap <String, Double> hourlyWeighings = suewsConfigValues.getPrestonExternalWaterHourlyWeighings();
		
		YVWUsage yVWUsage = new YVWUsage();
		String waterYear = new Integer(searchYear).toString().substring(2);
		ArrayList<TreeMap<String, Double>> yVWData = yVWUsage.calculateYearWaterExternal(waterYear);
		
		//select Year,Day_of_year,Time,Timecode,Month,Week,Kdown,Kup,Ldown,Lup,NET,QH,QE,QG,Flux_validity,CO2_flux_final,CO2_flux_validity,Temp,e_a,Wind_spd,Wind_dir,Pressure,Precip,Anthrop,tau,Soil_moisture,Deep_soil_temp,RH from Preston_Data 
		// where Year = 2004
		// order by Timecode
		
		//String table = "`suews`.`Preston_data`";
		String table = getDataTable();
		//TreeMap<String, Integer> variables = new TreeMap<String, Integer>();
		ArrayList<TreeMap<String, String>> variables = new ArrayList<TreeMap<String, String>>();
		
		String queryWhere = " where " + YEAR + "=" + searchYear ;
		if (searchYear == -1)
		{
			queryWhere = " ";
		}
		
		String query = "select " + YEAR + "," + DAY_OF_YEAR + "," + TIME + ","+ TIMECODE + "," +	
			MONTH + "," + WEEK + "," + KDOWN + ","+ KUP +"," + LDOWN + "," + LUP + "," + NET + ","+ QH + "," +
			QE + "," + QG + "," + FLUX_VALIDITY + ","+ CO2_FLUX_FINAL + "," + CO2_FLUX_VALIDITY + "," + TEMP + "," + E_A + ","+ WIND_SPD + "," +			
			WIND_DIR + "," + PRESSURE + "," + PRECIP + "," + ANTHROP + "," + TAU + "," + SOIL_MOISTURE + "," +
			DEEP_SOIL_TEMP + "," + RH +
				" from " +
				table +
				queryWhere +
				" order by "+ TIMECODE ;

		System.out.println (query);
		//Connection conn = common.getSuewsMySqlConnection();
		Connection conn = common.getPrestonSqliteConnection();
		try
		{
			Statement stat = conn.createStatement();

			ResultSet rs = stat.executeQuery(query);
			while (rs.next())
			{
				TreeMap<String, String> oneItem = new TreeMap<String, String>();
				String year = rs.getString(YEAR);
				oneItem.put(YEAR, year);
				String dayOfYear = rs.getString(DAY_OF_YEAR);
				oneItem.put(DAY_OF_YEAR, dayOfYear);
				String time = rs.getString(TIME);
				oneItem.put(TIME, time);
				String timecode = rs.getString(TIMECODE);
				oneItem.put(TIMECODE, timecode);
				String month = rs.getString(MONTH);
				oneItem.put(MONTH, month);
				String week = rs.getString(WEEK);
				oneItem.put(WEEK, week);
				String kdown = rs.getString(KDOWN);
				oneItem.put(KDOWN, kdown);
				String kup = rs.getString(KUP);
				oneItem.put(KUP, kup);
				String ldown = rs.getString(LDOWN);
				oneItem.put(LDOWN, ldown);
				String lup = rs.getString(LUP);
				oneItem.put(LUP, lup);
				String net = rs.getString(NET);
				oneItem.put(NET, net);
				String qh = rs.getString(QH);
				oneItem.put(QH, qh);
				String qe = rs.getString(QE);
				oneItem.put(QE, qe);
				String qg = rs.getString(QG);
				oneItem.put(QG, qg);
				String fluxValidity = rs.getString(FLUX_VALIDITY);
				oneItem.put(FLUX_VALIDITY, fluxValidity);
				String co2FluxFinal = rs.getString(CO2_FLUX_FINAL);
				oneItem.put(CO2_FLUX_FINAL, co2FluxFinal);
				String co2FluxValidity = rs.getString(CO2_FLUX_VALIDITY);
				oneItem.put(CO2_FLUX_VALIDITY, co2FluxValidity);
				String temp = rs.getString(TEMP);
				oneItem.put(TEMP, temp);
				double tempDouble = new Double(temp).doubleValue();
				//oneItem.put(YEAR, year);
				String eA = rs.getString(E_A);
				oneItem.put(E_A, eA);
				double eADouble = new Double(eA).doubleValue();
				//oneItem.put(YEAR, year);
				String windSpd = rs.getString(WIND_SPD);
				oneItem.put(WIND_SPD, windSpd);
				String windDir = rs.getString(WIND_DIR);
				oneItem.put(WIND_DIR, windDir);
				String pressure = rs.getString(PRESSURE);
				oneItem.put(PRESSURE, pressure);
				String precip = rs.getString(PRECIP);
				oneItem.put(PRECIP, precip);
				String anthro = rs.getString(ANTHROP);
				oneItem.put(ANTHROP, anthro);
				String tau = rs.getString(TAU);
				oneItem.put(TAU, tau);
				String soilMoisture = rs.getString(SOIL_MOISTURE);
				oneItem.put(SOIL_MOISTURE, soilMoisture);
				String deepSoilTemp = rs.getString(DEEP_SOIL_TEMP);
				oneItem.put(DEEP_SOIL_TEMP, deepSoilTemp);
				String rh = rs.getString(RH);
				
				String extWaterUsage = "0.0";
				if (searchYear == -1)
				{
					
				}
				else
				{
					extWaterUsage = getWaterUsageForHour(timecode, yVWData, hourlyWeighings);					 
				}
						
				oneItem.put(EXT_WATER, extWaterUsage);
//System.out.println("external Water for " + timecode + "=" + extWaterUsage);
				
				oneItem.put(RH, rh);

				
				variables.add(oneItem);
			}
			rs.close();
			conn.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return variables;
	}
	
	public void outputPlotData(ArrayList<TreeMap<String, String>> data, String path, String filename)
	{
		// # Year Day_of_year time timecode month week Kdown Kup Ldown Lup NET QH QE QG Flux_validity CO2flux_final CO2_flux_validity Temp e_a wind_spd wind_dir. pressure Precip. Anthrop. tau soil_moisture deep_soil_temp FormattedDate 
		StringBuffer st = new StringBuffer("# Year Day_of_year time timecode month week Kdown Kup Ldown Lup NET QH QE QG Flux_validity CO2flux_final CO2_flux_validity Temp e_a wind_spd wind_dir. pressure Precip. Anthrop. tau soil_moisture deep_soil_temp FormattedDate RH" + '\n');
		
		// 2003 224 1400 20032241400 200308 33 284.683  302  286.13 96.928 76.412 112.79 2   13.511 1.048 10.634 355.939 993.05 0 13.068 0.797 ? ? 2003-224-1400 
		for (TreeMap<String, String> oneItem : data)
		{					
			String year = oneItem.get(YEAR);			
			String dayOfYear = oneItem.get(DAY_OF_YEAR);			
			String time = oneItem.get(TIME);			
			String timecode = oneItem.get(TIMECODE);			
			String month = oneItem.get(MONTH);			
			String week = oneItem.get(WEEK);			
			String kdown = oneItem.get(KDOWN);			
			String kup = oneItem.get(KUP);			
			String ldown = oneItem.get(LDOWN);			
			String lup = oneItem.get(LUP );			
			String net = oneItem.get(NET );			
			String qh = oneItem.get(QH );			
			String qe = oneItem.get(QE );			
			String qg = oneItem.get(QG );			
			String fluxValidity = oneItem.get(FLUX_VALIDITY );			
			String co2FluxFinal = oneItem.get(CO2_FLUX_FINAL );			
			String co2FluxValidity = oneItem.get(CO2_FLUX_VALIDITY );			
			String temp = oneItem.get(TEMP );			
			String eA = oneItem.get(E_A );			
			String windSpd = oneItem.get(WIND_SPD );			
			String windDir = oneItem.get(WIND_DIR );			
			String pressure = oneItem.get(PRESSURE );			
			String precip = oneItem.get(PRECIP );			
			String anthro = oneItem.get(ANTHROP );			
			String tau = oneItem.get(TAU );			
			String soilMoisture = oneItem.get(SOIL_MOISTURE );			
			String deepSoilTemp = oneItem.get(DEEP_SOIL_TEMP );			
			String rh = oneItem.get(RH );
			String formattedDate = year + "-" + dayOfYear + "-" + time;
			
			st.append(year + " ");
			st.append(dayOfYear + " ");
			st.append(time + " ");
			st.append(timecode + " ");
			st.append(month + " ");
			st.append(week + " ");
			st.append(kdown + " ");
			st.append(kup + " ");
			st.append(ldown + " ");
			st.append(lup + " ");
			st.append(net + " ");
			st.append(qh + " ");
			st.append(qe + " ");
			st.append(qg + " ");
			st.append(fluxValidity + " ");
			st.append(co2FluxFinal + " ");
			st.append(co2FluxValidity + " ");
			st.append(temp + " ");
			st.append(eA + " ");
			st.append(windSpd + " ");
			st.append(windDir + " ");
			st.append(pressure + " ");
			st.append(precip + " ");
			st.append(anthro + " ");
			st.append(tau + " ");
			st.append(soilMoisture + " ");
			st.append(deepSoilTemp + " ");
			st.append(formattedDate + " ");
			st.append(rh + " ");
			
			st.append('\n');
			
		}
		common.writeFile(st.toString(), path + filename);
	}
	
	private void updateRH(String timecode, double rh)
	{
		try
		{
			//Connection conn = common.getSuewsMySqlConnection();
			Connection conn = common.getPrestonSqliteConnection();
		
			String updateStr = " update `suews`.`" +
					getDataTable() +
					"` set " 
							+ RH 
							+ " = " 
							+ rh 
							+ " where timecode=" 
							+ timecode;		
	
			Statement statement = conn.createStatement();
			statement.executeUpdate(updateStr);
			statement.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public String getDataTable()
	{
		return dataTable;
	}

	public void setDataTable(String dataTable)
	{
		this.dataTable = dataTable;
	}
	

}
