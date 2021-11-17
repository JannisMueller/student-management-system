package se.iths.exceptionhandling;

import javax.ws.rs.WebApplicationException;
import java.io.Serializable;

public class ApiInternalServerErrorException extends WebApplicationException
        implements Serializable {

    private static final long serialVersionUID = 1L;
    public ApiInternalServerErrorException(String msg) {
        super(msg);
    }
}
