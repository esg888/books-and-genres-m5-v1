package com.example.books_and_genres.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "title")
    private  String title;

    @Column(name = "author")
    private  String author;


    @ManyToOne
    @JoinColumn(name ="genre_id" )
    @ToString.Exclude
    @JsonIgnore
    private Genre genre;
}
