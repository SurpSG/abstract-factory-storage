package com.sgnatiuk.storage.file.filters;

import com.sgnatiuk.Movie;
import com.sgnatiuk.storage.filters.IFilter;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public interface FileStorageFilter extends IFilter {

    boolean filterMovieFromFile(Movie movie);
}
