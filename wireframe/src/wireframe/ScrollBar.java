package wireframe;

/**
 * ScrollBar Component
 */
public class ScrollBar extends Bar{
	/** Instantiates a new ScrollBar
	 * 
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this ScrollBar
	 * @param canvas Canvas that houses this ScrollBar
	 * @param width Width of this ScrollBar
	 * @param height Height of this ScrollBar
	 * @param verticalAlignment of this ScrollBar
	 */
	ScrollBar(int x, int y, Group parent, Canvas canvas, int width, int height, boolean verticalAlignment){
		super(x, y, parent, canvas, width, height, verticalAlignment);
	}
	/** Instantiates a new ScrollBar
	 * 
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this ScrollBar
	 * @param canvas Canvas that houses this ScrollBar
	 * @param width Width of this ScrollBar
	 * @param height Height of this ScrollBar
	 */
	ScrollBar(int x, int y, Group parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
}	