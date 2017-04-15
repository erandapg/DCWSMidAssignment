package dcws.hospital.system.rest.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import dcws.hospital.system.rest.domain.Doctor;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "responseStatus", "errorDesc", "doctorsList" })
public class DoctorResList extends GenericResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6003559698611562986L;
	@JsonProperty("doctorsList")
	@ApiModelProperty(notes = "Doctor List", required = false)
	private List<Doctor> doctorsList = new ArrayList<Doctor>();

	public List<Doctor> getDoctorsList() {
		return doctorsList;
	}

	public void setDoctorsList(List<Doctor> doctorsList) {
		this.doctorsList = doctorsList;
	}

}
