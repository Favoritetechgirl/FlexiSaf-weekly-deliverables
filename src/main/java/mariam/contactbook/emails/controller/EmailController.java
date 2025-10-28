package mariam.contactbook.emails.controller;

import jakarta.validation.Valid;
import mariam.contactbook.emails.model.EmailRequest;
import mariam.contactbook.emails.model.Emails;
import mariam.contactbook.emails.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emails")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/create")
    public ResponseEntity<Emails> createEmail(@PathVariable Integer contactId,
                                              @Valid @RequestBody EmailRequest request) {
        Emails created = emailService.addEmail(contactId, request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @GetMapping("/get}")
    public ResponseEntity<List<Emails>> getEmails(@PathVariable Long contactId) {
        List<Emails> emails = emailService.getEmailsByContact(contactId);
        return ResponseEntity.ok(emails);
    }
    @PutMapping("/update")
    public ResponseEntity<Emails> updateEmail(
            @PathVariable Long id,
            @Valid @RequestBody EmailRequest request) {
        Emails updated = emailService.updateEmail(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }
}
