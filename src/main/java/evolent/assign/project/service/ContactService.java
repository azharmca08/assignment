package evolent.assign.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import evolent.assign.project.entity.Contact;
import evolent.assign.project.model.Contacts;

@Component
public interface ContactService {

	public Contact addContact(Contacts contact);
	public List<Contact> getAllContacts();
	public Optional<Contact> getContact(long id);
	
}
