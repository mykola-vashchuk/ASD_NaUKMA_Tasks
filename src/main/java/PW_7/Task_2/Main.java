package PW_7.Task_2;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        try {
            orderService.checkout(5, "komod@ukma.edu.ua");
        } catch (OrderProcessingException e) {
            e.printStackTrace();
        }
    }
}

