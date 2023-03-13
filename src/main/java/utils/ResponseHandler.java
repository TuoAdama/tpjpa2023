package utils;

import javax.ws.rs.core.Response;

public class ResponseHandler {
    public static Response successResponse(Object entity){
        return Response
                .ok()
                .entity(entity)
                .build();
    }

    public static Response notFoundResponse(){
        return Response.status(Response.Status.NOT_FOUND)
                .build();
    }
}
