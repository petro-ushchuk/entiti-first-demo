package pis.lab4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pis.lab4.demo.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findByGenre(String dark);

}
