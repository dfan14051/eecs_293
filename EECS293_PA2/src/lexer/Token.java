package lexer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class Token {

	public enum Type {
		NOT("not", false, false, emptyOptional()),
		AND("and", false, true, Optional.of(ParserException.ErrorCode.AND_EXPECTED)),
		OR("or", false, true, emptyOptional()),
		OPEN("\\(", false, false, Optional.of(ParserException.ErrorCode.OPEN_EXPECTED)),
		CLOSE("\\)", false, false, Optional.of(ParserException.ErrorCode.CLOSE_EXPECTED)),
		ID("[a-z]+", true, false, Optional.of(ParserException.ErrorCode.ID_EXPECTED)),
		NUMBER("-?\\d+", true, false, emptyOptional()),
		BINARYOP("\\+|-|\\*|\\/", true, false, emptyOptional()),
		WHITESPACE("\\s+", false, false, emptyOptional());
		
		private static final Optional<ParserException.ErrorCode> emptyOptional(){
			Optional<ParserException.ErrorCode> empty = Optional.empty();
			return empty;
		}
		
		
		private final String pattern;
		public String getPattern() {
			return pattern;
		}
		
		private final boolean hasData;
		public boolean getHasData() {
			return hasData;
		}
		
		private boolean isComplex;
		public boolean getIsComplex() {
			return isComplex;
		}
		
		private Optional<ParserException.ErrorCode> errorCode;
		public Optional<ParserException.ErrorCode> getErrorCode() {
			return errorCode;
		}
		
		Type(String pattern, boolean hasData, boolean isComplex, Optional<ParserException.ErrorCode> errorCode){
			this.pattern = pattern;
			this.hasData = hasData;
			this.isComplex = isComplex;
			this.errorCode = errorCode;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", data=" + data + "]";
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Builder other = (Builder) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (type != other.type)
				return false;
			return true;
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
