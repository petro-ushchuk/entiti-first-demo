package pis.lab4.demo.service;

import pis.lab4.demo.dto.FilmDto;
import pis.lab4.demo.dto.UserDto;

public interface UserService {

  UserDto getUser(Long id);

  UserDto createUser(UserDto userDto);

  UserDto updateUser(UserDto userDto);

  void deleteUser(Long id);

  boolean isUserExistsWithEmail(String email);

}
