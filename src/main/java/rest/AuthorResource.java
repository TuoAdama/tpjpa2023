package rest;

import dao.AuthorDao;
import entities.Author;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/author")
@Produces({"application/json"})
public class AuthorResource {

    AuthorDao authDao = new AuthorDao();

    @GET
    @Path("/{authorId}")
    public Author getAuthorById(@PathParam("authorId") Long authorId)  {
        return authDao.findOne(authorId);
    }

    @POST
    @Consumes("application/json")
    @Path("/add")
    public Response addAuthor(
            @Parameter(description = "Author object that needs to be added to the store", required = true) Author author) {
        if( ! author.getName().isEmpty()) {
            authDao.save(author);
        }
        else {
            return Response.serverError().build();
        }
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delete")
    public void deleteAuthor(
            @Parameter Author author){
        authDao.delete(author);
    }
}
