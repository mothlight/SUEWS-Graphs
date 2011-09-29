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

//	public TUF3DDataFile()
//	{
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public PrestonDataFile(String path, String filename)
	{
		super();

		this.variables = new ArrayList<String>();
		this.data = new TreeMap<String, ArrayList<String>>();

		setPath(path);
		setFilename(filename);
		readDataFile(path, filename);
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

		PrestonDataFile prestonDataFile = new PrestonDataFile(path, filename);
		TreeMap<String, ArrayList<String>> theData = prestonDataFile.getData();
		//System.out.println(theData.toString());

		System.out.println(theData.get("Kup").toString());

	}

	public void readDataFile(String path, String filename)
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
				StringTokenizer st = new StringTokenizer(variableStr, "\t");
				while (st.hasMoreTokens())
				{
					String aVariable = st.nextToken().trim();
					System.out.println("Variable=" + aVariable);
					this.variables.add(aVariable);
				}
			}

			while (dis.available()>0)
			{
				int count = 0;
				String year;
				String dayOfYear;
				String time;
				String dataStr = dis.readLine();

				StringTokenizer st = new StringTokenizer(dataStr, "\t");
				while (st.hasMoreTokens())
				{
					String variableName = this.variables.get(count);
					ArrayList dataSet = this.data.get(variableName);
					if (dataSet == null)
					{
						dataSet = new ArrayList<String>();
					}

					String variableValue = st.nextToken().trim();

					dataSet.add(variableValue);
					this.data.put(variableName, dataSet);

//					if (variableName.equals("Year"))
//					{
//						year = variableValue;
//					}
//					else if (variableName.equals("Day of year"))
//					{
//						dayOfYear = variableValue;
//					}
//					else if (variableName.equals("Day of year"))
//					{
//						dayOfYear = variableValue;
//					}
//					else
					if (variableName.equals("timecode"))
					{
						dayOfYear = variableValue;
					}

					count ++;
				}

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
