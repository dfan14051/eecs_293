package numbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static numbers.Constants.DEFAULT_FAILURE_MESSAGE;
import static numbers.Constants.DEFAULT_AMBIGUITY_MESSAGE;

public class Utilities {
	public static List<String> readFile(String fileName){
		ArrayList<String> lines = new ArrayList<>();
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String line;
			while((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
		} catch (IOException e) {
			// Fail hard if file can't be read
			e.printStackTrace();
			System.exit(1);
		}
		
		return lines;		
	}
	
	public static List<Number> getDigits(List<String> lines) throws NumberException{
		ArrayList<Number> digits = new ArrayList<>();
		ArrayList<List<String>> inputLists = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			inputLists.add(new ArrayList<String>());
		}
		Validator.validateLines(lines);
		Validator.validateNumberInput(lines);
		for(String line : lines) {
			for(int i = 0; i < line.length(); i += 3) {
				inputLists.get(i/3).add(line.substring(i, i + 3));
			}
		}
		for(List<String> list : inputLists) {
			Number digit = new Number(list);
			Validator.validateDigit(digit);
			digits.add(digit);
		}
		
		return digits;
	}
	
	public static String matchDigits(List<Number> digits){
		StringBuilder builder = new StringBuilder();
		boolean garbled = false;
	    	for(Number digit : digits) {
			try {
				MatchedDigit matchedDigit = matchDigit(digit, garbled);
				builder.append(matchedDigit.matchedDigit);
				garbled = matchedDigit.garbled;
			} catch (NumberException e) {
				if(e.getErrorCode() == NumberException.ErrorCode.AMBIGUOUS_NUMBER) {
					return DEFAULT_AMBIGUITY_MESSAGE;
				}
				else {
					return DEFAULT_FAILURE_MESSAGE;
				}
			}
		}
		return builder.toString();
	}
	
	public static MatchedDigit matchDigit(Number digit, boolean garbled) throws NumberException {
		ArrayList<Number> possibleMatches = new ArrayList<>(Number.NUMBERS);
		for(Number number : Number.NUMBERS) {
			if(checkExactMatch(digit, number)){
				return new MatchedDigit("" + number.getValue(), garbled);
			}
			for(int i = 0; i < 9; i++) {
				// If the segment in digit isn't a space or the same as the segment in number
				if(!digit.getSegments()[i].matches("[ "+ number.getSegments()[i] + "]")) {
					possibleMatches.remove(number);
				}
			}
		}
		Validator.validateMatches(possibleMatches);
		if(garbled) {
			throw new NumberException(NumberException.ErrorCode.BAD_NUMBER);
		}
		return new MatchedDigit("" + possibleMatches.get(0).getValue(), true);
	}

	public static boolean checkExactMatch(Number digit, Number number) {
		for(int i = 0; i < 9; i++) {
			if(!digit.getSegments()[i].equals(number.getSegments()[i])) {
				return false;
			}
		}
		return true;
	}
	
	static class MatchedDigit{
		MatchedDigit(String matchedDigit, boolean garbled){
			this.matchedDigit = matchedDigit;
			this.garbled = garbled;
		}
		String matchedDigit;
		boolean garbled;
	}
}
