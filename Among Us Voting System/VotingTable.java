/*
Jack Blair 2/2/21
MIT Lisence by BruhLab
Java Development Resources - Quaratine CompSci
*/

import java.util.ArrayList;

public class VotingTable{

   public static void main(String[] args) {
      String imposter1 = "Red";
      String imposter2 = "Blue";

      ArrayList<Player> players = null;

      /*You must do a few things:
         1. Generate a lobby of new players
         2. Create an Array to tally votes
         3. Loop through every player and call the randomVote() method 
         4. Tally all the votes (accounting for a "skip" vote)
         5. Find who has the most votes and eject them
      */

   }

   public static ArrayList<Player> generatePlayers(String imposter1, String imposter2){
      ArrayList<Player> players = new ArrayList<Player>();
      String[] colors = {"Red", "Green", "Blue", "Lime", "Orange", "Black", "White", "Dark Blue", "Yellow", "Cyan"};
      
      if(imposter1.equals(imposter2)){
         System.out.println("Imposters must be two different colors.");
         System.exit(0);
      }
      
      for(int x = 0; x < colors.length; x++){
         if(colors[x].equals(imposter1) || colors[x].equals(imposter2))
            players.add(new Player(colors[x], true));
         else
            players.add(new Player(colors[x], false));
      }
      
      System.out.println("Imposters are " + imposter1 + " and " + imposter2 + ".");
      return players;
   }
}