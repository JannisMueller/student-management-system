package se.iths.exceptionHandling;

import javax.ejb.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Singleton
public class ApiNotFoundExceptionHandler implements ExceptionMapper<ApiNotFoundExceptions> {


    @Override
    public Response toResponse(ApiNotFoundExceptions apiExceptions) {
        return Response.status(
                        Response.Status.NOT_FOUND)
                .entity(new BasicResponse(apiExceptions.getResponse().toString(),apiExceptions.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
