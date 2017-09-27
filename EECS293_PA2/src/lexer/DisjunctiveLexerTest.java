package lexer;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class DisjunctiveLexerTest {

	@Test
	public void correctDisjunctiveExpression() {
		DisjunctiveLexer lexer = new DisjunctiveLexer("(a and b) and c");
		try {
			assertEquals(lexer.nextValid().get().getType(), Token.Type.OPEN);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.ID);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.AND);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.ID);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.CLOSE);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.AND);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.ID);
			assertFalse(lexer.nextValid().isPresent());
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void incorrectDisjunctiveExpression() {
		DisjunctiveLexer lexer = new DisjunctiveLexer("(a and b) or c");
		try {
			assertEquals(lexer.nextValid().get().getType(), Token.Type.OPEN);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.ID);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.AND);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.ID);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.CLOSE);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.OR);
			assertEquals(lexer.nextValid().get().getType(), Token.Type.ID);
			assertFalse(lexer.nextValid().isPresent());
			fail("Exception expected");
		} catch (ParserException e) {
			assertThat(e.getErrorCode(), CoreMatchers.is(ParserException.ErrorCode.INVALID_TOKEN));
		}
	}

}
