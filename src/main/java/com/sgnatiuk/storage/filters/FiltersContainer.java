package com.sgnatiuk.storage.filters;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class FiltersContainer<T extends IFilter> {

    private Set<T> filters = new LinkedHashSet<>();

    protected FiltersContainer(){}//FiltersContainer allowed to build only by factories

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

    public Collection<T> getFilters(){
        return filters;
    }

    @Override
    public String toString() {
        return "FiltersContainer{" +
                "filters=" + filters +
                '}';
    }
}
