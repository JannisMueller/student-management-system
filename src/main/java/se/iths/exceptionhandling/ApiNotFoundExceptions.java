package se.iths.exceptionhandling;

import javax.ws.rs.WebApplicationException;
import java.io.Serializable;

public class ApiNotFoundExceptions extends WebApplicationException
        implements Serializable {

    private static final long serialVersionUID = 1L;
    public ApiNotFoundExceptions(String msg)   {
        super(msg);
    }

}
