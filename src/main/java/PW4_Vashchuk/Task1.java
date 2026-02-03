package PW4_Vashchuk;

public class Task1 {
    public static void main (String[] args){
        run();
    }
    static void run() {
        Animal[] animals= { new Dog(), new Dog(), new Cat() };
         for (Animal a: animals){
            a.speak();
         }
    }
}
