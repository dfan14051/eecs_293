package numbers;

import static numbers.Constants.DEFAULT_LOG_FILE;
import static numbers.Constants.DEFAULT_FAILURE_MESSAGE;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			ErrorHandler.setupErrorLogFile(DEFAULT_LOG_FILE);
			Validator.validateArguments(args);
			List<String> lines = Utilities.readFile(args[0]);
			List<Number> digits = Utilities.getDigits(lines);
			String fullNumber = Utilities.matchDigits(digits);
			System.out.println(fullNumber);
		} catch (NumberException e) {
			if(e.getErrorCode() == NumberException.ErrorCode.BAD_ARGUMENTS) {
				ErrorHandler.logError(e);
				System.exit(1);
			}
			else{
				System.out.println(DEFAULT_FAILURE_MESSAGE);
			}
				
		}
	}
	
	//Test
	public static String tester(String[] args) {
		try {
			ErrorHandler.setupErrorLogFile(DEFAULT_LOG_FILE);
			Validator.validateArguments(args);
			List<String> lines = Utilities.readFile(args[0]);
			List<Number> digits = Utilities.getDigits(lines);
			String fullNumber = Utilities.matchDigits(digits);
			return fullNumber;
		} catch (NumberException e) {
			if(e.getErrorCode() == NumberException.ErrorCode.BAD_ARGUMENTS) {
				ErrorHandler.logError(e);
				System.exit(1);
			}
			else{
				return DEFAULT_FAILURE_MESSAGE;
			}
				
		}
		return "";
	}
}
