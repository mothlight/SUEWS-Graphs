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

	public final static String FORMATTED_DATE = "FormattedDate";

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

		System.out.println(theData.get(prestonDataFile.FORMATTED_DATE).toString());

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
				//use up lines
				//dis.readLine(); dis.readLine(); dis.readLine(); dis.readLine();
				String variableStr = dis.readLine();
				//variableStr = variableStr.replaceFirst("%", "");
				String[] splitString = variableStr.split("\t");
				System.out.println ("variable string size=" + splitString.length);
				//StringTokenizer st = new StringTokenizer(variableStr, "\t");
				//while (st.hasMoreTokens())
				for (String aVariable : splitString)
				{
					//String aVariable = st.nextToken().trim();
					//System.out.println("Variable=" + aVariable);
					this.variables.add(aVariable.trim().replaceAll(" ", "_"));
				}
				//not in the data files, added during processing
				this.variables.add(FORMATTED_DATE);
			}

			int readCount = 0;
			while (dis.available()>0)
			{
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

				String[] splitString = dataStr.split("\t");
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
