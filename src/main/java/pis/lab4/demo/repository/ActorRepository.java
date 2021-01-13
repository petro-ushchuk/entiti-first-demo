package pis.lab4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pis.lab4.demo.model.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    List<Actor> findActorByFirstNameAndLastName(String firstName, String lastName);

    Actor findByFirstName(String firstName);

}
