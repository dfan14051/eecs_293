package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PictureTest {
	Canvas canvas;
	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
	}
	@Test
	public void pictureTest() {
		Picture picture = new Picture(10,10,null,canvas,10,10);
		assertTrue(picture != null);
	}

}
