package dcws.hospital.system.rest.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentResponse implements Serializable {

	private static final long serialVersionUID = -5281077148808546833L;

	@JsonProperty(required = true)
	private String transactionId;
	@JsonProperty(required = true)
	private String status;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
