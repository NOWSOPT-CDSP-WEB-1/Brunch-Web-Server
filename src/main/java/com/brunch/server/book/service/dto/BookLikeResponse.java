package com.brunch.server.book.service.dto;

import com.brunch.server.book.entity.Book;
import lombok.Builder;

@Builder
public record BookLikeResponse (
        long bookId,
        int likeCount
) {
    public static BookLikeResponse from(Book book) {
        return BookLikeResponse.builder()
                .bookId(book.getId())
                .likeCount(book.getLikeCount())
                .build();
    }
}
