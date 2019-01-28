package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactEmail;
import kg.apps.CBMapp.service.ContactService;
import kg.apps.CBMapp.service.EmailService;
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

    @Autowired

    private EmailService emailService;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dateFormat2 =new SimpleDateFormat("dd-MMMMM-yyyy");

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


    @RequestMapping(value = {"/",""})
    public String getContacts(Model model){


        model.addAttribute("dateFormat",dateFormat2);
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

        Set<ContactEmail> emails = new HashSet<>();
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



        contactService.addContact(contact);

        //get emails


        Set<ContactEmail> contactEmails =emailService.selectAllEmailsByContact(contact);
        ArrayList<Long> emailsId=new ArrayList<>();
        ArrayList<String> emailsString = new  ArrayList<>();
        emailsString.addAll(Arrays.asList(request.getParameterValues("emails")));

        Set<Integer> dltdIndx=new HashSet<>();



        if (!Objects.isNull(request.getParameterValues("emailsid"))){
            String[] emailsIdStr= request.getParameterValues("emailsid");
            for (String emailId: emailsIdStr){
                emailsId.add(Long.parseLong(emailId));

            }
        }

        for (int k=0; k<emailsString.size(); k++){
            if (emailsString.get(k)==""){
                if (emailsId.size()>k)
                    emailsId.remove(k);
                emailsString.remove(k);
                dltdIndx.add(k);
            }
        }

        if (emailsId.size()<contactEmails.size()){
            for (ContactEmail email: contactEmails){
                boolean deleted =true;
                for (Long emailId:emailsId ){
                    if (emailId==email.getId()){
                        deleted=false;
                    }
                }
                if (deleted){
                    emailService.deleteEmailById(email.getId());
                }

            }
        }

        Set<ContactEmail> emailsAfterDeleted =emailService.selectAllEmailsByContact(contact);


        if (!Objects.isNull(emailsString)) {
            int i;

            for (i=0;i<emailsString.size();i++){


                if((!Objects.isNull(emailsString.get(i)) && emailsString.get(i)!="")){
                    ContactEmail contactEmail = new ContactEmail();

                    if (emailsId.size()>i){
                        contactEmail.setId(emailsId.get(i));
                    }

                    contactEmail.setContact(contact);

                    String stringEmail = emailsString.get(i);

                    contactEmail.setEmail(stringEmail);

                    emailService.addEmail(contactEmail);

                    emails.add(contactEmail);
                }

            }

            contact.setEmails(emails);

        }


        //TODO: contact.setMobile();




        contactService.addContact(contact);

        return "redirect/contacts:";

    }

    @RequestMapping(value = "/edit/{id}")
    public String editContact(@PathVariable long id, Model model) throws Exception {

        List<Contact> userContacts=contactService.selectUserContacts();

        boolean userContact = false;

        for (Contact contact:userContacts){
            if (contact.getId()==id){
                userContact=true;
            }
        }

        if (userContact){

            Contact contact = contactService.getContactById(id);

            String birthday = dateFormat.format(contact.getBirthday());

            Set<ContactEmail> emails = contact.getEmails();

            //model.addAttribute("emails",emails);

            model.addAttribute("birthday", birthday);
            model.addAttribute("contact", contact);
            return "form";
        } else {throw new Exception("Trying to get contact with id: "+id);}
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteContact(@PathVariable long id){
        contactService.deleteContactById(id);
        return "redirect:/contacts";
    }

}
