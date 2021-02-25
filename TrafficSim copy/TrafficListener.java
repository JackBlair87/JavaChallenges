import java.awt.event.*;      
import javax.swing.*;         
import java.awt.*;       
import java.io.*;

public class TrafficListener implements KeyListener{
   private Car car;
   private String mode = "N"; //Nuetral "N", Forward "F", Backward "B"
   
   public TrafficListener(Car carTrack){
      car = carTrack;
   }

   @Override
   public void keyPressed(KeyEvent e){
      int key = e.getKeyCode();
      switch(key){
         case KeyEvent.VK_LEFT:
            mode = "R";
            break;
         case KeyEvent.VK_RIGHT:
            mode = "F";
            break; 
      }
   }
   
   @Override
   public void keyReleased(KeyEvent e){
      int key = e.getKeyCode();
      switch(key){
         case KeyEvent.VK_LEFT:
            mode = "N";
            break;
         case KeyEvent.VK_RIGHT:
            mode = "N";
            break;
      }
   }
   
   @Override
   public void keyTyped(KeyEvent e){
   
   }
   
   public String getMode(){
      return mode;
   }
}