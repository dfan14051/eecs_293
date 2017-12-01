package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElementTest {

	Canvas canvas;
	TextBox textBox;
	
	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
		textBox = new TextBox(100, 200, null, canvas, 10, 20);
		canvas.add(textBox);
	}
	
	@Test
	public void deleteTest() {
		try {
			textBox.delete();
			assertEquals(0, canvas.components.size());
		} catch (LockedException e) {
			fail();
		}
	}
	
	@Test
	public void moveTest() {
		try {
			textBox.move(10, 20);
			assertTrue(textBox.x == 10 && textBox.y == 20);
		} catch (LockedException e) {
			fail();
		}
		
	}
	
	@Test
	public void resizeTest() {
		try {
			textBox.resize(10, 20);
			assertTrue(textBox.width == 10 && textBox.height == 20);
		} catch (LockedException e) {
			fail();
		}
	}

}
