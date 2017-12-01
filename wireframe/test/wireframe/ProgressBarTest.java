package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProgressBarTest {
	Canvas canvas;

	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
	}

	@Test
	public void progressBarTestNoArgs() {
		ProgressBar progressBar = new ProgressBar(0, 0, null, canvas, 10, 10);
		assertTrue(progressBar != null);
	}

	@Test
	public void progressBarTestArg() {
		ProgressBar progressBar = new ProgressBar(0, 0, null, canvas, 10, 10, true);
		assertTrue(progressBar != null);
	}

}
