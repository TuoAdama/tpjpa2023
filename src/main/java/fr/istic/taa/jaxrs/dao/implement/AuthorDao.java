package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.entities.Author;
import fr.istic.taa.jaxrs.entities.Person;

public class AuthorDao extends AbstractJpaDao<Long, Author> {

    public AuthorDao() {
        this.setClazz(Author.class);
    }
}