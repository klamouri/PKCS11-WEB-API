package api.beans.response;

public class KeyPairBeanResponse {
	
	private String PubKey;
	private String PrivKey;
	
	public String getPubKey() {
		return PubKey;
	}
	public void setPubKey(String pubKey) {
		PubKey = pubKey;
	}
	public String getPrivKey() {
		return PrivKey;
	}
	public void setPrivKey(String privKey) {
		PrivKey = privKey;
	}
	
}
