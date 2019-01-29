package kg.apps.CBMapp.service;

import kg.apps.CBMapp.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileService {
    String ContactsToCsvData(List<Contact> contacts);
}
