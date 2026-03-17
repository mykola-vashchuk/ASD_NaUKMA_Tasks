package PW_9.Task_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ticket {
    private int priority;
    private LocalDate createdAt;

    public Ticket(int priority, LocalDate createdAt) {
        this.priority = priority;
        this.createdAt = createdAt;
    }

    public int getPriority(){ return priority; }
    public LocalDate getCreatedAt(){ return createdAt;}

    static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>(List.of(
                new Ticket(3, LocalDate.now()),
                new Ticket(1, LocalDate.now().minusWeeks(1))
        ));

        tickets.sort(new Comparator<Ticket>() {
            @Override
            public int compare(Ticket t1, Ticket t2) {
                return Integer.compare(t1.getPriority(), t2.getPriority());
            }
        });

        tickets.sort((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority())); //рефакторинг на ламбду

        tickets.sort(Comparator.comparingInt(Ticket::getPriority)); //метод референс

    }
}
