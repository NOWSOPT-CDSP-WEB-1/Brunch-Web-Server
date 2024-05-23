package com.brunch.server.book.service.dto;

import com.brunch.server.author.entity.Author;
import com.brunch.server.book.entity.Book;
import lombok.Builder;

@Builder
public record BannerResponse(
        long id,
        String title,
        String authorName,
        String bannerImage,
        int episode,
        int requiredTime,
        String bookDescription,
        String recommendation
) {
    public static BannerResponse from(Book book, Author author) {
        return BannerResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(author.getName())
                .bannerImage(book.getBannerImage())
                .episode(book.getEpisode())
                .requiredTime(book.getRequiredTime())
                .bookDescription(book.getDescription())
                .recommendation(book.getRecommendation())
                .build();
    }
}
