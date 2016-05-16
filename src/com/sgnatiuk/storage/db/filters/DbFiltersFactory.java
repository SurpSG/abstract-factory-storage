package com.sgnatiuk.storage.db.filters;

import com.sgnatiuk.storage.filters.FiltersAbstractFactory;
import com.sgnatiuk.storage.filters.FiltersContainer;
import com.sgnatiuk.storage.filters.GenreFilter;
import com.sgnatiuk.storage.filters.YearFilter;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class DbFiltersFactory extends FiltersAbstractFactory<DbFilter> {
    @Override
    public GenreFilter buildGenreFilter() {
        return new DbGenreFilter();
    }

    @Override
    public YearFilter buildYearFilter() {
        return new DbYearFilter();
    }

    @Override
    public FiltersContainer<DbFilter> buildFiltersContainer() {
        return new FiltersContainer<>();
    }
}
