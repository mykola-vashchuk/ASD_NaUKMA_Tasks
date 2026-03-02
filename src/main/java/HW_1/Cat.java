package HW_1;

import java.awt.*;
import java.util.Objects;

public class Cat extends Mammal {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat(String name, int age, boolean hasFur, String color) {
        super(name, age, hasFur);
        this.color = color;
    }
    @Override
    public String toString(){
        return "Cat{ "+
                super.toString() +
                "color=" + color +
                "} ";
    }
    @Override
    public boolean equals(Object o){
        if (this ==  o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return getAge() == cat.getAge()
                && Objects.equals(getName(), cat.getName())
                && Objects.equals(getColor(), cat.getColor());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getName(), getAge(), getColor());
    }
}
