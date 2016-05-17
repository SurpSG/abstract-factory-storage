package com.sgnatiuk.storage.file.filters;

import com.sgnatiuk.Movie;
import com.sgnatiuk.storage.filters.YearFilter;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class YearFilterFileStorage extends YearFilter implements FileStorageFilter {

    @Override
    public boolean filterMovieFromFile(Movie movie) {
        return movie.getYear() >= getLowValue() && movie.getYear() <= getHighValue();
    }
}
