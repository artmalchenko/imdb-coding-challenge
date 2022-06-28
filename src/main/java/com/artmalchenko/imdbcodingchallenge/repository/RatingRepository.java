package com.artmalchenko.imdbcodingchallenge.repository;

import com.artmalchenko.imdbcodingchallenge.entity.RatingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<RatingEntity, Long> {

    RatingEntity save(RatingEntity ratingEntity);

}
