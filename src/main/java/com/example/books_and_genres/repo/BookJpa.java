package com.example.books_and_genres.repo;

import com.example.books_and_genres.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJpa extends JpaRepository<Book, Integer> {

//    List<Book> findBooksByTitleContaining(String bookTitle);
// List<Book> findBooksByAuthorContaining(String author);
List <Book> findBooksByGenre_NameContaining(String genreName);

    Book findDistinctFirstByAuthorContainingAndTitleContaining(
            String author, String title);


}
