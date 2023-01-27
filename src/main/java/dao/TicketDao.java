package dao;

import dao.generic.AbstractJpaDao;
import entities.Ticket;

public class TicketDao extends AbstractJpaDao<Long, Ticket> {
    TicketDao(){
        setClazz(Ticket.class);
    }
}
