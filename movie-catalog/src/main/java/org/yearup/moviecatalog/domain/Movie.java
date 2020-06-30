package org.yearup.moviecatalog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.yearup.moviecatalog.enumerations.Genre;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

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

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Movie() {
    }

}
