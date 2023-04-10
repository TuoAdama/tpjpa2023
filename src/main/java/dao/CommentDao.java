package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.EntityManagerHelper;
import entities.Comment;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CommentDao extends AbstractJpaDao<Long, Comment> {

    public CommentDao() {
        this.setClazz(Comment.class);
    }


    public List<Comment> getTicketComments(Long id){
        EntityManager em = EntityManagerHelper.getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Comment> query = builder.createQuery(Comment.class);
        Root<Comment> root = query.from(Comment.class);
        query.select(root)
                .where(builder.equal(root.join("ticket").get("id"), id));
        return em.createQuery(query).getResultList();
    }
}
