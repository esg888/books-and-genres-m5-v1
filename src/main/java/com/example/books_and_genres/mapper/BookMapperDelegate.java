package com.example.books_and_genres.mapper;
import com.example.books_and_genres.entity.Book;
import com.example.books_and_genres.service.GenreService;
import com.example.books_and_genres.web.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BookMapperDelegate implements BookMapper {

    @Autowired
    GenreService genreService;

    @Override
    public Book requestToBook(Integer bookId, BookRequest bookRequest){
Book book = requestToBook(bookRequest);
book.setId(bookId);
return book;
    }

    @Override
    public Book requestToBook(BookRequest bookRequest){
        Book book = new Book();
     book.setGenre(genreService.findById(bookRequest.getGenreId()));
     book.setAuthor(bookRequest.getAuthor());
     book.setTitle(bookRequest.getTitle());
        return book;
    }
}
