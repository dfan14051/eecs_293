package wireframe;

public abstract class Element extends Component {
	protected int width;
	protected int height;

	Element(int x, int y, Component parent, Canvas canvas, int width, int height) {
		super(x, y, parent, canvas);
		this.width = width;
		this.height = height;
	}

	@Override
	public void delete() throws LockedException {
		verifyNotLocked();
		if(parent == null) {
			canvas.remove(this);
		}
		else {
			canvas.remove(this);
			((Group)parent).remove(this);
		}
	}

	@Override
	public void move(int x, int y) throws LockedException {
		verifyNotLocked();
		this.x = x;
		this.y = y;
	}
	
	public void resize(int width, int height) throws LockedException {
		verifyNotLocked();
		this.width = width;
		this.height = height;
	}

}
