package repositories;

import entities.Ticket;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketRepository implements EntityRepository<Ticket> {

    EntityManager em = EntityManagerHelper.getEntityManager();

    @Override
    public void create(Ticket ticket) {
       em.persist(ticket);
    }

    @Override
    public void delete(Ticket ticket) {

    }

    @Override
    public void update(Ticket ticket) {

    }

    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public Ticket find(long id) {
        return null;
    }
}
