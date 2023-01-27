package dao;

import dao.generic.AbstractJpaDao;
import entities.Comment;

public class CommentDao extends AbstractJpaDao<Long, Comment> {

    public CommentDao() {
        this.setClazz(Comment.class);
    }
}
