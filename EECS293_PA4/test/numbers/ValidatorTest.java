package numbers;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ValidatorTest {

	@Test
	public void validateArgumentsTest() {
		try {
			String[] args = {};
			Validator.validateArguments(args);
			fail();
		} catch (NumberException e) {
			assertEquals("NumberException BAD_ARGUMENTS", e.toString());
		}
	}
	
	@Test
	public void validateArgumentsGoodTest() {
		try {
			String[] args = {"arg"};
			Validator.validateArguments(args);
			assertTrue(true);
		} catch (NumberException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void validateNumberInputTest() {
		try {
			List<String> input = new LinkedList<>();
			Validator.validateNumberInput(input);
			fail();
		} catch (NumberException e) {
			assertEquals("NumberException BAD_NUMBER_INPUT", e.toString());
		}
	}
	
	@Test
	public void validateLinesTest() {
		try {
			List<String> input = new LinkedList<>();
			input.add("dummy");
			Validator.validateLines(input);
			fail();
		} catch (NumberException e) {
			assertEquals("NumberException INVALID_INPUT_FORMAT", e.toString());
		}
	}
	
	@Test
	public void validateDigitTest() {
		try {
			List<String> input = new LinkedList<>();
			input.add("abc");
			input.add("abc");
			input.add("abc");
			Validator.validateDigit(new Number(input));
			fail();
		} catch (NumberException e) {
			assertEquals("NumberException BAD_NUMBER", e.toString());
		}
	}
	
	@Test
	public void validateMatchesTestNoMatch() {
		try {
			List<Number> matches = new LinkedList<>();
			Validator.validateMatches(matches);
			fail();
		} catch (NumberException e) {
			assertEquals("NumberException BAD_NUMBER", e.toString());
		}
	}
	
	@Test
	public void validateMatchesTestManyMatch() {
		try {
			List<Number> matches = new LinkedList<>();
			matches.add(Number.EIGHT);
			matches.add(Number.NINE);
			Validator.validateMatches(matches);
			fail();
		} catch (NumberException e) {
			assertEquals("NumberException AMBIGUOUS_NUMBER", e.toString());
		}
	}
}
