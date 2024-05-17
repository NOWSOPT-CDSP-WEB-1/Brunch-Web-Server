package com.brunch.server.book.service.dto;

import com.brunch.server.author.entity.Author;
import com.brunch.server.book.entity.Book;
import lombok.Builder;

@Builder
public record LikedBookResponse(
        Long id,
        String title,
        String authorName,
        String bookImage
) {
    public static LikedBookResponse from(Book book, Author author) {
        return LikedBookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(author.getName())
                .bookImage(book.getBookImage())
                .build();
    }
}
