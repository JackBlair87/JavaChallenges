import java.util.ArrayList;

public class Dog{
    private String color;
    private String name;
    private ArrayList<String> possibleColors;

    public Dog(String dogName, int dogColor){
        possibleColors = new ArrayList<String>();
        possibleColors.add("Orange");
        possibleColors.add("Yellow");
        possibleColors.add("Green");
        possibleColors.add("Purple");
        possibleColors.add("Blue");
        possibleColors.add("Pink");
        possibleColors.add("Red");

        color = possibleColors.get(dogColor);
        name = dogName;
    }

    public String toString(){
        return "My name is " + name + " and my collar is " + color;
    }
}