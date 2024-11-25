package com.example.books_and_genres.web;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreListResponse {
    private List<GenreResponse> genres = new ArrayList<>();
}
