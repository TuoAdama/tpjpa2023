package fr.istic.taa.jaxrs.rest;
import fr.istic.taa.jaxrs.dao.implement.TagDao;
import fr.istic.taa.jaxrs.entities.*;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/author")
@Produces({"application/json"})
public class TagResource {

    TagDao tagDao = new TagDao();

    @GET
    @Path("/{tagId}")
    public Tag getAuthorById(@PathParam("tagId") Long tagId)  {
        // return person
        return new Tag();
    }

    @POST
    @Consumes("application/json")
    @Path("/add_tag")
    public Response addTag(
            @Parameter(description = "Tag object that needs to be added to the store", required = true) Tag tag) {
        tagDao.save(tag);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delete_tag")
    public void deleteTag(
            @Parameter Tag tag){
        tagDao.delete(tag);
    }
}
