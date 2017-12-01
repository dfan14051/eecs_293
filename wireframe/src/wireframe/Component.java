package wireframe;

public abstract class Component {
	protected int x;
	protected int y;
	protected Component parent;
	protected Canvas canvas;
	protected Annotation annotation;
	protected boolean locked;
	
	Component(int x, int y, Component parent, Canvas canvas) {
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.canvas = canvas;
		this.annotation = null;
		this.locked = false;
	}

	public abstract void move(int x, int y) throws LockedException;

	public void transform(int x, int y) throws LockedException {
		this.move(this.x + x, this.y + y);
	}

	public abstract void delete() throws LockedException;
	
	public void sendToFront() {
		canvas.sendToFront(this);
	}
	
	public void sendToBack() {
		canvas.sendToBack(this);
	}

	public boolean isLocked() {
		return this.locked;
	}

	public void toggleLock() {
		this.locked = !this.locked;
	}

	public void verifyNotLocked() throws LockedException{
		if(this.isLocked()) {
			throw new LockedException("Locked");
		}
	}

	public void annotate(Annotation annotation) throws LockedException {
		verifyNotLocked();
		this.annotation = annotation;
	}
	
	public void resizeAnnotation(int width, int height) throws LockedException {
		verifyNotLocked();
		annotation.resize(width, height);
	}
	
	public void toggleAnnotationDisplayed() throws LockedException{
		verifyNotLocked();
		annotation.toggleDisplayed();
	}
	
	public void alignAnnotation(Text.Alignment alignment) throws LockedException{
		verifyNotLocked();
		annotation.align(alignment);
	}
	
	public void deleteAnnotation() throws LockedException {
		verifyNotLocked();
		this.annotation = null;
	}
}
