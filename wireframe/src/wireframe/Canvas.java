package wireframe;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
	List<Component> components;
	int width;
	int height;
	
	Canvas(int width, int height){
		this.components = new ArrayList<Component>();
		this.width = width;
		this.height = height;
	}
	
	public void add(Component component) {
		components.add(component);
	}
	
	public void remove(Component component) {
		components.remove(component);
	}

	public void sendToFront(Component component) {
		components.remove(component);
		components.add(0, component);
	}
	
	public void sendToBack(Component component) {
		components.remove(component);
		components.add(component);
	}
}
