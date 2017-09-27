package lexer;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
	private static Pattern tokenPatterns = setTokenPattern();
	private final Matcher matcher;
	
	public Lexer(String input) {
		matcher = tokenPatterns.matcher(input);
	}
	
	public boolean hasNext() {
		return matcher.find();
	}
	
	public LocationalToken next() throws ParserException{
		for(Token.Type type : Token.Type.values()) {
			if(matcher.group(type.name()) != null) {
				String data = matcher.group();
				Token token = Token.of(type, data);
				int location = matcher.start();
				return new LocationalToken(token, location);
			}
		}
		throw new ParserException(ParserException.ErrorCode.TOKEN_EXPECTED);
	}
	
	public Optional<LocationalToken> nextValid(Set<Token.Type> validTypes, Set<Token.Type> invalidTypes) throws ParserException{
		while(this.hasNext()) {
			LocationalToken token = this.next();
			if(validTypes.contains(token.getType())) {
				return Optional.of(token);
			}
			if(invalidTypes.contains(token.getType())) {
				throw new ParserException(token, ParserException.ErrorCode.INVALID_TOKEN);
			}
		}
		return Optional.empty();
	}
	
	private static Pattern setTokenPattern() {
		List<String> joinStrings = new LinkedList<String>();
		for(Token.Type type : Token.Type.values()) {
			joinStrings.add(String.format("(?<%s>%s)", type.name(), type.getPattern()));
		}
		String expression = String.join("|", joinStrings);
		return Pattern.compile(expression);
	}
}
