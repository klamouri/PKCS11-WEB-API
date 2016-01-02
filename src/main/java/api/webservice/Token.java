package api.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import api.beans.request.InitRequest;
import api.beans.request.Library;
import api.beans.response.TokenInfoResponse;
import api.webservice.implementation.TokenWebServiceImplementation;

@Path("token")
public class Token {
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{idToken}/info")
	public TokenInfoResponse tokenInfos(Library l, @PathParam("idToken") int idToken,
			@QueryParam("select") List<String> select) {
		return new TokenWebServiceImplementation().tokenInfos(l, idToken, select);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{idToken}/init")
	public Response init(InitRequest r, @PathParam("idToken") int idToken) {
		return new TokenWebServiceImplementation().init(r, idToken);

	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{idToken}/reset")
	public Response reset(InitRequest r, @PathParam("idToken") int idToken) {
		return new TokenWebServiceImplementation().reset(r, idToken);

	}
}
