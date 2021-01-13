package pis.lab4.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.model.enums.Role;

public interface AuthService extends UserDetailsService {

  UserDto signIn(UserDto userDto);

  UserDto signUp(UserDto userDto, Role role);

  void signOut();

}
