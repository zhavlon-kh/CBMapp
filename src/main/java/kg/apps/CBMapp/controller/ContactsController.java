package kg.apps.CBMapp.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping(value = {"contacts"})
public class ContactsController {

    @Autowired
    ContactService contactService;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


    @RequestMapping(value = {"/",""})
    public String getContacts(Model model){

            model.addAttribute("contacts",contactService.selectUserContacts());
            return "contacts";
    }

    @RequestMapping("/form")
    public String contactForm(Model model){
        model.addAttribute("command", new Contact());
        return  "form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveContact(HttpServletRequest request, @PathVariable Contact contact) {

        String bd =request.getParameter("birthday");
        try {
            Date bdate = dateFormat.parse(bd);
            contact.setBirthday(bdate);
        } catch (ParseException e) {
            System.out.println("Entered Birthdate: "+request.getParameter("birthday"));
            e.printStackTrace();
        }


        contactService.addContact(contact);

        return "redirect:/contacts";

    }

    @RequestMapping(value = "/edit/{id}")
    public String editContact(@PathVariable long id, Model model) throws Exception {
        Contact contact = contactService.getContactById(id);

        model.addAttribute("command", contact);
        return "form";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteContact(@PathVariable long id){
        contactService.deleteContactById(id);
        return "redirect:/contacts";
    }

}
