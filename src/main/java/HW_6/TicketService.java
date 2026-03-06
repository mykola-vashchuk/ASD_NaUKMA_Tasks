package HW_6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class TicketService {
    private static final Logger log = LoggerFactory.getLogger(TicketService.class);
    private final Map<Long, Ticket> tickets = new HashMap<>();
    private long nextId = 1L;

    public Ticket createTicket(String userEmail, String title) {
        Ticket ticket = new Ticket(nextId++, userEmail, title, TicketStatus.NEW);
        tickets.put(ticket.id(), ticket);
        log.info("Ticket created with id: {}", ticket.id());
        return ticket;
    }

    public Ticket findById(long id) {
        Ticket ticket = tickets.get(id);
        if (ticket == null) {
            throw new TicketNotFoundException("Ticket with id " + id + " not found");
        }
        return ticket;
    }

    public Ticket assignTicket(long id, String agentEmail) {
        Ticket ticket = findById(id);
        if (ticket.status() == TicketStatus.RESOLVED) {
            log.warn("Failed to assign ticket {}: already resolved", id);
            throw new TicketStateException("Cannot assign a resolved ticket");
        }
        Ticket updatedTicket = new Ticket(ticket.id(), ticket.userEmail(), ticket.title(), TicketStatus.IN_PROGRESS);
        tickets.put(updatedTicket.id(), updatedTicket);
        log.info("Ticket {} assigned to agent {}", updatedTicket.id(), agentEmail);
        return updatedTicket;
    }

    public Ticket resolveTicket(long id) {
        Ticket ticket = findById(id);
        if (ticket.status() == TicketStatus.RESOLVED) {
            log.warn("Failed to resolve ticket {}: already resolved", id);
            throw new TicketStateException("Ticket is already resolved");
        }
        Ticket updatedTicket = new Ticket(ticket.id(), ticket.userEmail(), ticket.title(), TicketStatus.RESOLVED);
        tickets.put(updatedTicket.id(), updatedTicket);
        log.info("Ticket {} resolved", updatedTicket.id());
        return updatedTicket;
    }

    public Collection<Ticket> getAllTickets() {
        return tickets.values();
    }
}