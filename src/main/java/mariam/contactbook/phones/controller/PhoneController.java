package mariam.contactbook.phones.controller;

import jakarta.validation.Valid;
import mariam.contactbook.contacts.model.ContactRequest;
import mariam.contactbook.contacts.model.Contacts;
import mariam.contactbook.phones.model.PhoneRequest;
import mariam.contactbook.phones.model.Phones;
import mariam.contactbook.phones.service.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/phones")
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping("/create")
    private ResponseEntity<Phones> createPhoneNumber(@Valid @RequestBody PhoneRequest request){
        return new ResponseEntity<>(phoneService.createPhoneNumber(request), HttpStatus.CREATED);
    }
}
