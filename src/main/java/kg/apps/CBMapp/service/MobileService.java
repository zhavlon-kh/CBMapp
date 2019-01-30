package kg.apps.CBMapp.service;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactMobile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface MobileService {
    Set<ContactMobile> selectAllMobilesByContact(Contact contact);

    void deleteMobile(ContactMobile mobile);

    void deleteMobileById(Long id);

    void addMobile(ContactMobile mobile);
}
