package mariam.contactbook.phones.repository;

import mariam.contactbook.phones.model.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phones, Long> {
}
