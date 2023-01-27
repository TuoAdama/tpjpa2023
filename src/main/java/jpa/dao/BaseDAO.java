package jpa.dao;

import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

public class BaseDAO<T> {

    String className;
    String queryString;

    Class<T> t;
    protected EntityManager em = EntityManagerHelper.getEntityManager();
    protected CriteriaBuilder cb = em.getCriteriaBuilder();
    protected CriteriaQuery<T> query;
    protected Root<T> from;

    public BaseDAO(Class<T> t){
        this.t = t;
        this.query = cb.createQuery(this.t);
        this.className = t.getName().split("\\.")[1];
    }

    public void create(T t){
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }
    public void delete(long id){
        CriteriaDelete<T> delete = cb.createCriteriaDelete(this.t);
        from = delete.from(this.t);
        delete.where(cb.equal(from.get("id"), id));
        EntityManagerHelper.beginTransaction();
        em.createQuery(delete).executeUpdate();
        EntityManagerHelper.commit();
    }
    public void update(T t){
        EntityManagerHelper.beginTransaction();
        em.merge(t);
        EntityManagerHelper.commit();
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

    public long count(){
        queryString = "select count(e) from "+this.className+" e";
        return (Long) em.createQuery(queryString).getSingleResult();
    }
    public void deleteAll(){
        EntityManagerHelper.beginTransaction();
        queryString = "delete from "+className;
        em.createQuery(queryString).executeUpdate();
        EntityManagerHelper.commit();
    }

}
