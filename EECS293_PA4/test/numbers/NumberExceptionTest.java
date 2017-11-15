package numbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberExceptionTest {

	@Test
	public void test() {
		NumberException e = new NumberException(NumberException.ErrorCode.BAD_NUMBER);
		assertEquals("NumberException BAD_NUMBER", e.toString());
	}

}
