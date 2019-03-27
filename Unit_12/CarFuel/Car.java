

public class Car
{
	/** Default initialization values */
	public static final int DEFAULT_YEAR = 1999;
	public static final String DEFAULT_MAKE_MODEL = "Ford Pinto";

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

	/** Constructs a Car with default settings
	 */
	public Car()
	{
		year = DEFAULT_YEAR;
		makeAndModel = DEFAULT_MAKE_MODEL;
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
		odometer += miles;
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

	/** Provides this car's information in a string
	 *  @return car info as a string
	 */
	@Override
	public String toString()
	{
		return year + " " + makeAndModel + " " + vin + " " + String.format("%,.1f", odometer);
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