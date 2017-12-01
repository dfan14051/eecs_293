package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParagraphTest {
	Canvas canvas;
	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
	}
	
	@Test
	public void paragraphTestNoArgument() {
		Paragraph paragraph = new Paragraph(0, 0, null, canvas, 10, 10);
		assertTrue(paragraph != null);
	}
	
	@Test
	public void paragraphTestArgument() {
		Paragraph paragraph = new Paragraph(0,0,null,canvas,10,10,Text.DEFAULT_ALIGNMENT);
		assertTrue(paragraph != null);
	}

}
