package com.artmalchenko.imdbcodingchallenge.service;

import com.artmalchenko.imdbcodingchallenge.dto.RatingDto;
import com.artmalchenko.imdbcodingchallenge.entity.RatingEntity;
import com.artmalchenko.imdbcodingchallenge.repository.RatingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    private final ModelMapper modelMapper;

    public RatingService(RatingRepository ratingRepository, ModelMapper modelMapper) {
        this.ratingRepository = ratingRepository;
        this.modelMapper = modelMapper;
    }

    public RatingDto saveRating(RatingDto ratingDto) {
        RatingEntity savedRating = ratingRepository.save(modelMapper.map(ratingDto, RatingEntity.class));
        return modelMapper.map(savedRating, RatingDto.class);
    }

}
