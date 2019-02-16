package kg.apps.CBMapp.service;

import kg.apps.CBMapp.model.Contact;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public interface ContactService {

    List<Contact> selectUserContacts();

    void  addContact(Contact newContact);

    void deleteContactById(long contactId) throws Exception;

    void deleteContact(Contact contact);

    Contact getContactById(Long id) throws Exception;

    List<Contact> getAllContactsWithIds(Set<Long> idSet) throws Exception;

    void deleteContacts(Iterable<Contact> contacts);
}
