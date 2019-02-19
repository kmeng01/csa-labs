/**
 * The StudentGroup Class provides functionality to search and sort
 * an array using a variety of algorithms.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 02/19/2019
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudentGroup 
{
	// Maximum number of students stored in array
	private final static int MAX_STUDENTS = 200;
	
	// Instance variables
	private Student[] students;	// array of Student objects
	private int numStudents;	// number of actual objects in array

	/** Constructs an empty student group with capacity for MAX_STUDENTS
	 */
	public StudentGroup() 
	{
		students = new Student[MAX_STUDENTS];
		numStudents = 0;
	}
	
	/** Constructs a student group with capacity for MAX_STUDENTS
	 *  and populates it with the student data found in the given file
	 *  @param fileName name of file containing student data
	 */
	public StudentGroup(String fileName) 
	{
		students = new Student[MAX_STUDENTS];
		numStudents = 0;
		readFile(fileName);
	}

	/**
	 * Given array of students, finds student with target name
	 * and gives the student object
	 * @param name target name to find
	 * @return student object if name found, otherwise null
	 */
	public Student findByName(String name) 
	{
		for (int i = 0; i < numStudents; i++)
		{
			if (students[i].getName().equals(name))
				return students[i];
		}
		return null;
	}
	
	/**
	 * Sorts students array by student name using the insertion sort
	 * algorithm
	 */
	public void sortByName() 
	{
		for (int i = 1; i < numStudents; i++)
		{
			Student cur = students[i];
			int j = i - 1;
			while (j >= 0 && students[j].getName().compareTo(cur.getName()) > 0)
			{
				students[j + 1] = students[j];
				j--;
			}
			students[j + 1] = cur;
		}
	}

	/**
	 * Sorts students array by ID using the selection sort
	 * algorithm
	 */
	public void sortByID() 
	{
		for (int i = 0; i < numStudents - 1; i++)
		{
			int mIdx = i;
			for (int j = i; j < numStudents; j++)
			{
				if (students[j].getID() < students[mIdx].getID())
				{
					mIdx = j;
				}
			}
			// swap i and j
			Student tempI = students[i];
			students[i] = students[mIdx];
			students[mIdx] = tempI;
		}
	}

	/**
	 * Given a sorted array of students and a target array that is 
	 * sorted by ID, returns the student object with the ID.
	 * @param id target ID number to find
	 * @return student object if found, null otherwise
	 */
	public Student findByID(int id) 
	{
		int lo = 0, hi = numStudents - 1;
		while (lo <= hi)
		{
			int mid = (lo + hi) / 2;
			int num = students[mid].getID();
			if (num == id)
				return students[mid];
			else if (num < id)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return null;
	}

	/** Provides the group of students
	 *  @return the group of students as a string
	 */
	@Override
	public String toString() 
	{
		String str = "[";
		for (int index = 0; index < numStudents; index++) 
		{
			str += students[index].toString();
			if (index == numStudents - 1) 
				str += "]";
			else
				str += ",\n ";
		}
		return str;
	}

	/** Reads student entries from a given file and stores them in the array
	 *  @param fileName name of file containing student data in format
	 *         LAST<space>FIRST<space>ID<space>GPA
	 */
	private void readFile(String fileName) 
	{
		try 
		{
			// Open file for reading
			Scanner scan = new Scanner(new FileReader(fileName));
			
			// Continue reading and adding students until  no more entries
			// Entries are in form LAST<space>FIRST<space>ID<space>GPA
			while (scan.hasNextLine()) 
			{						
				String inputStr = scan.nextLine();
				Scanner strScan = new Scanner(inputStr);
				String lastName = strScan.next();
				String firstName = strScan.next();
				int id = strScan.nextInt();
				double gpa = strScan.nextDouble();

				Student stu = new Student(lastName, firstName, id, gpa);
				students[numStudents] = stu;
				numStudents++;
			}
			scan.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Error reading from file " + fileName +
									  "\nError:  " + e.getMessage());
		} 
		catch (Exception e) 
		{
			System.out.println("Error reading from file " + fileName +
									  "\nError:  " + e.getMessage());
		}
	}
}