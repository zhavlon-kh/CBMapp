package kg.apps.CBMapp.service.impl;

import kg.apps.CBMapp.model.ContactEmail;
import kg.apps.CBMapp.repository.ContactEmailRepository;
import kg.apps.CBMapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    ContactEmailRepository contactEmailRepository;

    @Override
    public void addEmail(ContactEmail contactEmail) {

        contactEmailRepository.save(contactEmail);

    }

    @Override
    public void addAllEmails(Set<ContactEmail> contactEmails) {

        for (ContactEmail contactEmail:contactEmails){
            contactEmailRepository.save(contactEmail);
        }

    }

    @Override
    public void deleteEmail(ContactEmail contactEmail) {

        contactEmailRepository.delete(contactEmail);

    }
}
