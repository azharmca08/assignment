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
import evolent.assign.project.model.ContactDTO;

@RestController
@RequestMapping("/api/")
public class ContactController {

	@Autowired
	private ContactBusiness contactBusiness;
	
	@PostMapping("/contact")
	public ContactDTO createContact(@RequestBody ContactDTO contacts) {
		return contactBusiness.addContact(contacts);
	}
	
	@GetMapping("contact/{id}")
	public ResponseEntity<ContactDTO> getContactById(@PathVariable(value = "id") long id) throws ContactNotFoundException{
		ContactDTO contacts = contactBusiness.getContactById(id);
		return ResponseEntity.ok().body(contacts);
		
	}
	@PostMapping("contact/{id}")
	public String updateStatusContactById(@PathVariable(value = "id") long id) throws ContactNotFoundException{
		boolean isStatus = contactBusiness.updateStatusContactById(id);
		String message  =  isStatus == true ? "Updated successfully" : "No record found and update not successfully";
		return message;
		
	}
	@GetMapping("/allcontacts")
	public List<ContactDTO> getAllContactInfo(){
		return contactBusiness.getAllContacts();
	}
	
}
