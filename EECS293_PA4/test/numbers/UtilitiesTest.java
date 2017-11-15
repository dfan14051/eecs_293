package numbers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilitiesTest {

	@Test
	public void readFileTest() {
		List<String> expected = Arrays.asList("abc", "def", "ghi");
		assertEquals(expected, Utilities.readFile("testInput"));
	}

	@Test
	public void getDigitsTest() {
		try {
			List<Number> expected = Arrays.asList(Number.ONE, Number.TWO, Number.THREE, Number.FOUR, Number.FIVE,
					Number.SIX, Number.SEVEN, Number.EIGHT, Number.NINE);
			List<String> lines = Arrays.asList("    _  _     _  _  _  _  _ ","  | _| _||_||_ |_   ||_||_|","  ||_  _|  | _||_|  ||_| _|");
			assertEquals(expected, Utilities.getDigits(lines));
		} catch (NumberException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void matchDigitsTestGood() {
		List<Number> digits = Arrays.asList(Number.ONE, Number.TWO, Number.THREE, Number.FOUR, Number.FIVE,
				Number.SIX, Number.SEVEN, Number.EIGHT, Number.NINE);
		assertEquals("123456789", Utilities.matchDigits(digits));
	}
	
	@Test
	public void matchDigitsTestBad() {
		List<Number> digits = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			List<String> lines = Arrays.asList("   ", "|_|", "|_|");
			Number digit = new Number(lines);
			digits.add(digit);
		}
		assertEquals("failure", Utilities.matchDigits(digits));
	}
	
	@Test
	public void matchDigitTestGoodMatch() {
		try {
			List<String> lines = Arrays.asList("   ", "|_|", "|_|");
			Number digit = new Number(lines);
			assertEquals("8", Utilities.matchDigit(digit, false).matchedDigit);
		} catch (NumberException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void matchDigitTestExactMatch() {
		try {
			assertEquals("1", Utilities.matchDigit(Number.ONE, false).matchedDigit);
		} catch (NumberException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void matchDigitTestBadDigit() {
		try {
			List<String> lines = Arrays.asList("|||","|||","|||");
			Number digit = new Number(lines);
			Utilities.matchDigit(digit, false);
			fail();
		} catch (NumberException e) {
			assertEquals("NumberException BAD_NUMBER", e.toString());
		}
	}
	
	@Test
	public void matchDigitTestAmbiguousDigit() {
		try {
			List<String> lines = Arrays.asList("   ","   ", "   ");
			Number digit = new Number(lines);
			Utilities.matchDigit(digit, false);
			fail();
		} catch (NumberException e) {
			assertEquals("NumberException AMBIGUOUS_NUMBER", e.toString());
		}
	}
	
	@Test
	public void checkExactMatchTestMatch() {
		assertTrue(Utilities.checkExactMatch(Number.EIGHT, Number.EIGHT));
	}
	
	@Test
	public void checkExactMatchBadMatch() {
		assertFalse(Utilities.checkExactMatch(Number.EIGHT, Number.ONE));
	}
}
