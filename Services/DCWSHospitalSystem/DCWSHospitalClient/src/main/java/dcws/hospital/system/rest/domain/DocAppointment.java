package dcws.hospital.system.rest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dcws.hospital.system.rest.enums.Status;

@Entity
@Table(name = "hospital_system_doctor_apointments")
public class DocAppointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5787066924706482346L;

	@Id
	@GeneratedValue
	@Column(name = "DOC_APO_ID", nullable = false)
	private Long docApoId;

	@JoinColumn(name = "DOC_ID")
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Doctor.class)
	private Doctor doctor;

	@JoinColumn(name = "APO_ID")
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Appointments.class)
	private Appointments appointments;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@Column(name = "CHARGE", nullable = false)
	private double charge;

	public Long getDocApoId() {
		return docApoId;
	}

	public void setDocApoId(Long docApoId) {
		this.docApoId = docApoId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Appointments getAppointments() {
		return appointments;
	}

	public void setAppointments(Appointments appointments) {
		this.appointments = appointments;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

}
