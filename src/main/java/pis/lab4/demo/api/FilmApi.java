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
import pis.lab4.demo.dto.FilmDto;
import pis.lab4.demo.dto.validation.group.OnRegister;
import pis.lab4.demo.dto.validation.group.OnUpdate;
import pis.lab4.demo.model.Film;

@Api(tags = "Film management REST API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/film")
public interface FilmApi {

    @ApiOperation("Create Film API")
    @ApiResponse(code = 201, message = "OK", response = FilmDto.class)
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    FilmDto createFilm(@RequestBody @Validated(OnRegister.class) FilmDto filmDto);

    @ApiOperation("Get Film API")
    @ApiResponse(code = 200, message = "OK", response = FilmDto.class)
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    FilmDto getFilm(@PathVariable Long id);

    @ApiOperation("Update Film API")
    @ApiResponse(code = 200, message = "OK", response = FilmDto.class)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    FilmDto updateFilm(@RequestBody @Validated(OnUpdate.class) FilmDto filmDto);

    @ApiOperation("Delete Film API")
    @ApiResponse(code = 204, message = "No content")
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteFilm(@PathVariable Long id);
}
