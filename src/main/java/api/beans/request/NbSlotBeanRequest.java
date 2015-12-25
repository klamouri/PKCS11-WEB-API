package api.beans.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NbSlotBeanRequest {
	
	private String libraryPath;

	public String getLibraryPath() {
		return libraryPath;
	}

	public void setLibraryPath(String libraryPath) {
		this.libraryPath = libraryPath;
	}

}
