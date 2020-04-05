import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This is the class which stores a line of data (times series data on total
 * case count)
 * 
 * @author USER
 *
 */
public class LineData {

	String countryRegionName;
	ArrayList<Integer> totalCaseCount = new ArrayList<Integer>();

	/**
	 * read information from one line of CSV file
	 * 
	 * @param inputData
	 */
	public void ReadInfo(String[] inputData) {
		this.countryRegionName = inputData[1];

		for (int i = 4; i < inputData.length; i++) {
			totalCaseCount.add(Integer.parseInt(inputData[i]));
		}

//		System.out.println(this.countryRegionName+totalCaseCount.get(70));
	}

}
