package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComponentTest {

	Canvas canvas;
	TextBox textBox;
	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
		textBox = new TextBox(0, 0, null, canvas, 10, 20);
		canvas.add(textBox);
	}
	
	@Test
	public void transformTest() {
		try {
			textBox.transform(1, 0);
			assertEquals(1, textBox.x);
		} catch (LockedException e) {
			fail();
		}
	}
	
	// Should have done this at the element/group level
	@Test
	public void sendToFront() {
		TextBox textBox2 = new TextBox(0, 2, null, canvas, 10, 20);
		canvas.add(textBox2);
		textBox2.sendToFront();
		assertEquals(1, canvas.components.indexOf(textBox));
	}
	
	@Test
	public void sendToBack() {
		TextBox textBox2 = new TextBox(0, 2, null, canvas, 10, 20);
		canvas.add(textBox2);
		textBox.sendToBack();
		assertEquals(1, canvas.components.indexOf(textBox));
	}
	
	@Test
	public void isLockedTest() {
		assertFalse(textBox.isLocked());
	}
	
	@Test
	public void toggleLockTest() {
		textBox.toggleLock();
		assertTrue(textBox.isLocked());
	}
	
	@Test
	public void verifyNotLockedTest() {
		textBox.toggleLock();
		try {
			textBox.verifyNotLocked();
			fail();
		} catch (LockedException e) {
			assertEquals("Locked", e.getMessage());
		}
	}
	
	@Test
	public void annotateTest() {
		try {
			textBox.annotate(new Annotation(0,0,textBox, 5, 5, "test"));
			assertTrue(textBox.annotation != null);
		} catch (LockedException e) {
			fail();
		}
	}
	
	@Test
	public void resizeAnnotationTest() {
		try {
			textBox.annotate(new Annotation(0,0,textBox, 5, 5, "test"));
			textBox.resizeAnnotation(0, 0);
			assertEquals(0, textBox.annotation.width);
		} catch (LockedException e) {
			fail();
		}
	}
	
	@Test
	public void toggleAnnotationDisplayedTest() {
		try {
			textBox.annotate(new Annotation(0,0,textBox, 5, 5, "test"));
			textBox.toggleAnnotationDisplayed();
			assertFalse(textBox.annotation.displayed);
		} catch (LockedException e) {
			fail();
		}
	}
	
	@Test
	public void alignAnnotationTest() {
		try {
			textBox.annotate(new Annotation(0,0,textBox, 5, 5, "test"));
			textBox.alignAnnotation(Text.Alignment.RIGHT);
			assertEquals(Text.Alignment.RIGHT, textBox.annotation.alignment);
		} catch (LockedException e) {
			fail();
		}
	}
	
	@Test
	public void deleteAnnotationTest() {
		try {
			textBox.annotate(new Annotation(0,0,textBox, 5, 5, "test"));
			textBox.deleteAnnotation();
			assertTrue(textBox.annotation == null);
		} catch (LockedException e) {
			fail();
		}
	}
	

}
