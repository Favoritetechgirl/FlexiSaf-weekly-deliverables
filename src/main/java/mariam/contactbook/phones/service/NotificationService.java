package mariam.contactbook.phones.service;

import mariam.contactbook.phones.model.Phones;
import mariam.contactbook.phones.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    // Field Injection
    @Autowired
    private PhoneRepository phoneRepository;

    public void sendNumberAddedAlert(Phones contactId) {
        // just a mock notification
        System.out.println("✅ Notification: A new phone number was added for contact ID " + contactId);
    }
}
