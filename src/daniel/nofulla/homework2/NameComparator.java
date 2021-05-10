package daniel.nofulla.homework2;

/**
 * This is the generic NameComparator class.
 * 
 * @author Daniel Nofulla
 * @version v1.0
 * 
 */
public class NameComparator<T> extends Comparator<T> implements java.util.Comparator<T> {

	/**
	 * Comparing two generic employee references' names in Lexicographic order
	 * 
	 * @param employee1 Generic reference to the first employee
	 * @param employee2 Generic reference to the second employee
	 * 
	 * @return Returns 0 If Employee 1's name is equal to Employee 2's name, returns
	 *         1 If Employee 1's name is greater than Employee 2's name, or returns
	 *         -1 If Employee 1's name is less than Employee 2's name
	 */
	public int compare(T employee1, T employee2) {
		/*
		 * We cast to Employee when we compare so that we can access the name of each
		 * employee and compare them Java's compareToIgnoreCase method allows the
		 * strings to be compared by Lexicographic order (Also known as alphabetical
		 * order)
		 */
		if (((Employee) employee1).getName().compareToIgnoreCase(((Employee) employee2).getName()) == 0) {
			return 0;
		} else if (((Employee) employee1).getName().compareToIgnoreCase(((Employee) employee2).getName()) > 0) {
			return 1;
		} else {
			return -1;
		}
	}

}
