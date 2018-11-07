/** 
 * The CircleComponent Class provides functionality for the drawing of
 * 100 circles, initialized to random colors and locations. Circles will never 
 * run off of the screen.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 11/09/2018
 */

import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class CircleComponent extends JComponent
{

	private static final int MIN_DIAMETER = 20;
	private static final int MAX_DIAMETER = 50;

	@Override
	public void paintComponent(Graphics g)
	{
		// Recover Graphics2D object
		Graphics2D g2 = (Graphics2D) g;

		// Draw 100 circles
		for (int i = 0; i < 100; i++)
		{
			// Set color and draw randomly generated circle
			g2.setColor(getRandomColor());
			g2.fill(generateCircle());
		}

	}

	/** Returns Ellipse2D.Double object with a random diameter in range [MIN_DIAMETER, MAX_DIAMETER]
	 *  and location so that the circle will never run off the screen.
	 * 
	 * @return Ellipse2D.Double object drawable by Graphics component
	 */
	private Ellipse2D.Double generateCircle()
	{
		int diam = getRandomInteger(MIN_DIAMETER, MAX_DIAMETER);
		int xCoord = getRandomInteger(0, this.getWidth() - diam);
		int yCoord = getRandomInteger(0, this.getHeight() - diam);
		return new Ellipse2D.Double(xCoord, yCoord, diam, diam);
	}
	
	/** Returns a random int in the range [min, max]
	 * 
	 * @param min minimum value (inclusive)
	 * @param max maximum value (inclusive)
	 * @return random integer in range [min, max]
	 */
	private int getRandomInteger(int min, int max)
	{
		return (int) (Math.random() * (max - min + 1)) + min;
	}
	
	/** Returns a random RGB Color object
	 * 
	 * @return random Color object usable by Graphics component
	 */
	private Color getRandomColor()
	{
		return new Color(
			getRandomInteger(0, 255),
			getRandomInteger(0, 255),
			getRandomInteger(0, 255));
	}

}