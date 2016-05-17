package com.sgnatiuk.storage.db;

import com.sgnatiuk.Movie;
import com.sgnatiuk.storage.IStorage;
import com.sgnatiuk.storage.db.filters.DbFilter;
import com.sgnatiuk.storage.db.filters.DbFiltersFactory;
import com.sgnatiuk.storage.filters.FiltersContainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class DbStorage implements IStorage<DbFilter> {

    private List<Movie> moviesSet = new ArrayList<>();


    @Override
    public void insertMovie(Movie movie) {
        moviesSet.add(movie);
    }

    @Override
    public Collection<Movie> getMovieByFilter(FiltersContainer<DbFilter> filter) {

        String selectQuery = buildSelectQuery(filter);

        System.out.println("[DEBUG] select by query: "+selectQuery);

        return moviesSet;
    }

    private String buildSelectQuery(FiltersContainer<DbFilter> filters){
        StringBuilder stringBuilder = new StringBuilder("select * from movies where ");
        stringBuilder.append(buildConditionPart(filters));
        return stringBuilder.toString();
    }

    private String buildConditionPart(FiltersContainer<DbFilter> filters){
        StringJoiner stringJoiner = new StringJoiner(" AND ");
        for (DbFilter dbFilter : filters.getFilters()) {
            stringJoiner.add(dbFilter.getQueryCondition());
        }
        return stringJoiner.toString();
    }

    @Override
    public DbFiltersFactory getFiltersFactory() {
        return new DbFiltersFactory();
    }
}
