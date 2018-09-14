package software.testing.testdoubles;

/**
 * This class is a class with a method that we want to test both for 
 * the state change, i.e. check the result of the calculation, and
 * the interactions with the logger. We will use JUnit assert statements
 * to test the state and Mockito verify statements to test the 
 * interactions with the log. 
 * 
 * The state tests can be found in TestDataProcessor. The interaction 
 * tests can be found in TestDataProcessorLoggerBehaviour.
 * 
 * @author Neil Taylor (nst@aber.ac.uk) 
 */
public class DataProcessor {

	/** The logger to be used for storing log messages */
	private Logger logger = null; 
	
	/** 
	 * Creates a new instance of the processor and inserts the 
	 * logger that will be used. 
	 * 
	 * @param logger The logger. 
	 */
	public DataProcessor(Logger logger) { 
		this.logger = logger; 
	}
	
	/** 
	 * This method processes the given balance. If it is 100 or more, 
	 * it will be increased by 10. For example, if the input is 101,
	 * it will be returned as 111. If the balance is below 100, it will
	 * be increased by 1. For example, an input of 70 will be returned
	 * as 71. If the balance is below 0, the balance will be set to 0
	 * before the increase of 1 is applied.
	 *
	 * The method will log messages:
	 * <ul>
	 *     <li>A DEBUG message will be output each time this method is called</li>
	 *     <li>If the balance is less than 0, a WARNING message will be output</li>
	 *     <li>An INFO message is output to say which type of increase is made</li>
	 *     <li>A DEBUG message will be output before the method returns a value</li>
	 * </ul>
	 *
	 * @param balance The specified balance. 
	 * 
	 * @return The updated balance. 
	 */
	public int doSomeProcessing(int balance) { 
		
		logger.addMessage(LogLevel.DEBUG, 
				"starting processing with data: " + balance);

		if(balance < 0) {
			balance = 0;
			logger.addMessage(LogLevel.WARNING, "Balance is less than 0. Changed to 0");
		}
		
		// some statements here that do some processing of the data
		if(balance >= 100) { 
		   logger.addMessage(LogLevel.INFO, 
				   "value is more than 100, so added 1000");
		
		   balance += 10;
		}   
		else {
			logger.addMessage(LogLevel.INFO, "value is less than 100, so added 1");
			balance += 1;
		}
		
		logger.addMessage(LogLevel.DEBUG, "finished processing");
	    logger.flushMessages();
	    
	    return balance;
	}
	
}
