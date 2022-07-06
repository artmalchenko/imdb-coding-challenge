package com.artmalchenko.imdbcodingchallenge.repository;

import com.artmalchenko.imdbcodingchallenge.entity.FilmEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends CrudRepository<FilmEntity, Long> {

    Optional<FilmEntity> findByTitle(String title);

}
