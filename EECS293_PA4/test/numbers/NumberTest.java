package numbers;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NumberTest {

	@Test
	public void test() {
		List<String> input = Arrays.asList("   ", "  |", "  |");
		Number number = new Number(input);
		String[] expectedSegments = {" ", " ", " ", " ", " ", "|", " ", " ", "|"};
		assertArrayEquals(expectedSegments, number.getSegments());
	}

}
