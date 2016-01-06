package api.webservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import api.beans.request.ChangePasswordTokenBeanRequest;
import api.beans.request.DumpObjectRequest;
import api.beans.request.InitTokenBeanRequest;
import api.beans.request.InitUserPasswordTokenBeanRequest;
import api.beans.response.KeyPairBeanResponse;
import api.beans.response.RandomBeanResponse;
import api.beans.response.SecretKeyBeanResponse;
import api.beans.response.TokenInfoResponse;
import api.beans.response.TokenMechanismsBeanResponse;
import api.beans.response.DumpTokenBeanResponse;
import api.beans.response.ListTokenBeanResponse;

import api.webservice.implementation.TokenMechanismWebServiceImplementation;
import api.webservice.implementation.TokenWebServiceImplementation;

@Path("token")
public class TokenWebService {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("info/{idToken}")
	public TokenInfoResponse tokenInfos(@Context HttpServletRequest req, @PathParam("idToken") int idToken,
			@QueryParam("select") List<String> select) {
		return new TokenWebServiceImplementation().tokenInfos(req, idToken, select);
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("init/{idToken}")
	public Response init(@Context HttpServletRequest req, InitTokenBeanRequest r, @PathParam("idToken") int idToken) {
		return new TokenWebServiceImplementation().init(req, r, idToken);

	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("reset/{idToken}")
	public Response reset(@Context HttpServletRequest req, InitTokenBeanRequest r, @PathParam("idToken") int idToken) {
		return new TokenWebServiceImplementation().reset(req, r, idToken);

	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("changePW/{idToken}")
	public Response changePassword(@Context HttpServletRequest req, ChangePasswordTokenBeanRequest r, @PathParam("idToken") int idToken) {
		return new TokenWebServiceImplementation().changePassword(req, r, idToken);

	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("initUserPin/{idToken}")
	public Response initUserPin(@Context HttpServletRequest req, InitUserPasswordTokenBeanRequest r, @PathParam("idToken") int idToken) {
		return new TokenWebServiceImplementation().initUserPin(req, r, idToken);
	
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("mechanisms/{idToken}")
	public TokenMechanismsBeanResponse tokenMechanisms(@Context HttpServletRequest req, @PathParam("idToken") int idToken,
			@QueryParam("select") List<String> select) {
		return new TokenMechanismWebServiceImplementation().tokenMechanisms(req, idToken, select);

	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })	
	@Path("SecretKey/{idToken}")
	public SecretKeyBeanResponse genSecretKey(@Context HttpServletRequest req, @PathParam("idToken") int idToken) {
		return new TokenMechanismWebServiceImplementation().genSecretKey(req, idToken);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })	
	@Path("KeyPair/{idToken}")
	public KeyPairBeanResponse genKeyPair(@Context HttpServletRequest req, @PathParam("idToken") int idToken) {
		return new TokenMechanismWebServiceImplementation().genKeyPair(req, idToken);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("random/{idToken}/{nbByte}")
	public RandomBeanResponse tokenGetRandom(@Context HttpServletRequest req, @PathParam("idToken") int idToken, @PathParam("nbByte") int nbByte) {
		return new TokenWebServiceImplementation().tokenGetRandom(req, idToken, nbByte);
	}
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("object/{idToken}/")
	public ListTokenBeanResponse listObject(@Context HttpServletRequest req, @PathParam("idToken") int idToken) {
		return new TokenWebServiceImplementation().listObject(req, idToken);

	}
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("object/dump/{idToken}/")
	public DumpTokenBeanResponse tokenDumpObject(@Context HttpServletRequest req, DumpObjectRequest rb, @PathParam("idToken") int idToken) {
		return new TokenWebServiceImplementation().tokenDumpObject(req, rb, idToken);

	}
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("object/{idToken}/{handleObject}")
	public Response tokenDumpObject(@Context HttpServletRequest req, @PathParam("idToken") int idToken, @PathParam("handleObject") int handleObject) {
		return new TokenWebServiceImplementation().deleteObject(req, idToken, handleObject);

	}
}
