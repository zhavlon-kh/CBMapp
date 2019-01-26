package kg.apps.CBMapp.service.impl;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.security.CustomUserDetails;
import kg.apps.CBMapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private UserRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> optionalUsers = usersRepository.findByUsername(username);

        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(CustomUserDetails::new).get();
    }
    
    public void registerNewUser(User newUser)
    {
    	usersRepository.save(newUser);
    }


    @Override
    public List<Contact> userContacts(User user) {

        List<Contact> userContacts = new ArrayList<>();
        userContacts.addAll(user.getContacts());

        return userContacts;
    }
}