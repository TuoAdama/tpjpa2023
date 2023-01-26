package repositories;

import entities.Ticket;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketRepository extends BaseRepository<Ticket> {

}
