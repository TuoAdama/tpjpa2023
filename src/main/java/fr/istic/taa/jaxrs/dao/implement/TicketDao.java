package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.entities.Person;

public class TicketDao extends AbstractJpaDao<Long, Person> {

    public TicketDao() {
        this.setClazz(Person.class);
    }
}