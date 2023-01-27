package dao;

import dao.generic.AbstractJpaDao;
import entities.Author;

public class AuthorDao extends AbstractJpaDao<Long, Author> {

    public AuthorDao() {
        this.setClazz(Author.class);
    }
}