import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import rest.AuthorResource;
import rest.CommentResource;
import rest.TagResource;
import rest.TicketResource;

public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();
        clazzes.add(OpenApiResource.class);
        clazzes.add(AuthorResource.class);
        clazzes.add(CommentResource.class);
        clazzes.add(TicketResource.class);
        clazzes.add(TagResource.class);

        return clazzes;
    }

}