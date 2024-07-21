package com.shashank.movies.repository;

import com.shashank.movies.entity.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query("SELECT m from Movie m WHERE  m.email = ?1")
    Optional<Movie> findMovieByName(String name);

}
