package lexer;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationalTokenTest {

	@Test
	public void andTokenTest() {
		Token and = Token.of(Token.Type.AND, null);
		LocationalToken locationalAnd = new LocationalToken(and, 12);
		assertEquals(false, locationalAnd.getData().isPresent());
	}

}
