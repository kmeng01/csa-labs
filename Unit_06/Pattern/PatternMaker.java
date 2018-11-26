/**
 * The PatternMaker Class draws a series of 4 patterns on the GridWorld GUI
 * based on pre-defined requirements.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 11/15/2018
 */

import java.awt.Color;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class PatternMaker
{
	/** Dimensions for the different worlds */
	public static final int NUM_ROWS_NUMBER_GRID = 10;
	public static final int NUM_COLS_NUMBER_GRID = 10;
	
	public static final int NUM_ROWS_COLOR_GRID = 19;
	public static final int NUM_COLS_COLOR_GRID = 19;
	
	/** Draw the different patterns. Comment others out while working on a single pattern.
	 *  Uncomment calls to completed patterns before turning in.
	 */	
	public static void main(String[] args)
	{
		drawPattern1(NUM_ROWS_NUMBER_GRID, NUM_COLS_NUMBER_GRID);
		drawPattern2(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
		drawPattern3(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
		drawPattern4(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
	}

   /**
    * Draws a triangle pattern with digits 0 through 9
    * @param numRows number of rows
    * @param numCols number of columns
    */
	public static void drawPattern1(int numRows, int numCols)
	{
		BoundedGrid<Integer> grid = new BoundedGrid<Integer>(numRows, numCols);
		World<Integer> world = new World<Integer>(grid);
		
		for (int i = 0; i < numRows; i++)
		{
            for (int j = 0; j <= i; j++)
            {
                world.add(new Location(i, j), j);
            }
        }
		
		world.show();
	}

   /**
    * Draws two colors divided by a black diagonal line
    * @param numRows number of rows
    * @param numCols number of columns
    */
	public static void drawPattern2(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);

		for (int i = 0; i < numRows; i++)
		{
		    for (int j = 0; j < numCols; j++)
		    {
		        if (j == i)
		        {
		            world.add(new Location(i, j), Color.BLACK);
                }
                else if (j < i)
                {
		            world.add(new Location(i, j), new Color(255, i * 255 / 30, j * 255 / 30));
                }
                else {
					world.add(new Location(i, j), new Color(i * 255 / 30, 122, j * 255 / 30));
                }
            }
        }

		world.show();
	}

   /**
    * Draws a pattern of columns of 3 alternating colors
    * @param numRows number of rows
    * @param numCols number of columns
    */
	public static void drawPattern3(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);

		Color[] colors = {Color.RED, Color.CYAN, Color.MAGENTA};
		for (int j = 0; j < numCols; j++)
		{
		    for (int i = 0; i < numRows; i++)
		    {
		        world.add(new Location(i, j), colors[j % 3]);
            }
        }
		
		world.show();
	}

   /**
    * Draws a diamond pattern
    * @param numRows number of rows
    * @param numCols number of columns
    */
	public static void drawPattern4(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);

		int rowCenter = numCols / 2;
		int colCenter = numRows / 2;
		for (int i = 0; i < numRows; i++)
		{
		    for (int j = 0; j < numCols; j++)
		    {
		        if (j >= colCenter - rowCenter + Math.abs(i - rowCenter) &&
                    j <= colCenter + rowCenter - Math.abs(i - rowCenter))
		        {
		            world.add(new Location(i, j), new Color(i * 255 / 30, j * 255 / 30, 155));
                }
            }
        }

		world.show();
	}
}