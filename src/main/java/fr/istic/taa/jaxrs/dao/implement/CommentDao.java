package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.entities.Person;

public class CommentDao extends AbstractJpaDao<Long, Person> {

    public CommentDao() {
        this.setClazz(Person.class);
    }
}
