package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.repository.ContactRepository;
import kg.apps.CBMapp.repository.UserRepository;
import kg.apps.CBMapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController
{

	@Autowired
	UserService userService;

	@Autowired
    UserRepository userRepository;

	@Autowired
    ContactRepository contactRepository;

	/*@RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
	public String getWelcomePage(Model model)
	{


		return "welcome";
	}*/

    @RequestMapping(value = {"/","/welcome"})
    public String getUsers(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Optional<User> userOptional = userRepository.findByUsername(authentication.getName());

        User user = userOptional.get();

        model.addAttribute("user",user);
        return "welcome";
    }


    @RequestMapping(value="/editprofile", method=RequestMethod.GET)
    public String getIndex(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Optional<User> userOptional = userRepository.findByUsername(authentication.getName());

        User user = userOptional.get();

        model.addAttribute("user",user);

        return "editprofile";

    }


	@RequestMapping(value = {"/contact"})
	@ResponseBody
	public List<Contact> getContacts() {
		/*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user= (User) authentication.getPrincipal();

		List<Contact> contacts = userService.userContacts(user);

		String result="";

		for (Contact contact:contacts){
			result=result+"["+contact.getId();
			result+=","+contact.getName();
			result+=","+contact.getSurname()+"]";
		}

		return "{"+result+"}";*/

        List<Contact> contacts = new ArrayList<>();

        List<User> users = userRepository.findAll();

        long i=1;

        Optional<User> userOptional = userRepository.findById(1);

        User user = userOptional.get();

        Contact contact1 = new Contact("Contact1", "Contact1", "Con1", "Comp1",
                null, null, null, null);

        Contact contact2 = new Contact("Contact2", "Contact2", "Con2", "Comp2",
                null, null, null, null);

        Contact contact3 = new Contact("Contact3", "Contact3", "Con3", "Comp3",
                null, null, null, null);

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        return contactRepository.findAllByUser(user);


       /*User user1 = new User();
       user1.setUsername("user1");
       user1.setPassword("user1");
       user1.setName("user1");
       user1.setSurname("user1");

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("user2");
        user2.setName("user2");
        user2.setSurname("user2");

        User user3 = new User();
        user3.setUsername("user3");
        user3.setPassword("user3");
        user3.setName("user3");
        user3.setSurname("user3");

        User user4 = new User();
        user4.setUsername("user4");
        user4.setPassword("user4");
        user4.setName("user4");
        user4.setSurname("user4");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        return users;*/

	}

}