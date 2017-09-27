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
			if(token.getType() == Token.Type.ID) {
				return new Identifier(token.getData().get());
			}
			else
				throw new ParserException(ParserException.ErrorCode.ID_EXPECTED);
		}

	}
	
	@Override
	public String toString() {
		return "Identifier [id=" + id + "]";
	}
}
