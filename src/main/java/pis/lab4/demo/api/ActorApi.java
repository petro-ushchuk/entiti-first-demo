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
import pis.lab4.demo.dto.ActorDto;
import pis.lab4.demo.dto.validation.group.OnRegister;
import pis.lab4.demo.dto.validation.group.OnUpdate;

@Api(tags = "Actor management REST API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/actor")
public interface ActorApi {

    @ApiOperation("Create Actor API")
    @ApiResponse(code = 201, message = "OK", response = ActorDto.class)
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    ActorDto createActor(@RequestBody @Validated(OnRegister.class) ActorDto actorDto);

    @ApiOperation("Get Actor API")
    @ApiResponse(code = 200, message = "OK", response = ActorDto.class)
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ActorDto getActor(@PathVariable Long id);

    @ApiOperation("Update Actor API")
    @ApiResponse(code = 200, message = "OK", response = ActorDto.class)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    ActorDto updateActor(@RequestBody @Validated(OnUpdate.class) ActorDto actorDto);

    @ApiOperation("Delete Actor API")
    @ApiResponse(code = 204, message = "No content")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteActor(@PathVariable Long id);
}
