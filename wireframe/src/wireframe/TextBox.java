package wireframe;

/**
 * TextBox Component
 */
public class TextBox extends Text{
	/**
	 * Default Canned Text of the TextBox
	 */
	protected String cannedText = "Canned";
	
	/** Instantiates a new TextBox
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this TextBox
	 * @param canvas Canvas that houses this TextBox
	 * @param width Width of this TextBox
	 * @param height Height of this TextBox
	 */
	TextBox(int x, int y, Group parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
	
	/** Instantiates a new TextBox
	  * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this TextBox
	 * @param canvas Canvas that houses this TextBox
	 * @param width Width of this TextBox
	 * @param height Height of this TextBox
	 * @param alignment Alignment of this TextBox
	 */
	TextBox(int x, int y, Group parent, Canvas canvas, int width, int height, Alignment alignment){
		super(x, y, parent, canvas, width, height, alignment);
	}
}
