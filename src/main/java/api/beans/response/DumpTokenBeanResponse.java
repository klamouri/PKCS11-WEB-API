package api.beans.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DumpTokenBeanResponse {
	private List<ObjectBeans> objets;

	public List<ObjectBeans> getObjets() {
		return objets;
	}

	public void setObjets(List<ObjectBeans> objets) {
		this.objets = objets;
	}

}
