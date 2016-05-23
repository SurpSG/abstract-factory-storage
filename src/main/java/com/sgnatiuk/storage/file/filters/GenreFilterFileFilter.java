package com.sgnatiuk.storage.file.filters;

import com.sgnatiuk.Movie;
import com.sgnatiuk.storage.filters.GenreFilter;

import java.util.Collection;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class GenreFilterFileFilter extends GenreFilter implements FileStorageFilter {

    @Override
    public boolean filterMovieFromFile(Movie movie) {
        Collection<String> movieGenres = movie.getGenres();
        for (String genre : getGenres()) {
            if(movieGenres.contains(genre)){
                return true;
            }
        }
        return false;
    }
}
