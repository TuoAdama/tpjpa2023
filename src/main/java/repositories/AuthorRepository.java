package repositories;

import entities.Author;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorRepository implements EntityRepository<Author>{

    EntityManager em = EntityManagerHelper.getEntityManager();

    @Override
    public void create(Author author) {
        em.persist(author);
    }

    @Override
    public void delete(Author author) {

    }

    @Override
    public void update(Author author) {

    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public Author find(long id) {
        return null;
    }
}
