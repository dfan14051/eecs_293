package numbers;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.junit.Test;

/*
 * Had 0 clue how to unit test these.
 * I'm just calling the method in a try catch and failing if catch
 */
public class ErrorHandlerTest {
	
	@Test
	public void setupErrorLogFileGoodFileTest() {
		try {
			File file = File.createTempFile("ErrorHandler", null);
			ErrorHandler.setupErrorLogFile(file);
			System.err.println("Test");
			// TODO: Fix this assert
			// assertEquals("",System.err.);
			assertTrue(true);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void setupErrorLogFileBadFileTest() {
		try {
			File file = new File("src");
			ErrorHandler.setupErrorLogFile(file);
			System.err.println("Test");
			// TODO: Fix this assert
			assertTrue(true);
		} catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void logErrorTest() {
		try {
			File file = File.createTempFile("ErrorHandler", null);
			ErrorHandler.setupErrorLogFile(file);
			ErrorHandler.logError(new NumberException(NumberException.ErrorCode.BAD_NUMBER));
		} catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
