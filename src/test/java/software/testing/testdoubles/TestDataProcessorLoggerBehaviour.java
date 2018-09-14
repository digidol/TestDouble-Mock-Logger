package software.testing.testdoubles;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

/**
 * Some tests the interactions of the DataProcessor with the a Logger.
 * Mockito is used to provide a Mock Object implementation for the 
 * logger. 
 *  
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class TestDataProcessorLoggerBehaviour {

	@Test
	public void shouldCallDebugAndInfoLoggerDuringProcessing() {
		// Arrange 
		Logger mockedLogger = mock(Logger.class);
		
		DataProcessor processor = 
				new DataProcessor(mockedLogger); 
	
		// Act 
	    processor.doSomeProcessing(10);
	    
	    // Assert
	    verify(mockedLogger, times(2)).
	        addMessage(eq(LogLevel.DEBUG), anyString());
	    
	    verify(mockedLogger).
	        addMessage(eq(LogLevel.INFO), anyString()); 
	    
	    verify(mockedLogger).flushMessages();
	}
	
	@Test
	public void shouldCallDebugAndInfoLoggerSetNumberOfTimes() {
		
		Logger mockedLogger = mock(Logger.class);
		
		DataProcessor processor = 
				new DataProcessor(mockedLogger); 
	
	    processor.doSomeProcessing(10);
	    
	    verify(mockedLogger, times(1)).
	        addMessage(eq(LogLevel.DEBUG), eq("starting processing with data: 10"));
	    verify(mockedLogger, times(1)).
            addMessage(eq(LogLevel.DEBUG), eq("finished processing"));
	    verify(mockedLogger).
	        addMessage(eq(LogLevel.INFO), anyString()); 
	    verify(mockedLogger).flushMessages();
	}
	
	@Test
	public void shouldCallAddMessageBeforeFlushMessages() {
		
		Logger mockedLogger = mock(Logger.class);
		
		DataProcessor processor = new DataProcessor(mockedLogger); 
	
	    processor.doSomeProcessing(10);
	    
	    InOrder inOrder = inOrder(mockedLogger); 
	    
	    inOrder.verify(mockedLogger).addMessage(eq(LogLevel.DEBUG), anyString());
	    inOrder.verify(mockedLogger).addMessage(eq(LogLevel.INFO), anyString());
	    inOrder.verify(mockedLogger).flushMessages();

	    /*
        TODO: Uncomment the following line and try to run the test.
        What happens? Why does that happen?
        */
        //inOrder.verify(mockedLogger).addMessage(eq(LogLevel.DEBUG), anyString());
    }

    // TODO: Add in a test to check what messages are generated if a balance of -10 is
    // passed to the doSomeProcessing method.


}












