package com.example.books_and_genres.mapper;
import com.example.books_and_genres.entity.Book;
import com.example.books_and_genres.web.BookListResponse;
import com.example.books_and_genres.web.BookRequest;
import com.example.books_and_genres.web.BookResponse;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@DecoratedWith(BookMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    Book requestToBook(BookRequest bookRequest);

    @Mapping(source = "bookId", target = "id")
    Book requestToBook(Integer bookId, BookRequest bookRequest);

    BookResponse bookToResponse (Book book);

    List<BookResponse> bookListResponseList (List<Book> books);

    default BookListResponse bookListToBookListResponse (List<Book> books){
        BookListResponse responseList = new BookListResponse();
        responseList.setBooks(bookListResponseList(books));
        return responseList;
    }

}
