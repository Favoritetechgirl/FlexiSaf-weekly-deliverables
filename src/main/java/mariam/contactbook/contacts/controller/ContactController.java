package mariam.contactbook.contacts.controller;

import mariam.contactbook.contacts.model.ContactRequest;
import mariam.contactbook.contacts.model.Contacts;
import mariam.contactbook.contacts.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {
    private final ContactService contactService;
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @PostMapping("/create")
    private ResponseEntity<Contacts> createContact(@RequestBody ContactRequest request){
        return new ResponseEntity<>(contactService.createContact(request), HttpStatus.CREATED);
    }
    @GetMapping("/get/{name}")
    private ResponseEntity<Contacts> getContactsByFirstName(@PathVariable String name){
        return new ResponseEntity<>(contactService.getContactByFirstName(name), HttpStatus.OK);
    }
    @PutMapping("/update")
    private ResponseEntity<Contacts> updateContacts(@RequestBody ContactRequest request, @RequestParam String name){
        return new ResponseEntity<>(contactService.updateContact(request, name), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete")
    private ResponseEntity<Void> deleteContact(@PathVariable String name){
       contactService.deleteContact(name);
       return new ResponseEntity<>(HttpStatus.OK);
    }
}
