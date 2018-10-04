// collaborator: deddie shoe

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class HalloweenDrawing extends JComponent
{
	private Graphics2D g2;
	private int width;
	private int height;
	
	/** Draw a house, a pumpkin, and a greeting
	 *  @param g the Graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		// Convert g back to its Graphics2D self
		g2 = (Graphics2D)g;
		
		// Get size of component window
		width = getWidth();
		height = getHeight();
		
		// Draw house 
		drawHouse();
		drawHouseFeatures(50, 100, width / 3, height / 2);
		
		// Draw pumpkin
		drawPumpkin();
		drawPumpkinFace(50 + width / 2, 100, width / 3,  height / 2);
		
		// Draw greeting
		g2.setColor(Color.RED);
		g2.drawString("Welcome to Spooky Shack!", 10, 10);
	}
	
	/** 
	 */
	public void drawHouse()
	{
		// Set color to light brown for house
		g2.setColor(new Color(166, 128, 100));
		
		// Create house
		g2.fill(new Rectangle(50, 100, width / 3,  height / 2));
		
		// Set color to black for roofing lines
		g2.setColor(Color.BLACK);
		
		// Draw two lines that define the edges of roof		
		g2.draw(new Line2D.Double(50.0, 100.0, 50.0 + (int)(width / 6), 25.0));
		g2.draw(new Line2D.Double(50.0 + (int) (width / 6), 25.0, 50.0 + (int) (width / 3), 100.0));
	}
	
	/** 
	 */
	public void drawHouseFeatures(int houseX, int houseY, int houseWidth, int houseHeight)
	{
		// Set color to light blue for windows 
		g2.setColor(new Color(137, 196, 244));
		
		// Draw two windows
		g2.fill(new Rectangle(houseX + houseWidth / 7, houseY + houseHeight / 3,
			houseWidth / 7, houseHeight / 3));
		g2.fill(new Rectangle(houseX + houseWidth * 5 / 7, houseY + houseHeight * 1 / 3,
			houseWidth / 7, houseHeight / 3));
		
		// Set color to dark brown for door
		g2.setColor(new Color(139, 69, 19));
		
		// Draw door
		g2.fill(new Rectangle(houseX + houseWidth * 2 / 5, houseY + houseHeight / 3,
			houseWidth / 5, houseHeight * 2 / 3));
	}
	
	/** 
	 */
	public void drawPumpkin()
	{
		g2.setColor(new Color(255, 140, 0));
		g2.fill(new Ellipse2D.Double(50 + width / 2, 100, width / 3,  height / 2));
	}
	
	/** 
	 */
	public void drawPumpkinFace(int pumpkinX, int pumpkinY, int pumpkinWidth, int pumpkinHeight)
	{
		g2.setColor(Color.BLACK);
		
		g2.fill(new Ellipse2D.Double(pumpkinX + pumpkinWidth * 2.0 / 7.0, pumpkinY + pumpkinHeight / 4.0, pumpkinWidth / 7.0, pumpkinWidth / 7.0));
		
		g2.fill(new Ellipse2D.Double(pumpkinX + pumpkinWidth * 4.0 / 7.0, pumpkinY + pumpkinHeight / 4.0, pumpkinWidth / 7.0, pumpkinWidth / 7.0));
		
		g2.fill(new Ellipse2D.Double(pumpkinX + pumpkinWidth * 2.0 / 5.0, pumpkinY + pumpkinHeight * 3 / 5.0, pumpkinWidth / 5.0, pumpkinWidth / 5.0));
		
		g2.setColor(new Color(0, 100, 0));
		g2.fill(new Rectangle(pumpkinX + pumpkinWidth * 3 / 7, pumpkinY - pumpkinHeight / 12, pumpkinWidth / 7, pumpkinHeight / 5));
	}
}
