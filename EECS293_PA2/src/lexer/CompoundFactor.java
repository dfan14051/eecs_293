package lexer;

import java.util.Optional;

public class CompoundFactor implements Factor{
	private final DisjunctiveExpression leftExpression;
	public DisjunctiveExpression getLeftExpression() {
		return leftExpression;
	}
	
	private final DisjunctiveExpression rightExpression;
	public DisjunctiveExpression getRightExpression() {
		return rightExpression;
	}
	
	private CompoundFactor(DisjunctiveExpression leftExpression, DisjunctiveExpression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
	
	public static final class Builder{
	
		public static final CompoundFactor build(LocationalToken token, DisjunctiveLexer lexer) throws ParserException{
			ParserException.verify(Token.Type.OPEN, token);
			DisjunctiveExpression leftExpression = buildExpression(lexer);
			Optional<LocationalToken> nextToken = buildToken(lexer);
			ParserException.verify(Token.Type.AND, nextToken.get());
			DisjunctiveExpression rightExpression = buildExpression(lexer);
			nextToken = buildToken(lexer);
			ParserException.verify(Token.Type.CLOSE, nextToken.get());
			return new CompoundFactor(leftExpression, rightExpression);
		}
		
		private static DisjunctiveExpression buildExpression(DisjunctiveLexer lexer) throws ParserException {
			Optional<LocationalToken> nextToken = buildToken(lexer);
			return DisjunctiveExpression.Builder.build(nextToken.get(), lexer);
		}
		
		private static Optional<LocationalToken> buildToken(DisjunctiveLexer lexer) throws ParserException{
			Optional<LocationalToken> Token = lexer.nextValid();
			ParserException.verify(Token);
			return Token;
		}
	
	}
	
	public ConjunctiveRepresentation conjunctiveRepresentation() {
		return new ConjunctiveRepresentation("(not " + leftExpression + " or not " + rightExpression + ")", true);
	}

	@Override
	public String toString() {
		return "(" + leftExpression + "and " + rightExpression + ")";
	}
	
	
}
