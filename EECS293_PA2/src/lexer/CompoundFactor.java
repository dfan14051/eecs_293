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
			Optional<LocationalToken> nextToken = lexer.nextValid();
			ParserException.verify(nextToken);
			DisjunctiveExpression leftExpression = DisjunctiveExpression.Builder.build(nextToken.get(), lexer);
			nextToken = lexer.nextValid();
			ParserException.verify(nextToken);
			ParserException.verify(Token.Type.AND, nextToken.get());
			nextToken = lexer.nextValid();
			ParserException.verify(nextToken);
			DisjunctiveExpression rightExpression = DisjunctiveExpression.Builder.build(nextToken.get(), lexer);
			nextToken = lexer.nextValid();
			ParserException.verify(nextToken);
			ParserException.verify(Token.Type.CLOSE, nextToken.get());
			return new CompoundFactor(leftExpression, rightExpression);
		}
	
	}

	@Override
	public String toString() {
		return "CompoundFactor [leftExpression=" + leftExpression + ", rightExpression=" + rightExpression + "]";
	}
	
	
}
