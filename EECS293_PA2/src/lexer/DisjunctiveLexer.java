package lexer;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public final class DisjunctiveLexer {
	public static final Set<Token.Type> VALID_TOKEN_TYPES = initializeValidTokenTypes();
	private static Set<Token.Type> initializeValidTokenTypes() {
		Set<Token.Type> validTokenTypes = new HashSet<Token.Type>();
		validTokenTypes.add(Token.Type.AND);
		validTokenTypes.add(Token.Type.ID);
		validTokenTypes.add(Token.Type.NOT);
		validTokenTypes.add(Token.Type.OPEN);
		validTokenTypes.add(Token.Type.CLOSE);
		return validTokenTypes;
	}
	
	public static final Set<Token.Type> INVALID_TOKEN_TYPES = initializeInvalidTokenTypes();
	private static Set<Token.Type> initializeInvalidTokenTypes() {
		Set<Token.Type> invalidTokenTypes = new HashSet<Token.Type>();
		invalidTokenTypes.add(Token.Type.OR);
		invalidTokenTypes.add(Token.Type.NUMBER);
		invalidTokenTypes.add(Token.Type.BINARYOP);
		return invalidTokenTypes;
	}
	
	private Lexer lexer;
	
	DisjunctiveLexer(String input){
		this.lexer = new Lexer(input);
	}
	
	public Optional<LocationalToken> nextValid() throws ParserException{
		return lexer.nextValid(VALID_TOKEN_TYPES, INVALID_TOKEN_TYPES);
	}
	
}
