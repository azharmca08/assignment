package evolent.assign.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import evolent.assign.project.entity.Contact;
import evolent.assign.project.model.Contacts;
import evolent.assign.project.repository.ContactRepository;
import evolent.assign.project.service.ContactService;

@Component
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repo;

	@Override
	public Contact addContact(Contacts contacts) {
		Contact contact = new Contact();
		contact.setFirstName(contacts.getFirstName());
		contact.setLastName(contacts.getLastName());
		contact.setMobile(contacts.getMobile());
		contact.setStatus(contacts.isStatus());
		return repo.save(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public Optional<Contact> getContact(long id) {
		return repo.findById(id);
	}

}
