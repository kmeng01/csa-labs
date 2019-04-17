/**
 * The PotOfGold Class provides functionality for a Pot of Gold to gain
 * value and get its contents stolen by annoying Leprikins.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 4/17/2019
 */

import info.gridworld.actor.Actor;
import java.awt.Color;

public class PotOfGold extends Actor
{
	private static final int MIN_INCREASE = 1, MAX_INCREASE = 10;
	private int goldValue;
	
	/**
	 * Constructor to initialize PotOfGold w/ two params
	 * @param goldValue value of gold to start with
	 * @param clr color to init with
	 */
	public PotOfGold(int goldValue, Color clr)
	{
		this.goldValue = goldValue;
		setColor(clr);
	}

	/**
	 * Gets value of gold in pot
	 * @return amt of gold
	 */
	public int getValue()
	{
		return goldValue;
	}

	/**
	 * Wipes value of gold pot
	 */
	public void wipeValue()
	{
		goldValue = 0;
	}

	/**
	 * Updates value of gold in pot
	 */
	@Override
	public void act()
	{
		goldValue += (int) (Math.random() * (MAX_INCREASE - MIN_INCREASE + 1)) + MIN_INCREASE;
	}

	/** Retrieves the value for displaying on the grid
	 */
	public String getText()
	{
		return Integer.toString(goldValue);
	}
}