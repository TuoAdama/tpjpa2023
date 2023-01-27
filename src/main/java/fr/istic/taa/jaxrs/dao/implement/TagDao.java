package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.entities.Tag;

public class TagDao extends AbstractJpaDao<Long, Tag> {

    public TagDao() {
        this.setClazz(Tag.class);
    }
}