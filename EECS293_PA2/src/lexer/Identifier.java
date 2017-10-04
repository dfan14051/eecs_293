package lexer;

public final class Identifier implements Factor{
	private final String id;
	public String getId() {
		return id;
	}
	
	private Identifier(String id) {
		this.id = id;
	}
	
	public static final class Builder{

		public static final Identifier build(LocationalToken token) throws ParserException{
			ParserException.verify(Token.Type.ID, token);
			return new Identifier(token.getData().get());
		}

	}
	
	@Override
	public String toString() {
		return id;
	}

	public ConjunctiveRepresentation conjunctiveRepresentation() {
		return new ConjunctiveRepresentation(id, false);
	}
}
