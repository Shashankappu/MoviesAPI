package com.shashank.movies.repository;

import com.shashank.movies.entity.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query("SELECT m from Movie m WHERE  m.name = ?1")
    Optional<Movie> findMovieByName(String name);

    @Query("SELECT * from Movie WHERE Movie.Id = movieId")
    Movie findMovieById(Long movieId);
}
