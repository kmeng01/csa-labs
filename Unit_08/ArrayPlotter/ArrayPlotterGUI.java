/**
 * ArrayPlotterGUI.java  10/18/14
 *
 * @author - Robert Glen Martin
 * @author - School for the Talented and Gifted
 * @author - Dallas ISD
 *
 * @author - Alyce Brady
 *
 * License Information:
 *   This class is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation.
 *
 *   This class is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 */

import edu.tag.grid.gui.nuggets.BasicHelpMenu;

/**
 *  Grid Plotter GUI:<br>
 *
 *    The <code>ArrayPlotterGUI</code> class provides a
 *    Graphical User Interface for an Array Plotter to
 *    draw by placing color blocks in a grid.
 *
 *  @author Alyce Brady
 *  @version 1 September 2004
 **/

import edu.tag.world.GridObjectWorld;
import edu.tag.grid.GridObject;
import edu.tag.grid.display.ColorBlockDisplay;
import edu.tag.grid.display.DisplayMap;
import edu.tag.grid.gui.GridChangeListener;
import edu.tag.grid.gui.EnabledDisabledStates;
import edu.tag.grid.gui.GeneratedButtonList;
import edu.tag.grid.gui.GridAppFrame;
import edu.tag.grid.gui.nuggets.BGColorChoiceMenu;
import edu.tag.grid.gui.nuggets.ColorChoiceMenu;
import edu.tag.grid.gui.nuggets.MinimalFileMenu;
import edu.tag.grid.gui.nuggets.NewBoundedGridButton;
import edu.tag.grid.ColorBlock;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.lang.reflect.Field;

public class ArrayPlotterGUI extends GridObjectWorld
	implements GridChangeListener
{
	// Specify the dimensions of the grid display.
	private static final int DISPLAY_WIDTH = 400;    // in pixels
	private static final int DISPLAY_HEIGHT = 400;   // in pixels

	// Specify the minimum individual cell size.
	private static final int MIN_CELL_SIZE = 10;   // in pixels

	// Specify constants used to initialize slider, which adjusts the speed
	// of the program.  The slider controls a delay or pause that is
	// inserted after displaying the grid to allow the user time to view
	// it.  The longest delay value defines the slowest rate; the shortest
	// delay defines the fastest rate.  Both delay times are
	// in milliseconds.
	private static final int LONGEST_DELAY_MSECS = 1000;  // slowest
	private static final int SHORTEST_DELAY_MSECS = 10;  // fastest


	private GridPlotterGUI display;
	private boolean colorArrayCreated;

	public ArrayPlotterGUI(ArrayPlotter plotter)
	{
		super();
		initialize(plotter);
		show();
	}

	private void initialize(ArrayPlotter plotter)
	{
		colorArrayCreated = false;

		// Construct a graphical user interface (GUI).  The GUI
		// provides buttons to run the traversal algorithms and
		// displays the results of each traversal by highlighting
		// the appropriate cells in the grid.
		display = new GridPlotterGUI(LONGEST_DELAY_MSECS,
									        SHORTEST_DELAY_MSECS, plotter);

		display.includeMenu(
			new BasicHelpMenu("GridPlotter", "Robert Glen Martin",
							  		"with tons of assistance from Alyce Brady",
							  		"18 October 2014",
							  		""));

		// Construct the visible window with the specified components.
		display.constructWindowContents("Grid Plotter",
												  DISPLAY_WIDTH, DISPLAY_WIDTH,
												  MIN_CELL_SIZE);
	}

	public ColorChoiceMenu getDrawingColorChooser()
	{
		return display.colorBlockColorChooser;
	}

	/** Sets the grid in which to draw. */
	public void reactToNewGrid(Grid<GridObject> grid)
	{
		// Get Array Plotter to initialize its mirroring 2D array.
		display.plotter.initializeColorArray(
			grid.getNumRows(), grid.getNumCols());
		colorArrayCreated = true;

	  	setGrid(grid);
	}

	/** Updates the grid to reflect the state of the mirroring 2D array. */
	public void update(boolean[][] ca)
	{
		// Make sure that passed array is
		// THE ArrayPlotter colorArray instance variable
		boolean[][] colorArray = getColorArray();
		if (ca != colorArray)
			throw new IllegalStateException("Array passed to update " +
				"is not the ArrayPlotter colorArray instance variable.");

		syncGridToArray();
		display.sleep();
	}

	protected void repaint()
	{
		syncGridToArray();
		display.showGrid();
	}

	public void sleep()
	{
	   syncGridToArray();
		display.sleep();
	}

	private void syncGridToArray() // RGM
	{
		// Retrieve reference to array plotter's colorArray
		boolean[][] colorArray = getColorArray();

	  	Grid<GridObject> g = getGrid();

		if (colorArrayCreated)
		{
			if (colorArray == null)
				throw new IllegalStateException("colorArray is null!");
			if (g.getNumRows() != colorArray.length)
				throw new IllegalStateException(
					"colorArray row count is incorrect!");
			if (g.getNumCols() != colorArray[0].length)
				throw new IllegalStateException(
					"colorArray col count is incorrect!");
		}
		else
			return;

		Color color = getDrawingColorChooser().currentColor();

		for (int r = 0; r < colorArray.length; r++)
			for (int c = 0; c < colorArray[0].length; c++)
			{
				Location loc = new Location(r, c);
				GridObject gObj = g.get(loc);

				if (! colorArray[r][c])
				{
					if (gObj != null)
					{
						gObj.removeSelfFromGrid();
						display.getDisplay().updateLocation(loc);
					}
				}
				else
				{
					if (gObj == null)
					{
						new ColorBlock(color).putSelfInGrid(g, loc);
                  display.getDisplay().updateLocation(loc);
					}
				}
			}
	}


	/** Gets the Array Plotter's colorArray instance variable. */
	private boolean[][] getColorArray()
	{
		Field colorArrayField = null;
		try
		{
			colorArrayField = ArrayPlotter.class.getDeclaredField("colorArray");
		}
		catch (NoSuchFieldException e)
		{
			System.err.println("ArrayPlotter colorArray - NoSuchFieldException");
		}

		colorArrayField.setAccessible(true);

		boolean[][] colorArray = null;
		try
		{
			colorArray = (boolean[][])colorArrayField.get(display.plotter);
		}
		catch (IllegalAccessException e)
		{
			System.err.println("ArrayPlotter colorArray - IllegalAccessException");
		}

		return colorArray;
	}


	/**
	 *  Grid Plotter GUI:<br>
	 *
	 *    The <code>GridPlotterGUI</code> class provides the graphical
	 *    user interface for a program that draws in a grid by placing
	 *    color blocks in its cells.
	 *
	 *    This class is based on the College Board's FishToolbar class,
	 *    as allowed by the GNU General Public License.  FishToolbar is a
	 *    black-box GUI class within the AP(r) CS Marine Biology Simulation
	 *    case study (see www.collegeboard.com/ap/students/compsci).
	 *
	 *  @author Alyce Brady (based on code by Julie Zelenski)
	 *  @version 1 September 2004
	 *
	 *  @author Robert Glen Martin
	 *  @version 22 April 2007
	 **/
	public class GridPlotterGUI extends GridAppFrame
	{
	   // Define control buttons attributes.
	   private static final boolean INCLUDE_ONLY_ON_BUTTONCLICK_METHODS = true;
	   private static final boolean DISPLAY_GRID_AFTER_BUTTON_PRESSES = true;

		private ArrayPlotter plotter;

	   // Keep track of background color chooser menu for redefined
	   // constructWindowContents method.
	   private ColorChoiceMenu bgColorChooser;

	   // Include a color chooser component for color blocks.
	   private ColorChoiceMenu colorBlockColorChooser;


	  /** Constructs the graphical user interface for the Grid
	   *  Plotter program.
	   *    @param maxDelayMsecs longest delay value for slider,
	   *	       in milliseconds
	   *    @param minDelayMsecs shortest delay value for slider,
	   *		   in milliseconds
	   **/
	   public GridPlotterGUI(
	   	int maxDelayMSecs, int minDelayMsecs, ArrayPlotter plotter)
	   {
		 	// Construct and initialize the GUI window.  It will need
		 	// the list of drawing methods from the GridPlotter class.
		 	super();

		 	includeMenu(new MinimalFileMenu());

		 	// Include a New Grid button.
		 	includeControlComponent(
		 		new NewBoundedGridButton(this, "New Grid"),
		 		EnabledDisabledStates.NEEDS_APP_WAITING);

		 	// Include a background color chooser component.
		 	bgColorChooser = new BGColorChoiceMenu(this);
		 	includeControlComponent(bgColorChooser,
		 		EnabledDisabledStates.NEEDS_APP_WAITING);

		 	// Include a color chooser component for color blocks.
		 	colorBlockColorChooser = new ColorChoiceMenu("Drawing Color:");
		 	includeControlComponent(colorBlockColorChooser,
		 		EnabledDisabledStates.NEEDS_APP_WAITING);

		 	// Generate control buttons derived from the methods of the
		 	// target GridPlotter object and include them in the user
		 	// interface.  The world object needs to know when a new grid
		 	// is created, so register it as a grid change listener.
		 	this.plotter = plotter;
		 	addGridChangeListener(ArrayPlotterGUI.this);
		 	GeneratedButtonList generatedButtonList =
				new GeneratedButtonList(this, plotter,
			 		INCLUDE_ONLY_ON_BUTTONCLICK_METHODS,
					DISPLAY_GRID_AFTER_BUTTON_PRESSES);
		 	includeControlComponents(generatedButtonList,
		 		EnabledDisabledStates.NEEDS_GRID_AND_APP_WAITING);

		 	// Include a speed slider.
		 	includeSpeedSlider(maxDelayMSecs, minDelayMsecs);

		 	// Specify what object knows how to display color blocks.
		 	DisplayMap.associate("edu.tag.grid.ColorBlock",
				new ColorBlockDisplay());
	 	}

	   /* Inherit description from GridAppFrame. */
	   public void constructWindowContents(String title,
										 				int viewingWidth,
										 				int viewingHeight,
										 				int minCellSize)
	   {
		 	constructWindowContents(title, bgColorChooser.currentColor(),
				viewingWidth, viewingHeight, minCellSize);
	   }

	   /* Inherit description from GridAppFrame. */
	   protected JPanel defineContent()
	   {
		 	JPanel content = new JPanel();
		 	content.setBorder(BorderFactory.
		 		createEmptyBorder(15, 15, 15, 15));
		 	content.setLayout(new BorderLayout());

		 	// Create a panel to display the grid and speed slider bar
		 	// and another for the control buttons (e.g., a Reset button),
		 	// and add them to the main panel.
		 	JPanel gridAndSliderPanel = new JPanel();
		 	gridAndSliderPanel.setLayout(new BorderLayout());

		 	gridAndSliderPanel.add(makeDisplayPanel(),
		 					   		  BorderLayout.CENTER);

		 	JComponent sliderPanel = makeSliderPanel();
		 	if (sliderPanel != null)
			 	gridAndSliderPanel.add(sliderPanel, BorderLayout.SOUTH);

		 	content.add(gridAndSliderPanel, BorderLayout.CENTER);

		 	JComponent controlPanel = makeControlPanel(null);
		 	if (controlPanel != null)
			 	content.add(controlPanel, BorderLayout.WEST);

		 	return content;
	   }

		/** Shows the contents of a single location in the grid.  This
	    *  allows for speedier display than the showGrid method because
	    *  it only updates the contents of the one, specified location.
	    *  (Precondition: must have called <code>setGrid</code>.)
	    **/
	   public void showLocation(Location loc)
	   {
		 	getDisplay().updateLocation(loc);
		 	sleep();
	   }

	 	public void sleep()
		{
	    	if (getDelay() > 0)
		 	{
			 	try
			 	{
			 		Thread.sleep(getDelay());
			 	}
			 	catch (InterruptedException e)
			 	{
			 		System.err.println("InterruptedException");
			 	}
		 	}
	  	}
	}
}
