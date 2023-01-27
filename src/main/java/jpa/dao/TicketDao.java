package jpa.dao;

import entities.Ticket;

public class TicketDao extends BaseDAO<Ticket> {
    public TicketDao() {
        super(Ticket.class);
    }
}
