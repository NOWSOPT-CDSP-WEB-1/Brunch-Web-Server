package com.brunch.server.author.entity;

import com.brunch.server.book.entity.Book;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    @Column(name = "author_name")
    private String name;

    @Column(name = "author_description")
    private String description;

    private String job;
    private Long subscriber;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
