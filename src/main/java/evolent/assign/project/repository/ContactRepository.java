package evolent.assign.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import evolent.assign.project.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

	
}
