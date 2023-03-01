
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import rest.AuthorResource;
import rest.CommentResource;
import rest.SwaggerResource;
import rest.TagResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * RESTfull microservice, based on JAX-RS and JBoss Undertow
 *
 */
public class RestServer extends Application {


    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<>();
        resources.add(OpenApiResource.class);
        resources.add(AuthorResource.class);
        resources.add(CommentResource.class);
        resources.add(TagResource.class);
        resources.add(SwaggerResource.class);
        return resources;
    }

    private static final Logger logger = Logger.getLogger(RestServer.class.getName());

    public static void main( String[] args ) {

        UndertowJaxrsServer ut = new UndertowJaxrsServer();

        TestApplication ta = new TestApplication();

        ut.deploy(ta);

        ut.start(
                Undertow.builder()
                        .addHttpListener(8080, "localhost")

        );

        logger.info("JAX-RS based micro-service running!");
    }
}