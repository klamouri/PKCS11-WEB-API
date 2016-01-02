package api.beans.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InitRequest {
	
	private String pinSO;
	
	private String label;

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPinSO() {
		return pinSO;
	}

	public void setPinSO(String pinSO) {
		this.pinSO = pinSO;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
