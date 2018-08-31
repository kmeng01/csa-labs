/** 
 * The BugLandRunner class DOES SOMETHING
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: SOMETHING
 */

import java.awt.Color;
import java.util.Random;
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
		
		// Initialize arrays with information for each bug
		
		Location[] bugLocs = {new Location(0,4), new Location(5,0), new Location(9,5), new Location(4,9)};
		Color[] bugColors = {Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA};
		int[] bugDirs = {135, 45, -45, 225};
		
		// Add all bugs to world in specifically designated locations, bugColors, and directions
		for (int i=0; i<4; i++)
		{
			Bug tempBug = new Bug(bugColors[i]);
			tempBug.setDirection(bugDirs[i]);
			world.add(bugLocs[i], tempBug);
		}
		
		// Define matrix describing rock locations

		int[][] rockPos = {{5, -1, -1, 1}, {-1, 4, 1, 1}, {4, 10, 1, -1}, {10, 5, -1, -1}};

		// Fill in rocks at designated positions with different randomized colors
		
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
			{
				float r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat();
				Rock tempRock = new Rock(new Color(r, g, b));
				world.add(new Location(rockPos[i][0] += rockPos[i][2], rockPos[i][1] += rockPos[i][3]), tempRock);
			}
		}
		
		// Show the world in GUI
		world.show();
	}
}