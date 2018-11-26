
import java.awt.Color;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class SamplePatternMaker
{
	/** Dimensions for the different worlds */
	public static final int NUM_ROWS_NUMBER_GRID = 10;
	public static final int NUM_COLS_NUMBER_GRID = 10;
	
	public static final int NUM_ROWS_COLOR_GRID = 19;
	public static final int NUM_COLS_COLOR_GRID = 19;

	
	public static void main(String[] args)
	{
		drawNumberSample(NUM_ROWS_NUMBER_GRID, NUM_COLS_NUMBER_GRID);
		drawColorSample(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
	}
	
	public static void drawNumberSample(int numRows, int numCols)
	{
		BoundedGrid<Integer> grid = new BoundedGrid<Integer>(numRows, numCols);
		World<Integer> world = new World<Integer>(grid);
		
		for (int row = 0; row < numRows; row++)
		{
			for (int col = 0; col < numCols; col++)
			{
				Location myLoc = new Location(row, col);
				world.add(myLoc, row);
			}
		}

		world.show();
	}
	
	public static void drawColorSample(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);
		
		Location loc = new Location(0, 0);
		world.add(loc, Color.blue);

		loc = new Location(0, numCols - 1);
		world.add(loc, Color.green);

		loc = new Location(numRows - 1, 0);
		world.add(loc, Color.red);

		loc = new Location(numRows - 1, numCols - 1);
		world.add(loc, Color.magenta);

		world.show();
	}
}