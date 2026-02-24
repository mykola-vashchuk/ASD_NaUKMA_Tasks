package PW_7.Task_1;

import java.util.Objects;

public record Order(int id, String userEmail, double totalCents ) {

    public Order {
        if(id <= 0){throw new IllegalArgumentException("Order id must be positive.");}
        if(userEmail == null || !userEmail.contains("@")){throw new IllegalArgumentException("User email address must contain @");}
        if(totalCents < 0){throw new IllegalArgumentException("Total cents must be more than 0.");}
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(totalCents, order.totalCents) == 0 && Objects.equals(userEmail, order.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEmail, totalCents);
    }
}
