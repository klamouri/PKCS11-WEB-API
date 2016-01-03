package api.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import api.beans.request.LoginRequest;
import api.webservice.implementation.SessionWebServiceImplementation;

@Path("session")
public class SessionWebService {
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{idToken}/reset")
	public Response login(@Context HttpServletRequest req, LoginRequest r, @PathParam("idToken") int idToken) {
		return new SessionWebServiceImplementation().login(req, r, idToken);

	}
}
