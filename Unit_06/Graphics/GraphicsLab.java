/** 
 * The GraphicsLab class serves as a runner class for CircleComponent and
 * RectangleComponent. It opens two display frames and shows the 100 circles
 * and nested rectangles on a GUI.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 11/09/2018
 */

import javax.swing.JFrame;
 
public class GraphicsLab
{
	public static void main(String[] args)
 	{
 		final int FRAME_WIDTH = 550;
 		final int FRAME_HEIGHT = 350;

 		// Instantiate and define JFrame
 		JFrame frame = new JFrame();
 		
 		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
 		frame.setLocation(5, 5);
 		frame.setTitle("Graphics Lab");
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		// Draw circles
 		CircleComponent component = new CircleComponent();
 		frame.add(component);

		 // Show frame
 		frame.setVisible(true);

		// Show the rectangles in a separate frame for BONUS 
  		JFrame bonusFrame = new JFrame();
  		bonusFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
 		bonusFrame.setLocation(5, FRAME_HEIGHT + 10);
 		bonusFrame.setTitle("Rectangles");
 		bonusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		bonusFrame.add(new RectangleComponent());
 		bonusFrame.setVisible(true);

	}
}