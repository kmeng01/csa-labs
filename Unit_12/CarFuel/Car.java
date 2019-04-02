/**
 * The Car class provides the structure for keeping track of a vehicle's details,
 * including odometer level, fuel level, etc.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 4/3/2019
 */

import javax.xml.bind.annotation.XmlElement.DEFAULT;

public class Car
{
	/** Default initialization values */
	public static final int DEFAULT_YEAR = 1999;
	public static final String DEFAULT_MAKE_MODEL = "Ford Pinto";
	public static final double DEFAULT_CAPACITY = 14.5;
	public static final int DEFAULT_MPG = 24;

	/** Manages unique ID numbers for all cars */
	private static int nextVIN = 1001;

	/** the car's model year */
	private int year;

	/** the make and model of the car */
	private String makeAndModel;

	/** the car's unique VIN (Vehicle Identification Number) */
	private int vin;

	/** the current mileage on the car */
	private double odometer;

	private double gallons;
	private double capacity;
	private int mpg;

	/** Constructs a Car with default settings
	 */
	public Car()
	{
		year = DEFAULT_YEAR;
		makeAndModel = DEFAULT_MAKE_MODEL;
		gallons = 0;
		capacity = DEFAULT_CAPACITY;
		mpg = DEFAULT_MPG;
		vin = getNextVIN();
		odometer = 0;
	}

	/** Create a car with the given name, year, and odometer
	 *  @param year the year the car was manufactured
	 *  @param makeAndModel the car's make and model
	 *  @param odometer the current mileage on the car
	 */
	public Car(int year, String makeAndModel, double odometer)
	{
		this.year = year;
		this.makeAndModel = makeAndModel;
		this.odometer = odometer;
		this.gallons = 0;
		this.capacity = DEFAULT_CAPACITY;
		this.mpg = DEFAULT_MPG;
		this.vin = getNextVIN();
	}

	/**
	 * Create a car with the 6 given parameters
	 * @param year year manufactured
	 * @param makeAndModel make and model of car
	 * @param odometer current mileage
	 * @param gallons number of gallons in fuel tank
	 * @param capacity max capacity of tank
	 * @param mpg miles per gallon efficiency of car
	 */
	public Car(int year, String makeAndModel, double odometer, double gallons, double capacity, int mpg)
	{
		this.year = year;
		this.makeAndModel = makeAndModel;
		this.odometer = odometer;
		this.gallons = gallons;
		this.capacity = capacity;
		this.mpg = mpg;
		this.vin = getNextVIN();
	}

	/** Change the make and model of this car
	 *  @param newMakeAndModel the new Make and Model
	 */
	public void changeMakeAndModel(String newMakeAndModel)
	{
		makeAndModel = newMakeAndModel;
	}

	/** Drives the car a given number of miles
	 *  @param miles the number of miles driven
	 */
	public void drive(double miles)
	{
		double needGas = miles / mpg;
		if (gallons < needGas)
		{
			odometer += mpg * gallons;
			gallons = 0;
		}
		else
		{
			gallons -= miles / mpg;
			odometer += miles;
		}
	}

	/**
	 * Refill tank to max capacity
	 * @return always returns true
	 */
	public boolean addFuel()
	{
		gallons = capacity;
		return true;
	}

	/**
	 * Adds amount of fuel if possible, otherwise fills tank to capacity
	 * @param amt amount of fuel to add
	 * @return true if adding amt does not overflow tank, otherwise false
	 */
	public boolean addFuel(double amt)
	{
		if (gallons + amt > capacity)
		{
			gallons = capacity;
			return false;
		}
		gallons += amt;
		return true;
	}

	/** Drives the car a given number of miles per day
	 *  @param daysDriven the number of days of driving
	 *  @param milesPerDay the number of miles driven per day
	 */
	public void drive(int daysDriven, double milesPerDay)
	{
		double totalMiles = daysDriven * milesPerDay;
		drive(totalMiles);
	}

	/** Retrieves the current mileage on the odometer
	 *  @return the odometer setting
	 */
	public double getMileage()
	{
		return odometer;
	}

	/** Retrieves the car's VIN
	 *  @return the VIN
	 */
	public int getVIN()
	{
		return vin;
	}

	/**
	 * Returns number of gallons in tank
	 * @return number of gallons in fuel tank
	 */
	public double getFuelLevel()
	{
		return gallons;
	}

	/** Provides this car's information in a string
	 *  @return car info as a string
	 */
	@Override
	public String toString()
	{
		return year + " " + makeAndModel + " " + vin + " " + String.format("%,.1f %,.4f %,.3f %d", odometer, gallons, capacity, mpg);
	}

	/** Determines if 2 cars are the same based on its VIN
	 *  @param obj the car to compare to this one
	 *  @return true if this and obj have the same VIN, false otherwise
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof Car))
			return false;

		Car otherCar = (Car) obj;
		return this.vin == otherCar.vin;
	}

	/** Calculates and returns the next VIN for any car
	 *  @return unique VIN for a car
	 */
	private static int getNextVIN()
	{
		int newVIN = nextVIN;
		nextVIN++;
		return newVIN;
	}
}