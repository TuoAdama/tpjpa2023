package dao;

import dao.generic.AbstractJpaDao;
import entities.Ticket;

public class TicketDao extends AbstractJpaDao<Long, Ticket> {

    public TicketDao() {
        this.setClazz(Ticket.class);
    }
}