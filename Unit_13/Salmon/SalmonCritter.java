/**
 * The SalmonCritter Class provides functionality for a salmon critter
 * to traverse a GridWorld plane and reproduce.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 4/24/2019
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class SalmonCritter extends Critter
{    
    private static final Color BIRTH_COLOR = Color.ORANGE;
    private static final Color MATURE_COLOR = Color.RED;
    private static final int MATURE_AGE = 4;
    private static final int MAX_AGE = 20;
    private static final double EGG_PROB = 0.2;

    private int age;
    private boolean hasHatched;

    /**
     * Constructor for class that expicitly assigns values to instance vars
     */
    public SalmonCritter()
    {
        setDirection(Location.EAST);
        setColor(BIRTH_COLOR);
        age = 0;
        hasHatched = false;
    }

    /**
     * Hatches eggs for a mature salmon
     * @return true if at least one egg hatched else false
     */
    private boolean hatchEggs()
    {
        ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(getLocation());
        for (Location l : locs)
        {
            (new SalmonCritter()).putSelfInGrid(getGrid(), l);
        }
        return locs.size() > 0;
    }

    /**
     * Process all actors in a gridworld world @ each step
     * @param actors list of all actors
     */
    @Override
    public void processActors(ArrayList<Actor> actors)
    {
        age++;
        for (Actor a : actors)
        {
            if (a instanceof Bug)
                a.removeSelfFromGrid();
        }
        if (age >= MATURE_AGE)
        {
            setColor(MATURE_COLOR);
            if (Math.random() <= EGG_PROB)
            {
                hasHatched = hatchEggs();
            }
        }
    }

    /**
     * Choose a location to move to
     * @param locs all adjacent locs
     */
    @Override
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        if (age == MAX_AGE || hasHatched)
            return null;
        else
            return super.selectMoveLocation(locs);
    }
}