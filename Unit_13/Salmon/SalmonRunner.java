/**
 * The SalmonRunner Class is the runner class for the 
 * SalmonCritter class.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 4/24/2019
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

public class SalmonRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		
		// Add a SalmonCritter in the upper left-hand corner surrounded by rocks
		world.add(new Location(0, 1), new Rock(Color.CYAN));
		world.add(new Location(1, 0), new Rock(Color.CYAN));
		world.add(new Location(1, 1), new Rock(Color.CYAN));
		world.add(new Location(0, 0), new SalmonCritter());
		
		// Place bugs, rocks, and another salmon in random locations

		for (int i = 0; i < 10; i++)
		{
			world.add(world.getRandomEmptyLocation(), new Rock());
		}
		for (int i = 0; i < 10; i++)
		{
			world.add(world.getRandomEmptyLocation(), new Bug());
		}
		world.add(world.getRandomEmptyLocation(), new SalmonCritter());

		// Do not delete this statement		
		world.show();
	}
}