package com.brunch.server.posting.dto.response;

import com.brunch.server.author.entity.Author;
import com.brunch.server.posting.entity.Posting;
import lombok.Builder;
import lombok.NonNull;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record PostingResponse(
        @NonNull String title,
        @NonNull String content,
        @NonNull String authorName,
        @NonNull String imageUrl
) {

    public static PostingResponse of(Posting posting, Author author) {
        return PostingResponse.builder()
                .title(posting.getTitle())
                .content(posting.getContent())
                .authorName(author.getName())
                .imageUrl(posting.getImageUrl())
                .build();
    }
}
