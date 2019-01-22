package kg.apps.CBMapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController
{



	@RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
	public String getWelcomePage(Model model)
	{


		return "welcome";
	}


	@RequestMapping(value = {"/contacts"})
	@ResponseBody
	public Object getContacts(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails= (UserDetails) authentication.getPrincipal();
		return userDetails;

	}
}