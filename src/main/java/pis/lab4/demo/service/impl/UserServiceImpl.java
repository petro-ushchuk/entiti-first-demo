package pis.lab4.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.exception.NotFoundException;
import pis.lab4.demo.model.User;
import pis.lab4.demo.repository.UserRepository;
import pis.lab4.demo.service.MappingService;
import pis.lab4.demo.service.UserService;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final MappingService mappingService;

  @Override
  public UserDto getUser(Long id) {
    Optional<User> optionalUser =userRepository.findById(id);
    if(!optionalUser.isPresent())
      throw new NotFoundException("User with {id} not found" + id);
    User user = optionalUser.get();
    log.info("About to get User {}", user);
    return mappingService.mapUserToUserDto(user);
  }

  @Override
  public UserDto createUser(UserDto userDto) {
    User user = mappingService.mapUserDtoToUser(userDto);
    log.info("About to create user {}", user);
    user = userRepository.save(user);
    log.info("Used with id {} successfully created", user.getId());
    return mappingService.mapUserToUserDto(user);
  }

  @Override
  public UserDto updateUser(UserDto userDto) {
    User user = mappingService.mapUserDtoToUser(userDto);
    log.info("About to update user {}", user);
    user = userRepository.save(user);
    log.info("Used with id {} successfully updated", user.getId());
    return mappingService.mapUserToUserDto(user);
  }

  @Override
  public void deleteUser(Long id) {
    log.info("deleteUser: about to delete user with id {}", id);
    SecurityContextHolder.clearContext();
    userRepository.deleteById(id);
  }

  @Override
  public boolean isUserExistsWithEmail(String email) {
    Optional<User> user = userRepository.findByEmail(email);
    return user.isPresent();
  }

}

