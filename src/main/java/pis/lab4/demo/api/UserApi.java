package pis.lab4.demo.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.dto.validation.group.OnRegister;
import pis.lab4.demo.dto.validation.group.OnUpdate;
import pis.lab4.demo.model.User;

@Api(tags = "User management REST API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/user")
public interface UserApi {

    @ApiOperation("Create user API")
    @ApiResponse(code = 201, message = "OK", response = UserDto.class)
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    UserDto createUser(@RequestBody @Validated(OnRegister.class) UserDto user);

    @ApiOperation("Get user API")
    @ApiResponse(code = 200, message = "OK", response = UserDto.class)
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    UserDto getUser(@AuthenticationPrincipal @PathVariable Long id);

    @ApiOperation("Update user API")
    @ApiResponse(code = 200, message = "OK", response = UserDto.class)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    UserDto updateUser(@RequestBody @Validated(OnUpdate.class) UserDto userDto);

    @ApiOperation("Delete user API")
    @ApiResponse(code = 204, message = "No content")
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteUser(@AuthenticationPrincipal @PathVariable Long id);
}
