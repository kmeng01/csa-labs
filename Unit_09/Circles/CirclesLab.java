/**
 * The CirclesLab Class is the runner for CircleComponent
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 02/05/2019
 */
 
import javax.swing.JFrame;
 
public class CirclesLab
{
	public static void main(String[] args)
 	{
 		final int FRAME_WIDTH = 800;
 		final int FRAME_HEIGHT = 600;

 		// Instantiate and define JFrame
 		JFrame frame = new JFrame();
 		
 		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
 		frame.setLocation(5, 5);
 		frame.setTitle("Circles Lab");
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		// Draw circles
 		CirclesComponent component = new CirclesComponent();
 		frame.add(component);
 		frame.setVisible(true);
 	}
}