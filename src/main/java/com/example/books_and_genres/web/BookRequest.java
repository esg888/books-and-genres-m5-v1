package com.example.books_and_genres.web;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @NotNull(message = "ID  должно быть указано")
    @Positive(message = "ID должно быть больше 0!")
    private Integer genreId;

    @NotBlank(message = "Заполните автора!")
    @Size(min = 1, max = 333, message = "имя автора не может быть меньше {min} и больше {max}!")
    private String author;

    @NotBlank(message = "Заполните название!")
    @Size(min = 2, max = 333, message = "название не может быть меньше {min} и больше {max}!")
    private String title;
}
