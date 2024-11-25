package com.example.books_and_genres.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "app.cache")
public class AppCacheProperties {

    private final List<String> cacheNames = new ArrayList<>();

    private final Map<String, CacheProperties> caches = new HashMap<>();

    private final CacheType cacheType;

    @Data
    public static class CacheProperties{
        private Duration expiry = Duration.ZERO;
    }

    public interface CacheNames {
        String BOOKS = "books";
        String BOOK_BY_AUTHOR_AND_TITLE = "bookByAuthorAndTitle";
        String BOOK_BY_ID = "bookById";
        String BOOK_BY_GENRE = "booksByGenre";
    }

    public enum CacheType{
         REDIS
    }
}
