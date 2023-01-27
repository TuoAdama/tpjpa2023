package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.implement.PersonDao;
import fr.istic.taa.jaxrs.entities.Person;

import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/person")
@Produces({"application/json"})
public class PersonResource {

    PersonDao personDao = new PersonDao();

    @GET
    @Path("/{personId}")
    public Person getPersonById(@PathParam("personId") Long personId)  {
        // return person
        return new Person();
    }

    @POST
    @Consumes("application/json")
    @Path("/add_person")
    public Response addPerson(
            @Parameter(description = "Person object that needs to be added to the store", required = true) Person person) {
        personDao.save(person);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Consumes("application/json")
    @Path("/delete_person")
    public void deletePerson( @Parameter Person person){
        personDao.delete(person);
    }
}
