package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactEmail;
import kg.apps.CBMapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;
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
        model.addAttribute("contact", new Contact());
        return  "form";
    }

    @RequestMapping(value = {"/save","/edit/save"}, method = RequestMethod.POST)
    public String saveContact(HttpServletRequest request) {

        Contact contact = new Contact();
        String idStr =request.getParameter("id");
        Long id = Long.parseLong(idStr);
        if (!Objects.isNull(id) || id!=0) {
            try {
                contact = contactService.getContactById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        contact.setName(request.getParameter("name"));
        contact.setSurname(request.getParameter("surname"));
        contact.setNickname(request.getParameter("nickname"));
        contact.setCompany(request.getParameter("company"));

        String bd = request.getParameter("birthday");
        try {
            Date bdate = dateFormat.parse(bd);
            contact.setBirthday(bdate);
        } catch (ParseException e) {
            System.out.println("Entered Birthdate: "+request.getParameter("birthday"));
            e.printStackTrace();
        }


        //TODO: get emails
        if (!Objects.isNull(request.getParameterValues("newemail"))) {
            for (String email : request.getParameterValues("newemail")) {
                ContactEmail newEmail = new ContactEmail();
                newEmail.setContact(contact);
                newEmail.setEmail(email);
                //TODO: emailService.addEmail;
            }
        }


        //TODO: contact.setMobile();



        contactService.addContact(contact);

        return "redirect:/contacts";

    }

    @RequestMapping(value = "/edit/{id}")
    public String editContact(@PathVariable long id, Model model) throws Exception {

        Contact contact = contactService.getContactById(id);

        String birthday = dateFormat.format(contact.getBirthday());

        Set<ContactEmail> emails = contact.getEmails();

        //model.addAttribute("emails",emails);

        model.addAttribute("birthday", birthday);
        model.addAttribute("contact", contact);
        return "form";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteContact(@PathVariable long id){
        contactService.deleteContactById(id);
        return "redirect:/contacts";
    }

}
