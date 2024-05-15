package com.brunch.server.book.entity;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private Long author_id;

    private String title;
    private int episode;
    private int requiredTime;
    private String recommendation;
    private String description;
    private String bookImage;
    private String bannerImage;
    private int progress;
    private int likes;
    private String tagA;
    private String tagB;
    private String tagC;

}
