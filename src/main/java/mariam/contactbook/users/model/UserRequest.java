package mariam.contactbook.users.model;

import jakarta.validation.constraints.*;
import mariam.contactbook.Gender;
import mariam.contactbook.Status;

import java.time.LocalDate;

public class UserRequest {
    @NotBlank(message = "username is required")
    @Size(min = 3, max = 50, message = "username must be 3..50 chars")
    private String username;

    @NotBlank(message = "email is required")
    @Email(message = "must be a valid email")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 8, message = "password must be at least 8 characters")
    private String password;

    @NotBlank(message = "first name is required")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "last name is required")
    @Size(max = 50)
    private String lastName;

    @Past(message = "dateOfBirth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "gender is required")
    private Gender gender;
    @NotNull(message = "status is required")
    private Status status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
