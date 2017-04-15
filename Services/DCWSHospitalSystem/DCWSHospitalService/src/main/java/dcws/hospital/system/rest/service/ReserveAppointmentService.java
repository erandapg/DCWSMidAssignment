package dcws.hospital.system.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dcws.hospital.system.rest.domain.DocAppointment;
import dcws.hospital.system.rest.enums.Status;
import dcws.hospital.system.rest.repository.DocAppoinmentRepository;
import dcws.hospital.system.rest.request.SearchAppointmentRequest;
import dcws.hospital.system.rest.request.SearchDoctorsRequest;
import dcws.hospital.system.rest.response.DocAppointmentList;
import dcws.hospital.system.rest.response.DoctorResList;

@Service
public class ReserveAppointmentService implements IReserveAppointmentService {

	@Autowired
	private DocAppoinmentRepository docAppoinmentRepository;

	public DocAppointmentList getApointmentsByDocId(SearchAppointmentRequest appointmentRequest) {
		DocAppointmentList appointmentList = new DocAppointmentList();
		return appointmentList;

	}

	public DoctorResList serachDoctors(SearchDoctorsRequest searchDoctorsRequest) {
		DoctorResList doctorResList = new DoctorResList();
		return doctorResList;

	}

	public List<DocAppointment> getAllApointments() {
		List<DocAppointment> appointmentList = new ArrayList<DocAppointment>();
		appointmentList = docAppoinmentRepository.findByStatus(Status.ACTIVE);
		return appointmentList;

	}

	@Override
	public List<DocAppointment> getApointmentsBySearchCrit(SearchDoctorsRequest doctorsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
