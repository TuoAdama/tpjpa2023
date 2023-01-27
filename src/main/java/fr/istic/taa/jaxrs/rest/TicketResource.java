package fr.istic.taa.jaxrs.rest;
import fr.istic.taa.jaxrs.dao.implement.TicketDao;
import fr.istic.taa.jaxrs.entities.*;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public class TicketResource {

    TicketDao ticketDao = new TicketDao();

    @GET
    @Path("/{ticketId}")
    public Author getAuthorById(@PathParam("ticketId") Long ticketId)  {
        // return person
        return new Author();
    }

    @POST
    @Consumes("application/json")
    @Path("/add_ticket")
    public Response addAuthor(
            @Parameter(description = "Ticket object that needs to be added to the store", required = true) Ticket ticket) {
        ticketDao.save(ticket);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delete_ticket")
    public void deleteTicket( @Parameter Ticket ticket ){
        ticketDao.delete(ticket);
    }
}
