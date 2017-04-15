package dcws.hospital.system.rest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import dcws.hospital.system.rest.enums.Status;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "hospital_system_apointments")
public class Appointments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5787066924706482346L;

	@Id
	@GeneratedValue
	@Column(name = "APO_ID", nullable = false)
	@ApiModelProperty(notes = "Apo id", required = true, example = "1")
	private Long apoId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "HOSPITAL", nullable = false)
	private String hostpital;

	@Column(name = "dateTime", nullable = false)
	private Date dateTime;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public Long getApoId() {
		return apoId;
	}

	public void setApoId(Long apoId) {
		this.apoId = apoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHostpital() {
		return hostpital;
	}

	public void setHostpital(String hostpital) {
		this.hostpital = hostpital;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointments [apoId=" + apoId + ", name=" + name + ", hostpital=" + hostpital + ", dateTime=" + dateTime
				+ ", status=" + status + "]";
	}

}
