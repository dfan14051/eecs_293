package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeaderTest {
	Canvas canvas;
	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
	}
	@Test
	public void testNoArg() {
		Header header = new Header(10, 10, null, canvas, 10, 10);
		assertTrue(header != null);
	}
	@Test
	public void tesArg() {
		Header header = new Header(10, 10, null, canvas, 10, 10, Text.DEFAULT_ALIGNMENT);
		assertTrue(header != null);
	}
}
