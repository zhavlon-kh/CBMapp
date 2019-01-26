package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
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

    User user=new User();

    @Autowired
    public UserDataLoader(UserServiceImpl userService, ContactRepository contactRepository){
        this.userService=userService;
        this.contactRepository=contactRepository;
        loadUsers();
        loadContacts();

    }

    private void loadUsers() {

        user=new User("spring","springspring","Spring","Spring","spring@spring.io",
                "Bishkek","+996555555555",0);

        userService.registerNewUser(user);

    }

    private void loadContacts() {
        //Optional<User> userOptional= userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        //User user;


        //user = userOptional.get();

        Contact contact1=new Contact("Contact1","Contact1","Con1","Comp1",
                Date.from(Instant.now()),user,null,null);

        Contact contact2=new Contact("Contact2","Contact2","Con2","Comp2",
                Date.from(Instant.now()),user,null,null);

        Contact contact3=new Contact("Contact3","Contact3","Con3","Comp3",
                Date.from(Instant.now()),user,null,null);

        contactRepository.save(contact1);
        contactRepository.save(contact2);
        contactRepository.save(contact3);

    }
}
