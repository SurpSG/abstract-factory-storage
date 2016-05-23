package com.sgnatiuk;

import com.sgnatiuk.storage.InjectedStorageContainer;
import com.sgnatiuk.storage.filters.FiltersAbstractFactory;
import com.sgnatiuk.storage.filters.FiltersContainer;
import com.sgnatiuk.storage.filters.GenreFilter;
import com.sgnatiuk.storage.filters.YearFilter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        InjectedStorageContainer storageContainer = context.getBean(InjectedStorageContainer.class);

        Movie movie = new Movie();
        movie.setName("film name1");
        movie.setYear(2000);
        movie.addGenres(Arrays.asList("genre1", "genre2"));
        System.out.println("created movie: " + movie);

        storageContainer.insertMovie(movie);
        System.out.println("movie saved");


        FiltersAbstractFactory filtersFactory = storageContainer.getFiltersFactory();

        YearFilter yearFilter = filtersFactory.buildYearFilter();
        yearFilter.setLowValue(1999);
        yearFilter.setUpValue(2001);

        GenreFilter genreFilter = filtersFactory.buildGenreFilter();
        genreFilter.addGenres(Arrays.asList("genre2", "genre1"));

        FiltersContainer filterContainer = filtersFactory.buildFiltersContainer()
                .addFilter(genreFilter)
                .addFilter(yearFilter);

        System.out.println("Get movies by filters: "+filterContainer);
        storageContainer.getMovieByFilter(filterContainer)
                .forEach(System.out::println);
    }
}
