package mariam.contactbook.users.service;

import jakarta.transaction.Transactional;
import mariam.contactbook.exceptions.DuplicateResourceException;
import mariam.contactbook.exceptions.ResourceNotFoundException;
import mariam.contactbook.users.model.UserRequest;
import mariam.contactbook.users.model.Users;
import mariam.contactbook.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Users createUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already in use" + request.getEmail());
        }
        if (userRepository.existsByUserName(request.getUsername())) {
            throw new DuplicateResourceException(request.getUsername() + "Username already in use");
        }

        Users users = new Users();
        users.setUserName(request.getUsername());
        users.setEmail(request.getEmail());
        users.setPassword(request.getPassword());
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setDateOfBirth(request.getDateOfBirth());
        users.setGender(request.getGender());
        users.setStatus(request.getStatus());

        return userRepository.save(users);
    }

    public List<Users> getAll() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserByEmail(String email) {
        Users users = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return Optional.ofNullable(users);
    }

    public Optional<Users> getUserByUsername(String username) {
        Users users = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return Optional.ofNullable(users);
    }

    @Transactional
    public Users updateUser(UserRequest request, String username) {
        Users update = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (!update.getEmail().equalsIgnoreCase(request.getEmail()) && userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already in use" + request.getEmail());
        }
        if (!update.getUserName().equalsIgnoreCase(request.getUsername()) && userRepository.existsByUserName(request.getUsername())) {
            throw new DuplicateResourceException("Username already in use" + request.getUsername());
        }
        update.setUserName(request.getUsername());
        update.setEmail(request.getEmail());
        update.setPassword(request.getPassword());
        update.setFirstName(request.getFirstName());
        update.setLastName(request.getLastName());
        update.setDateOfBirth(request.getDateOfBirth());
        update.setGender(request.getGender());
        update.setStatus(request.getStatus());

        return userRepository.save(update);
    }

    @Transactional
    public void deleteUser(String username) {
        Users delete = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));
        userRepository.delete(delete);
    }
}
