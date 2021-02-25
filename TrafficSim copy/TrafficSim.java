import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import java.awt.event.*; 
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.io.File;
import java.awt.Graphics;

import java.util.*;

public class TrafficSim{
   public Car theBestCar;
   public Car betterCar;
   public Car incredibleCar;
   private TrafficListener tl;

   public TrafficSim(TrafficListener t){
      theBestCar = new Car(200, 500, "BlueCar.png", 0, 0, 5.0);
      betterCar = new Car(200, 200, "RedCar.png", 0, 0, 3.0);
      incredibleCar = new Car(200, 350, "GreenCar.png", 0, 0, 2.0);
      
   }
   
   public void tick(double deltaT){
      theBestCar.tick(deltaT, tl.getMode());
      betterCar.tick(deltaT, "F");
      incredibleCar.tick(deltaT, "F");
      System.out.println("Best Car: " + theBestCar.getLap() + ", Better Car: " + betterCar.getLap() + ", Incredible Car: " + incredibleCar.getLap());
   }
   
   public void render(Graphics g){
      theBestCar.render(g);
      betterCar.render(g);
      incredibleCar.render(g);
   }
   
   public Car getCar(){
      return theBestCar;
   }
   
   public void setTL(TrafficListener t){
      tl = t;
   }
}