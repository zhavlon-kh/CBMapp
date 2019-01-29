package kg.apps.CBMapp.service;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactEmail;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface EmailService {

    void addEmail(ContactEmail contactEmail);

    Set<ContactEmail> selectAllEmailsByContact(Contact contact);

    void addAllEmails(Set<ContactEmail> contactEmails);

    void deleteEmail(ContactEmail contactEmail);

    void deleteEmailById(Long emailId);
}
