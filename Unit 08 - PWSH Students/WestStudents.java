// replace with heading

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WestStudents 
{
	public static void main( String[] args) 
	{
		// Populate array of Student objects
		Student[] westWolves = loadStudents();
		
		// Display the students
		showStudents(westWolves);
		
		// Calculate the average GPA of all students
		double avgGPA = calcAverageGPA(westWolves);
		System.out.printf("Average GPA: %.5f %n%n", avgGPA);
		
		// Determine the number of juniors
		int numJuniors = calcNumInGrade(westWolves, 11);
		System.out.println("Number of juniors: " + numJuniors);
		
		// Determine the number of seniors
		int numSeniors = calcNumInGrade(westWolves, 12);
		System.out.println("Number of seniors: " + numSeniors);
		System.out.println();
		
		// Bump those with GPA in range [1.9, 2.0] to 2.0
		int numChanged = bumpGPAS(westWolves, 1.9, 2.0);
		System.out.println("Bumped " + numChanged + " gpas in [1.9, 2.0]");
		
		// Bump those with GPA in range [3.55, 3.6] to 3.6
		numChanged = bumpGPAS(westWolves, 3.55, 3.6);
		System.out.println("Bumped " + numChanged + " gpas in [3.55, 3.6]");
		System.out.println();
		
		System.out.println("After bumping:");
		showStudents(westWolves);
		
		// Get the names of students graduating with honors
		String[] honorStudents = getHonorStudents(westWolves, 3.6);
		System.out.println("Honor graduates: " + Arrays.toString(honorStudents));
		System.out.println();		
	}
	
	public static void showStudents(Student[] students)
	{
		// replace statement with code to print each student on separate line
		System.out.println(Arrays.toString(students));
		
		System.out.println();
	}
	
	public static double calcAverageGPA(Student[] students)
	{
		return 0;
	}
	
	public static int calcNumInGrade(Student[] students, int grade)
	{
		return 0;
	}
	
	public static int bumpGPAS(Student[] students, double minGPA, double maxGPA)
	{
		return 0;
	}
	
	public static String[] getHonorStudents(Student[] students, double honorsGPA)
	{
		return null;
	}
	
	/** Generates and returns an array of Student objects with data from
	 *  the file PWSH_Students.txt
	 *  @return fully populated array of Student objects
	 */
	private static Student[] loadStudents()
	{
		final String INPUT_FILE = "PWSH_Students.txt";
		
		// Check if the file exists
		File input = new File(INPUT_FILE);
		if (!input.exists())
		{
			System.out.println(INPUT_FILE 
				+ " not found. Check with your teacher.");
			System.out.println("Ending program");
			System.exit(0);
		}
		
		try
		{
			Scanner reader = new Scanner(input);
			
			// read in # of students in file and create array
			int numStudents = reader.nextInt();
			Student[] wolfpack = new Student[numStudents];
			
			// read in each students' data and add to array
			for (int k = 0; k < wolfpack.length; k++)
			{
				int grade = reader.nextInt();
				double gpa = reader.nextDouble();
				String name = reader.nextLine().trim();
				
				Student stu = new Student(name, gpa, grade);
				wolfpack[k] = stu;
			}
			
			return wolfpack;
		}
		catch (IOException exc)
		{
			System.out.println(exc.getMessage());
			System.out.println("Ending program");
			System.exit(0);
		}
		return null;
	}
}