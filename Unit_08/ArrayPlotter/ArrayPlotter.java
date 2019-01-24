/** 
 * The Array Plotter uses loops and arrays to generate
 * designs on a GridWorld canvas.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 01/24/2019
 */

public class ArrayPlotter
{
	/** The Array Plotter Graphical User Interface. */
	private ArrayPlotterGUI gui;
	
	/** The Color Array.  The element values indicate how to color a grid cell:
	 *  - true: Color the cell with the Drawing Color.
	 *  - false: Color the cell with the Background Color.
	 */
	private boolean[][] colorArray;
	
	/** Constructs an Array Plotter */
	public ArrayPlotter()
	{
		gui = new ArrayPlotterGUI(this);
		colorArray = null;
	}
	
	/** Initialize this's Color Array to a new 2D array of boolean values
	 *  with the given dimensions.
	 *  @param rows the number of rows in the new array.
	 *  @param cols the number of columns in the new array.
	 *  Postcondition: All of the Color Array's elements have the value false.
	 */
	public void initializeColorArray(int rows, int cols)
	{
		colorArray = new boolean[rows][cols];
	}

	/** Removes all objects from the grid. */
	public void onClearGridButtonClick()
	{
		for (int row = 0; row < colorArray.length; row++)
			for (int col = 0; col < colorArray[row].length; col++)
				colorArray[row][col] = false;
		gui.update(colorArray);
	}
	
	/** Fills in all the cells of the grid using a row-major traversal. */
	public void onRowMajorFillButtonClick()
	{
		for (int row = 0; row < colorArray.length; row++)
			for (int col = 0; col < colorArray[row].length; col++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
	}

	/** Fills in cells of the grid using col-major traversal. */
	public void onColMajorFillButtonClick()
	{
		for (int col = 0; col < colorArray.length; col++)
			for (int row = 0; row < colorArray[0].length; row++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
	}
	
	/** Fills in all the cells of the grid in a diagonal pattern using a row-major traversal. */
	public void onMainDiagonalFillButtonClick()
	{
		for (int row = 0; row < Math.min(colorArray.length, colorArray[0].length); row++)
		{
			colorArray[row][row] = true;
			gui.update(colorArray);
		}
	}
	
	/** Fills given row from left to right */
	private void fillRowLeftToRight(boolean[] row)
	{
		for (int i = 0; i < row.length; i++)
		{
			row[i] = true;
			gui.update(colorArray);
		}
	}

	/** Fills given row from right to left */
	private void fillRowRightToLeft(boolean[] row)
	{
		for (int i = row.length - 1; i >= 0; i--)
		{
			row[i] = true;
			gui.update(colorArray);
		}
	}
	
	/** Fills array in a snaking fashion */
	public void onSerpentineFillButtonClick()
	{
		for (int i = 0; i < colorArray.length; i += 2)
		{
			fillRowLeftToRight(colorArray[i]);
			fillRowRightToLeft(colorArray[i + 1]);
		}
	}

	/** Fills in the array bottom to up, left to right */
	public void onReverseColMajorFillButtonClick()
	{
		for (int row = colorArray.length - 1; row >= 0; row--)
			for (int col = 0; col < colorArray[0].length; col++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
	}

	/** Fills in array from top right to bottom left  */
	public void onOtherTriangleFillButtonClick()
	{
		for (int row = 0; row < colorArray[0].length; row++)
			for (int col = colorArray.length - row - 1; col < colorArray.length; col++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
	}

	/** main method that creates the grid plotter application. */
	public static void main(String[] args)
	{
		new ArrayPlotter();
	}
}
