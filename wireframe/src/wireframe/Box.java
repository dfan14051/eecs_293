package wireframe;

public class Box extends Element{
	protected double radius;
	
	Box(int x, int y, Component parent, Canvas canvas, int width, int height, double radius){
		super(x, y, parent, canvas, width, height);
		this.radius = radius;
	}
}
