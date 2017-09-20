package lexer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TokenTest {

	@Test
	public void andTest() {
		Token and = Token.of(Token.Type.AND, null);
		assertEquals(false, and.getData().isPresent());
		assertEquals("Token [type=AND, data=Optional.empty]", and.toString());
		
		Token and_2 = Token.of(Token.Type.AND, null);
		assertEquals(and, and_2);
	}
	
	@Test
	public void openTest() {
		Token open = Token.of(Token.Type.OPEN, null);
		assertEquals("\\(", open.getType().getPattern());
		assertEquals("Token [type=OPEN, data=Optional.empty]", open.toString());
	}
	
	@Test
	public void idTest() {
		Token id = Token.of(Token.Type.ID, "dmf98");
		assertEquals(true, id.getData().isPresent());
		assertEquals("dmf98", id.getData().get());
		assertEquals("Token [type=ID, data=Optional[dmf98]]", id.toString());
		
		Token id_2 = Token.of(Token.Type.ID, "notdmf98");
		assertEquals(true, id_2.getData().isPresent());
		assertEquals("notdmf98", id_2.getData().get());
		assertEquals("Token [type=ID, data=Optional[notdmf98]]", id_2.toString());
		
		Token id_3 = Token.of(Token.Type.ID, "dmf98");
		assertSame(id, id_3);
		assertNotEquals(id_2, id_3);
	}

}
