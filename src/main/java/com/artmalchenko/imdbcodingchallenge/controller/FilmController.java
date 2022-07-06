package com.artmalchenko.imdbcodingchallenge.controller;

import com.artmalchenko.imdbcodingchallenge.controller.api.FilmControllerApi;
import com.artmalchenko.imdbcodingchallenge.dto.FilmDto;
import com.artmalchenko.imdbcodingchallenge.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FilmController implements FilmControllerApi {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(value = "/films", params = "title")
    public ResponseEntity<FilmDto> findFilmByTitle(@RequestParam String title) {
        Optional<FilmDto> movieByIdOptional = filmService.findFilmByTitle(title);
        if (movieByIdOptional.isPresent()) {
            return new ResponseEntity<>(movieByIdOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/films")
    public ResponseEntity<List<FilmDto>> listAllFilms() {
        return new ResponseEntity<>(filmService.findAllFilms(), HttpStatus.OK);
    }

    @GetMapping(value = "/films/{id}")
    public ResponseEntity<FilmDto> findFilmById(@PathVariable Long id) {
        Optional<FilmDto> movieByIdOptional = filmService.findFilmById(id);

        if (movieByIdOptional.isPresent()) {
            return new ResponseEntity<>(movieByIdOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/films")
    public ResponseEntity<FilmDto> createFilm(@RequestBody FilmDto movie) {
        return new ResponseEntity<>(filmService.saveFilm(movie), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/films/{id}")
    public void deleteFilmById(@PathVariable Long id) {
        filmService.deleteFilm(id);
    }

}
