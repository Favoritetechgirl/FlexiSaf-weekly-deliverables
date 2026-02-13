package mariam.contactbook.contacts.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ContactRequest {
    @NotBlank(message = "firstName is required")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "lastName is required")
    @Size(max = 50)
    private String lastName;
    @NotNull(message = "userId is required")
    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
