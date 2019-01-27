package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactEmail;
import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.repository.ContactEmailRepository;
import kg.apps.CBMapp.repository.ContactRepository;
import kg.apps.CBMapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * This class adds just some initial data to database
 */
@Component
public class UserDataLoader {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
            private ContactEmailRepository emailRepository;

    private User user=new User();
    private User user2=new User();
    private Contact contact1=new Contact();
    private Contact contact2=new Contact();
    private Contact contact3=new Contact();
    private ContactEmail email1=new ContactEmail();
    private ContactEmail email2=new ContactEmail();
    private ContactEmail email3=new ContactEmail();
    private ContactEmail email4=new ContactEmail();


    @Autowired
    public UserDataLoader(UserServiceImpl userService, ContactRepository contactRepository, ContactEmailRepository emailRepository){
        this.userService=userService;
        this.contactRepository=contactRepository;
        this.emailRepository=emailRepository;
        loadUsers();
        loadContacts();
        loadEmails();

    }

    private void loadUsers() {

        user=new User("spring","springspring","Spring","Spring","spring@spring.io",
                "Bishkek","+996555555555",0);
        user2=new User("spring2","springspring","Spring2","Spring2","spring2@spring.io",
                "Bishkek","+996555555555",0);

        userService.registerNewUser(user);
        userService.registerNewUser(user2);
    }

    private void loadContacts() {
        //Optional<User> userOptional= userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        //User user;


        //user = userOptional.get();

        contact1 = new Contact("Contact1", "Contact1", "Con1", "Comp1",
                Date.from(Instant.now()), user, null, null);

        contact2 = new Contact("Contact2", "Contact2", "Con2", "Comp2",
                Date.from(Instant.now()), user, null, null);

        contact3 = new Contact("Contact3", "Contact3", "Con3", "Comp3",
                Date.from(Instant.now()), user2, null, null);

        contactRepository.save(contact1);
        contactRepository.save(contact2);
        contactRepository.save(contact3);
    }


    void loadEmails(){
        email1=new ContactEmail("contact1@gmail.com",contact1);
        email2=new ContactEmail("contact2@gmail.com",contact2);
        email3=new ContactEmail("contact3@gmail.com",contact3);
        email4=new ContactEmail("contact1-second@gmail.com",contact1);

        emailRepository.save(email1);
        emailRepository.save(email2);
        emailRepository.save(email3);
        emailRepository.save(email4);
    }


}
