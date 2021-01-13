package pis.lab4.demo.service;

import pis.lab4.demo.dto.GenreDto;

public interface GenreService {

  GenreDto getGenre(Long id);

  GenreDto createGenre(GenreDto genreDto);

  GenreDto updateGenre(GenreDto genreDto);

  void deleteGenre(Long id);

}
