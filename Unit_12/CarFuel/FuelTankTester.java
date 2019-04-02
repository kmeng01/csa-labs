/**
 * The FuelTankTester is the driver class for Car. It performs various operations
 * on Car objects.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 4/3/2019
 */

public class FuelTankTester
{
    public static void main(String[] args)
    {
    	// Create a Car object using the default constructor
    	// Create a Car object using the 3-parameter constructor
		// Display both cars using toString

		Car car1 = new Car();
		Car car2 = new Car(2002, "Porsche 911", 1700);

		System.out.println("Car 1: " + car1.toString());
		System.out.println("Car 2: " + car2.toString() + "\n");

    	// Drive both cars. Display each car's fuel tank level and odometer 
    	// using accessor methods (not toString)
		
		car1.drive(750);
		car2.drive(5280);

		System.out.printf("Car 1's odometer: %.1f\n", car1.getMileage());
		System.out.printf("Car 1's fuel level: %.1f\n\n", car1.getFuelLevel());

		System.out.printf("Car 2's odometer: %.1f\n", car2.getMileage());
		System.out.printf("Car 2's fuel level: %.1f\n\n", car2.getFuelLevel());

    	// 100-pt Version:
    	
    	// Create a Car object using your 6-parameter constructor
    	// Display the car using toString
	
		Car car3 = new Car(1951, "Hudson Hornet", 87293.8, 10, 18.5, 16);
		System.out.println("Car 3: " + car3 + "\n");

    	// Drive your car and add fuel, displaying the results
    	// as directed on your lab sheet

		car3.drive(100);
		System.out.printf("After 100 miles: %s\n", car3.toString());
		car3.drive(75);
		System.out.printf("After 75 miles: %s\n", car3.toString());
		car3.addFuel();
		System.out.printf("After filling tank: %.1f\n\n", car3.getFuelLevel());

		car3.drive(500);
		System.out.printf("After 500 miles: %s\n\n", car3.toString());

		double[] fuelAdd = {6.8, 11.7, 5.25};

		for (int i = 0; i < fuelAdd.length; i++)
		{
			boolean success = car3.addFuel(fuelAdd[i]);
			System.out.printf("Able to add %s gal? %b\n", fuelAdd[i], success);
			System.out.printf("Current fuel level: %.1f\n", car3.getFuelLevel());
		}

		System.out.println("Car 3: " + car3.toString());		
    }
}
