package api.beans.response;

import iaik.pkcs.pkcs11.objects.DateAttribute;
import iaik.pkcs.pkcs11.objects.MechanismArrayAttribute;

public class SecretKeyBeanResponse {
//	public String secretKeyString;

//	public String getAesKeyString() {
//		return secretKeyString;
//	}
//
//	public void setAesKeyString(String secretKeyString) {
//		this.secretKeyString = secretKeyString;
//	}
	
	private boolean alwaysSensitive;
	private Object checkValue;
	private boolean decrypt;
	private boolean encrypt;
	private boolean extractable;
	private boolean neverExtractable;
	private boolean sensitive;
	private boolean sign;
	private boolean trusted;
	private boolean unwrap;
	private Object unwrapTemplate;
	private boolean verify;
	private boolean wrap;
	private Object wrapTemplate;
	private boolean wrapWithTrusted;
	private Object allowedMechanisms;
	private boolean derive;
	private DateAttribute endDate;
	private Object id;
	private Object keyGenMechanism;
	private Object keyType;
	private boolean local;
	private DateAttribute startDate;
	
	
	public boolean isAlwaysSensitive() {
		return alwaysSensitive;
	}
	public void setAlwaysSensitive(boolean alwaysSensitive) {
		this.alwaysSensitive = alwaysSensitive;
	}
	public Object getCheckValue() {
		return checkValue;
	}
	public void setCheckValue(Object checkValue) {
		this.checkValue = checkValue;
	}
	public boolean isDecrypt() {
		return decrypt;
	}
	public void setDecrypt(boolean decrypt) {
		this.decrypt = decrypt;
	}
	public boolean isEncrypt() {
		return encrypt;
	}
	public void setEncrypt(boolean encrypt) {
		this.encrypt = encrypt;
	}
	public boolean isExtractable() {
		return extractable;
	}
	public void setExtractable(boolean extractable) {
		this.extractable = extractable;
	}
	public boolean isNeverExtractable() {
		return neverExtractable;
	}
	public void setNeverExtractable(boolean neverExtractable) {
		this.neverExtractable = neverExtractable;
	}
	public boolean isSensitive() {
		return sensitive;
	}
	public void setSensitive(boolean sensitive) {
		this.sensitive = sensitive;
	}
	public boolean isSign() {
		return sign;
	}
	public void setSign(boolean sign) {
		this.sign = sign;
	}
	public boolean isTrusted() {
		return trusted;
	}
	public void setTrusted(boolean trusted) {
		this.trusted = trusted;
	}
	public boolean isUnwrap() {
		return unwrap;
	}
	public void setUnwrap(boolean unwrap) {
		this.unwrap = unwrap;
	}
	public Object getUnwrapTemplate() {
		return unwrapTemplate;
	}
	public void setUnwrapTemplate(Object unwrapTemplate) {
		this.unwrapTemplate = unwrapTemplate;
	}
	public boolean isVerify() {
		return verify;
	}
	public void setVerify(boolean verify) {
		this.verify = verify;
	}
	public boolean isWrap() {
		return wrap;
	}
	public void setWrap(boolean wrap) {
		this.wrap = wrap;
	}
	public Object getWrapTemplate() {
		return wrapTemplate;
	}
	public void setWrapTemplate(Object wrapTemplate) {
		this.wrapTemplate = wrapTemplate;
	}
	public boolean isWrapWithTrusted() {
		return wrapWithTrusted;
	}
	public void setWrapWithTrusted(boolean wrapWithTrusted) {
		this.wrapWithTrusted = wrapWithTrusted;
	}
	public Object getAllowedMechanisms() {
		return allowedMechanisms;
	}
	public void setAllowedMechanisms(Object allowedMechanisms) {
		this.allowedMechanisms = allowedMechanisms;
	}
	public boolean isDerive() {
		return derive;
	}
	public void setDerive(boolean derive) {
		this.derive = derive;
	}
	public DateAttribute getEndDate() {
		return endDate;
	}
	public void setEndDate(DateAttribute endDate) {
		this.endDate = endDate;
	}
	public Object getId() {
		return id;
	}
	public void setId(Object id) {
		this.id = id;
	}
	public Object getKeyGenMechanism() {
		return keyGenMechanism;
	}
	public void setKeyGenMechanism(Object keyGenMechanism) {
		this.keyGenMechanism = keyGenMechanism;
	}
	public Object getKeyType() {
		return keyType;
	}
	public void setKeyType(Object keyType) {
		this.keyType = keyType;
	}
	public boolean isLocal() {
		return local;
	}
	public void setLocal(boolean local) {
		this.local = local;
	}
	public DateAttribute getStartDate() {
		return startDate;
	}
	public void setStartDate(DateAttribute startDate) {
		this.startDate = startDate;
	}

}
