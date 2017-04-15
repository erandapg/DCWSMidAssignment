package dcws.hospital.system.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class SearchAppointmentRequest implements Serializable {

	private static final long serialVersionUID = -5281077148808546833L;

	@JsonProperty(required = true)
	@ApiModelProperty(notes = "SME Id")
	@NotNull(message = "error.docId.notnull")
	private Long docId;

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	@Override
	public String toString() {
		return "SearchAppointmentRequest [docId=" + docId + "]";
	}

}
