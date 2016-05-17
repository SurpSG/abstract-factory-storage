package com.sgnatiuk.utils;

import com.sgnatiuk.Movie;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by sgnatiuk on 5/17/16.
 */
public class JsonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void serializeMoviesToFile(String path, Collection<Movie> movies) throws IOException {
        FileUtils.writeToFile(new File(path), Arrays.asList(mapper.writeValueAsString(movies)));
    }

    public static Collection<Movie> deserializeMoviesFromFile(String filePath) throws IOException {
        return deserializeMoviesFromFile(new File(filePath));
    }

    public static Collection<Movie> deserializeMoviesFromFile(File file) throws IOException {
        if(file.exists()){
            return mapper.readValue(new FileInputStream(file),
                    mapper.getTypeFactory().constructCollectionType(List.class, Movie.class));
        }
        return new ArrayList<>();
    }
}
