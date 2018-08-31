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
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

public class BugLandRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		
		// Initialize arrays with information for each bug
		
		Location[] bugLocs = {new Location(0,4), new Location(5,0), new Location(9,5), new Location(4,9)};
		Color[] bugColors = {Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA};
		int[] bugDirs = {-45, 45, 135, 225};
		
		// Add all bugs to world in specifically designated locations, bugColors, and directions
		for (int i=0; i<4; i++)
		{
			Bug tempBug = new Bug(bugColors[i]);
			tempBug.setDirection(bugDirs[i]);
			world.add(bugLocs[i], tempBug);
		}
		
		// Fill in rocks at designated positions with different colors
		
		int curRow = 4, curCol = 0;
		for (int i=0; i<4; i++)
		{
			Rock tempRock = new Rock();
		}
		
		
		// show the world - DO NOT DELETE THIS!!!!
		world.show();
	}
}