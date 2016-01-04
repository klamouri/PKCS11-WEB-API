package api.beans.request;

public class ChangePasswordTokenBeanRequest {
	
	private String userType;
	private String oldPin;
	private String newPin;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getOldPin() {
		return oldPin;
	}
	public void setOldPin(String oldPin) {
		this.oldPin = oldPin;
	}
	public String getNewPin() {
		return newPin;
	}
	public void setNewPin(String newPin) {
		this.newPin = newPin;
	}

}
