package daniel.nofulla.homework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the Helper Class. This is where all the test cases are written and
 * executed
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public class Helper {

	/**
	 * The start method runs all the test cases. We first create two priority
	 * queues, and then we sort, and then we delete. We print results for each
	 * operation.
	 * 
	 * @throws HeapException         Throws the HeapException
	 * @throws FileNotFoundException Throws the FileNotFoundException
	 */
	public static void start() throws HeapException, FileNotFoundException {
		PriorityQueue<Employee> priorityQueueByName = new PriorityQueue<Employee>(new NameComparator<Employee>());
		PriorityQueue<Employee> priorityQueueByPayRate = new PriorityQueue<Employee>(new PayRateComparator<Employee>());

		priorityQueueByName = create(priorityQueueByName);
		priorityQueueByPayRate = create(priorityQueueByPayRate);

		System.out.println("ORIGINAL PRIORITY QUEUES AFTER CREATION");
		System.out.println();
		
		display(priorityQueueByName);
		display(priorityQueueByPayRate);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		priorityQueueByName.sort();
		priorityQueueByPayRate.sort();
		
		System.out.println("PRIORITY QUEUES AFTER SORTING | WARNING: This makes it not a Max Heap");
		System.out.println();
		
		display(priorityQueueByName);
		display(priorityQueueByPayRate);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		Employee ex = priorityQueueByName.delete();
		Employee ey = priorityQueueByPayRate.delete();

		System.out.println(
				"PRIORITY QUEUES AFTER DELETING AN ELEMENT (Root) | WARNING: Deleting an element rebuilds the max heap FIRST to extract the largest element! The sorting order from before won't matter here!");
		System.out.println();
		
		System.out.println("Employee Deleted: " + ex);
		display(priorityQueueByName);
		
		System.out.println("Employee Deleted: " + ey);
		display(priorityQueueByPayRate);

	}

	/**
	 * The create method fills up a Priority Queue with Employee Objects from a file
	 * and returns the Priority Queue with each element in the internal Heap.
	 * 
	 * @param prioQueue The Priority Queue we pass as a parameter
	 * @return prioQueue We return the priority queue we filled with Employees
	 * @throws FileNotFoundException Throws the FileNotFoundException
	 * @throws HeapException         Throws the HeapException
	 */
	public static PriorityQueue<Employee> create(PriorityQueue<Employee> prioQueue)
			throws FileNotFoundException, HeapException {
		Scanner sc = new Scanner(new File("employees.txt"));
		sc.useDelimiter(",");
		while (sc.hasNext()) {
			Employee e = new Employee(sc.next(), Double.parseDouble(sc.next()));
			prioQueue.insert(e);
		}
		return prioQueue;
	}

	/**
	 * The display method simply prints out the Priority Queue we pass in as a parameter
	 * 
	 * @param prioQueue Priority Queue we will be printing
	 */
	public static void display(PriorityQueue<Employee> prioQueue) {
		// We just invoke the toString() of the Priority Queue by using java's println() function
		System.out.println(prioQueue);
		System.out.println();
	}

}
