package com.artmalchenko.imdbcodingchallenge.controller;

import com.artmalchenko.imdbcodingchallenge.controller.api.RatingControllerApi;
import com.artmalchenko.imdbcodingchallenge.dto.RatingDto;
import com.artmalchenko.imdbcodingchallenge.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController implements RatingControllerApi {

    @Autowired
    private RatingService ratingService;

    @PostMapping(value = "/ratings")
    public ResponseEntity<RatingDto> submitRating(@RequestBody RatingDto ratingDto) {
        return new ResponseEntity<>(ratingService.saveRating(ratingDto), HttpStatus.CREATED);
    }

}
