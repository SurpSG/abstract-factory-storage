package com.sgnatiuk.storage.db.filters;

import com.sgnatiuk.storage.filters.IFilter;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public interface DbFilter extends IFilter {

    String getQueryCondition();
}
