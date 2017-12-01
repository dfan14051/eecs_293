package wireframe;

public class Slider extends Bar{
	Slider(int x, int y, Component parent, Canvas canvas, int width, int height, boolean verticalAlignment){
		super(x, y, parent, canvas, width, height, verticalAlignment);
	}
	Slider(int x, int y, Component parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
}
