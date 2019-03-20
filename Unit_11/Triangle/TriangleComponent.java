/**
 * The TriangleComponent Class provides functionality to recursively draw a
 * Sierpinski Triangle pattern.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 03/20/2019
 */
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JComponent;

public class TriangleComponent extends JComponent
{
	
	// constant class array to hold progression of colors
	private static final Color LAVENDER = new Color(204, 153, 255);
	private static final Color PURPLE = new Color(153, 0, 255);
	private static final Color[] colors = {LAVENDER, Color.cyan, Color.darkGray, Color.blue, 
		PURPLE, Color.pink, Color.black, Color.lightGray};
		
	// Graphics object used for drawing
	private Graphics2D gr;
	
	/** Draw the triangles
	 *  @param g the Graphics object for drawing in this component
	 */
	@Override
	public void paintComponent(Graphics g) 
	{
		gr = (Graphics2D) g;
		drawTriangle(this.getWidth() / 2, 5, 5, this.getHeight() - 5, this.getWidth() - 5, this.getHeight() - 5, 0);
	}
	
	/**
	 * Draws triangle pattern recursively
	 * @param x1 x-loc of top point
	 * @param y1 y-loc of top point
	 * @param x2 x-loc of bottom left point
	 * @param y2 y-loc of bottom left point
	 * @param x3 x-loc of bottom right point
	 * @param y3 y-loc of bottom right point
	 * @param colorIndex index of desired color in array
	 */
	private void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int colorIndex)
	{
		// break out if any necessary intervals cannot be divided further
		if ((x1 + x2) / 2 == x1 || (x1 + x3) / 2 == x1 || (x2 + x3) / 2 == x2 || (y1 + y2) / 2 == y1) return;

		int[] xpoints = {x1, x2, x3};
		int[] ypoints = {y1, y2, y3};
		Polygon tri = new Polygon(xpoints, ypoints, 3);
		gr.setColor(colors[colorIndex]);
		gr.fill(tri);

		drawTriangle(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2, (x1 + x3) / 2, (y1 + y2) / 2, (colorIndex + 1) % colors.length); // top triangle (top point constant)
		drawTriangle((x1 + x2) / 2, (y1 + y2) / 2, x2, y2, (x2 + x3) / 2, y3, (colorIndex + 1) % colors.length); // left triangle (bottom left point constant)
		drawTriangle((x1 + x3) / 2, (y1 + y2) / 2, (x2 + x3) / 2, y2, x3, y3, (colorIndex + 1) % colors.length); // right triangle (bottom right point constant)
	}

}