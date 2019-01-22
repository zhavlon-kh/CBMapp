package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * This class adds just some initial data to database
 */
@Component
public class DataLoader {
    private UserServiceImpl userService;




    @Autowired
    public DataLoader(UserServiceImpl userService){
        this.userService=userService;
        LoadUsers();
    }

    private void LoadUsers() {

        User user=new User("spring","springspring","Spring","Spring","spring@spring.io",
                "Bishkek","+996555555555",0);


        Contact contact1=new Contact("Contact1","Contact1","Con1","Comp1",
                null,user,null,null);

        Contact contact2=new Contact("Contact2","Contact2","Con2","Comp2",
                null,user,null,null);

        Contact contact3=new Contact("Contact3","Contact3","Con3","Comp3",
                null,user,null,null);

        List<Contact> contacts=new ArrayList<>();

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        user.setContacts(contacts);
        userService.registerNewUser(user);

    }
}
