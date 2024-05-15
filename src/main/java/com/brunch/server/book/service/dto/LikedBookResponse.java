package com.brunch.server.book.service.dto;

public record LikedBookResponse(
        Long id,
        String title,
        String authorName,
        String bookImage
) {
}
