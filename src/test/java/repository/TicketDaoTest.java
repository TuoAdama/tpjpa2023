package repository;

import entities.Author;
import entities.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jpa.dao.BaseDAO;
import jpa.dao.TicketDao;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoTest {

    BaseDAO ticketRepository;
    Author author;
    @BeforeEach
    void setUp(){
        ticketRepository = new TicketDao();
        ticketRepository.deleteAll();
        author = new Author();
        author.setName("Tuo");

        Ticket t1 = new Ticket();
        t1.setTitle("Ticket 1");
        t1.setContent("Ceci est un signé");
        t1.setPublishedDate(LocalDateTime.now());
        t1.setAuthor(author);

        Ticket t2 = new Ticket();
        t2.setTitle("Ticket 1");
        t2.setContent("Ceci est un signé");
        t2.setPublishedDate(LocalDateTime.now());
        t2.setAuthor(author);

        ticketRepository.create(t2);
        ticketRepository.create(t1);
    }

    @Test
    void create(){
        Ticket t1 = new Ticket();
        t1.setTitle("Ticket 1");
        t1.setContent("Ceci est un signé");
        t1.setPublishedDate(LocalDateTime.now());
        t1.setTags(new ArrayList<>());
        assertEquals(2, ticketRepository.count());
        ticketRepository.create(t1);
        assertEquals(3, ticketRepository.count());
    }

    @Test
    void count(){
        long count = ticketRepository.count();
        assertEquals(2, count);
    }

    @Test
    void deleteAll(){
        ticketRepository.deleteAll();;
        assertEquals(0, ticketRepository.count());
    }

    @Test
    void getAll(){
        List<Ticket> tickets =  ticketRepository.getAll();
        assertEquals(2, tickets.size());
    }
}
