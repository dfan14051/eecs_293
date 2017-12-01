package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SliderTest {

	Canvas canvas;

	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
	}

	@Test
	public void sliderTestNoArgs() {
		Slider slider = new Slider(0, 0, null, canvas, 10, 10);
		assertTrue(slider != null);
	}

	@Test
	public void sliderTestArg() {
		Slider slider = new Slider(0, 0, null, canvas, 10, 10, true);
		assertTrue(slider != null);
	}
}
