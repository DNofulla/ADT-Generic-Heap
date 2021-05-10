package daniel.nofulla.homework2;

/**
 * This is the generic ADTPriorityQueue Interface
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public interface ADTPriorityQueue<T> {
	
	/**
	 * Invokes the Heap's insert method and passes in the item parameter into it as
	 * an argument
	 * 
	 * @param item A reference to a generic item
	 * @throws HeapException Throws the HeapException
	 */
	public void insert(T item) throws HeapException;
	
	/**
	 * Invokes the Heap's delete method. Deletes the biggest element in the Priority
	 * Queue
	 * 
	 * @return Returns a reference to the item deleted from the heap
	 * @throws HeapException Throws the HeapException
	 */
	public T delete() throws HeapException;
	
	/**
	 * Invokes the Heap's isEmpty method
	 * 
	 * @return Returns true if the heap is empty
	 */
	public boolean isEmpty();
	
	/**
	 * Invokes the Heap's sort method. Sorts the elements in the Priority Queue/Heap
	 * in the order of smallest to largest
	 */
	public void sort();
}
