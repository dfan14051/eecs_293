package lexer;

import java.util.Optional;

public final class ParserException extends Exception {
	static final long serialVersionUID = 293;
	
	public enum ErrorCode {
		TOKEN_EXPECTED,
		INVALID_TOKEN,
		TRAILING_INPUT,
		AND_EXPECTED,
		OPEN_EXPECTED,
		CLOSE_EXPECTED,
		ID_EXPECTED
	}
	
	private final ErrorCode errorCode;
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	private final int location;
	public int getLocation() {
		return location;
	}
	
	ParserException(LocationalToken token, ErrorCode errorCode){
		this.errorCode = errorCode;
		this.location = token.getLocation();
	}
	
	ParserException(ErrorCode errorCode){
		this.errorCode = errorCode;
		this.location = -1;
	}

	@Override
	public String toString() {
		return "ParserException [errorCode=" + errorCode + ", location=" + location + "]";
	}
	
	public static void verify(Optional<LocationalToken> token) throws ParserException {
		if(!token.isPresent()) {
			throw new ParserException(ErrorCode.TOKEN_EXPECTED);
		}
	}
	
	public static void verifyEnd(Optional<LocationalToken> token) throws ParserException {
		if(token.isPresent()) {
			throw new ParserException(ErrorCode.TRAILING_INPUT);
		}
	}
	
	public final static void verify(Token.Type expectedType, LocationalToken token) throws ParserException{
		if(!token.getType().equals(expectedType)) {
			throw new ParserException(expectedType.getErrorCode().get());
		}
	}
}
