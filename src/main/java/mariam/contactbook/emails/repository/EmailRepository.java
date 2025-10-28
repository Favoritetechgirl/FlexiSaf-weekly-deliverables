package mariam.contactbook.emails.repository;

import mariam.contactbook.emails.model.Emails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepository extends JpaRepository<Emails, Long> {
    List<Emails> findByContactsId(Long contactId);
    boolean existsByEmailAddress(String address);
}
