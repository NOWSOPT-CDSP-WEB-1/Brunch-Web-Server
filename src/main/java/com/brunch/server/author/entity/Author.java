package com.brunch.server.author.entity;

import jakarta.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    private String name;
    private String description;
    private String job;
    private int subscriber;
}
