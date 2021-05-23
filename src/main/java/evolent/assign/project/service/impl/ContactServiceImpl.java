package evolent.assign.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import evolent.assign.project.entity.Contact;
import evolent.assign.project.model.ContactDTO;
import evolent.assign.project.repository.ContactRepository;
import evolent.assign.project.service.ContactService;

@Component
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repo;

	@Override
	public Contact addContact(ContactDTO contacts) {
		Contact contact = new Contact();
		contact.setFirstName(contacts.getFirstName());
		contact.setLastName(contacts.getLastName());
		contact.setMobile(contacts.getMobile());
		contact.setStatus(true);
		return repo.save(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public Optional<Contact> getContactById(long id) {
		return repo.findById(id);
	}

	@Override
	public boolean updateStatusContactById(long id) {
		Optional<Contact> contact = repo.findById(id);
		if(contact.isPresent()) {
			Contact con = new Contact();
			con.setId(contact.get().getId());
			con.setFirstName(contact.get().getFirstName());
			con.setLastName(contact.get().getLastName());
			con.setMobile(contact.get().getMobile());
			con.setStatus(false);
			repo.save(con);
			return true;
		}	
		return false;
	}

}
