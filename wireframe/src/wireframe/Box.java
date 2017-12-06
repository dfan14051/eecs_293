package wireframe;

/**
 * Box component
 */
public class Box extends Element{
	/**
	 * Corner radius of the box
	 */
	protected double radius;
	
	/** Initializes a newly created Box
	 * @param x	X coordinate
	 * @param y	Y coordinate
	 * @param parent	Parent of this box
	 * @canvas canvas Canvas that houses this box
	 * @param width	Width of the box
	 * @param height	Height of the box
	 * @param radius
	 */
	Box(int x, int y, Group parent, Canvas canvas, int width, int height, double radius){
		super(x, y, parent, canvas, width, height);
		this.radius = radius;
	}
}
