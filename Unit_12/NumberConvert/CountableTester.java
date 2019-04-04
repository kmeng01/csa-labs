/**
 *  CountableTester.java
 *  Tests the RomanNumeral and HexInteger classes
 */

public class CountableTester
{
	public static void main(String[] args)
	{
		System.out.println("---------------------------------------------------");
		System.out.println("Testing HexInteger Class - 70 pt version");
		System.out.println("---------------------------------------------------");
		test70PointVersion();

		System.out.println("---------------------------------------------------");
		System.out.println("Testing HexInteger Class - 80 pt version");
		System.out.println("---------------------------------------------------");
		test80PointVersion();

		// Uncomment these methods as you get to them
		System.out.println("---------------------------------------------------");
		System.out.println("Testing RomanNumeral Class - 90 & 100 pt versions");
		System.out.println("---------------------------------------------------");
		test90and100PointVersions();

/*
		System.out.println("---------------------------------------------------");
		System.out.println("Testing RomanNumeral Class - 110 pt version");
		System.out.println("---------------------------------------------------");
		test110PointVersion();
*/
	}
	
	/** Tests the 70-point version of the HexInteger Class
	 */
	public static void test70PointVersion()
	{	
		// Test Countable implementation
		Countable count1 = new HexInteger("CAFE");
		System.out.printf("count1: " + count1 + " = %,d%n", count1.getValue());
		
		Countable count2 = new HexInteger("A1B2");
		System.out.printf("count2: " + count2 + " = %,d%n", count2.getValue());
		System.out.println();
	}
		
	/** Tests the 80-point version of the HexInteger Class
	 */
	public static void test80PointVersion()
	{	
		// Must be declared as HexInteger to call reset methods
		HexInteger hex1 = new HexInteger(4011);
		System.out.printf("hex1: " + hex1 + " = %,d%n", hex1.getValue());

		hex1.reset(34_276_829);	
		System.out.printf("hex1: " + hex1 + " = %,d%n", hex1.getValue());

		HexInteger hex2 = new HexInteger("ABC1234");
		System.out.printf("hex2: " + hex2 + " = %,d%n", hex2.getValue());

		if (hex1.compareTo(hex2) < 0)
			System.out.println(hex1 + " is smaller than " + hex2);
		else
			System.out.println(hex2 + " is smaller than " + hex1);
		System.out.println();

		hex1.reset(1_000_000);	
		hex2.reset("D0A9");
		System.out.printf("hex1: " + hex1 + " = %,d%n", hex1.getValue());
		System.out.printf("hex2: " + hex2 + " = %,d%n", hex2.getValue());

		if (hex1.compareTo(hex2) < 0)
			System.out.println(hex1 + " is smaller than " + hex2);
		else
			System.out.println(hex2 + " is smaller than " + hex1);
		System.out.println();
	}
	
	/** Tests the 90- and 100-point versions of the RomanNumeral Class
	 */
	public static void test90and100PointVersions()
	{
		// Test Countable implementation
		Countable count3 = new RomanNumeral(1998);
		System.out.println("count3: " + count3 + " = " + count3.getValue());
		
		Countable count4 = new RomanNumeral("X"); 
		System.out.println("count4: " + count4 + " = " + count4.getValue());
		
		// Cast back to being RomanNumeral objects to test non-Countable methods
		RomanNumeral roman1 = (RomanNumeral) count3;
		RomanNumeral roman2 = (RomanNumeral) count4;

		roman1.reset("CII");
		System.out.println("roman1: " + roman1 + " = " + roman1.getValue());

		if (roman1.compareTo(roman2) < 0)
			System.out.println(roman1 + " is smaller than " + roman2);
		else
			System.out.println(roman2 + " is smaller than " + roman1);
		System.out.println();

		String[] testStrings = {"DVI", "XLV", "CDXLIV", "MMXV", "CCCXXXIII"};
		for (String str : testStrings)
		{
			roman1.reset(str);
			System.out.println("roman1: " + roman1 + " = " + roman1.getValue());
		}

		roman2.reset("MMMCMXCIX");
		System.out.println("roman2: " + roman2 + " = " + roman2.getValue());

		if (roman1.compareTo(roman2) < 0)
			System.out.println(roman1 + " is smaller than " + roman2);
		else
			System.out.println(roman2 + " is smaller than " + roman1);
		System.out.println();

	}
	
	/** Tests the 110-point versions of the RomanNumeral Class
	 */
/* Uncomment to compile and run
	public static void test110PointVersion()
	{
		RomanNumeral roman3 = new RomanNumeral(149);
		System.out.println("roman3: " + roman3 + " = " + roman3.getValue());
		
		int[] testNumbers = {45, 444, 888, 1344, 1776, 1998, 3333, 3999};
		for (int num : testNumbers)
		{
			roman3.reset(num);
			System.out.println("roman3: " + roman3 + " = " + roman3.getValue());
		}
		System.out.println();
	}
	 */
}