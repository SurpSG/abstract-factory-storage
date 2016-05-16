package com.sgnatiuk.storage;

import com.sgnatiuk.Movie;
import com.sgnatiuk.storage.filters.FiltersContainer;
import com.sgnatiuk.storage.filters.FiltersAbstractFactory;
import com.sgnatiuk.storage.filters.IFilter;

import java.util.Collection;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public interface IStorage<P extends IFilter> {

    void insertMovie(Movie movie);

    Collection<Movie> getMovieByFilter(FiltersContainer<P> filter);

    FiltersAbstractFactory<P> getFiltersFactory();
}
