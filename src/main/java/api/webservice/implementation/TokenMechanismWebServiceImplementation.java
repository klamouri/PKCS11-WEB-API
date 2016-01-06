package api.webservice.implementation;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.response.KeyPairBeanResponse;
import api.beans.response.SecretKeyBeanResponse;
import api.beans.response.TokenMechanismsBeanResponse;
import api.error.entity.ErrorEntity;
import iaik.pkcs.pkcs11.Mechanism;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.Session;
import iaik.pkcs.pkcs11.Slot;
import iaik.pkcs.pkcs11.Token;
import iaik.pkcs.pkcs11.TokenException;
import iaik.pkcs.pkcs11.TokenInfo;
import iaik.pkcs.pkcs11.objects.AESSecretKey;
import iaik.pkcs.pkcs11.objects.SecretKey;
import iaik.pkcs.pkcs11.wrapper.PKCS11Constants;

public class TokenMechanismWebServiceImplementation {
	public TokenMechanismsBeanResponse tokenMechanisms(HttpServletRequest req, int idToken, List<String> select) {
		Module m = (Module) req.getSession().getAttribute("module");
		if (m == null)
			throw new WebApplicationException(Response.status(Status.UNAUTHORIZED)
					.entity(new ErrorEntity("Module is not initialized")).build());
		try {
			Slot[] slotList = m.getSlotList(Module.SlotRequirement.ALL_SLOTS);
			Token tok = slotList[idToken].getToken();
			Mechanism[] mechList = tok.getMechanismList();
			TokenMechanismsBeanResponse b = new TokenMechanismsBeanResponse();
			if (select.size() == 0 || select.contains("*")){
				select.clear();
				select.add("Digest");
				select.add("FullEncryptDecrypt");
				select.add("FullSignVerify");
				select.add("KeyDerivation");
				select.add("KeyGeneration");
				select.add("KeyPairGeneration");
				select.add("SignVerifyRecover");
				select.add("SingleOperationEncryptDecrypt");
				select.add("SingleOperationSignVerify");
				select.add("WrapUnwrap");
				select.add("Other");
			}
			for(Mechanism mech : mechList){
				if(mech.isDigestMechanism() && select.contains("Digest")) {
					b.addDigest(mech.getName());
				}
				if(mech.isFullEncryptDecryptMechanism() && select.contains("FullEncryptDecrypt")) {
					b.addFullEncryptDecrypt(mech.getName());
				}
				if(mech.isFullSignVerifyMechanism() && select.contains("FullSignVerify")) {
					b.addFullSignVerify(mech.getName());
				}
				if(mech.isKeyDerivationMechanism() && select.contains("KeyDerivation")) {
					b.addKeyDerivation(mech.getName());
				}
				if(mech.isKeyGenerationMechanism() && select.contains("KeyGeneration")) {
					b.addKeyGeneration(mech.getName());
				}
				if(mech.isKeyPairGenerationMechanism() && select.contains("KeyPairGeneration")) {
					b.addKeyPairGeneration(mech.getName());
				}
				if(mech.isSignVerifyRecoverMechanism() && select.contains("SignVerifyRecover")) {
					b.addSignVerifyRecover(mech.getName());
				}
				if(mech.isSingleOperationEncryptDecryptMechanism() && select.contains("SingleOperationEncryptDecrypt")) {
					b.addSingleOperationEncryptDecrypt(mech.getName());
				}
				if(mech.isSingleOperationSignVerifyMechanism() && select.contains("SingleOperationSignVerify")) {
					b.addSingleOperationSignVerify(mech.getName());
				}
				if(mech.isWrapUnwrapMechanism() && select.contains("WrapUnwrap")) {
					b.addWrapUnwrap(mech.getName());
				}
				if(!mech.isDigestMechanism() && 
						!mech.isFullEncryptDecryptMechanism() &&
						!mech.isFullSignVerifyMechanism() &&
						!mech.isKeyDerivationMechanism() &&
						!mech.isKeyGenerationMechanism() &&
						!mech.isKeyPairGenerationMechanism() &&
						!mech.isSignVerifyRecoverMechanism() &&
						!mech.isSingleOperationEncryptDecryptMechanism() &&
						!mech.isSingleOperationSignVerifyMechanism() &&
						!mech.isWrapUnwrapMechanism() &&
						select.contains("Other")){
					if(!mech.getName().contains("Unknwon mechanism with code:")){ //thanks for bad spelling "unknwon"
						b.addOther(mech.getName());
					}
				}
				
				
			}
			return b;
		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Unable to retrieve slot list")).build());
		}
	}
	
	@SuppressWarnings("all")
	public SecretKeyBeanResponse genSecretKey(HttpServletRequest req, int idToken) {
		Module m = (Module) req.getSession().getAttribute("module");
		SecretKeyBeanResponse br = new SecretKeyBeanResponse();
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
			Mechanism keyGenerationMechanism = Mechanism.get(PKCS11Constants.CKM_AES_KEY_GEN);
			AESSecretKey secretKeyTpt = new AESSecretKey();
			secretKeyTpt.getValueLen().setLongValue(new Long(32));
			
			SecretKey secretKey = (AESSecretKey)sess.generateKey(keyGenerationMechanism, secretKeyTpt);
			
			br.setAlwaysSensitive(secretKey.getAlwaysSensitive().getBooleanValue());
			br.setCheckValue(secretKey.getCheckValue().getByteArrayValue());
			br.setDecrypt(secretKey.getDecrypt().getBooleanValue());
			br.setEncrypt(secretKey.getEncrypt().getBooleanValue());
			br.setExtractable(secretKey.getExtractable().getBooleanValue());
			br.setNeverExtractable(secretKey.getExtractable().getBooleanValue());
			br.setSensitive(secretKey.getSensitive().getBooleanValue());
			br.setSign(secretKey.getSign().getBooleanValue());
			br.setTrusted(secretKey.getTrusted().getBooleanValue());
			br.setUnwrap(secretKey.getUnwrap().getBooleanValue());
			br.setUnwrapTemplate(secretKey.getUnwrapTemplate().getAttributeArrayValue());
			br.setVerify(secretKey.getVerify().getBooleanValue());
			br.setWrap(secretKey.getWrap().getBooleanValue());
			br.setWrapTemplate(secretKey.getWrapTemplate());
			br.setWrapWithTrusted(secretKey.getWrapWithTrusted().getBooleanValue());
			br.setAllowedMechanisms(secretKey.getAllowedMechanisms());
			br.setDerive(secretKey.getDerive().getBooleanValue());
			br.setEndDate(secretKey.getEndDate().toString());
			br.setId(secretKey.getId());
			br.setKeyGenMechanism(secretKey.getKeyGenMechanism().getMechanism().getName());
			br.setKeyType(secretKey.getKeyType());
			br.setLocal(secretKey.getLocal().getBooleanValue());
			br.setStartDate(secretKey.getEndDate().toString());
			return br;
			
		} catch (TokenException e) {
			e.printStackTrace();
		}
//		br.setAesKeyString("No key generated");
		
		return br;
	}

	public KeyPairBeanResponse genKeyPair(HttpServletRequest req, int idToken) {
		// TODO Auto-generated method stub
		return null;
	}
}
