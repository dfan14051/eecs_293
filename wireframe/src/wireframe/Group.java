package wireframe;

import java.util.ArrayList;
import java.util.List;

public class Group extends Component{
	protected List<Component> components;
	
	Group(int x, int y, Component parent, Canvas canvas){
		super(x, y, parent, canvas);
		components = new ArrayList<Component>();
	}
	
	public void add(Component component) throws LockedException {
		verifyNotLocked();
		if(component.equals(this)) {
			return;
		}
		component.parent = this;
		components.add(component);
	}
	
	public void remove(Component component) throws LockedException {
		verifyNotLocked();
		components.remove(component);
	}
	
	@Override
	public void move(int x, int y) throws LockedException {
		verifyNotLocked();
		int diff_x = x - this.x;
		int diff_y = y - this.y;
		for(Component component: components) {
			component.transform(diff_x, diff_y);
		}
	}
	
	@Override
	public void delete() throws LockedException {
		int stoppingCondition = components.size();
		for(int i = 0; i < stoppingCondition; i++) {
			components.get(0).delete();
		}
		if(parent == null) {
			canvas.remove(this);
		}
		else {
			canvas.remove(this);
			((Group)parent).remove(this);
		}
	}
	
	public void reOrder(Component component, int index) {
		components.remove(component);
		components.add(index, component);
	}
	
	
}
