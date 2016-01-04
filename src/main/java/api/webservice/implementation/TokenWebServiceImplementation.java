package api.webservice.implementation;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.request.ChangePasswordTokenBeanRequest;
import api.beans.request.InitTokenBeanRequest;
import api.beans.request.InitUserPasswordTokenBeanRequest;
import api.beans.response.TokenInfoResponse;
import api.beans.response.TokenMechanismsBeanResponse;
import api.error.entity.ErrorEntity;
import iaik.pkcs.pkcs11.Mechanism;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.Session;
import iaik.pkcs.pkcs11.Slot;
import iaik.pkcs.pkcs11.Token;
import iaik.pkcs.pkcs11.Token.SessionReadWriteBehavior;
import iaik.pkcs.pkcs11.Token.SessionType;
import iaik.pkcs.pkcs11.TokenException;
import iaik.pkcs.pkcs11.TokenInfo;
import iaik.pkcs.pkcs11.wrapper.PKCS11Constants;

public class TokenWebServiceImplementation {

	public TokenInfoResponse tokenInfos(HttpServletRequest req, int idToken, List<String> select) {

		TokenInfoResponse ti = new TokenInfoResponse();
		Token t = null;
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
					.entity(new ErrorEntity("Module is not initialized")).build());

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
			throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
					.entity(new ErrorEntity("Module is not initialized")).build());
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
			throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
					.entity(new ErrorEntity("Module is not initialized")).build());
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
			TokenInfo tokenInfo = t.getTokenInfo();
			try{
				Session session = t.openSession(SessionType.SERIAL_SESSION, SessionReadWriteBehavior.RW_SESSION, null, null);
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
		} catch (TokenException ee) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
		}
		
		return Response.status(Status.NO_CONTENT).build();

	}


	@SuppressWarnings("unchecked")
	public Response changePassword(HttpServletRequest req, ChangePasswordTokenBeanRequest r, int idToken) {
		Session s;
		Token t;
		if(req.getSession().getAttribute("session") != null && ((Map<Integer,Session>) req.getSession().getAttribute("session")).get(Integer.valueOf(idToken)) != null){
			s = ((Map<Integer,Session>) req.getSession().getAttribute("session")).get(Integer.valueOf(idToken));
			t = s.getToken();
		}
		else{
			Module m = (Module) req.getSession().getAttribute("module");
			if (m == null)
				throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
						.entity(new ErrorEntity("Module is not initialized")).build());
			Slot[] slots;
			try {
				slots = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);
				if (idToken > slots.length)
					throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
							.entity(new ErrorEntity("You're trying to use an out of range ID for the token")).build());
				t = slots[idToken].getToken();
				s = t.openSession(SessionType.SERIAL_SESSION, SessionReadWriteBehavior.RW_SESSION, null, null);
			} catch (TokenException e) {
				throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(new ErrorEntity("Ooops- Problem while retriving the slots")).build());
			}
			/*try {
				if (t.getTokenInfo().isLoginRequired()) {
				     // check, if the token has own means to authenticate the user; e.g. a PIN-pad on the reader
				     if (t.getTokenInfo().isProtectedAuthenticationPath()) {
				       System.out.println("Please enter the user PIN at the PIN-pad of your reader.");
				       s.login(Session.UserType.SO, null); // the token prompts the PIN by other means; e.g. PIN-pad;
				     } else {
				       s.login(Session.UserType.SO, r.getOldPin().toCharArray());
				     }
				   }
				if (t.getTokenInfo().isProtectedAuthenticationPath()){
					
				}
				else{
					s.setPIN(r.getOldPin().toCharArray(), r.getNewPin().toCharArray());
				}
			} catch (TokenException e) {
				throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
						.entity(new ErrorEntity("Ooops- Problem while Setting the new PIN")).build());
			}*/
		}
		return null;
	}


	public Response initUserPin(HttpServletRequest req, InitUserPasswordTokenBeanRequest r, int idToken) {
		// TODO Auto-generated method stub
		return null;
	}

	public TokenMechanismsBeanResponse tokenMechanisms(HttpServletRequest req, int idToken) {
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
					.entity(new ErrorEntity("Module is not initialized")).build());
		try {
			Slot[] slotList = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);
			Token tok = slotList[idToken].getToken();
			Mechanism[] mechList = tok.getMechanismList();
			TokenMechanismsBeanResponse b = new TokenMechanismsBeanResponse();
			for(Mechanism mech : mechList){
				if(mech.getName().equals(PKCS11Constants.CKM_AES_CBC)){
				    b.setAES_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_AES_CBC_ENCRYPT_DATA)){
				    b.setAES_CBC_ENCRYPT_DATA(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_AES_CBC_PAD)){
				    b.setAES_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_AES_ECB)){
				    b.setAES_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_AES_ECB_ENCRYPT_DATA)){
				    b.setAES_ECB_ENCRYPT_DATA(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_AES_KEY_GEN)){
				    b.setAES_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_AES_MAC)){
				    b.setAES_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_AES_MAC_GENERAL)){
				    b.setAES_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_BATON_CBC128)){
				    b.setBATON_CBC128(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_BATON_COUNTER)){
				    b.setBATON_COUNTER(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_BATON_ECB128)){
				    b.setBATON_ECB128(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_BATON_ECB96)){
				    b.setBATON_ECB96(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_BATON_KEY_GEN)){
				    b.setBATON_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_BATON_SHUFFLE)){
				    b.setBATON_SHUFFLE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_BATON_WRAP)){
				    b.setBATON_WRAP(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_BLOWFISH_CBC)){
				    b.setBLOWFISH_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_BLOWFISH_KEY_GEN)){
				    b.setBLOWFISH_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST_CBC)){
				    b.setCAST_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST_CBC_PAD)){
				    b.setCAST_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST_ECB)){
				    b.setCAST_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST_KEY_GEN)){
				    b.setCAST_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST_MAC)){
				    b.setCAST_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST_MAC_GENERAL)){
				    b.setCAST_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST128_CBC)){
				    b.setCAST128_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST128_CBC_PAD)){
				    b.setCAST128_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST128_ECB)){
				    b.setCAST128_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST128_KEY_GEN)){
				    b.setCAST128_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST128_MAC)){
				    b.setCAST128_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST128_MAC_GENERAL)){
				    b.setCAST128_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST3_CBC)){
				    b.setCAST3_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST3_CBC_PAD)){
				    b.setCAST3_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST3_ECB)){
				    b.setCAST3_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST3_KEY_GEN)){
				    b.setCAST3_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST3_MAC)){
				    b.setCAST3_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST3_MAC_GENERAL)){
				    b.setCAST3_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST5_CBC)){
				    b.setCAST5_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST5_CBC_PAD)){
				    b.setCAST5_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST5_ECB)){
				    b.setCAST5_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST5_KEY_GEN)){
				    b.setCAST5_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST5_MAC)){
				    b.setCAST5_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CAST5_MAC_GENERAL)){
				    b.setCAST5_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CDMF_CBC)){
				    b.setCDMF_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CDMF_CBC_PAD)){
				    b.setCDMF_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CDMF_ECB)){
				    b.setCDMF_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CDMF_KEY_GEN)){
				    b.setCDMF_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CDMF_MAC)){
				    b.setCDMF_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CDMF_MAC_GENERAL)){
				    b.setCDMF_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CONCATENATE_BASE_AND_DATA)){
				    b.setCONCATENATE_BASE_AND_DATA(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CONCATENATE_BASE_AND_KEY)){
				    b.setCONCATENATE_BASE_AND_KEY(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_CONCATENATE_DATA_AND_BASE)){
				    b.setCONCATENATE_DATA_AND_BASE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_CBC)){
				    b.setDES_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_CBC_ENCRYPT_DATA)){
				    b.setDES_CBC_ENCRYPT_DATA(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_CBC_PAD)){
				    b.setDES_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_CFB64)){
				    b.setDES_CFB64(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_CFB8)){
				    b.setDES_CFB8(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_ECB)){
				    b.setDES_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_ECB_ENCRYPT_DATA)){
				    b.setDES_ECB_ENCRYPT_DATA(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_KEY_GEN)){
				    b.setDES_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_MAC)){
				    b.setDES_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_MAC_GENERAL)){
				    b.setDES_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_OFB64)){
				    b.setDES_OFB64(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES_OFB8)){
				    b.setDES_OFB8(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES2_KEY_GEN)){
				    b.setDES2_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES3_CBC)){
				    b.setDES3_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES3_CBC_ENCRYPT_DATA)){
				    b.setDES3_CBC_ENCRYPT_DATA(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES3_CBC_PAD)){
				    b.setDES3_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES3_ECB)){
				    b.setDES3_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES3_ECB_ENCRYPT_DATA)){
				    b.setDES3_ECB_ENCRYPT_DATA(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES3_KEY_GEN)){
				    b.setDES3_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES3_MAC)){
				    b.setDES3_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DES3_MAC_GENERAL)){
				    b.setDES3_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DH_PKCS_DERIVE)){
				    b.setDH_PKCS_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DH_PKCS_KEY_PAIR_GEN)){
				    b.setDH_PKCS_KEY_PAIR_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DH_PKCS_PARAMETER_GEN)){
				    b.setDH_PKCS_PARAMETER_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DSA)){
				    b.setDSA(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DSA_KEY_PAIR_GEN)){
				    b.setDSA_KEY_PAIR_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DSA_PARAMETER_GEN)){
				    b.setDSA_PARAMETER_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_DSA_SHA1)){
				    b.setDSA_SHA1(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_EC_KEY_PAIR_GEN)){
				    b.setEC_KEY_PAIR_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_ECDH1_COFACTOR_DERIVE)){
				    b.setECDH1_COFACTOR_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_ECDH1_DERIVE)){
				    b.setECDH1_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_ECDSA)){
				    b.setECDSA(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_ECDSA_KEY_PAIR_GEN)){
				    b.setECDSA_KEY_PAIR_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_ECDSA_SHA1)){
				    b.setECDSA_SHA1(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_ECMQV_DERIVE)){
				    b.setECMQV_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_EXTRACT_KEY_FROM_KEY)){
				    b.setEXTRACT_KEY_FROM_KEY(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_FASTHASH)){
				    b.setFASTHASH(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_FORTEZZA_TIMESTAMP)){
				    b.setFORTEZZA_TIMESTAMP(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_GENERIC_SECRET_KEY_GEN)){
				    b.setGENERIC_SECRET_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_IDEA_CBC)){
				    b.setIDEA_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_IDEA_CBC_PAD)){
				    b.setIDEA_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_IDEA_ECB)){
				    b.setIDEA_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_IDEA_KEY_GEN)){
				    b.setIDEA_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_IDEA_MAC)){
				    b.setIDEA_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_IDEA_MAC_GENERAL)){
				    b.setIDEA_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_JUNIPER_CBC128)){
				    b.setJUNIPER_CBC128(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_JUNIPER_COUNTER)){
				    b.setJUNIPER_COUNTER(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_JUNIPER_ECB128)){
				    b.setJUNIPER_ECB128(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_JUNIPER_KEY_GEN)){
				    b.setJUNIPER_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_JUNIPER_SHUFFLE)){
				    b.setJUNIPER_SHUFFLE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_JUNIPER_WRAP)){
				    b.setJUNIPER_WRAP(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_KEA_KEY_DERIVE)){
				    b.setKEA_KEY_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_KEA_KEY_PAIR_GEN)){
				    b.setKEA_KEY_PAIR_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_KEY_WRAP_LYNKS)){
				    b.setKEY_WRAP_LYNKS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_KEY_WRAP_SET_OAEP)){
				    b.setKEY_WRAP_SET_OAEP(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_MD2)){
				    b.setMD2(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_MD2_HMAC)){
				    b.setMD2_HMAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_MD2_HMAC_GENERAL)){
				    b.setMD2_HMAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_MD2_KEY_DERIVATION)){
				    b.setMD2_KEY_DERIVATION(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_MD2_RSA_PKCS)){
				    b.setMD2_RSA_PKCS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_MD5)){
				    b.setMD5(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_MD5_HMAC)){
				    b.setMD5_HMAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_MD5_HMAC_GENERAL)){
				    b.setMD5_HMAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_MD5_KEY_DERIVATION)){
				    b.setMD5_KEY_DERIVATION(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_MD5_RSA_PKCS)){
				    b.setMD5_RSA_PKCS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBA_SHA1_WITH_SHA1_HMAC)){
				    b.setPBA_SHA1_WITH_SHA1_HMAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_MD2_DES_CBC)){
				    b.setPBE_MD2_DES_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_MD5_CAST_CBC)){
				    b.setPBE_MD5_CAST_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_MD5_CAST128_CBC)){
				    b.setPBE_MD5_CAST128_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_MD5_CAST3_CBC)){
				    b.setPBE_MD5_CAST3_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_MD5_CAST5_CBC)){
				    b.setPBE_MD5_CAST5_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_MD5_DES_CBC)){
				    b.setPBE_MD5_DES_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_SHA1_CAST128_CBC)){
				    b.setPBE_SHA1_CAST128_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_SHA1_CAST5_CBC)){
				    b.setPBE_SHA1_CAST5_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_SHA1_DES2_EDE_CBC)){
				    b.setPBE_SHA1_DES2_EDE_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_SHA1_DES3_EDE_CBC)){
				    b.setPBE_SHA1_DES3_EDE_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_SHA1_RC2_128_CBC)){
				    b.setPBE_SHA1_RC2_128_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_SHA1_RC2_40_CBC)){
				    b.setPBE_SHA1_RC2_40_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_SHA1_RC4_128)){
				    b.setPBE_SHA1_RC4_128(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PBE_SHA1_RC4_40)){
				    b.setPBE_SHA1_RC4_40(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_PKCS5_PBKD2)){
				    b.setPKCS5_PBKD2(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC2_CBC)){
				    b.setRC2_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC2_CBC_PAD)){
				    b.setRC2_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC2_ECB)){
				    b.setRC2_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC2_KEY_GEN)){
				    b.setRC2_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC2_MAC)){
				    b.setRC2_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC2_MAC_GENERAL)){
				    b.setRC2_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC4)){
				    b.setRC4(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC4_KEY_GEN)){
				    b.setRC4_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC5_CBC)){
				    b.setRC5_CBC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC5_CBC_PAD)){
				    b.setRC5_CBC_PAD(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC5_ECB)){
				    b.setRC5_ECB(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC5_KEY_GEN)){
				    b.setRC5_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC5_MAC)){
				    b.setRC5_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RC5_MAC_GENERAL)){
				    b.setRC5_MAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RIPEMD128)){
				    b.setRIPEMD128(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RIPEMD128_HMAC)){
				    b.setRIPEMD128_HMAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RIPEMD128_HMAC_GENERAL)){
				    b.setRIPEMD128_HMAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RIPEMD128_RSA_PKCS)){
				    b.setRIPEMD128_RSA_PKCS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RIPEMD160)){
				    b.setRIPEMD160(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RIPEMD160_HMAC)){
				    b.setRIPEMD160_HMAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RIPEMD160_HMAC_GENERAL)){
				    b.setRIPEMD160_HMAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RIPEMD160_RSA_PKCS)){
				    b.setRIPEMD160_RSA_PKCS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RSA_9796)){
				    b.setRSA_9796(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RSA_PKCS)){
				    b.setRSA_PKCS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RSA_PKCS_KEY_PAIR_GEN)){
				    b.setRSA_PKCS_KEY_PAIR_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RSA_PKCS_OAEP)){
				    b.setRSA_PKCS_OAEP(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RSA_PKCS_PSS)){
				    b.setRSA_PKCS_PSS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RSA_X_509)){
				    b.setRSA_X_509(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RSA_X9_31)){
				    b.setRSA_X9_31(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_RSA_X9_31_KEY_PAIR_GEN)){
				    b.setRSA_X9_31_KEY_PAIR_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA_1)){
				    b.setSHA_1(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA_1_HMAC)){
				    b.setSHA_1_HMAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA_1_HMAC_GENERAL)){
				    b.setSHA_1_HMAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA1_KEY_DERIVATION)){
				    b.setSHA1_KEY_DERIVATION(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA1_RSA_PKCS)){
				    b.setSHA1_RSA_PKCS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA1_RSA_PKCS_PSS)){
				    b.setSHA1_RSA_PKCS_PSS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA1_RSA_X9_31)){
				    b.setSHA1_RSA_X9_31(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA256)){
				    b.setSHA256(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA256_HMAC)){
				    b.setSHA256_HMAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA256_HMAC_GENERAL)){
				    b.setSHA256_HMAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA256_KEY_DERIVATION)){
				    b.setSHA256_KEY_DERIVATION(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA256_RSA_PKCS)){
				    b.setSHA256_RSA_PKCS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA256_RSA_PKCS_PSS)){
				    b.setSHA256_RSA_PKCS_PSS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA384)){
				    b.setSHA384(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA384_HMAC)){
				    b.setSHA384_HMAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA384_HMAC_GENERAL)){
				    b.setSHA384_HMAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA384_KEY_DERIVATION)){
				    b.setSHA384_KEY_DERIVATION(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA384_RSA_PKCS)){
				    b.setSHA384_RSA_PKCS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA384_RSA_PKCS_PSS)){
				    b.setSHA384_RSA_PKCS_PSS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA512)){
				    b.setSHA512(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA512_HMAC)){
				    b.setSHA512_HMAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA512_HMAC_GENERAL)){
				    b.setSHA512_HMAC_GENERAL(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA512_KEY_DERIVATION)){
				    b.setSHA512_KEY_DERIVATION(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA512_RSA_PKCS)){
				    b.setSHA512_RSA_PKCS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SHA512_RSA_PKCS_PSS)){
				    b.setSHA512_RSA_PKCS_PSS(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_CBC64)){
				    b.setSKIPJACK_CBC64(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_CFB16)){
				    b.setSKIPJACK_CFB16(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_CFB32)){
				    b.setSKIPJACK_CFB32(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_CFB64)){
				    b.setSKIPJACK_CFB64(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_CFB8)){
				    b.setSKIPJACK_CFB8(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_ECB64)){
				    b.setSKIPJACK_ECB64(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_KEY_GEN)){
				    b.setSKIPJACK_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_OFB64)){
				    b.setSKIPJACK_OFB64(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_PRIVATE_WRAP)){
				    b.setSKIPJACK_PRIVATE_WRAP(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_RELAYX)){
				    b.setSKIPJACK_RELAYX(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SKIPJACK_WRAP)){
				    b.setSKIPJACK_WRAP(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SSL3_KEY_AND_MAC_DERIVE)){
				    b.setSSL3_KEY_AND_MAC_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SSL3_MASTER_KEY_DERIVE)){
				    b.setSSL3_MASTER_KEY_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SSL3_MASTER_KEY_DERIVE_DH)){
				    b.setSSL3_MASTER_KEY_DERIVE_DH(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SSL3_MD5_MAC)){
				    b.setSSL3_MD5_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SSL3_PRE_MASTER_KEY_GEN)){
				    b.setSSL3_PRE_MASTER_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_SSL3_SHA1_MAC)){
				    b.setSSL3_SHA1_MAC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_TLS_KEY_AND_MAC_DERIVE)){
				    b.setTLS_KEY_AND_MAC_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_TLS_MASTER_KEY_DERIVE)){
				    b.setTLS_MASTER_KEY_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_TLS_MASTER_KEY_DERIVE_DH)){
				    b.setTLS_MASTER_KEY_DERIVE_DH(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_TLS_PRE_MASTER_KEY_GEN)){
				    b.setTLS_PRE_MASTER_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_TLS_PRF)){
				    b.setTLS_PRF(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_VENDOR_DEFINED)){
				    b.setVENDOR_DEFINED(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_WTLS_CLIENT_KEY_AND_MAC_DERIVE)){
				    b.setWTLS_CLIENT_KEY_AND_MAC_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_WTLS_MASTER_KEY_DERIVE)){
				    b.setWTLS_MASTER_KEY_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_WTLS_MASTER_KEY_DERIVE_DH_ECC)){
				    b.setWTLS_MASTER_KEY_DERIVE_DH_ECC(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_WTLS_PRE_MASTER_KEY_GEN)){
				    b.setWTLS_PRE_MASTER_KEY_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_WTLS_PRF)){
				    b.setWTLS_PRF(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_WTLS_SERVER_KEY_AND_MAC_DERIVE)){
				    b.setWTLS_SERVER_KEY_AND_MAC_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_X9_42_DH_DERIVE)){
				    b.setX9_42_DH_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_X9_42_DH_HYBRID_DERIVE)){
				    b.setX9_42_DH_HYBRID_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_X9_42_DH_KEY_PAIR_GEN)){
				    b.setX9_42_DH_KEY_PAIR_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_X9_42_DH_PARAMETER_GEN)){
				    b.setX9_42_DH_PARAMETER_GEN(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_X9_42_MQV_DERIVE)){
				    b.setX9_42_MQV_DERIVE(true);
				}
				if(mech.getName().equals(PKCS11Constants.CKM_XOR_BASE_AND_DATA)){
				    b.setXOR_BASE_AND_DATA(true);
				}
			}
			return b;
		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Unable to retrieve slot list")).build());
		}
	}
}
