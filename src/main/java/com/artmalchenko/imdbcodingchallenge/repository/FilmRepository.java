package com.artmalchenko.imdbcodingchallenge.repository;

import com.artmalchenko.imdbcodingchallenge.entity.FilmEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends CrudRepository<FilmEntity, Long> {

    List<FilmEntity> findAll();

    Optional<FilmEntity> findByTitle(String title);

    Optional<FilmEntity> findById(Long id);

    FilmEntity save(FilmEntity filmEntity);

    void deleteById(Long id);

}
