package wireframe;

/** Abstract Bar Component
 *
 */
public abstract class Bar extends Element{
	protected boolean verticalAlignment;
	
	/**
	 * @param x	X coordinate
	 * @param y	Y coordinate
	 * @param parent	Parent of this bar
	 * @param canvas Canvas that houses this bar
	 * @param width	Width of the bar
	 * @param height	Height of the bar
	 */
	Bar(int x, int y, Group parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
		this.verticalAlignment = true;
	}
	
	/**
	 * @param x	X coordinate
	 * @param y	Y coordinate
	 * @param parent	Parent of this bar
	 * @param canvas Canvas that houses this bar
	 * @param width	Width of the bar
	 * @param height	Height of the bar
	 * @param message Message of the bar
	 * @param verticalAlignment If the bar is vertical or horizontal
	 */
	Bar(int x, int y, Group parent, Canvas canvas, int width, int height, boolean verticalAlignment){
		super(x, y, parent, canvas, width, height);
		this.verticalAlignment = verticalAlignment;
	}
	
	/** Flips the vertical alignment of the bar
	 * 
	 */
	public void flip() {
		verticalAlignment = !verticalAlignment;
	}
}
