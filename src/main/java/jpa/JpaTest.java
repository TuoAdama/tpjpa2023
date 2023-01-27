package jpa;

import entities.Ticket;
import repositories.BaseRepository;
import repositories.TicketRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Class<Ticket> t = Ticket.class;

		BaseRepository<Ticket> ticketRepository = new TicketRepository();


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
