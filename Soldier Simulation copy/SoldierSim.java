import java.awt.*;

public class SoldierSim{
   private Soldier[] rightSide;
   private Soldier[] leftSide;
   public int numLivingLeft;
   public int numLivingRight;
   private int numFightingLeft;
   private int numFightingRight;
   private String winner = "";
   
   public SoldierSim(int left, int right){
      rightSide = new Soldier[right];
      leftSide = new Soldier[left];
      for(int x = 0; x < left; x++){
         leftSide[x] = new Soldier(100, true, false, false, 50 + (int) (Math.random()*400), (int) (Math.random()*700) + 50);
      }
      
      for(int y = 0; y < right; y++){
         rightSide[y] = new Soldier(100, true, false, false, 1350 - (int) (Math.random()*400), (int) (Math.random()*700) + 50);
      }
      
      numLivingLeft = 0;
      numLivingRight = 0;
      numFightingLeft = 0;
      numFightingRight = 0;
   }
   
   public boolean isFinished(){
      numLivingLeft = 0;
      numLivingRight = 0;
      numFightingLeft = 0;
      numFightingRight = 0;
      for(int a = 0; a < leftSide.length; a++){
         if(leftSide[a] != null){
            if(!leftSide[a].isDead())
               numLivingLeft += 1;
            if(leftSide[a].isFighting())
               numFightingLeft++;
         }
      }
      
      for(int a = 0; a < rightSide.length; a++){
         if(rightSide[a] != null){
            if(!rightSide[a].isDead())
               numLivingRight += 1;
            if(rightSide[a].isFighting())
               numFightingRight++;
         }
      }
      
      //System.out.println(numLivingLeft + ", " + numFightingLeft + " -- " + numLivingRight + ", " + numFightingRight);
      if(numFightingLeft == 0 || numFightingRight == 0){
         if(numFightingLeft > numFightingRight)
            winner = "Left";
         else
            winner = "Right";
         return true;
      }
      return false;
   }
   
   public void tick(){
      for(int x = 0; x < rightSide.length; x++){
         if(rightSide[x] != null && rightSide[x].isFighting()){ //If there is someone there and they are fighting
            double numHit = (Math.random()*2);
            if(numHit >= 1){ //IF THEY HIT SOMEONE
               int damage = 0;
               if(rightSide[x].isWounded())
                  damage = (int) (Math.random()*10);
               else
                  damage = (int) (Math.random()*10 + 5);
               int enemy = (int) (Math.random()*leftSide.length);
               leftSide[enemy].recieveDamage(damage);
            }
         }
      }
      
      for(int y = 0; y < leftSide.length; y++){
         if(leftSide[y] != null && leftSide[y].isFighting()){ //If there is someone there and they are fighting
            double numHit = (Math.random()*2);
            if(numHit >= 1){ //IF THEY HIT SOMEONE
               int damage = 0;
               if(leftSide[y].isWounded())
                  damage = (int) (Math.random()*10);
               else
                  damage = (int) (Math.random()*10 + 5);
               int enemy = (int) (Math.random()*rightSide.length);
               rightSide[enemy].recieveDamage(damage);
            }
         }
      }
      
      for(int a = 0; a < leftSide.length; a++){
         if(leftSide[a] != null){
            leftSide[a].tick();
         }
      }
      
      for(int a = 0; a < rightSide.length; a++){
         if(rightSide[a] != null){
            rightSide[a].tick();
         }
      }
   }
   
   public void render(Graphics g){
      for(int a = 0; a < leftSide.length; a++){
         if(leftSide[a] != null){
            leftSide[a].render(g, 30);
         }
      }
      
      for(int a = 0; a < rightSide.length; a++)
         if(rightSide[a] != null)
            rightSide[a].render(g, 30);
   }
   
   public String getWinner(){
      return winner;
   }
}