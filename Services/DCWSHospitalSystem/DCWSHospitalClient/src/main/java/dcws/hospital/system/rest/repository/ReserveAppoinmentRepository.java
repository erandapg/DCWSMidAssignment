package dcws.hospital.system.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import dcws.hospital.system.rest.domain.ReserveAppointment;

@Transactional
public interface ReserveAppoinmentRepository extends CrudRepository<ReserveAppointment, Long> {
}