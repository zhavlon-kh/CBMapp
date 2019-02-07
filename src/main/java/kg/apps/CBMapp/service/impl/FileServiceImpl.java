package kg.apps.CBMapp.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactEmail;
import kg.apps.CBMapp.model.ContactMobile;
import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.service.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FileServiceImpl implements FileService
 {

    @Autowired
    UserService userService;

    @Autowired
    ContactService contactService;

    @Autowired
     EmailService emailService;

    @Autowired
     MobileService mobileService;

     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public JSONArray getAllUserContactsAsJsonArray() throws Exception {

        User user = userService.getCurrentUser();

        List<Contact> contacts = userService.getUserContacts(user);

        JSONArray jsonElements = getJSONArrayOfContacts(contacts);

        return jsonElements;
    }

    @Override
    public JSONArray getContactsAsJsonArrayByIds(Set<Long> idSet) throws Exception {

        User user = userService.getCurrentUser();

        List<Contact> contacts = contactService.getAllContactsWithIds(idSet);

        ObjectMapper mapper = new ObjectMapper();



        String jsonString = mapper.writeValueAsString(contacts);

        JSONArray jsonElements = new JSONArray(jsonString);

        removeIdsFromJson(jsonElements);

        return jsonElements;
    }


     @Override
     public boolean storeFile(MultipartFile getFile) {

        User user = userService.getCurrentUser();

        try {
            File file = new File(getFile.getOriginalFilename());

            file.createNewFile();

            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(getFile.getBytes());
            outputStream.close();

            FileInputStream inputStream = new FileInputStream(file.toString());
            byte[] buffer = new byte[10];
            StringBuilder stringBuilder = new StringBuilder();
            while (inputStream.read(buffer)!=-1){
                stringBuilder.append(new String(buffer));
                buffer =new byte[10];
            }

            inputStream.close();

            String jsonString = stringBuilder.toString();

            //jsonString = jsonString.substring(0,jsonString.length()-3);
            //jsonString.replace("","");

            JSONArray jsonArray = new JSONArray(jsonString);
            List<Contact> contacts = new ArrayList<>();
            Set<ContactEmail> emails = new HashSet<>();


            for (int i=0;i<jsonArray.length();i++){
                Contact contact = new Contact();

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                contact.setUser(user);
                contact.setBirthday(dateFormat.parse(jsonObject.getString("birthday")));
                contact.setCompany(jsonObject.getString("company"));
                contact.setName(jsonObject.getString("name"));
                contact.setSurname(jsonObject.getString("surname"));
                contact.setNickname(jsonObject.getString("nickname"));

                contactService.addContact(contact);

                JSONArray jsonEmails = jsonObject.getJSONArray("emails");
                JSONArray jsonMobiles = jsonObject.getJSONArray("mobiles");
                for (int j=0;j<jsonEmails.length();j++){
                    JSONObject jsonEmail = jsonEmails.getJSONObject(j);
                    ContactEmail email =new ContactEmail();
                    email.setContact(contact);
                    email.setEmail(jsonEmail.getString("email"));
                    emailService.addEmail(email);
                }

                for (int k=0; k<jsonMobiles.length(); k++){
                    JSONObject jsonMobile = jsonMobiles.getJSONObject(k);
                    ContactMobile mobile = new ContactMobile();
                    mobile.setContact(contact);
                    mobile.setPhoneNumber(jsonMobile.getString("phoneNumber"));
                    mobileService.addMobile(mobile);
                }


            }

            return true;

        }catch (Exception e){
            return false;
        }


     }

     private static JSONArray getJSONArrayOfContacts(List<Contact> contacts) throws JsonProcessingException {
         ObjectMapper mapper = new ObjectMapper();

         String jsonString = mapper.writeValueAsString(contacts);

         JSONArray jsonElements = new JSONArray(jsonString);

         removeIdsFromJson(jsonElements);
         return jsonElements;
     }

     private static void removeIdsFromJson(JSONArray jsonElements){
         for (int i=0;i<jsonElements.length();i++){
             jsonElements.getJSONObject(i).remove("id");
             JSONArray jsonMobiles = jsonElements.getJSONObject(i).getJSONArray("mobiles");
             JSONArray jsonEmails = jsonElements.getJSONObject(i).getJSONArray("emails");
             for (int j=0; j<jsonEmails.length();j++){
                 jsonEmails.getJSONObject(j).remove("id");
             }
             for (int k=0; k<jsonMobiles.length();k++){
                 jsonMobiles.getJSONObject(k).remove("id");
             }
         }
     }
 }
