package lexer;

import static org.junit.Assert.*;

import org.junit.Test;

public class DisjunctiveExpressionTest {

	@Test
	public void identifierTest() {
		DisjunctiveLexer lexer = new DisjunctiveLexer("a");
		Token token = Token.of(Token.Type.NOT, null);
		LocationalToken locationalToken = new LocationalToken(token, 0);
		try {
			DisjunctiveExpression disjunctiveExpression = DisjunctiveExpression.Builder.build(locationalToken, lexer);
			assertFalse(disjunctiveExpression.isPositive());
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void compoundFactorTest() {
		DisjunctiveLexer lexer = new DisjunctiveLexer("a and b )");
		Token token = Token.of(Token.Type.OPEN, null);
		LocationalToken locationalToken = new LocationalToken(token, 0);
		try {
			DisjunctiveExpression disjunctiveExpression = DisjunctiveExpression.Builder.build(locationalToken, lexer);
			assertTrue(disjunctiveExpression.isPositive());
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void conjunctiveRepresentationIdentifierTest() {
		DisjunctiveLexer lexer = new DisjunctiveLexer("a");
		Token token = Token.of(Token.Type.NOT, null);
		LocationalToken locationalToken = new LocationalToken(token, 0);
		try {
			DisjunctiveExpression disjunctiveExpression = DisjunctiveExpression.Builder.build(locationalToken, lexer);
			assertEquals(disjunctiveExpression.conjunctiveRepresentation(), "not a");
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void conjunctiveRepresentationCompoundFactortest() {
		DisjunctiveLexer lexer = new DisjunctiveLexer("a and b )");
		Token token = Token.of(Token.Type.OPEN, null);
		LocationalToken locationalToken = new LocationalToken(token, 0);
		try {
			DisjunctiveExpression disjunctiveExpression = DisjunctiveExpression.Builder.build(locationalToken, lexer);
			assertEquals(disjunctiveExpression.conjunctiveRepresentation(), "not (not a or not b)");
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}

}
