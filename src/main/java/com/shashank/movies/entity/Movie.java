package com.shashank.movies.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "MoviesDB")
@Entity(name = "Movies")
public class Movie{
    @Id
    @SequenceGenerator(name = "movies_sequence",sequenceName = "movies_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "movies_sequence")
    private Long id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "movie_runtime")
    private int runtime;

    @Column(name = "movie_rating")
    private Float rating;

    @Column(name = "movie_genres")
    private List<String> genres;

    @Column
    private Boolean isAdultRated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Boolean getAdultRated() {
        return isAdultRated;
    }

    public void setAdultRated(Boolean adultRated) {
        isAdultRated = adultRated;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", runtime=" + runtime +
                ", rating=" + rating +
                ", genres=" + genres +
                ", isAdultRated=" + isAdultRated +
                '}';
    }

    public Movie(String name, int runtime, Float rating, List<String> genres, Boolean isAdultRated) {
        this.name = name;
        this.runtime = runtime;
        this.rating = rating;
        this.genres = genres;
        this.isAdultRated = isAdultRated;
    }
    public Movie(Long id,String name, int runtime, Float rating, List<String> genres, Boolean isAdultRated) {
        this.id = id;
        this.name = name;
        this.runtime = runtime;
        this.rating = rating;
        this.genres = genres;
        this.isAdultRated = isAdultRated;
    }


    public Movie() {
    }


}
