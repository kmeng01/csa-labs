/**
 * The LeprekanRunir Class is the driver class for the rest of the
 * files in this assignment. It creates all objects necessary.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 4/17/2019
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import java.awt.Color;

public class LeprechaunRunner
{
	private static final int INIT_GOLD = 10;

	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		
		// Adding some rocks and flowers at random locations
		for (int k = 0; k < 5; k++)
		{
			world.add(new Flower(Color.cyan));
			world.add(new Rock(Color.green));
		}
	
		// Add 10 PotOfGold objects with different colors and values to grid

		for (int i = 0; i < 10; i++)
		{
			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
			world.add(new PotOfGold(INIT_GOLD, new Color(r, g, b)));
		}

		// Add 2 LeprechaunCritter objects to grid using both constructors
	
		world.add(new LeprechaunCritter());
		world.add(new LeprechaunCritter(10));

		world.show();
	}
}