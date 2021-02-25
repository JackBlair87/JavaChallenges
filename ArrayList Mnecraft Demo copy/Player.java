public class Player {
    public static void main(String[] args){
        

    }

    public static Dog tameDog(String name){
        Dog dog = new Dog(name, (int) (Math.random()*7));
        return dog;
    }
}
