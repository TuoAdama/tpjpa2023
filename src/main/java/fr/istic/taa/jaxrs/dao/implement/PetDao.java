package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.entities.Person;

public class PetDao extends AbstractJpaDao<Long, Person> {

    public PetDao() {
        this.setClazz(Person.class);
    }
}