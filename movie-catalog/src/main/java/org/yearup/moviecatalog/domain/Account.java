package org.yearup.moviecatalog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Account {

    @Id
    private Long userId;

    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private Boolean staySignedIn;

    private List<Movie> movies;

    public Account() { }


}
