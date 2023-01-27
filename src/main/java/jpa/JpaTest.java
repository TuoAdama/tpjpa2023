package jpa;

import entities.Ticket;
import jpa.dao.BaseDAO;
import jpa.dao.TicketDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Class<Ticket> t = Ticket.class;

		BaseDAO<Ticket> ticketRepository = new TicketDao();


		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			ticketRepository.getAll().forEach(ticket -> System.out.println(ticket.getTitle()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}

}
