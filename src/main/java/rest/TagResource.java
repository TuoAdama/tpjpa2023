package rest;

import dao.TagDao;
import entities.Tag;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/tag")
@Produces({"application/json"})
public class TagResource {

    TagDao tagDao = new TagDao();

    @POST
    @Consumes("application/json")
    @Path("/add")
    public Response addTag(
            @Parameter(description = "Tag object that needs to be added to the store", required = true) Tag tag) {
        Map<String, String> errors = new HashMap<>();
        if(tag.getLabel() == null || tag.getLabel().isEmpty()){
            errors.put("label", "label ne peut être vide");
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(errors)
                    .build();
        }
        tagDao.save(tag);
        return Response.ok().build();
    }

    @GET
    @Path("/{tagId}")
    public Tag getAuthorById(@PathParam("tagId") Long tagId)  {
        // return person
        return new Tag();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delete_tag")
    public void deleteTag(
            @Parameter Tag tag){
        tagDao.delete(tag);
    }
}
