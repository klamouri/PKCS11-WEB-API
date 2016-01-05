package api.beans.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class RandomBeanResponse {
	
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	private byte[] bytesArray;

	public byte[] getBytesArray() {
		return bytesArray;
	}

	public void setBytesArray(byte[] bytesArray) {
		this.bytesArray = bytesArray;
	}
}
