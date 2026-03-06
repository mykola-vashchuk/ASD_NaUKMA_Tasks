package HW_7;

public record Ticket(long id, String userEmail, String title, TicketStatus status) {
    public Ticket {
        if (id <= 0) { throw new IllegalArgumentException("ID must be positive!"); }
        if (!userEmail.contains("@") || userEmail == null) { throw new IllegalArgumentException("Invalid email!"); }
        if (title == null) { throw new IllegalArgumentException("Invalid title!"); }
    }
}
