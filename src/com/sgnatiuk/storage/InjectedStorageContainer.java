package com.sgnatiuk.storage;

import com.sgnatiuk.Movie;
import com.sgnatiuk.storage.file.FileStorage;
import com.sgnatiuk.storage.filters.FiltersContainer;
import com.sgnatiuk.storage.db.DbStorage;
import com.sgnatiuk.storage.filters.FiltersAbstractFactory;

import java.util.Collection;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class InjectedStorageContainer {

    //it can be injected
//    public IStorage<?> storage = new FileStorage();
    public IStorage<?> storage = new DbStorage();

    public void insertMovie(Movie movie){
        storage.insertMovie(movie);
    }

    public Collection<Movie> getMovieByFilter(FiltersContainer filter){
        return storage.getMovieByFilter(filter);
    }

    public FiltersAbstractFactory<?> getFiltersFactory(){
        return storage.getFiltersFactory();
    }
}
