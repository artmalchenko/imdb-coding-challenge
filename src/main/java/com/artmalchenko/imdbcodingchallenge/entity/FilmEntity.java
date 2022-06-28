package com.artmalchenko.imdbcodingchallenge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movies")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String title;

    @Formula("(select sum(ur.rating)/count(ur.id) from users_ratings ur where ur.film_id = id)")
    private Double averageRating;

    @JoinTable(name = "movies_genres", joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @ElementCollection(targetClass = GenreEntity.class)
    private Set<GenreEntity> genres;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Set<RatingEntity> filmRatings;

}
