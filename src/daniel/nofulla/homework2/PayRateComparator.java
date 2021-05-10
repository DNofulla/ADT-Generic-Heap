package daniel.nofulla.homework2;

/**
 * This is the generic PayRateComparator class.
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public class PayRateComparator<T> extends Comparator<T> implements java.util.Comparator<T> {

	/**
	 * Comparing two generic employee references' Pay Rates
	 * 
	 * @param employee1 Generic reference to the first employee
	 * @param employee2 Generic reference to the second employee
	 * 
	 * @return Returns 0 If Employee 1's Pay Rate is equal to Employee 2's Pay Rate,
	 *         returns 1 If Employee 1's Pay Rate is greater than Employee 2's Pay
	 *         Rate or returns -1 If Employee 1's Pay Rate is less than Employee 2's
	 *         Pay Rate
	 */
	public int compare(T employee1, T employee2) {

		/*
		 * We numerically compare the Pay Rates of both employees to find if they're
		 * equal, which is greater and which is less than the other's
		 */
		if (((Employee) employee1).getPayRate() == ((Employee) employee2).getPayRate()) {
			return 0;
		} else if (((Employee) employee1).getPayRate() > ((Employee) employee2).getPayRate()) {
			return 1;
		} else {
			return -1;
		}
	}

}
