package wireframe;

import java.io.File;

public class Picture extends Element{
	protected File image = null;
	
	Picture(int x, int y, Component parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
}
