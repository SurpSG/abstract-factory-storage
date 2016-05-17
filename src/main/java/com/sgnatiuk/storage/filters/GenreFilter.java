package com.sgnatiuk.storage.filters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public abstract class GenreFilter implements IFilter {

    private List<String> genres = new ArrayList<>();

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "GenreFilter{" +
                "genres=" + genres +
                '}';
    }
}
