package lexer;

import java.util.Optional;

public final class DisjunctiveExpression {
	private final Factor factor;
	public Factor getFactor() {
		return factor;
	}
	
	private final boolean positive;
	public boolean isPositive() {
		return positive;
	}
	
	private DisjunctiveExpression(Factor factor, boolean positive) {
		this.factor = factor;
		this.positive = positive;
	}
	
	public static final class Builder{

		public static final DisjunctiveExpression build(LocationalToken token, DisjunctiveLexer lexer) throws ParserException{
			boolean positive = (token.getType() != Token.Type.NOT);
			Factor factor;
			if(positive) {
				factor = buildFactor(token, lexer);
			}
			else {
				Optional<LocationalToken> nextToken = lexer.nextValid();
				ParserException.verify(nextToken);
				factor = buildFactor(nextToken.get(), lexer);
			}
			return new DisjunctiveExpression(factor, positive);
		}
		
		private static Factor buildFactor(LocationalToken token, DisjunctiveLexer lexer) throws ParserException{
			if(token.getType() == Token.Type.ID) {
				return Identifier.Builder.build(token);
			}
			else {
				return CompoundFactor.Builder.build(token, lexer);
			}
		}

	}
	
	public final DisjunctiveExpression negate() {
		return new DisjunctiveExpression(this.getFactor(), !this.isPositive());
	}
	
	private final boolean isPositiveRepresentation(boolean positive, ConjunctiveRepresentation conjunctiveRepresentation) {
		return (positive && !conjunctiveRepresentation.isNegation()) || (!positive && conjunctiveRepresentation.isNegation());
	}
	
	@Override
	public String toString() {
		if(positive) {
			return factor.toString();
		}
		else {
			return "not " + factor.toString();
		}
	}

	public final String conjunctiveRepresentation() {
		ConjunctiveRepresentation conjunctiveRepresentation = factor.conjunctiveRepresentation();
		if(isPositiveRepresentation(positive, conjunctiveRepresentation)) {
			return conjunctiveRepresentation.getRepresentation();
		}
		else {
			return "not " + conjunctiveRepresentation.getRepresentation();
		}
	}
	
}
