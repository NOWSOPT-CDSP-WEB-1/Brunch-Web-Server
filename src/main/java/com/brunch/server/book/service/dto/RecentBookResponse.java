package com.brunch.server.book.service.dto;

import java.time.LocalDateTime;

public record RecentBookResponse(
        Long id,
        String title,
        String authorName,
        String bookImage,
        String description,
        int episode,
        int requiredTime,
        int progress,
        LocalDateTime lastViewd
) {
}
