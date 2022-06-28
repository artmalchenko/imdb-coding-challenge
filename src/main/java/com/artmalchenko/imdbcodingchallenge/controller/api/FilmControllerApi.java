package com.artmalchenko.imdbcodingchallenge.controller.api;

import com.artmalchenko.imdbcodingchallenge.dto.FilmDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FilmControllerApi {

    @Operation(summary = "Find film by title.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the film",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmDto.class))}),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content)})
    ResponseEntity<FilmDto> findFilmByTitle(@Parameter String title);

    @Operation(summary = "List all films.")
    ResponseEntity<List<FilmDto>> listAllFilms();

    @Operation(summary = "Find film by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the film",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmDto.class))}),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content)})
    ResponseEntity<FilmDto> findFilmById(@Parameter Long id);

    @Operation(summary = "Persist film.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created the film.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmDto.class))})})
    ResponseEntity<FilmDto> createFilm(@Parameter FilmDto movie);

    @Operation(summary = "Delete film by id.")
    void deleteFilmById(@PathVariable Long id);

}
