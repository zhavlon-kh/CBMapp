package kg.apps.CBMapp.repository;

import kg.apps.CBMapp.model.ContactEmail;
import org.hibernate.annotations.LazyToOne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactEmailRepository extends JpaRepository<ContactEmail, Long> {
}
