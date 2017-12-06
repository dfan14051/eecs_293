package wireframe;

/**
 * Exception thrown by locked components
 */
public class LockedException extends Exception {

	/**
	 * Default
	 */
	private static final long serialVersionUID = 1L;
	
	/** Instantiates new LockedExceptions
	 * @param message Message of the exception
	 */
	LockedException(String message){
        super(message);
    }
	
}
