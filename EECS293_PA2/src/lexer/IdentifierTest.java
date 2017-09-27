package lexer;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class IdentifierTest {

	@Test
	public void test() {
		Token token = Token.of(Token.Type.ID, "A");
		LocationalToken locationalToken = new LocationalToken(token, 0);
		try {
			Identifier identifier = Identifier.Builder.build(locationalToken);
			assertEquals(identifier.getId(), "A");
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}

}
