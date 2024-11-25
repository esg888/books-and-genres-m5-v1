package com.example.books_and_genres.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookFilter {

    private String author;
    private String title;

}
