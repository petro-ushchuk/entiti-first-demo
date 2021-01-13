package pis.lab4.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pis.lab4.demo.dto.GenreDto;
import pis.lab4.demo.model.Genre;
import pis.lab4.demo.repository.GenreRepository;
import pis.lab4.demo.service.GenreService;
import pis.lab4.demo.service.MappingService;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final MappingService mappingService;

    @Override
    public GenreDto getGenre(Long id) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if(!optionalGenre.isPresent())
            throw new EmptyResultDataAccessException(1);
        Genre Genre = optionalGenre.get();
        log.info("About to get Genre {}", Genre);
        return mappingService.mapGenreToGenreDto(Genre);
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        Genre genre = mappingService.mapGenreDtoToGenre(genreDto);
        log.info("About to create Genre {}", genre);
        genre = genreRepository.save(genre);
        log.info("Used with id {} successfully created", genre.getId());
        return mappingService.mapGenreToGenreDto(genre);
    }

    @Override
    public GenreDto updateGenre(GenreDto genreDto) {
        Genre genre = mappingService.mapGenreDtoToGenre(genreDto);
        log.info("About to update Genre {}", genre);
        genre = genreRepository.save(genre);
        log.info("Used with id {} successfully updated", genre.getId());
        return mappingService.mapGenreToGenreDto(genre);
    }

    @Override
    public void deleteGenre(Long id) {
        log.info("deleteGenre: about to delete Genre with id {}", id);
        SecurityContextHolder.clearContext();
        genreRepository.deleteById(id);
    }

}
