import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CoronaVirus {



	ArrayList <LineData> allLineData = new ArrayList <LineData> ();
	ArrayList <CountryData> allCountryData = new ArrayList <CountryData> ();
	
	
	/**
	 * this method reads data from a CSV file
	 */
	public void readFile() {
		String filename = "time_series_covid19_confirmed_global.csv";
		File coronaVirusFile = new File(filename);


		
		try {
			Scanner fileReader = new Scanner(coronaVirusFile);
			fileReader.nextLine(); // skip the headings for now, store dates later
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine(); // read one line of data
				String lineElements[] = line.split(",");
				LineData currentLine = new LineData();
				currentLine.ReadInfo(lineElements);
				allLineData.add(currentLine);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	/**
	 * this method processes data, as some countries (such as Australia) have multiple lines in the original datafile, representing different provinces. This method aggregates the data for the entire country
	 */	
	public void processData() {
		HashMap<String, ArrayList<Integer>> countrytoTotalCount = new HashMap<String, ArrayList<Integer>>(); // some country have multiple lines
		for (LineData thisLine:allLineData) {
			String key = thisLine.countryRegionName;
			if (countrytoTotalCount.containsKey(key)) {
				
				ArrayList <Integer> tempData = new ArrayList <Integer> ();
				

				
				for (int i=0; i<countrytoTotalCount.get(key).size(); i++) {
					int tempCount = countrytoTotalCount.get(key).get(i);
					tempCount = tempCount + thisLine.totalCaseCount.get(i);
					tempData.add(tempCount);
				}
				
				countrytoTotalCount.put(key, tempData);
			} else {
				countrytoTotalCount.put(key, thisLine.totalCaseCount);
			} 
		}
		
		for (String key: countrytoTotalCount.keySet()) {
			CountryData thisCountryData = new CountryData (key, countrytoTotalCount.get(key));
			allCountryData.add(thisCountryData);
		}
		

	
	}
	
	
	public void printData() {
		for (int i=0;i<allCountryData.size();i++) {
			System.out.println(allCountryData.get(i).countryRegionName+" "+allCountryData.get(i).totalCaseCount.get(70)+" "+allCountryData.get(i).incrementalCaseCount.get(70));
		}
	}
}
