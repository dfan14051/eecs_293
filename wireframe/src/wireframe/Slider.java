package wireframe;

/**
 * Slider component
 */
public class Slider extends Bar{
	/** Instantates a new Slider
	 * 
	  * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this Slider
	 * @param canvas Canvas that houses this Slider
	 * @param width Width of this Slider
	 * @param height Height of this Slider
	 * @param verticalAlignment of this Slider
	 */
	Slider(int x, int y, Group parent, Canvas canvas, int width, int height, boolean verticalAlignment){
		super(x, y, parent, canvas, width, height, verticalAlignment);
	}
	/** Instantiates a new Slider
	 * 
	  * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this Slider
	 * @param canvas Canvas that houses this Slider
	 * @param width Width of this Slider
	 * @param height Height of this Slider
	 */
	Slider(int x, int y, Group parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
}
