package com.shashank.movies.Controller;

import com.shashank.movies.MovieService;
import com.shashank.movies.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("/")
public class MoviesController {
    private final MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping("/movies")
    public void addNewMovie(@RequestBody  Movie movie){
        movieService.addNewMovie(movie);
    }

    @DeleteMapping(path = "/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
        movieService.deleteMovie(movieId);
    }

    @PutMapping(path = "/movies/{movieId}")
    public void updateMovie(
            @PathVariable("movieId")Long movieId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer runtime,
            @RequestParam(required = false) Float rating,
            @RequestParam(required = false) Boolean isAdultRated,
            @RequestParam(required = false) List<String> genres
    ){
        movieService.updateMovie(movieId,name,runtime,rating,isAdultRated,genres);
    }
}
