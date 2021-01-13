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
import pis.lab4.demo.dto.GenreDto;
import pis.lab4.demo.dto.validation.group.OnCreate;
import pis.lab4.demo.dto.validation.group.OnRegister;
import pis.lab4.demo.dto.validation.group.OnUpdate;
import pis.lab4.demo.model.Genre;

@Api(tags = "Genre management REST API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/genre")
public interface GenreApi {

    @ApiOperation("Create Genre API")
    @ApiResponse(code = 201, message = "OK", response = GenreDto.class)
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    GenreDto createGenre(@RequestBody @Validated(OnCreate.class) GenreDto genreDto);

    @ApiOperation("Get Genre API")
    @ApiResponse(code = 200, message = "OK", response = GenreDto.class)
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    GenreDto getGenre(@PathVariable Long id);

    @ApiOperation("Update Genre API")
    @ApiResponse(code = 200, message = "OK", response = GenreDto.class)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    GenreDto updateGenre(@RequestBody @Validated(OnUpdate.class) GenreDto genreDto);

    @ApiOperation("Delete Genre API")
    @ApiResponse(code = 204, message = "No content")
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteGenre(@PathVariable Long id);
}
