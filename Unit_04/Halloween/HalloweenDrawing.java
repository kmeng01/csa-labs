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
		drawHouseFeatures(50, 100, (int)(width / 3), (int)(height / 2));
		
		// Draw pumpkin
		drawPumpkin();
		
		// Draw greeting
		g2.setColor(Color.RED);
		g2.drawString("Welcome to spooky shack", 10, 10);
	}
	
	/** 
	 */
	public void drawHouse()
	{
		g2.setColor(new Color(166, 128, 100));
		Rectangle rect = new Rectangle(50, 100, width / 3,  height / 2);
		g2.fill(rect);
		
		g2.setColor(Color.BLACK);
		g2.draw(new Line2D.Double(50.0, 100.0, 50.0 + (int)(width / 6), 25.0));
		g2.draw(new Line2D.Double(50.0 + (int)(width / 6), 25.0, 50.0 + (int)(width / 3), 100.0));
	}
	
	/** 
	 */
	public void drawHouseFeatures(int houseX, int houseY, int houseWidth, int houseHeight)
	{
		g2.setColor(Color.CYAN);
		Rectangle window1 = new Rectangle(houseX + houseWidth / 7, houseY + houseHeight / 3, houseWidth / 7, houseHeight / 3);
		g2.fill(window1);
		
		Rectangle window2 = new Rectangle(houseX + houseWidth * 5 / 7, houseY + houseHeight * 1 / 3, houseWidth / 7, houseHeight / 3);
		g2.fill(window2);
		
		g2.setColor(Color.RED);
		Rectangle door = new Rectangle(houseX + houseWidth / 4, houseY + houseHeight / 3);
		g2.fill(door);
	}
	
	/** 
	 */
	public void drawPumpkin()
	{

	}
	
	/** 
	 */
	public void drawPumpkinFace(int pumpkinX, int pumpkinY, int pumpkinWidth, int pumpkinHeight)
	{

	}
}
