package api.beans.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModuleBeanRequest {
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
