package com.example.books_and_genres.web;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class BookListResponse {

    private List <BookResponse> books= new ArrayList<>();
    
}
