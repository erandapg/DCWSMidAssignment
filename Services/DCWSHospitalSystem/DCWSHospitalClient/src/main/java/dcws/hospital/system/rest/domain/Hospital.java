package dcws.hospital.system.rest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dcws.hospital.system.rest.enums.Status;

@Entity
@Table(name = "hospital_system_hospital")
public class Hospital implements Serializable {

	private static final long serialVersionUID = -5787066924706482346L;

	@Id
	@GeneratedValue
	@Column(name = "HOST_ID", nullable = false)
	private Long hostId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public Long getHostId() {
		return hostId;
	}

	public void setHostId(Long hostId) {
		this.hostId = hostId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Hospital [hostId=" + hostId + ", name=" + name + ", address=" + address + ", status=" + status + "]";
	}

}
