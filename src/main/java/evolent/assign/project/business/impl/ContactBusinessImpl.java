package evolent.assign.project.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import evolent.assign.project.business.ContactBusiness;
import evolent.assign.project.entity.Contact;
import evolent.assign.project.exception.ContactNotFoundException;
import evolent.assign.project.model.ContactDTO;
import evolent.assign.project.service.ContactService;

@Component
public class ContactBusinessImpl implements ContactBusiness {

	@Autowired
	private ContactService contactService;
	
	@Override
	public ContactDTO addContact(ContactDTO contact) {
		ContactDTO contacts = new ContactDTO();
		Contact con = contactService.addContact(contact);
		contacts.setFirstName(con.getFirstName());
		contacts.setLastName(con.getLastName());
		contacts.setMobile(con.getMobile());
		return contacts;
	}

	@Override
	public List<ContactDTO> getAllContacts() {
		List<Contact> contactList = contactService.getAllContacts();
		List<ContactDTO> contactLists = new ArrayList<>();
		contactList.forEach(contact ->{
			ContactDTO cont = new ContactDTO();
			cont.setId(contact.getId());
			cont.setFirstName(contact.getFirstName());
			cont.setLastName(contact.getLastName());
			cont.setMobile(contact.getMobile());
			String status = contact.isStatus() ? "ACTIVE" : "IN-ACTIVE";
			cont.setStatus(status);
			contactLists.add(cont);	
		});
		return contactLists;
	}

	@Override
	public ContactDTO getContactById(long id) throws ContactNotFoundException {
		Optional<Contact> contactEntity = contactService.getContactById(id);
		ContactDTO contact = new ContactDTO();
		if(contactEntity.isPresent()) {
			contact.setId(contactEntity.get().getId());
			contact.setFirstName(contactEntity.get().getFirstName());
			contact.setLastName(contactEntity.get().getLastName());
			contact.setMobile(contactEntity.get().getMobile());
			String status = contactEntity.get().isStatus() ? "ACTIVE" : "IN-ACTIVE";
			contact.setStatus(status);
			
		}else {
			throw new ContactNotFoundException("Invalid Request or Record is not available in our records");
		}
		
		return contact;
		
	}

	@Override
	public boolean updateStatusContactById(long id) throws ContactNotFoundException {
		return contactService.updateStatusContactById(id);
	}

}
