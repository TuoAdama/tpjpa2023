package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.EntityManagerHelper;
import entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class AuthorDao extends AbstractJpaDao<Long, Author> {

    public AuthorDao() {
        this.setClazz(Author.class);
    }


    public Author authenticate(String username, String password){
        String query = "SELECT a from Author a WHERE a.email = :email AND a.password = :password";
        Author author = null;
        try {
            author = EntityManagerHelper
                    .getEntityManager()
                    .createQuery(query, Author.class)
                    .setParameter("email", username)
                    .setParameter("password", password)
                    .getSingleResult();
        }catch (NoResultException e){}
        return author;
    }

}