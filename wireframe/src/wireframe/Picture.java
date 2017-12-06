package wireframe;

import java.io.File;

/**
 * Picture component
 */
public class Picture extends Element{
	protected File image = null;
	
	/** Instantiates a new Picture
	 * 
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this picture
	 * @param canvas Canvas that houses this picture
	 * @param width Width of this picture
	 * @param height Height of this picture
	 */
	Picture(int x, int y, Group parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
}
