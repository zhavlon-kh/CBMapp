package kg.apps.CBMapp.repository;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactMobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContactMobileRepository extends JpaRepository<ContactMobile,Long> {

    Set<ContactMobile> getAllByContact(Contact contact);

}
