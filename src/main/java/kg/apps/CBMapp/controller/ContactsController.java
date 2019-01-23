package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"contacts"})
public class ContactsController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = {"/",""})
    public String getContacts(Model model){

        model.addAttribute("contacts",contactService.selectUserContacts());

        return "contacts";
    }

    @RequestMapping("/form")
    public String contactForm(Model model){
        model.addAttribute("newContact", new Contact());
        return  "form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute("contact") Contact contact){
        contactService.addContact(contact);

        return "redirect:/";

    }

    @RequestMapping(value = "")
}
