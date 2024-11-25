package com.example.books_and_genres.controller;

import com.example.books_and_genres.entity.Book;
import com.example.books_and_genres.entity.BookFilter;
import com.example.books_and_genres.mapper.BookMapper;
import com.example.books_and_genres.service.BookService;
import com.example.books_and_genres.web.BookListResponse;
import com.example.books_and_genres.web.BookRequest;
import com.example.books_and_genres.web.BookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<BookListResponse> findAll() {
        return ResponseEntity.ok(bookMapper
                .bookListToBookListResponse(bookService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookMapper
                .bookToResponse(bookService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest request) {
        Book book = bookService.create(bookMapper.requestToBook(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(bookMapper.bookToResponse(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> edit(@PathVariable("id") Integer bookId,
                                             @RequestBody BookRequest request) {
        Book eBook = bookService.update(bookMapper.requestToBook(bookId, request));

        return ResponseEntity.ok(bookMapper.bookToResponse(eBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<BookResponse> findByAuthorAndTitle(BookFilter filter){
        return ResponseEntity.ok(bookMapper.bookToResponse(bookService.findByAuthorAndTitle(filter)));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<BookListResponse> findByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(bookMapper
                .bookListToBookListResponse(bookService.findByGenre(genre)));
    }
}
