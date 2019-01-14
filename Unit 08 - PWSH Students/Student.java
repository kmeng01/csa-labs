/**
 *  Student.java
 *  Represents a student that has a name, GPA, and grade level.
 *  Provides ability to retrieve name, GPA, and grade level, as well as
 *  change the GPA. 
 *  @author Tracy Ishman
 *  Date: 01-09-2015
 */

public class Student 
{
	/** Name of the student */
	private String name;
	
	/** GPA of the student */
	private double gpa;
	
	/** Grade level of the student */
	private int gradeLevel;

	/** Constructs a student with the given name, GPA, and grade level
	 *  @param stuName the student's name
	 *  @param stuGPA the student's GPA
	 *  @param stuGradeLevel the student's grade level
	 */
	public Student(String stuName, double stuGPA, int stuGradeLevel) 
	{
		name = stuName;
		gpa = stuGPA;
		gradeLevel = stuGradeLevel;
	}

	/** Retrieves the student's name
	 *  @return the name of the student
	 */
	public String getName()
	{
		return name;
	}

	/** Retrieves the student's GPA
	 *  @return the GPA of the student
	 */
	public double getGPA()
	{
		return gpa;
	}
	
	/** Changes the student's current GPA to newGPA
	 *  @param newGPA the new GPA of the student
	 */
	public void updateGPA(double newGPA)
	{
		gpa = newGPA;
	}

	/** Retrieves the student's grade level
	 *  @return the grade level of the student
	 */
	public int getGradeLevel()
	{
		return gradeLevel;
	}
	
	/** Retrieves the student's information as a string
	 *  @return the student information
	 */
	@Override
	public String toString()
	{
		return String.format(name + " %.5f " + gradeLevel, gpa);
	}	
}