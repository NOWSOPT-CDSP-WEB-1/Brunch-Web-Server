package com.brunch.server.book.service.dto;

import com.brunch.server.author.entity.Author;
import com.brunch.server.book.entity.Book;
import lombok.Builder;

@Builder
public record BookOverviewResponse (
        long id,
        String title,
        String bookImage,
        String authorName,
        String authorDescription,
        String job,
        int subscriber,
        int episode,
        int requiredTime,
        int likeCount,
        String recommendation,
        String bookDescription,
        String tag
) {
    public static BookOverviewResponse from (Book book, Author author) {
        return BookOverviewResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .bookImage(book.getBookImage())
                .authorName(author.getName())
                .authorDescription(author.getDescription())
                .job(author.getJob())
                .subscriber(author.getSubscriber())
                .episode(book.getEpisode())
                .requiredTime(book.getRequiredTime())
                .likeCount(book.getLikeCount())
                .recommendation(book.getRecommendation())
                .bookDescription(book.getDescription())
                .tag(book.getTag())
                .build();
    }

}
