package dcws.hospital.system.rest.response;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApointmentResponse implements Serializable {

	private static final long serialVersionUID = -5281077148808546833L;

	@JsonProperty(required = true)
	private String apoimentId;
	@JsonProperty(required = true)
	private String docName;
	@JsonProperty(required = true)
	private String speciality;
	@JsonProperty(required = true)
	private String hospitalName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty(required = true)
	private Date apoimentTime;
	@JsonProperty(required = true)
	private String status;
	@JsonProperty(required = true)
	private double charge;

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public String getApoimentId() {
		return apoimentId;
	}

	public void setApoimentId(String apoimentId) {
		this.apoimentId = apoimentId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Date getApoimentTime() {
		return apoimentTime;
	}

	public void setApoimentTime(Date apoimentTime) {
		this.apoimentTime = apoimentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

}
