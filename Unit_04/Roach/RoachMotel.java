/** 
 * The RoachMotel Class establishes populations of roaches in a lab and a kitchen,
 * allows them to grow over time, and finally sprays insecticide to reduce the
 * population. Along the way, populations are printed to show users how the number
 * of roaches changes over time.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 10/01/2018
 */
 
import java.util.Scanner;

public class RoachMotel 
{
	public static void main(String[] args) 
	{
		/*
		 * 70-point version
		 */

		// Using the default constructor, declare and instantiate a 
		// RoachPopulation object to represent the roach population 
		// in the computer lab. 
		// Display the initial population using the accessor method.
		
		RoachPopulation labRoaches = new RoachPopulation();
		System.out.printf("My lab has an initial population of %d roaches.\n\n", labRoaches.getRoaches());


		// Using the starting population provided by the user and 1-parameter
		// constructor, declare and instantiate a RoachPopulation object to
		// represent the roach population in your kitchen. 
		// Display initial population using the accessor method.
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter starting population of the kitchen (an integer): ");
		int initialPopulation = scan.nextInt();

		RoachPopulation kitchenRoaches = new RoachPopulation(100);
		System.out.printf("My kitchen has an initial population of %d roaches.\n\n", kitchenRoaches.getRoaches());

		/*
		 * 85-point version
		 */

		// Wait for the kitchen population to double and display the results
		
		System.out.printf("Waiting for the kitchen population to grow....\n");
		kitchenRoaches.waitForDoubling();
		System.out.printf("My kitchen now has %d roaches.\n\n", kitchenRoaches.getRoaches());
		
		// Wait for the lab population to double and display the results

		System.out.printf("Waiting for the lab population to grow....\n");
		labRoaches.waitForDoubling();
		System.out.printf("My lab now has %d roaches.\n\n", labRoaches.getRoaches());

		/*
		 * 100-point version (uncomment section below)
		 */
		// Spray insecticide in the kitchen and display the results
		System.out.print("Enter strength of kitchen insecticide used (ex, 22.75): ");
		double kitchenSpray = scan.nextDouble();
		
		int numKilled = kitchenRoaches.spray(kitchenSpray);
		int numRemaining = kitchenRoaches.getRoaches();
		System.out.printf("My kitchen now has %d roaches after killing %d roaches.\n\n", numRemaining, numKilled);

		// Spray insecticide in the lab and display the results
		System.out.print("Enter strength of lab insecticide used (ex, 22.75): ");
		double labSpray = scan.nextDouble();
		
		numKilled = labRoaches.spray(labSpray);
		numRemaining = labRoaches.getRoaches();
		System.out.printf("My lab now has %d roaches after killing %d roaches.\n\n", numRemaining, numKilled);
		
	}
}
		
		
