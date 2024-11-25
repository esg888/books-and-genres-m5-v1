package com.example.books_and_genres.web;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreRequest {

    @NotBlank(message = "Категория(жарн) должна быть заполнено!")
    @Size(min = 3, max = 30, message = "Категория(жарн) не может быть меньше {min} и больше {max}!")
    private String name;
}
