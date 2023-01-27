package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.entities.Person;

public class PersonDao extends AbstractJpaDao<Long, Person> {

    public PersonDao() {
        this.setClazz(Person.class);
    }
}
