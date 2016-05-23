package com.sgnatiuk.storage.filters;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public abstract class GenreFilter implements IFilter {

    private Set<String> genres = new HashSet<>();

    public Collection<String> getGenres() {
        return genres;
    }

    public void addGenres(Collection<String> genres) {
        this.genres.addAll(genres);
    }

    public void removeGenre(String genre){
        genres.remove(genre);
    }

    @Override
    public String toString() {
        return "GenreFilter{" +
                "genres=" + genres +
                '}';
    }
}
