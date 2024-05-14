package com.brunch.server.posting.dto.response;

import lombok.Builder;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record ViewedPostingResponse(
        PostingResponse recentPostings,
        PostingResponse likePostings
) {

    public static ViewedPostingResponse of(PostingResponse recentPostings, PostingResponse likePostings) {
        return ViewedPostingResponse.builder()
                .recentPostings(recentPostings)
                .likePostings(likePostings)
                .build();
    }
}
