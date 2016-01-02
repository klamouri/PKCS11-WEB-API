package api.webservice;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.request.InitRequest;
import api.error.entity.ErrorEntity;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.Session;
import iaik.pkcs.pkcs11.Slot;
import iaik.pkcs.pkcs11.Token;
import iaik.pkcs.pkcs11.Token.SessionReadWriteBehavior;
import iaik.pkcs.pkcs11.Token.SessionType;
import iaik.pkcs.pkcs11.TokenException;
import iaik.pkcs.pkcs11.TokenInfo;

@Path("session")
public class SessionWebService {
	
	private Logger logger = Logger.getLogger(this.getClass().toString());
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{idToken}/reset")
	public Response login(InitRequest r, @PathParam("idToken") int idToken) {
		try {
			Module m = Module.getInstance(r.getPath());
			try {
				m.initialize(null);
			} catch (TokenException e) {
				logger.info("Exception durant le initialize :" + e);
			}
			Slot[] slots;
			slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);
			if (idToken > slots.length)
				throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
						.entity(new ErrorEntity("You're trying to use an out of range ID for the token")).build());
			Token t = slots[idToken].getToken();
			if (!t.getTokenInfo().isTokenInitialized())
				throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
						.entity(new ErrorEntity("Your token is not initialized")).build());
			TokenInfo tokenInfo = t.getTokenInfo();
			try{
				Session session = t.openSession(SessionType.SERIAL_SESSION, SessionReadWriteBehavior.RO_SESSION, null, null);
				if (tokenInfo.isLoginRequired()) {
				     // check, if the token has own means to authenticate the user; e.g. a PIN-pad on the reader
				     if (tokenInfo.isProtectedAuthenticationPath()) {
				       System.out.println("Please enter the user PIN at the PIN-pad of your reader.");
				       session.login(Session.UserType.SO, null); // the token prompts the PIN by other means; e.g. PIN-pad
				       session.closeSession();
				     } else {
				       session.login(Session.UserType.SO, r.getPinSO().toCharArray());
				       session.closeSession();
				     }
				   }
			} catch(TokenException e){
				throw new WebApplicationException(Response.status(Status.FORBIDDEN)
						.entity(new ErrorEntity("Wrong SO PIN")).build());
			}
			
			t.initToken(r.getPinSO().toCharArray(), r.getLabel());
		} catch (TokenException | IOException e1) {
		}
		
		return Response.status(Status.NO_CONTENT).build();

	}
}
