package rest;
import dao.AuthorDao;
import dao.CommentDao;
import entities.Author;
import entities.Comment;
import entities.Ticket;
import io.swagger.v3.oas.annotations.Parameter;
import utils.ResponseHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;


@Path("/comment")
@Produces({"application/json"})
public class CommentResource {

    CommentDao commentDao = new CommentDao();
    AuthorDao authorDao = new AuthorDao();

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
        Calendar createdAt = Calendar.getInstance();
        comment.setCreatedAt(createdAt);
        comment.setUpdatedAt(createdAt);
        commentDao.save(comment);
        Long authorId = commentDao.findOne(comment.getId()).getAuthor().getId();
        comment.setAuthor(authorDao.findOne(authorId));
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
