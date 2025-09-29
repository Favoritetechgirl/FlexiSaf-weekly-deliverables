package mariam.contactbook.contacts.repository;

import mariam.contactbook.contacts.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contacts, Integer> {
    Optional<Contacts> findByFirstName(String firstName);
}
