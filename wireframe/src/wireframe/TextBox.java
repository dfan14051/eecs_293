package wireframe;

public class TextBox extends Text{
	protected String cannedText = "Canned";
	
	TextBox(int x, int y, Component parent, Canvas canvas, int width, int height){
		super(x, y, parent, canvas, width, height);
	}
	
	TextBox(int x, int y, Component parent, Canvas canvas, int width, int height, Alignment alignment){
		super(x, y, parent, canvas, width, height, alignment);
	}
}
