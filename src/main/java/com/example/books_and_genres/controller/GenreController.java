package com.example.books_and_genres.controller;
import com.example.books_and_genres.entity.Genre;
import com.example.books_and_genres.mapper.GenreMapper;
import com.example.books_and_genres.service.GenreService;
import com.example.books_and_genres.web.GenreListRequest;
import com.example.books_and_genres.web.GenreListResponse;
import com.example.books_and_genres.web.GenreRequest;
import com.example.books_and_genres.web.GenreResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreMapper genreMapper;

    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<GenreListResponse> findAll (){
        List<Genre> genres = genreService.findAll();
        return ResponseEntity.ok(genreMapper.genreListResponseList(genres));
            }

    @GetMapping("/{id}")
    public  ResponseEntity <GenreResponse> findById(@PathVariable Integer id){
        return ResponseEntity.ok(genreMapper.genreToResponse(genreService.findById(id)));
    }

    @PostMapping
    public  ResponseEntity <GenreResponse> create (@RequestBody GenreRequest request){
        Genre genre = genreService.save(genreMapper.requestToGenre(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(genreMapper.genreToResponse(genre));
    }

    @PutMapping("/{id}")
    public  ResponseEntity <GenreResponse> update (@PathVariable("id") Integer genreId,
@RequestBody GenreRequest request){
        Genre genre = genreService.update(genreMapper.requestToGenre(genreId, request));
        return  ResponseEntity.ok(genreMapper.genreToResponse(genre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        genreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
