




public class RomanNumeral implements Comparable<RomanNumeral>, Countable
{
	/** array of possible Roman Numeral letters */
	private static final String[] ROMAN_LETTERS = 
		{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 
	
	/** array of values for corresponding Roman Numeral letters */
	private static final int[] ROMAN_VALUES = 
		{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; 

	/** the value as a roman numeral */
	private String romanStr;
	
	/** the roman numeral as an integer */
	private int romanInt;
	
	/** Constructs a RomanNumeral with the given roman numeral
	 *  @param romanNum a string containing a valid roman numeral
	 */
	public RomanNumeral(String romanNum)
	{
		reset(romanNum);
	}
	
	/** Constructs a roman numeral with the given decimal integer
	 *  @param num an integer from which to create a roman numeral
	 */
	public RomanNumeral(int num)
	{
		reset(num);
	}
	
	public void reset(String newRomanNum)
	{
		romanStr = newRomanNum;
		
		romanInt = 0;
		String temp = romanStr;
		for (int i = 0; i < ROMAN_LETTERS.length; i++)
		{
			String rom = ROMAN_LETTERS[i];
			while (temp.contains(rom))
			{
				temp = temp.replace(rom, "");
				romanInt += ROMAN_VALUES[i];
			}
		}
	}

	public void reset(int newNum)
	{
		romanInt = newNum;
		
		romanStr = new String("");
		while (newNum != 0)
		{
			int idx = 0;
			while (newNum - ROMAN_VALUES[idx] < 0 && idx < ROMAN_VALUES.length - 1) ++idx;
			newNum -= ROMAN_VALUES[idx];
			romanStr += ROMAN_LETTERS[idx];
		}
	}
	
	@Override
	public int getValue()
	{
		return romanInt;
	}
	
	/** Determines whether or not 2 roman numerals are the same
	 *  @param obj the other roman numeral to compare agains
	 *  @return true if this matches obj; false otherwise
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof RomanNumeral))
			return false;
		
		RomanNumeral other = (RomanNumeral) obj;
		return this.getValue() == other.getValue();
	}
	
	/** Compare 2 RomanNumeral to determine which is "smaller"
	 *  based on its decimal integer value
	 *  @param other the other RomanNumeral to compare against
	 *  @return 0 if this.equals(other) is true
	 *          < 0 if this < other
	 *          > 0 if this > other
	 */
	@Override
	public int compareTo(RomanNumeral other)
	{
		return 0;
	} 
	
	/** Provides this RomanNumeral information in a string
	 *  @return RomanNumeral info as a string
	 */
	@Override
	public String toString()
	{
		return romanStr;
	}
	
}