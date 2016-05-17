package com.sgnatiuk.storage.file.filters;

import com.sgnatiuk.storage.filters.FiltersAbstractFactory;
import com.sgnatiuk.storage.filters.FiltersContainer;
import com.sgnatiuk.storage.filters.GenreFilter;
import com.sgnatiuk.storage.filters.YearFilter;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class FiltersFactoryFileStorage extends FiltersAbstractFactory<FileStorageFilter> {
    @Override
    public GenreFilter buildGenreFilter() {
        return new GenreFilterFileFilter();
    }

    @Override
    public YearFilter buildYearFilter() {
        return new YearFilterFileStorage();
    }

    @Override
    public FiltersContainer<FileStorageFilter> buildFiltersContainer() {
        return new FiltersContainer<FileStorageFilter>(){};//anonymous subclass allows to use protected constructor
    }
}
