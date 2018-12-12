/**
 * The Files Lab class is runs a series of commands
 * to both extract data from and write data to text
 * files. It employs exception handling to improve
 * robustness against negative tests.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 12/13/2018
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilesLab 
{
	public static void main(String[] args) 
	{
		try
		{
			// run 70-point version
			processIntegers("test1.txt", "output1.txt");
			System.out.println();
			
			// run 85-point version
			testLines("test2a.txt", "output2a.txt");
			
			// run 85-point version
			testLines("test2b.txt", "output2b.txt");
			System.out.println();
			
			// run 100-point version - good data
			extractSubstrings("test3a.txt", "output3a.txt");		
			
			// run 100-point version - bad data
			extractSubstrings("test3b.txt", "output3b.txt");		
			System.out.println();
		}
		catch (Exception exc)
		{
			System.out.println("Error opening file: " + exc.getMessage());
		}
	}
	
	/**
	 * Reads in integer N, which represents the number of triplets, from inFile.
	 * For each triplet, the minimum and maximum value in the triplet is written
	 * to outFile.
	 * 
	 * @param inFile name of input file
	 * @param outFile name of output file
	 * @throws FileNotFoundException if either inFile or outFile is not found
	 */
	public static void processIntegers(String inFile, String outFile) throws FileNotFoundException
	{
		// declare and instantiate input/output streams
		Scanner sc = new Scanner(new File(inFile));
		PrintWriter pw = new PrintWriter(new File(outFile));

		int N = sc.nextInt();
		for (int i = 0; i < N; i++)
		{
			int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
			for (int j = 0; j < 3; j++)
			{
				int cur = sc.nextInt();
				mn = Math.min(mn, cur);
				mx = Math.max(mx, cur);
			}
			pw.println(mn + "  " + mx);
		}

		// update msg
		System.out.println("Smallest and largest integers from " + inFile 
			+ " written to " + outFile);

		// close streams
		sc.close();
		pw.close();
	}
	
	/**
	 * Reads in a string to find from inFile. For each following line in inFile,
	 * the line is printed to outFile if the string to find is contained in the sentence.
	 * Case does not matter.
	 * 
	 * @param inFile name of input file
	 * @param outFile name of output file
	 * @throws FileNotFoundException if either inFile or outFile is not found
	 */
	public static void testLines(String inFile, String outFile) throws FileNotFoundException
	{
		// declare and instantiate input/output streams
		Scanner sc = new Scanner(new File(inFile));
		PrintWriter pw = new PrintWriter(new File(outFile));

		String toFind = sc.next();
		while (sc.hasNextLine())
		{
			String line = sc.nextLine();
			String lowerLine = line.toLowerCase();
			if (lowerLine.contains(toFind.toLowerCase()))
				pw.println(line);
		}

		// update msg
		System.out.println("Lines from " + inFile + " written to " + outFile);

		// close streams
		sc.close();
		pw.close();
	}
	
	/**
	 * For each line in inFile, scans in hard left bound and soft right bound
	 * to query the substring for. Outputs substring to outFile surrounded by
	 * colons if the substring is valid. Else, an error message is written.
	 * 
	 * @param inFile name of input file
	 * @param outFile name of output file
	 * @throws FileNotFoundException if either inFile or outFile is not found
	 */
	public static void extractSubstrings(String inFile, String outFile) throws FileNotFoundException
	{
		// declare and instantiate input/output streams
		Scanner sc = new Scanner(new File(inFile));
		PrintWriter pw = new PrintWriter(new File(outFile));

		while (sc.hasNextLine())
		{
			int leftBound = sc.nextInt(), rightBound = sc.nextInt();
			String str = sc.nextLine().substring(1);

			try
			{
				String sub = getSubstring(leftBound, rightBound, str);
				pw.printf(":%s:\n", sub);
			}
			catch(IllegalArgumentException e)
			{
				pw.printf("Error in file %s: %s\n", inFile, e.getMessage());
			}
		}

		// update msg
		System.out.println("Requested substrings from " + inFile + " written to " + outFile);

		// close streams
		sc.close();
		pw.close();
	}
	
	/**
	 * Helper method to extract substring of string.
	 * 
	 * @param index1 left bound of index (inclusive)
	 * @param index2 right bound of index (exclusive)
	 * @throws IllegalArgumentException if either index is out of bounds
	 */
	private static String getSubstring(int index1, int index2, String text) throws IllegalArgumentException
	{
		try {
			return text.substring(index1, index2);
		}
		catch(StringIndexOutOfBoundsException e)
		{
			throw new IllegalArgumentException(String.format("Invalid indexes [%d, %d] for \"%s\"", index1, index2, text));
		}
	}
}
