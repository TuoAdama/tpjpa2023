import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import rest.PetResource;

public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(PetResource.class);
        clazzes.add(OpenApiResource.class);


        return clazzes;
    }

}