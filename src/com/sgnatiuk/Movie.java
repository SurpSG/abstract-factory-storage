package com.sgnatiuk;

import java.util.List;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class Movie {

    private String name;
    private int year;
    private List<String> genres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genres=" + genres +
                '}';
    }
}
