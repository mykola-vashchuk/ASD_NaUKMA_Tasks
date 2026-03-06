package HW_7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

public class TicketExporter {
    public void exportOpenTickets(Path path, Collection<Ticket> tickets) throws StorageException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Ticket ticket : tickets) {
                if (ticket.status() == TicketStatus.NEW || ticket.status() == TicketStatus.IN_PROGRESS) {
                    writer.write(String.format("%d, %s, %s, %s%n",
                            ticket.id(), ticket.userEmail(), ticket.title(), ticket.status()));
                }
            }
        } catch (IOException e) {
            throw new StorageException("Failed to write tickets to file: " + path, e);
        }
    }
}