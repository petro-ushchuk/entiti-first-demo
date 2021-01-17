package pis.lab4.demo.controller;

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
import pis.lab4.demo.util.JwtTokenTool;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

  private final AuthService authService;
  private final JwtTokenTool jwtTokenTool;

  @Value("${jwt.token.cookie.name}")
  private String jwtTokenCookieName;

  @Value("${jwt.authentication.cookie.expire-date}")
  private int jwtCookieExpireDate;

  @Override
  public UserDto signIn(UserDto inUserDto, HttpServletResponse httpServletResponse) {
    log.info("Singing in user with email {}", inUserDto.getEmail());
    UserDto user = authService.signIn(inUserDto);
    String token = jwtTokenTool.createToken(user.getEmail());
    CookieUtils.addCookie(httpServletResponse, jwtTokenCookieName, token, jwtCookieExpireDate);
    return user;
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
