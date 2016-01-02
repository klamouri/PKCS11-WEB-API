package api.webservice.implementation;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.request.InitRequest;
import api.beans.request.Library;
import api.beans.response.TokenInfoResponse;
import api.error.entity.ErrorEntity;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.Session;
import iaik.pkcs.pkcs11.Slot;
import iaik.pkcs.pkcs11.Token;
import iaik.pkcs.pkcs11.Token.SessionReadWriteBehavior;
import iaik.pkcs.pkcs11.Token.SessionType;
import iaik.pkcs.pkcs11.TokenException;
import iaik.pkcs.pkcs11.TokenInfo;

@Path("token")
public class TokenWebServiceImplementation {
	private Logger logger = Logger.getLogger(this.getClass().toString());

	public TokenInfoResponse tokenInfos(Library l, @PathParam("idToken") int idToken,
			@QueryParam("select") List<String> select) {

		TokenInfoResponse ti = new TokenInfoResponse();
		Token t = null;

		try {
			Module m = Module.getInstance(l.getPath());
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
			if (select.size() == 0)
				throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
						.entity(new ErrorEntity("You didn't specified any select")).build());
			t = slots[idToken].getToken();
			if (select.contains("*")) {
				select.clear();
				select.add("minorFirmwareVersion");
				select.add("majorFirmwareVersion");
				select.add("freePrivateMemory");
				select.add("freePublicMemory");
				select.add("minorHardwareVersion");
				select.add("majorHardwareVersion");
				select.add("label");
				select.add("manufacturerID");
				select.add("maxPinLen");
				select.add("minPinLen");
				select.add("serialNumber");
				select.add("totalPrivateMemory");
				select.add("totalPublicMemory");
				select.add("isDualCryptoOperations");
				select.add("isLoginRequired");
				select.add("isProtectedAuthenticationPath");
				select.add("isRestoreKeyNotNeeded");
				select.add("isRNG");
				select.add("isSecondaryAuthentication");
				select.add("isSoPinCountLow");
				select.add("isSoPinFinalTry");
				select.add("isSoPinLocked");
				select.add("isSoPinToBeChanged");
				select.add("isTokenInitialized");
				select.add("isUserPinCountLow");
				select.add("isUserPinFinalTry");
				select.add("isUserPinInitialized");
				select.add("isUserPinLocked");
				select.add("isUserPinToBeChanged");
				select.add("isWriteProtected");
			}
			try {
				if (select.contains("minorFirmwareVersion"))
					ti.setMinorFirmwareVersion(t.getTokenInfo().getFirmwareVersion().getMinor());
				if (select.contains("majorFirmwareVersion"))
					ti.setMajorFirmwareVersion(t.getTokenInfo().getFirmwareVersion().getMajor());
				if (select.contains("freePrivateMemory"))
					ti.setFreePrivateMemory(t.getTokenInfo().getFreePrivateMemory());
				if (select.contains("freePublicMemory"))
					ti.setFreePublicMemory(t.getTokenInfo().getFreePublicMemory());
				if (select.contains("minorHardwareVersion"))
					ti.setMinorHardwareVersion(t.getTokenInfo().getHardwareVersion().getMinor());
				if (select.contains("majorHardwareVersion"))
					ti.setMajorHardwareVersion(t.getTokenInfo().getHardwareVersion().getMajor());
				if (select.contains("label"))
					ti.setLabel(t.getTokenInfo().getLabel());
				if (select.contains("manufacturerID"))
					ti.setManufacturerID(t.getTokenInfo().getManufacturerID());
				if (select.contains("maxPinLen"))
					ti.setMaxPinLen(t.getTokenInfo().getMaxPinLen());
				if (select.contains("minPinLen"))
					ti.setMinPinLen(t.getTokenInfo().getMinPinLen());
				if (select.contains("serialNumber"))
					ti.setSerialNumber(t.getTokenInfo().getSerialNumber());
				if (select.contains("totalPrivateMemory"))
					ti.setTotalPrivateMemory(t.getTokenInfo().getTotalPrivateMemory());
				if (select.contains("totalPublicMemory"))
					ti.setTotalPublicMemory(t.getTokenInfo().getTotalPublicMemory());
				if (select.contains("isDualCryptoOperations"))
					ti.setDualCryptoOperations(t.getTokenInfo().isDualCryptoOperations());
				if (select.contains("isLoginRequired"))
					ti.setLoginRequired(t.getTokenInfo().isLoginRequired());
				if (select.contains("isProtectedAuthenticationPath"))
					ti.setProtectedAuthenticationPath(t.getTokenInfo().isProtectedAuthenticationPath());
				if (select.contains("isRestoreKeyNotNeeded"))
					ti.setRestoreKeyNotNeeded(t.getTokenInfo().isRestoreKeyNotNeeded());
				if (select.contains("isRNG"))
					ti.setRNG(t.getTokenInfo().isRNG());
				if (select.contains("isSecondaryAuthentication"))
					ti.setSecondaryAuthentication(t.getTokenInfo().isSecondaryAuthentication());
				if (select.contains("isSoPinCountLow"))
					ti.setSoPinCountLow(t.getTokenInfo().isSoPinCountLow());
				if (select.contains("isSoPinFinalTry"))
					ti.setSoPinFinalTry(t.getTokenInfo().isSoPinFinalTry());
				if (select.contains("isSoPinLocked"))
					ti.setSoPinLocked(t.getTokenInfo().isSoPinLocked());
				if (select.contains("isSoPinToBeChanged"))
					ti.setSoPinToBeChanged(t.getTokenInfo().isSoPinToBeChanged());
				if (select.contains("isTokenInitialized"))
					ti.setTokenInitialized(t.getTokenInfo().isTokenInitialized());
				if (select.contains("isUserPinCountLow"))
					ti.setUserPinCountLow(t.getTokenInfo().isUserPinCountLow());
				if (select.contains("isUserPinFinalTry"))
					ti.setUserPinFinalTry(t.getTokenInfo().isUserPinFinalTry());
				if (select.contains("isUserPinInitialized"))
					ti.setUserPinInitialized(t.getTokenInfo().isUserPinInitialized());
				if (select.contains("isUserPinLocked"))
					ti.setUserPinLocked(t.getTokenInfo().isUserPinLocked());
				if (select.contains("isUserPinToBeChanged"))
					ti.setUserPinToBeChanged(t.getTokenInfo().isUserPinToBeChanged());
				if (select.contains("isWriteProtected"))
					ti.setWriteProtected(t.getTokenInfo().isWriteProtected());
				return ti;
			} catch (TokenException e) {
				throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(new ErrorEntity("Ooops- Error while filling the bean")).build());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TokenException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new ErrorEntity("Ooops - Something is very wrong")).build());
	}


	public Response init(InitRequest r, @PathParam("idToken") int idToken) {
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
			if (t.getTokenInfo().isTokenInitialized())
				throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
						.entity(new ErrorEntity("Your token is already initialized")).build());
			t.initToken(r.getPinSO().toCharArray(), r.getLabel());
		} catch (TokenException | IOException e1) {
			e1.printStackTrace();
		}
		
		return Response.status(Status.NO_CONTENT).build();

	}
	

	public Response reset(InitRequest r, @PathParam("idToken") int idToken) {
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
