/*
Jack Blair 2/2/21
MIT Lisence by BruhLab
Java Development Resources - Quaratine CompSci
*/

import java.util.ArrayList;

public class ParkingGarage {
    /*
        You run a parking garage in DC.
        Your job is to maintain a list of every car currently in the parking garage.
        The parking garage has a limit of 15 cars.

        Every hour, cars will fill and leave the parking garage, and you must update your list accordingly.
        Print out the number of cars in the garage at the end of every hour.
        The garage is open from 10 AM to 1 PM
    */

    public static void main(String[] args) {

        //Create your ArrayList to store the cars
        ArrayList<Car> parking = new ArrayList<Car>();

        //Before Mall Opens
        System.out.println();
        System.out.println("9 AM ------Mall not Open--------");
        
        towCheck(parking);
        printCapacity(parking);

        //10 AM
        System.out.println();
        System.out.println("10 AM ----------------------------");

        Car c1 = newCar("Ford", false);
        parking.add(c1);
        Car c2 = newCar("Toyota", false);
        parking.add(c2);

        towCheck(parking);
        printCapacity(parking);

        //11 AM
        System.out.println();
        System.out.println("11 AM ----------------------------");

        Car c3 = newCar("Lambo", false);
        parking.add(c3);
        Car c4 = newCar("Chevy", true);
        parking.add(c4);

        towCheck(parking);
        printCapacity(parking);

        //12 PM
        System.out.println();
        System.out.println("12 PM ----------------------------");

        Car c5 = newCar("Ferrari", false);
        parking.add(c5);
        carLeft(parking, c1);

        towCheck(parking);
        printCapacity(parking);

        //1 PM
        System.out.println();
        System.out.println("1 PM ----------------------------");

        Car c6 = newCar("Tesla", false);
        parking.add(c6);
        carLeft(parking, c2);
        carLeft(parking, c3);

        towCheck(parking);
        printCapacity(parking);

        //2 PM
        System.out.println();
        System.out.println("2 PM --------Mall closed---------");
        
        carLeft(parking, c6);

        towEveryCar(parking);
        printCapacity(parking);
    }

    public static Car newCar(String brand, boolean broken){
        Car c1 = new Car(brand, broken);
        if(broken)
            System.out.println("A new car has arrived! It is a " + brand + " and is broken.");
        else
            System.out.println("A new car has arrived! It is a " + brand + " and is not broken.");
        return c1;
    } 

    public static void carLeft(ArrayList<Car> c, Car car){
        System.out.println("A " + car.getBrand() + " has left the lot.");
        c.remove(car);
    }

    public static void printCapacity(ArrayList<Car> c){
        if(c.isEmpty()){
            System.out.println("The lot is empty...");
        }
        else{
            System.out.print("There are " + c.size() + " cars in the lot. They are ");
            for(Car vehicle : c)
                System.out.print("and a " + vehicle.getBrand() + " ");
        }
        System.out.println();
    }

    public static void towEveryCar(ArrayList<Car> c) {
        c.clear();
        System.out.println("Removed Every Car.");
    }

    public static boolean emptySpot(ArrayList<Car> c) {
        return c.size() < 15;
    }

    public static void towCheck(ArrayList<Car> c) {
        for(int index = 0; index < c.size(); index++){
            if(c.get(index).getStatus() == true){
                System.out.println("Removed a broken down " + c.get(index).getBrand());
                c.remove(c.get(index));
            }
        }
    }
}
