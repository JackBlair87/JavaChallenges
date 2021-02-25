/*
Jack Blair 2/2/21
MIT Lisence by BruhLab
Java Development Resources - Quaratine CompSci
*/

import java.util.ArrayList;

public class VotingTable{

   public static void main(String[] args) {
      ArrayList<Player> players = generatePlayers("Red", "Blue");
      int[] votes = new int[11]; //One extra slot for "Skip Vote"
   
      for(Player p : players){
         Player voted_out = p.randomVote(players);
         if(voted_out == null){
            votes[10] += 1;
         }
         else{
            int index = players.indexOf(voted_out);
            votes[index] += 1;
         }
      }
      System.out.print(votes.toString());
   
      int max = 0;
      int max_index = 0;
      for(int x = 0; x < votes.length; x++){
         if(votes[x] > max){
            max = votes[x];
            max_index = x;
         }
      }
   
      Player ejected = players.get(max_index);
   
      System.out.println("Ejected " + ejected.color());
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