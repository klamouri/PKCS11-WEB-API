package api.beans.request;

public class KeyRequest {
	private String selectedMechanism;
	private long keySize;
	private String name;
	private boolean sensitive;
	private boolean extractable;
	private boolean derive;
	private boolean encrypt;
	private boolean decrypt;
	private boolean wrap;
	private boolean sign;
	private boolean verify;
	private boolean unwrap;
	
	
	public String getSelectedMechanism() {
		return selectedMechanism;
	}
	public void setSelectedMechanism(String selectedMechanism) {
		this.selectedMechanism = selectedMechanism;
	}
	public long getKeySize() {
		return keySize;
	}
	public void setKeySize(long keySize) {
		this.keySize = keySize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSensitive() {
		return sensitive;
	}
	public void setSensitive(boolean sensitive) {
		this.sensitive = sensitive;
	}
	public boolean isExtractable() {
		return extractable;
	}
	public void setExtractable(boolean extractable) {
		this.extractable = extractable;
	}
	public boolean isDerive() {
		return derive;
	}
	public void setDerive(boolean derive) {
		this.derive = derive;
	}
	public boolean isEncrypt() {
		return encrypt;
	}
	public void setEncrypt(boolean encrypt) {
		this.encrypt = encrypt;
	}
	public boolean isDecrypt() {
		return decrypt;
	}
	public void setDecrypt(boolean decrypt) {
		this.decrypt = decrypt;
	}
	public boolean isWrap() {
		return wrap;
	}
	public void setWrap(boolean wrap) {
		this.wrap = wrap;
	}
	public boolean isSign() {
		return sign;
	}
	public void setSign(boolean sign) {
		this.sign = sign;
	}
	public boolean isVerify() {
		return verify;
	}
	public void setVerify(boolean verify) {
		this.verify = verify;
	}
	public boolean isUnwrap() {
		return unwrap;
	}
	public void setUnwrap(boolean unwrap) {
		this.unwrap = unwrap;
	}

}
