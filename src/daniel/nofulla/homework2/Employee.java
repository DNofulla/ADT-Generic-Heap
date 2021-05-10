package daniel.nofulla.homework2;

/**
 * This is the Employee Class. Each employee has a Name and a Pay Rate
 * 
 * @author Daniel Nofulla
 * @version v1.0
 */
public class Employee {

	/**
	 * The name of the employee
	 */
	private String name;

	/**
	 * The pay rate of the employee
	 */
	private double payRate;

	/**
	 * Constructs a new Employee with name set as "NO NAME" and pay rate of 0.00
	 */
	public Employee() {
		name = "NO NAME";
		payRate = 0.00;
	}

	/**
	 * Constructs a new Employee with a name which is passed as a parameter. Pay
	 * Rate is set to 0.00.
	 * 
	 * @param name The name we want to give to the employee object
	 */
	public Employee(String name) {
		this.name = name;
		this.payRate = 0.00;
	}

	/**
	 * Constructs a new Employee from a given name and pay rate as parameters
	 * 
	 * @param name    The name we want to give to the employee
	 * @param payRate The pay rate we want to assign the employee
	 */
	public Employee(String name, double payRate) {
		this.name = name;
		this.payRate = payRate;
	}

	/**
	 * Getter method for the name of the employee
	 * 
	 * @return Returns the name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for the name of the employee
	 * 
	 * @param name The name we wish for the employee to have
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for the pay rate of the employee
	 * 
	 * @return Returns the pay rate of the employee
	 */
	public double getPayRate() {
		return payRate;
	}

	/**
	 * Setter method for the pay rate of the employee
	 * 
	 * @param payRate The pay rate we wish for the employee to have
	 */
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	/**
	 * This method overrides the toString method of the Employee Object to be used
	 * to get the object in a String format
	 * 
	 * @return Returns the Employee Object in String format
	 */
	public String toString() {
		return "[ Name: " + getName() + ", Pay Rate: $" + getPayRate() + " ]";
	}

}
