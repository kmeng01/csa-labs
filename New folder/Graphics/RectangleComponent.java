

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class RectangleComponent extends JComponent
{
	@Override
	public void paintComponent(Graphics g)
	{
		// Recover Graphics2D object
		Graphics2D g2 = (Graphics2D) g;
		
		int width = this.getWidth(), height = this.getHeight();
		int xCoord = 0, yCoord = 0;
		while (width >= 10 && height >= 5) {
			g2.setColor(getRandomColor());
			g2.fill(generateRect(xCoord, yCoord, width, height));
			width -= 40;
			height -= 40;
			xCoord += 20;
			yCoord += 20;
		}
		
	}

	private Rectangle generateRect(int xCoord, int yCoord, int width, int height)
	{
		return new Rectangle(xCoord, yCoord, width, height);
	}

	private int getRandomInteger(int min, int max)
	{
		return (int) (Math.random() * (max - min + 1)) + min;
	}
	
	private Color getRandomColor()
	{
		return new Color(
			getRandomInteger(0, 255),
			getRandomInteger(0, 255),
			getRandomInteger(0, 255));
	}

}