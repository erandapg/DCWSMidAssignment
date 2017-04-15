package dcws.hospital.system.rest.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	"responseStatus",
	"errorDesc",
})
public class GenericResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6892133356959790704L;
	/**
	 * 
	 */
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "Status Code of the service call", required = true, example = "0")
	private int responseStatus;
	@JsonProperty("errorDesc")
	@ApiModelProperty(notes = "Error code description", required = false, example = "Invlid status")
	private String errorDesc;
	
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
	@Override
	public String toString() {
		return "GeneralResponse [responseStatus=" + responseStatus + ", errorDesc=" + errorDesc
				+ "]";
	}
	
}
