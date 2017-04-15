package dcws.hospital.system.rest.service;

import java.util.List;

import dcws.hospital.system.rest.domain.DocAppointment;
import dcws.hospital.system.rest.request.SearchAppointmentRequest;
import dcws.hospital.system.rest.request.SearchDoctorsRequest;
import dcws.hospital.system.rest.response.DocAppointmentList;
import dcws.hospital.system.rest.response.DoctorResList;

public interface IReserveAppointmentService {

	public DocAppointmentList getApointmentsByDocId(SearchAppointmentRequest appointmentRequest);

	public DoctorResList serachDoctors(SearchDoctorsRequest searchDoctorsRequest);

	public List<DocAppointment> getAllApointments();

	public List<DocAppointment> getApointmentsBySearchCrit(SearchDoctorsRequest doctorsRequest);

}
