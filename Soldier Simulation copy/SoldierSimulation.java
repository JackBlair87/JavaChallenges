import javax.swing.JFrame; //For the JFrame

public class SoldierSimulation{
   private static SoldierPanel panel;
   private static int numSoldiersLeftSide = 100;
   private static int numSoldiersRightSide = 100;
   
   public static void main(String[] args) throws InterruptedException{
      JFrame frame = new JFrame("Soldier Simulation");
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Full screen
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      panel = new SoldierPanel(numSoldiersLeftSide, numSoldiersRightSide);
      frame.getContentPane().add(panel);
      frame.setVisible(true);
      Thread.sleep(1500); //Wait for Frame to open
      panel.begin();
   }
}
