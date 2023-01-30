package rest;
import dao.AuthorDao;
import dao.TagDao;
import dao.TicketDao;

import entities.Author;
import entities.Tag;
import entities.Ticket;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
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
    TagDao tagDao = new TagDao();

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
        Author author = ticket.getAuthor();
        if(ticket.getTitle() == null || ticket.getTitle().isEmpty()){
            errors.put("title", "le titre ne doit pas être vide");
        }
        if(ticket.getContent() == null  || ticket.getContent().isEmpty()) {
            errors.put("content", "Le ticket doit avoir une description (content)");
        }

        if(author == null){
            errors.put("author", "l'auteur ne peut être null");
        }
        if (errors.size() != 0){
            return Response.status(Status.BAD_REQUEST)
                    .entity(errors)
                    .build();
        }
        ticket.setAuthor(author);
        ticket.setPublishedDate(LocalDateTime.now());
        ticketDao.save(ticket);
        return Response.ok()
                .entity(ticket)
                .build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delete/{id}")
    public Response deleteTicket( @PathParam("id") Long id ){
        Ticket ticket = ticketDao.findOne(id);
        if(ticket == null)
            return Response.status(Status.NOT_FOUND).build();

        return Response.ok().entity(ticket).build();
    }

    @POST
    @Consumes("application/json")
    @Path("/add/tag")
    public Response addTagToTicket(Map<String, Long> data){
        Map<String, String> errors = new HashMap();
        Ticket ticket = null;
        Tag tag = null;
        if(data.get("ticketId") == null){
            errors.put("ticketId","ticketId id ne peut être null");
        }
        if(data.get("tagId") == null){
            errors.put("tagId","tagId id ne peut être null");
        }
        if(errors.size() != 0){
            return Response.status(Status.BAD_REQUEST)
                    .entity(errors)
                    .build();
        }

        Long ticketId = data.get("ticketId");
        ticket = ticketDao.findOne(ticketId);
        if(ticket == null){
            errors.put("ticketId", "ticket id n'existe pase");
        }
        Long tagId = data.get("tagId");
        tag = tagDao.findOne(tagId);
        if(tag == null){
            errors.put("tagId", "tag id n'existe pas");
        }

        if(errors.size() != 0){
            return Response.status(Status.BAD_REQUEST)
                    .entity(errors)
                    .build();
        }

        ticket.getTags().add(tag);
        ticketDao.update(ticket);
        return Response.status(Status.OK)
                .entity(ticket)
                .build();
    }
}
