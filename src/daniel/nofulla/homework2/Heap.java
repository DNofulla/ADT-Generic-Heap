package daniel.nofulla.homework2;

import java.util.ArrayList;

/**
 * This is the generic Heap Class (Specifically, this is a MAX HEAP)
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public class Heap<T> implements ADTHeap<T> {

	/**
	 * Empty ArrayList to store Heap elements
	 */
	private ArrayList<T> list = null;

	/**
	 * A Comparator to be used for the ordering of elements
	 */
	private Comparator<T> comparator = null;

	/**
	 * Uses an integer to keep track of the comparator type
	 * 
	 * Using a compType of 0, means we are using a Name Comparator Using a compType
	 * of 1, means we are using a Pay Rate Comparator
	 */
	private int compType;

	/**
	 * The heap's size
	 */
	private int heapSize = 0;

	/**
	 * Constructs a new empty heap with a Name Comparator reference
	 */
	public Heap() {
		list = new ArrayList<T>();
		setHeapSize(0);
		setComparator(new NameComparator<T>());
		setCompType(0);
	}

	/**
	 * Constructs a new Heap with a reference to a comparator (Name Comparator or
	 * Pay Rate Comparator)
	 * 
	 * @param newComparator Reference to a comparator
	 */
	public Heap(Comparator<T> newComparator) {
		list = new ArrayList<T>();
		setHeapSize(0);

		// instanceof is used to find the instance of a subclass on a superclass
		// variable
		if (newComparator instanceof NameComparator) {
			setComparator(new NameComparator<T>());
			setCompType(0);
		} else {
			setComparator(new PayRateComparator<T>());
			setCompType(1);
		}
	}

	/**
	 * Constructs a new Heap from another heap's elements and with a reference to a
	 * comparator
	 * 
	 * @param newHeap       The new heap reference
	 * @param newComparator The comparator reference
	 * @throws HeapException Throws the HeapException
	 */
	public Heap(Heap<T> newHeap, Comparator<T> newComparator) throws HeapException {
		list = new ArrayList<T>();
		setHeapSize(0);

		// instanceof is used to find the instance of a subclass on a superclass
		// variable
		if (newComparator instanceof NameComparator) {
			setComparator(new NameComparator<T>());
			setCompType(0);
		} else {
			setComparator(new PayRateComparator<T>());
			setCompType(1);
		}

		// We insert every element of the heap reference into this heap
		for (int i = 0; i < newHeap.getList().size(); i++) {
			insert(newHeap.getList().get(i));
		}
	}

	/**
	 * Constructs a new Heap from an ArrayList and with a reference to a comparator
	 * 
	 * @param newArrayList  The new ArrayList reference
	 * @param newComparator The comparator reference
	 * @throws HeapException Throws the HeapException
	 */
	public Heap(ArrayList<T> newArrayList, Comparator<T> newComparator) throws HeapException {
		list = new ArrayList<T>();
		setHeapSize(0);

		// instanceof is used to find the instance of a subclass on a superclass
		// variable
		if (newComparator instanceof NameComparator) {
			setComparator(new NameComparator<T>());
			setCompType(0);
		} else {
			setComparator(new PayRateComparator<T>());
			setCompType(1);
		}

		// We insert every element of the arraylist reference into this heap
		for (int i = 0; i < newArrayList.size(); i++) {
			insert(newArrayList.get(i));
		}

	}

	/**
	 * Constructs a new Heap from an array's elements and with a reference to a
	 * comparator
	 * 
	 * @param newArray      The new array reference
	 * @param newComparator The comparator reference
	 * @throws HeapException Throws the HeapException
	 */
	public Heap(T[] newArray, Comparator<T> newComparator) throws HeapException {
		list = new ArrayList<T>();
		setHeapSize(0);

		// instanceof is used to find the instance of a subclass on a superclass
		// variable
		if (newComparator instanceof NameComparator) {
			setComparator(new NameComparator<T>());
			setCompType(0);
		} else {
			setComparator(new PayRateComparator<T>());
			setCompType(1);
		}

		// We insert every element of the array reference into this heap
		for (int i = 0; i < newArray.length; i++) {
			insert(newArray[i]);
		}
	}

	/**
	 * The buildHeap method builds the max heap. We set the heap's size to the max
	 * heap and then we loop and heapify the heap with a loop until all the parent
	 * nodes are bigger than the nodes of their children and the max heap is built.
	 */
	public void buildHeap() {
		setHeapSize(list.size());

		for (int i = (list.size() / 2); i >= 0; i--) {
			heapify(i);
		}
	}

	/**
	 * The insert operation first builds the max heap in order to make the insertion
	 * process flawless. After building the max heap, we increase the heap's size by
	 * 1, add it to the heap's list, and increase the key of that item so that the
	 * heap is adjusted accordingly.
	 * 
	 * @param item The reference to a generic item
	 * @throws HeapException Throws the HeapException
	 */
	public void insert(T item) throws HeapException {
		buildHeap();
		setHeapSize(getHeapSize() + 1);
		list.add(getHeapSize() - 1, item);
		increaseKey(getHeapSize() - 1, item);
	}

	/**
	 * The increaseKey method is used within the insert method in order to properly
	 * reorganize a heap after an element is inserted at the end of the heap and
	 * move it up.
	 * 
	 * @param i    Reference to the current index
	 * @param item Reference to the item added in theheap
	 * @throws HeapException Throws the HeapException
	 */
	public void increaseKey(int i, T item) throws HeapException {

		if (getCompType() == 0) {

			// The new item can't be smaller than the current index item since the item is
			// already at the last index
			if (((NameComparator<T>) comparator).compare(item, list.get(i)) < 0) {
				throw new HeapException("HeapIncreaseKeyException! The new item is smaller than the current item!");
			}

			// We set the item to that index
			list.set(i, item);

			/*
			 * We loop until we're either at the root or the parent element of the current
			 * index is greater than or equal to the item of the current index
			 */
			while (i > 0 && ((NameComparator<T>) comparator).compare(list.get(getParentPos(i)), list.get(i)) < 0) {
				exchange(i, getParentPos(i));
				i = getParentPos(i);
			}

			// Same thing for Pay Rate comparisons as well
		} else {

			if (((PayRateComparator<T>) comparator).compare(item, list.get(i)) < 0) {
				throw new HeapException("HeapIncreaseKeyException! The new item is smaller than the current item!");
			}

			list.set(i, item);

			while (i > 0 && ((PayRateComparator<T>) comparator).compare(list.get(getParentPos(i)), list.get(i)) < 0) {
				exchange(i, getParentPos(i));
				i = getParentPos(i);
			}
		}
	}

	/**
	 * The delete method deletes the root (biggest) element from the heap and
	 * returns the element deleted. We first build the max heap to ensure a flawless
	 * deletion.
	 * 
	 * @throws HeapException Throws the HeapException
	 * @return Returns the item deleted (the root of the heap)
	 */
	public T delete() throws HeapException {

		buildHeap(); // we build the max heap

		// We throw an exception if we try to remove an item from an empty heap
		if (isEmpty()) {
			throw new HeapException("Heap Underflow! Cannot delete element from an Empty Heap!");
		}

		T item = list.get(0); // Get the element

		// We set the sizes and elements accordingly
		list.set(0, list.get(getHeapSize() - 1));
		setHeapSize(getHeapSize() - 1);
		heapify(0); // Heapify at the root index
		/*
		 * We remove the last element from the list (after heapify ran through the whole
		 * heap, the old root will be at the very end of the heap
		 */
		list.remove(list.size() - 1);

		return item;
	}

	/**
	 * Heapify recursively loops to adjust the array in the correct order by
	 * swapping elements between parent nodes (current index) and child nodes (left
	 * and right child positions)
	 * 
	 * @param i Reference to the current index
	 */
	public void heapify(int i) {
		/*
		 * We get the positions of the left, right nodes of the current index
		 */
		int left = getLeftChildPos(i);
		int right = getRightChildPos(i);
		int largest; // index with the largest element

		if (getCompType() == 0) {

			/*
			 * If the left element is larger than its parent we set the largest element
			 * position to the left, otherwise we set it to the current position
			 */
			if (left < getHeapSize() && ((NameComparator<T>) comparator).compare(list.get(left), list.get(i)) > 0) {
				largest = left;
			} else {
				largest = i;
			}

			/*
			 * If the right element position is larger than the largest position, we set the
			 * largest to the right, otherwise it remains as is
			 */
			if (right < getHeapSize()
					&& ((NameComparator<T>) comparator).compare(list.get(right), list.get(largest)) > 0) {
				largest = right;
			}

		} else {
			// Same process for Pay Rate comparisons
			if (left < getHeapSize() && ((PayRateComparator<T>) comparator).compare(list.get(left), list.get(i)) > 0) {
				largest = left;
			} else {
				largest = i;
			}

			if (right < getHeapSize()
					&& ((PayRateComparator<T>) comparator).compare(list.get(right), list.get(largest)) > 0) {
				largest = right;
			}

		}
		/*
		 * If the largest element's position is not the current element's position, swap
		 * the current element with the largest element and then heapify at the largest
		 * index.
		 */
		if (largest != i) {
			exchange(i, largest);
			heapify(largest);
		}
	}

	/**
	 * The isEmpty method checks if the heap is empty
	 * 
	 * @return Returns true if the heapSize is 0
	 */
	public boolean isEmpty() {
		return getHeapSize() == 0;
	}

	/**
	 * The sort method performs the heapsort operation on a max heap using max
	 * heapify to set the items in the heap in sorted order (smallest to biggest)
	 */
	public void sort() {
		// First we build the max heap
		buildHeap();

		/*
		 * We then loop through the list from the last element down to the root. We keep
		 * swapping the current index element with the root, while decreasing the heap
		 * size so that the element is no longer in the max heap (since it would break
		 * the max heap property if elements are sorted in smallest to biggest order) We
		 * then perform max heapify on the root. By the end, the heap is empty in order
		 * to avoid breaking the max heap property.
		 */
		for (int i = list.size() - 1; i >= 0; i--) {
			exchange(0, i);
			setHeapSize(getHeapSize() - 1);
			heapify(0);
		}
	}

	/**
	 * The toString method returns the list/heap's elements formatted as a String.
	 * 
	 * @return Returns the list/heap's elements formatted as a String
	 */
	public String toString() {
		String str = "";

		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				str += "Index: " + i + "         ROOT        " + list.get(i) + " Comparator: "
						+ (getCompType() == 0 ? "Name Comparator" : "Pay Rate Comparator") + "\n";
				str += "-------------------------------------------------------------------------------------------\n";
			} else {
				str += "Index: " + i + " | Parent Index: " + getParentPos(i) + " | " + list.get(i) + "\n";
			}
		}
		return str;
	}

	/**
	 * The getParentPos method gets the Parent Index Position of the current index
	 * 
	 * @param i Reference to the current index
	 * @return Returns the parent index position of the current index position
	 */
	public int getParentPos(int i) {
		if (i != 0 && (i % 2) == 0) {
			return (int) ((Math.floor(i / 2)) - 1);
		} else {
			return (int) Math.floor(i / 2);
		}

	}

	/**
	 * The getLeftChildPos method gets the Left Child Index Position of the current
	 * index
	 * 
	 * @param i Reference to the current index
	 * @return Returns the left child index position of the current index position
	 */
	public int getLeftChildPos(int i) {
		return (2 * i) + 1;
	}

	/**
	 * The getRightChildPos method gets the Right Child Index Position of the
	 * current index
	 * 
	 * @param i Reference to the current index
	 * @return Returns the right child index position of the current index position
	 */
	public int getRightChildPos(int i) {
		return (2 * i) + 2;
	}

	/**
	 * The exchange method swaps the elements at the two positions passed as
	 * references.
	 * 
	 * @param i Reference of the index of the first element
	 * @param j Reference of the index of the second element
	 */
	public void exchange(int i, int j) {
		T firstElement = list.get(i);
		T secondElement = list.get(j);
		list.set(j, firstElement);
		list.set(i, secondElement);

	}

	/**
	 * The getList method returns the ArrayList where the heap is stored
	 * 
	 * @return Returns the ArrayList where the heap is stored
	 */
	public ArrayList<T> getList() {
		return list;
	}

	/**
	 * The setList method sets the ArrayList of the Heap to a reference of another
	 * ArrayList and then builds the max heap.
	 * 
	 * @param list Reference to an ArrayList
	 */
	public void setList(ArrayList<T> list) {
		this.list = list;
		buildHeap();
	}

	/**
	 * The getComparator method returns the Comparator of the Heap
	 * 
	 * @return Returns the Comparator of the Heap
	 */
	public Comparator<T> getComparator() {
		return comparator;
	}

	/**
	 * The setComparator method sets the Comparator of the Heap to a reference of
	 * another Comparator and then builds the max heap.
	 * 
	 * @param comparator Reference to a Comparator
	 */
	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
		// 0 is for NameComparator, 1 is for PayRateComparator
		if (comparator instanceof NameComparator) {
			setCompType(0);
		} else {
			setCompType(1);
		}
		buildHeap();
	}

	/**
	 * The getCompType method returns the compType integer value of the heap
	 * 
	 * @return Returns the compType of the heap
	 */
	public int getCompType() {
		return compType;
	}

	/**
	 * The setCompType method sets the compType to a Reference of a compType passed
	 * as a parameter.
	 * 
	 * @param compType Reference to a compType
	 */
	public void setCompType(int compType) {
		this.compType = compType;
	}

	/**
	 * The getHeapSize method returns the size of the heap
	 * 
	 * @return Returns the size of the heap
	 */
	public int getHeapSize() {
		return heapSize;
	}

	/**
	 * The setHeapSize method set the heapSize to a reference heapSize value
	 * 
	 * @param heapSize Reference to a integer to be used as the new heap size
	 */
	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

}
