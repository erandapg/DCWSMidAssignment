package dcws.hospital.system.rest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import dcws.hospital.system.rest.domain.DocAppointment;
import dcws.hospital.system.rest.enums.Status;

/*This class using for DB transcation related function on DocAppointment*/

@Transactional
public interface DocAppoinmentRepository extends CrudRepository<DocAppointment, Long> {

	Page<DocAppointment> findAll(Pageable pageable);

	List<DocAppointment> findByStatus(Status status);

	DocAppointment findByDocApoId(Long docApoId);

}
