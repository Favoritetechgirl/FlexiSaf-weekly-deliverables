package mariam.contactbook.phones.model;

import jakarta.persistence.*;
import mariam.contactbook.contacts.model.Contacts;
import mariam.contactbook.users.model.Users;

@Entity
@Table(name ="phones")
public class Phones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneId;
    @Column(nullable = false, length = 20)
    private String phoneNumber;
    @Column(length = 20)
    private String type; // e.g., Home, Work, Mobile
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contacts contacts;

    public Phones() {}

    public Phones(int phoneId, String phoneNumber, String type, Contacts contacts) {
        this.phoneId = phoneId;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.contacts = contacts;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }
}
