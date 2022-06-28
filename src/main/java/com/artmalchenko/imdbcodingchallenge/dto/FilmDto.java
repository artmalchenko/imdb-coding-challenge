package com.artmalchenko.imdbcodingchallenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmDto implements Serializable {
    private Long id;
    private String title;
    private Double averageRating = 0.0;
    private Set<GenreDto> genres;

    public FilmDto(String title, Set<GenreDto> genres) {
        this.title = title;
        this.genres = genres;
    }

}
