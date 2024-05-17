package com.brunch.server.book.service.dto;

import com.brunch.server.book.entity.Book;
import com.brunch.server.posting.entity.Posting;
import lombok.Builder;

@Builder
public record BookChapterResponse(
        long id,
        long bookId,
        String imageUrl,
        String title,
        String content,
        int requiredTime,
        int commentCount
) {
    public static BookChapterResponse from (Book book, Posting posting) {
        return BookChapterResponse.builder()
                .id(posting.getId())
                .bookId(book.getId())
                .imageUrl(posting.getImageUrl())
                .title(posting.getTitle())
                .content(posting.getContent())
                .requiredTime(posting.getRequiredTime())
                .commentCount(posting.getCommentCount())
                .build();
    }
}
