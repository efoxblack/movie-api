package org.yearup.moviecatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yearup.moviecatalog.domain.Movie;
import org.yearup.moviecatalog.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        movieRepository.findAll().forEach(movieList::add);
        return movieList;
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(Movie movie, Long id) {
        for (Movie movie1: movieRepository.findAll()) {
            if(movie1.getId().equals(id)) {
                movieRepository.save(movie);
            }
        }
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

}
