import java.awt.*;

public class ColorPicker{
   private Color c;
   private int red;
   private int green;
   private int blue;

   
   public ColorPicker(int red, int green, int blue){
      if(red < 256 && red >= 0 && green < 256 && green >= 0 && blue < 256 && blue >= 0){
         this.red = red;
         this.green = green;
         this.blue = blue;
         c = new Color(red, green, blue);
      }
   }
   
   public void tick(){
   //System.out.println(blue);
      //if(green < 254){
        // green += 1;
        // red -= 1;
      //}
      
      //c = new Color(red, green, blue);
   }
   
   public void render(Graphics g){
      g.setColor(c);
      g.fillOval(500, 100, 500, 500);
   }
}


//0 --> 255 Red
//0 --> 255 Green
//0 --> 255 Blue

//x, y, z) --> ([0] --> Red, [1] --> Green, [2] --> Blue)