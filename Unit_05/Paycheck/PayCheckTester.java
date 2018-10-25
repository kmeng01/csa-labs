
  
import java.text.DecimalFormat;
import java.util.Scanner;

public class PayCheckTester 
{
	public static void main(String[] args) 
	{
		// Input name and type of worker
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter employee's name: ");
		String name = scan.nextLine();
		
		System.out.print("Enter M (Manager) or S (Sales Clerk): ");
		String type = scan.next();
		System.out.println();
		
		// Check for manager status
		boolean isManager = type.equalsIgnoreCase("M");

		// Declare and instantiate a Paycheck object
		PayCheck employee = new PayCheck(name, isManager);
		
		// Set the hours and sales. Display the expected wage
		changeHoursAndSales(scan, employee);
		displayWages(employee);
		System.out.println();
		
		// Change the hours and sales. Display the expected wage
		changeHoursAndSales(scan, employee);
		displayWages(employee);
	}
	
	/** Updates worker's weekly hours and sales with information
	 *  input by the user
	 *  @param scan the Scanner to use to get input from user
	 *  @param worker the Paycheck to update
	 */
	public static void changeHoursAndSales(Scanner scan, PayCheck worker)
	{
		System.out.print("Enter total number of hours worked: ");
		double hours = scan.nextDouble();
		
		System.out.print("Enter total sales generated: ");
		double sales = scan.nextDouble();
		System.out.println();
		
		// Update PayCheck object's hours and sales
		worker.setHours(hours);
		worker.setSales(sales);
	}
	
	public static void displayWages(PayCheck worker)
	{
		// Create decimal format object to remove training zeros in printing
		// doubles with printf()
		DecimalFormat df = new DecimalFormat("0.#");

		// Print information
		System.out.printf("%s %s: %s hours, $%.2f in sales\n", 
			(worker.isManager() ? "Manager" : "Employee"),
			worker.getName(), df.format(worker.getHours()), worker.getSales());
		System.out.printf("Total wages: $%.2f\n", worker.calcWages());
	}
}