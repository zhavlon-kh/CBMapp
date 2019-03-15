package kg.apps.CBMapp.service;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    void registerNewUser(User newUser);

    List<Contact> getUserContacts(User user);

    boolean deleteUserById(int userId);

    boolean deleteUser(User user);

    User getUserById(int userId);

    User getCurrentUser();

}
