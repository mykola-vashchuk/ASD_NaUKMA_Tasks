package PW4_Vashchuk;
    abstract class Animal {
        abstract void speak();
    }

class Cat extends Animal {
    @Override
    void speak(){ System.out.println("Мяу. Я кіт");}
}

class Dog extends Animal {
    @Override
    void speak(){ System.out.println("Я пес. Гав");}

    void fetchStick(){ System.out.println("Пес приніс палку");}
}
