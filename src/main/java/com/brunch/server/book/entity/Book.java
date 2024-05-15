package com.brunch.server.book.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "author_id")
    private long authorId;

    private String title;
    private int episode;
    private int requiredTime;
    private String recommendation;
    private String description;
    private String bookImage;
    private String bannerImage;
    private int progress;
    private int likeCount;
    private String tag;

    @Column(name = "last_viewed")
    private LocalDateTime lastViewed;

}
