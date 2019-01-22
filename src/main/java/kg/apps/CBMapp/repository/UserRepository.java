package kg.apps.CBMapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kg.apps.CBMapp.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByUsername(String username);


}