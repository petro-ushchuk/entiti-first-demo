package pis.lab4.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.model.enums.Role;

public interface AuthService extends UserDetailsService {

  String signIn(UserDto userDto);

  String signUp(UserDto userDto, Role role);

  void signOut();

}
