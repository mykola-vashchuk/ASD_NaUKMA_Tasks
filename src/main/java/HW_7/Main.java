package HW_7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
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

        // business exception
        try {
            service.resolveTicket(99L); //no such id
        } catch (AppException e) {
            System.out.println("User Warning: " + e.getMessage());
        }

        // infrastructure error (checked)
        try {
            Path restrictedPath = Paths.get("/root/denied_access.csv");
            exporter.exportOpenTickets(restrictedPath, service.getAllTickets());
        } catch (StorageException e) {

            System.out.println("USER MESSAGE: The system cannot save the file at the moment. Please contact your administrator.");

            log.error("Infrastructure failure during export to path: {}", e.getMessage(), e);
        }
    }
}