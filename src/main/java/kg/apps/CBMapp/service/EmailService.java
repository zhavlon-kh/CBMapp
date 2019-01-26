package kg.apps.CBMapp.service;

import kg.apps.CBMapp.model.ContactEmail;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface EmailService {

    void addEmail(ContactEmail contactEmail);

    void addAllEmails(Set<ContactEmail> contactEmails);

    void deleteEmail(ContactEmail contactEmail);
}
