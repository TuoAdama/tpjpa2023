package rest;
import dao.AuthorDao;
import dao.TicketDao;

import dto.TicketCreateDTO;
import entities.Author;
import entities.Ticket;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Path("/ticket")
@Produces({"application/json"})
public class TicketResource {

    TicketDao ticketDao = new TicketDao();
    AuthorDao authorDao = new AuthorDao();

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
            @Parameter(description = "Ticket object that needs to be added to the store", required = true) TicketCreateDTO ticketDTO) {
        Map<String,Object> errors = new HashMap<>();
        Ticket ticket = ticketDTO.getTicket();
        Long authorId = ticketDTO.getAuthorId();
        Author author = null;
        if(ticket.getTitle() == null || ticket.getTitle().isEmpty()){
            errors.put("title", "le titre ne doit pas être vide");
        }
        if(ticket.getContent() == null  || ticket.getContent().isEmpty()) {
            errors.put("content", "Le ticket doit avoir une description (content)");
        }

        if(authorId == null){
            errors.put("author", "l'id de auteur ne peut être null");
        }else{
            author = authorDao.findOne(authorId);
            if(author == null){
                errors.put("author", "l'id de n'auteur n'existe pas");
            }
        }
        if (errors.size() != 0){
            return Response.status(Status.BAD_REQUEST)
                    .entity(errors)
                    .build();
        }
        ticket.setAuthor(author);
        ticket.setPublishedDate(LocalDateTime.now());
        ticketDao.save(ticket);
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
