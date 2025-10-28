package mariam.contactbook.emails.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import mariam.contactbook.contacts.model.Contacts;

@Entity
@Table(name ="emails")
public class Emails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    @NotBlank(message = "Email type is required")
    private String type; // e.g., "work", "personal"

    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email address cannot be blank")
    private String emailAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contacts contacts;

    public Emails() {}

    public Emails(Long emailId, String type, String emailAddress, Contacts contacts) {
        this.emailId = emailId;
        this.type = type;
        this.emailAddress = emailAddress;
        this.contacts = contacts;
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

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

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }
}
