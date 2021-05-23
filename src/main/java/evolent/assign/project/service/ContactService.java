package evolent.assign.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import evolent.assign.project.entity.Contact;
import evolent.assign.project.model.ContactDTO;

@Component
public interface ContactService {

	public Contact addContact(ContactDTO contact);
	public List<Contact> getAllContacts();
	public Optional<Contact> getContactById(long id);
	public boolean updateStatusContactById(long id);
}
