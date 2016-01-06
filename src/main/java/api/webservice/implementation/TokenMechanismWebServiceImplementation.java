package api.webservice.implementation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.response.KeyPairBeanResponse;
import api.beans.response.SecretKeyBeanResponse;
import api.beans.response.TokenMechanismsBeanResponse;
import api.error.entity.ErrorEntity;
import iaik.pkcs.pkcs11.Mechanism;
import iaik.pkcs.pkcs11.MechanismInfo;
import iaik.pkcs.pkcs11.Module;
import iaik.pkcs.pkcs11.Session;
import iaik.pkcs.pkcs11.Slot;
import iaik.pkcs.pkcs11.Token;
import iaik.pkcs.pkcs11.TokenException;
import iaik.pkcs.pkcs11.TokenInfo;
import iaik.pkcs.pkcs11.Version;
import iaik.pkcs.pkcs11.objects.AESSecretKey;
import iaik.pkcs.pkcs11.objects.Attribute;
import iaik.pkcs.pkcs11.objects.DateAttribute;
import iaik.pkcs.pkcs11.objects.GenericTemplate;
import iaik.pkcs.pkcs11.objects.KeyPair;
import iaik.pkcs.pkcs11.objects.RSAPrivateKey;
import iaik.pkcs.pkcs11.objects.RSAPublicKey;
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
			secretKeyTpt.getToken().setBooleanValue(true);
			secretKeyTpt.getExtractable().setBooleanValue(true);
			secretKeyTpt.getLabel().setCharArrayValue(Calendar.getInstance().getTime().toString().toCharArray());

			SecretKey secretKey = (AESSecretKey)sess.generateKey(keyGenerationMechanism, secretKeyTpt);

			System.out.println("ClassName");
			System.out.println(secretKey.getClass().getName());
			System.out.println("Secret key content");
			System.out.println(secretKey.toString());

			br.setLabel(secretKey.getLabel().toString());
			br.setModifiable(secretKey.getModifiable().getBooleanValue());
			br.setPrivated(secretKey.getPrivate().getBooleanValue());
			br.setToken(secretKey.getToken().getBooleanValue());
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

	@SuppressWarnings("unchecked")
	public KeyPairBeanResponse genKeyPair(HttpServletRequest req, int idToken) {
		Module m = (Module) req.getSession().getAttribute("module");
		KeyPairBeanResponse br = new KeyPairBeanResponse();
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
			MechanismInfo signatureMechanismInfo = t.getMechanismInfo(Mechanism.get(PKCS11Constants.CKM_RSA_PKCS));

			Mechanism keyPairGenerationMechanism = Mechanism.get(PKCS11Constants.CKM_RSA_PKCS_KEY_PAIR_GEN);
			RSAPublicKey rsaPublicKeyTemplate = new RSAPublicKey();
			RSAPrivateKey rsaPrivateKeyTemplate = new RSAPrivateKey();

			// set the general attributes for the public key
			rsaPublicKeyTemplate.getModulusBits().setLongValue(new Long(1024)); //TODO set customizable key length
			byte[] publicExponentBytes = {0x01, 0x00, 0x01}; // 2^16 + 1
			rsaPublicKeyTemplate.getPublicExponent().setByteArrayValue(publicExponentBytes);
			rsaPublicKeyTemplate.getToken().setBooleanValue(Boolean.FALSE);
			byte[] id = new byte[20];
			new Random().nextBytes(id);
			rsaPublicKeyTemplate.getId().setByteArrayValue(id);
			//rsaPublicKeyTemplate.getLabel().setCharArrayValue(args[2].toCharArray());

			rsaPrivateKeyTemplate.getSensitive().setBooleanValue(Boolean.TRUE);
			rsaPrivateKeyTemplate.getToken().setBooleanValue(Boolean.FALSE);
			rsaPrivateKeyTemplate.getPrivate().setBooleanValue(Boolean.TRUE);
			rsaPrivateKeyTemplate.getId().setByteArrayValue(id);
			//byte[] subject = args[1].getBytes();
			//rsaPrivateKeyTemplate.getSubject().setByteArrayValue(subject);
			//rsaPrivateKeyTemplate.getLabel().setCharArrayValue(args[2].toCharArray());

			try{
				Version cryptokiVersion = m.getInfo().getCryptokiVersion();
				if ((cryptokiVersion.getMajor() >= 2) && (cryptokiVersion.getMinor() >= 20)){
					GenericTemplate wrapTemplate = new GenericTemplate();
					GregorianCalendar startDate = new GregorianCalendar();
					startDate.add(Calendar.HOUR_OF_DAY, -1);
					DateAttribute startDateAttr = new DateAttribute(Attribute.START_DATE);
					startDateAttr.setDateValue(startDate.getTime());
					wrapTemplate.addAttribute(startDateAttr);
					GregorianCalendar endDate = new GregorianCalendar();
					endDate.add(Calendar.MONTH, 11);
					DateAttribute endDateAttr = new DateAttribute(Attribute.END_DATE);
					endDateAttr.setDateValue(endDate.getTime());
					wrapTemplate.addAttribute(endDateAttr);
					rsaPublicKeyTemplate.getWrapTemplate().setAttributeArrayValue(wrapTemplate);

					Mechanism[] allowedMechanisms = new Mechanism[1];
					Mechanism mechanism1 = new Mechanism(PKCS11Constants.CKM_RSA_PKCS);
					allowedMechanisms[0] = mechanism1;
					rsaPrivateKeyTemplate.getAllowedMechanisms().setMechanismAttributeArrayValue(allowedMechanisms);
				}
			}catch(TokenException e){
				e.printStackTrace();
			}

			// set the attributes in a way netscape does, this should work with most tokens
			if (signatureMechanismInfo != null) {
				rsaPublicKeyTemplate.getVerify().setBooleanValue(new Boolean(signatureMechanismInfo.isVerify()));
				rsaPublicKeyTemplate.getVerifyRecover().setBooleanValue(new Boolean(signatureMechanismInfo.isVerifyRecover()));
				rsaPublicKeyTemplate.getEncrypt().setBooleanValue(new Boolean(signatureMechanismInfo.isEncrypt()));
				rsaPublicKeyTemplate.getDerive().setBooleanValue(new Boolean(signatureMechanismInfo.isDerive()));
				rsaPublicKeyTemplate.getWrap().setBooleanValue(new Boolean(signatureMechanismInfo.isWrap()));

				rsaPrivateKeyTemplate.getSign().setBooleanValue(new Boolean(signatureMechanismInfo.isSign()));
				rsaPrivateKeyTemplate.getSignRecover().setBooleanValue(new Boolean(signatureMechanismInfo.isSignRecover()));
				rsaPrivateKeyTemplate.getDecrypt().setBooleanValue(new Boolean(signatureMechanismInfo.isDecrypt()));
				rsaPrivateKeyTemplate.getDerive().setBooleanValue(new Boolean(signatureMechanismInfo.isDerive()));
				rsaPrivateKeyTemplate.getUnwrap().setBooleanValue(new Boolean(signatureMechanismInfo.isUnwrap()));
			} else {
				// if we have no information we assume these attributes
				rsaPrivateKeyTemplate.getSign().setBooleanValue(Boolean.TRUE);
				rsaPrivateKeyTemplate.getDecrypt().setBooleanValue(Boolean.TRUE);

				rsaPublicKeyTemplate.getVerify().setBooleanValue(Boolean.TRUE);
				rsaPublicKeyTemplate.getEncrypt().setBooleanValue(Boolean.TRUE);
			}

			// netscape does not set these attribute, so we do no either
			rsaPublicKeyTemplate.getKeyType().setPresent(false);
			rsaPublicKeyTemplate.getObjectClass().setPresent(false);

			rsaPrivateKeyTemplate.getKeyType().setPresent(false);
			rsaPrivateKeyTemplate.getObjectClass().setPresent(false);
			
			System.out.println("Pub template");
			System.out.println(rsaPublicKeyTemplate);
			System.out.println("Priv tempalte");
			System.out.println(rsaPrivateKeyTemplate);
			
			
			KeyPair generatedKeyPair = sess.generateKeyPair(keyPairGenerationMechanism, rsaPublicKeyTemplate, rsaPrivateKeyTemplate);

			RSAPublicKey generatedRSAPublicKey = (RSAPublicKey) generatedKeyPair.getPublicKey();
			RSAPrivateKey generatedRSAPrivateKey = (RSAPrivateKey) generatedKeyPair.getPrivateKey();
			
			br.setPubKey(generatedRSAPublicKey.toString());
			br.setPrivKey(generatedRSAPrivateKey.toString());
			
			return br;

		} catch (TokenException e) {
			e.printStackTrace();
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity(e.getMessage())).build());
		}
//		return null;
	}
}
