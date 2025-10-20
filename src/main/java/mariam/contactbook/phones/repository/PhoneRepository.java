package mariam.contactbook.phones.repository;

import mariam.contactbook.phones.model.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phones, Long> {
    boolean existsByContactIdAndPhone(Integer contactId, String phone);
    List<Phones> findAllByContactId(Long contactId);

    boolean existsByNumber(Integer number);
}
