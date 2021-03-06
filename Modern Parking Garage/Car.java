/*
Jack Blair 2/2/21
MIT Lisence by BruhLab
Java Development Resources - Quaratine CompSci
*/

public class Car{

    private String brand;
    private boolean brokenDown;

    public Car(String b, boolean broken) {
        brand = b;
        brokenDown = broken;
    }

    //Returns the brand of the car
    public String getBrand(){
        return brand;
    }

    //Returns whether or not the car is broken down and needs to be towed
    public boolean getStatus() {
        return brokenDown;
    }
}