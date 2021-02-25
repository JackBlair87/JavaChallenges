import javax.swing.JFrame; //import to make a new JFrame

public class ColorDriver
{
   private static ColorPanel cp;
   
   public static void main(String[] args) throws InterruptedException{
      JFrame frame = new JFrame("Color Simulation"); //Name the frame "Double Pendulum Simulation"
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Make it full screen, and let the user press the X
      cp = new ColorPanel(); //add a new instance of our DPPanel class
      frame.getContentPane().add(cp);
      frame.setVisible(true); //Make it visible, then hesitate before it starts swingin
      cp.begin();
   }
}