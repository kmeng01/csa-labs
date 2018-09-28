

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
	}
	
	/**
	 */
	public int spray(double killPercent) 
	{
		return 0;
	}
}
	