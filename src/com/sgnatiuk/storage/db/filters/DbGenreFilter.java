package com.sgnatiuk.storage.db.filters;

import com.sgnatiuk.storage.filters.GenreFilter;

import java.util.StringJoiner;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class DbGenreFilter extends GenreFilter implements DbFilter {

    @Override
    public String getQueryCondition() {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (String genre : getGenres()) {
            stringJoiner.add(genre);
        }
        return String.format("genre in(%s)",stringJoiner);
    }
}
