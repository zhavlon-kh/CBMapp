package kg.apps.CBMapp.service.impl;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.service.FileService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String ContactsToCsvData(List<Contact> contacts) {

        String contactsCSV="";

        for (Contact contact: contacts){
            contactsCSV += contact.toString();
            contactsCSV += "<br/>";

        }

        return contactsCSV;
    }
}
