package PW_9;

public class Task2 {

    public String buildTicketId(String base) {
        int ticketCounter = 42; //effectively final

        class IdBuilder { // local
            // існує і видимий тільки в межах цього методу
            public String generate() {
                return base.toUpperCase() + "-" + ticketCounter;
            }
        }

        IdBuilder builder = new IdBuilder();
        return builder.generate();
    }

    public Runnable runOnce() { // anonymous
        // без імені, на льоту створюжться для якогось одного разу
        //одразу реалізує інтерфейсь і створює об'єкт
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class executed.");
            }
        };
    }
}
