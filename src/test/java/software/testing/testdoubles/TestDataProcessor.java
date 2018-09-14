package software.testing.testdoubles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * Some tests the functionality of the DataProcessor class.
 *  
 * @author Neil Taylor (nst@aber.ac.uk)
 *
 */
public class TestDataProcessor {

	@Test
	public void shouldProcessDataValueBelow100() {
		
		ConsoleLogger logger = new ConsoleLogger(); 
		DataProcessor processor = new DataProcessor(logger);
		
		int result = processor.doSomeProcessing(99); 
		
		assertEquals(100, result);
		
	}
	
	@Test
	public void shouldProcessDataValueOf100() {
		
		ConsoleLogger logger = new ConsoleLogger(); 
		DataProcessor processor = new DataProcessor(logger);
		
		int result = processor.doSomeProcessing(100); 
		
		assertEquals(110, result);
		
	}
	
	@Test
	public void shouldProcessDataValueOver100() {
		
		ConsoleLogger logger = new ConsoleLogger(); 
		DataProcessor processor = new DataProcessor(logger);
		
		int result = processor.doSomeProcessing(101); 
		
		assertEquals(111, result);
	}
	

}
