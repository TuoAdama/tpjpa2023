package rest;
import dao.TicketDao;

import entities.Ticket;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.Map;

@Path("/ticket")
@Produces({"application/json"})
public class TicketResource {

    TicketDao ticketDao = new TicketDao();

    @GET
    @Consumes("application/json")
    @Path("/{ticketId}")
    public Response getTicketById(@PathParam("ticketId") Long ticketId)  {
        Ticket ticket = ticketDao.findOne(ticketId);
        return Response.status(ticket != null ? Status.OK : Status.NOT_FOUND)
                .entity(ticket)
                .build();
    }

    @POST
    @Consumes("application/json")
    @Path("/add")
    public Response addTicket(
            @Parameter(description = "Ticket object that needs to be added to the store", required = true) Ticket ticket) {
        Map<String,Object> errors = new HashMap<>();
        if(ticket.getTitle().isEmpty()){
            errors.put("title", "le titre ne doit pas ếtre vide");
        }
        if(ticket.getContent().isEmpty()){
            errors.put("content", "Le ticket doit avoir une description (content)");
        }
        Map<String, String> authorErrors = AuthorResource.validAuthor(ticket.getAuthor());
        if(authorErrors.size() != 0){
            errors.put("author", authorErrors);
        }
        if (errors.size() != 0){
            return Response.status(Status.BAD_REQUEST)
                    .entity(errors)
                    .build();
        }
        return Response.ok().build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/{id}")
    public Response deleteTicket( @PathParam("id") Long id ){
        Ticket ticket = ticketDao.findOne(id);
        if(ticket == null)
            return Response.status(Status.NOT_FOUND).build();

        return Response.ok().entity(ticket).build();
    }
}
