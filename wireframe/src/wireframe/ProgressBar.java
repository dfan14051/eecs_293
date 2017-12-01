package wireframe;

public class ProgressBar extends Bar{
	ProgressBar(int x, int y, Component parent, Canvas canvas, int width, int height, boolean verticalAlignment){
		super(x, y, parent, canvas, width, height, verticalAlignment);
	}
	ProgressBar(int x, int y, Component parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
}
