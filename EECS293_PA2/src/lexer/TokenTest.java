package lexer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TokenTest {

	@Test
	public void test() {
		Token and = Token.of(Token.Type.AND, null);
		assertEquals(false, and.getData().isPresent());
		assertEquals("AND", and.toString());
		
		Token open = Token.of(Token.Type.OPEN, null);
		assertEquals("(", open.getType().getPattern());
		assertEquals("OPEN", open.toString());
		
		Token and_2 = Token.of(Token.Type.AND, null);
		assertEquals(and, and_2);
		
		Token id = Token.of(Token.Type.ID, "dmf98");
		assertEquals(true, id.getData().isPresent());
		assertEquals("dmf98", id.getData().get());
		assertEquals("dmf98", id.toString());
		
		Token id_2 = Token.of(Token.Type.ID, "notdmf98");
		assertEquals(true, id_2.getData().isPresent());
		assertEquals("notdmf98", id_2.getData().get());
		assertEquals("notdmf98", id_2.toString());
		
		Token id_3 = Token.of(Token.Type.ID, "dmf98");
		assertSame(id, id_3);
		assertNotEquals(id_2, id_3);
	}

}
