package se.iths.rest;

import javax.ws.rs.WebApplicationException;
import java.io.Serializable;

public class ApiExceptions extends WebApplicationException implements Serializable {
    private static final long serialVersionUID = 1L;
    public ApiExceptions() {
        super();
    }
    public ApiExceptions(String msg)   {
        super(msg);
    }
    public ApiExceptions(String msg, Exception e)  {
        super(msg, e);
    }


}
