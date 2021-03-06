/*
Jack Blair 2/2/21
MIT Lisence by BruhLab
Java Development Resources - Quaratine CompSci
*/

import java.util.*;
import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class PresidentSearcher {
   public static void main(String[] args){
      ArrayList<President> presidents = readData("./presidents.txt");
      //System.out.println(whoWasPresIn(1956, presidents).toString());
      //System.out.println(whoWasPresFor("Charles G. Dawes", presidents).toString());
      //display(presidents);
   }

   public static ArrayList<President> readData(String filename){
      ArrayList<President> pres = new ArrayList<President>(50);
      try {
         File f = new File(filename);
         Scanner reader = new Scanner(f);
         while (reader.hasNextLine()) {
            String data = reader.nextLine();
            pres.add(new President(data));
         }
         reader.close();
      } catch (Exception e) {
         System.out.println("Couldn't find file of presidents!");
      }
   
      return pres;
   }

   public static President whoWasPresIn(int year, ArrayList<President> pres){
      //Loop through all the Presidents and return the one who was serving that year
      //If the year is out of bounds, let the user know
   }

   public static President whoWasPresFor(String vice, ArrayList<President> pres){
      //Given a vice president, Loop through all the Presidents and return the one who was serving
      //If the year is out of bounds, return none
 }

   public static void display(ArrayList<President> pres){
      //display every president in US History
      //Call the .toString() method of every president
   }
}