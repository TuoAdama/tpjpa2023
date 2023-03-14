package utils;

import javax.ws.rs.core.Response;

public class ResponseHandler {
    public static Response successResponse(Object entity){  // unsubscribe function doesn't need to do anything in this

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
