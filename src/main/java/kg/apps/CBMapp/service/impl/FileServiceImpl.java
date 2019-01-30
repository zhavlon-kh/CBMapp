package kg.apps.CBMapp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import kg.apps.CBMapp.service.ContactService;
import kg.apps.CBMapp.service.FileService;
import kg.apps.CBMapp.service.UserService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FileServiceImpl implements FileService
 {

    @Autowired
    UserService userService;

    @Autowired
    ContactService contactService;

    @Override
    public JSONArray getAllUserContactsAsJsonArray() throws Exception {

        User user = userService.getCurrentUser();

        List<Contact> contacts = userService.getUserContacts(user);

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(contacts);

        JSONArray jsonElements = new JSONArray(jsonString);

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


        return jsonElements;
    }

    @Override
    public JSONArray getContactsAsJsonArrayByIds(Set<Long> idSet) {




        return null;
    }
}
