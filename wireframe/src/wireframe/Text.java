package wireframe;

/** Abstract Text Implementation
 *
 */
public abstract class Text extends Element{
	/**
	 * Text Alignments
	 */
	public enum Alignment{
		LEFT,
		CENTER,
		RIGHT
	};
		
	/**
	 * Default Text Alignment
	 */
	public final static Alignment DEFAULT_ALIGNMENT = Alignment.LEFT;
	/**
	 * Alignment of the Text object
	 */
	protected Alignment alignment;
	
	Text(int x, int y, Group parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
		this.alignment = DEFAULT_ALIGNMENT;
	}
	
	Text(int x, int y, Group parent, Canvas canvas, int width, int height, Alignment alignment){
		super(x, y, parent, canvas, width, height);
		this.alignment = alignment;
	}
	
	/** Changes the alignment of this Text object
	 * @param alignment New Text Alignment
	 */
	public void changeAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
	
}
