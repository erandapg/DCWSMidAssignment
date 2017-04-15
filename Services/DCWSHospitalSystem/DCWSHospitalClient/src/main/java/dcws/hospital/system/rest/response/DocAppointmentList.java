package dcws.hospital.system.rest.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import dcws.hospital.system.rest.domain.DocAppointment;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "responseStatus", "errorDesc", "appointmentList" })
public class DocAppointmentList extends GenericResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6003559698611562986L;
	@ApiModelProperty(notes = "Appointment List", required = false)
	private List<ApointmentResponse> appointmentList = new ArrayList<ApointmentResponse>();

	public List<ApointmentResponse> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<ApointmentResponse> appointmentList) {
		this.appointmentList = appointmentList;
	}

}
