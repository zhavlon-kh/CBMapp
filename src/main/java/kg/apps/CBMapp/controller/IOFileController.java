package kg.apps.CBMapp.controller;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.repository.ContactRepository;
import kg.apps.CBMapp.service.FileService;
import kg.apps.CBMapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Controller
public class IOFileController {



    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    /*@RequestMapping("/expall")
    public ResponseEntity<Object> exportAllUserContacts(HttpServletResponse response) throws Exception {

        String username = userService.getCurrentUser().getUsername();

        String fileName = FileService.now()+username+".json";
        File file = new File("All"+fileName);
        FileWriter writer = new FileWriter(file);

        String jsonString = fileService.getAllUserContactsAsJsonArray().toString();
        writer.write(jsonString);


        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            HttpHeaders headers =new HttpHeaders();
            headers.add("attachment; filename=\"%s\"",file.getName());
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            response.setHeader("Content-Disposition","attachment; filename="+fileName);

            ResponseEntity<Object> responseEntity = ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/txt")).body(resource);
            return responseEntity;

        } catch (FileNotFoundException e) {
            return new ResponseEntity<>("error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            if (file.exists()) file.delete();
            writer.close();
        }

    }


    @Autowired
    ContactRepository contactRepository;

    @RequestMapping("/train")
    @ResponseBody
    public String training() throws Exception {

        Set<Long> idSet = new HashSet<>();
        List<Contact> contacts = userService.getUserContacts(userService.getCurrentUser());

        for (Contact contact :
                contacts) {
            idSet.add(contact.getId());
        }

        List<Contact> cont = contactRepository.findAll(idSet);

        return cont.toString();

        //return fileService.getContactsAsJsonArrayByIds(idSet).toString();
    }*/

}
