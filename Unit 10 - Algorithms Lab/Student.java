/**
 * Student.java
 * Student Class - Stores the information from a student, implementing 
 * the Comparable interface and overriding the equals method to
 * support searching and sorting
 */

public class Student implements Comparable<Student>
{
	// Instance Variables
	private String lastName;
	private String firstName;
	private int id;
	private double gpa;
	
	/** Constructs a student with the given information
	 *  @param last the student's last name
	 *  @param first the student's first name
	 *  @param idNum the student's ID number
	 *  @param gpaVal the student's GPA
	 */
	public Student(String last, String first, int idNum, double gpaVal) 
	{
		lastName = last;
		firstName = first;
		id = idNum;
		gpa = gpaVal;
	}
	
	/** Provides the name of the student in the format Last, First
	 *  @return the student's name as Last, First
	 */
	public String getName() 
	{
		return lastName + ", " + firstName;
	}
	
	/** Provides the ID number of the student
	 *  @return the student's ID number
	 */
	public int getID() 
	{
		return id;
	}
		
	/** Provides the GPA of the student 
	 *  @return the student's GPA
	 */
	public double getGPA() 
	{
		return gpa;
	}
	
	/** Returns whether or not 2 students are the same based on their IDs
	 *  @param obj the Student object to compare against this one
	 *  @return true if this and obj have the same ID number; false otherwise
	 */ 
	@Override
	public boolean equals(Object obj) 
	{
		if (obj == null || getClass() != obj.getClass())
			return false;
		
		Student other = (Student) obj;
		return getID() == other.getID();
	}
	
	/** Compares 2 students based on their ID number
	 *  @param other the Student object to compare against this one
	 *  @return integer value == 0 if this.equals(other) 
	 *                         < 0 if this ID < other ID 
	 *                         > 0 if this ID > other ID
	 */ 
	@Override
	public int compareTo(Student other) 
	{
		if (this.equals(other)) 
			return 0;
		
		return this.getID() - other.getID();
	}
	
	/** Provides the student's information as a string
	 *  @return this object as a string
	 */
	@Override
	public String toString() 
	{
		return getName() + "  " + getID() + "  " 
			+ String.format("%.3f", getGPA());
	}
}