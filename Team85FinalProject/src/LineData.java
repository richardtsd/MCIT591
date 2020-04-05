import java.time.LocalDate;
import java.util.ArrayList;

public class LineData {

	String countryRegionName;
	ArrayList <Integer> totalCaseCount = new ArrayList <Integer>();

	
	public void ReadInfo(String[] inputData){
		this.countryRegionName = inputData[1];
		

		
		for (int i=4; i<inputData.length; i++) {
			totalCaseCount.add(Integer.parseInt(inputData[i]));
		}
		
//		System.out.println(this.countryRegionName+totalCaseCount.get(70));
	}
	
	
}
