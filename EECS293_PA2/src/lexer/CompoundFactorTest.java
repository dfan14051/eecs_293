package lexer;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompoundFactorTest {

	@Test
	public void test() {
		Token token = Token.of(Token.Type.OPEN, null);
		LocationalToken locationalToken = new LocationalToken(token, 0);
		DisjunctiveLexer lexer = new DisjunctiveLexer("(a and b) and not c)");
		try {
			CompoundFactor compoundFactor = CompoundFactor.Builder.build(locationalToken, lexer);
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}

}
