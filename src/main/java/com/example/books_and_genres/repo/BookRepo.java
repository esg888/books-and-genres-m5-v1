package com.example.books_and_genres.repo;
import com.example.books_and_genres.entity.Book;
import com.example.books_and_genres.entity.BookFilter;

import java.util.List;
public interface BookRepo  {

    List<Book> findAll();

    Book findById (Integer id);

    Book create(Book book);

    Book update (Book book);

void delete (Integer id);

Book findByAuthorAndTitle (BookFilter filter);

    List<Book> findByGenre(String genreName);

}
