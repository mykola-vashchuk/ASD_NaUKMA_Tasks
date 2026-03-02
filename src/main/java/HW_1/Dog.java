package HW_1;

import java.util.Objects;

public class Dog extends Mammal {
    private String breed;

    public Dog(String name, int age, boolean hasFur,  String breed) {
        super(name, age, hasFur);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString(){
        return "Dog{ "+
                super.toString() +
                "breed=" + breed+
                "} ";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return getAge() == dog.getAge()
                && Objects.equals(getName(), dog.getName())
                && Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), breed);
    }
}
