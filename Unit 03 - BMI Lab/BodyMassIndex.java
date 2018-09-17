// add your 6-item heading here 

import java.util.Scanner;

public class BodyMassIndex 
{
	// Define constants for unit conversions
	
	public static final double CM_IN_M = 100.0;
	public static final double KG_IN_LB = 0.453592;
	public static final double CM_IN_IN = 2.54;

	// Create global Scanner object

	public static Scanner sc = new Scanner(System.in);
	
	// Do not make any changes to the main!
	public static void main(String[] args) 
	{
		// 80-point version
		// Input user's weight and height in metric units and calculate BMI
		calculateMetricBMI();
		System.out.println();
		
		// 100-point version
		// Input user's weight and height in imperial units and calculate BMI
		calculateImperialBMI();
		System.out.println();
	}
	
	/** 
	 */
	public static void calculateMetricBMI()
	{
		int weightKG, heightCM;

		System.out.print("Enter your weight in kilograms: ");
		System.out.flush();
		weightKG = sc.nextInt();

		System.out.print("\nEnter your height in centimeters: ");
		System.out.flush();
		heightCM = sc.nextInt();

		double bmi = getBMI(weightKG, heightCM);
		System.out.printf("\nA body mass index of 20 - 25 is considered \"normal\"\n");
		System.out.printf("Your BMI is %.2f\n\n", bmi);
	} 
		
	
	/** 
	 */ 
	public static double getBMI(int weightKG, int heightCM)
	{
		return (double) weightKG / (heightCM / CM_IN_M) / (heightCM / CM_IN_M);
	}
	
	/** 
	 */
	public static void calculateImperialBMI()
	{
		int weightLB, heightIN;

		System.out.print("Enter your weight in pounds: ");
		System.out.flush();
		weightLB = sc.nextInt();

		System.out.print("\nEnter your height in inches: ");
		System.out.flush();
		heightIN = sc.nextInt();

		int weightKG = convertPoundsToKG(weightLB);
		int heightCM = convertInchesToCM(heightIN);

		double bmi = getBMI(weightKG, heightCM);
		System.out.printf("\nA body mass index of 20 - 25 is considered \"normal\"\n");
		System.out.printf("Your BMI is %.2f\n\n", bmi);

		sc.close();
	}
	
	/** 
	 */
	public static int convertPoundsToKG(int numPounds)
	{
		return (int) Math.round((double) numPounds * KG_IN_LB);
	}
	
	/** 
	 */
	public static int convertInchesToCM(int numInches)
	{
		return (int) Math.round((double) numInches * CM_IN_IN);
	}
}