package api.webservice.implementation;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.request.LoginRequest;
import api.error.entity.ErrorEntity;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.Session;
import iaik.pkcs.pkcs11.Slot;
import iaik.pkcs.pkcs11.Token;
import iaik.pkcs.pkcs11.Token.SessionReadWriteBehavior;
import iaik.pkcs.pkcs11.Token.SessionType;
import iaik.pkcs.pkcs11.TokenException;
import iaik.pkcs.pkcs11.TokenInfo;

public class SessionWebServiceImplementation {

	private Logger logger = Logger.getLogger(this.getClass().toString());

	public Response login(HttpServletRequest req, LoginRequest r, int idToken) {
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
			try {
				t.closeAllSessions();
				Session session = t.openSession(SessionType.SERIAL_SESSION, SessionReadWriteBehavior.RW_SESSION, null,
						null);
				if (tokenInfo.isLoginRequired()) {
					// check, if the token has own means to authenticate the
					// user; e.g. a PIN-pad on the reader
					boolean userType;
					if (r.getUserType().equalsIgnoreCase("user"))
						userType = Session.UserType.USER;
					else if (r.getUserType().equalsIgnoreCase("so"))
						userType = Session.UserType.SO;
					else
						throw new WebApplicationException(
								Response.status(Status.BAD_REQUEST).entity(new ErrorEntity("Bad user type")).build());
					if (tokenInfo.isProtectedAuthenticationPath()) {
						System.out.println("Please enter the user PIN at the PIN-pad of your reader.");
						// the token prompts the PIN by other means; e.g.
						// PIN-pad
						session.login(userType, null);
					} else {
						session.login(userType, r.getPin().toCharArray());
					}
				}
				req.getSession().setAttribute("session", session);
			} catch (TokenException e) {
				throw new WebApplicationException(
						Response.status(Status.FORBIDDEN).entity(new ErrorEntity("Wrong SO PIN")).build());
			}

		} catch (TokenException | IOException e1) {
		}

		return Response.status(Status.NO_CONTENT).build();

	}

	public Response testLogin(HttpServletRequest req, LoginRequest r, int idToken) {
		if (req.getSession().getAttribute("session") != null)
			return Response.status(Status.NO_CONTENT).build();
		else
			return Response.status(Status.UNAUTHORIZED).build();
	}

	public Response logout(HttpServletRequest req, LoginRequest r, int idToken) {
		if (req.getSession().getAttribute("session") != null){
			Session s = (Session) req.getSession().getAttribute("session");
			try {
				s.getToken().closeAllSessions();
			} catch (TokenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getSession().removeAttribute("session");
			return Response.status(Status.NO_CONTENT).build();
		}
			
		else
			return Response.status(Status.UNAUTHORIZED).build();
	}
}
