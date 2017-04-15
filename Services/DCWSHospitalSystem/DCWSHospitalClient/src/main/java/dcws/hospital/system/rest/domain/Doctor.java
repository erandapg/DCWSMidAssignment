package dcws.hospital.system.rest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import dcws.hospital.system.rest.enums.Status;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "hospital_system_doctor")
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5787066924706482346L;

	@Id
	@GeneratedValue
	@Column(name = "DOC_ID", nullable = false)
	@ApiModelProperty(notes = "Doc id", required = true, example = "1")
	private Long docId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "SPECIALITY", nullable = false)
	private String speciality;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_DATE", nullable = false)
	@ApiModelProperty(notes = "Created date", required = true, example = "2016-03-31 06:31:14")
	private Date createdDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "MODIFY_DATE")
	@ApiModelProperty(notes = "Modified date", required = false, example = "2016-04-01 06:31:14")
	private Date modifyDate;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", name=" + name + ", speciality=" + speciality + ", createdDate="
				+ createdDate + ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}

}
