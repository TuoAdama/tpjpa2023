package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.entities.Person;
import fr.istic.taa.jaxrs.entities.Ticket;

public class TicketDao extends AbstractJpaDao<Long, Ticket> {

    public TicketDao() {
        this.setClazz(Ticket.class);
    }
}