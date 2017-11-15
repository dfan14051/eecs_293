package numbers;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Fails on the server for some reason
 * @author david
 *
 */
public class MainTest {

	@Test
	public void aTest() {
		String[] args = {"hw10a.in.txt"};
		assertEquals("123456789", Main.tester(args));
	}
	
	@Test
	public void bTest() {
		String[] args = {"hw10b.in.txt"};
		assertEquals("ambiguous", Main.tester(args));
	}
	
	@Test
	public void cTest() {
		String[] args = {"hw10c.in.txt"};
		assertEquals("failure", Main.tester(args));
	}

	@Test
	public void dTest() {
		String[] args = {"hw10d.in.txt"};
		assertEquals("818888888", Main.tester(args));
	}
}
