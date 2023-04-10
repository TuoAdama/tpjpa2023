package rest;
import dao.CommentDao;
import entities.Comment;
import entities.Ticket;
import io.swagger.v3.oas.annotations.Parameter;
import utils.ResponseHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/comment")
@Produces({"application/json"})
public class CommentResource {

    CommentDao commentDao = new CommentDao();

    @GET
    @Path("/find/{id}")
    public Response find(@PathParam("id") Long id) {
        Comment comment = commentDao.findOne(id);
        if(comment == null){
            return ResponseHandler.notFoundResponse();
        }
        return ResponseHandler.successResponse(comment);
    }

    @POST
    @Consumes("application/json")
    @Path("/add")
    public Response add(
            @Parameter(description = "Ticket object that needs to be added to the store", required = true) Comment comment) {
        commentDao.save(comment);
        return ResponseHandler.successResponse(comment);
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id){
        Comment comment = commentDao.findOne(id);
        if(comment == null){
            return ResponseHandler.notFoundResponse();
        }
        commentDao.delete(comment);
        return ResponseHandler.successResponse(comment);
    }

    @GET
    @Path("/ticket/{id}")
    public Response getTicketComments(@PathParam("id") Long ticketId){
        List<Comment> comments = commentDao.getTicketComments(ticketId);
        return ResponseHandler.successResponse(comments);
    }
}
