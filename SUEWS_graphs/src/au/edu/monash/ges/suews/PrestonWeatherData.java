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
	
	ENVICommon common = new ENVICommon();
		

	/*
	  load data local infile '/home/kerryn/Documents/Work/PrestonData/PrestonMysqlImport.csv' 
into table suews.Preston_data fields terminated by ',' lines terminated by '\n'; 
	 * 
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrestonWeatherData prestonWeatherData = new PrestonWeatherData();
		prestonWeatherData.getPrestonData();

	}
	
	public TreeMap<String, Integer> getPrestonData()
	{		
		TreeMap<String, Integer> variables = new TreeMap<String, Integer>();
		String query = "select " + YEAR + "," + DAY_OF_YEAR + "," + TIME + ","+ TIMECODE + "," +	
			MONTH + "," + WEEK + "," + KDOWN + ","+ KUP +"," + LDOWN + "," + LUP + "," + NET + ","+ QH + "," +
			QE + "," + QG + "," + FLUX_VALIDITY + ","+ CO2_FLUX_FINAL + "," + CO2_FLUX_VALIDITY + "," + TEMP + "," + E_A + ","+ WIND_SPD + "," +			
			WIND_DIR + "," + PRESSURE + "," + PRECIP + "," + ANTHROP + "," + TAU + "," + SOIL_MOISTURE + "," +
			DEEP_SOIL_TEMP + "," + RH +
				" from `suews`.`Preston_data` ";

		System.out.println (query);
		Connection conn = common.getSuewsMySqlConnection();		
		try
		{
			Statement stat = conn.createStatement();

			ResultSet rs = stat.executeQuery(query);
			while (rs.next())
			{
				String year = rs.getString(YEAR);
				String dayOfYear = rs.getString(DAY_OF_YEAR);
				String time = rs.getString(TIME);
				String timecode = rs.getString(TIMECODE);
				
				String month = rs.getString(MONTH);
				String week = rs.getString(WEEK); 
				String kdown = rs.getString(KDOWN); 
				String kup = rs.getString(KUP); 
				String ldown = rs.getString(LDOWN); 
				String lup = rs.getString(LUP); 
				String net = rs.getString(NET); 
				String qh = rs.getString(QH);
				String qe = rs.getString(QE);
				String qg = rs.getString(QG); 
				String fluxValidity = rs.getString(FLUX_VALIDITY); 						
				String co2FluxFinal = rs.getString(CO2_FLUX_FINAL); 
				String co2FluxValidity = rs.getString(CO2_FLUX_VALIDITY); 
				String temp = rs.getString(TEMP); 
				double tempDouble = new Double(temp).doubleValue();
				String eA = rs.getString(E_A); 
				double eADouble = new Double(eA).doubleValue();
				String windSpd = rs.getString(WIND_SPD);			
				String windDir = rs.getString(WIND_DIR); 
				String pressure = rs.getString(PRESSURE); 
				String precip = rs.getString(PRECIP); 
				String anthro = rs.getString(ANTHROP); 
				String tau = rs.getString(TAU); 
				String soilMoisture = rs.getString(SOIL_MOISTURE);
				String deepSoilTemp = rs.getString(DEEP_SOIL_TEMP); 
				String rh = rs.getString(RH);
				if (rh == null)
				{			
					double rhDouble = common.roundTwoDecimals(common.CalculateRHFromVapor2(tempDouble, eADouble));
					rh = new Double(rhDouble).toString();
					updateRH(timecode, rhDouble);
				}			
				
				System.out.println(year + " " + dayOfYear + " " + time + " " + timecode + "," +
						month + "," + week + "," + kdown + ","+ kup + ","+ ldown + "," + lup + "," + net + ","+ qh + "," +
						qe + "," + qg + "," + fluxValidity + ","+ co2FluxFinal + " ," + co2FluxValidity + "," + temp + "," + eA + ","+ windSpd + "," +			
						windDir + "," + pressure + "," + precip + "," + anthro + "," + tau + "," + soilMoisture + "," +
						deepSoilTemp + "," + rh );
				
				//variables.put(variableName, variableID);
			}
			rs.close();
			conn.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//System.out.println(variables.toString());
		return variables;
	}
	private void updateRH(String timecode, double rh)
	{
		try
		{
			Connection conn = common.getSuewsMySqlConnection();
		
			String updateStr = " update `suews`.`Preston_data` set " 
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

}
