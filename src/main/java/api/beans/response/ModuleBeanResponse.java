package api.beans.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModuleBeanResponse {
	private String jsessionid;

	public String getJsessionid() {
		return jsessionid;
	}

	public void setJsessionid(String jsessionid) {
		this.jsessionid = jsessionid;
	}
}
