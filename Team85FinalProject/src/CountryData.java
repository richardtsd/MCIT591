import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * This is the class which stores times series data on total case count, incremental case count for various countries 
 * @author USER
 *
 */

public class CountryData {


	String countryRegionName;
	ArrayList <LocalDate> date = new ArrayList <LocalDate>();
	ArrayList <Integer> totalCaseCount = new ArrayList <Integer>();
	ArrayList <Integer> incrementalCaseCount = new ArrayList <Integer>();
	
	public CountryData(String key, ArrayList<Integer> arrayList) {
		this.countryRegionName=key;
		this.totalCaseCount = arrayList;
		this.incrementalCaseCount.add(0);
		
		for (int i=1;i<this.totalCaseCount.size();i++) {
			this.incrementalCaseCount.add(this.totalCaseCount.get(i)-this.totalCaseCount.get(i-1));
		}
		
		// TODO Auto-generated constructor stub
	}
	
	
	
}
