package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScrollBarTest {
	Canvas canvas;

	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
	}

	@Test
	public void scrollBarTestNoArgs() {
		ScrollBar scrollBar = new ScrollBar(0, 0, null, canvas, 10, 10);
		assertTrue(scrollBar != null);
	}

	@Test
	public void progressBarTestArg() {
		ScrollBar scrollBar = new ScrollBar(0, 0, null, canvas, 10, 10, true);
		assertTrue(scrollBar != null);
	}

}