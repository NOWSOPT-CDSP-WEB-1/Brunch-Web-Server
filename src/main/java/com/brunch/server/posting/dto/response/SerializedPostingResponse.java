package com.brunch.server.posting.dto.response;

import com.brunch.server.author.entity.Author;
import com.brunch.server.book.entity.Book;
import com.brunch.server.posting.entity.Posting;
import lombok.Builder;
import lombok.NonNull;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record SerializedPostingResponse(
        @NonNull String bookTitle,
        @NonNull String postingTitle,
        @NonNull String authorName,
        @NonNull String imageUrl
) {

    public static SerializedPostingResponse of(Posting posting, Book book, Author author) {
        return SerializedPostingResponse.builder()
                .bookTitle(book.getTitle())
                .postingTitle(posting.getTitle())
                .authorName(author.getName())
                .imageUrl(posting.getImageUrl())
                .build();
    }
}
