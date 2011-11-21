package au.edu.monash.ges.suews;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class ProcessSuewsMonthlyAverage
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String path = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DATA_PATH");
		String filename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE");

		SUEWSDataFile sUEWSDataFile = new SUEWSDataFile(path, filename, true, SUEWSDataFile.LINES_TO_SKIP_60);
		TreeMap<String, ArrayList<String>> theData = sUEWSDataFile.getData();

		Set<String> keys = theData.keySet();
		for (String key : keys)
		{
			System.out.println(key);
		}

		//System.out.println(theData.toString());

		//System.out.println(theData.get(SUEWS_DAILY_FILE_STR_Change).toString());

		SUEWSMonthlyAverages sUEWSMonthlyAverages = new SUEWSMonthlyAverages(sUEWSDataFile);

		sUEWSMonthlyAverages.outputDataFile(Messages.getString("SuewsPrestonComparisonGraphs.graph_dir"),
				Messages.getString("SuewsPrestonComparisonGraphs.MONTHLY_AVERAGE_DAT_FILE"));


		ProcessSUEWSRun processSUEWSRun = new ProcessSUEWSRun();
		sUEWSDataFile.setPath(Messages.getString("SuewsPrestonComparisonGraphs.graph_dir"));
		processSUEWSRun.generateReformattedDataFile(sUEWSDataFile);


	}

}
