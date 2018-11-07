
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

		for (int i = 0; i < 100; i++)
		{
			g2.setColor(getRandomColor());
			g2.fill(generateCircle());
		}

	}

	private Ellipse2D.Double generateCircle()
	{
		int diam = getRandomInteger(MIN_DIAMETER, MAX_DIAMETER);
		int xCoord = getRandomInteger(0, this.getWidth() - diam);
		int yCoord = getRandomInteger(0, this.getHeight() - diam);
		return new Ellipse2D.Double(xCoord, yCoord, diam, diam);
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