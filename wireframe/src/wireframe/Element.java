package wireframe;

/**
 * @author david
 *
 */
public abstract class Element extends Component {
	protected int width;
	protected int height;

	/**
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this element
	 * @param canvas Canvas that houses this element
	 * @param width Width of this element
	 * @param height Height of this element
	 */
	Element(int x, int y, Group parent, Canvas canvas, int width, int height) {
		super(x, y, parent, canvas);
		this.width = width;
		this.height = height;
	}

	/**
	 * @see wireframe.Component#delete()
	 */
	@Override
	public void delete() throws LockedException {
		verifyNotLocked();
		canvas.remove(this);
		if(parent.isPresent()) {
			parent.get().remove(this);
		}
	}

	/**
	 * @see wireframe.Component#move(int, int)
	 */
	@Override
	public void move(int x, int y) throws LockedException {
		verifyNotLocked();
		this.x = x;
		this.y = y;
	}
	
	/** Resize this element
	 * @param width New width
	 * @param height New Height
	 * @throws LockedException If the element is locked
	 */
	public void resize(int width, int height) throws LockedException {
		verifyNotLocked();
		this.width = width;
		this.height = height;
	}

}
