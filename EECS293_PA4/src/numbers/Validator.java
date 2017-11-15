package numbers;

import java.util.List;

public class Validator {
	
	public static void validateArguments(String[] args) throws NumberException {
		if(args.length != 1) {
			throw new NumberException(NumberException.ErrorCode.BAD_ARGUMENTS);
		}
	}
	
	public static void validateNumberInput(List<String> input) throws NumberException {
		if(input.size() != 3) {
			throw new NumberException(NumberException.ErrorCode.BAD_NUMBER_INPUT);
		}
	}
	
	public static void validateLines(List<String> lines) throws NumberException {
		for(String line : lines) {
			if(line.length() != 27) {
				throw new NumberException(NumberException.ErrorCode.INVALID_INPUT_FORMAT);
			}
		}
	}
	
	public static void validateDigit(Number digit) throws NumberException {
		for(String segment : digit.getSegments()) {
			if(!segment.matches("[ |_]")) {
				throw new NumberException(NumberException.ErrorCode.BAD_NUMBER);
			}
		}
	}
	
	public static void validateMatches(List<Number> matches) throws NumberException {
		if(matches.size() == 0) {
			throw new NumberException(NumberException.ErrorCode.BAD_NUMBER);
		}
		if(matches.size() > 1) {
			throw new NumberException(NumberException.ErrorCode.AMBIGUOUS_NUMBER);
		}
	}
	
}
