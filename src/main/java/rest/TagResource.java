package rest;

import dao.TagDao;
import entities.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import utils.ResponseHandler;

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
    @Path("/find/{tagId}")
    public Response getAuthorById(@PathParam("tagId") Long tagId)  {
        Tag tag = tagDao.findOne(tagId);
        if(tag == null){
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response.ok().entity(tag).build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delete_tag")
    public void deleteTag(
            @Parameter Tag tag){
        tagDao.delete(tag);
    }

    @GET
    @Path("/all")
    public Response getTags(){
        return ResponseHandler.successResponse(tagDao.findAll());
    }
}
