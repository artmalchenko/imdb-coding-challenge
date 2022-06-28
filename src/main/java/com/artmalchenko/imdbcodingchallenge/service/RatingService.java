package com.artmalchenko.imdbcodingchallenge.service;

import com.artmalchenko.imdbcodingchallenge.dto.RatingDto;
import com.artmalchenko.imdbcodingchallenge.entity.RatingEntity;
import com.artmalchenko.imdbcodingchallenge.repository.RatingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RatingDto saveRating(RatingDto ratingDto) {
        RatingEntity savedRating = ratingRepository.save(modelMapper.map(ratingDto, RatingEntity.class));
        return modelMapper.map(savedRating, RatingDto.class);
    }

}
