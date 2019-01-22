package kg.apps.CBMapp.service;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

    List<Contact> selectUserContacts(User user);

}
