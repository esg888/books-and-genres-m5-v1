package com.example.books_and_genres.service;

import com.example.books_and_genres.configuration.AppCacheProperties;
import com.example.books_and_genres.entity.Book;
import com.example.books_and_genres.entity.BookFilter;
import com.example.books_and_genres.err.EntityNotFoundException;
import com.example.books_and_genres.repo.BookJpa;
import com.example.books_and_genres.repo.BookRepo;
import com.example.books_and_genres.util.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheManager = "redisCacheManager")
public class BookService implements BookRepo {
    @Autowired
    private BookJpa bookJpa;

    @Override
    @Cacheable(AppCacheProperties.CacheNames.BOOKS)
    public List<Book> findAll() {
        return bookJpa.findAll();
    }

    @Cacheable(cacheNames=AppCacheProperties.CacheNames.BOOK_BY_ID, key = "#id")
    @Override
    public Book findById(Integer id) {
        return bookJpa.findById(id).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("ID {0} не найден", id)));
    }


    @Override
    @Cacheable(cacheNames=AppCacheProperties.CacheNames.BOOK_BY_AUTHOR_AND_TITLE, key = "{#filter.author, #filter.title}")
    public Book findByAuthorAndTitle(BookFilter filter) {
        String author = filter.getAuthor();
        String title = filter.getTitle();
        Book book = bookJpa.findDistinctFirstByAuthorContainingAndTitleContaining(author, title);
        return book;
    }


        @Override
        @Cacheable(cacheNames=AppCacheProperties.CacheNames.BOOK_BY_GENRE, key = "#genre")
    public List<Book> findByGenre(String genre) {
        return bookJpa.findBooksByGenre_NameContaining(genre);
    }

    @Override
    @CacheEvict(value = "books", allEntries = true)
    public Book create(Book book) {
        return bookJpa.save(book);
    }

    @Override
    @CacheEvict (cacheNames= AppCacheProperties.CacheNames.BOOK_BY_ID, key = "#id", beforeInvocation = true)
    public Book update(Book book) {
        Book eBook = findById(book.getId());
        BeanUtils.copyNonNullProperties(book, eBook);
        return bookJpa.save(eBook);
    }

    @Override
    @CacheEvict(cacheNames= AppCacheProperties.CacheNames.BOOK_BY_ID, key = "#id", beforeInvocation = true)
    public void delete(Integer id) {
bookJpa.deleteById(id);
    }
}
