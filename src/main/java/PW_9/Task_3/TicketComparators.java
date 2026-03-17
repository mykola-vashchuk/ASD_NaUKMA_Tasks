package PW_9.Task_3;

import java.util.Comparator;

public class TicketComparators {
    public static final Comparator<Ticket> BY_PRIORITY = Comparator.comparingInt(Ticket::getPriority);
    public static final Comparator<Ticket> BY_CREATEED_AT = Comparator.comparing(Ticket::getCreatedAt);

    public static final Comparator<Ticket> BY_PRIORITY_THEN_BY_CREATED_AT = BY_PRIORITY.thenComparing(BY_CREATEED_AT);


 }
