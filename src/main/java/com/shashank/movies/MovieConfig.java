package com.shashank.movies;

import com.shashank.movies.entity.Movie;
import com.shashank.movies.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository){
        return args -> {
            Movie KGF_1 = new Movie("KGF 1", 90, 9.0f, List.of("Thriller","Drama","Action"), false);
            Movie KGF_2 =  new Movie("KGF 2", 120, 9.9f, List.of("Thriller","Action"), false);
            Movie Kantara_1 =new Movie("Kantara 1", 100, 10.0f, List.of("Thriller","Horror","Drama"), false);
            Movie Kantara_2 =new Movie("Kantara 2", 135, 9.2f, List.of("Mystery","Drama","History"), false);
            movieRepository.saveAll(List.of(KGF_1,KGF_2,Kantara_1,Kantara_2));
        };
    }
}
