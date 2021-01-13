package pis.lab4.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pis.lab4.demo.api.FilmApi;
import pis.lab4.demo.dto.FilmDto;
import pis.lab4.demo.model.Film;
import pis.lab4.demo.service.MappingService;
import pis.lab4.demo.service.FilmService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FilmController implements FilmApi {

    private final FilmService filmService;

    @Override
    public FilmDto createFilm(FilmDto filmDto) {
        log.info("createFilm: with title {}", filmDto.getTitle());
        FilmDto film = filmService.createFilm(filmDto);
        return film;
    }

    @Override
    public FilmDto getFilm(Long id) {
        log.info("getFilm: with id {}", id);
        FilmDto filmDto = filmService.getFilm(id);
        return filmDto;
    }

    @Override
    public FilmDto updateFilm(FilmDto filmDto) {
        log.info("updateFilm controller is called");
        FilmDto film =filmService.updateFilm(filmDto);
        return film;
    }

    @Override
    public ResponseEntity<Void> deleteFilm(Long id) {
        log.info("deleteFilm: with id {}", id);
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }

}
