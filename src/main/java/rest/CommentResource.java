package rest;
import dao.CommentDao;
import entities.Comment;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public class CommentResource {

    CommentDao commentDao = new CommentDao();

    @GET
    @Path("/{commentId}")
    public Comment getCommentById(@PathParam("commentId") Long ticketId) {
        // return person
        return new Comment();
    }

    @POST
    @Consumes("application/json")
    @Path("/add_comment")
    public Response addComment(
            @Parameter(description = "Ticket object that needs to be added to the store", required = true) Comment comment) {
        commentDao.save(comment);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delete_comment")
    public void deleteComment( @Parameter Comment comment ){
        commentDao.delete(comment);
    }
}
