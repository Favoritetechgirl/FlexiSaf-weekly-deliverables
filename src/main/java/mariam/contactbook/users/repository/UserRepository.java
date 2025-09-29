package mariam.contactbook.users.repository;

import mariam.contactbook.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
    boolean existsByUserName(String username);
    Optional<Users> findByEmail(String email);
    Optional<Users> findByUserName(String username);
}
