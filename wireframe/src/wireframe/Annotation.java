package wireframe;

/** Annotation of components
 * 
 */
public class Annotation{
	/**
	 * X coordinate
	 */
	int x;
	/**
	 * Y coordinate
	 */
	int y;
	/**
	 * Width of the annotation
	 */
	int width;
	/**
	 * Height of the annotation
	 */
	int height;
	/**
	 * Whether or not the the annotation is being displayed
	 */
	boolean displayed;
	/**
	 * The text alignment of the annotation
	 */
	Text.Alignment alignment;
	/**
	 * The message of the annotation
	 */
	String message;
	/**
	 * The component this annotation is attached to
	 */
	Component parent;
	
	/** Initializes a newly created Annotation
	 * 
	 * @param x	X coordinate
	 * @param y	Y coordinate
	 * @param parent	Parent of this annotation
	 * @param width	Width of the annotation
	 * @param height	Height of the annotation
	 * @param message Message of the annotation
	 */
	Annotation(int x, int y, Component parent, int width, int height, String message){
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.width = width;
		this.height = height;
		this.message = message;
		this.displayed = true;
		this.alignment = Text.DEFAULT_ALIGNMENT;
	}
	
	/** Resize this annotation
	 * 
	 * @param width new width
	 * @param height	new height
	 */
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	/** Edit the message of this annotation
	 * 
	 * @param message new message
	 */
	public void edit(String message) {
		this.message = message;
	}
	
	/** Returns if the annotation is being displayed
	 * 
	 * @return displayed
	 */
	public boolean isDisplayed() {
		return this.displayed;
	}
	
	/** Toggles the value of displayed
	 * 
	 */
	public void toggleDisplayed() {
		displayed = !displayed;
	}
	
	/** Changes the alignment of this annotation
	 * 
	 * @param alignment new alignment
	 */
	public void align(Text.Alignment alignment) {
		this.alignment = alignment;
	}

	/** Moves this annotation element on the canvas
	 * 
	 * @param x new x coordinate
	 * @param y new y coordinate
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
