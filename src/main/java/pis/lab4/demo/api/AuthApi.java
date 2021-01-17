package pis.lab4.demo.api;

import pis.lab4.demo.dto.UserDto;
import pis.lab4.demo.dto.validation.group.OnRegister;
import pis.lab4.demo.dto.validation.group.OnSignIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "Auth management REST API")
@ApiResponses({
    @ApiResponse(code = 404, message = "Not found"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/auth")
public interface AuthApi {

  @ApiOperation("Sign in user to the system")
  @ApiResponse(code = 200, message = "OK", response = UserDto.class)
  @PostMapping("/signin")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<UserDto> signIn(@RequestBody @Validated(OnSignIn.class) UserDto userDto);

  @ApiOperation("Sign up and automatically sign in user to the system")
  @ApiResponse(code = 201, message = "Created", response = UserDto.class)
  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  UserDto signUp(@RequestBody @Validated(OnRegister.class) UserDto userDto);

  @ApiOperation("Sign out current user from the system")
  @ApiResponse(code = 204, message = "No content")
  @GetMapping("/signout")
  ResponseEntity<Void> signOut();

}
