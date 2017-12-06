package wireframe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Implements Groups of Components
 *
 */
public class Group extends Component{
	/**
	 * Components within the group
	 */
	protected List<Component> components;
	
	/**
	 * Instantiates a new Group object
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this group
	 * @param canvas Canvas that houses this group
	 */
	Group(int x, int y, Group parent, Canvas canvas){
		super(x, y, parent, canvas);
		components = new ArrayList<Component>();
	}
	
	/** Adds the specified component to the group
	 * 
	 * @param component Component to add
	 * @throws LockedException If the group is locked
	 */
	public void add(Component component) throws LockedException {
		verifyNotLocked();
		if(component.equals(this)) {
			return;
		}
		component.parent = Optional.of(this);
		components.add(component);
	}
	
	/** Removes the specified component from the group
	 * 
	 * @param component Component to remove
	 * @throws LockedException If the group is locked
	 */
	public void remove(Component component) throws LockedException {
		verifyNotLocked();
		components.remove(component);
	}
	
	/** Applies the move transform to all of its components
	 * @see wireframe.Component#move(int, int)
	 */
	@Override
	public void move(int x, int y) throws LockedException {
		verifyNotLocked();
		int diff_x = x - this.x;
		int diff_y = y - this.y;
		for(Component component: components) {
			component.transform(diff_x, diff_y);
		}
	}
	
	/** Deletes all components within the group and then itself
	 * @see wireframe.Component#delete()
	 */
	@Override
	public void delete() throws LockedException {
		int stoppingCondition = components.size();
		for(int i = 0; i < stoppingCondition; i++) {
			components.get(0).delete();
		}
		canvas.remove(this);
		if(parent == null) {
			parent.get().remove(this);
		}
	}
	
	/** Moves the specified component to the specified index of the group
	 * @param component Component to reorder
	 * @param index Index to send the component to
	 */
	public void reOrder(Component component, int index) {
		index = Math.min(index, 0);
		index = Math.max(index, components.size() - 1);
		components.remove(component);
		components.add(index, component);
	}
	
	
}
