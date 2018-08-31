/** 
 * The BugLandRunner class creates 5 bugs and 12 rocks on a graphical user interface, 
 * moves the 5th bug twice, and retrieves positional information about the 5th bug.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 09/04/2018
 */

import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

public class BugLandRunner
{
	public static void main(String[] args)
	{
		// Create Random and ActorWorld objects necessary for execution of program

		Random rand = new Random();
		ActorWorld world = new ActorWorld();
		
		// Create ArrayLists to store all bugs and rocks

		ArrayList<Bug> bugList = new ArrayList<Bug>();
		ArrayList<Rock> rockList = new ArrayList<Rock>();

		// Initialize arrays with information for each bug
		
		Location[] bugLocs = {
			new Location(0, 4), new Location(5, 0), new Location(9, 5), new Location(4, 9)};
		Color[] bugColors = {Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA};
		int[] bugDirs = {135, 45, -45, 225};
		
		// Add all bugs to world in specifically designated locations, bugColors, and directions
		
		for (int i = 0; i < 4; i++)
		{
			Bug tempBug = new Bug(bugColors[i]);
			tempBug.setDirection(bugDirs[i]);
			world.add(bugLocs[i], tempBug);
			bugList.add(tempBug);
		}
		
		// Define matrix describing rock locations

		int[][] rockPos = {{5, -1, -1, 1}, {-1, 4, 1, 1}, {4, 10, 1, -1}, {10, 5, -1, -1}};

		// Fill in rocks at designated positions with different randomized colors
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4 ; j++)
			{
				float r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat();
				Rock tempRock = new Rock(new Color(r, g, b));
				world.add(
					new Location(rockPos[i][0] += rockPos[i][2], rockPos[i][1] += rockPos[i][3]),
					tempRock);
				rockList.add(tempRock);
			}
		}

		// Create a 5th bug

		Bug fifthBug = new Bug();
		world.add(fifthBug);

		// Move 5th bug twice

		fifthBug.act();
		fifthBug.act();

		// Retrieve direction and location of 5th bug

		int fifthBugDir = fifthBug.getDirection();
		Location fifthBugLoc = fifthBug.getLocation();
		System.out.println("Direction: " + fifthBugDir + "\nLocation: " + fifthBugLoc);

		// Show the world in GUI
		world.show();
	}
}