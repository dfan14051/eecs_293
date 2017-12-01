package wireframe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AnnotationTest {

	Canvas canvas;
	TextBox textBox;
	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
		textBox = new TextBox(0, 0, null, canvas, 10, 20);
		canvas.add(textBox);
	}
	
	@Test
	public void annotationTest() {
		Annotation annotation = new Annotation(10, 10, textBox, 5, 5, "Test");
		assertTrue(annotation != null);
	}
	
	@Test
	public void resizeTest() {
		Annotation annotation = new Annotation(10, 10, textBox, 5, 5, "Test");
		annotation.resize(1, 1);
		assertTrue(annotation.width == 1 && annotation.height == 1);
	}
	
	@Test 
	public void editTest() {
		Annotation annotation = new Annotation(10, 10, textBox, 5, 5, "Test");
		annotation.edit("new");
		assertTrue(annotation.message.equals("new"));
	}
	
	@Test
	public void isDisplayedTest() {
		Annotation annotation = new Annotation(10, 10, textBox, 5, 5, "Test");
		assertTrue(annotation.isDisplayed());
	}
	
	@Test
	public void toggleDisplayed() {
		Annotation annotation = new Annotation(10, 10, textBox, 5, 5, "Test");
		annotation.toggleDisplayed();
		assertFalse(annotation.displayed);
	}
	
	@Test
	public void align() {
		Annotation annotation = new Annotation(10, 10, textBox, 5, 5, "Test");
		annotation.align(Text.Alignment.RIGHT);
		assertTrue(annotation.alignment == Text.Alignment.RIGHT);
	}
	
	@Test
	public void move() {
		Annotation annotation = new Annotation(10, 10, textBox, 5, 5, "Test");
		annotation.move(0, 1);
		assertTrue(annotation.x == 0 && annotation.y == 1);
	}

}
