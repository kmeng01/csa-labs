/** 
 * The PayCheck Class provides functionality for the calculation of a worker's wages,
 * given their responsibilities (manager or sales clerk), working hours, sales, and 
 * commission.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 10/27/2018
 */
  
public class PayCheck 
{
	/* Static Constants Go Here */
	public static final int BASE_HOURS = 40;
	public static final double BASE_PAY_PER_HOUR = 9.75;
	public static final int MANAGER_BONUS = 100;
	public static final double[] COMMISSION_UPPER_BOUNDS = {99.99, 299.99, -1};
	public static final double[] COMMISSION_PERCENTAGES = {0.05, 0.08, 0.13};
	
	/* Instance variables */
	private String employee;
	private double hoursWorked;
	private boolean isManager;
	private double weeklySales;
	
	/** 
	 *  Creates a PayCheck object for an employee given the name and
	 *  whether or not this employee is a manager.
	 *  @param name the name of the employee
	 *  @param manager indicates whether or not this is a manager 
	 *     (true if a manager, false if a sales clerk)
	 */
	public PayCheck(String name, boolean manager)
	{
		employee = name;
		isManager = manager;
		hoursWorked = 0;
		weeklySales = 0;
	}

	/** 
	 *  Calculates a worker's total wages, comprised of base salary, overtime salary,
	 *  commission, and the manager's bonus
	 *  @return the total wages earned by the worker
	 */
	public double calcWages()
	{
		// Get base wages
		double baseWages = BASE_PAY_PER_HOUR * Math.min(hoursWorked, BASE_HOURS);

		// Get wages from overtime working (if any)
		double overtimeWages = BASE_PAY_PER_HOUR * 1.5 * Math.max(0, hoursWorked - BASE_HOURS);

		// Get wages from sales commission
		double comWages = calcCommission();

		// Get bonus for being a manager
		int managerBonus = (isManager ? MANAGER_BONUS : 0);

		return baseWages + overtimeWages + comWages + managerBonus;
	}
	
	/** 
	 *  Calculates commission from sales of a worker and the given bounds
	 *  and percentages for commission in a company
	 *  @return the commission earned by the worker
	 */
	private double calcCommission()
	{
		if (weeklySales <= COMMISSION_UPPER_BOUNDS[0])
			return weeklySales * COMMISSION_PERCENTAGES[0];
		else if (weeklySales <= COMMISSION_UPPER_BOUNDS[1])
			return weeklySales * COMMISSION_PERCENTAGES[1];
		else
			return weeklySales * COMMISSION_PERCENTAGES[2];
	}
	
	/** Retrieves the employee's name
	 *  @return the name of this employee
	 */
	public String getName()
	{
		return employee;
	}
	
	/** Reports whether or not this employee is a manager
	 *  @return true if this employee is a manager, false otherwise
	 */
	public boolean isManager()
	{
		return isManager;
	}
	
	/** Retrieves the number of hours worked 
	 *  @return the number of hours worked this pay period
	 */
	public double getHours()
	{
		return hoursWorked;
	}

	/** Resets the number of hours worked to newHours
	 *  @param newHours the number of hours worked this pay period
	 */
	public void setHours(double newHours)
	{
		hoursWorked = newHours;
	}

	/** Retrieves the total amount of sales generated 
	 *  @return the total amount of sales generated this pay period
	 */
	public double getSales()
	{
		return weeklySales;
	}

	/** Resets the amount of sales generated to newSales
	 *  @param newSales the total amount of sales generated this pay period
	 */
	public void setSales(double newSales)
	{
		weeklySales = newSales;
	}
}