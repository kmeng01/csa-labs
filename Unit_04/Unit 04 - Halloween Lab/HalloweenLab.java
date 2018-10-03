

import javax.swing.JFrame;

public class HalloweenLab
{
	/** frame dimensions */	
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 400;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Halloween Lab");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocation(10, 10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Draw shapes
		HalloweenDrawing drawing = new HalloweenDrawing();
		frame.add(drawing);
		
		// Show it
		frame.setVisible(true);
	}
}