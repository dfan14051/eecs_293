package wireframe;

public class Header extends Text{
	Header(int x, int y, Component parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
	
	Header(int x, int y, Component parent, Canvas canvas, int width, int height, Alignment alignment){
		super(x, y, parent, canvas, width, height, alignment);
	}
}
