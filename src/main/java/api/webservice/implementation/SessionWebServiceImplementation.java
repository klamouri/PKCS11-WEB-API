package api.webservice.implementation;

import java.util.HashMap;
import java.util.Map;
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
	
	@SuppressWarnings("unchecked")
	public static Session getLocalSession(HttpServletRequest req, int idToken) {
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
					.entity(new ErrorEntity("Module is not initialized")).build());
		try {
			Slot[] slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);

			if (idToken > slots.length)
				throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
						.entity(new ErrorEntity("You're trying to use an out of range ID for the slot")).build());
			Slot s = slots[idToken];
			Token t = s.getToken();
			TokenInfo tInfo = t.getTokenInfo();
			Session sess;
			if(tInfo.isLoginRequired()){
				// Recup session log
				Map<Integer, Session> map = (Map<Integer, Session>) req.getSession().getAttribute("session");
				if (map != null && map.get(Integer.valueOf(idToken)) != null)
					sess = map.get(Integer.valueOf(idToken));
				else
					throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
							.entity(new ErrorEntity("You need to be logged into the token to continue")).build());
			}
			else{
				//Recup session non log
				sess = t.openSession(Token.SessionType.SERIAL_SESSION, Token.SessionReadWriteBehavior.RW_SESSION, null, null);
			}
			return sess;
		} catch (TokenException e) {
			e.printStackTrace();
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Ooops- Problem while retriving the session")).build());
		}
	}

	public Response login(HttpServletRequest req, LoginRequest r, int idToken) {
		try {
			Module m = (Module) req.getSession().getAttribute("module");
			if (m == null)
				throw new WebApplicationException(
						Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
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
				Map<Integer, Session> mapSession = new HashMap<>();
				mapSession.put(Integer.valueOf(idToken), session);
				req.getSession().setAttribute("session", mapSession);
			} catch (TokenException e) {
				if(e.getMessage().equals("CKR_PIN_INCORRECT"))
					throw new WebApplicationException(
						Response.status(Status.FORBIDDEN).entity(new ErrorEntity("Wrong PIN")).build());
				else
					throw new WebApplicationException(
							Response.status(Status.FORBIDDEN).entity(new ErrorEntity(e.getMessage())).build());
			}

		} catch (TokenException e) {
			
		}

		return Response.status(Status.NO_CONTENT).build();

	}

	public Response testLogin(HttpServletRequest req, int idToken) {
		@SuppressWarnings("unchecked")
		Map<Integer, Session> map = (Map<Integer, Session>) req.getSession().getAttribute("session");
		if (map != null && map.get(Integer.valueOf(idToken)) != null)
			return Response.status(Status.NO_CONTENT).build();
		else
			return Response.status(Status.UNAUTHORIZED).build();
	}

	public Response logout(HttpServletRequest req, int idToken) {
		@SuppressWarnings("unchecked")
		Map<Integer, Session> map = (Map<Integer, Session>) req.getSession().getAttribute("session");
		if (map !=null && map.get(Integer.valueOf(idToken)) != null){
			Session s = map.get(Integer.valueOf(idToken));
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
