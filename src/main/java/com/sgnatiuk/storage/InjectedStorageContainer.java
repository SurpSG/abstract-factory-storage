package com.sgnatiuk.storage;

import com.sgnatiuk.Movie;
import com.sgnatiuk.storage.db.DbStorage;
import com.sgnatiuk.storage.filters.FiltersAbstractFactory;
import com.sgnatiuk.storage.filters.FiltersContainer;

import java.util.Collection;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class InjectedStorageContainer {

    private IStorage<?> storage = new DbStorage();

    public void insertMovie(Movie movie){
        storage.insertMovie(movie);
    }

    public Collection<Movie> getMovieByFilter(FiltersContainer filter){
        return storage.getMoviesByFilter(filter);
    }

    public FiltersAbstractFactory<?> getFiltersFactory(){
        return storage.getFiltersFactory();
    }

    public void setStorage(IStorage<?> storage){
        this.storage=storage;
    }

    @Override
    public String toString() {
        return "InjectedStorageContainer{" +
                "storage=" + storage +
                '}';
    }
}
