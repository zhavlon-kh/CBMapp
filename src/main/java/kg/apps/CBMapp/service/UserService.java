package kg.apps.CBMapp.service;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<Contact> userContacts(User user);
}
