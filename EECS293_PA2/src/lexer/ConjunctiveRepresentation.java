package lexer;

public final class ConjunctiveRepresentation {
	private final String representation;
	public final String getRepresentation() {
		return representation;
	}
	
	private final boolean negation;
	public final boolean isNegation() {
		return negation;
	}
	
	ConjunctiveRepresentation(String representation, boolean negation){
		this.representation = representation;
		this.negation = negation;
	}
}
