package api.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import api.beans.request.ModuleBeanRequest;
import api.webservice.implementation.ModuleWebServiceImplementation;

@Path("module")
public class ModuleWebService {
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response setModule(@Context HttpServletRequest req, ModuleBeanRequest m) {
		return new ModuleWebServiceImplementation().setModule(req, m);

	}
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	public Response unsetModule(@Context HttpServletRequest req) {
		return new ModuleWebServiceImplementation().unsetModule(req);

	}
}
