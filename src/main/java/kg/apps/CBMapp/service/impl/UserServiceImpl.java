package kg.apps.CBMapp.service.impl;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.security.CustomUserDetails;
import kg.apps.CBMapp.service.ContactService;
import kg.apps.CBMapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactService contactService;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> optionalUsers = userRepository.findByUsername(username);

        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(CustomUserDetails::new).get();
    }

    @Override
    public void registerNewUser(User newUser)
    {
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
    }

    @Override
    public List<Contact> getUserContacts(User user) {

        List<Contact> userContacts = new ArrayList<>();
        userContacts.addAll(user.getContacts());

        return userContacts;
    }



    @Override
    public boolean deleteUserById(int userId) {

        User user = getCurrentUser();


        if (getCurrentUser().getId()==userId) {

            return deleteUser(user);

        }
        return false;
    }

    @Override
    public User getUserById(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.get();
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Optional<User> userOptional = userRepository.findByUsername(authentication.getName());

        User user = userOptional.get();

        return user;
    }

    @Override
    public boolean deleteUser(User user) {

        List<Contact> contacts = this.getUserContacts(user);

        contactService.deleteContacts(contacts);

        userRepository.delete(user);

        return true;

    }
}