/** 
 * The ComedyOfErrors Class converts a given temperature in degres
 * Celcius to its corresponding value in Fahrenheit using the formula
 * F = 1.8 x C + 32
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
	
	private int numRoaches;		// The roach population
	
	/** Default constructor, initializes the population to 10 
	 */
	public RoachPopulation() 
	{
		numRoaches = DEFAULT_POPULATION;
	}
	
	/** Default constructor, initializes the population to 10 
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


	/**
	 */
	public void waitForDoubling() 
	{
		numRoaches *= 2;
	}
	
	/**
	 */
	public int spray(double killPercent) 
	{
		assert(killPercent < 100);
		int numKilled = (int) Math.ceil(numRoaches * killPercent / 100.0);
		numRoaches -= numKilled;
		return numKilled;
	}
}
	
