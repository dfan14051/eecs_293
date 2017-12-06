package wireframe;

import java.util.ArrayList;
import java.util.List;

/** The Canvas class that houses all of the components of the wireframe.
 *
 */
public class Canvas {
	/**
	 * Components of the canvas
	 */
	List<Component> components;
	/**
	 * Width of the canvas
	 */
	int width;
	/**
	 * Height of the canvas
	 */
	int height;
	
	/** Initializes a new Canvas object
	 * @param width Width of the canvas
	 * @param height Height of the canvas
	 */
	Canvas(int width, int height){
		this.components = new ArrayList<Component>();
		this.width = width;
		this.height = height;
	}
	
	/** Adds a component to the canvas
	 * @param component component to add
	 */
	public void add(Component component) {
		components.add(component);
	}
	
	/** Removes the specified component from the canvas
	 * @param component component to remove
	 */
	public void remove(Component component) {
		components.remove(component);
	}

	/** Sends the specified component to the front of the canvas
	 * @param component component to send to front
	 */
	public void sendToFront(Component component) {
		components.remove(component);
		components.add(0, component);
	}
	
	/** Sends the specified component to the back of the canvas
	 * @param component component to send to back
	 */
	public void sendToBack(Component component) {
		components.remove(component);
		components.add(component);
	}
}
