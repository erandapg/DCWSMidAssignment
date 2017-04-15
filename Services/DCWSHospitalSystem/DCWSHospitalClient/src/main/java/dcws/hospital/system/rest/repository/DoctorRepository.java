package dcws.hospital.system.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import dcws.hospital.system.rest.domain.Doctor;

/*This class using for DB transcation related function on Doctor*/

@Transactional
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

	Doctor findByName(String name);

}
