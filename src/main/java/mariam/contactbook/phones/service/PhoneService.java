package mariam.contactbook.phones.service;

import jakarta.transaction.Transactional;
import mariam.contactbook.contacts.model.Contacts;
import mariam.contactbook.contacts.repository.ContactRepository;
import mariam.contactbook.exceptions.DuplicateResourceException;
import mariam.contactbook.exceptions.ResourceNotFoundException;
import mariam.contactbook.phones.model.PhoneRequest;
import mariam.contactbook.phones.model.Phones;
import mariam.contactbook.phones.repository.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;
    private final ContactRepository contactRepository;
    private final PhoneNumberValidator phoneNumberValidator;

    public PhoneService(PhoneRepository phoneRepository, ContactRepository contactRepository, PhoneNumberValidator phoneNumberValidator) {
        this.phoneRepository = phoneRepository;
        this.contactRepository = contactRepository;
        this.phoneNumberValidator = phoneNumberValidator;
    }

    @Transactional
    public Phones createPhoneNumber(PhoneRequest request) {
        Contacts contacts = contactRepository.findById(request.getContactId())
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found "));

        if (phoneRepository.existsByContactIdAndPhone(request.getContactId(), request.getPhoneNumber())) {
            throw new DuplicateResourceException("Phone number already exists for this contact");
        }

        Phones phones = new Phones();
        phones.setPhoneNumber(request.getPhoneNumber());
        phones.setType(request.getType());
        phones.setContacts(contacts);

        return phoneRepository.save(phones) ;
    }



}
