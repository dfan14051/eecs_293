package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TextTest {
	Canvas canvas;
	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
	}
	@Test
	public void testNoArg() {
		TextBox textBox = new TextBox(0,0,null, canvas, 1,1);
		assertTrue(textBox != null);
	}
	@Test
	public void testArg() {
		TextBox textBox = new TextBox(0,0,null,canvas,1,1,Text.DEFAULT_ALIGNMENT);
		assertTrue(textBox != null);
	}
	@Test
	public void changeAlignnment() {
		TextBox textBox = new TextBox(0,0,null,canvas,1,1);
		textBox.changeAlignment(Text.Alignment.RIGHT);
		assertEquals(Text.Alignment.RIGHT, textBox.alignment);
	}

}
