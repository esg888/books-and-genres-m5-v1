package com.example.books_and_genres.repo;

import com.example.books_and_genres.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreJpa extends JpaRepository<Genre, Integer> {
}
