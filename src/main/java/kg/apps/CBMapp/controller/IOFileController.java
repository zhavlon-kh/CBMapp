package kg.apps.CBMapp.controller;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.repository.ContactRepository;
import kg.apps.CBMapp.service.ContactService;
import kg.apps.CBMapp.service.FileService;
import kg.apps.CBMapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
public class IOFileController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @Autowired
    private ContactService contactService;

    @RequestMapping("/expall")
    public ResponseEntity<Object> exportAllUserContacts(HttpServletResponse response) throws Exception {

        String username = userService.getCurrentUser().getUsername();

        String fileName = FileService.now()+username+".json";
        File file = new File("All"+fileName);
        FileWriter writer = new FileWriter(file);

        String jsonString = fileService.getAllUserContactsAsJsonArray().toString();
        writer.write(jsonString);
        writer.close();


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
            writer.close();
            if (file.exists()) file.delete();
        }

    }

    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public String getImport(){
        return "import";
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String handleImport(@RequestParam("file") MultipartFile file, RedirectAttributes attributes){

        if(fileService.storeFile(file)){
            attributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");
        }else {
            attributes.addFlashAttribute("message",
                    "There are some problem with uploading file: " + file.getOriginalFilename() + "!");
        }

        return "redirect:/contacts";
    }

    @PostMapping("/explist")
    public String makeFileToExportByList(HttpServletRequest request) throws Exception{
        String username = userService.getCurrentUser().getUsername();
        String fileName = FileService.now()+username+".json";
        String[] idsString = request.getParameterValues("ids");

        Set<Long> idSet = new TreeSet<>();
        for (String idStr:idsString){
            idSet.add(Long.parseLong(idStr));
        }

        String export = request.getParameter("export");
        String delete = request.getParameter("delete");

        if (Objects.isNull(export) && !(Objects.isNull(delete))){
            if (idsString.length==0) return "redirect:/contacts";

            for (long id:idSet){
                contactService.deleteContactById(id);
            }

            return "redirect:/contacts";
        }

        if (idsString.length==0){
            return "redirect:/expall";
        }

        File file = new File(fileName);
        String jsonString = fileService.getContactsAsJsonArrayByIds(idSet).toString();

        FileWriter writer = new FileWriter(file);
        writer.write(jsonString);
        writer.close();

        return "redirect:/explist/"+fileName;
    }

    @GetMapping("/explist/{filename}")
    public ResponseEntity<Object> exportFileWithName(@PathVariable("filename") String fileName, HttpServletResponse response){
        File file= new File(fileName);


        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            HttpHeaders headers =new HttpHeaders();
            headers.add("attachment; filename=\"%s\"",file.getName());
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            headers.set("Content-Disposition","attachment; filename="+fileName);

            ResponseEntity<Object> responseEntity = ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/txt")).body(resource);
            return responseEntity;

        } catch (FileNotFoundException e) {
            return new ResponseEntity<>("error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            if (file.exists()) file.delete();
        }


    }


    //***** Training :D *******//

    /*@Autowired
    ContactService contactService;

    @RequestMapping("/train")
    @ResponseBody
    public List<Contact> getContactsById(){

        List<Contact> allContacts = userService.getUserContacts(userService.getCurrentUser());
        Long[] idSet = new Long[2];

        idSet[0]=allContacts.get(0).getId();
        idSet[1]=allContacts.get(1).getId();

        try {
            return contactService.getAllContactsWithIds(idSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
