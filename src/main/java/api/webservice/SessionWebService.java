package api.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{idToken}")
	public Response login(@Context HttpServletRequest req, LoginRequest r, @PathParam("idToken") int idToken) {
		return new SessionWebServiceImplementation().login(req, r, idToken);

	}
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{idToken}")
	public Response testLogin(@Context HttpServletRequest req, @PathParam("idToken") int idToken) {
		return new SessionWebServiceImplementation().testLogin(req, idToken);

	}
	
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{idToken}")
	public Response logout(@Context HttpServletRequest req, @PathParam("idToken") int idToken) {
		return new SessionWebServiceImplementation().logout(req, idToken);

	}
	
}
