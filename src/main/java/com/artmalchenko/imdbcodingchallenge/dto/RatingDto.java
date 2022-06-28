package com.artmalchenko.imdbcodingchallenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatingDto implements Serializable {
    private Long id;
    private Long userId;
    private Long filmId;
    private Integer rating;

    public RatingDto(Long userId, Long filmId, Integer rating) {
        this.userId = userId;
        this.filmId = filmId;
        this.rating = rating;
    }

}
