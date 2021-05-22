package evolent.assign.project.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import evolent.assign.project.entity.Contact;
import evolent.assign.project.exception.ContactNotFoundException;
import evolent.assign.project.model.Contacts;

@Component
public interface ContactBusiness {

	public Contacts addContact(Contacts contact);
	public List<Contacts> getAllContacts();
	public Contacts getContact(long id) throws ContactNotFoundException;
}
