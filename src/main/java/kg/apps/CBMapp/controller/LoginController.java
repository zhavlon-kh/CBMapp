package kg.apps.CBMapp.controller;

import javax.servlet.http.HttpServletRequest;

import kg.apps.CBMapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class LoginController
{
	@Autowired
    private UserServiceImpl userDetailsService;

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"", "/", "/login"}, method = RequestMethod.GET)
	public String getLoginPage()
	{
		try {
			User user = userService.getCurrentUser();
			return "index";
		} catch (Exception e){
			return "login";
		}
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String registerUser(HttpServletRequest request)
	{
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		//String usertype = request.getParameter("usertype");
		
		if(password1 != null && password2 != null && password1.equals(password2))
		{
			try
			{
				
				User newUser = new User();
				newUser.setName(name);
				newUser.setSurname(lastname);
				newUser.setEmail(email);
				newUser.setUsername(username);
				newUser.setPassword(password1);
				//newUser.setRoles(roleSet);
				
				userDetailsService.registerNewUser(newUser);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		return "login";
	}

	@RequestMapping(value = {"/user"},method = RequestMethod.GET)
	@ResponseBody
	public String currentUser(Principal principal){
		return principal.getName();
	}
}