package jpa;

import entities.Author;
import entities.Comment;
import entities.Tag;
import entities.Ticket;
import repositories.AuthorRepository;
import repositories.CommentRepository;
import repositories.EntityRepository;
import repositories.TagRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityRepository<Author> authorRepository = new AuthorRepository();
		EntityRepository<Comment> commentRepository = new CommentRepository();
		EntityRepository<Tag> tagRepository = new TagRepository();

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			authorRepository.create(new Author());
			tagRepository.create(new Tag());
			commentRepository.create(new Comment());
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
