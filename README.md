# About this project
This project uses the [Mockito](https://site.mockito.org) mocking framework to show 
an example of creating tests based on behaviour. 

The project includes code that runs JUnit tests to check the functionality
of the code - see `TestConsoleLogger` and `TestDataProcessor`. These use the
assertion statements that are provided by [JUnit](https://junit.org/). 
The JUnit tests will check the state of the program. 

As the code in DataProcessor runs, it will make calls to a Logger object to store
some debugging information. That information is not available to the JUnit 
test cases. The `doSomeProcessing()` method makes those calls directly to the `Logger`. 

The `mokito` library lets us writes tests to check the functionality of the 
Logger. Does it receive the specified messages? 
Are they sent in the correct order?

# Building the Project
You can load this into your preferred IDE and run it. Use the facilities in your IDE 
to run the test phases. 

Instead of running this through the IDE, you can also run the tests from the 
command line using Maven. In the same folder as the `pom.xml` file, you can type `mvn test`. 
That will build the project and then run the tests. 

To run from the command line, you will need to download [Maven](http://maven.apache.org) 
and setup the path so that you can run the `mvn` command.


# Exercise
Look at the class `TestDataProcessorLoggerBehaviour`. There are some TODO item 
in the file. Follow the instructions on those TODO items.