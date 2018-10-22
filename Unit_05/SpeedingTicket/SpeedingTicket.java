/** 
 * The SpeedingTicket Class accepts a person's name and information about their speeding incident
 * and outputs the price of their speeding ticket.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 10/18/2018
 */

import java.util.*;

public class SpeedingTicket 
{
	// Predefined constants
	private static final int MIN_COST = 50;
	private static final int STD_PER_EXCESS_SPEED = 7;
	private static final int SCHOOL_PER_EXCESS_SPEED = 15;
	private static final int EXCESSIVE_SPEED = 30;
	private static final int EX_SPEED_ADD_COST = 175;
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		// Scan in driver's information
		System.out.print("Enter driver's name: ");
		String name = sc.nextLine();
		System.out.print("Enter driver's speed: ");
		int speed = sc.nextInt();
		System.out.print("Enter speed limit: ");
		int speedLim = sc.nextInt();
		System.out.print("Was driver in school zone? ");
		String schoolZone = sc.next();

		// Calculate and display speeding ticket price
		int ticketPrice = calcTicket(speed, speedLim, schoolZone);
		System.out.printf("\nSpeed traveled: %3d\nSpeed limit: %6d\nIn school zone: %3s\n%s owes $%d\n\n",
			speed, speedLim, schoolZone, name, ticketPrice);	

		sc.close();
	}

	/**
	 * Calculates the price of the speeding ticket given information about the incident.
	 * 
	 * @param speedDriving speed at which driver was driving
	 * @param speedLimit speed limit at location of incident
	 * @param schoolZone whether location was within school zone or not
	 * @return calculated price of speeding ticket
	 */ 
	public static int calcTicket(int speedDriving, int speedLimit, String schoolZone)
	{
		// Handle case of no ticket
		if (speedDriving <= speedLimit)
			return 0;
		
		int ticketPrice = MIN_COST;

		// Handle case of driver in school zone or not
		if (schoolZone.equalsIgnoreCase("yes"))
			ticketPrice += (speedDriving - speedLimit) * SCHOOL_PER_EXCESS_SPEED;
		else
			ticketPrice += (speedDriving - speedLimit) * STD_PER_EXCESS_SPEED;

		// Handle case of driver being more than EXCESSIVE_SPEED over the limit
		if (speedDriving - speedLimit > EXCESSIVE_SPEED)
			ticketPrice += EX_SPEED_ADD_COST;

		return ticketPrice;
	}
}		
