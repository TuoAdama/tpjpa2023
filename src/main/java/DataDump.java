import com.github.javafaker.Faker;
import dao.AuthorDao;
import dao.CommentDao;
import dao.TagDao;
import dao.TicketDao;
import entities.Author;
import entities.Comment;
import entities.Tag;
import entities.Ticket;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class DataDump {

    private AuthorDao authorDao;
    private TicketDao ticketDao;
    private CommentDao commentDao;
    private TagDao tagDao;
    private Faker faker;

    private final int NUM_OF_AUTHOR = 30;
    private final int NUM_OF_TICKET_PER_AUTHOR = 10;
    private final int NUM_OF_COMMENT_PER_TICKET = 10;
    private final int NUM_OF_TAG = 5;

    private void createAuthor(){
        for (int i = 0; i < NUM_OF_AUTHOR; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            Author author = new Author();
            author.setName(firstName+" "+lastName);
            author.setTickets(createTickets());
            authorDao.save(author);
        }
    }

    private List<Ticket> createTickets(){
        List<Ticket> tickets = new ArrayList<>();
        boolean solve = false;
        for (int i = 0; i < NUM_OF_TICKET_PER_AUTHOR; i++) {
            solve = !solve;
            Ticket ticket = new Ticket();
            String title = faker.lorem().word();
            String content = faker.lorem().sentence();
            ticket.setTitle(title);
            ticket.setContent(content);
            ticket.setSolve(solve);
            ticket.setComments(createComments());

            tickets.add(ticket);  //Added each ticket created
        }
        return tickets;
    }


    private List<Comment> createComments(){
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i < NUM_OF_COMMENT_PER_TICKET; i++) {
            Comment comment = new Comment();
            comment.setContent(faker.lorem().sentence(10));
            comments.add(comment);
        }
        return comments;
    }


    private void createTags(){
        String[] labels = {"LOADING", "DONE", "INIT"};
        for (String label : labels) {
            Tag tag = new Tag();
            tag.setLabel(label);
            tagDao.save(tag);
        }
    }


    public void dumpData(){
        System.out.println("------------------------------------- DUMP --------------------");
        createAuthor();
        createTags();
    }

}
