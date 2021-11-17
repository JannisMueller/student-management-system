package se.iths.rest;

import javax.ejb.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Singleton
public class ApiInternalServerErrorExceptionHandler implements ExceptionMapper<ApiInternalServerErrorException> {
    @Override
    public Response toResponse(ApiInternalServerErrorException e) {
        return Response.status(
                Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new BasicResponse(e.getResponse().toString(), e.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
