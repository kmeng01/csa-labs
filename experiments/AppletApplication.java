import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class AppletApplication extends Applet implements WindowListener {

   public static void main(java.lang.String[] args) {
      AppletApplication applet = new AppletApplication();
      Frame w = new Frame("Applet");
      w.addWindowListener(applet);
      w.add("Center", applet);
      w.setSize(50, 50);
      w.setVisible(true);
      applet.init();
      applet.start();
   }

   public void paint(Graphics g) {
      super.paint(g);
      g.drawString("Hello World", 10, 10);	// Upper left corner
   }

   public void windowClosing(WindowEvent e) {
      System.exit(0);	// Exit the application when the window is closed
   }
   
   // Required methods
   public void windowActivated(WindowEvent e) { }
   public void windowClosed(WindowEvent e) { }
   public void windowDeactivated(WindowEvent e) { }
   public void windowDeiconified(WindowEvent e) { }
   public void windowIconified(WindowEvent e) { }
   public void windowOpened(WindowEvent e) { }

}