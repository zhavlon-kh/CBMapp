package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactsController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = {"/contacts"})
    public String getContacts(Model model){

        model.addAttribute("contacts",contactService.selectUserContacts());

        return "contacts";
    }
}
