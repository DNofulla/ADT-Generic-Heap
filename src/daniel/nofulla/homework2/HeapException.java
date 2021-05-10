package daniel.nofulla.homework2;

/**
 * This is the HeapException Class
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public class HeapException extends Exception {

	/**
	 * Randomly generated Serial Version ID by java (to remove a warning)
	 */
	private static final long serialVersionUID = -3794296062524120260L;

	/**
	 * Constructs a Heap Exception with a message. The message is passed on to the
	 * superclass' constructor (The Exception Class constructor, which is part of
	 * Java)
	 * 
	 * @param message The message to be displayed by the Exception
	 */
	public HeapException(String message) {
		super(message);
	}

}
