package com.example.books_and_genres.web;
import com.example.books_and_genres.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreResponse {

    private int id;
    private String name;
    private List<Book> books = new ArrayList<>();


}
