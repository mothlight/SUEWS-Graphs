package au.edu.monash.ges.suews;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PrestonDataFile
{
	ENVICommon common = new ENVICommon();

	public final static String FORMATTED_DATE = "FormattedDate";
	public final static String AVAILABLE_ENERGY = "AvailableEnergy";
	public final static String RN_G_H_LE = "Rn_G_H_LE";
	public final static String DAILY_ENERGY_BALANCE = "DailyEnergyBalance";

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

	public static String PRESTON_AVAILABLE_ENERGY = "29";
	public static String PRESTON_DAILY_ENERGY_BALANCE = "30";
	public static String PRESTON_RN_G_H_LE = "31";


	public static String PRESTON_STR_Year = "Year";
	public static String PRESTON_STR_Day_of_year = "Day_of_year";
	public static String PRESTON_STR_time = "time";
	public static String PRESTON_STR_timecode = "timecode";
	public static String PRESTON_STR_month = "month";
	public static String PRESTON_STR_week = "week";
	public static String PRESTON_STR_Kdown = "Kdown";
	public static String PRESTON_STR_Kup = "Kup";
	public static String PRESTON_STR_Ldown = "Ldown";
	public static String PRESTON_STR_Lup = "Lup";
	public static String PRESTON_STR_NET = "NET";
	public static String PRESTON_STR_QH = "QH";
	public static String PRESTON_STR_QE = "QE";
	public static String PRESTON_STR_QG = "QG";
	public static String PRESTON_STR_Flux_validity = "Flux_validity";
	public static String PRESTON_STR_CO2flux_final = "CO2flux_final";
	public static String PRESTON_STR_CO2_flux_validity = "CO2_flux_validity";
	public static String PRESTON_STR_Temp = "Temp";
	public static String PRESTON_STR_e_a = "e_a";
	public static String PRESTON_STR_wind_spd = "wind_spd";
	public static String PRESTON_STR_wind_dir = "wind_dir";
	public static String PRESTON_STR_pressure = "pressure";
	public static String PRESTON_STR_Precip = "Precip";
	public static String PRESTON_STR_Anthrop = "Anthrop";
	public static String PRESTON_STR_tau = "tau";
	public static String PRESTON_STR_soil_moisture = "soil_moisture";
	public static String PRESTON_STR_deep_soil_temp = "deep_soil_temp";
	public static String PRESTON_STR_FormattedDate = "FormattedDate";

//	public TUF3DDataFile()
//	{
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public PrestonDataFile(String path, String filename, boolean skip30s)
	{
		super();

		this.variables = new ArrayList<String>();
		this.data = new TreeMap<String, ArrayList<String>>();

		setPath(path);
		setFilename(filename);
		readDataFile(path, filename, skip30s);
	}

//	public SUEWSDataFile(String path, String filename, boolean reformatFullFile)
//	{
//		super();
//
//		this.variables = new ArrayList<String>();
//		this.data = new TreeMap<String, ArrayList<String>>();
//
//		setPath(path);
//		setFilename(filename);
//
//	}


	private String path;
	private String filename;

	ArrayList<String> variables;
	TreeMap<String, ArrayList<String>> data;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String path = Messages.getString("PrestonDataFile.DATA_PATH");
		String filename = Messages.getString("PrestonDataFile.DATA_FILE");

		PrestonDataFile prestonDataFile = new PrestonDataFile(path, filename, false);
		TreeMap<String, ArrayList<String>> theData = prestonDataFile.getData();
		//System.out.println(theData.toString());

		//System.out.println(theData.get(DAILY_ENERGY_BALANCE).toString());

	}

	public void readDataFile(String path, String filename, boolean skip30s)
	{
		String dataFile = path + File.separator + filename;

		File file = new File(dataFile);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try
		{
			fis = new FileInputStream(file);

			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			if (dis.available()>0)
			{

				String variableStr = dis.readLine();
				//variableStr = variableStr.replaceFirst("%", "");
				String[] splitString = variableStr.split(",");
				System.out.println ("variable string size=" + splitString.length);
				//StringTokenizer st = new StringTokenizer(variableStr, "\t");
				//while (st.hasMoreTokens())
				for (String aVariable : splitString)
				{
					//String aVariable = st.nextToken().trim();
					//System.out.println("Variable=" + aVariable);
					this.variables.add(aVariable.trim().replaceAll(" ", "_").replaceAll("\"", ""));
				}
				//not in the data files, added during processing
				this.variables.add(FORMATTED_DATE);

				this.variables.add(AVAILABLE_ENERGY);
				this.variables.add(DAILY_ENERGY_BALANCE);
				this.variables.add(RN_G_H_LE);
			}

			int readCount = 0;
			while (dis.available()>0)
			{

				String net = null, QG = null, QH = null, QE = null, temp = null, kup= null, kdown = null, lup = null, ldown = null;
				Double availableEnergy = 0.0, dailyEnergyBalance = 0.0, Rn_G_H_LE = 0.0;

				int count = 0;
				String year;
				String dayOfYear;
				String time;
				String dataStr = dis.readLine();

				if (skip30s)
				{
					//if count is even, skip this line
					if (readCount % 2 == 0)
					{
						readCount ++;
						continue;
					}
				}

				String[] splitString = dataStr.split(",");
				//System.out.println ("variable string size=" + splitString.length);

				//StringTokenizer st = new StringTokenizer(dataStr, "\t");
				//while (st.hasMoreTokens())
				for (String variableValue : splitString)
				{
					if (variableValue.equals(FORMATTED_DATE))
					{
						continue;
					}
					String variableName = this.variables.get(count);
					ArrayList<String> dataSet = this.data.get(variableName);
					if (dataSet == null)
					{
						dataSet = new ArrayList<String>();
					}

					//String variableValue = st.nextToken().trim();
					if (variableValue == null || variableValue.trim().equals(""))
					{
						variableValue = "?";
					}
					dataSet.add(variableValue);
					this.data.put(variableName, dataSet);

					if (variableName.equals("timecode"))
					{
						year = variableValue.substring(0, 4);
						dayOfYear = variableValue.substring(4, 7);
						time = variableValue.substring(7, 11);

						String formattedDate = year + "-" + dayOfYear + "-" + time;
						ArrayList<String> formattedDateDataSet = this.data.get(FORMATTED_DATE);
						if (formattedDateDataSet == null)
						{
							formattedDateDataSet = new ArrayList<String>();
						}
						formattedDateDataSet.add(formattedDate);
						this.data.put(FORMATTED_DATE, formattedDateDataSet);
					}


					if (variableName.equals(PRESTON_STR_NET))
					{
						net = variableValue;
					}
					else if (variableName.equals(PRESTON_STR_QH))
					{
						QH = variableValue;
					}
					else if (variableName.equals(PRESTON_STR_QE))
					{
						QE = variableValue;
					}
					else if (variableName.equals(PRESTON_STR_QG))
					{
						QG = variableValue;
					}
					else if (variableName.equals(PRESTON_STR_Temp))
					{
						temp = variableValue;
					}
					else if (variableName.equals(PRESTON_STR_Kup))
					{
						kup = variableValue;
					}
					else if (variableName.equals(PRESTON_STR_Kdown))
					{
						kdown = variableValue;
					}
					else if (variableName.equals(PRESTON_STR_Lup))
					{
						lup = variableValue;
					}
					else if (variableName.equals(PRESTON_STR_Ldown))
					{
						ldown = variableValue;
					}

					//if (count == variables.size())
					if (net != null && QG != null && QH != null && QE != null && temp != null)
					{
						ArrayList<Double> energyBalanceValues = common.energyBalance(kdown, kup, ldown, lup, QG, QH, QE, temp);
						availableEnergy = energyBalanceValues.get(0);
						dailyEnergyBalance = energyBalanceValues.get(1);
						Rn_G_H_LE = energyBalanceValues.get(2);

						ArrayList<String> formattedDateDataSet = this.data.get(AVAILABLE_ENERGY);
						if (formattedDateDataSet == null)
						{
							formattedDateDataSet = new ArrayList<String>();
						}
						formattedDateDataSet.add(availableEnergy.toString());
						this.data.put(AVAILABLE_ENERGY, formattedDateDataSet);

						formattedDateDataSet = this.data.get(DAILY_ENERGY_BALANCE);
						if (formattedDateDataSet == null)
						{
							formattedDateDataSet = new ArrayList<String>();
						}
						formattedDateDataSet.add(dailyEnergyBalance.toString());
						this.data.put(DAILY_ENERGY_BALANCE, formattedDateDataSet);

						formattedDateDataSet = this.data.get(RN_G_H_LE);
						if (formattedDateDataSet == null)
						{
							formattedDateDataSet = new ArrayList<String>();
						}
						formattedDateDataSet.add(Rn_G_H_LE.toString());
						this.data.put(RN_G_H_LE, formattedDateDataSet);

//						outputStr.append(availableEnergy + " ");
//						outputStr.append(dailyEnergyBalance + " ");
//						outputStr.append(Rn_G_H_LE + " ");
					}


					count ++;
				}
				readCount ++;

			}

			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public ArrayList<String> getVariables()
	{
		return variables;
	}

	public void setVariables(ArrayList<String> variables)
	{
		this.variables = variables;
	}

	public TreeMap<String, ArrayList<String>> getData()
	{
		return data;
	}

	public void setData(TreeMap<String, ArrayList<String>> data)
	{
		this.data = data;
	}

}
