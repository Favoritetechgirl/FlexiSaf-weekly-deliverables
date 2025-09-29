package mariam.contactbook.contacts.service;

import jakarta.transaction.Transactional;
import mariam.contactbook.contacts.model.ContactRequest;
import mariam.contactbook.contacts.model.Contacts;
import mariam.contactbook.contacts.repository.ContactRepository;
import mariam.contactbook.exceptions.ResourceNotFoundException;
import mariam.contactbook.users.model.Users;
import mariam.contactbook.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private final ContactRepository contactRepository;
    private final UserRepository userRepository;
    public ContactService(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public Contacts createContact(ContactRequest request) {
        Users user = userRepository.findByUserName(request.getFirstName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found " ));

        Contacts contact = new Contacts();
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setUsers(user);

        return contactRepository.save(contact);
    }
    public Contacts getContactByFirstName(String name) {
        return contactRepository.findByFirstName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
    }
    @Transactional
    public Contacts updateContact(ContactRequest request, String name) {
        Contacts update = contactRepository.findByFirstName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found"));

        update.setFirstName(request.getFirstName());
        update.setLastName(request.getLastName());

        return contactRepository.save(update);
    }
    @Transactional
    public void deleteContact(String name) {
        Contacts delete = contactRepository.findByFirstName(name)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + name));
        contactRepository.delete(delete);
    }
}
