package mariam.contactbook.phones.service;

import mariam.contactbook.phones.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberValidator {

    private PhoneRepository phoneRepository;

    // Setter Injection
    @Autowired
    public void setPhoneRepository(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }
    public boolean isDuplicate(Integer number) {
        return phoneRepository.existsByNumber(number);
    }
}
