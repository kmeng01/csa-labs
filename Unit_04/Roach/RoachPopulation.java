/** 
 * The RoachPopulation Class represents a location and stores the number of 
 * roaches in that location. It provides a constructor to define the number 
 * of initial roaches. Also provided are methods to get the roach population,
 * wait for the population to double, and spray a poison to kill a number of 
 * roaches.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 10/01/2018
 */

public class RoachPopulation 
{
	private static final int DEFAULT_POPULATION = 10;
	
	private int numRoaches; // The roach population
	
	/** Default constructor, initializes the population to 10 
	 */
	public RoachPopulation() 
	{
		numRoaches = DEFAULT_POPULATION;
	}
	
	/** Overloaded constructor, initializes the population to user-specified integer
	 */
	public RoachPopulation(int initNum) 
	{
		numRoaches = initNum;
	}

	/** Provides the current roach population
	 *  @return number of roaches remaining
	 */
	public int getRoaches() 
	{
		return numRoaches;
	}


	/** Doubles roach population
	 */
	public void waitForDoubling() 
	{
		numRoaches *= 2;
	}
	
	/** Sprays current roach population and kills a user-specified percentage
	 *  @param killPercent percentage of roaches to kill, expressed from 0 to 100
	 *  @return number of roaches killed
	 */
	public int spray(double killPercent) 
	{
		assert(killPercent <= 100);
		int numKilled = (int) Math.ceil(numRoaches * killPercent / 100.0);
		numRoaches -= numKilled;
		return numKilled;
	}
}
	
