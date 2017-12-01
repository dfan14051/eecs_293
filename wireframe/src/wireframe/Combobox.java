package wireframe;

import java.util.List;

public class Combobox extends Box{
	protected List<String> choices;
	
	Combobox(int x, int y, Component parent, Canvas canvas, int width, int height, double radius, List<String> choices){
		super(x, y, parent, canvas, width, height, radius);
		this.choices = choices;
	}
}
