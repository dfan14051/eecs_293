package lexer;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;

public class LexerTest {

	@Test
	public void inputTest() {
		String input = "(a COMMENT and \t b) or c";
		String[] outputTokens = {"OPEN","ID(a)","WHITESPACE", "WHITESPACE", "AND", "WHITESPACE", "ID(b)", "CLOSE", "WHITESPACE", "OR", "WHITESPACE", "ID(c)"};
		Lexer lexer = new Lexer(input);
		int counter = 0;
		while(lexer.hasNext()) {
			try {
				LocationalToken token = lexer.next();
				if(token.getType().getHasData()) {
					assertEquals(outputTokens[counter], String.format("%s(%s)", token.getType().name(), token.getData().get()));
				}
				else {
					assertEquals(outputTokens[counter], token.getType().name());
				}
				counter++;
			} catch (ParserException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		}
	}
	@Test
	public void validTest() {
		String input = "(a COMMENT and \t b) or c";
		Lexer lexer = new Lexer(input);
		Set<Token.Type> validTypes = new HashSet<Token.Type>();
		Set<Token.Type> invalidTypes = new HashSet<Token.Type>();
		validTypes.add(Token.Type.AND);
		try {
			Optional<LocationalToken> token = lexer.nextValid(validTypes, invalidTypes);
			assertEquals(token.get().getType(), Token.Type.AND);
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void complexityTest() {
		String input = "(a COMMENT and \t b) or c";
		Lexer lexer = new Lexer(input);
		int complexity = 0;
		while(lexer.hasNext()) {
			try {
				LocationalToken token = lexer.next();
				if (token.getType().getIsComplex()) {
					complexity++;
				}
			} catch (ParserException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		}
		assertEquals(complexity, 2);
	}
}
