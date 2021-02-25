import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;
import java.awt.*; 
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;


public class Car{
   //Physics
   private int myX; //Position
   private int myY;
   private double velX;
   private double velY;
   private double acceleration;
   private double maxAccel = 0.25;
   private int lapNum = 0;
   
   //Graphics
   private int myLength = 150;
   private int myHeight = 75;
   private String icon;
   private BufferedImage myCar;
   
   public Car(int x, int y, String colorFile, double newVX, double newVY, double newA){
      icon = colorFile;
      
      myX = x;
      myY = y;
      velX = newVX;
      velY = newVY;
      acceleration = newA;
      
      try{
         myCar = ImageIO.read(new File(icon));
      }catch(Exception e) { }
   }
   
   public void tick(double delta, String s){
      
      //"F"
      //"B"
      //"N"
      
      if(s.equals("F")){
         acceleration = maxAccel;
      }
      else if(s.equals("B")){
         acceleration = -2 * maxAccel;
      }
      else if(s.equals("N")){
         if(velX > 0.2){
            acceleration = -maxAccel;
         }
         else if(velX < -0.2){
            acceleration = maxAccel;
         }
         else{
            acceleration = 0;
         }
         
      }
   
   
   
      velX += acceleration;
      myX += velX * delta;
      myY += velY * delta;
      
      if(myX > 1510){
         lapNum++;
         myX = -20;
      }
      else if(myX < -20){
         lapNum--;
         myX = 1510;
      }
   }
   
   //Draws the car
   public void render(Graphics g){
      double x = myX - (myLength/2); //Draws car from center
      double y = myY - (myHeight/2);
      g.drawImage(myCar, (int) x, (int) y, (int) (x + myLength), (int) (y + myHeight), 0, 0, 300, 150, null);
   }
   
   public int getLap(){
      return lapNum;
   }
}

//X --> How far across
//Y --> How far vertically 
//Velocity --> How much something moves
//Speed vs Velocity
//60 mph 55 mph NW


//FPS (Frames per second)
//deltaTime --> Time inbetween frames
//delta --> change

//acceleration
//deceleration