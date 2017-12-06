package wireframe;

/** Header component
 *
 */
public class Header extends Text{

	/** Instantiates a new header component
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this header
	 * @param canvas Canvas that houses this header
	 * @param width Width of this header
	 * @param height Height of this header
	 */
	Header(int x, int y, Group parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
	
	/** Instantiates a new header component
	  * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this header
	 * @param canvas Canvas that houses this header
	 * @param width Width of this header
	 * @param height Height of this header
	 * @param alignment Text alignment of this header
	 */
	Header(int x, int y, Group parent, Canvas canvas, int width, int height, Alignment alignment){
		super(x, y, parent, canvas, width, height, alignment);
	}
}
