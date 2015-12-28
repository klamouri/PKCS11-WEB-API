package api.beans.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TokenInfoResponse {
	private byte minorFirmwareVersion;
	private byte majorFirmwareVersion;
	private long freePrivateMemory;
	private long freePublicMemory;
	private byte minorHardwareVersion;
	private byte majorHardwareVersion;
	private String label;
	private String manufacturerID;
	private long maxPinLen;
	private long minPinLen;
	private String serialNumber;
	private long totalPrivateMemory;
	private long totalPublicMemory;
	private boolean isDualCryptoOperations;
	private boolean isLoginRequired;
	private boolean isProtectedAuthenticationPath;
	private boolean isRestoreKeyNotNeeded;
	private boolean isRNG;
	private boolean isSecondaryAuthentication;
	private boolean isSoPinCountLow;
	private boolean isSoPinFinalTry;
	private boolean isSoPinLocked;
	private boolean isSoPinToBeChanged;
	private boolean isTokenInitialized;
	private boolean isUserPinCountLow;
	private boolean isUserPinFinalTry;
	private boolean isUserPinInitialized;
	private boolean isUserPinLocked;
	private boolean isUserPinToBeChanged;
	private boolean isWriteProtected;

	public byte getMinorFirmwareVersion() {
		return minorFirmwareVersion;
	}

	public void setMinorFirmwareVersion(byte minorFirmwareVersion) {
		this.minorFirmwareVersion = minorFirmwareVersion;
	}

	public byte getMajorFirmwareVersion() {
		return majorFirmwareVersion;
	}

	public void setMajorFirmwareVersion(byte majorFirmwareVersion) {
		this.majorFirmwareVersion = majorFirmwareVersion;
	}

	public long getFreePrivateMemory() {
		return freePrivateMemory;
	}

	public void setFreePrivateMemory(long freePrivateMemory) {
		this.freePrivateMemory = freePrivateMemory;
	}

	public long getFreePublicMemory() {
		return freePublicMemory;
	}

	public void setFreePublicMemory(long freePublicMemory) {
		this.freePublicMemory = freePublicMemory;
	}

	public byte getMinorHardwareVersion() {
		return minorHardwareVersion;
	}

	public void setMinorHardwareVersion(byte minorHardwareVersion) {
		this.minorHardwareVersion = minorHardwareVersion;
	}

	public byte getMajorHardwareVersion() {
		return majorHardwareVersion;
	}

	public void setMajorHardwareVersion(byte majorHardwareVersion) {
		this.majorHardwareVersion = majorHardwareVersion;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(String manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public long getMaxPinLen() {
		return maxPinLen;
	}

	public void setMaxPinLen(long maxPinLen) {
		this.maxPinLen = maxPinLen;
	}

	public long getMinPinLen() {
		return minPinLen;
	}

	public void setMinPinLen(long minPinLen) {
		this.minPinLen = minPinLen;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public long getTotalPrivateMemory() {
		return totalPrivateMemory;
	}

	public void setTotalPrivateMemory(long totalPrivateMemory) {
		this.totalPrivateMemory = totalPrivateMemory;
	}

	public long getTotalPublicMemory() {
		return totalPublicMemory;
	}

	public void setTotalPublicMemory(long totalPublicMemory) {
		this.totalPublicMemory = totalPublicMemory;
	}

	public boolean isDualCryptoOperations() {
		return isDualCryptoOperations;
	}

	public void setDualCryptoOperations(boolean isDualCryptoOperations) {
		this.isDualCryptoOperations = isDualCryptoOperations;
	}

	public boolean isLoginRequired() {
		return isLoginRequired;
	}

	public void setLoginRequired(boolean isLoginRequired) {
		this.isLoginRequired = isLoginRequired;
	}

	public boolean isProtectedAuthenticationPath() {
		return isProtectedAuthenticationPath;
	}

	public void setProtectedAuthenticationPath(boolean isProtectedAuthenticationPath) {
		this.isProtectedAuthenticationPath = isProtectedAuthenticationPath;
	}

	public boolean isRestoreKeyNotNeeded() {
		return isRestoreKeyNotNeeded;
	}

	public void setRestoreKeyNotNeeded(boolean isRestoreKeyNotNeeded) {
		this.isRestoreKeyNotNeeded = isRestoreKeyNotNeeded;
	}

	public boolean isRNG() {
		return isRNG;
	}

	public void setRNG(boolean isRNG) {
		this.isRNG = isRNG;
	}

	public boolean isSecondaryAuthentication() {
		return isSecondaryAuthentication;
	}

	public void setSecondaryAuthentication(boolean isSecondaryAuthentication) {
		this.isSecondaryAuthentication = isSecondaryAuthentication;
	}

	public boolean isSoPinCountLow() {
		return isSoPinCountLow;
	}

	public void setSoPinCountLow(boolean isSoPinCountLow) {
		this.isSoPinCountLow = isSoPinCountLow;
	}

	public boolean isSoPinFinalTry() {
		return isSoPinFinalTry;
	}

	public void setSoPinFinalTry(boolean isSoPinFinalTry) {
		this.isSoPinFinalTry = isSoPinFinalTry;
	}

	public boolean isSoPinLocked() {
		return isSoPinLocked;
	}

	public void setSoPinLocked(boolean isSoPinLocked) {
		this.isSoPinLocked = isSoPinLocked;
	}

	public boolean isSoPinToBeChanged() {
		return isSoPinToBeChanged;
	}

	public void setSoPinToBeChanged(boolean isSoPinToBeChanged) {
		this.isSoPinToBeChanged = isSoPinToBeChanged;
	}

	public boolean isTokenInitialized() {
		return isTokenInitialized;
	}

	public void setTokenInitialized(boolean isTokenInitialized) {
		this.isTokenInitialized = isTokenInitialized;
	}

	public boolean isUserPinCountLow() {
		return isUserPinCountLow;
	}

	public void setUserPinCountLow(boolean isUserPinCountLow) {
		this.isUserPinCountLow = isUserPinCountLow;
	}

	public boolean isUserPinFinalTry() {
		return isUserPinFinalTry;
	}

	public void setUserPinFinalTry(boolean isUserPinFinalTry) {
		this.isUserPinFinalTry = isUserPinFinalTry;
	}

	public boolean isUserPinInitialized() {
		return isUserPinInitialized;
	}

	public void setUserPinInitialized(boolean isUserPinInitialized) {
		this.isUserPinInitialized = isUserPinInitialized;
	}

	public boolean isUserPinLocked() {
		return isUserPinLocked;
	}

	public void setUserPinLocked(boolean isUserPinLocked) {
		this.isUserPinLocked = isUserPinLocked;
	}

	public boolean isUserPinToBeChanged() {
		return isUserPinToBeChanged;
	}

	public void setUserPinToBeChanged(boolean isUserPinToBeChanged) {
		this.isUserPinToBeChanged = isUserPinToBeChanged;
	}

	public boolean isWriteProtected() {
		return isWriteProtected;
	}

	public void setWriteProtected(boolean isWriteProtected) {
		this.isWriteProtected = isWriteProtected;
	}

}
