package pis.lab4.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pis.lab4.demo.api.GenreApi;
import pis.lab4.demo.dto.GenreDto;
import pis.lab4.demo.service.GenreService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GenreController implements GenreApi {

    private final GenreService GenreService;

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        log.info("createGenre: with title {}", genreDto.getGenre());
        GenreDto genre = GenreService.createGenre(genreDto);
        return genre;
    }

    @Override
    public GenreDto getGenre(Long id) {
        log.info("getGenre: with id {}", id);
        GenreDto genreDto = getGenre(id);
        return genreDto;
    }

    @Override
    public GenreDto updateGenre(GenreDto genreDto) {
        log.info("updateGenre controller is called");
        GenreDto genre = GenreService.updateGenre(genreDto);
        return genre;
    }

    @Override
    public ResponseEntity<Void> deleteGenre(Long id) {
        log.info("deleteGenre: with id {}", id);
        GenreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }

}
