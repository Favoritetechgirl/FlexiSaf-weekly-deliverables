package mariam.contactbook.phones.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PhoneRequest {
    @NotBlank(message = "phone is required")
    @Size(min = 7, max = 20)
    private String phoneNumber;

    @Size(max = 20)
    private String type;

    @NotNull(message = "contactId is required")
    private int contactId;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}
