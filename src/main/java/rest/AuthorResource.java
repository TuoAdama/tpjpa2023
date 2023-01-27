package rest;

import dao.AuthorDao;
import entities.Author;
import io.swagger.v3.oas.annotations.Parameter;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/author")
@Produces({"application/json"})
public class AuthorResource {

    AuthorDao authDao = new AuthorDao();

    @GET
    @Path("/all")
    public Response getAllAuthors(){
        return Response.status(Status.OK)
                .entity(authDao.findAll())
                .build();
    }

    @GET
    @Path("/find/{authorId}")
    public String getAuthorById(@PathParam("authorId") Long authorId)  {
        return "";
    }

    @POST
    @Consumes("application/json")
    @Path("/add")
    public Response addAuthor(
            @Parameter(description = "Author object that needs to be added to the store", required = true) Author author) {
        authDao.save(author);
        return Response.status(Response.Status.OK)
                .entity(author)
                .build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delete/{id}")
    public Response deleteAuthor(
            @PathParam("id") Long id){

        Author author = authDao.findOne(id);
        if(author ==  null){
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
        authDao.deleteById(id);
        return Response.status(Response.Status.OK)
                .entity(id)
                .build();
    }
}
