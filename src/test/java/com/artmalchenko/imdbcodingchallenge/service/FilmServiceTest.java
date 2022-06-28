package com.artmalchenko.imdbcodingchallenge.service;

import com.artmalchenko.imdbcodingchallenge.dto.FilmDto;
import com.artmalchenko.imdbcodingchallenge.entity.FilmEntity;
import com.artmalchenko.imdbcodingchallenge.entity.GenreEntity;
import com.artmalchenko.imdbcodingchallenge.repository.FilmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class FilmServiceTest {

    private final long filmId = 1L;
    private FilmEntity filmEntity;

    @Spy
    private ModelMapper modelMapper;

    @Mock
    private FilmRepository filmRepository;

    @InjectMocks
    private FilmService filmService;

    @BeforeEach
    public void setup() {
        HashSet<GenreEntity> genres = new HashSet<>(Arrays.asList(new GenreEntity(1L, "Horror"),
                new GenreEntity(2L, "Documentary")));
        filmEntity = new FilmEntity(1L, "James Bond", 0.0, genres, new HashSet<>());
    }

    @Test
    @DisplayName("deleteMovie() - Verify repository is called")
    void deleteFilm_verifyRepositoryIsCalled() {
        filmService.deleteFilm(filmId);
        then(filmRepository).should().deleteById(filmId);
    }

    @Test
    @DisplayName("findMovie() - Verify repository is called")
    void findFilmById_verifyRepositoryIsCalled() {
        given(filmRepository.findById(filmId)).willReturn(Optional.of(filmEntity));
        filmService.findFilmById(filmId);
        then(filmRepository).should().findById(filmId);
    }

    @Test
    @DisplayName("findMovie() - Verify empty optional is returned when no movie found")
    void findFilmById_verifyEmptyOptionalIsReturnedWhenNoFilmFound() {
        given(filmRepository.findById(filmId)).willReturn(Optional.empty());
        Optional<FilmDto> movieByIdOptional = filmService.findFilmById(filmId);
        assertTrue(movieByIdOptional.isEmpty());
    }

}