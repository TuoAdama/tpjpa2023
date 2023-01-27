package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.entities.Comment;
import fr.istic.taa.jaxrs.entities.Person;

public class CommentDao extends AbstractJpaDao<Long, Comment> {

    public CommentDao() {
        this.setClazz(Comment.class);
    }
}
