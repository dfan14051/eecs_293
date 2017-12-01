package wireframe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GroupTest {

	Canvas canvas;
	TextBox textBox1;
	TextBox textBox2;
	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
		textBox1 = new TextBox(0, 0, null, canvas, 10, 20);
		textBox2 = new TextBox(1,1,null, canvas, 10, 20);
		canvas.add(textBox1);
		canvas.add(textBox2);
	}
	
	@Test
	public void groupTest() {
		Group group = new Group(0,0,null, canvas);
		assertTrue(group != null);
	}
	
	@Test
	public void addTest() {
		Group group = new Group(0,0,null,canvas);
		try {
			group.add(textBox1);
			assertEquals(1, group.components.size());
		} catch (LockedException e) {
			fail();
		}
	}
	
	@Test
	public void removeTest() {
		Group group = new Group(0,0,null,canvas);
		try {
			group.add(textBox1);
			group.remove(textBox1);
			assertEquals(0, group.components.size());
		} catch (LockedException e) {
			fail();
		}
	}
	
	@Test
	public void moveTest() {
		Group group = new Group(0,0,null,canvas);
		try {
			group.add(textBox1);
			group.move(1, 1);
			assertEquals(1, textBox1.x);
		} catch (LockedException e) {
			fail();
		}
	}
	
	@Test
	public void deleteTest() {
		Group group = new Group(0,0,null,canvas);
		try {
			group.add(textBox1);
			group.delete();
			assertEquals(1, canvas.components.size());
		} catch (LockedException e) {
			fail();
		}
	}
	
	@Test
	public void reOrderTest() {
		Group group = new Group(0,0,null,canvas);
		try {
			group.add(textBox1);
			group.add(textBox2);
			group.reOrder(textBox1, 1);
			assertEquals(1, group.components.indexOf(textBox1));
		} catch (LockedException e) {
			fail();
		}
	}
	

}
