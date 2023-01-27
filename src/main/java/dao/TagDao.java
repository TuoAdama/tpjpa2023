package dao;

import dao.generic.AbstractJpaDao;
import entities.Tag;

public class TagDao extends AbstractJpaDao<Long, Tag> {

    public TagDao() {
        this.setClazz(Tag.class);
    }
}