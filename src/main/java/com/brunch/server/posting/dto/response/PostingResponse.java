package com.brunch.server.posting.dto.response;

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

    public static PostingResponse of(String title, String content, String authorName, String imageUrl) {
        return PostingResponse.builder()
                .title(title)
                .content(content)
                .authorName(authorName)
                .imageUrl(imageUrl)
                .build();
    }
}
