package wireframe;

public class ScrollBar extends Bar{
	ScrollBar(int x, int y, Component parent, Canvas canvas, int width, int height, boolean verticalAlignment){
		super(x, y, parent, canvas, width, height, verticalAlignment);
	}
	ScrollBar(int x, int y, Component parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
}	