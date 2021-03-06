/*
Jack Blair 2/2/21
MIT Lisence by BruhLab
Java Development Resources - Quaratine CompSci
*/

import java.util.ArrayList;

public class Player {

   private String color;
   private boolean imposter;

   public Player(String color, boolean isImposter){
      imposter = isImposter;
      this.color = color;
   }

   public Player randomVote(ArrayList<Player> players){
   //Select a random index in the list; or -1 for a "skip" vote
      int random = (int) (Math.random() * (players.size()+1)) - 1;
      if(random == -1)
         return null; //return here for a "Skip"
      return players.get(random); //Otherwise return the player at that index
   }
   
   public String color(){
      return color;
   }
   
   public boolean isImposter(){
      return imposter;
   }
}
