package pis.lab4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pis.lab4.demo.model.Film;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findAllByActors_FirstNameAndActors_LastName(String firstName, String lastName);

    List<Film> findAllByGenres_Genre(String genre);

    List<Film> findByTitle(String title);
}
