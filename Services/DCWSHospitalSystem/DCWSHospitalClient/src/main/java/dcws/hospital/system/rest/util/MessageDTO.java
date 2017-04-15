package dcws.hospital.system.rest.util;

public class MessageDTO {
	private int responseStatus;
	private String errorDesc;
	  
	  public MessageDTO() {
	    super();
	  }
	  
	  public MessageDTO(int status, String message) {
	    super();
	    this.responseStatus = status;
	    this.errorDesc = message;
	  }

	public int getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	  
}
