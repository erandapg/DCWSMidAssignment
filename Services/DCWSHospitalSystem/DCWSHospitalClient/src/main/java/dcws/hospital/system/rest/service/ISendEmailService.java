package dcws.hospital.system.rest.service;

import org.springframework.stereotype.Service;

import dcws.hospital.system.rest.domain.ReserveAppointment;

@Service
public interface ISendEmailService {

	/* This class used send an apoinment confirmation email to user */

	public void sendEmail(ReserveAppointment reserveAppointment);

}
