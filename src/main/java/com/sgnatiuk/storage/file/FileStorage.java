package com.sgnatiuk.storage.file;

import com.sgnatiuk.Movie;
import com.sgnatiuk.storage.IStorage;
import com.sgnatiuk.storage.file.filters.FileStorageFilter;
import com.sgnatiuk.storage.file.filters.FiltersFactoryFileStorage;
import com.sgnatiuk.storage.filters.FiltersContainer;
import com.sgnatiuk.utils.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class FileStorage implements IStorage<FileStorageFilter> {

    private static final String MOVIES_FILE_PATH = "movies.json";

    @Override
    public void insertMovie(Movie movie) {
        Collection<Movie> movies = readMoviesFromFile();
        movies.add(movie);
        saveMoviesToFile(movies);
    }

    private Collection<Movie> readMoviesFromFile(){
        try {
            return JsonUtils.deserializeMoviesFromFile(MOVIES_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void saveMoviesToFile(Collection<Movie> movies){
        try {
            JsonUtils.serializeMoviesToFile(MOVIES_FILE_PATH, movies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Movie> getMoviesByFilter(FiltersContainer<FileStorageFilter> filters) {
        return readMoviesFromFile().stream()
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
