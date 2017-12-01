package wireframe;

import static org.junit.Assert.*;

import org.junit.Test;

public class CanvasTest {

	@Test
	public void stressTest() {
		Canvas canvas = new Canvas(100, 200);
		for (int i = 0; i < 5000; i++) {
			canvas.add(new TextBox(100, 200, null, canvas, 10, 20));
			canvas.add(new Box(1, 2, null, canvas, 10, 20, 5));
		}
		for(int i = 0; i < 250; i++) {
			int index = (int) (Math.random() * 10000);
			canvas.components.get(index).sendToBack();
		}
		for(int i = 0; i < 250; i++) {
			int index = (int) (Math.random() * 10000);
			try {
				canvas.components.get(index).move(10, 20);
			} catch (LockedException e) {
				fail();
			}
		}
	}

	@Test
	public void canvasTest() {
		Canvas canvas = new Canvas(100, 200);
		assertTrue(canvas != null);
	}

	@Test
	public void addTest() {
		Canvas canvas = new Canvas(100, 200);
		TextBox textBox = new TextBox(100, 200, null, canvas, 10, 20);
		canvas.add(textBox);
		assertEquals(textBox, canvas.components.get(0));
	}

	@Test
	public void removeTest() {
		Canvas canvas = new Canvas(100, 200);
		TextBox textBox = new TextBox(100, 200, null, canvas, 10, 20);
		canvas.add(textBox);
		canvas.remove(textBox);
		assertEquals(0, canvas.components.size());
	}

	@Test
	public void sendToFrontTest() {
		Canvas canvas = new Canvas(100, 200);
		TextBox textBox1 = new TextBox(100, 200, null, canvas, 10, 20);
		TextBox textBox2 = new TextBox(50, 200, null, canvas, 10, 20);
		canvas.add(textBox1);
		canvas.add(textBox2);
		canvas.sendToFront(textBox2);
		assertEquals(textBox2, canvas.components.get(0));
	}

	@Test
	public void sendToBackTest() {
		Canvas canvas = new Canvas(100, 200);
		TextBox textBox1 = new TextBox(100, 200, null, canvas, 10, 20);
		TextBox textBox2 = new TextBox(50, 200, null, canvas, 10, 20);
		canvas.add(textBox1);
		canvas.add(textBox2);
		canvas.sendToBack(textBox1);
		assertEquals(textBox2, canvas.components.get(0));
	}

}
