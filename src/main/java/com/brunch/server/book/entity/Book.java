package com.brunch.server.book.entity;

import com.brunch.server.author.entity.Author;
import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    private String title;

    private int bookEpisode;

    private int bookRuntime;

    private String bookRecommendation;

    private String bookDescription;

    private String bookImage;

    private int progress;

}
