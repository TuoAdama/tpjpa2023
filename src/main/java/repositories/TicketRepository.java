package repositories;

import entities.Ticket;

public class TicketRepository extends BaseRepository<Ticket> {
    public TicketRepository() {
        super(Ticket.class);
    }
}
