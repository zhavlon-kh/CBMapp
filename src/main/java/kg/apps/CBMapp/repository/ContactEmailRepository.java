package kg.apps.CBMapp.repository;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContactEmailRepository extends JpaRepository<ContactEmail, Long> {
<<<<<<< HEAD
    Set<ContactEmail> findAllByContact(Contact contact);
=======

    Set<ContactEmail> getAllByContact(Contact contact);
>>>>>>> f559489e04ddc1855acf8e61559254b5e65ef7ff
}
