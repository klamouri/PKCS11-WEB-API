package api.beans.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NbSlotBeanResponse {

	private int nbSlot;

	public int getNbSlot() {
		return nbSlot;
	}

	public void setNbSlot(int length) {
		this.nbSlot = length;
	}
	
}
