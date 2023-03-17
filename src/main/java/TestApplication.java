import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import rest.*;

@ApplicationPath("/")
public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();
        clazzes.add(OpenApiResource.class);
        clazzes.add(AuthorResource.class);
        clazzes.add(CommentResource.class);
        clazzes.add(TicketResource.class);
        clazzes.add(TagResource.class);
        clazzes.add(SwaggerResource.class);
        clazzes.add(Configuration.class);
        return clazzes;
    }

}