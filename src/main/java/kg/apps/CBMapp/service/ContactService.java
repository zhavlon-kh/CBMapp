package kg.apps.CBMapp.service;

import kg.apps.CBMapp.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

    List<Contact> selectUserContacts();

    void  addContact(Contact newContact);

    void deleteContactById(long contactId);

    Contact getContactById(Long id) throws Exception;

}
