package lexer;

import java.util.Optional;

public final class LocationalToken {
	
	private final Token token;
	public Token getToken() {
		return token;
	}
	
	private final int location;
	public int getLocation() {
		return location;
	}
	
	LocationalToken(Token token, int location){
		this.token = token;
		this.location = location;
	}
	
	public Token.Type getType() {
		return token.getType();
	}
	
	public Optional<String> getData() {
		return token.getData();
	}
	
}
