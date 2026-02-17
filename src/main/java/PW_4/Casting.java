package PW_4;

public class Casting {
    public static void main(String[] args) {
        run();
    }
    static void run() {
        Animal a = new Dog();
        Animal b = new Cat();

        if (a instanceof Dog abracadabra) {
            abracadabra.fetchStick();
        }

        if(b instanceof Dog brabacadabra){
            brabacadabra.fetchStick();
        }else
            System.out.println("Це не пес");

    }
}
