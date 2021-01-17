package pis.lab4.demo.controller;

import pis.lab4.demo.api.AuthApi;
import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.model.enums.Role;
import pis.lab4.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

  private final AuthService authService;

  @Override
  public String signIn(UserDto inUserDto) {
    return authService.signIn(inUserDto);
  }

  @Override
  public String signUp(UserDto inUserDto) {
    log.info("Registering user with email {}", inUserDto.getEmail());
    return authService.signUp(inUserDto, Role.USER);
  }

  @Override
  public ResponseEntity<Void> signOut() {
    authService.signOut();
    return ResponseEntity.noContent().build();
  }

}
