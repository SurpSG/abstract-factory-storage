package com.sgnatiuk.storage.db.filters;

import com.sgnatiuk.storage.filters.YearFilter;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class DbYearFilter extends YearFilter implements DbFilter {
    @Override
    public String getQueryCondition() {
        return String.format("year>=%s and year<=%s",getLowValue(), getHighValue());
    }
}
