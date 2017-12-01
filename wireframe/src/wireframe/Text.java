package wireframe;

public abstract class Text extends Element{
	public enum Alignment{
		LEFT,
		CENTER,
		RIGHT
	};
	
	public final static Alignment DEFAULT_ALIGNMENT = Alignment.LEFT;
	protected Alignment alignment;
	
	Text(int x, int y, Component parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
		this.alignment = DEFAULT_ALIGNMENT;
	}
	
	Text(int x, int y, Component parent, Canvas canvas, int width, int height, Alignment alignment){
		super(x, y, parent, canvas, width, height);
		this.alignment = alignment;
	}
	
	public void changeAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
	
}
