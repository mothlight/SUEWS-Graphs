package au.edu.monash.ges.suews;

public class TestRH {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ENVICommon common = new ENVICommon();
		
		double t1 = 10;
		double rh1 = 10;
		double vapor = 2.4;
		//double t2 = 20;
		
		//common.CalculateH(t1, rh1, t2);
		//common.CalculateH(t1, rh1);
		double rh = common.CalculateRH(t1, vapor);
		System.out.println (rh);
		
		double rh2 = common.CalculateRH2(t1, vapor);
		System.out.println (rh2);

	}

}
