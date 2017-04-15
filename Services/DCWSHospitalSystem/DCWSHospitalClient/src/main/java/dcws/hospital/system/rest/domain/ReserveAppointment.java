package dcws.hospital.system.rest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import dcws.hospital.system.rest.enums.PaymentMethods;
import dcws.hospital.system.rest.enums.Status;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "hospital_system_reserve_apointments")
public class ReserveAppointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5787066924706482346L;

	@Id
	@GeneratedValue
	@Column(name = "REZ_ID")
	@ApiModelProperty(notes = "Rez id", required = true, example = "1")
	private Long rezId;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_DATE", nullable = false)
	@ApiModelProperty(notes = "Created date", required = true, example = "2016-03-31 06:31:14")
	private Date createdDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "MODIFY_DATE")
	@ApiModelProperty(notes = "Modified date", required = false, example = "2016-04-01 06:31:14")
	private Date modifyDate;

	@JoinColumn(name = "DOC_APO_ID", nullable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private DocAppointment docAppointment;

	@Column(name = "CHARGE", nullable = false)
	private double charge;

	@Column(name = "PAYMENT_METH", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private PaymentMethods paymentMethods;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@Column(name = "USER", nullable = false)
	private String user;

	public Long getRezId() {
		return rezId;
	}

	public void setRezId(Long rezId) {
		this.rezId = rezId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public DocAppointment getDocAppointment() {
		return docAppointment;
	}

	public void setDocAppointment(DocAppointment docAppointment) {
		this.docAppointment = docAppointment;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public PaymentMethods getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethods paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ReserveAppointment [rezId=" + rezId + ", description=" + description + ", createdDate=" + createdDate
				+ ", modifyDate=" + modifyDate + ", docAppointment=" + docAppointment + ", charge=" + charge
				+ ", paymentMethods=" + paymentMethods + ", status=" + status + ", user=" + user + "]";
	}

}
