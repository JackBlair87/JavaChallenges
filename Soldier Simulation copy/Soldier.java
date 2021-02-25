import java.awt.*;

public class Soldier{
   private int health;
   private int myX;
   private int myY;
   private boolean isFighting;
   private boolean isWounded;
   private boolean isDead;
   
   public Soldier(int myHealth, boolean fighting, boolean wounded, boolean dead, int x, int y){
      health = myHealth;
      isFighting = fighting;
      isWounded = wounded;
      isDead = dead;
      myX = x;
      myY = y;
   }
   
   //getters
   public int getHealth(){
      return health;
   }
   
   public boolean isFighting(){
      return isFighting;
   }
   
   public boolean isWounded(){
      return isWounded;
   }
   
   public boolean isDead(){
      return isDead;
   }
   
   //special functions and setters
   public void recieveDamage(int x){
      health -= x;
   }
   
   public void tick(){
      if(health <= 0){
         isDead = true;
         isFighting = false;
         isWounded = true;
      }
      else if(health <= 25){
         isWounded = true;
         isFighting = false;
      }
      else if(health <= 50){
         isWounded = true;
      }
      else
         isFighting = true;
   }
   
   public void render(Graphics g, int size){
      if(health > 0){
         g.setColor(getColor());
         g.fillOval(myX - (size/2), myY - (size/2), size, size);
      }
   }
   
   private Color getColor(){
      if(health < 0)
         return new Color(0, 0, 0);
      int green = ((int) (health / 100.0 * 255));
      int red = 255 - green;
   
      return new Color(red, green, 0);
   }

}