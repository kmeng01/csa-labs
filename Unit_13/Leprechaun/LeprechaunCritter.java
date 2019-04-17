/**
 * The LeprekanCritir Class provides functionality for a Leprikin to
 * go around and steel gold from pots.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 4/17/2019
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class LeprechaunCritter extends Critter
{
	private int purse;
	
	/**
	 * Constructor with no params
	 */
	public LeprechaunCritter()
	{
		purse = 0;
	}

	/**
	 * Constructor with one param
	 * @param start starting value of purse
	 */
	public LeprechaunCritter(int start)
	{
		purse = start;
	}

	/**
	 * Gets value of purse in Leprechaun
	 * @return money in purse
	 */
	public int getPurse()
	{
		return purse;
	}

	/**
	 * Attemps to steal gold from pots of gold in surrounding 
	 * eight (8) spaces
	 * @param actors list of neighboring actor objects
	 */
	@Override
	public void processActors(ArrayList<Actor> actors)
	{
		int mxValue = Integer.MIN_VALUE;
		PotOfGold mxPot = null;

		for (Actor a : actors)
		{
			if (a instanceof PotOfGold && ((PotOfGold) a).getValue() > mxValue)
			{
				mxValue = ((PotOfGold) a).getValue();
				mxPot = (PotOfGold) a;
			}
		}

		if (mxPot != null)
		{
			mxPot.wipeValue();
			purse += mxValue;
		}
	}

	/**
	 * Moves and sets location of Leprechauns
	 * @param loc new location to move to
	 */
	@Override
	public void makeMove(Location loc)
	{
		setDirection(getLocation().getDirectionToward(loc));
		super.makeMove(loc);
	}

	/** Turns off the color on the critter's image
	 */
	public Color getColor()
	{
		return null;
	}
}