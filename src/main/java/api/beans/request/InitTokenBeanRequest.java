package api.beans.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InitTokenBeanRequest {
	
	private String pinSO;
	
	private String label;

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
