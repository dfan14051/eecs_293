package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TextBoxTest {
	Canvas canvas;

	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
	}

	@Test
	public void textBoxTestNoArgs() {
		TextBox textBox = new TextBox(0, 0, null, canvas, 10, 10);
		assertTrue(textBox != null);
	}

	@Test
	public void textBoxTestArg() {
		TextBox textBox = new TextBox(0, 0, null, canvas, 10, 10, Text.DEFAULT_ALIGNMENT);
		assertTrue(textBox != null);
	}

}
