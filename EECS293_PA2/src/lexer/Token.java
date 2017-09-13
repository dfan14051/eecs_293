package lexer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class Token {

	public enum Type {
		NOT("not", false),
		AND("and", false),
		OR("or", false),
		OPEN("(", false),
		CLOSE(")", false),
		ID("[a-z]+", true),
		NUMBER("	-?\\d+", true),
		BINARYOP("\\+|-|\\*|\\/", true),
		WHITESPACE("\\s+", false);
		
		private final String pattern;
		public String getPattern() {
			return pattern;
		}
		
		private final Boolean hasData;
		public Boolean getHasData() {
			return hasData;
		}
		
		Type(String pattern, Boolean hasData){
			this.pattern = pattern;
			this.hasData = hasData;
		}
	}
	
	private final Type type;
	public Type getType() {
		return type;
	}

	private final Optional<String> data;
	public Optional<String> getData() {
		return data;
	}
	
	public boolean equals(Object token) {
		if(this == token) {
			return true;
		}
		if(!(token instanceof Token)) {
			return false;
		}
		Token temp = (Token) token;
		return (temp.getType() == this.getType()) && (temp.getData().equals(this.getData()));
	}
	
	public int hashCode() {
		return this.getType().hashCode() + this.getData().hashCode();
	}
	
	public String toString() {
		if(this.getType().getHasData()) {
			return this.getData().get();
		}
		return this.getType().name();
	}
	
	private Token(Type type, Optional<String> data) {
		this.type = type;
		this.data = data;
	}
	
	private static class Builder {
		private final Type type;
		private final Optional<String> data;
		Builder(Type type, Optional<String> data){
			this.type = type;
			this.data = data;
		}
		
		private Token build() {
			return new Token(this.type, this.data);
		}
		
		public boolean equals(Object builder) {
			if(this == builder) {
				return true;
			}
			if(!(builder instanceof Builder)) {
				return false;
			}
			Builder temp = (Builder) builder;
			return (temp.type == this.type) && (temp.data.equals(this.data));
		}
		
		public int hashCode() {
			return this.type.hashCode() + this.data.hashCode();
		}
		
	}
	
	private static Map<Builder, Token> tokens = new HashMap<Builder, Token>();
	
	public static Token of (Type type, String data) {
		Builder builder = new Builder(type, Optional.ofNullable(data));
		if(tokens.containsKey(builder)) {
			return tokens.get(builder);
		}
		Token token = builder.build();
		tokens.put(builder, token);
		return token;
	}
}
