package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactEmail;

import kg.apps.CBMapp.model.ContactMobile;
import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.repository.ContactEmailRepository;
import kg.apps.CBMapp.repository.ContactMobileRepository;

import kg.apps.CBMapp.repository.ContactRepository;
import kg.apps.CBMapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;


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
    @Autowired
    private ContactMobileRepository mobileRepository;


    private User user=new User();
    private User user2=new User();
    private Contact contact1=new Contact();
    private Contact contact2=new Contact();
    private Contact contact3=new Contact();
    private ContactEmail email1=new ContactEmail();
    private ContactEmail email2=new ContactEmail();
    private ContactEmail email3=new ContactEmail();
    private ContactEmail email4=new ContactEmail();
    private ContactMobile mobile1 = new ContactMobile();
    private ContactMobile mobile2 = new ContactMobile();
    private ContactMobile mobile3 = new ContactMobile();
    private ContactMobile mobile4 = new ContactMobile();


    @Autowired
    public UserDataLoader(UserServiceImpl userService, ContactRepository contactRepository, ContactEmailRepository emailRepository, ContactMobileRepository mobileRepository){
        this.userService=userService;
        this.contactRepository=contactRepository;
        this.emailRepository=emailRepository;
        this.mobileRepository=mobileRepository;
        loadUsers();
        loadContacts();
        loadEmails();
        loadMobiles();

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

    void loadMobiles(){
        mobile1=new ContactMobile("+996555532561",contact1);
        mobile2=new ContactMobile("+996550532562",contact2);
        mobile3=new ContactMobile("+996551532563",contact3);
        mobile4=new ContactMobile("+996552532564",contact1);

        mobileRepository.save(mobile1);
        mobileRepository.save(mobile2);
        mobileRepository.save(mobile3);
        mobileRepository.save(mobile4);
    }


}
