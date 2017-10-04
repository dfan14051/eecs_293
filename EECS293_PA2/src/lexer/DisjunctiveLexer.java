package lexer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public final class DisjunctiveLexer {
	public static final Set<Token.Type> VALID_TOKEN_TYPES = 
			new HashSet<Token.Type>(Arrays.asList(Token.Type.AND, Token.Type.ID, Token.Type.NOT, Token.Type.OPEN, Token.Type.CLOSE));
	
	public static final Set<Token.Type> INVALID_TOKEN_TYPES = 
			new HashSet<Token.Type>(Arrays.asList(Token.Type.OR, Token.Type.NUMBER, Token.Type.BINARYOP));

	private Lexer lexer;
	
	DisjunctiveLexer(String input){
		this.lexer = new Lexer(input);
	}
	
	public Optional<LocationalToken> nextValid() throws ParserException{
		return lexer.nextValid(VALID_TOKEN_TYPES, INVALID_TOKEN_TYPES);
	}
	
}
