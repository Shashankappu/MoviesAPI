package com.shashank.movies;

import com.shashank.movies.entity.Movie;
import com.shashank.movies.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieByName = movieRepository.findMovieByName(movie.getName());
        if (movieByName.isPresent()) {
            throw new IllegalStateException("Movie Exists Already");
        }else{
            movieRepository.save(movie);
        }
    }

    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if(!exists){
            throw new IllegalStateException("Movie with "+movieId+" Does not exist");
        }else{
            movieRepository.deleteById(movieId);
        }
    }

    @Transactional
    public void updateMovie(Long movieId, String name, Integer runtime, Float rating,Boolean isAdultRated,List<String> genres) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(()-> new IllegalStateException(
                        "Movie with Id" + movieId + "does not exist"
                ));

        //to update name
        if(name!=null && !name.isEmpty() && !Objects.equals(movie.getName(),name)){
            movie.setName(name);
        }

        //to update name
        if(runtime!=null && !Objects.equals(movie.getRuntime(),runtime)){
            movie.setRuntime(runtime);
        }

        //to update rating
        if(rating!=null && !Objects.equals(movie.getRating(),rating)){
            movie.setRating(rating);
        }

        //to update isAdultRated
        if(isAdultRated!=null){
            movie.setAdultRated(isAdultRated);
        }

        //to update all genres
        if(genres!=null && !Objects.equals(movie.getGenres(),genres)){
            movie.setGenres(genres);
        }

    }
}
