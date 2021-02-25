import javax.swing.JFrame;

public class TeachTrafficDriver{
   private static TrafficPanel tp;
   private static TrafficListener tl;
   
   public static void main(String[] args) throws InterruptedException{
      JFrame frame = new JFrame("Traffic Simulation");
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      tp = new TrafficPanel();
      tl = new TrafficListener(tp.getSim().getCar());
      tp.getSim().setTL(tl);
      frame.addKeyListener(tl);
      
      frame.getContentPane().add(tp);
      frame.setVisible(true);
      tp.begin(tl);
   }
}