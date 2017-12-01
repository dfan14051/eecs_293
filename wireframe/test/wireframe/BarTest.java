package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BarTest {

	Canvas canvas;

	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
	}

	@Test
	public void noArgTest() {
		Slider slider = new Slider(0, 0, null, canvas, 1, 1, false);
		assertTrue(slider != null);
	}

	@Test
	public void argTest() {
		Slider slider = new Slider(0, 0, null, canvas, 1, 1);
		assertTrue(slider != null);
	}
	
	@Test
	public void flipTest() {
		Slider slider = new Slider(0, 0, null, canvas, 1, 1);
		slider.flip();
		assertFalse(slider.verticalAlignment);
	}

}
