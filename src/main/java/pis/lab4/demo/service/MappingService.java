package pis.lab4.demo.service;


import pis.lab4.demo.dto.ActorDto;
import pis.lab4.demo.dto.FilmDto;
import pis.lab4.demo.dto.GenreDto;
import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.model.Actor;
import pis.lab4.demo.model.Film;
import pis.lab4.demo.model.Genre;
import pis.lab4.demo.model.User;

public interface MappingService {

  User mapUserDtoToUser(UserDto userDto);

  UserDto mapUserToUserDto(User user);

  GenreDto mapGenreToGenreDto(Genre genre);

  ActorDto mapActorToActorDto(Actor actor);

  Genre mapGenreDtoToGenre(GenreDto genreDto);

  Actor mapActorDtoToActor(ActorDto actorDto);

  FilmDto mapFilmToFilmDto(Film film);

  Film mapFilmDtoToFilm(FilmDto filmDto);
}
