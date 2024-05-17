package com.brunch.server.posting.dto.response;

import lombok.Builder;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record ViewedPostingResponse(
        List<PostingResponse> recentPostings,
        List<PostingResponse> likePostings
) {

    public static ViewedPostingResponse of(List<PostingResponse> recentPostings, List<PostingResponse> likePostings) {
        return ViewedPostingResponse.builder()
                .recentPostings(recentPostings)
                .likePostings(likePostings)
                .build();
    }
}
