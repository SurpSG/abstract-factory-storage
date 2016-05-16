package com.sgnatiuk.storage.file;

import com.sgnatiuk.storage.IStorage;
import com.sgnatiuk.Movie;
import com.sgnatiuk.storage.file.filters.FileStorageFilter;
import com.sgnatiuk.storage.file.filters.FiltersFactoryFileStorage;
import com.sgnatiuk.storage.filters.FiltersContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class FileStorage implements IStorage<FileStorageFilter> {

    private List<Movie> movies = new ArrayList<>();

    @Override
    public void insertMovie(Movie movie) {
        movies.add(movie);
    }

    @Override
    public List<Movie> getMovieByFilter(FiltersContainer<FileStorageFilter> filters) {
        return movies.stream()
                .filter(movie -> movieCorrespondsToFilters(movie, filters))
                .collect(Collectors.toList());
    }

    private boolean movieCorrespondsToFilters(Movie movie, FiltersContainer<FileStorageFilter> filters){
        for (FileStorageFilter filterStorage2 : filters.getFilters()) {
            if(!filterStorage2.filterMovieFromFile(movie)){
                return false;
            }
        }
        return true;
    }

    @Override
    public FiltersFactoryFileStorage getFiltersFactory() {
        return new FiltersFactoryFileStorage();
    }
}
