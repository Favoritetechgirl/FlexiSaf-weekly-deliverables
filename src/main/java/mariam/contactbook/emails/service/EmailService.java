package mariam.contactbook.emails.service;

import mariam.contactbook.contacts.model.Contacts;
import mariam.contactbook.contacts.repository.ContactRepository;
import mariam.contactbook.emails.model.EmailRequest;
import mariam.contactbook.emails.model.Emails;
import mariam.contactbook.emails.repository.EmailRepository;
import mariam.contactbook.exceptions.DuplicateResourceException;
import mariam.contactbook.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    private final EmailRepository emailRepository;
    private final ContactRepository contactRepository;

    public EmailService(EmailRepository emailRepository, ContactRepository contactRepository) {
        this.emailRepository = emailRepository;
        this.contactRepository = contactRepository;
    }

    public Emails addEmail(Integer contactId, EmailRequest request) {
        Contacts contacts = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with ID: " + contactId));

        if (emailRepository.existsByEmailAddress(request.getEmailAddress())) {
            throw new DuplicateResourceException("Email address already exists");
        }

        Emails email = new Emails();
        email.setType(request.getType());
        email.setEmailAddress(request.getEmailAddress());
        email.setContacts(contacts);

        return emailRepository.save(email);
    }

    public List<Emails> getEmailsByContact(Long contactId) {
        return emailRepository.findByContactsId(contactId);
    }

    public Emails updateEmail(Long id, EmailRequest request) {
        Emails email = emailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Email not found with ID: " + id));

        email.setType(request.getType());
        email.setEmailAddress(request.getEmailAddress());
        return emailRepository.save(email);
    }

    public void deleteEmail(Long id) {
        Emails email = emailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Email not found with ID: " + id));

        emailRepository.delete(email);
    }
}
