package wireframe;

public abstract class Bar extends Element{
	protected boolean verticalAlignment;
	
	Bar(int x, int y, Component parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
		this.verticalAlignment = true;
	}
	
	Bar(int x, int y, Component parent, Canvas canvas, int width, int height, boolean verticalAlignment){
		super(x, y, parent, canvas, width, height);
		this.verticalAlignment = verticalAlignment;
	}
	
	public void flip() {
		verticalAlignment = !verticalAlignment;
	}
}
