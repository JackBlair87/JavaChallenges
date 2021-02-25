import javax.swing.*;
import java.awt.GradientPaint;
import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import java.awt.event.*; 
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.io.File;

public class SoldierPanel extends JPanel{
   private BufferedImage mImage; 
   private Timer time; //make a new timer and simulation
   private SoldierSim ss;
   private int winsLeft = 0;
   private int winsRight = 0;
  
   public SoldierPanel(int numPL, int numPR){
      ss = new SoldierSim(numPL, numPR);
   }
   
   public void begin(){
      time = new Timer(100,      
            new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  if(!ss.isFinished()){ //simulate until everyone is dead or cured
                     ss.tick(); //tick and render
                     repaint(); 
                  } 
                  else{
                     if(ss.getWinner().equals("Right"))
                        winsRight++;
                     else
                        winsLeft++;
                     ss = new SoldierSim(ss.numLivingLeft, ss.numLivingRight);
                  }
               }                               
            }
            );
      time.start();
   }

   @Override
   public void paintComponent(Graphics g){ 
      draw();
      g.drawImage(mImage,0,0,getWidth(),getHeight(),null);
   }

   public void draw(){
      mImage = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);     
      Graphics g = mImage.getGraphics(); 
      ss.render(g); //then renders the data
      g.setColor(Color.WHITE);
      g.drawString(winsLeft + " - " + winsRight, 750, 400);
   }
}