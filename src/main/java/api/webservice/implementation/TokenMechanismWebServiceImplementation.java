package api.webservice.implementation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.beans.request.KeyRequest;
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
import iaik.pkcs.pkcs11.objects.AESSecretKey;
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
	public SecretKeyBeanResponse genSecretKey(HttpServletRequest req, KeyRequest kr, int idToken) {
		Session sess = SessionWebServiceImplementation.getLocalSession(req, idToken);

		SecretKeyBeanResponse br = new SecretKeyBeanResponse();

		Mechanism keyGenerationMechanism;
		switch (kr.getSelectedMechanism()) {
		case "CKM_DES_KEY_GEN" :
			keyGenerationMechanism = Mechanism.get(PKCS11Constants.CKM_DES_KEY_GEN);
			break;
		case "CKM_DES2_KEY_GEN" :
			keyGenerationMechanism = Mechanism.get(PKCS11Constants.CKM_DES2_KEY_GEN);
			break;
		case "CKM_DES3_KEY_GEN" :
			keyGenerationMechanism = Mechanism.get(PKCS11Constants.CKM_DES3_KEY_GEN);
			break;
		case "CKM_AES_KEY_GEN" :
			keyGenerationMechanism = Mechanism.get(PKCS11Constants.CKM_AES_KEY_GEN);
			break;
		case "CKM_DSA_PARAMETER_GEN" :
			keyGenerationMechanism = Mechanism.get(PKCS11Constants.CKM_DSA_PARAMETER_GEN);
			break;
		case "CKM_DH_PKCS_PARAMETER_GEN" : 
			keyGenerationMechanism = Mechanism.get(PKCS11Constants.CKM_DH_PKCS_PARAMETER_GEN);
			break;
		default:
			keyGenerationMechanism = Mechanism.get(PKCS11Constants.CKM_AES_KEY_GEN);
			break;
		}

		SecretKey secretKeyTpt;

		if (kr.getSelectedMechanism().equals("CKM_AES_KEY_GEN")){
			secretKeyTpt = new AESSecretKey();
			((AESSecretKey) secretKeyTpt).getValueLen().setLongValue(kr.getKeySize() /8);
		} else {
			secretKeyTpt = new SecretKey();
		}

		secretKeyTpt.getToken().setBooleanValue(true);

		secretKeyTpt.getSensitive().setBooleanValue(kr.isSensitive());
		secretKeyTpt.getExtractable().setBooleanValue(kr.isExtractable());

		secretKeyTpt.getDerive().setBooleanValue(kr.isDerive());
		secretKeyTpt.getEncrypt().setBooleanValue(kr.isEncrypt());
		secretKeyTpt.getDecrypt().setBooleanValue(kr.isDecrypt());
		secretKeyTpt.getWrap().setBooleanValue(kr.isWrap());
		secretKeyTpt.getUnwrap().setBooleanValue(kr.isUnwrap());
		secretKeyTpt.getSign().setBooleanValue(kr.isSign());
		secretKeyTpt.getVerify().setBooleanValue(kr.isVerify());

		secretKeyTpt.getLabel().setCharArrayValue(kr.getName().toCharArray());

		SecretKey secretKey;
		try {
			secretKey = (SecretKey) sess.generateKey(keyGenerationMechanism, secretKeyTpt);
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
		} catch (TokenException e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Internal error while generating Key")).build());
		}
		return br;
	}


	public KeyPairBeanResponse genKeyPair(HttpServletRequest req, KeyRequest kr, int idToken) {
		Session sess = SessionWebServiceImplementation.getLocalSession(req, idToken);

		KeyPairBeanResponse br = new KeyPairBeanResponse();

		Mechanism keyPairGenerationMechanism;
		if (kr.getSelectedMechanism().equals("CKM_RSA_PKCS_KEY_PAIR_GEN")){
			Mechanism.get(PKCS11Constants.CKM_RSA_PKCS_KEY_PAIR_GEN);
		} else {
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
					.entity(new ErrorEntity("Key Generation Mechanism not supported")).build());
		}
		keyPairGenerationMechanism = Mechanism.get(PKCS11Constants.CKM_RSA_PKCS_KEY_PAIR_GEN);

		RSAPublicKey rsaPublicKeyTemplate = new RSAPublicKey();
		RSAPrivateKey rsaPrivateKeyTemplate = new RSAPrivateKey();

		rsaPublicKeyTemplate.getModulusBits().setLongValue(kr.getKeySize());//
		rsaPublicKeyTemplate.getToken().setBooleanValue(true);

		rsaPrivateKeyTemplate.getSensitive().setBooleanValue(kr.isSensitive());//
		rsaPrivateKeyTemplate.getExtractable().setBooleanValue(kr.isExtractable());//

		rsaPublicKeyTemplate.getDerive().setBooleanValue(false);
		rsaPublicKeyTemplate.getEncrypt().setBooleanValue(kr.isEncrypt());//
		rsaPublicKeyTemplate.getWrap().setBooleanValue(kr.isWrap());//
		rsaPublicKeyTemplate.getVerify().setBooleanValue(kr.isVerify());//

		String keyName = kr.getName();

		rsaPublicKeyTemplate.getLabel().setCharArrayValue((keyName + ".pub").toCharArray());//name

		rsaPrivateKeyTemplate.getDerive().setBooleanValue(false);
		rsaPrivateKeyTemplate.getDecrypt().setBooleanValue(kr.isDecrypt());//
		rsaPrivateKeyTemplate.getUnwrap().setBooleanValue(kr.isUnwrap());//
		rsaPrivateKeyTemplate.getSign().setBooleanValue(kr.isSign());//
		rsaPrivateKeyTemplate.getToken().setBooleanValue(true);

		rsaPrivateKeyTemplate.getLabel().setCharArrayValue(keyName.toCharArray());

		System.out.println("Pub template");
		System.out.println(rsaPublicKeyTemplate);
		System.out.println("Priv tempalte");
		System.out.println(rsaPrivateKeyTemplate);

		KeyPair generatedKeyPair;
		try {
			generatedKeyPair = sess.generateKeyPair(keyPairGenerationMechanism, rsaPublicKeyTemplate, rsaPrivateKeyTemplate);


			RSAPublicKey generatedRSAPublicKey = (RSAPublicKey) generatedKeyPair.getPublicKey();
			RSAPrivateKey generatedRSAPrivateKey = (RSAPrivateKey) generatedKeyPair.getPrivateKey();

			br.setPubKey(generatedRSAPublicKey.toString());
			br.setPrivKey(generatedRSAPrivateKey.toString());
		} catch (TokenException e) {
			e.printStackTrace();
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorEntity("Internal error while generating Key")).build());
		}

		return br;

	} 
}
