package com.example.books_and_genres.repo;

import com.example.books_and_genres.entity.Book;
import com.example.books_and_genres.entity.Genre;

import java.util.List;

public interface GenreRepo {

    List<Genre> findAll();

    Genre findById (Integer id);

    Genre save (Genre genre);

    Genre update (Genre genre);

    void delete (Integer id);
}
