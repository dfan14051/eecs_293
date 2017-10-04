package lexer;

public class Main {
	public static void main(String args[]) {
		if(args.length != 1) {
			System.err.println("Usage: java main inputString");
			return;
		}
		String[] inputStrings = args[0].split(" ",2);
		Lexer lexer = new Lexer(inputStrings[0]);
		try {
			LocationalToken token = lexer.next();
			DisjunctiveLexer disjunctiveLexer = new DisjunctiveLexer(inputStrings[1]);
			System.out.println(DisjunctiveExpression.Builder.build(token, disjunctiveLexer).conjunctiveRepresentation());
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}
}
