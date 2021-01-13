package pis.lab4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  pis.lab4.demo.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
