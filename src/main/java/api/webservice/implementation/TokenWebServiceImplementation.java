package api.webservice.implementation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.request.ChangePasswordTokenBeanRequest;
import api.beans.request.DumpObjectRequest;
import api.beans.request.InitTokenBeanRequest;
import api.beans.request.InitUserPasswordTokenBeanRequest;
import api.beans.response.DumpTokenBeanResponse;
import api.beans.response.ListTokenBeanResponse;
import api.beans.response.RandomBeanResponse;
import api.beans.response.TokenInfoResponse;
import api.error.entity.ErrorEntity;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.Session;
import iaik.pkcs.pkcs11.SessionInfo;
import iaik.pkcs.pkcs11.Slot;
import iaik.pkcs.pkcs11.State;
import iaik.pkcs.pkcs11.Token;
import iaik.pkcs.pkcs11.Token.SessionReadWriteBehavior;
import iaik.pkcs.pkcs11.Token.SessionType;
import iaik.pkcs.pkcs11.TokenException;
import iaik.pkcs.pkcs11.objects.Attribute;
import iaik.pkcs.pkcs11.objects.ByteArrayAttribute;
import iaik.pkcs.pkcs11.objects.Object;
import iaik.pkcs.pkcs11.objects.X509AttributeCertificate;
import iaik.pkcs.pkcs11.objects.X509PublicKeyCertificate;

public class TokenWebServiceImplementation {

	private PrintWriter output_ = new PrintWriter(System.out, true);

	public TokenInfoResponse tokenInfos(HttpServletRequest req, int idToken, List<String> select) {

		TokenInfoResponse ti = new TokenInfoResponse();
		Token t = null;
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());

		try {

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
		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
		}
	}

	public Response init(HttpServletRequest req, InitTokenBeanRequest r, int idToken) {
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
		try {
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
		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
		}

		return Response.status(Status.NO_CONTENT).build();

	}

	public Response reset(HttpServletRequest req, InitTokenBeanRequest r, int idToken) {
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
		try {
			Slot[] slots;
			slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);
			if (idToken > slots.length)
				throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
						.entity(new ErrorEntity("You're trying to use an out of range ID for the token")).build());
			Token t = slots[idToken].getToken();
			if (!t.getTokenInfo().isTokenInitialized())
				throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
						.entity(new ErrorEntity("Your token is not initialized")).build());

			if (t.getTokenInfo().isProtectedAuthenticationPath()) {
				t.initToken(null, r.getLabel());
			} else {
				t.initToken(r.getPinSO().toCharArray(), r.getLabel());
			}

		} catch (TokenException ee) {
			if (ee.getMessage().equals("CKR_SESSION_EXISTS"))
				throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
						.entity(new ErrorEntity("You should not be logged")).build());
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
		}

		return Response.status(Status.NO_CONTENT).build();

	}

	@SuppressWarnings("unchecked")
	public Response changePassword(HttpServletRequest req, ChangePasswordTokenBeanRequest r, int idToken) {
		Session s;
		Token t;

		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
		Slot[] slots;
		try {
			slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);
			if (idToken > slots.length)
				throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
						.entity(new ErrorEntity("You're trying to use an out of range ID for the token")).build());
			t = slots[idToken].getToken();

			if (t.getTokenInfo().isLoginRequired()) {
				if (req.getSession().getAttribute("session") != null
						&& ((Map<Integer, Session>) req.getSession().getAttribute("session"))
								.get(Integer.valueOf(idToken)) != null) {
					s = ((Map<Integer, Session>) req.getSession().getAttribute("session"))
							.get(Integer.valueOf(idToken));
				} else
					throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
							.entity(new ErrorEntity("You must be logged into the token")).build());
			} else {
				s = t.openSession(SessionType.SERIAL_SESSION, SessionReadWriteBehavior.RW_SESSION, null, null);
			}
			try {
				if (t.getTokenInfo().isProtectedAuthenticationPath()) {
					s.setPIN(null, null);
				} else {
					s.setPIN(r.getOldPin().toCharArray(), r.getNewPin().toCharArray());
				}
				return Response.status(Status.NO_CONTENT).build();
			} catch (TokenException e) {
				if (e.getMessage().equals("CKR_PIN_INCORRECT"))
					throw new WebApplicationException(
							Response.status(Status.BAD_REQUEST).entity(new ErrorEntity("Wrong PIN")).build());
				else
					throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
							.entity(new ErrorEntity("Something went wrong while setting the new pin")).build());
			}

		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
		}
	}

	@SuppressWarnings("unchecked")
	public Response initUserPin(HttpServletRequest req, InitUserPasswordTokenBeanRequest r, int idToken) {
		Session s;
		Token t;

		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
		Slot[] slots;
		try {
			slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);
			if (idToken > slots.length)
				throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
						.entity(new ErrorEntity("You're trying to use an out of range ID for the token")).build());
			t = slots[idToken].getToken();

			if (t.getTokenInfo().isLoginRequired()) {
				if (req.getSession().getAttribute("session") != null
						&& ((Map<Integer, Session>) req.getSession().getAttribute("session"))
								.get(Integer.valueOf(idToken)) != null) {
					s = ((Map<Integer, Session>) req.getSession().getAttribute("session"))
							.get(Integer.valueOf(idToken));
					if (!s.getSessionInfo().getState().equals(State.RW_SO_FUNCTIONS))
						throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
								.entity(new ErrorEntity("You're not connected as SO in a RW session")).build());
				} else
					throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
							.entity(new ErrorEntity("You must be logged into the token")).build());
			} else {
				s = t.openSession(SessionType.SERIAL_SESSION, SessionReadWriteBehavior.RW_SESSION, null, null);
			}
			try {
				if (t.getTokenInfo().isProtectedAuthenticationPath()) {
					s.initPIN(null);
				} else {
					s.initPIN(r.getPin().toCharArray());
				}
				return Response.status(Status.NO_CONTENT).build();
			} catch (TokenException e) {
				throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
						.entity(new ErrorEntity("Something went wrong while setting the pin")).build());
			}

		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
		}
	}

	public RandomBeanResponse tokenGetRandom(HttpServletRequest req, int idToken, int nbByte) {
		Session s;
		Token t;

		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
		Slot[] slots;
		if (req.getSession().getAttribute("session") != null
				&& ((Map<Integer, Session>) req.getSession().getAttribute("session"))
						.get(Integer.valueOf(idToken)) != null) {
			s = ((Map<Integer, Session>) req.getSession().getAttribute("session")).get(Integer.valueOf(idToken));
		} else {
			try {
				slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);
				if (idToken > slots.length)
					throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
							.entity(new ErrorEntity("You're trying to use an out of range ID for the token")).build());
				t = slots[idToken].getToken();
				s = t.openSession(Token.SessionType.SERIAL_SESSION, Token.SessionReadWriteBehavior.RO_SESSION, null,
						null);

			} catch (TokenException e) {
				throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
			}
		}

		try {
			RandomBeanResponse r = new RandomBeanResponse();
			r.setBytesArray(s.generateRandom(nbByte));
			return r;
		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Problem while generating the random byte arrray")).build());
		}
	}

	@SuppressWarnings("unchecked")
	public DumpTokenBeanResponse tokenDumpObject(HttpServletRequest req, DumpObjectRequest r, int idToken) {
		Session session;
		Token t;

		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
		Slot[] slots;
		if (req.getSession().getAttribute("session") != null
				&& ((Map<Integer, Session>) req.getSession().getAttribute("session"))
						.get(Integer.valueOf(idToken)) != null) {
			session = ((Map<Integer, Session>) req.getSession().getAttribute("session")).get(Integer.valueOf(idToken));
		} else {
			try {
				slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);
				if (idToken > slots.length)
					throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
							.entity(new ErrorEntity("You're trying to use an out of range ID for the token")).build());
				t = slots[idToken].getToken();
				session = t.openSession(Token.SessionType.SERIAL_SESSION, Token.SessionReadWriteBehavior.RO_SESSION,
						null, null);

			} catch (TokenException e) {
				throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
			}
		}

		try {

			String outputDirectroyName = r.getPath();
			String pathSepatator = System.getProperty("file.separator");
			SessionInfo sessionInfo = session.getSessionInfo();
			output_.println(" using session:");
			output_.println(sessionInfo);

			session.findObjectsInit(null);
			Object[] objects = session.findObjects(1);

			while ((objects.length > 0) && (objects[0] != null)) {
				Object object = objects[0];
				long handle = object.getObjectHandle();
				String textDumpFilename = outputDirectroyName + pathSepatator + handle + ".txt";
				FileOutputStream textDumpStream = new FileOutputStream(textDumpFilename);
				textDumpStream.write(object.toString().getBytes("UTF-8"));
				textDumpStream.flush();
				textDumpStream.close();

				Hashtable attributes = object.getAttributeTable();
				if (attributes.containsKey(Attribute.VALUE)) {
					ByteArrayAttribute valueAttribute = (ByteArrayAttribute) attributes.get(Attribute.VALUE);
					byte[] value = valueAttribute.getByteArrayValue();
					if (value != null) {
						String valueDumpFilename = outputDirectroyName + pathSepatator + handle + ".value.bin";
						FileOutputStream valueDumpStream = new FileOutputStream(valueDumpFilename);
						valueDumpStream.write(value);
						valueDumpStream.flush();
						valueDumpStream.close();
						if ((object instanceof X509PublicKeyCertificate)
								|| (object instanceof X509AttributeCertificate)) {
							String certificateDumpFilename = outputDirectroyName + pathSepatator + handle + ".der.cer";
							FileOutputStream certificateDumpStream = new FileOutputStream(certificateDumpFilename);
							certificateDumpStream.write(value);
							certificateDumpStream.flush();
							certificateDumpStream.close();
						}
					}
				}
				objects = session.findObjects(1);
			}
			session.findObjectsFinal();
		} catch (TokenException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ListTokenBeanResponse listObject(HttpServletRequest req, int idToken) {
		Session session;
		ListTokenBeanResponse r = new ListTokenBeanResponse();
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
		if (req.getSession().getAttribute("session") != null
				&& ((Map<Integer, Session>) req.getSession().getAttribute("session"))
						.get(Integer.valueOf(idToken)) != null) {
			session = ((Map<Integer, Session>) req.getSession().getAttribute("session")).get(Integer.valueOf(idToken));
		} else {
			try {
				Slot[] slots;
				Token t;
				slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);
				if (idToken > slots.length)
					throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
							.entity(new ErrorEntity("You're trying to use an out of range ID for the token")).build());
				t = slots[idToken].getToken();
				session = t.openSession(Token.SessionType.SERIAL_SESSION, Token.SessionReadWriteBehavior.RO_SESSION,
						null, null);

			} catch (TokenException e) {
				throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
			}
		}

		try {
			session.findObjectsInit(null);
			Object[] objects = session.findObjects(1);
			Map<Long, String> objectHandleToObject = new Hashtable<Long, String>(10);

			while (objects.length > 0) {
				long objectHandle = objects[0].getObjectHandle();
				objectHandleToObject.put(new Long(objectHandle), objects[0].toString());
				objects = session.findObjects(1);
			}
			r.setHandleAndObject(objectHandleToObject);
			session.findObjectsFinal();
		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
					.entity(new ErrorEntity("Couldn't list the object on the token")).build());
		}

		return r;
	}

	public Response deleteObject(HttpServletRequest req, int idToken, long objectHandle) {
		Session session;
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("Module is not initialized")).build());
		if (req.getSession().getAttribute("session") != null
				&& ((Map<Integer, Session>) req.getSession().getAttribute("session"))
						.get(Integer.valueOf(idToken)) != null) {
			session = ((Map<Integer, Session>) req.getSession().getAttribute("session")).get(Integer.valueOf(idToken));
		} else {
			throw new WebApplicationException(
					Response.status(Status.UNAUTHORIZED).entity(new ErrorEntity("You're not logged")).build());
		}

		try {
			session.findObjectsInit(null);
			Object[] objects = session.findObjects(1);
			while (objects.length > 0) {
				if (objects[0].getObjectHandle() == objectHandle) {
					try {
						session.destroyObject(objects[0]);
					} catch (TokenException e) {
						throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
								.entity(new ErrorEntity("Couldn't remove the object")).build());
					}
					break;
				}
				objects = session.findObjects(1);
			}

			session.findObjectsFinal();
			return Response.status(Status.NO_CONTENT).build();
		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
					.entity(new ErrorEntity("Couldn't list the object on the token")).build());
		}
	}
}
