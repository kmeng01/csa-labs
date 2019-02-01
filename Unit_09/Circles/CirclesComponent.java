
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.ArrayList;

public class CirclesComponent extends JComponent
{
	private final int NUM_CIRCLES = 1000;
	private ArrayList<Ellipse2D.Double> circles;

	public CirclesComponent()
	{
		circles = new ArrayList<Ellipse2D.Double>();
	}
	
	/**
	 *  Generate and draw all of the circles
	 *  @param g the graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		generateCircles();
		drawCircles(g2);
	}
	
	private void generateCircles()
	{
		circles.clear();
		int w = this.getWidth(), h = this.getHeight();
		while (circles.size() != this.NUM_CIRCLES)
		{
			double diam = (Math.random() * 60) + 1;
			int x = (int) (Math.random() * (w - diam));
			int y = (int) (Math.random() * (h - diam));
			Ellipse2D.Double el = new Ellipse2D.Double(x, y, diam, diam);
			if (!circleIntersects(el))
				circles.add(el);
		}
	}

	private void drawCircles(Graphics2D g2)
	{
		for (int i = 0; i < this.NUM_CIRCLES; i++)
		{
			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
			Color c = new Color(r, g, b);
			g2.setColor(c);
			g2.draw(circles.get(i));
		}
	}		

	// 100-point Version
	private boolean circleIntersects(Ellipse2D.Double circle)
	{
		double cx = circle.getCenterX(), cy = circle.getCenterY();
		double cr = circle.getHeight() / 2;
		for (Ellipse2D.Double el : circles)
		{
			double ex = el.getCenterX(), ey = el.getCenterY();
			double er = el.getHeight() / 2;
			double dist = Math.sqrt((ex - cx) * (ex - cx) + (ey - cy) * (ey - cy));
			if (dist < cr + er)
				return true;
		}
		return false;
	}
}