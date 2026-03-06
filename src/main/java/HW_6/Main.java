package HW_6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Paths;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        TicketService service = new TicketService();
        TicketExporter exporter = new TicketExporter();

        // successful
        Ticket t1 = service.createTicket("student@naukma.edu.ua", "Bug in portal");
        service.assignTicket(t1.id(), "support_agent_1");

        // exporting to file
        try {
            exporter.exportOpenTickets(Paths.get("active_tickets.csv"), service.getAllTickets());
            System.out.println("Export successful!");
        } catch (StorageException e) {
            System.err.println("System Error: " + e.getMessage());
            log.error("Export failure", e);
        }

        // exception
        try {
            service.resolveTicket(99L); //no such id
        } catch (AppException e) {
            System.out.println("User Warning: " + e.getMessage());
        }
    }
}