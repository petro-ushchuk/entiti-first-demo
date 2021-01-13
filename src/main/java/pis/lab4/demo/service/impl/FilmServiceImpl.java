package pis.lab4.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pis.lab4.demo.dto.FilmDto;
import pis.lab4.demo.model.Film;
import pis.lab4.demo.repository.FilmRepository;
import pis.lab4.demo.service.FilmService;
import pis.lab4.demo.service.MappingService;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final MappingService mappingService;

    @Override
    public FilmDto getFilm(Long id) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if(!optionalFilm.isPresent())
            throw new EmptyResultDataAccessException(1);
        Film film = optionalFilm.get();
        log.info("About to get Film {}", film);
        return mappingService.mapFilmToFilmDto(film);
    }

    @Override
    public FilmDto createFilm(FilmDto filmDto) {
        Film film = mappingService.mapFilmDtoToFilm(filmDto);
        log.info("About to create Film {}", film);
        film = filmRepository.save(film);
        log.info("Used with id {} successfully created",film.getId());
        return mappingService.mapFilmToFilmDto(film);
    }

    @Override
    public FilmDto updateFilm(FilmDto filmDto) {
        Film film = mappingService.mapFilmDtoToFilm(filmDto);
        log.info("About to update Film {}", film);
        film = filmRepository.save(film);
        log.info("Used with id {} successfully updated", film.getId());
        return mappingService.mapFilmToFilmDto(film);
    }

    @Override
    public void deleteFilm(Long id) {
        log.info("deleteFilm: about to delete Film with id {}", id);
        SecurityContextHolder.clearContext();
        filmRepository.deleteById(id);
    }

}
