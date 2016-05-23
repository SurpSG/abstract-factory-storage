package com.sgnatiuk;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class Movie {

    private String name;
    private int year;
    private Set<String> genres = new HashSet<>();

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

    public Collection<String> getGenres() {
        return genres;
    }

    public void addGenres(Collection<String> genres) {
        this.genres.addAll(genres);
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
