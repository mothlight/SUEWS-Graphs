package au.edu.monash.ges.suews.dbimport;

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
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import au.edu.monash.ges.suews.ENVICommon;
import au.edu.monash.ges.suews.Messages;
import au.edu.monash.ges.suews.SuewsConfigValues;

public class MawsonLakesDataImport
{
	ENVICommon common = new ENVICommon();
	
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
	
	public static int Timestamp_int = 0;
	public static int Date_int = 1;
	public static int Time_int = 2;
	public static int AirTC_Avg_AP_int = 3;
	public static int RH_Avg_AP_int = 4;
	public static int WS_ms_Avg_AP_int = 5;
	public static int WD_Avg_AP_int = 6;
	public static int P_hPA_Avg_AP_int = 7;
	public static int Rainfall_int = 8;
	public static int Solar_int = 9;

	private String dataTable = "Mawson_Lakes_data";
	private String dataFile = common.getHostnameWorkDirPath()		
			+ Messages.getString("MawsonLakesDataImport.DATA_PATH")
			+ Messages.getString("MawsonLakesDataImport.DATA_FILE");

	
	SuewsConfigValues suewsConfigValues = new SuewsConfigValues();

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		MawsonLakesDataImport mawsonLakesDataImport = new MawsonLakesDataImport();
		mawsonLakesDataImport.importData(mawsonLakesDataImport.dataFile);

	}

	public MawsonLakesDataImport()
	{
		super();
	}

	public void importData(String dataFile)
	{
		
		String timestamp;
		String date;
		String time;
		String airTC_Avg_AP;
		String rH_Avg_AP;
		String wS_ms_Avg_AP;
		String wD_Avg_AP;
		String p_hPA_Avg_AP;
		String rainfall;
		String solar;
		String[] fullDate;
		
		String year;
		String day;
		String month;

		File file = new File(dataFile);
		FileInputStream fis = null;
		Connection conn = null;

		try
		{
			conn = common.getPrestonSqliteConnection();
			
			fis = new FileInputStream(file);

			BufferedReader d = new BufferedReader(new InputStreamReader(fis));
			String header = d.readLine();
			
			while (d.ready())
			{
				// TIMESTAMP,date,time,AirTC_Avg_AP,RH_Avg_AP,WS_ms_Avg_AP,WD_Avg_AP,P_hPA_Avg_AP,Rainfall,Solar
				// 9/02/2011 8:30:00 PM,9,2030,28.9333333,23,4.23333333,81,1014.83333,0.0,4.82861827
				
				String line = d.readLine();
				//System.out.println(line);
				
				String[] splitLine = line.split(",");
				
				timestamp = splitLine[Timestamp_int];
				date = splitLine[Date_int];
				time = splitLine[Time_int];
				airTC_Avg_AP = splitLine[AirTC_Avg_AP_int];
				rH_Avg_AP = splitLine[RH_Avg_AP_int];
				wS_ms_Avg_AP = splitLine[WS_ms_Avg_AP_int];
				wD_Avg_AP = splitLine[WD_Avg_AP_int];
				p_hPA_Avg_AP = splitLine[P_hPA_Avg_AP_int];
				rainfall = splitLine[Rainfall_int];
				solar  = splitLine[Solar_int];
				
				time = common.padLeft(time, 4, '0');
				
				fullDate = getSplitDateFromTimestamp(timestamp);
				year = fullDate[2];
				day = fullDate[0];
				month = fullDate[1];
				int dayOfYearInt = common.getDayOfYearFromDayAndMonth(year, day, month);
				String dayOfYear = new Integer(dayOfYearInt).toString();
				dayOfYear = common.padLeft(dayOfYear, 3, '0');
				
				int weekOfYearInt = common.getWeekOfYearFromDayAndMonth(year, day, month);
				String weekOfYear = new Integer(weekOfYearInt).toString();
				weekOfYear = common.padLeft(weekOfYear, 3, '0');
				
				String timecode = year + dayOfYear + time;
				//System.out.println("dayOfYear=" + dayOfYear);				
				
//				System.out.println(timestamp 
//						+ " " + date 
//						+ " " + time 
//						+ " " + airTC_Avg_AP 
//						+ " " + rH_Avg_AP 
//						+ " " + wS_ms_Avg_AP 
//						+ " " + wD_Avg_AP 
//						+ " " + p_hPA_Avg_AP 
//						+ " " + rainfall 
//						+ " " + solar );
				
				//INSERT INTO `Preston_data` (`Year`,`Day_of_year`,`Time`,`Timecode`,`Month`,`Week`,`Kdown`,`Kup`,`Ldown`,`Lup`,`NET`,`QH`,`QE`,`QG`,`Flux_validity`,`CO2_flux_final`,`CO2_flux_validity`,`Temp`,`e_a`,`Wind_spd`,`Wind_dir`,`Pressure`,`Precip`,`Anthrop`,`tau`,`Soil_moisture`,`Deep_soil_temp`,`RH`) VALUES 
				//  (2003,224,1330,'20032241330',200308,33,331.417,0,316,0,267.854,124.524,52.172,91.158,2,0,0,13.183,1.059,9.873,353.549,993.6,0,0,1.019,0,0,69.91);
				
				String kup = "0";
				String ldown = "316";
				String lup = "0";
				double net = new Double(solar).doubleValue() + new Double(ldown).doubleValue();
				String qh = "-999";
				String qe = "-999";
				String qg = "-999";
				String fluxValidity = "2";
				String co2_flux_final = "0";
				String co2_flux_validity = "0";
				String e_a = "-999";
				String anthrop = "0";
				String tau = "1.019";
				String soil_moisture = "0";
				String deep_soil_temp = "0";
				
				
				String insertString = "INSERT INTO " +
						dataTable +
						" (`Year`,`Day_of_year`,`Time`,`Timecode`,`Month`,`Week`,`Kdown`,`Kup`,`Ldown`,`Lup`," +
						"`NET`,`QH`,`QE`,`QG`,`Flux_validity`,`CO2_flux_final`,`CO2_flux_validity`,`Temp`," +
						"`e_a`,`Wind_spd`,`Wind_dir`,`Pressure`,`Precip`,`Anthrop`,`tau`,`Soil_moisture`,`Deep_soil_temp`,`RH`) " +
						"VALUES (" +
						year +
						"," +
						dayOfYear +
						"," +
						time +
						"," +
						"'" +
						timecode +
						"'" +
						"," +
						year + month +
						"," +
						weekOfYear +
						"," +
						solar +
						"," +
						kup+
						"," +
						ldown +
						"," +
						lup +
						"," +
						net +
						"," +
						qh +
						"," +
						qe +
						"," +
						qg +
						"," +
						fluxValidity +
						"," +
						co2_flux_final +
						"," +
						co2_flux_validity +
						"," +
						airTC_Avg_AP +
						"," +
						e_a  +
						"," +
						wS_ms_Avg_AP +
						"," +
						wD_Avg_AP +
						"," +
						p_hPA_Avg_AP +
						"," +
						rainfall +
						"," +
						anthrop +
						"," +
						tau +
						"," +
						soil_moisture +
						"," +
						deep_soil_temp +
						"," +
						rH_Avg_AP +
						")"; 
				System.out.println(insertString);
				
				try
				{
					Statement stat = conn.createStatement();
					stat.executeUpdate(insertString);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}

				
				
			}
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}


	}
	
	public String[] getSplitDateFromTimestamp(String timestamp)
	{
		
		// 17/02/2011 12:30:00 AM
		
		String[] splitLine = timestamp.split(" ");
		//year = splitLine[2];
//		for (String item : splitLine)
//		{
//			System.out.println (item);
//		}
		String date = splitLine[0];
		String[] splitDate = date.split("/");
		
//		for (String item : splitDate)
//		{
//			System.out.println (item);
//		}
		return splitDate;
		
	}

}
