package org.yearup.moviecatalog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.yearup.moviecatalog.enumerations.Genre;
import org.yearup.moviecatalog.enumerations.Rating;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity(name = "Movie")
public class Movie {

    @Id
    private Long id;

    private String title;
    private String description;
    private Boolean recommended;
    private String cast;
    private String release_date;
    private Integer duration;
    private double userRating;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @ManyToOne
    private Account account;


    public Movie() {
    }

}
