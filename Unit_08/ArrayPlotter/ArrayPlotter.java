// import javax.swing.JOptionPane;

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

	public void onColMajorFillButtonClick()
	{
		for (int col = 0; col < colorArray.length; col++)
			for (int row = 0; row < colorArray[0].length; row++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
	}
	
	public void onMainDiagonalFillButtonClick()
	{
		for (int row = 0; row < Math.min(colorArray.length, colorArray[0].length); row++)
		{
			colorArray[row][row] = true;
			gui.update(colorArray);
		}
	}
	
	private void fillRowLeftToRight(boolean[] row)
	{
		for (int i = 0; i < row.length; i++)
		{
			row[i] = true;
			gui.update(colorArray);
		}
	}

	private void fillRowRightToLeft(boolean[] row)
	{
		for (int i = row.length - 1; i >= 0; i--)
		{
			row[i] = true;
			gui.update(colorArray);
		}
	}
	
	public void onSerpentineFillButtonClick()
	{
		for (int i = 0; i < colorArray.length; i += 2)
		{
			fillRowLeftToRight(colorArray[i]);
			fillRowRightToLeft(colorArray[i + 1]);
		}
	}

	public void onReverseColMajorFillButtonClick()
	{
		for (int row = 0; row < colorArray.length; row++)
			for (int col = colorArray[0].length - 1; col >= 0; col--)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
	}

	public void onOtherTriangleFillButtonClick()
	{
		for (int col = colorArray.length - 1; col >= 0; col--)
		{
			colorArray[colorArray.length - col - 1][col] = true;
			gui.update(colorArray);
		}
	}

	/** main method that creates the grid plotter application. */
	public static void main(String[] args)
	{
		new ArrayPlotter();
	}
}