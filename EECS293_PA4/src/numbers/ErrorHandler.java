package numbers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorHandler {
	 static final Logger LOGGER = Logger.getLogger(NumberLogger.class.getName());
	
	static void setupErrorLogFile(File errorLog) {
		try {
			System.setErr(new PrintStream(new FileOutputStream(errorLog)));
		} catch (IOException e) {
			System.setErr(System.err);
		}
	}
	
	static void logError(NumberException e) {
        LOGGER.log(Level.SEVERE, e.getMessage(), e);
	}
}
