package com.brunch.server.book.service.dto;

import com.brunch.server.author.entity.Author;
import com.brunch.server.book.entity.Book;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record RecentBookResponse(
        Long id,
        String title,
        String authorName,
        String bookImage,
        String description,
        int episode,
        int requiredTime,
        int progress,
        LocalDateTime lastViewed
) {
    public static RecentBookResponse from(Book book, Author author) {
        return RecentBookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(author.getName())
                .bookImage(book.getBookImage())
                .description(book.getDescription())
                .episode(book.getEpisode())
                .requiredTime(book.getRequiredTime())
                .progress(book.getProgress())
                .lastViewed(book.getLastViewed())
                .build();
    }
}
