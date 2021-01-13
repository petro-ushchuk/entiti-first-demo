package pis.lab4.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pis.lab4.demo.dto.ActorDto;
import pis.lab4.demo.dto.FilmDto;
import pis.lab4.demo.dto.GenreDto;
import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.model.Actor;
import pis.lab4.demo.model.Film;
import pis.lab4.demo.model.Genre;
import pis.lab4.demo.model.User;
import pis.lab4.demo.service.MappingService;

@Slf4j
@Service
public class MappingServiceImpl implements MappingService {

  public User mapUserDtoToUser(UserDto userDto) {
    log.debug("mapUserDtoToUser: map to User from UserDto: {}", userDto);
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    return user;
  }

  public UserDto mapUserToUserDto(User user) {
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(user, userDto);
    userDto.setPassword(null);
    log.debug("mapUserToUserDto: map from User to UserDto: {}", userDto);
    return userDto;
  }

  @Override
  public GenreDto mapGenreToGenreDto(Genre genre) {
    GenreDto genreDto = new GenreDto();
    BeanUtils.copyProperties(genre, genreDto);
    log.debug("mapGenreToGenreDto: map from Genre to GenreDto: {}", genreDto);
    return genreDto;
  }

  @Override
  public ActorDto mapActorToActorDto(Actor actor) {
    ActorDto actorDto = new ActorDto();
    BeanUtils.copyProperties(actor, actorDto);
    log.debug("mapActorToActorDto: map from Actor to ActorDto: {}", actorDto);
    return actorDto;
  }

  @Override
  public Genre mapGenreDtoToGenre(GenreDto genreDto) {
    log.debug("mapGenreDtoToGenre: map to Genre from GenreDto: {}", genreDto);
    Genre genre = new Genre();
    BeanUtils.copyProperties(genreDto, genre);
    return genre;
  }

  @Override
  public Actor mapActorDtoToActor(ActorDto actorDto) {
    log.debug("mapActorDtoToActor: map to Actor from ActorDto: {}", actorDto);
    Actor actor = new Actor();
    BeanUtils.copyProperties(actorDto, actor);
    return actor;
  }

  @Override
  public FilmDto mapFilmToFilmDto(Film film) {
    FilmDto filmDto = new FilmDto();
    BeanUtils.copyProperties(film, filmDto);
    log.debug("mapFilmToFilmDto: map from Film to FilmDto: {}", filmDto);
    return filmDto;
  }

  @Override
  public Film mapFilmDtoToFilm(FilmDto filmDto) {
    log.debug("mapFilmDtoToFilm: map to Film from FilmDto: {}", filmDto);
    Film film = new Film();
    BeanUtils.copyProperties(filmDto, film);
    return film;
  }
}
