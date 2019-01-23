package kg.apps.CBMapp.repository;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ContactRepository extends JpaRepository<Contact,Long> {

    //@Query("select c from Contact c, User u where u.id=c.user_id and u.username =?1")
    List<Contact> findAllByUser(User user);

    List<Contact> findBySurnameStartsWithIgnoreCase(String surname);
}
