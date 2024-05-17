package com.brunch.server.posting.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posting_id")
    private Long id;

    private Long bookId;

    private Integer bookIndex;

    private Long authorId;

    private String imageUrl;

    private String title;

    private String content;

    private String day;

    private int requiredTime;

    private int commentCount;

    private int likeCount;

    private Integer isViewed;

    private Integer isLiked;
}
