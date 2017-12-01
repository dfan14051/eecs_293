package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoxTest {

	Canvas canvas;
	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
	}
	
	@Test
	public void boxTest() {
		Box box = new Box(10, 10, null, canvas, 10, 10, .5);
		assertTrue(box != null);
	}

}
