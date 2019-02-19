/**
 * StudentGroupTest.java
 * Test the StudentGroup class
 */

public class StudentGroupTest 
{
	public static void main(String[] args) 
	{
		StudentGroup apcs1 = new StudentGroup("apcs1.txt");
		System.out.println("Students\n" + apcs1 + "\n");

/*		
		// Test findByName, a linear search
		System.out.println("Searching by name:");
		String[] someNames = {"Fry, Small", "Pants, Smarty", "Dude, Big"};
		for (String name : someNames)
		{
			Student stu = apcs1.findByName(name);
			if (stu == null)
				System.out.println("Unable to find " + name);
			else
				System.out.println("Found:  " + stu.toString());
		}
		System.out.println();
*/

/*
		// Test sortByName, an Insertion Sort
		apcs1.sortByName();
		System.out.println("Students sorted by name\n" + apcs1 + "\n");
*/

/*		
		// Test sortByID, a Selection Sort
		apcs1.sortByID();
		System.out.println("Students sorted by ID\n" + apcs1 + "\n");
*/

/*		
		// Test findByID, a binary search
		System.out.println("Searching by ID:");
		int[] someIDs = {6322, 9342, 3927, 2933, 2222, 9999};
		for (int id : someIDs)
		{
			Student stu = apcs1.findByID(id);
			if (stu == null)
				System.out.println("Unable to find student with ID " + id);
			else
				System.out.println("Found:  " + stu.toString());
		}
		System.out.println();
*/
	}
}