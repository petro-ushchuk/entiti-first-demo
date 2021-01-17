package pis.lab4.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import  pis.lab4.demo.dto.UserDto;
import  pis.lab4.demo.model.User;
import  pis.lab4.demo.model.enums.Role;
import  pis.lab4.demo.repository.UserRepository;
import  pis.lab4.demo.service.AuthService;
import  pis.lab4.demo.service.MappingService;
import pis.lab4.demo.util.JwtProvider;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final MappingService mappingService;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final JwtProvider jwt;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Unable to find user email!"));
  }

  @Override
  public String signIn(UserDto userDto) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            userDto.getEmail(),
            userDto.getPassword())
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    User user = (User) authentication.getPrincipal();
    return jwt.createToken(user.getEmail());
  }

  @Override
  public String signUp(UserDto userDto, Role role) {
    User user = mappingService.mapUserDtoToUser(userDto);
    log.info("createUser: about to register a new user with email {}", user.getEmail());

    user.setRole(role);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user = userRepository.save(user);
    log.info("Used with id {} successfully registered", user.getId());

    return signIn(userDto);
  }

  @Override
  public void signOut() {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    log.info("Singing out user with email {}", user.getEmail());
    SecurityContextHolder.clearContext();
  }

}
