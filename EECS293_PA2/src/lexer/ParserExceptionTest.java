package lexer;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.hamcrest.CoreMatchers;

public class ParserExceptionTest {

	@Test
	public void verifyTest() {
		Optional<LocationalToken> optional = Optional.empty();
		try {
			ParserException.verify(optional);
			fail("Expected a ParserException to be thrown.");
		} catch (ParserException e) {
			assertThat(e.getErrorCode(), CoreMatchers.is(ParserException.ErrorCode.TOKEN_EXPECTED));
		}
	}
	
	@Test
	public void verifyEndTest() {
		Token token = Token.of(Token.Type.AND, null);
		LocationalToken locationalToken = new LocationalToken(token, 0);
		try {
			ParserException.verifyEnd(Optional.of(locationalToken));
			fail("Expected a ParserException to be thrown.");
		} catch (ParserException e) {
			assertThat(e.getErrorCode(), CoreMatchers.is(ParserException.ErrorCode.TRAILING_INPUT));
		}
	}

}
