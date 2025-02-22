
import com.github.javafaker.Faker;
import dao.AuthorDao;
import dao.CommentDao;
import dao.TagDao;
import dao.TicketDao;
import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import javax.ws.rs.core.Application;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * RESTfull microservice, based on JAX-RS and JBoss Undertow
 *
 */
public class RestServer extends Application {
    private static final Logger logger = Logger.getLogger(RestServer.class.getName());

    public static void main( String[] args ) {

        UndertowJaxrsServer ut = new UndertowJaxrsServer();


        TestApplication ta = new TestApplication();

        DataDump dataDump = new DataDump();
        dataDump.setFaker(new Faker(new Locale("fr")));
        dataDump.setAuthorDao(new AuthorDao());
        dataDump.setTicketDao(new TicketDao());
        dataDump.setCommentDao(new CommentDao());
        dataDump.setTagDao(new TagDao());
        //dataDump.dumpData(); // Fill database with fake data;

        ut.deploy(ta);

        ut.start(
                Undertow.builder()
                        .addHttpListener(8080, "localhost")


        );
        logger.info("JAX-RS based micro-service running!");
    }
}


// Débouchés
// Programme de formations
// Fichers