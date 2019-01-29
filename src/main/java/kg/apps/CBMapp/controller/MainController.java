package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.repository.ContactRepository;
import kg.apps.CBMapp.repository.UserRepository;
import kg.apps.CBMapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController
{

	@Autowired
	UserService userService;

	@Autowired
    UserRepository userRepository;

	@Autowired
    ContactRepository contactRepository;

	@RequestMapping(value = {"/index"}, method = RequestMethod.GET)
	public String getWelcomePage(Model model)
	{
		return "index";
	}

    @RequestMapping(value = {"/","/profile"})
    public String getUsers(Model model){

        model.addAttribute("user",userService.getCurrentUser());
        return "profile";
    }


    @RequestMapping(value="/editprofile", method=RequestMethod.GET)
    public String getIndex(Model model)
    {
        model.addAttribute("user",userService.getCurrentUser());

        return "editprofile";

    }

    @RequestMapping(value="/editprofile/save", method= RequestMethod.POST)
    public String getUserEdit(HttpServletRequest request)
    {
        User userForEdit=userService.getCurrentUser();
        userForEdit.setUsername(request.getParameter("username"));
        userForEdit.setName(request.getParameter("name"));
        userForEdit.setSurname(request.getParameter("surname"));
        userForEdit.setAddress(request.getParameter("address"));
        userForEdit.setPhone(request.getParameter("phone"));
        userForEdit.setEmail(request.getParameter("email"));

        userService.registerNewUser(userForEdit);

        return "redirect:/login";
    }

    @RequestMapping(value = "/profile/delete")
    public String deleteUser(){

	    User user =userService.getCurrentUser();
        userService.deleteUser(user);
        return "redirect:/logout";
    }

}