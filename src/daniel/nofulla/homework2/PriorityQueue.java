package daniel.nofulla.homework2;

import java.util.ArrayList;

/**
 * This is the generic Priority Queue Class
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public class PriorityQueue<T> implements ADTPriorityQueue<T> {

	/**
	 * This is the Heap Field of type Heap<T>
	 */
	private Heap<T> heap = null;

	/**
	 * This Constructs a Priority Queue with a new Heap
	 */
	public PriorityQueue() {
		this.setHeap(new Heap<T>());
	}

	/**
	 * This Constructs a new Priority Queue with a new Heap and a reference to a
	 * Comparator
	 * 
	 * @param comparator This is a Comparator Reference
	 */
	public PriorityQueue(Comparator<T> comparator) {
		this.setHeap(new Heap<T>(comparator));
	}

	/**
	 * This Constructs a new Priority Queue with a Heap reference and a Name
	 * Comparator by default
	 * 
	 * @param heap Reference to a Heap
	 * @throws HeapException Throws the HeapException
	 */
	public PriorityQueue(Heap<T> heap) throws HeapException {
		this.setHeap(new Heap<T>(heap, new NameComparator<T>()));
	}

	/**
	 * This Constructs a new Priority Queue with an ArrayList reference and a Name
	 * Comparator by default
	 * 
	 * @param list Reference to an ArrayList
	 * @throws HeapException Throws the HeapException
	 */
	public PriorityQueue(ArrayList<T> list) throws HeapException {
		this.setHeap(new Heap<T>(list, new NameComparator<T>()));
	}

	/**
	 * This Constructs a new Priority Queue with an Array reference and a Name
	 * Comparator by default
	 * 
	 * @param newArray Reference to an Array
	 * @throws HeapException Throws the HeapException
	 */
	public PriorityQueue(T[] newArray) throws HeapException {
		this.setHeap(new Heap<T>(newArray, new NameComparator<T>()));
	}

	/**
	 * This Constructs a new Priority Queue with a Heap and Comparator Reference
	 * 
	 * @param heap       Reference to a Heap
	 * @param comparator Reference to a Comparator
	 * @throws HeapException Throws the HeapException
	 */
	public PriorityQueue(Heap<T> heap, Comparator<T> comparator) throws HeapException {
		this.setHeap(new Heap<T>(heap, comparator));
	}

	/**
	 * This Constructs a new Priority Queue with an ArrayList and Comparator
	 * Reference
	 * 
	 * @param list       Reference to an ArrayList
	 * @param comparator Reference to a Comparator
	 * @throws HeapException Throws the HeapException
	 */
	public PriorityQueue(ArrayList<T> list, Comparator<T> comparator) throws HeapException {
		this.setHeap(new Heap<T>(list, comparator));
	}

	/**
	 * This Constructs a new Priority Queue with an Array and Comparator Reference
	 * 
	 * @param newArray   Reference to an Array
	 * @param comparator Reference to a Comparator
	 * @throws HeapException Throws the HeapException
	 */
	public PriorityQueue(T[] newArray, Comparator<T> comparator) throws HeapException {
		this.setHeap(new Heap<T>(newArray, comparator));
	}

	/**
	 * Invokes the Heap's insert method and passes in the item parameter into it as
	 * an argument
	 * 
	 * @param item A reference to a generic item
	 * @throws HeapException Throws the HeapException
	 */
	public void insert(T item) throws HeapException {
		heap.insert(item);
	}

	/**
	 * Invokes the Heap's delete method. Deletes the biggest element in the Priority
	 * Queue
	 * 
	 * @return Returns a reference to the item deleted from the heap
	 * @throws HeapException Throws the HeapException
	 */
	public T delete() throws HeapException {
		return heap.delete();
	}

	/**
	 * Invokes the Heap's isEmpty method
	 * 
	 * @return Returns true if the heap is empty
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	/**
	 * Invokes the Heap's sort method. Sorts the elements in the Priority Queue/Heap
	 * in the order of smallest to largest
	 */
	public void sort() {
		heap.sort();
	}

	/**
	 * Invokes the Heap's toString method
	 * 
	 * @return Returns the Heap's String representation
	 */
	public String toString() {
		return heap.toString();
	}

	/**
	 * The getHeap method returns the Heap field
	 * 
	 * @return Returns the heap
	 */
	public Heap<T> getHeap() {
		return heap;
	}

	/**
	 * The setHeap method sets the heap to a reference heap passed as a parameter
	 * 
	 * @param heap A reference to another heap
	 */
	public void setHeap(Heap<T> heap) {
		this.heap = heap;
	}

}
