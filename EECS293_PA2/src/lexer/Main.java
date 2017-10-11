package lexer;

import java.util.Optional;

public class Main {
	public static void main(String args[]) {
		if(args.length != 1) {
			System.err.println("Usage: java main inputString");
			return;
		}
		DisjunctiveLexer disjunctiveLexer = new DisjunctiveLexer(args[0]);
		try {
			Optional<LocationalToken> token = disjunctiveLexer.nextValid();
			ParserException.verify(token);
			System.out.println(DisjunctiveExpression.Builder.build(token.get(), disjunctiveLexer).conjunctiveRepresentation());
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}
}
