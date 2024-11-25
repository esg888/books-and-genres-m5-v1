package com.example.books_and_genres.mapper;
import com.example.books_and_genres.entity.Genre;
import com.example.books_and_genres.web.GenreListResponse;
import com.example.books_and_genres.web.GenreRequest;
import com.example.books_and_genres.web.GenreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.List;
import java.util.stream.Collectors;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {BookMapper.class})
public interface GenreMapper {
    Genre requestToGenre(GenreRequest request);

    @Mapping(source = "genreId", target = "id")
    Genre requestToGenre(Integer genreId, GenreRequest request);

    GenreResponse genreToResponse(Genre genre);

    default GenreListResponse genreListResponseList(List<Genre> genres) {
        GenreListResponse response = new GenreListResponse();
        response.setGenres(genres.stream().map(this::genreToResponse).collect(Collectors.toList()));
        return response;
    }

}
