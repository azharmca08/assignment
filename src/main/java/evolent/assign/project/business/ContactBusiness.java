package evolent.assign.project.business;

import java.util.List;

import org.springframework.stereotype.Component;

import evolent.assign.project.exception.ContactNotFoundException;
import evolent.assign.project.model.ContactDTO;

@Component
public interface ContactBusiness {

	public ContactDTO addContact(ContactDTO contact);
	public List<ContactDTO> getAllContacts();
	public ContactDTO getContactById(long id) throws ContactNotFoundException;
	public boolean updateStatusContactById(long id) throws ContactNotFoundException;
}
