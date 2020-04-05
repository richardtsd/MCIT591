/**
 * This is the class which has the main method
 * 
 * @author USER
 *
 */

public class CoronaVirusRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoronaVirus myAnalysis = new CoronaVirus();
		myAnalysis.readFile();
		myAnalysis.processData();
		// myAnalysis.printData();

		System.out.println("Country with most coronavirus case is "+myAnalysis.mostCaseCountry());
		// myAnalysis.mostGrowthCountry();
	}

}
