package evolent.assign.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import evolent.assign.project.business.ContactBusiness;
import evolent.assign.project.exception.ContactNotFoundException;
import evolent.assign.project.model.Contacts;

@RestController
@RequestMapping("/api/")
public class ContactController {

	@Autowired
	private ContactBusiness contactBusiness;
	
	@PostMapping("/contact")
	public Contacts createContact(@RequestBody Contacts contacts) {
		return contactBusiness.addContact(contacts);
	}
	
	@GetMapping("contact/{id}")
	public ResponseEntity<Contacts> getContactById(@PathVariable(value = "id") long id) throws ContactNotFoundException{
		Contacts contacts = contactBusiness.getContact(id);
		return ResponseEntity.ok().body(contacts);
		
	}
	
	@GetMapping("/allcontacts")
	public List<Contacts> getAllContactInfo(){
		return contactBusiness.getAllContacts();
	}
	
}
