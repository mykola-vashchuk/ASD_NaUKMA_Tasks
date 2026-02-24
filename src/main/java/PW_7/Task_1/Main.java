package PW_7.Task_1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program has started!");
        Order order = new Order(8, "vashchuk@ukma.edu.ua", 200);
        System.out.println("Order has been created!\n"+ order);

        Order badOrder = new Order(-2, "vashchuk@ukma.edu.ua", 300);

        System.out.println("This text isn't in reach");
    }
}

