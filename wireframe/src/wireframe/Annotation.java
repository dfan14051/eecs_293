package wireframe;

public class Annotation{
	int x;
	int y;
	int width;
	int height;
	boolean displayed;
	Text.Alignment alignment;
	String message;
	Component parent;
	
	Annotation(int x, int y, Component parent, int width, int height, String message){
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.width = width;
		this.height = height;
		this.message = message;
		this.displayed = true;
		this.alignment = Text.DEFAULT_ALIGNMENT;
	}
	
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void edit(String message) {
		this.message = message;
	}
	
	public boolean isDisplayed() {
		return this.displayed;
	}
	
	public void toggleDisplayed() {
		displayed = !displayed;
	}
	
	public void align(Text.Alignment alignment) {
		this.alignment = alignment;
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
