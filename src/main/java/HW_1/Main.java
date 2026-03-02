package HW_1;

import java.sql.SQLOutput;

public class Main {
    static void main() {
        Dog barsik = new Dog("barsil", 2, true, "golden");
        Dog netro = new Dog("netro", 3, true, "black-indian");

        Cat halk = new Cat("halk", 4, true, "gray");
        Cat halk1 = new Cat("halk", 4, true, "gray");
        Cat baobab = new Cat("baobab", 6, true, "black");

        Animal[] animals = {barsik, netro, halk, halk1, baobab};
        System.out.println("\nAnimals are:");
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }

        System.out.println("\nFeeding the animals:");
        for (Animal animal : animals) {
            feed(animal);
        }

        System.out.println("\nSafe downcast");
        Animal someAnimal = barsik;
        if (someAnimal instanceof Dog) {
            Dog specificDog = (Dog) someAnimal;
            System.out.println("Breed of this dog: " + specificDog.getBreed());
        }
        Animal someAnimal2 = halk;
        if (someAnimal2 instanceof Dog) {
            Dog specificDog2 = (Dog) someAnimal2;
            System.out.println("Breed of this dog: " + specificDog2.getBreed());
        }else {
        System.out.println("This is not a Dog");
        }

        System.out.println("\n == VS equals()");
        System.out.println("halk == halk1: "  +  (halk == halk1));
        System.out.println("halk.equals(halk1): "  +  halk.equals(halk1));
    }

    private static void feed(Animal animal) {
        System.out.println("The " + animal.getName() + " is being feeded.");
    }
}
