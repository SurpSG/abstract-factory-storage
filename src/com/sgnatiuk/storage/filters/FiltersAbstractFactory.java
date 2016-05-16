package com.sgnatiuk.storage.filters;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public abstract class FiltersAbstractFactory<T extends IFilter> {

    public abstract GenreFilter buildGenreFilter();
    public abstract YearFilter buildYearFilter();

    public abstract FiltersContainer<T> buildFiltersContainer();
}