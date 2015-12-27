package api.error.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorEntity {
	
	private String description;
	
	public ErrorEntity(){
		
	}
	
	public ErrorEntity(String cause){
		this.setDescription(cause);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
