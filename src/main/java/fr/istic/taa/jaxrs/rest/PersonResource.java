package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.entities.Person;

import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/person")
@Produces({"application/json"})
public class PersonResource {

    @GET
    @Path("/{personId}")
    public Person getPersonById(@PathParam("personId") Long personId)  {
        // return person
        return new Person();
    }

    @GET
    public String getPersonById()  {
        return "foo";
    }


    @POST
    @Consumes("application/json")
    public Response addPerson(
            @Parameter(description = "Person object that needs to be added to the store", required = true) Person person) {
        // add pet
        return Response.ok().entity("SUCCESS").build();
    }
}
