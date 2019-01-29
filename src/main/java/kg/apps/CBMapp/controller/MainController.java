package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.repository.ContactRepository;
import kg.apps.CBMapp.repository.UserRepository;
import kg.apps.CBMapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

	@Autowired
    UserDetailsService userDetailsService;

	@RequestMapping(value = {"/index"}, method = RequestMethod.GET)
	public String getWelcomePage(Model model)
	{
		return "index";
	}

    @RequestMapping(value = {"/","/profile"})
    public String getUsers(Model model){


  User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Optional<User> userOptional = userRepository.findByUsername(authentication.getName());

        User user = userOptional.get();
	    return user;
    }

    @RequestMapping(value = {"/","/welcome"})
    public String getUsers(Model model){
	    User user = getCurrentUser();

        model.addAttribute("user",user);
        return "profile";
    }


    @RequestMapping(value="/editprofile", method=RequestMethod.GET)
    public String getIndex(Model model)
    {

        User user = getCurrentUser();

        model.addAttribute("user",user);

        return "editprofile";

    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String getUserEdit(HttpServletRequest request)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Optional<User> userOptional = userRepository.findByUsername(authentication.getName());
        User userForEdit=userOptional.get();
        userForEdit.setUsername(request.getParameter("username"));
        userForEdit.setName(request.getParameter("name"));
        userForEdit.setSurname(request.getParameter("surname"));
        userForEdit.setAddress(request.getParameter("address"));
        userForEdit.setPhone(request.getParameter("phone"));
        userForEdit.setEmail(request.getParameter("email"));

        userService.registerNewUser(userForEdit);

        return "redirect:/login";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUserById(Integer.parseInt(id));
        return "redirect:/login";
    }

	}

}