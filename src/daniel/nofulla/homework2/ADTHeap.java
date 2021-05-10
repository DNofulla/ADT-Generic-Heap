package daniel.nofulla.homework2;

/**
 * This is the generic ADTHeap Interface
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public interface ADTHeap<T> {
	/**
	 * The insert operation first builds the max heap in order to make the insertion
	 * process flawless. After building the max heap, we increase the heap's size by
	 * 1, add it to the heap's list, and increase the key of that item so that the
	 * heap is adjusted accordingly.
	 * 
	 * @param item The reference to a generic item
	 * @throws HeapException Throws the HeapException
	 */
	public void insert(T item) throws HeapException;
	
	/**
	 * The delete method deletes the root (biggest) element from the heap and
	 * returns the element deleted. We first build the max heap to ensure a flawless
	 * deletion.
	 * 
	 * @throws HeapException Throws the HeapException
	 * @return Returns the item deleted (the root of the heap)
	 */
	public T delete() throws HeapException;
	
	/**
	 * Heapify recursively loops to adjust the array in the correct order by
	 * swapping elements between parent nodes (current index) and child nodes (left
	 * and right child positions)
	 * 
	 * @param i Reference to the current index
	 */
	public void heapify(int i);
	
	/**
	 * The isEmpty method checks if the heap is empty
	 * 
	 * @return Returns true if the heapSize is 0
	 */
	public boolean isEmpty();
	
	/**
	 * The sort method performs the heapsort operation on a max heap using max
	 * heapify to set the items in the heap in sorted order (smallest to biggest)
	 */
	public void sort();
}
