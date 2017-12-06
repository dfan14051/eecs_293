package wireframe;

import java.util.List;

/** 
 * Combobox component
 */
public class Combobox extends Box{
	/**
	 * Choices for the dropdown of the combobox
	 */
	protected List<String> choices;
	
	/** Initializes a new Combobox object
	 * @param x	X coordinate
	 * @param y	Y coordinate
	 * @param parent	Parent of this combobox
	 * @param canvas Canvas that houses this combobox
	 * @param width	Width of the combobox
	 * @param height	Height of the combobox
	 * @param radius Radius of the corners of the combobox
	 * @param choices List of dropdown choices
	 */
	Combobox(int x, int y, Group parent, Canvas canvas, int width, int height, double radius, List<String> choices){
		super(x, y, parent, canvas, width, height, radius);
		this.choices = choices;
	}
}
