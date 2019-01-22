package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.repository.ContactRepository;
import kg.apps.CBMapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
public class ContactDataLoader {

    /*@Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ContactDataLoader(ContactRepository contactRepository){
        this.contactRepository=contactRepository;

        loadData();
    }

    private void loadContacts() {
        Optional<User> userOptional= userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        User user;


        user = userOptional.get();

        Contact contact1=new Contact("Contact1","Contact1","Con1","Comp1",
                null,user,null,null);

        Contact contact2=new Contact("Contact2","Contact2","Con2","Comp2",
                null,user,null,null);

        Contact contact3=new Contact("Contact3","Contact3","Con3","Comp3",
                null,user,null,null);

        contactRepository.save(contact1);
        contactRepository.save(contact2);
        contactRepository.save(contact3);

    }*/


}
