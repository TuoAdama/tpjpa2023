package repositories;

import entities.Ticket;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class BaseRepository<T> {

    Class<T> t;
    protected EntityManager em = EntityManagerHelper.getEntityManager();
    protected CriteriaBuilder cb = em.getCriteriaBuilder();
    protected CriteriaQuery<T> query;
    protected Root<T> from;

    public BaseRepository(){
        this.query = cb.createQuery(this.t);
    }

    public void create(T t){
        em.persist(t);
    }
    public void delete(long id){
        CriteriaDelete<T> delete = cb.createCriteriaDelete(this.t);
        from = delete.from(this.t);
        delete.where(cb.equal(from.get("id"), id));
        em.createQuery(delete).executeUpdate();
    }
    public void update(T t){
        em.merge(t);
    }

    public List<T> getAll(){
        from = query.from(this.t);
        query = query.select(from);
        return em.createQuery(query).getResultList();
    }

    public T find(long id){
        query = cb.createQuery(this.t);
        from = query.from(this.t);
        query.where(cb.equal(from.get("id"), id));
        return em.createQuery(query).getSingleResult();
    }

}
