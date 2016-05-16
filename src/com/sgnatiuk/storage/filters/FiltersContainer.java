package com.sgnatiuk.storage.filters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class FiltersContainer<T extends IFilter> {

    private List<T> filters = new ArrayList<>();

    public FiltersContainer<T> addFilter(T filter){
        filters.add(filter);
        return this;
    }

    public <P extends T> P  getFilterByClass(Class<P> filterClass){
        for (T filter : filters) {
            if(filterClass.isInstance(filter)){
                return (P) filter;
            }
        }
        return null;
    }

    public List<T> getFilters(){
        return filters;
    }
}
