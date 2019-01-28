package kg.apps.CBMapp.repository;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContactEmailRepository extends JpaRepository<ContactEmail, Long> {

    Set<ContactEmail> getAllByContact(Contact contact);

    Set<ContactEmail> findAllByContact(Contact contact);
}
