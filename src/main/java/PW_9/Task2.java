package PW_9;

public class Task2 {

    public String buildTicketId(String base) {
        int ticketCounter = 42; //effectively final

        class IdBuilder {
            public String generate() {
                return base.toUpperCase() + "-" + ticketCounter;
            }
        }

        IdBuilder builder = new IdBuilder();
        return builder.generate();
    }

    public Runnable runOnce() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class executed.");
            }
        };
    }
}
