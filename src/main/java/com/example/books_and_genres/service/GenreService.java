package com.example.books_and_genres.service;

import com.example.books_and_genres.entity.Genre;
import com.example.books_and_genres.err.EntityNotFoundException;
import com.example.books_and_genres.repo.GenreJpa;
import com.example.books_and_genres.repo.GenreRepo;
import com.example.books_and_genres.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class GenreService implements GenreRepo {

    @Autowired
    private GenreJpa genreJpa;

    @Override
    public List<Genre> findAll() {
        return genreJpa.findAll();
    }

    @Override
    public Genre findById(Integer id) {
        return genreJpa.findById(id).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("ID жанра {0} не найден", id)));
    }

    @Override
    public Genre save(Genre genre) {
        return genreJpa.save(genre);
    }

    @Override
    public Genre update(Genre genre) {
        Genre eGenre = findById(genre.getId());
        BeanUtils.copyNonNullProperties(genre, eGenre);
        return genreJpa.save(eGenre);
    }

    @Override
    public void delete(Integer id) {
genreJpa.deleteById(id);
    }
}
