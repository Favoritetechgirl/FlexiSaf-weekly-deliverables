package mariam.contactbook.emails.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmailRequest {
    @NotBlank(message = "Email type is required")
    private String type;
    @Email(message = "Please enter a valid email address")
    @NotBlank(message = "Email address cannot be blank")
    private String emailAddress;
    @NotNull(message = "contactId is required")
    private int contactId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}
