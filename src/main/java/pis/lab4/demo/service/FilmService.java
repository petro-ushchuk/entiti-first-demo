package pis.lab4.demo.service;

import pis.lab4.demo.dto.FilmDto;

public interface FilmService {

  FilmDto getFilm(Long id);

  FilmDto createFilm(FilmDto filmDto);

  FilmDto updateFilm(FilmDto filmDto);

  void deleteFilm(Long id);

}
