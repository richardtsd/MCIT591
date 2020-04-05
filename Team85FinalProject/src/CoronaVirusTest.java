import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoronaVirusTest {

	@Test
	void testMostCaseCountry() {
		
		CoronaVirus myTest = new CoronaVirus ();
		myTest.readFile();
		myTest.processData();
		assertEquals (myTest.mostCaseCountry(), "US");
		
		
	}

}
