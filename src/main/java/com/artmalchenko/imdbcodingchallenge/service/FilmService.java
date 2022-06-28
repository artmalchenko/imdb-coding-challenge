package com.artmalchenko.imdbcodingchallenge.service;

import com.artmalchenko.imdbcodingchallenge.dto.FilmDto;
import com.artmalchenko.imdbcodingchallenge.entity.FilmEntity;
import com.artmalchenko.imdbcodingchallenge.repository.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FilmRepository filmRepository;

    public List<FilmDto> findAllFilms() {
        List<FilmEntity> entities = filmRepository.findAll();

        List<FilmDto> dtos = entities
                .stream()
                .map(source -> modelMapper.map(source, FilmDto.class))
                .collect(Collectors.toList());
        return dtos;
    }

    public Optional<FilmDto> findFilmByTitle(String title) {
        Optional<FilmEntity> findByTitleOptionalEntity = filmRepository.findByTitle(title);

        if (findByTitleOptionalEntity.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(modelMapper.map(findByTitleOptionalEntity.get(), FilmDto.class));
        }
    }

    public Optional<FilmDto> findFilmById(Long id) {
        Optional<FilmEntity> movieEntityOptional = filmRepository.findById(id);

        if (movieEntityOptional.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(modelMapper.map(movieEntityOptional.get(), FilmDto.class));
        }
    }

    public FilmDto saveFilm(FilmDto filmDto) {
        FilmEntity savedEntity = filmRepository.save(modelMapper.map(filmDto, FilmEntity.class));
        return modelMapper.map(savedEntity, FilmDto.class);
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

}
