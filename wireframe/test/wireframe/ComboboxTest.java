package wireframe;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ComboboxTest {
	Canvas canvas;
	List<String> choices;

	@Before
	public void setUp() {
		canvas = new Canvas(100, 200);
		choices = Arrays.asList("Test", "Choice");
	}

	@Test
	public void comboboxTest() {
		Combobox comboBox = new Combobox(10, 10, null, canvas, 10, 10, .5, choices);
		assertTrue(comboBox != null);
	}

}
