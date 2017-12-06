package wireframe;

import java.util.Optional;

/** Abstract Component implementation
 *
 */
public abstract class Component {
	protected int x;
	protected int y;
	protected Optional<Group> parent;
	protected Canvas canvas;
	/**
	 * The annotation of this component
	 */
	protected Annotation annotation;
	/**
	 * Whether or not this component is locked
	 */
	protected boolean locked;
	
	/** 
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this component
	 * @param canvas Canvas that houses this component
	 */
	Component(int x, int y, Group parent, Canvas canvas) {
		this.x = x;
		this.y = y;
		if(parent != null) {
			this.parent = Optional.of(parent);
		}
		else {
			this.parent = Optional.empty();
		}
		this.canvas = canvas;
		this.annotation = null;
		this.locked = false;
	}

	/**
	 * Move this Component
	 * @param x New X coordinate
	 * @param y New Y Coordinate
	 * @throws LockedException If the component is locked
	 */
	public abstract void move(int x, int y) throws LockedException;

	/**
	 * Shift this component
	 * @param x Horizontal shift
	 * @param y Vertical shift
	 * @throws LockedException If the component is locked
	 */
	public void transform(int x, int y) throws LockedException {
		this.move(this.x + x, this.y + y);
	}

	/** Delete this component
	 * @throws LockedException If the component is locked
	 */
	public abstract void delete() throws LockedException;
	
	/**
	 * Send this component to the front of the Canvas
	 */
	public void sendToFront() {
		canvas.sendToFront(this);
	}
	
	/**
	 * Send this component to the back of the Canvas
	 */
	public void sendToBack() {
		canvas.sendToBack(this);
	}

	/** Returns the locked value of the component
	 * @return locked
	 */
	public boolean isLocked() {
		return this.locked;
	}

	/**
	 * Switches the value of locked
	 */
	public void toggleLock() {
		this.locked = !this.locked;
	}

	/** Checks if the component is locked and throws an exception if it is
	 * @throws LockedException If the component is locked
	 */
	public void verifyNotLocked() throws LockedException{
		if(this.isLocked()) {
			throw new LockedException("Locked");
		}
	}

	/** Annotate this component
	 * @param annotation Annotation to add to the component
	 * @throws LockedException If the component is locked
	 */
	public void annotate(Annotation annotation) throws LockedException {
		verifyNotLocked();
		this.annotation = annotation;
	}
	
	/** Resize the annotation of this component
	 * @param width New width of the annotation
	 * @param height New height of the annotation
	 * @throws LockedException If the component is locked
	 */
	public void resizeAnnotation(int width, int height) throws LockedException {
		verifyNotLocked();
		annotation.resize(width, height);
	}
	
	/** Toggles the displayed value of the annotation
	 * @throws LockedException If the component is locked
	 */
	public void toggleAnnotationDisplayed() throws LockedException{
		verifyNotLocked();
		annotation.toggleDisplayed();
	}
	
	/** Replace the alignment of the annotation
	 * @param alignment New text alignment
	 * @throws LockedException If the component is locked
	 */
	public void alignAnnotation(Text.Alignment alignment) throws LockedException{
		verifyNotLocked();
		annotation.align(alignment);
	}
	
	/** Delete the annotation
	 * @throws LockedException If the component is locked
	 */
	public void deleteAnnotation() throws LockedException {
		verifyNotLocked();
		this.annotation = null;
	}
}
