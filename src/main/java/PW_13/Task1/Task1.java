package PW_13.Task1;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, 2500),
                new Order(2, 1200),
                new Order(3, 800)
        );

        AtomicInteger sum = new AtomicInteger(0);
        AtomicInteger max = new AtomicInteger(0);

        Runnable calcSum = () -> {
            int total = orders.stream().mapToInt(Order::totalCents).sum();
            sum.set(total);
        };

        Runnable calcMax = () -> {
            int maxVal = orders.stream().mapToInt(Order::totalCents).max().orElse(0);
            max.set(maxVal);
        };

        TaskRunner.runAndWait(List.of(calcSum, calcMax));

        System.out.println("Sum: " + sum.get() + " cents");
        System.out.println("Max: " + max.get() + " cents");
    }
}