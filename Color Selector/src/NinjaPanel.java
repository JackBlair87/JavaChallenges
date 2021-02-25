import javax.imageio.ImageIO;
import java.util.*;
import javax.swing.*; //For Panel
import java.awt.*; //For graphics
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class NinjaPanel extends JPanel{
   private static final long serialVersionUID = -5595525441567848011L;
   private BufferedImage mImage;

   private ColorDisplay color;
   private Header header;
   // private Subbar sub;

   public NinjaPanel(){

      setLayout(new BorderLayout());
      header = new Header();
      //header.setPreferredSize(new Dimension(header.getWidth(), (int) (header.getHeight()*1.25)));
      add(header, BorderLayout.NORTH);

      color = new ColorDisplay();
      color.addMouseListener(new Mouse());
      color.addKeyListener(new Key());
      color.setFocusable(true);
      add(color, BorderLayout.CENTER);
   }


   @Override
   public void paintComponent(Graphics g){ 
      draw();
      g.drawImage(mImage,0,0,getWidth(),getHeight(),null);
   }

   public void draw(){
      mImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);     
      Graphics g = mImage.getGraphics();  

      g.fillRect(0, 0, getWidth(), getHeight());
   }

   private class Mouse extends MouseAdapter
   {
      public void mouseClicked(MouseEvent e)
      {
         CustomColor c = color.select(e.getX(), e.getY());
         update(c);
      }
   }

   private class Key extends KeyAdapter
   {
      public void keyPressed(KeyEvent e)
      {
         CustomColor c;
         switch( e.getKeyCode() )
         {
            case KeyEvent.VK_UP:    
               c = color.shift(0, -1);  
               update(c);  
               break;
            case KeyEvent.VK_DOWN:  
               c = color.shift(0, 1);  
               update(c);
               break;
            case KeyEvent.VK_LEFT:  
               c = color.shift(-1, 0);
               update(c);  
               break;
            case KeyEvent.VK_RIGHT: 
               c = color.shift(1, 0);
               update(c); 
               break;
         }
      }
   }   

   private void update(CustomColor c) {
      color.requestFocus();
      if(c != null){
         header.update(c);
         color.update(c);
      }
      color.repaint();
   }
}