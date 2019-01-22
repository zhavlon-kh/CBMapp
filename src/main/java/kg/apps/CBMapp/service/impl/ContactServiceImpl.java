package kg.apps.CBMapp.service.impl;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.repository.ContactRepository;
import kg.apps.CBMapp.repository.UserRepository;
import kg.apps.CBMapp.service.ContactService;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    /*@Autowired
    private UserRepository userRepository;*/

    @Override
    public List<Contact> selectUserContacts() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //List<Contact> contacts= contactRepository.findAllByUser(authentication.getName());
        //List<Contact> userContacts = new ArrayList<>();

        /*for (Contact contact:contacts){
            if (contact.getUser().getId()==user.getId()){
                userContacts.add(contact);
            }
        }*/

        //userContacts.addAll(contactRepository.findAllByUser(user));


        return null;
    }
}
