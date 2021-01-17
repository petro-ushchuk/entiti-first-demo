package pis.lab4.demo.controller;

import com.google.common.net.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import pis.lab4.demo.api.AuthApi;
import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.model.enums.Role;
import pis.lab4.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pis.lab4.demo.util.CookieUtils;
import pis.lab4.demo.util.JwtProvider;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

  private final AuthService authService;
  private final JwtProvider jwtProvider;

  @Override
  public ResponseEntity<UserDto> signIn(UserDto inUserDto) {
    UserDto user = authService.signIn(inUserDto);
    return ResponseEntity.ok()
            .header(
                    HttpHeaders.AUTHORIZATION,
                    jwtProvider.createToken(user.getEmail())
            )
            .body(user);
  }

  @Override
  public UserDto signUp(UserDto inUserDto) {
    log.info("Registering user with email {}", inUserDto.getEmail());
    return authService.signUp(inUserDto, Role.USER);
  }

  @Override
  public ResponseEntity<Void> signOut() {
    authService.signOut();
    return ResponseEntity.noContent().build();
  }

}
