package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.entities.Person;

public class TagDao extends AbstractJpaDao<Long, Person> {

    public TagDao() {
        this.setClazz(Person.class);
    }
}