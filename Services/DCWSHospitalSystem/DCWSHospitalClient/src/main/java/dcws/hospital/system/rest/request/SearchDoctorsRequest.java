package dcws.hospital.system.rest.request;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class SearchDoctorsRequest implements Serializable {

	private static final long serialVersionUID = -5281077148808546833L;

	@ApiModelProperty(notes = "Doc Name", required = false)
	private String docName;

	@ApiModelProperty(notes = "Hospital Name", required = false)
	private String hospitalName;

	@ApiModelProperty(notes = "Specialization", required = false)
	private String specialization;

	@ApiModelProperty(notes = "Apoinment Date", required = false)
	private Date date;

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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SearchDoctorsRequest [docName=" + docName + ", hospitalName=" + hospitalName + ", specialization="
				+ specialization + ", date=" + date + "]";
	}

}
