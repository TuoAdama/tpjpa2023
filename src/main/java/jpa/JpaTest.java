package jpa;

import entities.Author;
import entities.Ticket;
import repositories.EntityRepository;
import repositories.TicketRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityRepository<Ticket> ticketRepository = new TicketRepository();


		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			Ticket t1 = new Ticket();
			t1.setSolve(false);
			t1.setTitle("Ticket 1");
			t1.setContent("solving ticket 1");
			t1.setPublishedDate(LocalDateTime.now());
			Author author = new Author();
			author.setName("Adama Tuo");
			t1.setAuthor(author);
			ticketRepository.create(t1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}

}
