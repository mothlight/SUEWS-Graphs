package au.edu.monash.ges.suews;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jgnuplot.Axes;
import org.jgnuplot.Graph;
import org.jgnuplot.LineType;
import org.jgnuplot.Plot;
import org.jgnuplot.PointType;
import org.jgnuplot.Style;
import org.jgnuplot.Terminal;

public class SuewsPrestonComparisonGraphs
{

	ENVICommon common = new ENVICommon();

	public String XRANGE_BEG = "2004-002-0000";
	public String XRANGE_END = "2004-005-0000";
	//public static String GRAPH_SIZE = "1024,600";
	public static String GRAPH_SIZE = "1536,900";

	public static boolean SKIP_LINES_TRUE = true;
	public static boolean SKIP_LINES_FALSE = false;



	public static String SUEWS_id_it = "1";
	//public static String SUEWS_it = "2";
	public static String SUEWS_dectime = "2";
	public static String SUEWS_kdown = "3";
	public static String SUEWS_kup = "4";
	public static String SUEWS_ldown = "5";
	public static String SUEWS_lup = "6";
	public static String SUEWS_Tsurf = "7";
	public static String SUEWS_qn = "8";
	public static String SUEWS_h_mod = "9";
	public static String SUEWS_e_mod = "10";
	public static String SUEWS_qs = "11";
	public static String SUEWS_QF = "12";
	public static String SUEWS_QH = "13";
	public static String SUEWS_QE = "14";
	public static String SUEWS_P_i = "15";
	public static String SUEWS_Ie_i = "16";
	public static String SUEWS_E_i = "17";
	public static String SUEWS_DR_i = "18";
	public static String SUEWS_Ch_i = "19";
	public static String SUEWS_ST_i = "20";
	public static String SUEWS_ROsoil_i = "21";
	public static String SUEWS_RO_i = "22";
	public static String SUEWS_ROpipe = "23";
	public static String SUEWS_ROpav = "24";
	public static String SUEWS_ROveg = "25";
	public static String SUEWS_ROwater = "26";
	public static String SUEWS_RA = "27";
	public static String SUEWS_RS = "28";
	public static String SUEWS_ustar = "29";
	public static String SUEWS_L_mod = "30";
	public static String SUEWS_SoilSt_pav = "31";
	public static String SUEWS_SoilSt_blg = "32";
	public static String SUEWS_SoilSt_con = "33";
	public static String SUEWS_SoilSt_dec = "34";
	public static String SUEWS_SoilSt_Irrgr = "35";
	public static String SUEWS_SoilSt_Gr = "36";
	public static String SUEWS_St_pav = "37";
	public static String SUEWS_St_blg = "38";
	public static String SUEWS_St_con = "39";
	public static String SUEWS_St_dec = "40";
	public static String SUEWS_St_Irrgr = "41";
	public static String SUEWS_St_Gr = "42";
	public static String SUEWS_St_water = "43";
	public static String SUEWS_Fcld = "44";
	public static String SUEWS_SoilState = "45";
	public static String SUEWS_smd = "46";
	public static String SUEWS_LAI = "47";
	public static String SUEWS_Fw = "48";
	public static String SUEWS_addWater = "49";
	public static String SUEWS_FormattedDate = "50";

//	public static String SUEWS_STR_id_it = "id_it";
//	//public static String SUEWS_it = "2";
//	public static String SUEWS_STR_dectime = "dectime";
//	public static String SUEWS_STR_kdown = "kdown";
//	public static String SUEWS_STR_kup = "kup";
//	public static String SUEWS_STR_ldown = "ldown";
//	public static String SUEWS_STR_lup = "lup";
//	public static String SUEWS_STR_Tsurf = "Tsurf";
//	public static String SUEWS_STR_qn = "qn";
//	public static String SUEWS_STR_h_mod = "h_mod";
//	public static String SUEWS_STR_e_mod = "e_mod";
//	public static String SUEWS_STR_qs = "qs";
//	public static String SUEWS_STR_QF = "QF";
//	public static String SUEWS_STR_QH = "QH";
//	public static String SUEWS_STR_QE = "QE";
//	public static String SUEWS_STR_P_i = "P_i";
//	public static String SUEWS_STR_Ie_i = "Ie_i";
//	public static String SUEWS_STR_E_i = "E_i";
//	public static String SUEWS_STR_DR_i = "DR_i";
//	public static String SUEWS_STR_Ch_i = "Ch_i";
//	public static String SUEWS_STR_ST_i = "ST_i";
//	public static String SUEWS_STR_ROsoil_i = "ROsoil_i";
//	public static String SUEWS_STR_RO_i = "RO_i";
//	public static String SUEWS_STR_ROpipe = "ROpipe";
//	public static String SUEWS_STR_ROpav = "ROpav";
//	public static String SUEWS_STR_ROveg = "ROveg";
//	public static String SUEWS_STR_ROwater = "26";
//	public static String SUEWS_STR_RA = "27";
//	public static String SUEWS_STR_RS = "28";
//	public static String SUEWS_STR_ustar = "29";
//	public static String SUEWS_STR_L_mod = "30";
//	public static String SUEWS_STR_SoilSt_pav = "31";
//	public static String SUEWS_STR_SoilSt_blg = "32";
//	public static String SUEWS_STR_SoilSt_con = "33";
//	public static String SUEWS_STR_SoilSt_dec = "34";
//	public static String SUEWS_STR_SoilSt_Irrgr = "35";
//	public static String SUEWS_STR_SoilSt_Gr = "36";
//	public static String SUEWS_STR_St_pav = "37";
//	public static String SUEWS_STR_St_blg = "38";
//	public static String SUEWS_STR_St_con = "39";
//	public static String SUEWS_STR_St_dec = "40";
//	public static String SUEWS_STR_St_Irrgr = "41";
//	public static String SUEWS_STR_St_Gr = "42";
//	public static String SUEWS_STR_St_water = "43";
//	public static String SUEWS_STR_Fcld = "44";
//	public static String SUEWS_STR_SoilState = "45";
//	public static String SUEWS_STR_smd = "46";
//	public static String SUEWS_STR_LAI = "47";
//	public static String SUEWS_STR_Fw = "48";
//	public static String SUEWS_STR_addWater = "49";
//	public static String SUEWS_STR_FormattedDate = "50";

	public static String SUEWS_availableEnergy = "51";
	public static String SUEWS_dailyEnergyBalance = "52";
	public static String SUEWS_Rn_G_H_LE = "53";


	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		ArrayList<String> variableArray = new ArrayList<String>();
		ArrayList<String> suewsVariableNumberArray = new ArrayList<String>();
		ArrayList<String> prestonVariableNumberArray = new ArrayList<String>();

		SuewsPrestonComparisonGraphs suewsPrestonComparisonGraphs = new SuewsPrestonComparisonGraphs();

		String graphDir = Messages.getString("SuewsPrestonComparisonGraphs.graph_dir");

		String prestonPath = Messages.getString("PrestonDataFile.DATA_PATH");
		String prestonFilename = Messages.getString("PrestonDataFile.DATA_FILE");

		PrestonDataFile prestonDataFile = new PrestonDataFile(prestonPath, prestonFilename, true);
		prestonDataFile.setPath(graphDir);
		suewsPrestonComparisonGraphs.generateReformattedPrestonDataFile(prestonDataFile);
		//TreeMap<String, ArrayList<String>> theData = prestonDataFile.getData();
		//System.out.println(theData.get(prestonDataFile.FORMATTED_DATE).toString());


		String suewsPath = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DATA_PATH");
		String suewsFilename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_60_FILE");

		ProcessSUEWSRun processSUEWSRun = new ProcessSUEWSRun();
		SUEWSDataFile suewsDataFile = new SUEWSDataFile(suewsPath, suewsFilename, SKIP_LINES_TRUE, SUEWSDataFile.LINES_TO_SKIP_60);
		suewsDataFile.setPath(graphDir);
		processSUEWSRun.generateReformattedDataFile(suewsDataFile);
		//String timeField = "dectime";
		String variable = "kdown";
		String suewsTimeField = SUEWS_FormattedDate;
		String prestonTimeField = PrestonDataFile.PRESTON_FormattedDate;
		String suewsVariableNumber = "3";
		String prestonVariableNumber = "7";
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "Tsurf";
		suewsVariableNumber = SUEWS_Tsurf;
		prestonVariableNumber =  PrestonDataFile.PRESTON_Temp ;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);

//		public static String SUEWS_availableEnergy = "availableEnergy";
//		public static String SUEWS_dailyEnergyBalance = "dailyEnergyBalance";
//		public static String SUEWS_Rn_G_H_LE = "Rn_G_H_LE";
//
//		public static String SUEWS_availableEnergy = "51";
//		public static String SUEWS_dailyEnergyBalance = "52";
//		public static String SUEWS_Rn_G_H_LE = "53";

		ArrayList<String> energyVariableArray = new ArrayList<String>();
		ArrayList<String> energyVariableNumberArray = new ArrayList<String>();
		energyVariableArray.add(SUEWSDataFile.SUEWS_availableEnergy);
		energyVariableNumberArray.add(SUEWS_availableEnergy);
		//prestonVariableNumber =  PRESTON_Temp ;
		//suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);

		energyVariableArray.add(SUEWSDataFile.SUEWS_dailyEnergyBalance);
		energyVariableNumberArray.add(SUEWS_dailyEnergyBalance);
		//prestonVariableNumber =  PRESTON_Temp ;
		//suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);

//		energyVariableArray.add(SUEWSDataFile.SUEWS_Rn_G_H_LE);
//		energyVariableNumberArray.add(SUEWS_Rn_G_H_LE);
//		//prestonVariableNumber =  PRESTON_Temp ;
//		//suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);

		suewsPrestonComparisonGraphs.plotDataMultiples(suewsDataFile, energyVariableArray, energyVariableNumberArray, SUEWS_FormattedDate, "energyBalance");


		ArrayList<String> prestonEnergyVariableNumberArray = new ArrayList<String>();
		prestonEnergyVariableNumberArray.add(PrestonDataFile.PRESTON_EnergyBalance);
		ArrayList<String> suewsEnergyVariableNumberArray = new ArrayList<String>();
		suewsEnergyVariableNumberArray.add(SUEWS_dailyEnergyBalance);

		ArrayList<String> energyVariableArray2 = new ArrayList<String>();
		energyVariableArray2.add(SUEWSDataFile.SUEWS_dailyEnergyBalance);


		suewsPrestonComparisonGraphs.plotDataMultiples(suewsDataFile, energyVariableArray2, prestonDataFile,
				suewsEnergyVariableNumberArray, prestonEnergyVariableNumberArray,
											suewsTimeField, prestonTimeField, "EnergyBalanceComp");


		variable = "QH";
		suewsVariableNumber =  SUEWS_QH;
		//suewsVariableNumber =  SUEWS_h_mod;
		prestonVariableNumber = PrestonDataFile.PRESTON_QH;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "QE";
		suewsVariableNumber = SUEWS_QE;
		//suewsVariableNumber = SUEWS_e_mod;
		prestonVariableNumber = PrestonDataFile.PRESTON_QE;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "QG";
		suewsVariableNumber = SUEWS_qs;
		prestonVariableNumber = PrestonDataFile.PRESTON_QG;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "kup";
		suewsVariableNumber = SUEWS_kup;
		prestonVariableNumber = PrestonDataFile.PRESTON_Kup;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "lup";
		suewsVariableNumber = SUEWS_lup;
		prestonVariableNumber = PrestonDataFile.PRESTON_Lup;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "ldown";
		suewsVariableNumber = SUEWS_ldown;
		prestonVariableNumber = PrestonDataFile.PRESTON_Ldown;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "net";
		suewsVariableNumber = SUEWS_qn;
		prestonVariableNumber = PrestonDataFile.PRESTON_NET;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);
		variableArray.add(variable);
		suewsVariableNumberArray.add(suewsVariableNumber);
		prestonVariableNumberArray.add(prestonVariableNumber);

		variable = "Anthrop";
		suewsVariableNumber = SUEWS_QF;
		prestonVariableNumber = PrestonDataFile.PRESTON_Anthrop;
		suewsPrestonComparisonGraphs.plotData(suewsDataFile, variable, prestonDataFile, suewsVariableNumber, prestonVariableNumber, suewsTimeField, prestonTimeField);

		suewsPrestonComparisonGraphs.plotDataMultiples(suewsDataFile, variableArray, prestonDataFile, suewsVariableNumberArray, prestonVariableNumberArray, suewsTimeField, prestonTimeField, "EnergyBalance");

//----------------------------------

		String path = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DATA_PATH");
		String filename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_NARP_FILE");

		ArrayList<String> variableArray2 = new ArrayList<String>();
		ArrayList<String> suewsVariableNumberArray2 = new ArrayList<String>();

		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_kup_pav);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_kup_pav);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_kup_blg);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_kup_blg);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_kup_con);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_kup_con);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_kup_dec);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_kup_dec);

		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_kup_Irrgr);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_kup_Irrgr);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_kup_Gr);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_kup_Gr);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_kup_wtr);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_kup_wtr);

		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_lup_pav);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_lup_pav);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_lup_blg);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_lup_blg);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_lup_con);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_lup_con);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_lup_dec);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_lup_dec);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_lup_Irrgr);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_lup_Irrgr);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_lup_Gr);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_lup_Gr);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_lup_wtr);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_lup_wtr);

		SUEWSDataFile sUEWSDataFile = new SUEWSDataFile(path, filename, SKIP_LINES_TRUE, SUEWSDataFile.LINES_TO_SKIP_NARP);
		sUEWSDataFile.setPath(graphDir);
		String dayFieldNarpFile = SUEWSDataFile.SUEWS_NARP_STR_day;
		String timeFieldNarpFile = SUEWSDataFile.SUEWS_NARP_STR_dectime;
		processSUEWSRun.generateReformattedGenericDataFile(sUEWSDataFile, dayFieldNarpFile, timeFieldNarpFile);
		suewsPrestonComparisonGraphs.plotDataMultiples(sUEWSDataFile, variableArray2, suewsVariableNumberArray2, SUEWSDataFile.SUEWS_NARP_REFORMAT_FormattedDate, "NARP_K_L");

		variableArray2.clear();
		suewsVariableNumberArray2.clear();
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_Ts_pav);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_Ts_pav);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_Ts_blg);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_Ts_blg);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_Ts_con);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_Ts_con);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_Ts_dec);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_Ts_dec);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_Ts_Irrgr);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_Ts_Irrgr);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_Ts_Gr);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_Ts_Gr);
		//variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_Ts_wtr);
		//suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_Ts_wtr);
		suewsPrestonComparisonGraphs.plotDataMultiples(sUEWSDataFile, variableArray2, suewsVariableNumberArray2, SUEWSDataFile.SUEWS_NARP_REFORMAT_FormattedDate, "NARP_T");

		variableArray2.clear();
		suewsVariableNumberArray2.clear();
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_qn_pav);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_qn_pav);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_qn_blg);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_qn_blg);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_qn_con);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_qn_con);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_qn_dec);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_qn_dec);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_qn_Irrgr);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_qn_Irrgr);
		variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_qn_Gr);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_qn_Gr);
		//variableArray2.add(SUEWSDataFile.SUEWS_NARP_STR_qn_wtr);
		//suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_NARP_qn_wtr);
		suewsPrestonComparisonGraphs.plotDataMultiples(sUEWSDataFile, variableArray2, suewsVariableNumberArray2, SUEWSDataFile.SUEWS_NARP_REFORMAT_FormattedDate, "NARP_Q");

// ----------------------------------

		suewsPrestonComparisonGraphs.setXRANGE_END("2004-055-0000");

		path = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DATA_PATH");
		filename = Messages.getString("ProcessSUEWSRun.SUEWS_OUTPUT_DAILY_FILE");

		sUEWSDataFile = new SUEWSDataFile(path, filename, SKIP_LINES_FALSE, SUEWSDataFile.LINES_TO_SKIP_DAILY_FILE);
		sUEWSDataFile.setPath(graphDir);
		String dayFieldDailyFile = SUEWSDataFile.SUEWS_DAILY_FILE_STR_day;
		String timeFieldDailyFile = SUEWSDataFile.SUEWS_DAILY_FILE_STR_counter;
		processSUEWSRun.generateReformattedGenericDataFile(sUEWSDataFile, dayFieldDailyFile, timeFieldDailyFile);

		variableArray2 = new ArrayList<String>();
		suewsVariableNumberArray2 = new ArrayList<String>();

		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_qn);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_qn);
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_qs);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_qs);
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_qf);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_qf);
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_qe_S);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_qe_S);
		suewsPrestonComparisonGraphs.plotDataMultiples(sUEWSDataFile, suewsVariableNumberArray2, variableArray2, SUEWSDataFile.SUEWS_DAILY_FILE_FormattedDate, "DAILY_Q");

		variableArray2.clear();
		suewsVariableNumberArray2.clear();
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_ext_Ie);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_ext_Ie);
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_int_Ie);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_int_Ie);
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_tot_ie);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_tot_ie);
		suewsPrestonComparisonGraphs.plotDataMultiples(sUEWSDataFile, suewsVariableNumberArray2, variableArray2, SUEWSDataFile.SUEWS_DAILY_FILE_FormattedDate, "DAILY_IE");

		variableArray2.clear();
		suewsVariableNumberArray2.clear();
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_R_Soil);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_R_Soil);
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_R);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_R);
		suewsPrestonComparisonGraphs.plotDataMultiples(sUEWSDataFile, suewsVariableNumberArray2, variableArray2, SUEWSDataFile.SUEWS_DAILY_FILE_FormattedDate, "DAILY_R");

		variableArray2.clear();
		suewsVariableNumberArray2.clear();
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_E_S);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_E_S);
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_Change);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_Change);
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_Fw);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_Fw);
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_addWater);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_addWater);
		variableArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_pp);
		suewsVariableNumberArray2.add(SUEWSDataFile.SUEWS_DAILY_FILE_STR_pp);
		suewsPrestonComparisonGraphs.plotDataMultiples(sUEWSDataFile, suewsVariableNumberArray2, variableArray2, SUEWSDataFile.SUEWS_DAILY_FILE_FormattedDate, "DAILY_VAR");

	}

	public void plotDataMultiples(SUEWSDataFile sUEWSDataFile, ArrayList<String> variableArray,
			ArrayList<String> suewsVariableNumberArray, String suewsTimeField, String graphPrefix)
	{
		String suewsDataFileName = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + ".gnuplot.dat";
		//String prestonDataFileName = prestonDataFile.getPath() + prestonDataFile.getFilename() + ".gnuplot.dat";
		String outputFile = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + "_" + graphPrefix + ".png";

		Plot.setGnuplotExecutable("gnuplot");
		String plotDirectory = sUEWSDataFile.getPath().substring(0, sUEWSDataFile.getPath().length()-1);
		Plot.setPlotDirectory(plotDirectory);
		Plot aPlot = new Plot();

		aPlot.setTitle("Plot for " + graphPrefix);
		aPlot.setGrid();
		aPlot.setKey("right box");
		aPlot.unsetParametric();
		aPlot.unsetPolar();
		aPlot.setOutput(Terminal.PNG, outputFile, " " + GRAPH_SIZE + "  enhanced font Vera 14 ");
		aPlot.unsetLogscale();
		aPlot.setYTics("nomirror");
//		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 pi 20");
//		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 pi 20");
//		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 pi 20");
//		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 pi 20");
//		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 pi 20");
//		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 pi 20");
//		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 pi 20");
//		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 pi 20");
//		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 pi 20");
//		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 pi 20");
//		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 pi 20");

		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 ");
		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 ");
		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 ");
		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 ");
		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 ");
		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 ");
		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 ");
		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 ");
		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 ");
		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 ");
		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 ");

		aPlot.addExtra("set tmargin 1");
		aPlot.addExtra("set bmargin 2");
		aPlot.addExtra("set lmargin 6");
		aPlot.addExtra("set rmargin 1");

		aPlot.addExtra("set xdata time");
		aPlot.addExtra("set timefmt '%Y-%j-%H%M'");
		aPlot.addExtra("set xrange [\"" + XRANGE_BEG + "\":\"" + XRANGE_END + "\"]");

		aPlot.addExtra("set dgrid3d 10,10,1");
		aPlot.addExtra("set ylabel \" " + graphPrefix + "\"");
		String xLabel = "Time";
		aPlot.addExtra("set xlabel \" " + xLabel + "\"");

		aPlot.setDataFileName(suewsDataFileName);

		for (int i=0;i<variableArray.size();i++)
		{
			String variable = variableArray.get(i);
			String suewsVariableNumber = suewsVariableNumberArray.get(i);
			//String prestonVariableNumber = prestonVariableNumberArray.get(i);

			aPlot.pushGraph(new Graph(suewsDataFileName, suewsTimeField + ":" + suewsVariableNumber, Axes.X1Y1, variable + "-SUEWS", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));
			//aPlot.pushGraph(new Graph(prestonDataFileName, prestonTimeField + ":" + prestonVariableNumber, Axes.X1Y1, variable + "-Preston", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));
		}

		try
		{
//			OutputStream stdin = null;
//		    InputStream stderr = null;
//		    InputStream stdout = null;
//		    String line;
			String plotCommand = aPlot.plot();
			plotCmd(plotCommand, plotDirectory);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void plotDataMultiples(SUEWSDataFile sUEWSDataFile, ArrayList<String> variableArray, PrestonDataFile prestonDataFile,
			ArrayList<String> suewsVariableNumberArray, ArrayList<String> prestonVariableNumberArray, String suewsTimeField, String prestonTimeField, String graphPrefix)
	{
		String suewsDataFileName = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + ".gnuplot.dat";
		String prestonDataFileName = prestonDataFile.getPath() + prestonDataFile.getFilename() + ".gnuplot.dat";
		String outputFile = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + "_" + graphPrefix + ".png";

		Plot.setGnuplotExecutable("gnuplot");
		String plotDirectory = sUEWSDataFile.getPath().substring(0, sUEWSDataFile.getPath().length()-1);
		Plot.setPlotDirectory(plotDirectory);
		Plot aPlot = new Plot();

		aPlot.setTitle("Plot for " + graphPrefix);
		aPlot.setGrid();
		aPlot.setKey("right box");
		aPlot.unsetParametric();
		aPlot.unsetPolar();
		aPlot.setOutput(Terminal.PNG, outputFile, " " + GRAPH_SIZE + "  enhanced font Vera 14 ");
		aPlot.unsetLogscale();
		aPlot.setYTics("nomirror");
//		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 pi 20");
//		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 pi 20");
//		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 pi 20");
//		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 pi 20");
//		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 pi 20");
//		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 pi 20");
//		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 pi 20");
//		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 pi 20");
//		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 pi 20");
//		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 pi 20");
//		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 pi 20");

		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 ");
		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 ");
		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 ");
		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 ");
		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 ");
		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 ");
		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 ");
		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 ");
		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 ");
		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 ");
		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 ");

		aPlot.addExtra("set tmargin 1");
		aPlot.addExtra("set bmargin 2");
		aPlot.addExtra("set lmargin 6");
		aPlot.addExtra("set rmargin 1");

		aPlot.addExtra("set xdata time");
		aPlot.addExtra("set timefmt '%Y-%j-%H%M'");
		aPlot.addExtra("set xrange [\"" + XRANGE_BEG + "\":\"" + XRANGE_END + "\"]");

		aPlot.addExtra("set dgrid3d 10,10,1");
		aPlot.addExtra("set ylabel \" " + graphPrefix + "\"");
		String xLabel = "Time";
		aPlot.addExtra("set xlabel \" " + xLabel + "\"");

		aPlot.setDataFileName(suewsDataFileName);

		for (int i=0;i<variableArray.size();i++)
		{
			String variable = variableArray.get(i);
			String suewsVariableNumber = suewsVariableNumberArray.get(i);
			String prestonVariableNumber = prestonVariableNumberArray.get(i);

			aPlot.pushGraph(new Graph(suewsDataFileName, suewsTimeField + ":" + suewsVariableNumber, Axes.X1Y1, variable + "-SUEWS", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));
			aPlot.pushGraph(new Graph(prestonDataFileName, prestonTimeField + ":" + prestonVariableNumber, Axes.X1Y1, variable + "-Preston", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));
		}

		try
		{
//			OutputStream stdin = null;
//		    InputStream stderr = null;
//		    InputStream stdout = null;
//		    String line;
			String plotCommand = aPlot.plot();
			plotCmd(plotCommand, plotDirectory);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public void plotData(SUEWSDataFile sUEWSDataFile, String variable, PrestonDataFile prestonDataFile,
			String suewsVariableNumber, String prestonVariableNumber, String suewsTimeField, String prestonTimeField)
	{
		String suewsDataFileName = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + ".gnuplot.dat";
		String prestonDataFileName = prestonDataFile.getPath() + prestonDataFile.getFilename() + ".gnuplot.dat";
		String outputFile = sUEWSDataFile.getPath() + sUEWSDataFile.getFilename() + "_" + variable + ".png";

		Plot.setGnuplotExecutable("gnuplot");
		String plotDirectory = sUEWSDataFile.getPath().substring(0, sUEWSDataFile.getPath().length()-1);
		Plot.setPlotDirectory(plotDirectory);
		Plot aPlot = new Plot();

		aPlot.setTitle("Plot for " + variable);
		aPlot.setGrid();
		aPlot.setKey("right box");
		aPlot.unsetParametric();
		aPlot.unsetPolar();
		aPlot.setOutput(Terminal.PNG, outputFile, " " + GRAPH_SIZE + "  enhanced font Vera 14 ");
		aPlot.unsetLogscale();
		aPlot.setYTics("nomirror");
//		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 pi 20");
//		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 pi 20");
//		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 pi 20");
//		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 pi 20");
//		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 pi 20");
//		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 pi 20");
//		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 pi 20");
//		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 pi 20");
//		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 pi 20");
//		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 pi 20");
//		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 pi 20");

		aPlot.addExtra("set style line 1 linecolor rgbcolor \"#0000AA\" lw 2 pt 1 ps 1 ");
		aPlot.addExtra("set style line 2 linecolor rgbcolor \"#990000\" lw 2 pt 2 ps 1 ");
		aPlot.addExtra("set style line 3 linecolor rgbcolor \"#52015b\" lw 2 pt 3 ps 1 ");
		aPlot.addExtra("set style line 4 linecolor rgbcolor \"#988f03\" lw 2 pt 4 ps 1 ");
		aPlot.addExtra("set style line 5 linecolor rgbcolor \"#be7400\" lw 2 pt 5 ps 1 ");
		aPlot.addExtra("set style line 6 linecolor rgbcolor \"#00AA00\" lw 2 pt 6 ps 1 ");
		aPlot.addExtra("set style line 7 linecolor rgbcolor \"#00b7be\" lw 2 pt 7 ps 1 ");
		aPlot.addExtra("set style line 8 linecolor rgbcolor \"#808080\" lw 2 pt 8 ps 1 ");
		aPlot.addExtra("set style line 9 linecolor rgbcolor \"#d26584\" lw 2 pt 9 ps 1 ");
		aPlot.addExtra("set style line 10 linecolor rgbcolor \"#000000\" lw 2 pt 10 ps 1 ");
		aPlot.addExtra("set style line 11 linecolor rgbcolor \"#AA0000\" lw 2 pt 11 ps 1 ");

		aPlot.addExtra("set tmargin 1");
		aPlot.addExtra("set bmargin 2");
		aPlot.addExtra("set lmargin 6");
		aPlot.addExtra("set rmargin 1");

		aPlot.addExtra("set xdata time");
		aPlot.addExtra("set timefmt '%Y-%j-%H%M'");
		aPlot.addExtra("set xrange [\"" + XRANGE_BEG + "\":\"" + XRANGE_END + "\"]");

		aPlot.addExtra("set dgrid3d 10,10,1");
		aPlot.addExtra("set ylabel \" " + variable + "\"");
		String xLabel = "Time";
		aPlot.addExtra("set xlabel \" " + xLabel + "\"");

		aPlot.setDataFileName(suewsDataFileName);
		aPlot.pushGraph(new Graph(suewsDataFileName, suewsTimeField + ":" + suewsVariableNumber, Axes.X1Y1, variable + "-SUEWS", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));
		aPlot.pushGraph(new Graph(prestonDataFileName, prestonTimeField + ":" + prestonVariableNumber, Axes.X1Y1, variable + "-Preston", Style.LINESPOINTS, LineType.NOT_SPECIFIED, PointType.NOT_SPECIFIED));


		try
		{
//			OutputStream stdin = null;
//		    InputStream stderr = null;
//		    InputStream stdout = null;
//		    String line;
			String plotCommand = aPlot.plot();
			plotCmd(plotCommand, plotDirectory);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void plotCmd(String plotCommand, String plotDirectory)
	{
		try
		{
			OutputStream stdin = null;
		    InputStream stderr = null;
		    InputStream stdout = null;
		    String line;

			String gnuplotScriptFile = plotCommand.replaceFirst("gnuplot", "");
			ProcessBuilder pb= new ProcessBuilder("/usr/bin/gnuplot", gnuplotScriptFile);
			pb.directory(new File(plotDirectory));
			Process p = pb.start();
			p.waitFor();

			stdin = p.getOutputStream ();
		    stderr = p.getErrorStream ();
		    stdout = p.getInputStream ();
		    BufferedReader brCleanUp = new BufferedReader (new InputStreamReader (stdout));
		    while ((line = brCleanUp.readLine ()) != null)
		    {
		        System.out.println ("[Stdout] " + line);
		    }
		    brCleanUp.close();
		    brCleanUp = new BufferedReader (new InputStreamReader (stderr));
		    while ((line = brCleanUp.readLine ()) != null)
		    {
		    	System.out.println ("[Stderr] " + line);
		    }
		    brCleanUp.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void generateReformattedPrestonDataFile(PrestonDataFile prestonDataFile)
	{
		StringBuffer outputStr = new StringBuffer("# ");

		ArrayList<String> variables = prestonDataFile.getVariables();
		//System.out.println (variables.toString());
		int count = 0;
		for (String variable : variables)
		{
			outputStr.append(variable + " ");
			count++;
		}
		outputStr.append('\n');


		TreeMap<String, ArrayList<String>> theData = prestonDataFile.getData();
		ArrayList<String> timeArray = theData.get("tau");

		for (int i = 0;i<timeArray.size()-1;i++)
		{
			count = 0;
			for (String variable : variables)
			{
				ArrayList<String> dataArray = theData.get(variable);
				if (dataArray == null)
				{
					//System.out.println("theData.get(variable)="+ variable);
					String variableValue = "?";
					outputStr.append(variableValue + " ");

				}
				else
				{
					//System.out.println(dataArray.toString());
					//System.out.println(variable + "=" + variable);
					String variableValue = dataArray.get(i);
					//System.out.println(variable + "=" + variableValue);
					outputStr.append(variableValue + " ");
				}
					count++;
//				}

			}
			outputStr.append('\n');
		}

		String dataFileName = prestonDataFile.getPath() + prestonDataFile.getFilename() + ".gnuplot.dat";
		common.writeFile(outputStr.toString(), dataFileName);
	}

	public String getXRANGE_BEG()
	{
		return XRANGE_BEG;
	}

	public void setXRANGE_BEG(String xRANGE_BEG)
	{
		XRANGE_BEG = xRANGE_BEG;
	}

	public String getXRANGE_END()
	{
		return XRANGE_END;
	}

	public void setXRANGE_END(String xRANGE_END)
	{
		XRANGE_END = xRANGE_END;
	}



}
