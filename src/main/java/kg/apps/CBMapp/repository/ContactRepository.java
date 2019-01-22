package kg.apps.CBMapp.repository;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact,Long> {

    @Override
    List<Contact> findAll();

    @Override
    List<Contact> findAllById(Iterable<Long> iterable);

    @Query("select u from #{#entityName} u where u.user =?1")
    List<Contact> findAllByUser(User user);
}
