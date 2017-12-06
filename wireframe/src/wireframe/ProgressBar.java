package wireframe;

/**
 * ProgressBar component
 */
public class ProgressBar extends Bar{
	/** Instantiates a new ProgressBar
	 * 
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this ProgressBar
	 * @param canvas Canvas that houses this ProgressBar
	 * @param width Width of this ProgressBar
	 * @param height Height of this ProgressBar
	 * @param verticalAlignment of this ProgressBar
	 */
	ProgressBar(int x, int y, Group parent, Canvas canvas, int width, int height, boolean verticalAlignment){
		super(x, y, parent, canvas, width, height, verticalAlignment);
	}
	/** Instantiates a new ProgressBar
	 * 
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this ProgressBar
	 * @param canvas Canvas that houses this ProgressBar
	 * @param width Width of this ProgressBar
	 * @param height Height of this ProgressBar
	 */
	ProgressBar(int x, int y, Group parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
}
