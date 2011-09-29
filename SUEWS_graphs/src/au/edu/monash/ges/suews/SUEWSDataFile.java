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

public class SUEWSDataFile
{

//	public TUF3DDataFile()
//	{
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public SUEWSDataFile(String path, String filename, boolean skipEveryOtherLine)
	{
		super();

		this.variables = new ArrayList<String>();
		this.data = new TreeMap<String, ArrayList<String>>();

		setPath(path);
		setFilename(filename);
		setYear(parseYear(filename));
		readDataFile(path, filename, skipEveryOtherLine);
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
	private String year;

	private String parseYear(String filename)
	{
		String year;

		String[] filenameSplit = filename.split("_");
		year = filenameSplit[1];

		return year;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	ArrayList<String> variables;
	TreeMap<String, ArrayList<String>> data;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String path = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DATA_PATH");
		String filename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE");

		SUEWSDataFile sUEWSDataFile = new SUEWSDataFile(path, filename, false);
		TreeMap<String, ArrayList<String>> theData = sUEWSDataFile.getData();
		//System.out.println(theData.toString());

		System.out.println(theData.get("kup").toString());

	}

	public void readDataFile(String path, String filename, boolean skipEveryOtherLine)
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
				dis.readLine(); dis.readLine(); dis.readLine(); dis.readLine();
				String variableStr = dis.readLine();
				variableStr = variableStr.replaceFirst("%", "");
				StringTokenizer st = new StringTokenizer(variableStr);
				while (st.hasMoreTokens())
				{
					String aVariable = st.nextToken().trim();
					//System.out.println("Variable=" + aVariable);
					this.variables.add(aVariable);
				}
			}

			int readCount = 0;
			while (dis.available()>0)
			{
				int count = 0;
				String dataStr = dis.readLine();

				if (skipEveryOtherLine)
				{
					//if count is even, skip this line
					if (readCount % 2 == 0)
					{}
					else
					{
						readCount ++;
						continue;
					}
				}

				StringTokenizer st = new StringTokenizer(dataStr);
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
