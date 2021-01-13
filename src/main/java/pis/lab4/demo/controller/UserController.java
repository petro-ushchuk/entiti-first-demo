package pis.lab4.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pis.lab4.demo.api.UserApi;
import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.model.User;
import pis.lab4.demo.service.MappingService;
import pis.lab4.demo.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("createUser: with email {}", userDto.getEmail());
        UserDto user = userService.createUser(userDto);
        return user;
    }

    @Override
    public UserDto getUser(Long id) {
        log.info("getUser: with id {}", id);
        UserDto userDto = userService.getUser(id);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        log.info("updateUser controller is called");
        UserDto user = userService.updateUser(userDto);
        return user;
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        log.info("deleteUser: with id {}", id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
